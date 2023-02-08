package com.example.listsforone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddLists extends AppCompatActivity {
    EditText AddListNameID;
    Button ButtonAddListsID;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lists);

        AddListNameID = findViewById(R.id.AddListNameID);
        ButtonAddListsID = findViewById(R.id.ButtonAddListsID);

        ButtonAddListsID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_ListName = AddListNameID.getText().toString();

                System.out.println(text_ListName);

                startActivity(new Intent(AddLists.this, Lists.class));
            }
        });
    }
}