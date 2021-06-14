package com.isaacinfrastructure.kdratiocalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class HomeActivity extends AppCompatActivity {
    //declaring all the views and buttons

EditText  matches,kills;
Button calculate;
TextView result;
ImageButton reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //hiding the action bar


        //intializing the declared all things by thier id
        matches=findViewById(R.id.matches);
        kills=findViewById(R.id.kills);
        calculate=findViewById(R.id.calculate);
        reset=findViewById(R.id.reset);
        result=findViewById(R.id.Result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to makesure the entered things are not zero
                if(matches.getText().toString().length()==0)
                {
                  matches.setText("0");
                }
                if(kills.getText().toString().length()==0)
                {
                    kills.setText("0");
                }
                //float is used to store those string values because after decimal also no problem Right
                Float v1 = Float.valueOf(matches.getText().toString());
                Float v2 = Float.valueOf(kills.getText().toString());
                Float calculate =v2/v1;
                result.setText(String.valueOf("Your KD is:"+calculate));
                //forcing input method engine to hide keyboard after the click of calculate button
                kills.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if (calculate<=1&&calculate>0){
                    Toast.makeText(getApplicationContext(),"Need To Improve Practice", Toast.LENGTH_LONG).show();
                }
                if (calculate>3)
                {
                    Toast.makeText(getApplicationContext(),"Hacker Bolthe!!!",Toast.LENGTH_LONG).show();
                }
                if(calculate>1&&calculate<=2){
                    Toast.makeText(getApplicationContext(),"GOOD,You are a Semi-Pro",Toast.LENGTH_SHORT).show();
                }
                if (calculate>=2&&calculate<=3)
                {
                    Toast.makeText(getApplicationContext(),"Wow!Thats Impressive PRO!",Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clearing all the inputs after the reset button is clicked
                matches.setText("");
                kills.setText("");
                result.setText("");
            }
        });
        {
            AlertDialog.Builder myalertbuilder= new AlertDialog.Builder(HomeActivity.this);
            myalertbuilder.setTitle("Remember!!!");
            myalertbuilder.setMessage("Your KD depends on How Consistently you take Kills on Each Match");
            myalertbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(HomeActivity.this,"Every Match Counts",Toast.LENGTH_LONG).show();
                }
            });myalertbuilder.show();
        }
    }
}