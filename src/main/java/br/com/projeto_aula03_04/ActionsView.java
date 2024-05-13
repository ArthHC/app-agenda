package br.com.projeto_aula03_04;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActionsView extends AppCompatActivity {

    Button btnList, btnAdd, btnExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actions_view);
        initialize();

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callListContactView();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAddContactView();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callExitToLogin();
            }
        });

    }

    public void callListContactView() {
        Intent intent = new Intent(this, ContactListView.class);
        startActivity(intent);
    }

    public void callAddContactView() {
        Intent intent = new Intent(this, AddContactView.class);
        startActivity(intent);
    }
    public void callExitToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void initialize() {
        btnList = findViewById(R.id.contactList_btn);
        btnAdd = findViewById(R.id.addContact_btn);
        btnExit = findViewById(R.id.exit_btn);
    }
}
