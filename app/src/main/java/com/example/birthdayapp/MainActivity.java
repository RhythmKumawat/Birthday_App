package com.example.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtAge;
    private Button btnHaveFun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnHaveFun = findViewById(R.id.btnHaveFun);

       ParseInstallation.getCurrentInstallation().saveInBackground();

        btnHaveFun.setOnClickListener(MainActivity.this);

         if (ParseUser.getCurrentUser() != null) {
            //ParseUser.getCurrentUser().logOut();
            transitionToNewLayoutActivity();
        }

    }

    @Override
    public void onClick(View v) {

//       try {

        final ParseObject BirthdayLogin = new ParseObject("BirthdayLogin");
        BirthdayLogin.put("name", edtName.getText().toString());
        BirthdayLogin.put("age", Integer.parseInt(edtAge.getText().toString()));

            final AlertDialog dialog =  new SpotsDialog.Builder()

                                   .setContext(this)
                                   .setTheme(R.style.Custom)
                                   .build();
                                   dialog.show();

        BirthdayLogin.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    FancyToast.makeText(MainActivity.this,
                            "Happy Birthday " + edtName.getText().toString(),
                            FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                    transitionToNewLayoutActivity();
                } else {
                    FancyToast.makeText(MainActivity.this,
                            e.getMessage(), FancyToast.LENGTH_LONG,
                            FancyToast.ERROR, false).show();
                }

//                dialog.dismiss();

            }

        });

//        }catch (Exception e) {
//            FancyToast.makeText(MainActivity.this,
//                    e.getMessage(), FancyToast.LENGTH_LONG,
//                    FancyToast.ERROR, false);
//        }

//    }

    }

        private void transitionToNewLayoutActivity () {
            Intent intent = new Intent(MainActivity.this, newLayout.class);
            startActivity(intent);
        }


}
