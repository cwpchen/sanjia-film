package com.sj.user.service.ipml;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.internal.compiler.env.ISourceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sj.common.pojo.ObjectUtil;
import com.sj.common.pojo.User;
import com.sj.common.utils.MD5Util;
import com.sj.common.vo.SysResult;
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
		//密码采用MD5加密
		String password = MD5Util.md5(user.getPass());
		user.setPass(password);
		User exiUser = userMapper.login(user);
		if(exiUser!=null){ //查询到对应用户
			//查询用户对应的登录信息
			String exitTicket = cluster.get(exiUser.getName());
//			String exiTicket = cluster.get("SJ_TICKET");
			if(StringUtils.isNotEmpty(exitTicket)){ //说明cluster中已经存在了ticket,已有人正在登录
				cluster.del(exitTicket);//删除登录信息
			}
			
			String key = "SJ_TICKET"+user.getName()+System.currentTimeMillis(); //用户本次登录信息 MD5加密			
			String jsondata;
			try {
				jsondata = ObjectUtil.mapper.writeValueAsString(exiUser);
				String ticket=MD5Util.md5(key);
				cluster.set(exiUser.getName(), ticket);
				cluster.set(ticket, jsondata);
				return ticket;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
			
		}else{  //没有查询到对应用户
			return "";
		}
		
	}
	public SysResult isExiTicket(String ticket) {
		//判断用户登录信息是否超时
		Long lastTime = cluster.ttl(ticket);
		if(lastTime<5*60 && lastTime>0){
			cluster.expire(ticket, (int)(lastTime+10*60));
		}
		String jsondata = cluster.get(ticket);
		return new SysResult(200, "sucess", jsondata);
	}

}
