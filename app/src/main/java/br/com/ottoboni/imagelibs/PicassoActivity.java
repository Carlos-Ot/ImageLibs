package br.com.ottoboni.imagelibs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {

    public static final String URL = "https://goo.gl/xDB9Sr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        ImageView imageView = (ImageView) findViewById(R.id.image_holder);

        Picasso.with(getApplicationContext())
            .load(URL)
            .placeholder(R.drawable.placeholder_img)
            .error(R.drawable.error_img)
            .into(imageView);
    }
}
