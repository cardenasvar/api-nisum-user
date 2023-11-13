package com.cardenasvar.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.class)
public class UserResponse {

	private Long id;
	private String created;
	private String modified;
	private String lastLogin;
	private String token;
	private boolean active;

	@JsonProperty("respuestaBackoffice")
	private BackofficeResponse respuestaBackoffice = null;

	public UserResponse() {}

	public UserResponse(
			final Long id,
			final String created,
			final String modified,
			final String lastLogin,
			final String token,
			final boolean active) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public String getCreated() {
		return created;
	}

	public String getModified() {
		return modified;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public String getToken() {
		return token;
	}

	public boolean isActive() {
		return active;
	}

	public BackofficeResponse getRespuestaBackoffice() {
		return respuestaBackoffice;
	}

	public void setRespuestaBackoffice(BackofficeResponse respuestaBackoffice) {
		this.respuestaBackoffice = respuestaBackoffice;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final UserResponse that = (UserResponse) o;
		return isActive() == that.isActive()
				&& Objects.equals(getId(), that.getId())
				&& Objects.equals(getCreated(), that.getCreated())
				&& Objects.equals(getModified(), that.getModified())
				&& Objects.equals(getLastLogin(), that.getLastLogin())
				&& Objects.equals(getToken(), that.getToken());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				getId(), getCreated(), getModified(), getLastLogin(), getToken(), isActive());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UserResponse {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
		sb.append("    token: ").append(toIndentedString(token)).append("\n");
		sb.append("    isActive: ").append(toIndentedString(active)).append("\n");
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
