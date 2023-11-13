package com.cardenasvar.usuario.util;

import com.cardenasvar.usuario.dto.BackofficeResponse;

public class Utils {

    public static BackofficeResponse getBackOfficeResponseKO(String descripcion) {
		BackofficeResponse respuestaBackoffice = new BackofficeResponse();
		respuestaBackoffice.setCodigo(400);
		respuestaBackoffice.setMensaje(descripcion);
		return respuestaBackoffice;
	}

    public static BackofficeResponse getBackOfficeResponseOK(String descripcion) {
		BackofficeResponse respuestaBackoffice = new BackofficeResponse();
		respuestaBackoffice.setCodigo(200);
		respuestaBackoffice.setMensaje(descripcion);
		return respuestaBackoffice;
	}
}
