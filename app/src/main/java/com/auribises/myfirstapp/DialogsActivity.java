package com.auribises.myfirstapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogsActivity extends AppCompatActivity {

    void showAlertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is Title");
        builder.setMessage("This is Message");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogsActivity.this,"You Clicked OK",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false); // Now Dialog will not be destroyed if you press the back key
        dialog.show();
    }

    void showProgressDialog(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait...");
        dialog.setCancelable(false); // Now Dialog will not be destroyed if you press the back key
        dialog.show();

        // dialog.dismiss();
    }

    void showDialogWithOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"View","Update","Delete","Cancel"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Toast.makeText(DialogsActivity.this,"You Selected View",Toast.LENGTH_LONG).show();
                        break;

                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:
                        finish();
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    Button btnCancel;

    void customDialog(){

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        btnCancel = dialog.findViewById(R.id.button5);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialog.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }

    public void clickHandler(View view){
        //showAlertDialog();
        //showProgressDialog();
        //showDialogWithOptions();
        customDialog();
    }
}
