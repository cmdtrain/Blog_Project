package com.blogproject.web.models;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	@MAnyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL);
	@JoinTable(
			name = "users_roles",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
			)
	private List<Role> roles = new ArrayList<>();
	
	
	public void setRoles(List<com.blogproject.web.models.Role> asList) {
		// TODO Auto-generated method stub
		
	}
	public void setUsername(Object username2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}
	public void setPassword(Object password2) {
		// TODO Auto-generated method stub
		
	}
	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
