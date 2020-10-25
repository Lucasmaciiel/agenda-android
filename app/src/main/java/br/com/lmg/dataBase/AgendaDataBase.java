package br.com.lmg.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import br.com.lmg.dataBase.converter.ConversonCalendar;
import br.com.lmg.dataBase.dao.AlunoDao;
import br.com.lmg.model.Aluno;

import static br.com.lmg.dataBase.dao.AgendaMigrations.TODAS_MIGRATIONS;

@Database(entities = { Aluno.class}, version = 4, exportSchema = false)
@TypeConverters({ConversonCalendar.class})
public abstract class AgendaDataBase  extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public static AgendaDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDataBase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }

    public abstract AlunoDao getRoomAlunoDao();
}
