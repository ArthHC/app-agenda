package br.com.projeto_aula03_04;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.projeto_aula03_04.service.Service;

public class ContactListView extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.contact_listview);

        ListView lw = findViewById(R.id.listview);
        ArrayAdapter<ContactEntity> adapter = new ArrayAdapter<ContactEntity>(this,
                android.R.layout.simple_list_item_1, findContacts());
        lw.setAdapter(adapter);
    }

    public ArrayList<ContactEntity> findContacts() {
        Service service = new Service();
        Gson gson = new Gson();
        String json = service.Get("/contacts/getAllContacts");
        ContactEntity[] list = gson.fromJson(json, ContactEntity[].class);
        return new ArrayList<>(Arrays.asList(list));
    }

}
