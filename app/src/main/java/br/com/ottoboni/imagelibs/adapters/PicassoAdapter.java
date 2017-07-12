package br.com.ottoboni.imagelibs.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.ottoboni.imagelibs.R;

public class PicassoAdapter extends RecyclerView.Adapter<PicassoAdapter.ViewHolder> {

    private List<String> mUrls;
    private Context mContext;

    public PicassoAdapter(List<String> urls, Context context) {
        mUrls = urls;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_picasso,
            parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext)
            .load(mUrls.get(position))
            .placeholder(R.drawable.placeholder_img)
            .error(R.drawable.error_img)
            .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mUrls.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.picasso_item_img);
        }
    }
}
