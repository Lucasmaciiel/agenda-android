package br.com.lmg.dataBase.converter;

import java.util.Calendar;

import androidx.room.TypeConverter;

public class ConversonCalendar {

    @TypeConverter
    public Long paraLong(Calendar valor) {
        return valor.getTimeInMillis();
    }

    @TypeConverter
    public Calendar paraCalendar(Long valor){
        Calendar momentoAtual = Calendar.getInstance();
        if (momentoAtual != null){
            momentoAtual.setTimeInMillis(valor);
        }
        return momentoAtual;
    }
}
