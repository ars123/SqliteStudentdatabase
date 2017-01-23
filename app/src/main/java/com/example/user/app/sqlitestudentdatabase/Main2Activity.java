package com.example.user.app.sqlitestudentdatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/*Created by Arun 23-01-2017.
* */

public class Main2Activity extends AppCompatActivity {

    ListView listStudentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listStudentDetails = (ListView)findViewById(R.id.list);
        loadStudentData();


    }

    public  void loadStudentData(){
        StudentDatabaseHelper db = new StudentDatabaseHelper(getApplicationContext());
        List<String> studentDetails = db.getAllStudentDetails();

        ArrayAdapter<String> studentAdapter = new ArrayAdapter<String>(this,R.layout.list_item_student_details,R.id.listText,studentDetails);
        listStudentDetails.setAdapter(studentAdapter);
    }
}
