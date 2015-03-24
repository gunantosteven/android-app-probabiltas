package com.gunsoft.aplikasiprobabilitaspelemparandaduatauuang;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MataUangActivity extends ActionBarActivity {

    TextView hasilOutput;
    EditText editTextbanyakLemparan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mata_uang);
        setTitle("Probabilitas Mata Uang");

        hasilOutput = (TextView) findViewById(R.id.textViewHasil);
        editTextbanyakLemparan = (EditText) findViewById(R.id.editTextInputBanyakPelemparan);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mata_uang, menu);
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
        int totalGambar = 0;
        int totalAngka = 0;
        hasilOutput.setText("Hasil : \n");
        for(int i = 0; banyakLemparan > i; i++)
        {
            String pertama = randomMataUang();
            String kedua = randomMataUang();
            if(pertama.equals("G"))
            {
                totalGambar++;
            }
            else
            {
                totalAngka++;
            }

            if(kedua.equals("G"))
            {
                totalGambar++;
            }
            else
            {
                totalAngka++;
            }

            hasilOutput.append((i+1) + ") \t" +
                    pertama + " " +
                    kedua + "\n");
        }

        hasilOutput.append("Total Gambar : " + totalGambar + ", Total Angka : " + totalAngka + "\n\n");

        hasilOutput.append("Jadi peluang muncul : \n");

        hasilOutput.append("gambar " + round((((double) totalGambar / (banyakLemparan * 2)) * 100.0), 0) + "%\n");

        hasilOutput.append("angka " + round((((double) totalAngka / (banyakLemparan * 2)) * 100.0), 0) + "%\n");
    }

    public String randomMataUang()
    {
        Integer i = (int) (Math.random() * 2);
        if(i == 0)
        {
            return "G";
        }
        else
        {
            return "A";
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
