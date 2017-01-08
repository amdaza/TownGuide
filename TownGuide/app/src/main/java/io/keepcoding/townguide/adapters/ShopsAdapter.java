package io.keepcoding.townguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.keepcoding.townguide.R;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.Shops;
import io.keepcoding.townguide.views.ShopRowViewHolder;

/**
 * Created by Alicia on 08/01/2017.
 */

public class ShopsAdapter extends RecyclerView.Adapter<ShopRowViewHolder> {

    private final Shops shops;
    private final LayoutInflater layoutInflater;

    //private OnElementClick<Shop> listener;

    public ShopsAdapter(Shops shops, Context context) {
        this.shops = shops;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ShopRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_shop, parent, false);

        return new ShopRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopRowViewHolder row, final int position) {
        final Shop shop = shops.get(position);

        row.setShop(shop);
/*
        holder.setShop(shop);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.clickedOn(shop, position);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return (int)shops.size();
    }
/*
    public void setOnElementClickListener(@NonNull final OnElementClick<Shop> listener) {
        this.listener = listener;
    }
    */
}
