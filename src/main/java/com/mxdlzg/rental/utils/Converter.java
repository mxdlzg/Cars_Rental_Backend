package com.mxdlzg.rental.utils;

import java.sql.Timestamp;

public class Converter {
    public static Timestamp toTimestamp(Long unixTime10){
        return new Timestamp(unixTime10*1000);
    }

    public static int diffDays(Long d1, Long d2) {
        return (int) Math.ceil(((d2-d1)/(3600*24.0)));
    }
}
