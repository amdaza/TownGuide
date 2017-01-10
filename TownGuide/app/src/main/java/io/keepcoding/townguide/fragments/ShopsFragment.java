package io.keepcoding.townguide.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.keepcoding.townguide.R;
import io.keepcoding.townguide.adapters.ShopsAdapter;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.Shops;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends Fragment {
    private RecyclerView shopsRecyclerView;
    private ShopsAdapter adapter;
    private Shops shops;

    private ShopsAdapter.OnElementClick<Shop> listener;
    //private OnElementClick<Shop> listener;


    public ShopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shops, container, false);

        shopsRecyclerView = (RecyclerView) view.findViewById(R.id.shops_recycler_view);
        shopsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private void updateUI() {
        adapter = new ShopsAdapter(getShops(), getActivity());
        shopsRecyclerView.setAdapter(adapter);

        adapter.setOnElementClickListener(new ShopsAdapter.OnElementClick<Shop>() {
            @Override
            public void elementClicked(@NonNull Shop shop, int position) {
                if (listener != null) {
                    listener.elementClicked(shop, position);
                    //listener.clickedOn(element, position);

                }
            }
        });

    }

    public Shops getShops() {
        return shops;
    }

    public void setShops(Shops shops) {
        this.shops = shops;
        updateUI();
    }



    public void setOnElementClickListener(@NonNull final ShopsAdapter.OnElementClick<Shop> listener) {
        this.listener = listener;
    }
/*
    public OnElementClick<Shop> getListener() {
        return listener;
    }

    public void setListener(OnElementClick<Shop> listener) {
        this.listener = listener;
    }
    */
}
