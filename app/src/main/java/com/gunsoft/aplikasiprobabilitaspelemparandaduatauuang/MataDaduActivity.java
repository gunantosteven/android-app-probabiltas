package com.gunsoft.aplikasiprobabilitaspelemparandaduatauuang;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MataDaduActivity extends ActionBarActivity {

    TextView hasilOutput;
    EditText editTextbanyakLemparan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mata_dadu);
        setTitle("Probabilitas Mata Dadu");

        hasilOutput = (TextView) findViewById(R.id.textViewHasil);
        editTextbanyakLemparan = (EditText) findViewById(R.id.editTextInputBanyakPelemparan);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mata_dadu, menu);
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

    public void proses(View view)
    {
        int banyakLemparan = Integer.parseInt(editTextbanyakLemparan.getText().toString());
        int[] totaldadu = new int[6];
        hasilOutput.setText("Hasil : \n");
        for(int i = 0; banyakLemparan > i; i++)
        {
            int pertama = randomMataDadu();
            int kedua = randomMataDadu();
            totaldadu[pertama]++;
            totaldadu[kedua]++;

            hasilOutput.append((i+1) + ") \t" +
                    (pertama+1) + " " +
                    (kedua+1) + "\n");
        }

        for(int i = 0; 6 > i; i++)
        {
            hasilOutput.append("Total Angka Dadu " + (i+1) + " : " + totaldadu[i] + "\n");
        }

        hasilOutput.append("\nJadi peluang muncul : \n");

        for(int i = 0; 6 > i; i++)
        {
            hasilOutput.append("Dadu " + (i+1) + " = " + round((((double) totaldadu[i] / (banyakLemparan * 2)) * 100.0), 0) + "%\n");
        }
    }

    public Integer randomMataDadu() // Dari 0 sampai 5
    {
        return (int) (Math.random() * 6);

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
