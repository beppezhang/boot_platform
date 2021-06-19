package cn.moncocc.controller;

import cn.moncocc.security.JwtAuthenticatioToken;
import cn.moncocc.utils.SecurityUtils;
import cn.moncocc.vo.HttpResult;
import cn.moncocc.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录控制器
 * @author Louis
 * @date Nov 28, 2018
 */
@RestController
public class LoginController {

	@Resource
	private AuthenticationManager authenticationManager;

	/**
	 * 登录接口
	 */
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();
		
		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
				
		return HttpResult.ok(token);
	}

}
