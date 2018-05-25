package com.example.alunos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tnome = new EditText(this);
    EditText ttelefone = new EditText(this);

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Cria o layout

        TableLayout tabela = new TableLayout(this);
        tabela.setPadding(10, 10, 10, 10);
        tabela.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        //Expande a coluna 1
        tabela.setColumnStretchable(1, true);
        //Linha 1
        TableRow linha1 = new TableRow(this);
        TextView nome = new TextView(this);
        nome.setText("Nome: ");
        linha1.addView(nome);
        //Focus
        tnome.requestFocus();
        linha1.addView(tnome);

        //Linha 2
        TableRow linha2 = new TableRow(this);
        TextView telefone = new TextView(this);
        telefone.setText("Telefone: ");
        linha2.addView(telefone);
        //ttelefone.setTransformationMethod(
                //new NumberFormatException());
        linha2.addView(ttelefone);

        //Linha 3

        TableRow linha3 = new TableRow(this);
        linha3.setGravity(Gravity.CENTER_HORIZONTAL);
        //Botão alinhado a direita
        Button salvar = new Button(this);
        salvar.setText("Salvar: ");
        //salvar.setOnClickListener(this);
        linha3.addView(salvar);

        TableRow linha4 = new TableRow(this);
        linha4.setGravity(Gravity.CENTER_HORIZONTAL);
        Button carregar = new Button(this);
        carregar.setText("Carregar: ");
        //carregar.setOnClickListener(this);
        linha4.addView(carregar);

        //Adiciona as linhas
        tabela.addView(linha1);
        tabela.addView(linha2);
        tabela.addView(linha3);
        tabela.addView(linha4);

        //Informa o layout
        setContentView(tabela);
    }
    public void salvar(View V){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String name = tnome.getText().toString();
        String telefone  = ttelefone.getText().toString();
        if(name.matches("") && telefone.matches("") ){
            Toast toast = Toast.makeText(MainActivity.this,
                    "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("nome", name);
        editor.putString("telefone", telefone);
        editor.commit();
        tnome.setText("");
        ttelefone.setText("");

        lista.add(new Pessoa(name, telefone));
    }

    /*@Override
    public void onClick(View v){
        salvar();
    }*/

    public void mostrarLista(View v){
        Intent it = new Intent(this, Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        it.putExtras(bundle);
        startActivity(it);
    }
}
