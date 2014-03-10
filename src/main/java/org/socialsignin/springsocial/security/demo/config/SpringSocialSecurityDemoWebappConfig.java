package org.socialsignin.springsocial.security.demo.config;

import javax.annotation.PostConstruct;

import org.socialsignin.springsocial.security.signup.SpringSocialSecurityConnectionSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jpa.JpaUsersConnectionRepository;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class SpringSocialSecurityDemoWebappConfig {
	
	@Autowired(required=false)
	private SpringSocialSecurityConnectionSignUp springSocialSecurityConnnectionSignUp;

	@Autowired
	private JpaUsersConnectionRepository usersConnectionRepository;
	
	@Bean
	public RequestMappingHandlerMapping handlerMapping() throws Exception {

		 RequestMappingHandlerMapping mapping = new  RequestMappingHandlerMapping();
		return mapping;
	}
	
	@Bean
	public RequestMappingHandlerAdapter handlerAdapter() throws Exception {

		RequestMappingHandlerAdapter mapping = new RequestMappingHandlerAdapter();

		return mapping;

	}
	
	@PostConstruct
	// Registers a mechanism for implicit sign up if user id available from provider
	// Remove if explicit user name selection is required
	public void registerConnectionSignUp()
	{
		if (springSocialSecurityConnnectionSignUp != null)
		{
			usersConnectionRepository.setConnectionSignUp(springSocialSecurityConnnectionSignUp);
		}
	}

}
