package com.gunsoft.aplikasiprobabilitaspelemparandaduatauuang;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MenuActivity extends ActionBarActivity {

    ImageButton imageButtonMataUang, imageButtonMataDadu;
    Button buttonClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Probabilitas Uang dan Dadu");

        imageButtonMataUang = (ImageButton) findViewById(R.id.imageButtonMataUang);
        imageButtonMataDadu = (ImageButton) findViewById(R.id.imageButtonMataDadu);
        buttonClose = (Button) findViewById(R.id.btnClose);

        addListenerImageButtonMataUang();
        addListenerImageButtonMataDadu();
        addListenerButtonClose();
    }

    public void addListenerImageButtonMataUang()
    {
        imageButtonMataUang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MataUangActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerImageButtonMataDadu()
    {
        imageButtonMataDadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MataDaduActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerButtonClose()
    {
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
