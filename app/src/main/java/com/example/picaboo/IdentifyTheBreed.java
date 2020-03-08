package com.example.picaboo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class IdentifyTheBreed extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"chihuahua", "chihuahua", "japanese_spaniel"};
    private static final String[] breeds = {"chihuahua","japanese_spaniel"};
//            ,"Maltese_dog","Pekinese","Shih-Tzu",
//            "Blenheim_spaniel","papillon","toy_terrier","Rhodesian_ridgeback","Afghan_hound","basset","beagle","bloodhound",
//            "bluetick","black-and-tan_coonhound"};

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        IdentifyTheBreed.image = image;
    }

    private static  String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_breed);
        ImageView iv = (ImageView)findViewById(R.id.imgRandom);
       image = breeds[(int) (Math.random()*2)];
        String imageName = image+"_"+(int) (Math.random()*10);
        int id = getResources().getIdentifier(imageName,"drawable",getPackageName());
        System.out.println("----------------------"+imageName+"----------"+R.drawable.n02085620_199+"--------"+id);
        iv.setImageResource(id);


        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(IdentifyTheBreed.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }


    public void submitAnswer(View view) {

        Spinner spinner = findViewById(R.id.spinner);
        String fruit = String.valueOf(spinner.getSelectedItem());
        if(fruit.contentEquals(image)) {
            openCorrectDialog();
            System.out.println("########Correct########" + fruit);
            changeButtton();
        }
        else {
            openWrongDialog(image);
            changeButtton();
        }
    }
    public void changeButtton(){
        Button p1_button = findViewById(R.id.button2);

        p1_button.setText("Next");



        p1_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recreate();
            }
        });
//        p1_button.callOnClick();
    }

    private void openWrongDialog(String image) {
        Context context = this;

        TextView titleView = new TextView(context);
        titleView.setText("Wrong :(");
        titleView.setGravity(Gravity.CENTER);
        titleView.setPadding(20, 20, 20, 20);
        titleView.setTextSize(20F);
        titleView.setTypeface(Typeface.DEFAULT_BOLD);
//        titleView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
        titleView.setTextColor(ContextCompat.getColor(context, R.color.wrong));

        AnswerDialog dialog = new AnswerDialog();
//        dialog.setTitle("Wrong :)");
        dialog.setMessage("The correct answer is :"+image);
        dialog.show(getSupportFragmentManager(),"wrong");
        dialog.setTextView(titleView);

    }

    private void openCorrectDialog() {
        Context context = this;


        TextView titleView = new TextView(context);
        titleView.setText("Correct :) ");
        titleView.setGravity(Gravity.CENTER);
        titleView.setPadding(20, 20, 20, 20);
        titleView.setTextSize(20F);
        titleView.setTypeface(Typeface.DEFAULT_BOLD);
        titleView.setTextColor(ContextCompat.getColor(context, R.color.correct));


        AnswerDialog dialog = new AnswerDialog();
    dialog.setMessage("Good Job");
    dialog.setTextView(titleView);
        dialog.show(getSupportFragmentManager(),"corrrect");
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}
