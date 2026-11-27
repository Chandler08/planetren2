package com.example.planetren;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivAktualneCwiczenie;
    private TextView tvNazwaCwiczenia;
    private TextView tvLicznikSerii;
    private TextView tvLacznaLiczbaSerii;

    private Button btnLosujCwiczenie;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnNastepneCwiczenie;
    private Button btnReset;

    private int aktualneSerie = 0;
    private int lacznaLiczbaSerii = 0;

    private final Random random = new Random();

    // Tablica identyfikatorów grafik ćwiczeń (indeks 0 to stan początkowy, 1..6 to ćwiczenia)
    private final int[] obrazyCwiczen = {
            R.drawable.cwiczenie0,
            R.drawable.cwiczenie1,
            R.drawable.cwiczenie2,
            R.drawable.cwiczenie3,
            R.drawable.cwiczenie4,
            R.drawable.cwiczenie5,
            R.drawable.cwiczenie6
    };

    // Tablica nazw ćwiczeń odpowiadająca indeksom w tablicy obrazyCwiczen
    private final String[] nazwyCwiczen = {
            "Losuj ćwiczenie",
            "Przysiad",
            "Pompki",
            "Plank",
            "Wykroki",
            "Burpees",
            "Podciąganie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicjalizujWidoki();
        ustawStanPoczatkowy();
        ustawObslugePrzyciskow();
    }

    private void inicjalizujWidoki() {
        ivAktualneCwiczenie = findViewById(R.id.ivAktualneCwiczenie);
        tvNazwaCwiczenia = findViewById(R.id.tvNazwaCwiczenia);
        tvLicznikSerii = findViewById(R.id.tvLicznikSerii);
        tvLacznaLiczbaSerii = findViewById(R.id.tvLacznaLiczbaSerii);

        btnLosujCwiczenie = findViewById(R.id.btnLosujCwiczenie);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnNastepneCwiczenie = findViewById(R.id.btnNastepneCwiczenie);
        btnReset = findViewById(R.id.btnReset);
    }

    private void ustawStanPoczatkowy() {
        aktualneSerie = 0;
        lacznaLiczbaSerii = 0;

        ivAktualneCwiczenie.setImageResource(obrazyCwiczen[0]);
        tvNazwaCwiczenia.setText(nazwyCwiczen[0]);
        aktualizujWidokLicznikaSerii();
        aktualizujWidokLacznejLiczbySerii();
    }

    private void ustawObslugePrzyciskow() {
        btnLosujCwiczenie.setOnClickListener(v -> wylosujNoweCwiczenie());

        btnPlus.setOnClickListener(v -> zwiekszLiczbeSerii());

        btnMinus.setOnClickListener(v -> zmniejszLiczbeSerii());

        btnNastepneCwiczenie.setOnClickListener(v -> przejdzDoNastepnegoCwiczenia());

        btnReset.setOnClickListener(v -> ustawStanPoczatkowy());
    }

    private void wylosujNoweCwiczenie() {
        // Losowanie liczby całkowitej z zakresu od 1 do 6
        int wylosowanyNumer = random.nextInt(6) + 1;

        ivAktualneCwiczenie.setImageResource(obrazyCwiczen[wylosowanyNumer]);
        tvNazwaCwiczenia.setText(nazwyCwiczen[wylosowanyNumer]);

        aktualneSerie = 0;
        aktualizujWidokLicznikaSerii();
    }

    private void zwiekszLiczbeSerii() {
        aktualneSerie++;
        aktualizujWidokLicznikaSerii();
    }

    private void zmniejszLiczbeSerii() {
        if (aktualneSerie > 0) {
            aktualneSerie--;
            aktualizujWidokLicznikaSerii();
        }
    }

    private void przejdzDoNastepnegoCwiczenia() {
        lacznaLiczbaSerii += aktualneSerie;
        aktualizujWidokLacznejLiczbySerii();
        wylosujNoweCwiczenie();
    }

    private void aktualizujWidokLicznikaSerii() {
        tvLicznikSerii.setText(String.valueOf(aktualneSerie));
    }

    private void aktualizujWidokLacznejLiczbySerii() {
        tvLacznaLiczbaSerii.setText("Łączna liczba serii: " + lacznaLiczbaSerii);
    }
}