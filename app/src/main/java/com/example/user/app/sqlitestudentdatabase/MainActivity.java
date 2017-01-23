package com.example.user.app.sqlitestudentdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/*Created by Arun 23-01-2017.
* */

public class MainActivity extends AppCompatActivity {

    EditText editFirstName,editLastName,editTeacherName,editRollNo;
    String firstName,lastName,teacherName,rollNumber;
    Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                firstName = editFirstName.getText().toString();
                lastName = editLastName.getText().toString();
                teacherName = editTeacherName.getText().toString();
                rollNumber = editRollNo.getText().toString();

                StudentDatabaseHelper db = new StudentDatabaseHelper(getApplicationContext());
                db.insertStudentInfo(firstName,lastName,teacherName,rollNumber);
                Toast.makeText(MainActivity.this, "Student data is successfully stored", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

   void init(){
        editFirstName = (EditText)findViewById(R.id.firstName);
        editLastName = (EditText)findViewById(R.id.lastName);
        editTeacherName= (EditText)findViewById(R.id.teacherName);
        editRollNo = (EditText)findViewById(R.id.rollNum);
        saveBtn = (Button)findViewById(R.id.saveBtn);


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
