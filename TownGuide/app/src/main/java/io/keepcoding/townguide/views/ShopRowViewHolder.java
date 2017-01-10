package io.keepcoding.townguide.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

import io.keepcoding.townguide.R;
import io.keepcoding.townguide.model.Shop;

/**
 * Created by Alicia on 08/01/2017.
 */

public class ShopRowViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    ImageView logoImageView;
    WeakReference<Context> context;

    public ShopRowViewHolder(View rowShop) {
        super(rowShop);

        context = new WeakReference<>(rowShop.getContext());
        nameTextView = (TextView) rowShop.findViewById(R.id.row_shop_name);
        logoImageView = (ImageView) rowShop.findViewById(R.id.row_shop_logo);
    }

    public void setShop(final @NonNull Shop shop) {
        if (shop == null) {
            return;
        }
        this.nameTextView.setText(shop.getName());
        //this.logoImageView.setImageBitmap(null);

        Picasso.with(context.get())
            .load(shop.getLogoImgUrl())
            .networkPolicy(NetworkPolicy.OFFLINE)
            .placeholder(android.R.drawable.ic_btn_speak_now)
            .into(logoImageView);

    }
}
