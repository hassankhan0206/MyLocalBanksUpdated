package sg.edu.rp.c346.id22019244.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnOne;
    Button btnTwo;
    Button btnThree;

    String wordClicked = "";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnOne.setText(R.string.dbs);
            btnTwo.setText(R.string.ocbc);
            btnThree.setText(R.string.uob);
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnOne.setText(R.string.dbsChi);
            btnTwo.setText(R.string.ocbcChi);
            btnThree.setText(R.string.uobChi);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);

        registerForContextMenu(btnOne);
        registerForContextMenu(btnTwo);
        registerForContextMenu(btnThree);







    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact The Bank");

        if (v == btnOne)
        {
            wordClicked = "dbs";
        }else if (v == btnTwo)
        {
            wordClicked = "ocbc";
        }else if (v == btnThree)
        {
            wordClicked = "uob";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tele)+1800111111));
                startActivity(intentcall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc"))
        {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tele)+1800363333));
                startActivity(intentcall);
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("uob"))
        {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tele)+1800222212));
                startActivity(intentcall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }








}