package io.keepcoding.townguide.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.keepcoding.townguide.R;
import io.keepcoding.townguide.navigator.Navigator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_shops_button)

    Button shopsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupShopsButton();
    }

    private void setupShopsButton() {
        shopsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigator.navigateFromMainActivityToShopsActivity(MainActivity.this);
            }
        });
    }
}
