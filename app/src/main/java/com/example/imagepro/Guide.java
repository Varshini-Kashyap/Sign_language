package com.example.imagepro;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Guide extends Activity {
    TextView Title;
    Image imageView2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);


        Title = (TextView) findViewById(R.id.Title);
        ImageView asl= (ImageView)findViewById(R.id.imageView2);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}
