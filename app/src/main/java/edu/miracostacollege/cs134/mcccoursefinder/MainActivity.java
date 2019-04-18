package edu.miracostacollege.cs134.mcccoursefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import edu.miracostacollege.cs134.mcccoursefinder.model.Course;
import edu.miracostacollege.cs134.mcccoursefinder.model.DBHelper;
import edu.miracostacollege.cs134.mcccoursefinder.model.Instructor;
import edu.miracostacollege.cs134.mcccoursefinder.model.Offering;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private static final String TAG = "MCC Course Finder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importCoursesFromCSV("courses.csv");
        db.importInstructorsFromCSV("instructors.csv");
       // db.importOfferingsFromCSV("offerings.csv");
        //TODO: Create the method importOfferingsFromCSV, then use it in this activity.


        List<Course> allCourses = db.getAllCourses();
        for (Course course : allCourses)
            Log.i(TAG, course.toString());

        List<Instructor> allInstructors = db.getAllInstructors();
        for (Instructor instructor : allInstructors)
            Log.i(TAG, instructor.toString());

        List<Offering> allOfferings = db.getAllOfferings();
        for (Offering offering : allOfferings)
            Log.i(TAG, offering.toString());


        //TODO: Get all the offerings from the database, then print them out to the Log


    }
}
