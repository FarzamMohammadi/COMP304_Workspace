package Exercise02;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farzammohammadi_comp304sec002_lab03.R;

public class FarzamMohammadi_COMP304Sec002_Lab03_Ex02 extends AppCompatActivity {

    private AnimationDrawable _frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farzam_exercise02);

        // add event handlers
        findViewById(R.id.startAnimBtn).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                FarzamMohammadi_COMP304Sec002_Lab03_Ex02.this._startAnimation();
            }
        });

        findViewById(R.id.stopAnimBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FarzamMohammadi_COMP304Sec002_Lab03_Ex02.this._stopAnimation();
            }
        });
    }

    // helper methods
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void _startAnimation() {
        ImageView imgView = findViewById(R.id.imageViewForAnimation);
        Drawable[] frames = new Drawable[8];
        frames[0] = getDrawable(R.drawable.frame1);
        frames[1] = getDrawable(R.drawable.frame2);
        frames[2] = getDrawable(R.drawable.frame3);
        frames[3] = getDrawable(R.drawable.frame4);
        frames[4] = getDrawable(R.drawable.frame5);
        frames[5] = getDrawable(R.drawable.frame6);
        frames[6] = getDrawable(R.drawable.frame8);
        frames[7] = getDrawable(R.drawable.frame9);

        this._frameAnimation = new AnimationDrawable();
        // infinitely loop
        this._frameAnimation.setOneShot(false);

        //add all frames to animation
        for (Drawable frame : frames) {
            this._frameAnimation.addFrame(frame, getResources().getInteger(R.integer.animation_duration));
        }

        imgView.setBackgroundDrawable(this._frameAnimation);
        this._frameAnimation.start();
        Toast.makeText(this, getResources().getString(R.string.starting_anim_txt), Toast.LENGTH_SHORT).show();
    }

    private void _stopAnimation() {
        this._frameAnimation.stop();
        Toast.makeText(this, getResources().getString(R.string.stopping_anim_txt), Toast.LENGTH_SHORT).show();
    }
}