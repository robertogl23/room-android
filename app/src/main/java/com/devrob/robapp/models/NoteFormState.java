package com.devrob.robapp.models;

import androidx.annotation.Nullable;

public class NoteFormState {
    @Nullable
    private Integer titleError;

    @Nullable
    private Integer descriptionError;

    private boolean isDataValid;

    public NoteFormState(@Nullable Integer titleError, @Nullable Integer descriptionError) {
        this.titleError = titleError;
        this.descriptionError = descriptionError;
        this.isDataValid = false;
    }

    public NoteFormState(boolean isDataValid) {
        this.titleError = null;
        this.descriptionError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getTitleError() {
        return titleError;
    }

    @Nullable
    public Integer getDescriptionError() {
        return descriptionError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
