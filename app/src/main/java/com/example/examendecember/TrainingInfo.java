package com.example.examendecember;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Locale;

public class TrainingInfo extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Fragment itself = this;
    private ConstraintLayout background;

    private ImageView workImg;
    private TextView workName;
    private TextView workDescription;
    private Button backBtn;


    public TrainingInfo() {
    }

    public static TrainingInfo newInstance(String param1, String param2) {
        TrainingInfo fragment = new TrainingInfo();
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


        View view = inflater.inflate(R.layout.fragment_training_info, container, false);
        workImg = view.findViewById(R.id.workImage);
        workName = view.findViewById(R.id.workName);
        workDescription = view.findViewById(R.id.workDescrition);
        backBtn = view.findViewById(R.id.backBtn);

        background = view.findViewById(R.id.constraintLayout);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            backBtn.setVisibility(View.GONE);
        } else {
            background.setBackgroundColor(Color.WHITE);
            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().getFragmentManager().beginTransaction().remove(itself).commit();
                }
            });
        }

        String workN = getArguments().getString("workN");
        drawWork(workN);

        return view;
    }

    public void drawWork(String n) {


        int titleId = getResources().getIdentifier("entreno" + n, "string", getActivity().getPackageName());
        int descriptionID = getResources().getIdentifier("descripcio" + n, "string", getActivity().getPackageName());

        n = n.toLowerCase(Locale.ROOT);
        int imgId = getResources().getIdentifier(n, "drawable", getActivity().getPackageName());


        workImg.setImageResource(imgId);
        workName.setText(titleId);
        workDescription.setText(descriptionID);


    }

}