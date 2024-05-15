package com.codewithsrv.vj;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    View view;
    TextView accounttv,contacttv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.fragment_setting,container,false);

        accounttv=(TextView) view.findViewById(R.id.user_profile_account);
        contacttv=(TextView) view.findViewById(R.id.user_profile_contact);

        accounttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Activity_Manage_Account.class);
                startActivity(intent);
            }
        });

        contacttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Activity_Contact_Us.class);
                startActivity(intent);
            }
        });
        return view;
    }
}