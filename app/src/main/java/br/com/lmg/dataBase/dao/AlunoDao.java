package br.com.lmg.dataBase.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import br.com.lmg.model.Aluno;

@Dao
public interface AlunoDao {

    @Insert
    void salva(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> todos();

    @Delete
     void remove(Aluno aluno);

    @Update
    void edita(Aluno aluno);
}

