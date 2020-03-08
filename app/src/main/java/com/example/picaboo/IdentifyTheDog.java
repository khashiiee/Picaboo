package com.example.picaboo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IdentifyTheDog extends AppCompatActivity {

    private static final String[] breeds = {"chihuahua","maltese_dog","japanese_spaniel","pekinese","shih_tzu","blenheim_spaniel","papillon"};
//           ,"Maltese_dog","Pekinese","Shih-Tzu",
//            "Blenheim_spaniel","papillon","toy_terrier","Rhodesian_ridgeback","Afghan_hound","basset","beagle","bloodhound",
//            "bluetick","black-and-tan_coonhound"};


    private String breedName;

    private String answer_1;
    private String fanswer_1;
    private String fanswer_2;
    private String fanswer_3;
    private  String answer_2;

    private ImageView a_1;
    private ImageView a_2;
    private ImageView a_3;

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public ImageView getA_1() {
        return a_1;
    }

    public void setA_1(ImageView a_1) {
        this.a_1 = a_1;
    }

    public ImageView getA_2() {
        return a_2;
    }

    public void setA_2(ImageView a_2) {
        this.a_2 = a_2;
    }

    public ImageView getA_3() {
        return a_3;
    }

    public void setA_3(ImageView a_3) {
        this.a_3 = a_3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int breedIndex = (int) (Math.random()*6);
        breedName = breeds[breedIndex];
       int  answer1 = getRandomExcluding(breedIndex,6);
        int  answer2 = getRandomExcluding(breedIndex, answer1,6);
        answer_1 = breeds[answer1];
        answer_2 = breeds[answer2];
        String[] ans = {breedName,answer_1,answer_2};
        setContentView(R.layout.activity_identify_the_dog);

        TextView breed = (TextView)findViewById(R.id.breedLabel);
        breed.setText(breedName);


        a_1 = (ImageView)findViewById(R.id.answer_1);
        a_2 = (ImageView)findViewById(R.id.answer_2);
        a_3 = (ImageView)findViewById(R.id.answer_3);

int setImage1 = (int) (Math.random()*3);
int setImage2 = getRandomExcluding(setImage1,3);
int setImage3 = getRandomExcluding(setImage1,setImage2,3);

int imgid = (int) (Math.random()*6);
int imgid2 = getRandomExcluding(imgid,6);
int imgid3 = getRandomExcluding(imgid,imgid2,6);

        fanswer_1 = ans[setImage1];
        fanswer_2 = ans[setImage2];
        fanswer_3 = ans[setImage3];

        String imageName1 = fanswer_1+"_"+imgid;
        String imageName2 = fanswer_2+"_"+imgid2;
        String imageName3 = fanswer_3+"_"+imgid3;

        int id1 = getResources().getIdentifier(imageName1,"mipmap",getPackageName());
        int id2 = getResources().getIdentifier(imageName2,"mipmap",getPackageName());
        int id3 = getResources().getIdentifier(imageName3,"mipmap",getPackageName());

        System.out.println("----------------------"+imageName1+"----"+imageName2+"-----"+imageName3+"----"+R.mipmap.chihuahua_0+"--------");
        System.out.println("^^^^^^^^^^^^^^^^^^^^"+answer1+"---"+answer2+"setImage1");
        a_1.setImageResource(id1);
        a_1.setContentDescription(fanswer_1);
        a_2.setImageResource(id2);
        a_2.setContentDescription(fanswer_2);
        a_3.setImageResource(id3);
        a_3.setContentDescription(fanswer_3);





    }

    public void checkTheAnswer(View view){

        ImageView img = (ImageView)findViewById(view.getId());
        String des = (String) img.getContentDescription();


        if(breedName.contentEquals(des)){
    System.out.println("Finalluyyyyyyyyyyyyyyyyyyyyyyyyy");
}

        System.out.println("--------------"+des+"--------------");
    }





    private  int getRandomExcluding(int excludedNumber1, int excludedNumber2,int limit){



        int num;

        do{
            num = (int) (Math.random()*limit);

            do {
                num = (int) (Math.random()*limit);

            }while(num == excludedNumber2);

        }while(num==excludedNumber1);
        return num;
    }

    private int getRandomExcluding(int excludedNumber1,int limit){
        int num;

        do{
            num = (int) (Math.random()*limit);


        }while(num==excludedNumber1);
        return num;
    }
}
