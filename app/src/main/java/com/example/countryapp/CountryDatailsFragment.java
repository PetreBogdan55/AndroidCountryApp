package com.example.countryapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.countryapp.activities.CountryActivity;
import com.example.countryapp.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountryDatailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountryDatailsFragment extends Fragment  implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button backButton;

    public CountryDatailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CountryDatailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountryDatailsFragment newInstance(String param1, String param2) {
        CountryDatailsFragment fragment = new CountryDatailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_country_datails, container, false);
        backButton=(Button)view.findViewById(R.id.country_details_back_button);
        backButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.country_details_back_button:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}