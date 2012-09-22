package org.socialsignin.springsocial.security.demo;

import org.socialsignin.springsocial.security.signup.AbstractSignUpController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The default implementation of SpringSocialSecurity provides a
 * SpringSocialSecuritySignUpController which works with instances of 
 * SpringSocialSecurityProfile on user signup
 * 
 * By providing this controller instead we enable custom local user details to be stored
 * and initialised on signup as User instances.
 * 
 * @author Michael Lavelle
 *
 */
@Controller
@RequestMapping("/signup")
public class UserSignUpController extends 
AbstractSignUpController<User, UserSignUpService, UserSpringSocialProfileFactory> {

	public UserSignUpController() {
		super();
	}

	
	
}
