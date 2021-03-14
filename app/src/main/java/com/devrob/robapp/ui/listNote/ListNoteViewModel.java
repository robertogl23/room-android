package com.devrob.robapp.ui.listNote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.devrob.robapp.room.entity.NoteEntity;
import com.devrob.robapp.room.repository.NoteRepository;

import java.util.List;

public class ListNoteViewModel extends AndroidViewModel {

    private LiveData<List<NoteEntity>> noteList;

    private LiveData<List<String>> titles;
    private NoteRepository noteRepository;

    public ListNoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        noteList = noteRepository.getAllNotes();
        titles = noteRepository.titles();
    }

    public LiveData<List<NoteEntity>> getNoteList() {
        return noteList;
    }

    public LiveData<List<String>> getTitles() {
        return titles;
    }
}
