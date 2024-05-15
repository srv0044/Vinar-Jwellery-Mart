package com.codewithsrv.vj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Activity_Manage_Account extends AppCompatActivity {

    Button updateBtn;
    EditText firstName,middleName,lastName,password,mobile,email,gender,address1,address2;
    String firstNameTxt,middleNameTxt,lastNameTxt,passwordTxt,mobileTxt,emailTxt,address1Txt,address2Txt;
    RadioGroup male,female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        updateBtn=findViewById(R.id.upd_btn) ;

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Manage_Account.this,SettingFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}