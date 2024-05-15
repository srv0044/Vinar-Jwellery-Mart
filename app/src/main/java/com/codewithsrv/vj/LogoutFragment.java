package com.codewithsrv.vj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LogoutFragment extends Fragment {
    View view;
    Button logout;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_logout, container, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirm LogOut?");
        builder.setMessage("Are you sure you want to LogOut?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logOutUser();
                    }
                }).setNegativeButton("Cancel",null);
        AlertDialog alert = builder.create();
        alert.show();

        return view;
    }
    private void logOutUser()
    {
        Intent logOutFragment = new Intent(getActivity(),Activity_Splash_Login.class);
        logOutFragment.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logOutFragment);
        getActivity().finish();
    }

}