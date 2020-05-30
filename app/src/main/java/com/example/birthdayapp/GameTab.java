package com.example.birthdayapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class GameTab extends Fragment implements View.OnClickListener {

    private ImageButton imgBtnDiceApp, imgBtnLionOrTiger, imgBtnQuizApp;

    public GameTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_tab, container, false);

        imgBtnDiceApp = view.findViewById(R.id.imgBtnDiceApp);
        imgBtnLionOrTiger = view.findViewById(R.id.imgBtnSportsSpeakerApp);
        imgBtnQuizApp = view.findViewById(R.id.imgBtnQuizApp);

        imgBtnDiceApp.setOnClickListener(this);
        imgBtnLionOrTiger.setOnClickListener(this);
        imgBtnQuizApp.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())  {
            case R.id.imgBtnQuizApp:
                transitionToQuizApp();
                break;
           case R.id.imgBtnDiceApp:
                transitionToDiceApp();
                break;
           case R.id.imgBtnSportsSpeakerApp:
               transitionToSportsSpeakerApp();
                break;
        }

    }

    private void transitionToQuizApp() {
        Intent intent = new Intent(getActivity(), OuizApp.class);
        startActivity(intent);
    }

    private void transitionToDiceApp() {
        Intent intent = new Intent(getActivity(), DiceApp.class);
        startActivity(intent);
    }

    private void transitionToSportsSpeakerApp() {
        Intent intent = new Intent(getActivity(), DiceApp.class);
        startActivity(intent);
    }

    }


