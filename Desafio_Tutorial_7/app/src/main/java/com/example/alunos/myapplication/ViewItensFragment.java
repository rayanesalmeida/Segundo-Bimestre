package com.example.alunos.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class ViewItensFragment extends Fragment{

    MainActivity main;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_view_items_layout,
                container, false);

        mostraListaDinamica;

        return v;
    }
}
