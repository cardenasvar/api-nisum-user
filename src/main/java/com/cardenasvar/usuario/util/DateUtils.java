package com.cardenasvar.usuario.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    public static String dateNow() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(LocalDateTime.now());
    }

    public DateUtils() {}
}
