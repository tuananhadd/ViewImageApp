package com.example.viewimageapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    private ImageView[] imageViews;
    private int currentImageIndex = 0; // Initial image index
    private int numImages = 5; // Number of images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);

        imageViews = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5};

        Button btnPrevious = findViewById(R.id.btnPrevious);
        Button btnNext = findViewById(R.id.btnNext);

        updateImageView();

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex > 0) {
                    currentImageIndex--;
                    updateImageView();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex < numImages - 1) {
                    currentImageIndex++;
                    updateImageView();
                }
            }
        });
    }

    private void updateImageView() {
        for (int i = 0; i < numImages; i++) {
            if (i == currentImageIndex) {
                imageViews[i].setVisibility(View.VISIBLE);
            } else {
                imageViews[i].setVisibility(View.GONE);
            }
        }
    }
}
