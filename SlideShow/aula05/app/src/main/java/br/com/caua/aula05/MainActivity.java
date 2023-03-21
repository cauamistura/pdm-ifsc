package br.com.caua.aula05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnHome;
    private Button btnUntil;
    private Button btnNext;

    private int[] images = {R.drawable.cachorro, R.drawable.gardem, R.drawable.happy, R.drawable.patinho, R.drawable.porquinho};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnHome = findViewById(R.id.btn_home);
        btnUntil = findViewById(R.id.btn_until);
        btnNext = findViewById(R.id.btn_next);
        
        imageView.setImageResource(images[currentIndex]);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = 0;
                imageView.setImageResource(images[currentIndex]);
            }
        });

        btnUntil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = images.length - 1;
                }
                imageView.setImageResource(images[currentIndex]);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex == images.length) {
                    currentIndex = 0;
                }
                imageView.setImageResource(images[currentIndex]);
            }
        });
    }
}
