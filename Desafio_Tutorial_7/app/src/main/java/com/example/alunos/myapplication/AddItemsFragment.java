package com.example.alunos.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class AddItemsFragment extends Fragment{

    EditText editNome;

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_items_layout,
                container, false);
        return v;
    }
        public void salvar(View v){

        editNome = (EditText)findViewById(R.id.editName);

        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String name = editNome.getText().toString();
        if(name.matches("")  ){
            Toast toast = Toast.makeText(AddItemsFragment.this,
                    "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("nome", name);
        editor.commit();
        editNome.setText("");

        lista.add(new Pessoa(name));
    }
}
