package com.bridgelabz.ipl.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class SocialUser extends org.springframework.social.security.SocialUser {

    private String userId;

    public SocialUser(final String userId, final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        System.out.println("Social Usr Extends to org.springframework.social.security.SocialUser ");
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
