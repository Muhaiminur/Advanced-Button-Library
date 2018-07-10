package com.muhaiminurabir.buttonlibrary;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.basel.DualButton.DualButton;
import com.ebanx.swipebtn.OnActiveListener;
import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.emrekose.recordbutton.OnRecordListener;
import com.emrekose.recordbutton.RecordButton;

import org.jetbrains.annotations.NotNull;

import in.shadowfax.proswipebutton.ProSwipeButton;
import io.ghyeok.stickyswitch.widget.StickySwitch;

public class Button_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        //Swipe Button
        final ProSwipeButton proSwipeBtn = (ProSwipeButton) findViewById(R.id.awesome_btn);
        proSwipeBtn.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                // user has swiped the btn. Perform your async operation now
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // task success! show TICK icon in ProSwipeButton
                        proSwipeBtn.showResultIcon(true); // false if task failed
                    }
                }, 2000);
            }
        });
        //Dual Button
        DualButton dualBtn = findViewById(R.id.dualBtn);
        dualBtn.setDualClickListener(new DualButton.OnDualClickListener() {
            public void onClickFirst(Button btn) {
                //first btn has been clicked
            }
            public void onClickSecond(Button btn) {
                //second btn has been clicked
            }
        });
        //circle
        RecordButton recordButton = (RecordButton) findViewById(R.id.recordBtn);

        recordButton.setRecordListener(new OnRecordListener() {
            @Override
            public void onRecord() {
                //Toast.makeText(getApplicationContext(), "onRecord:", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRecordCancel() {
                //Toast.makeText(getApplicationContext(), "onRecordCancel", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRecordFinish() {
                Toast.makeText(getApplicationContext(), "onRecordFinish", Toast.LENGTH_LONG).show();
            }
        });
        //switch button
        //https://android-arsenal.com/details/1/5433
        StickySwitch stickySwitch = (StickySwitch) findViewById(R.id.sticky_switch);
        stickySwitch.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
            @Override
            public void onSelectedChange(@NotNull StickySwitch.Direction direction, @NotNull String text) {
                Toast.makeText(getApplicationContext(), "Switching Finish"+text, Toast.LENGTH_SHORT).show();
            }
        });

        //Swipe with logo
        SwipeButton enableButton = (SwipeButton) findViewById(R.id.swipe_btn);
        enableButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                Toast.makeText(Button_Activity.this, "State: " + active, Toast.LENGTH_SHORT).show();
            }
        });
        /*swipeButtonNoState.setOnActiveListener(new OnActiveListener() {
            @Override
            public void onActive() {
                Toast.makeText(MainActivity.this, "Active!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
