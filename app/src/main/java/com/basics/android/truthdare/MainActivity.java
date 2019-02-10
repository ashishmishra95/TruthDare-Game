package com.basics.android.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ImageView img;
    private Random random = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =findViewById(R.id.button2);
        img =findViewById(R.id.imageView);

    }

    public void spin(View view){

//        To make rotation of object we use Animation methods
        int newDirection = random.nextInt(10000);//Random number to generate the direction for newDirection
        float pivotX = img.getWidth()/2;//pivot are used to define at which axis we want to rotate the object
        float pivotY = img.getHeight()/2;
        // RotateAnimation method requires 4 directions/parameter to rotate the object (lastDirection by default or Starting direction)
        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);//To keep the animation working on
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btn.setEnabled(false);
                btn.setBackgroundResource(R.drawable.disabled_button);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn.setEnabled(true);
                btn.setBackgroundResource(R.drawable.new_button);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection = newDirection;
        img.startAnimation(rotate);

    }
}
