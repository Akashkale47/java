package com.example.akashkale.aaplibusaurangabad;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trackbus extends Fragment implements View.OnClickListener{

    Spinner spinner, spinner2;
    CardView cardView;
    Button button;
    TextView tv1, tv2;
    String[] Cities = {"Railway Station", "ST Divisional Office", "Central Bus Stand", "Police Commissioner Office", "Naubat Darwaza"};
    String[] des = {"Railway Station", "ST Divisional Office", "Central Bus Stand", "Police Commissioner Office", "Naubat Darwaza"};
    ArrayAdapter<String> adapter, adapter2;
    String record = "";

    public Trackbus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trackbus, container, false);
        spinner = view.findViewById(R.id.onsetLocation);
        spinner2 = view.findViewById(R.id.ondeslocation);
        button = view.findViewById(R.id.btFind);
        cardView = view.findViewById(R.id.ccBus);
        tv1 = view.findViewById(R.id.setLocation);
        tv2 = view.findViewById(R.id.setDestinationView);
        button.setOnClickListener(this);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrackingBusLocation.class);
                startActivity(intent);
            }

        });
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, Cities);
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, des);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner = (Spinner) parent;
                if (spinner.getId() == R.id.onsetLocation) {
                    String item = parent.getItemAtPosition(position).toString();
                    tv1.setText(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2 = (Spinner) parent;

                if (spinner2.getId() == R.id.ondeslocation) {

                    String item = parent.getItemAtPosition(position).toString();
                    tv2.setText(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        cardView.setVisibility(View.VISIBLE);
    }

}
