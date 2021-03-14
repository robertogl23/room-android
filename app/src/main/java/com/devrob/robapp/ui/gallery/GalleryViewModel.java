package com.devrob.robapp.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devrob.robapp.room.repository.NoteRepository;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private NoteRepository noteRepository;
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}