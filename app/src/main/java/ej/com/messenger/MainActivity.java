package ej.com.messenger;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ej.com.messenger.utils.DataHolder;
import ej.com.messenger.utils.MyAdapter;
import ej.com.messages.R;

import static android.view.View.*;

/**
 * Created by 3mill on 2015-05-11.
 */
public class MainActivity extends Activity implements OnClickListener {

    private RecyclerView messageView;
    private Button sendButton;
    private TextView titleText;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();
        prepareData();


    }

    private void viewSetup() {
        sendButton = (Button)findViewById(R.id.sendButton);
        messageView = (RecyclerView)findViewById(R.id.messageView);
        titleText = (TextView)findViewById(R.id.titleText);
        sendButton.setOnClickListener(this);
    }

    private void prepareData() {
        titleText.setText("Witaj, "+DataHolder.getInstance().getPojo().getName());
        MyAdapter myAdapter = new MyAdapter(DataHolder.getInstance().getPojo().getMessages(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        messageView.setLayoutManager(layoutManager);
        messageView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View view) {
        AddActivity.start(this);
    }
}
