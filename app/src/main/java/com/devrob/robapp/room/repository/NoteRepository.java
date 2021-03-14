package com.devrob.robapp.room.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.devrob.robapp.AppDatabase;
import com.devrob.robapp.room.dao.NoteDao;
import com.devrob.robapp.room.entity.NoteEntity;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application) {
        AppDatabase db= AppDatabase.getDatabase(application);
        noteDao = db.userDao();
    }

    public LiveData<List<NoteEntity>> getAllNotes(){
        return noteDao.getAll();
    }

    public LiveData<Integer> rows(){
        return  noteDao.getRows();
    }

    public LiveData<List<String>> titles(){
        return noteDao.getTitles();
    }

    public void noteSave(NoteEntity note) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            try {
                noteDao.save(note);
                System.out.println("ok");

            }catch (Exception e){
                System.out.println(e);
            }
        });
    }
}
