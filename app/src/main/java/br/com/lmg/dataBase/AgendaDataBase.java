package br.com.lmg.dataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import br.com.lmg.dataBase.dao.AlunoDao;
import br.com.lmg.model.Aluno;

@Database(entities = { Aluno.class}, version = 2, exportSchema = false)
public abstract class AgendaDataBase  extends RoomDatabase {

    public static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public static AgendaDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDataBase.class, NOME_BANCO_DE_DADOS)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .addMigrations(new Migration(1 , 2) { // versão antiga / versão nova da base de dados
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
                    }
                })
                .build();
    }

    public abstract AlunoDao getRoomAlunoDao();
}
