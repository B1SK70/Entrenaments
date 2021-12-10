package com.example.examendecember;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout workA = (LinearLayout) findViewById(R.id.workA);
        workA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workSelected("A");
            }
        });

        LinearLayout workB = (LinearLayout) findViewById(R.id.workB);
        workB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workSelected("B");
            }
        });

        LinearLayout workC = (LinearLayout) findViewById(R.id.workC);
        workC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workSelected("C");
            }
        });

        LinearLayout workD = (LinearLayout) findViewById(R.id.workD);
        workD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workSelected("D");
            }
        });

    }

    private void workSelected(String workN) {

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("workN", workN);

        TrainingInfo training = new TrainingInfo();
        training.setArguments(bundle);

        transaction.replace(R.id.containerB, training);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    
}