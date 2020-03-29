package org.wtm.logistics.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateConverter implements Converter<String,Date>{

    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Nullable
    @Override
    public Date convert(String s) {
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
