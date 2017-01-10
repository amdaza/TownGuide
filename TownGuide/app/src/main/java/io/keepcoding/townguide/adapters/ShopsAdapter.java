package io.keepcoding.townguide.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

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

    public interface OnElementClick<T> {
        public void elementClicked(T element, int position);
    }

    // Only one
    private OnElementClick<Shop> listener;

    // In case of multiple listeners:
    private List<OnElementClick<Shop>> listeners;

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


        row.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // For just one listener
                /*
                if (listener != null) {
                    listener.clickedOn(shop, position);
                }
                */

                // For multiple listeners

                for (OnElementClick<Shop> listener: getListeners()) {
                    // Needs to be declared final, fails otherwise
                    // bc it would be removed from stack
                    listener.elementClicked(shop, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (int)shops.size();
    }


    public List<OnElementClick<Shop>> getListeners() {
        // Lazy getter

        if (listeners == null) {
            listeners = new LinkedList<>();
        }
        return listeners;
    }


    public void setOnElementClickListener(@NonNull final OnElementClick<Shop> listener) {
        // For just one:
        //this.listener = listener;

        // For multiple listeners:
        getListeners().add(listener);

        // Note the use of getListeners instead of listeners
    }

}
