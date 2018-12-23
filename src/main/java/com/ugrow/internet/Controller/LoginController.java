package com.ugrow.internet.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugrow.internet.Entity.BackOperator;
import com.ugrow.internet.Service.BackOperatorService;
import com.ugrow.internet.Utils.jsonInfo;

@Controller
public class LoginController {
    @Autowired
    BackOperatorService backOperatorService;

    @RequestMapping(value = "/login")
    public String login() {
            return "back/login";
    }

    @RequestMapping(value = "/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("operator");
        return "back/login";
    }

    @RequestMapping(value = "/userLogin")
    public @ResponseBody jsonInfo userLogin(BackOperator operator, HttpSession session) {
        BackOperator sOperator;
        sOperator= backOperatorService.logIn(operator);
            if (sOperator!=null) {
            session.setAttribute("operator",sOperator);
            session.setMaxInactiveInterval(3600);
           return new jsonInfo(1,"登录成功");
        } else {
            return  new jsonInfo(-1,"用户名或密码错误");
        }
    }
    
//    进入修改密码界面
    @RequestMapping("editPass")
    public String editPass() {
    	return "back/operator/updatePass";
    }
    
    @RequestMapping("updatePass")
    public @ResponseBody jsonInfo updatePass(String oldpass,String pass1,String pass2,HttpSession session) {
    	BackOperator operator=(BackOperator) session.getAttribute("operator");
    	String pass=operator.getPass();
    	
    	if(pass1.equals(pass2)) {
    		if(pass.equals(oldpass)) {
    			BackOperator o=new BackOperator();
    			o.setId(operator.getId());
    			o.setPass(pass1);
    			if(backOperatorService.updatePass(o)>0) {
    				operator.setPass(pass1);
    				return new jsonInfo(1, "修改成功！");
    			}else {
    				return new jsonInfo(-2, "请重新操作！");
    			}
    			
    		}else {
    			return new jsonInfo(0, "原密码输入不正确！");
    		}
    	}else {
    		return new jsonInfo(-1, "两次密码不一致！");
    	}
    	
    }
    
}
