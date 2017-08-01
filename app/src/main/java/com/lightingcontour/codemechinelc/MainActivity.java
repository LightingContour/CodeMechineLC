package com.lightingcontour.codemechinelc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    View title;//标题文字
    View version;//版本文字
    final static String TAG = "MainActivity";
    Toast toast;//使用toastMaker函数进行Toast显示，Toast堆叠.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "还没实装Action哦", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        titleActivity();
    }

    //主界面的方法
    private void titleActivity()
    {
        titleclick();//封装的标题点击事件及其彩蛋.
        //版本点击事件.
        version = findViewById(R.id.version);
        version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorClass.clickAnimator(version);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this,WorkActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void titleclick()
    {
        title = findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            long[] mHints = new long[9];
            @Override
            public void onClick(View v) {
                AnimatorClass.clickAnimator(title);
                //将mHints数组内的所有元素左移一个位置.
                System.arraycopy(mHints,1,mHints,0,mHints.length -1);
                //获取当前系统时间.
                mHints[mHints.length - 1] = SystemClock.uptimeMillis();
                Log.i(TAG,"已点击!");

                toastMaker(MainActivity.this,mHints[0] + "  ***  " + SystemClock.uptimeMillis(),Toast.LENGTH_SHORT);

                if (SystemClock.uptimeMillis() - mHints[0] <= 3000)
                {
                    toastMaker(MainActivity.this,"实现！",Toast.LENGTH_SHORT);
                    easterEgg();//title点击9次彩蛋.
                }
            }
        });
    }

    //与Toast原使用方法相同，目的为防止Toast堆叠.
    private void toastMaker(Context context, String msg,int duration){
        if (toast != null)
        {
            toast.setText(msg);
            toast.setDuration(duration);
        }else {
            toast = Toast.makeText(context,msg,duration);
        }
        toast.show();
    }

    //title点击9次触发彩蛋.
    private void easterEgg()
    {

    }
}
