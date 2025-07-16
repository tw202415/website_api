package tw.com.elf.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Replace with real DB/user repo lookup
        
    	System.err.println(username);
    	// 帳密無誤便把資訊存在User物件
    	if ("admin@yahoo.com".equals(username)) {
            // password: "password" (BCrypt encoded: $2a$10$7QwJX1lQ5M8w7r4u1b1F9e8tQh7lQ7b8lQ7b8lQ7b8lQ7b8lQ7b8lQ7)
            return new User("user", "$2a$10$7QwJX1lQ5M8w7r4u1b1F9e8tQh7lQ7b8lQ7b8lQ7b8lQ7b8lQ7b8lQ7", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }
        throw new UsernameNotFoundException("User not found");
    }
}
