package com.example.mainactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList taskList = new ArrayList();
    ListView mTaskListView = (ListView) findViewById (R.id.list_todo);
    ArrayAdapter mAdapter = new ArrayAdapter<String>(this, R.layout.todo_item, R.id.list_todo, taskList);


    private void addItem (String itemText){
        taskList.add (itemText);
        mAdapter.notifyDataSetChanged() ;
    }
    private void removeItem (String itemText) {
        taskList.remove (itemText);
        mAdapter.notifyDataSetChanged() ;
    }


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mTaskListView.setAdapter (mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate (R.menu.main_menu, menu);
        return super.onCreateOptionsMenu (menu) ;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                Log.d("MainClass","Add a new task");
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }


     EditText taskEditText = new EditText (this);
     public AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Add a new task").setMessage("What do you want to do next?").setView(taskEditText).setPositiveButton ("Add", new DialogInterface.OnClickListener(){
         private static final String TAG = "TAG";

         @Override
                public void onClick (DialogInterface dialog , int which)
                {
                    String task = String . valueOf ( taskEditText . getText ());
                    Log.d(TAG,"Task to add : " + task) ;
                }
     }).setNegativeButton ("Cancel", null).create();

    public void showDialog(AlertDialog d){
        d.show();
    }

}