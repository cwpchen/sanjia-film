package com.sj.user.service.ipml;

import org.eclipse.jdt.internal.compiler.env.ISourceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.common.pojo.User;
import com.sj.common.utils.MD5Util;
import com.sj.user.mapper.UserMapper;

import redis.clients.jedis.JedisCluster;
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	/**
	 * 用户注册前进行用户名是否已存在的验证
	 * @param userName
	 * @return 返回1 表示已存在 不能进行注册
	 * 		        返回0 表示不存在 可以进行注册
	 */
	public Integer checkUserName(String userName) {
		try{
			Integer result = userMapper.checkExists(userName);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return 1;
		}
		
	}
	/**
	 * 用户注册
	 * 请求方式	POST 
	 * @param user
	 * @return 返回1 表示已存入数据库 注册成功
	 * 		        返回0  表示注册失败
	 */
	public Integer userSave(User user) {
		try{
			String password = MD5Util.md5(user.getPass());
			user.setPass(password);
			return userMapper.doRegist(user);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	@Autowired
	private JedisCluster cluster;
	public String userLogin(User user) {
		User exiUser = userMapper.login(user);
		if(exiUser!=null){ //查询到对应用户
			String exiTicket = cluster.get("SJ_TICKET");
			if(exiTicket != null  && (! ("".equals(exiTicket)))){ //说明cluster中已经存在了ticket
				cluster.del(exiTicket);
			}
			String status = "SJ_TICKET"+user.getName()+System.currentTimeMillis();
			String ticket=MD5Util.md5(status);
			cluster.set("SJ_TICKET", ticket);
			return ticket;
		}else{  //没有查询到对应用户
			return "";
		}
		
	}

}
