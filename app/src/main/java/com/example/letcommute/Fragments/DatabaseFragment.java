package com.example.letcommute.Fragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.letcommute.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DatabaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatabaseFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private SearchView searchView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DatabaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatabaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DatabaseFragment newInstance(String param1, String param2) {
        DatabaseFragment fragment = new DatabaseFragment();
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
        View view = inflater.inflate(R.layout.fragment_database, container, false);
        dataList = createDataList();

        listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterData(newText);
                return false;
            }
        });

        return view;
    }

    private void filterData(String query) {
        if (TextUtils.isEmpty(query)) {
            adapter.getFilter().filter(null);
        } else {
            adapter.getFilter().filter(query);
        }
    }

    private List<String> createDataList() {
        // Create a sample list of items
        List<String> dataList = new ArrayList<>();
        dataList.add("\nCulprit: Faheem Raza\nCharges: Hit and Run");
        dataList.add("\nCulprit: Rizwan Hmaz\nCharges: Robbery");
        dataList.add("\nCulprit: Farhan Shezad\nCharges: Attempted GTA");
        dataList.add("\nCulprit: Faheem Raza\nCharges: Robbery");
        dataList.add("\nCulprit: Rizwan Hmaz\nCharges: Hit and Run");
        dataList.add("\nCulprit: Farhan Shezad\nCharges: Attempted GTA");
        dataList.add("\nCulprit: Faheem Raza\nCharges: Attempted GTA");
        dataList.add("\nCulprit: Rizwan Hmaz\nCharges: Robbery");
        dataList.add("\nCulprit: Farhan Shezad\nCharges: Hit and Run");
        return dataList;
    }
}