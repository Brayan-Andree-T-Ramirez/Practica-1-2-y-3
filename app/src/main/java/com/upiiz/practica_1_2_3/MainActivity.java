package com.upiiz.practica_1_2_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button btnHome,btnNews, btnServices,btnSchool,btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnHome = findViewById(R.id.btnHome);
        btnNews = findViewById(R.id.btnNews);
        btnServices = findViewById(R.id.btnServices);
        btnProfile = findViewById(R.id.btnProfile);
        btnSchool = findViewById(R.id.btnSchool);

        if(savedInstanceState == null){
            replaceFragment(new fragment_inicio());
        }
        btnHome.setOnClickListener(v -> replaceFragment(new fragment_inicio()));
        btnNews.setOnClickListener(v -> replaceFragment(new fragment_noticias()));
        btnServices.setOnClickListener(v -> replaceFragment(new fragment_servicios()));
        btnSchool.setOnClickListener(v -> activarToast());
        btnProfile.setOnClickListener(v -> activarToast());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.body, fragment);

        fragmentTransaction.commit();

    }

    private void activarToast(){
        CharSequence texto = "Funcion no disponible :(";
        int longitud = Toast.LENGTH_LONG;
        Toast mensaje = Toast.makeText(this, texto,longitud);
        mensaje.show();
    }
}