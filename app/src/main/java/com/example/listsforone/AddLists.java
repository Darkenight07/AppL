package com.example.listsforone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLists extends AppCompatActivity {
    EditText AddListNameID;
    Button ButtonAddListsID;
    Button BackButtonListsID;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lists);

        AddListNameID = findViewById(R.id.AddListNameID);
        ButtonAddListsID = findViewById(R.id.ButtonAddListsID);
        BackButtonListsID = findViewById(R.id.BackButtonListsID);

        ButtonAddListsID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_ListName = AddListNameID.getText().toString();

                Toast.makeText(AddLists.this, "Agregando " + text_ListName, Toast.LENGTH_SHORT).show();

                Intent sendVariableListName = new Intent(AddLists.this, Lists.class);
                sendVariableListName.putExtra("text_ListName", text_ListName);
                startActivity(sendVariableListName);

                startActivity(new Intent(AddLists.this, Lists.class));
            }
        });

        BackButtonListsID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddLists.this, Lists.class));
            }

        });
    }
}