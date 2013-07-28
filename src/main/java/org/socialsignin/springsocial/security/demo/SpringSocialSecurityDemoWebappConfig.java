package org.socialsignin.springsocial.security.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.UserIdSource;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.extension.config.annotation.EnableHibernateJpaConnectionRepository;
import org.springframework.social.facebook.config.annotation.EnableFacebook;
import org.springframework.social.twitter.config.annotation.EnableTwitter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
//Swap in the below annotation instead of no-arg version if implicit sign up is required
//@EnableHibernateJpaConnectionRepository(connectionSignUpRef="springSocialSecurityConnectionSignUp")
@EnableHibernateJpaConnectionRepository
// Note we do not need to add @EnableSpringSocialSecurity annotation here because we want to provide custom user sign up
@EnableTwitter(appId = "${twitter.consumerKey}", appSecret = "${twitter.consumerSecret}")
@EnableFacebook(appId = "${facebook.clientId}", appSecret = "${facebook.clientSecret}")
public class SpringSocialSecurityDemoWebappConfig {
	
	@Bean
	public RequestMappingHandlerMapping handlerMapping() throws Exception {

		 RequestMappingHandlerMapping mapping = new  RequestMappingHandlerMapping();
		return mapping;
	}
	
	/**
	 * This is only needed because the official spring-social-security from SpringSocial is on the classpath
	 * @return
	 */
	@Bean
	public UserIdSource userIdSource() {
		return new UserIdSource() {			
			@Override
			public String getUserId() {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (authentication == null) {
					throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
				}
				return authentication.getName();
			}
		};
	}
	

	@Bean
	public RequestMappingHandlerAdapter handlerAdapter() throws Exception {

		RequestMappingHandlerAdapter mapping = new RequestMappingHandlerAdapter();

		return mapping;

	}

}
