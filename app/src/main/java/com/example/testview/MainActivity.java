package com.example.testview;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Bundle;
import android.app.AlertDialog;


public class MainActivity extends AppCompatActivity {
    Button btnCancel, btnInfo;
    CheckBox chkCoding, chkReading, chkTravelling;
    RadioButton rdMale = (RadioButton) findViewById(R.id.rdMale), rdFemale;
    EditText editName, editEmail;
    Spinner spinLang;
    Switch switchExpert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCancel =  (Button)findViewById(R.id.btnCancel);
        btnInfo =  (Button)findViewById(R.id.btnInfo);
        editName =  (EditText)findViewById(R.id.editName);
        editEmail =  (EditText)findViewById(R.id.editEmail);
        chkCoding =  (CheckBox) findViewById(R.id.chkCoding);
        chkReading =  (CheckBox) findViewById(R.id.chkReading);
        chkTravelling =  (CheckBox) findViewById(R.id.chkTravelling);
        rdFemale =  (RadioButton) findViewById(R.id.rdFemale);
        spinLang =  (Spinner) findViewById(R.id.entries);
        switchExpert =  (Switch) findViewById(R.id.switchExpert);
    }

    public void cancel(View v){
        System.exit(0);
    }
    public void onClick(View v) {
        // nội dung thực thi
        String msg = "My name: " + editName.getText().toString() +
                System.getProperty("line.separator") +
                "Email: " + editEmail.getText().toString();
        msg += System.getProperty("line.separator") + "My hobbies: ";
        if(chkCoding.isChecked())
            msg +=  chkCoding.getText().toString()+ ", ";
        if(chkReading.isChecked())
            msg += chkReading.getText().toString() + ", ";
        if(chkTravelling.isChecked())
            msg += chkTravelling.getText().toString()+ ", ";
        msg += System.getProperty("line.separator") + "My Sex: ";
        if(rdFemale.isChecked())
            msg += rdFemale.getText().toString();
        if(rdMale.isChecked())
            msg += rdMale.getText().toString();
        msg += System.getProperty("line.separator") + "My language: " + spinLang.getSelectedItem().toString();
        msg += System.getProperty("line.separator") + "Do you have experience with Jave frameworks: ";
        if(switchExpert.isChecked())
            msg += "Yes";
        else
            msg += "No";
        info(v,msg);
        editName.setText("");
        editEmail.setText("");
        chkCoding.setChecked(false);
        chkReading.setChecked(false);
        chkTravelling.setChecked(false);
        rdFemale.setChecked(false);
        rdMale.setChecked(false);
    }

    public void info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("My First App");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}