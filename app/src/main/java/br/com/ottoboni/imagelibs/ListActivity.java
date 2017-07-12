package br.com.ottoboni.imagelibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import br.com.ottoboni.imagelibs.adapters.FrescoAdapter;
import br.com.ottoboni.imagelibs.adapters.GlideAdapter;
import br.com.ottoboni.imagelibs.adapters.PicassoAdapter;

public class ListActivity extends AppCompatActivity {

    public static final int PICASSO = 1;
    public static final int GLIDE = 2;
    public static final int FRESCO = 3;
    public static final String LIB_TYPE = "lib_type";
    private int mLibType = -1;

    private RecyclerView mRecyclerList;
    private LinearLayoutManager mLinearLayoutManager;

    //Adapters
    private PicassoAdapter mPicassoAdapter;
    private GlideAdapter mGlideAdapter;
    private FrescoAdapter mFrescoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            mLibType = extras.getInt(LIB_TYPE);
        }

        initViews();
        loadListByType();
    }

    private void initViews() {

        mRecyclerList = (RecyclerView) findViewById(R.id.recycler_list);
        mRecyclerList.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerList.setLayoutManager(mLinearLayoutManager);
    }

    private void loadListByType() {

        switch (mLibType) {
            case PICASSO:
                mPicassoAdapter = new PicassoAdapter(ImageUtil.getImageList(ImageUtil.ListType.DOGS), getApplicationContext());
                mRecyclerList.setAdapter(mPicassoAdapter);
                break;
            case GLIDE:
                mGlideAdapter = new GlideAdapter(ImageUtil.getImageList(ImageUtil.ListType.BEACHES),
                    getApplicationContext());
                mRecyclerList.setAdapter(mGlideAdapter);
                break;
            case FRESCO:
                mFrescoAdapter = new FrescoAdapter(ImageUtil.getImageList(ImageUtil.ListType.FOREST),
                    getApplicationContext());
                mRecyclerList.setAdapter(mFrescoAdapter);
                break;
            default:
                Toast.makeText(this, "Invalid lib type", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
