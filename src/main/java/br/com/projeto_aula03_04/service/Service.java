package br.com.projeto_aula03_04.service;

import android.util.Log;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Service {

    //url base do backend (Sprngboot)
    private String url = "http://192.168.37.231:8080/app-agenda/api/";
    private Client clientJersey = null;
    private WebResource resource = null;

    public Service() {
        clientJersey = Client.create();
        resource = clientJersey.resource(url);
    }

    /**
     * @param path {path do endpoint}
     * @return devolve o json da requisicao.
     */

    public String Post(String path, Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);

        Log.i(null, "JSON:" + json);
        String resposta = resource.path(path)
                .header("Content-Type", "application/json")
                .post(String.class, json);
        Log.i(null, "Saída User:" + resposta);
        return resposta;
    }

    public String Get(String path) {
        String resposta = resource.path(path)
                .header("Content-Type", "application/json")
                .get(String.class);
        Log.i(null, "Saida:" + resposta);

        return resposta;
    }
}
