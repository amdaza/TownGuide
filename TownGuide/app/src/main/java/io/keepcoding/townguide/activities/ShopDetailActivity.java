package io.keepcoding.townguide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.keepcoding.townguide.R;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.utils.Constants;

public class ShopDetailActivity extends AppCompatActivity {

    private Shop shop;

    @BindView(R.id.activity_shop_detail_logo_image)
    ImageView logoImage;

    @BindView(R.id.activity_shop_detail_shop_name_text)
    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        // When using ButterKnife annotations,
        // first thing to do is bind it:
        ButterKnife.bind(this);

        Intent intent = getIntent();
        shop = (Shop) intent.getSerializableExtra(Constants.INTENT_KEY_DETAIL_SHOP);

        if (shop != null) {
            nameText.setText(shop.getName());

            Picasso.with(this)
                    .load(shop.getLogoImgUrl())
                    .into(logoImage);
        }
    }
}
