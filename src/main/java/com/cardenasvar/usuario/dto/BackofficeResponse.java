package com.cardenasvar.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;

@Validated
public class BackofficeResponse {

    @JsonProperty("codigo")
    private Integer codigo = null;

    @JsonProperty("mensaje")
    private String mensaje = null;

    public BackofficeResponse codigoError(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    @ApiModelProperty(value = "Código")
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BackofficeResponse mensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    @ApiModelProperty(value = "Mensaje")
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BackofficeResponse respuestaBackoffice = (BackofficeResponse) o;
        return Objects.equals(this.codigo, respuestaBackoffice.codigo) &&
                Objects.equals(this.mensaje, respuestaBackoffice.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, mensaje);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RespuestaBackoffice {\n");

        sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
        sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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