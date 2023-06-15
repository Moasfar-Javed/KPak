package com.example.letcommute.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.letcommute.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DistressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DistressFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DistressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DistressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DistressFragment newInstance(String param1, String param2) {
        DistressFragment fragment = new DistressFragment();
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
        View view = inflater.inflate(R.layout.fragment_distress, container, false);

        // Initialize ListView
        listView = view.findViewById(R.id.listView);

        // Create and set the adapter
        dataList = createDataList(); // Replace this with your own data
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        return view;
    }

    private List<String> createDataList() {
        // Create a sample list of items
        List<String> dataList = new ArrayList<>();
        dataList.add("\nName: Muhammad Moasfar Javed\nLocation: Saima Pride\nType: Crime\nTime: 7:10 PM\nDescription: A person just got robbed infront of me!! send help ASAP\n");
        dataList.add("\nName: Ahmad Mustabassir\nLocation: Bahria University\nType: Fire\nTime: 8:10 PM\nDescription: Theres a fire on the 3rd floor and the building is being evacuated, send fire dept!!\n");
        dataList.add("\nName: Abeer Inam\nLocation: Disco Bakery\nType: Ambulance\nTime: 9:10 PM\nDescription: A person just got a heart attack at disco bakery, need an immediate ambulance here\n");
        return dataList;
    }
}