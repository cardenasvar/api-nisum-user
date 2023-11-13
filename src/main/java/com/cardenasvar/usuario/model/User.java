package com.cardenasvar.usuario.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "USERS")
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "PHONES")
	@ElementCollection
	private List<Phone> phones;

	@Column(name = "CREATED")
	private String created;

	@Column(name = "MODIFIED")
	private String modified;

	@Column(name = "LAST_LOGIN")
	private String lastLogin;

	@Column(name = "TOKEN")
	private String token;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	public User() {}

	public User(final Long id) {
		this.id = id;
	}

	public User(
			final Long id,
			final String name,
			final String email,
			final String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(
			final Long id,
			final String name,
			final String email,
			final String password,
			final String created,
			final String modified,
			final String lastLogin,
			final String token,
			final boolean isActive) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public User(
			final String name,
			final String email,
			final String password,
			final List<Phone> phones,
			final String created,
			final String modified,
			final String lastLogin,
			final String token,
			final boolean isActive) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public User(
			final Long id,
			final String name,
			final String email,
			final String password,
			final List<Phone> phones,
			final String created,
			final String modified,
			final String lastLogin,
			final String token,
			final boolean isActive) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuario {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
		sb.append("    token: ").append(toIndentedString(token)).append("\n");
		sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}

		return o.toString().replace("\n", "\n    ");
	}
}
