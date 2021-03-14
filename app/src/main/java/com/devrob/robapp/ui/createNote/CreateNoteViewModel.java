package com.devrob.robapp.ui.createNote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devrob.robapp.room.repository.NoteRepository;

public class CreateNoteViewModel extends AndroidViewModel {

    private LiveData<Integer> noNotes;

    private NoteRepository noteRepository;

    public CreateNoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        noNotes = noteRepository.rows();

    }

    public LiveData<Integer> notesCounter() {
        return noNotes;
    }
}
