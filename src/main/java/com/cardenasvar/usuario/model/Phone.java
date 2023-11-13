package com.cardenasvar.usuario.model;

import com.cardenasvar.usuario.util.Constantes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategy.class)
public class Phone implements Serializable {

	@NotNull(message = Constantes.ERROR_MSG_NULL_NUMBER)
	@NotBlank(message = Constantes.ERROR_MSG_EMPTY_NUMBER)
	private String number;

	@NotNull(message = Constantes.ERROR_MSG_NULL_CITY_CODE)
	@NotBlank(message = Constantes.ERROR_MSG_EMPTY_CITY_CODE)
	@JsonProperty("citycode")
	private String cityCode;

	@NotNull(message = Constantes.ERROR_MSG_NULL_COUNTRY_CODE)
	@NotBlank(message = Constantes.ERROR_MSG_EMPTY_COUNTRY_CODE)
	@JsonProperty("contrycode")
	private String countryCode;

	public Phone() {}

	public Phone(final String number, final String cityCode, final String countryCode) {
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
			
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
			
		final Phone phone = (Phone) o;
		return Objects.equals(getNumber(), phone.getNumber()) && 
			Objects.equals(getCityCode(), phone.getCityCode()) && 
			Objects.equals(getCountryCode(), phone.getCountryCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, cityCode, countryCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Phone {\n");
		sb.append("    number: ").append(toIndentedString(number)).append("\n");
		sb.append("    citycode: ").append(toIndentedString(cityCode)).append("\n");
		sb.append("    contrycode: ").append(toIndentedString(countryCode)).append("\n");
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
