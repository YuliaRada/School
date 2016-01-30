package com.softdesign.school;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
    * Creates a key-value for saving sets
     */
    public static final String VISIBLE_KEY = "visible";
    public static final String TOOLBAR_COLOR_KEY = "toolBarColorKey";
    public static final String STATUSBAR_COLOR_KEY = "statusBarColorKey";

    /**
    * Declare a variable for setting colors
     */
    public static int newToolBarColor =R.color.colorPrimary;
    public static int newStatusBarColor =R.color.colorPrimaryDark;

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolBar;
    Button mBlue;
    Button mGreen;
    Button mRed;

    /**
     *
     * Use @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * Send a log message to split log
 */
        Lg.e(this.getLocalClassName(), "=======================");

        setTitle("School lesson 1");

        Lg.e(this.getLocalClassName(), "on create");

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);
        mEditText = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRed = (Button) findViewById(R.id.btn_red);
        mGreen = (Button) findViewById(R.id.btn_green);
        mBlue = (Button) findViewById(R.id.btn_blue);
        mRed.setOnClickListener(this);
        mGreen.setOnClickListener(this);
        mBlue.setOnClickListener(this);

        setupToolbar();
        }

    /**
     * Setup tool bar with icon menu
     */
    private void setupToolbar(){
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Create a toast message by click on icon
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Toast.makeText(this, "Menu click", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * OnClickListener for CheckBox and buttons
     * @param v
     *
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()){
                mEditText2.setVisibility(View.INVISIBLE);
                }else{
                mEditText2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_blue:
                newToolBarColor = R.color.blue;
                newStatusBarColor = R.color.dark_blue;
                break;
            case R.id.btn_green:
                newToolBarColor = R.color.green;
                newStatusBarColor = R.color.dark_green;
                break;
            case R.id.btn_red:
                newToolBarColor = R.color.red;
                newStatusBarColor = R.color.dark_red;
                break;
        }
        /**
         * Sets color of tool bars background
         */
        mToolBar.setBackgroundResource(newToolBarColor);

        /**
         * Sets status bar color and check the build version for support status bar
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(newStatusBarColor));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on destroy");
    }

    /**
     * Saves instance state in Bundle (visibility of EditText, changing tool bars and status bars colors)
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "on save instance state");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
        outState.putInt(TOOLBAR_COLOR_KEY, mToolBar.getResources().getColor(newToolBarColor));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            outState.putInt(STATUSBAR_COLOR_KEY, window.getStatusBarColor());
        }
        }

    /**
     * Recreating the saved data in Activity
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on restore instance state");
        int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        mEditText.setVisibility(visibleState);
        mToolBar.setBackgroundColor(savedInstanceState.getInt(TOOLBAR_COLOR_KEY, R.color.colorPrimary));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(savedInstanceState.getInt(STATUSBAR_COLOR_KEY, R.color.colorPrimaryDark));
        }
    }
}
