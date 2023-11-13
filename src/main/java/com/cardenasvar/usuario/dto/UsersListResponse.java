package com.cardenasvar.usuario.dto;

import com.cardenasvar.usuario.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.class)
public class UsersListResponse {

	private List<User> users;

	public UsersListResponse() {}

	public UsersListResponse(final List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
			
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
			
		UsersListResponse that = (UsersListResponse) o;
		return Objects.equals(getUsers(), that.getUsers());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUsers());
	}

	@Override
	public String toString() {
		return "UsersListResponse {" + "users=" + getUsers() + '}';
	}
}
