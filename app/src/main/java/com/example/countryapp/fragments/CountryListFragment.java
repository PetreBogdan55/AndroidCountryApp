package com.example.countryapp.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.countryapp.R;
import com.example.countryapp.activities.CountryActivity;
import com.example.countryapp.adapters.CountryAdapter;
import com.example.countryapp.adapters.SwipeToDeleteCallback;
import com.example.countryapp.models.Country;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountryListFragment extends Fragment implements CountryAdapter.ItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CountryAdapter adapter;

    public CountryListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CountryListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountryListFragment newInstance(String param1, String param2) {
        CountryListFragment fragment = new CountryListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        //recycler view
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Romania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));
        countries.add(new Country("Germania", "Bucuresti", "Europa", 18121212, "https://flagpedia.net/data/flags/h80/ro.webp"));

        RecyclerView recyclerView = view.findViewById(R.id.rvCountries);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new CountryAdapter(getContext(), countries);
        adapter.setClickListener(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);


        //swipe do delete
        SwipeToDeleteCallback swipeToDeleteCallback=new SwipeToDeleteCallback(getContext()) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                final Country item = adapter.getItem(position);
                adapter.removeItem(position);

                Snackbar snackbar = Snackbar.make(view, "Item a fost sters din lista", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.restoreItem(item, position);
                        recyclerView.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
        };

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "Ai apasat "+adapter.getItem(position).getName()+" pe randul "+position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), CountryActivity.class);
        intent.putExtra("selectedCountry", (Country)(adapter.getItem(position)));
        startActivity(intent);
    }
}