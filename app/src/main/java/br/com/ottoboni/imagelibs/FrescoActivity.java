package br.com.ottoboni.imagelibs;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoActivity extends AppCompatActivity {

    public static final String URL = "https://goo.gl/xDB9Sr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.image_holder);

        Uri uri = Uri.parse(URL);
        simpleDraweeView.setImageURI(uri);

    }
}
