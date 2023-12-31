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
 * Use the {@link GuidelineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuidelineFragment extends Fragment {


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

    public GuidelineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuidelineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuidelineFragment newInstance(String param1, String param2) {
        GuidelineFragment fragment = new GuidelineFragment();
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

        //View view = inflater.inflate(R.layout.fragment_guideline, container, false);
        View view = inflater.inflate(R.layout.fragment_guideline, container, false);
        listView = view.findViewById(R.id.listView); // Initialize listView

        dataList = createDataList();
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        return view;
    }

    private List<String> createDataList() {
        // Create a sample list of items
        List<String> dataList = new ArrayList<>();
        dataList.add("See something, say something");
        dataList.add("Get to a safe distance");
        dataList.add("Inform authorities");
        dataList.add("Do not pursuit the bandits");
        dataList.add("If injured maintain pressure on the wound");
        return dataList;
    }
}