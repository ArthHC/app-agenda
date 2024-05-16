package br.com.projeto_aula03_04;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.HashMap;

import br.com.projeto_aula03_04.service.Message;
import br.com.projeto_aula03_04.service.Service;

public class AddContactView extends AppCompatActivity {

    EditText contactName, contactPhone, contactEmail, contactBirthDate,contactDescription;

    Button btnAddContact;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        initialize();

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });

    }

    public void addContact() {
        Service service = new Service();
        HashMap<String, String> req = new HashMap<>();
        req.put("name", contactName.getText().toString());
        req.put("phone", contactPhone.getText().toString());
        req.put("email", contactEmail.getText().toString());
        req.put("birthDate", contactPhone.getText().toString());
        req.put("description", contactDescription.getText().toString());
        String res = service.Post("/contacts/", req);
        Log.i(null, "Conver jason" + res.toString());
        showMessage("New contact saved");
        Intent intent = new Intent(this, MenuView.class);
        startActivity(intent);
    }

    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void initialize() {
        contactName = findViewById(R.id.contact_name_input);
        contactPhone = findViewById(R.id.contact_phone_input);
        contactEmail = findViewById(R.id.contact_email_input);
        contactBirthDate = findViewById(R.id.contact_birthDate_input);
        contactDescription = findViewById(R.id.contact_description_input);
        btnAddContact = findViewById(R.id.add_btn);
    }

}
