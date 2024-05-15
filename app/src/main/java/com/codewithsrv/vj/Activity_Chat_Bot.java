package com.codewithsrv.vj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_Chat_Bot extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    ImageView imageView;
    ArrayList<Chatmodal> chatmodalArrayList;
    ChatAdapter chatAdapter;
    private final String USER_KEY = "user";
    private final String BOT_KEY = "bot";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        recyclerView = findViewById(R.id.chat_recycler);
        editText = findViewById(R.id.edt_msg);
        imageView = findViewById(R.id.send_btn);
        chatmodalArrayList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatmodalArrayList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter((chatAdapter));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().isEmpty()) {
                    Toast.makeText(Activity_Chat_Bot.this,"Please enter your message",Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(editText.getText().toString());
                editText.setText(" ");
            }
        });


    }

    private void getResponse(String message) {
        chatmodalArrayList.add(new Chatmodal(message,USER_KEY));
        chatAdapter.notifyDataSetChanged();
        String url= "http://api.brainshop.ai/get?bid=165179&key=vZjUZT4YgZq6L2sM&uid=[uid]&msg="+message;
        String BASE_URL = "https://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetroFitApi retroFitApi = retrofit.create(RetroFitApi.class);
        Call<MsgModal> call = retroFitApi.getMessage(url);
        call.enqueue(new Callback<MsgModal>() {
            @Override
            public void onResponse(Call<MsgModal> call, Response<MsgModal> response) {
                if(response.isSuccessful()){
                    MsgModal msgModal = response.body();
                    chatmodalArrayList.add(new Chatmodal(msgModal.getCnt(),BOT_KEY));
                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(chatmodalArrayList.size()-1);
                }
            }

            @Override
            public void onFailure(Call<MsgModal> call, Throwable t) {
                chatmodalArrayList.add(new Chatmodal("no response",BOT_KEY));
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
}