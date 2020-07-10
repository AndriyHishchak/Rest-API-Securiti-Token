//package com.RestAPISecuritiToken.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@Component(value = "authenticationProviderImpl")
//public class AuthenticationProviderImpl implements AuthenticationProvider {
//
//    @Autowired
//    private UserDetailsService userService;
//
//    //@Resource(name="userService")
//    public void setUserService(UserDetailsService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String login = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        if (userService == null)
//
//            throw new InternalAuthenticationServiceException("UserService is null");
//        System.out.println("UserService is null");
//        UserDetails user = userService.loadUserByUsername(login);
//        if (user == null)
//
//            throw new AuthenticationCredentialsNotFoundException("Not found");
//        System.out.println("Not found");
//        if (user.getPassword().equals(password)) {
//            System.out.println("UsernamePasswordAuthenticationToken");
//            return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
//        } else {
//            System.out.println("Unable to auth against third party systems");
//            throw new AuthenticationServiceException("Unable to auth against third party systems");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//}