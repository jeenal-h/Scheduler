package com.example.jeenal_h.scheduler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class TeacherNotes extends AppCompatActivity {

    private ListView obj;
    TeacherNDb mydb;
    FloatingActionButton btnadd;
    ListView mylist;
    Menu menu;
    MenuItem item;
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    Context context = this;
    CoordinatorLayout coordinatorLayout;
    SimpleCursorAdapter adapter;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_notedisplay);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mydb = new TeacherNDb(this);
        btnadd = (FloatingActionButton) findViewById(R.id.add_note);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Intent intent = new Intent(getApplicationContext(),
                        TeacherDisplayNote.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
            }
        });

        Cursor c = mydb.fetchAll();
        String[] fieldNames = new String[]{TeacherNDb.name, TeacherNDb._id, TeacherNDb.dates, TeacherNDb.remark};
        int[] display = new int[]{R.id.txtnamerow, R.id.txtidrow,
                R.id.txtdate, R.id.txtremark};
        adapter = new SimpleCursorAdapter(this, R.layout.teacher_listtemplate, c, fieldNames,
                display, 0);
        snackbar = Snackbar
                .make(coordinatorLayout, "Click on the button with a plus sign to write a note!", Snackbar.LENGTH_LONG);
        snackbar.show();
        mylist = (ListView) findViewById(R.id.listView1);
        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                LinearLayout linearLayoutParent = (LinearLayout) arg1;
                LinearLayout linearLayoutChild = (LinearLayout) linearLayoutParent
                        .getChildAt(0);
                TextView m = (TextView) linearLayoutChild.getChildAt(1);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id",
                        Integer.parseInt(m.getText().toString()));
                Intent intent = new Intent(getApplicationContext(),
                        TeacherDisplayNote.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
            }
        });

        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    PopupMenu popup = new PopupMenu(TeacherNotes.this, mylist);
                    popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) TeacherNotes.this);
                    popup.getMenuInflater().inflate(R.menu.notepad_lv_popup_menu,popup.getMenu());
                    popup.show();
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.add:
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Intent intent = new Intent(getApplicationContext(),
                        TeacherDisplayNote.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.rename_item:
                // do your code
                return true;
            case R.id.delete_item:
                // do your code
                return true;
            default:
                return false;
        }
    }

}
