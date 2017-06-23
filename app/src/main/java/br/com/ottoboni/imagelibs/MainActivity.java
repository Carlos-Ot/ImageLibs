package br.com.ottoboni.imagelibs;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.icu.util.TimeUnit;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TimingLogger;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://goo.gl/5qHdB8";
    public static final String TAG_LOGGER = "ImageLoad";

    private ImageView holderPicasso;
    private ImageView holderGlide;
    private SimpleDraweeView holderFresco;

    private long picassoTime = 0;
    private long frescoTime = 0;
    private long glideTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holderPicasso = (ImageView) findViewById(R.id.holder_picasso);
        holderGlide = (ImageView) findViewById(R.id.holder_glide);
        holderFresco = (SimpleDraweeView) findViewById(R.id.holder_fresco);

        loadImages();
        setListeners();
    }

    private void loadImages() {

        //Load image with Picasso
        picassoTime = System.nanoTime();
        Picasso.with(getApplicationContext())
            .load(URL)
            .placeholder(R.drawable.placeholder_img)
            .error(R.drawable.error_img)
            .into(holderPicasso, new Callback() {
                @Override
                public void onSuccess() {
                    picassoTime = System.nanoTime() - picassoTime;
                    Log.d(TAG_LOGGER, "Picasso time: " + (picassoTime/1000000000.0) + " secconds");
                }

                @Override
                public void onError() {

                }
            });

        //Load image with Glide
        glideTime = System.nanoTime();
        GlideApp.with(getApplicationContext())
            .load(URL)
            .placeholder(R.drawable.placeholder_img)
            .error(R.drawable.error_img)
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable>
                    target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    glideTime = System.nanoTime() - glideTime;
                    Log.d(TAG_LOGGER, "Glide time: " + (glideTime/1000000000.0) + " secconds");
                    return false;
                }
            })
            .into(holderGlide);

        //Load image with Fresco
        Uri uri = Uri.parse(URL);

        DraweeController controller = Fresco.newDraweeControllerBuilder()
            .setControllerListener(controllerListener)
            .setUri(uri)
            .build();
        frescoTime = System.nanoTime();
        holderFresco.setController(controller);

    }

    private void setListeners() {

        holderPicasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou Picasso", Toast.LENGTH_SHORT).show();
            }
        });

        holderGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou Glide", Toast.LENGTH_SHORT).show();
            }
        });

        holderFresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou no Fresco", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ControllerListener controllerListener = new BaseControllerListener() {
        @Override
        public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);

            frescoTime = System.nanoTime() - frescoTime;

            Log.d(TAG_LOGGER, "Fresco time: " + (frescoTime/1000000000.0) + " secconds");
        }
    };

}
