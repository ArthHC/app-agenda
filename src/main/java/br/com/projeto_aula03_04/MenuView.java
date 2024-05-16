package br.com.projeto_aula03_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuView extends AppCompatActivity {

    Button btnList, btnAdd, btnExit;

    ImageView info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_view);
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

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callInfoView();
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

    public void callInfoView() {
        Intent intent = new Intent(this, InfoView.class);
        startActivity(intent);
    }

    public void initialize() {
        btnList = findViewById(R.id.contactList_btn);
        btnAdd = findViewById(R.id.addContact_btn);
        btnExit = findViewById(R.id.exit_btn);
        info = findViewById(R.id.info);
    }
}
