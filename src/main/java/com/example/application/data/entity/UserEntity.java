package com.example.application.data.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.application.data.AbstractEntity;

@Entity
public class UserEntity extends AbstractEntity {

	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	@Email(message = "This doesn't look like a valid email address")
	@NotNull(message = "Полето е задължително!")
	private String email;
	@NotNull(message = "Полето е задължително!")
	@Size(min = 4, max = 250, message = "Дължината на стойността не е валидна")
	@Column(name = "avatar_location", length = 255)
	private String avatarLocation;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<CommentEntity> comments;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles;

	public UserEntity() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatarLocation() {
		return avatarLocation;
	}

	public void setAvatarLocation(String avatarLocation) {
		this.avatarLocation = avatarLocation;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public void removeRole(RoleEntity selectedRole) {
		roles.remove(selectedRole);

	}

	public void addRole(RoleEntity newRole) {
		roles.add(newRole);

	}
}
