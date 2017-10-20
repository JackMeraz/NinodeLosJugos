package com.example.jacobomeraz.niodelosjugos;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Said on 17/10/2017.
 */

public class RegisterRequest extends StringRequest {

    private  static final  String REGISTER_REQUEST_URL="http://jugos.utrodeo.edu.mx";
    private Map<String,String> params;
    public RegisterRequest(String nombre, String ape_pat, String ape_mat, String user, String pass, String telefono, Response.Listener<String>listener){
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);

        params= new HashMap<>();
        params.put("nombre",nombre);
        params.put("ape_pat",ape_pat);
        params.put("ape_mat",ape_mat);
        params.put("user",user);
        params.put("pass",pass);
        params.put("telefono",telefono);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
