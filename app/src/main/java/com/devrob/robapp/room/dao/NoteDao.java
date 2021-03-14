package com.devrob.robapp.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.devrob.robapp.room.entity.NoteEntity;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    LiveData<List<NoteEntity>> getAll();

    @Query("SELECT COUNT(*) FROM note")
    LiveData<Integer> getRows();

    @Query("SELECT title FROM note")
    LiveData<List<String>> getTitles();

    @Insert
    void save(NoteEntity note);
}
