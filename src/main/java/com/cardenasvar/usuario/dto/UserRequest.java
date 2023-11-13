package com.cardenasvar.usuario.dto;

import com.cardenasvar.usuario.model.Phone;
import com.cardenasvar.usuario.util.Constantes;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.Valid;

@JsonNaming(PropertyNamingStrategy.class)
public class UserRequest implements Serializable {

	@NotNull(message = Constantes.ERROR_MSG_NULL_NAME)
	@NotBlank(message = Constantes.ERROR_MSG_EMPTY_NAME)
	private String name;

	@NotNull(message = Constantes.ERROR_MSG_NULL_EMAIL)
	@NotBlank(message = Constantes.ERROR_MSG_EMPTY_EMAIL)
	@Email(message = Constantes.ERROR_MSG_FORMAT_EMAIL, regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;

	@NotNull(message = Constantes.ERROR_MSG_NULL_PASSWORD)
	@NotBlank(message = Constantes.ERROR_MSG_EMPTY_PASSWORD)
	private String password;

	@Valid
	@NotNull(message = Constantes.ERROR_MSG_NULL_PHONES)
	@NotEmpty(message = Constantes.ERROR_MSG_EMPTY_PHONES)
	private List<Phone> phones;

	public UserRequest() {
	}

	public UserRequest(final String email) {
		this.email = email;
	}

	public UserRequest(
			final String name,
			final String email,
			final String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserRequest(
			final String name,
			final String email,
			final String password,
			final List<Phone> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final UserRequest that = (UserRequest) o;
		return Objects.equals(name, that.name) &&
				Objects.equals(email, that.email) &&
				Objects.equals(password, that.password) &&
				Objects.equals(phones, that.phones);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, email, password, phones);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UserRequest {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
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
