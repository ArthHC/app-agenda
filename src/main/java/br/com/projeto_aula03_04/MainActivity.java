package br.com.projeto_aula03_04;

import static android.os.StrictMode.setThreadPolicy;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.util.HashMap;

import br.com.projeto_aula03_04.service.Message;
import br.com.projeto_aula03_04.service.Service;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
//    Funciona tipo o main do java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        initialize();
        //username.setText("my friend");
        Log.i(null,"opa chequei aqui...");


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Bem vindo " + username.getText());
                efetuaLogin();
            }
        });
    }

    public void efetuaLogin() {
        Log.i(null, "Iniciando login");
        Service service = new Service();
        HashMap<String, String> req = new HashMap<>();
        req.put("userName", username.getText().toString());
        req.put("password", password.getText().toString());
        String res = service.Post("/user/login", req);
        Log.i(null, "Chamada login");
        Gson gson = new Gson();
        Message msg = gson.fromJson(res, Message.class);
        Log.i(null, "Conver jason" + res.toString());

        if(msg.getAuth()) {
            Log.i(null, "Login Autorizado - Prox Tela" + msg.getMsg());
            Intent intent = new Intent(this, ActionsView.class);
            startActivity(intent);
        } else {
            Log.i(null, "Login não autorizado." + msg.getMsg());
        }
    }

    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void initialize() {
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        btnLogin = findViewById(R.id.login_btn);
    }
}