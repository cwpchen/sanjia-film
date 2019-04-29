package com.sj.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sj.common.pojo.Favorite;
import com.sj.common.pojo.Purchase;
import com.sj.common.vo.SysResult;
import com.sj.web.service.StoreService;

@Controller
@RequestMapping("store/")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@RequestMapping(value="mystore",method=RequestMethod.GET)
	public String queryStore(HttpServletRequest request,
			Model model) {
		String username = (String)request.getAttribute("name");
		List<Purchase> purchases = storeService.queryStore(username);
		model.addAttribute("purchaseList", purchases);
		return "store";
	}
	
	@RequestMapping(value="delete/{favoriteId}",method=RequestMethod.GET)
	public String deleteStore(@PathVariable String favoriteId,
			HttpServletRequest request){
		String username = (String)request.getAttribute("name");
		Favorite favorite = new Favorite(username,favoriteId);
		String result = storeService.deleteStore(favorite);
		return "redirect:/store/mystore";
	}
	
}
