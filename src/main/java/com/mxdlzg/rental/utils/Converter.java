package com.mxdlzg.rental.utils;

import java.sql.Timestamp;

public class Converter {
    public static Timestamp toTimestamp(Long unixTime10){
        return new Timestamp(unixTime10*1000);
    }
}
