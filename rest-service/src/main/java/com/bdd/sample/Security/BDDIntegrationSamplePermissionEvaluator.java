//package com.bdd.sample.Security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.access.PermissionEvaluator;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//
//@Component
//public class BDDIntegrationSamplePermissionEvaluator implements PermissionEvaluator {
//
//    @Override
//    public boolean hasPermission(
//            Authentication authentication,
//            Object target,
//            Object permission) {
//    return false;
//
//
//    }
//
//    @Override
//    public boolean hasPermission(Authentication authentication,Serializable targetId,
//                                 String targetType,Object permission) {
//        Logger logger = LoggerFactory.getLogger(BDDIntegrationSamplePermissionEvaluator.class);
//        logger.info("hasPermission >> permission.toString() : " + permission.toString());
//        logger.info("hasPermission >> contains : " + authentication.getAuthorities().contains(new SimpleGrantedAuthority(permission.toString())));
//        return authentication.getAuthorities().contains(new SimpleGrantedAuthority(permission.toString()));
//    }
//
//
//
//}
//
