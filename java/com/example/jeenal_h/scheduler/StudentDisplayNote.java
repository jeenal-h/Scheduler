package com.example.jeenal_h.scheduler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StudentDisplayNote extends AppCompatActivity {
    private StudentNDb mydb;
    EditText name;
    EditText content;
    private CoordinatorLayout coordinatorLayout;
    String dateString;
    Bundle extras;
    int id_To_Update = 0;
    Snackbar snackbar;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_viewnotepad);

        name = (EditText) findViewById(R.id.txtname);
        content = (EditText)findViewById(R.id.txt_content);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mydb = new StudentNDb(this);
        builder = new AlertDialog.Builder(this);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                snackbar = Snackbar
                        .make(coordinatorLayout, "Note Id : "+String.valueOf(Value), Snackbar.LENGTH_LONG);
                snackbar.show();
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();
                String nam = rs.getString(rs.getColumnIndex(StudentNDb.name));
                String contents = rs.getString(rs.getColumnIndex(StudentNDb.remark));
                if (!rs.isClosed()) {
                    rs.close();
                }
                name.setText((CharSequence) nam);
                content.setText((CharSequence) contents);
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            getMenuInflater().inflate(R.menu.display_menu, menu);
        }
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.Delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.notepad_lv_popup_menu_i2).setTitle(R.string.notepad_lv_popup_menu_i2);
                builder.setMessage(R.string.DeleteNote)
                        .setCancelable(false)
                        .setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        mydb.deleteNotes(id_To_Update);
                                        Toast.makeText(StudentDisplayNote.this, "Deleted Successfully",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(
                                                getApplicationContext(),
                                                StudentNotes.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                        .setNegativeButton("NO",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();
                return true;

            case R.id.Save:
                Bundle extras = getIntent().getExtras();
                Calendar c = Calendar.getInstance();
                System.out.println("Current time => " + c.getTime());
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c.getTime());
                dateString = formattedDate;
                if (extras != null) {
                    int Value = extras.getInt("id");
                    if (Value > 0) {
                        if (content.getText().toString().trim().equals("")
                                || name.getText().toString().trim().equals("")) {
                            snackbar = Snackbar
                                    .make(coordinatorLayout, "Please fill in name of the note", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        } else {
                            if (mydb.updateNotes(id_To_Update, name.getText()
                                    .toString(), dateString, content.getText()
                                    .toString())) {
                                snackbar = Snackbar
                                        .make(coordinatorLayout, "Your note Updated Successfully!!!", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            } else {
                                snackbar = Snackbar
                                        .make(coordinatorLayout, "There's an error. That's all I can tell. Sorry!", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        }
                    } else {
                        if (content.getText().toString().trim().equals("")
                                || name.getText().toString().trim().equals("")) {
                            snackbar = Snackbar
                                    .make(coordinatorLayout, "Please fill in name of the note", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        } else {
                            if (mydb.insertNotes(name.getText().toString(), dateString,
                                    content.getText().toString())) {
                                snackbar = Snackbar
                                        .make(coordinatorLayout, "Added Successfully.", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            } else {
                                snackbar = Snackbar
                                        .make(coordinatorLayout, "Unfortunately Task Failed.", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        }
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(),
                StudentNotes.class);
        startActivity(intent);
        finish();
        return;
    }
}
