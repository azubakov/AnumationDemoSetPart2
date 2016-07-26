package tomerbu.edu.animationdemos;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivDroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivDroid = (ImageView) findViewById(R.id.ivDroid);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateDroid();
            }
        });
    }

    private void animateDroid() {
        Animation mySet = AnimationUtils.loadAnimation(this, R.anim.my_set);
        mySet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ivDroid.startAnimation(mySet);

    }

    private void slide() {
        Animation slide = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        ivDroid.startAnimation(slide);
    }

    private void floatIn(){
        Animation floatIn = AnimationUtils.loadAnimation(this, R.anim.float_in);
        ivDroid.startAnimation(floatIn);
    }

    private void swing() {
        //Load the animation: inflate the xml to an animation object:
        Animation swing = AnimationUtils.loadAnimation(this, R.anim.swing);

        //start The animation:
        ivDroid.startAnimation(swing);
    }

    private void fadeOut() {
        //Load the animation: inflate the xml to an animation object:
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        //start The animation:
        ivDroid.startAnimation(fadeOut);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
