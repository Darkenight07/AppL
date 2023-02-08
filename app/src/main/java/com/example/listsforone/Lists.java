package com.example.listsforone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lists extends AppCompatActivity {

    Button addListsButtonID;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        addListsButtonID = findViewById(R.id.ButtonAddListsID);

        // Pasando la variable text_ListName de la clase AddLists.java a este

        Intent sendVariableListName = getIntent();
        String text_ListName = sendVariableListName.getStringExtra("text_ListName");

        System.out.println(text_ListName);

    }
    public void addListButton(View view) {
        startActivity(new Intent(Lists.this, AddLists.class));

    }
}