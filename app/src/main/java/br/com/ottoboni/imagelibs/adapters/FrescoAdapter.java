package br.com.ottoboni.imagelibs.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import br.com.ottoboni.imagelibs.R;

public class FrescoAdapter extends RecyclerView.Adapter<FrescoAdapter.ViewHolder> {

    private List<String> mUrls;
    private Context mContext;

    public FrescoAdapter(List<String> urls, Context context) {
        mUrls = urls;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_fresco,
            parent, false);

        return new FrescoAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Uri uri = Uri.parse(mUrls.get(position));
        holder.mImageView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mUrls.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mImageView = (SimpleDraweeView) itemView.findViewById(R.id.fresco_item_img);
        }
    }
}
