package br.com.ottoboni.imagelibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class GlideActivity extends AppCompatActivity {

    public static final String URL = "https://goo.gl/xDB9Sr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ImageView imageView = (ImageView) findViewById(R.id.image_holder);

        GlideApp.with(getApplicationContext())
            .load(URL)
            .placeholder(R.drawable.placeholder_img)
            .error(R.drawable.error_img)
            .into(imageView);
    }
}
