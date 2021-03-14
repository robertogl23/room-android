package com.devrob.robapp.ui.listNote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.devrob.robapp.R;


public class ListNoteFragment extends Fragment {

    private ListNoteViewModel listNoteViewModel;

    private ListView listView;

    private CustomAdapter customAdapter;

    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listNoteViewModel =  new ViewModelProvider(this).get(ListNoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list_note,container,false);
        listView = (ListView) root.findViewById(R.id.note_list);
        setListView();
        setHasOptionsMenu(true);
        return  root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.search_icon);
        SearchView searchView =(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here!");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    protected void setListView(){
        listNoteViewModel.getTitles().observe(getActivity(),titles ->{
            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,titles);
            listView.setAdapter(adapter);
        });
    }
}
