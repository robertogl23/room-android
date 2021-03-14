package com.devrob.robapp.ui.createNote;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.devrob.robapp.R;
import com.devrob.robapp.room.entity.NoteEntity;
import com.devrob.robapp.room.repository.NoteRepository;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class CreateNoteFragment extends Fragment implements View.OnClickListener {
    private CreateNoteViewModel createNoteViewModel;

    private NoteRepository noteRepository;
    private NoteEntity note;
    private TextInputEditText txtTitle;
    private TextInputEditText txtDescription;
    private String title;
    private String description;
    private Button btnNoteSave;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createNoteViewModel = new ViewModelProvider(this).get(CreateNoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_note,container,false);
        configView(root);
        setDefaultTitle();
        return root;
    }

    public void configView(View v){
        noteRepository = new NoteRepository(getActivity().getApplication());
        txtTitle = (TextInputEditText) v.findViewById(R.id.txtTile);
        txtDescription = (TextInputEditText) v.findViewById(R.id.txtDes);
        btnNoteSave = (Button) v.findViewById(R.id.btnSave);
        btnNoteSave.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        title = txtTitle.getText().toString().trim();
        description = txtDescription.getText().toString().trim();

        if(title.isEmpty()){
            txtTitle.setError(getString(R.string.error_input_empty));
        }else{
            if(title.length() < 20){
                if(description.isEmpty()){
                    txtDescription.setError(getString(R.string.error_input_empty));
                }else{
                    if(description.length() < 200){
                        saveNote();
                        Navigation.findNavController(v).navigate(R.id.nav_list_note);
                    }else{
                        txtDescription.setError(getString(R.string.error_input_length));
                    }
                }
            }else{
                txtTitle.setError(getString(R.string.error_input_length));
            }
        }
    }

    private void saveNote(){
        note = new NoteEntity();
        note.setTitle(title);
        note.setDescription(description);
        noteRepository.noteSave(note);
    }


    private void setDefaultTitle(){
        createNoteViewModel.notesCounter().observe(getActivity(),number ->{
            int n = number + 1;
            txtTitle.setText("Note " + n);
        });
    }
}
