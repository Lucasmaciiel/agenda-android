package br.com.lmg.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import br.com.lmg.dataBase.dao.AlunoDao;
import br.com.lmg.model.Aluno;

@Database(entities = { Aluno.class}, version = 2, exportSchema = false)
public abstract class AgendaDataBase  extends RoomDatabase {

    public static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public static AgendaDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDataBase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .build();
    }

    public abstract AlunoDao getRoomAlunoDao();
}
