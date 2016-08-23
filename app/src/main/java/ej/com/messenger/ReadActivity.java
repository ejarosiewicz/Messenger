package ej.com.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ej.com.messenger.model.database.Message;
import ej.com.messages.R;

/**
 * @author Emil Jarosiewicz on 26.04.16.
 */
public class ReadActivity extends Activity {

    private static final String MESSAGE = "MESSAGE";

    TextView sender;
    TextView messageContent;

    public static void start(Context context, Message message) {
        Intent starter = new Intent(context, ReadActivity.class);
        starter.putExtra(MESSAGE, message);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        uiSetup();
        prepareMessage();
    }

    private void uiSetup() {
        sender = (TextView) findViewById(R.id.sender);
        messageContent = (TextView) findViewById(R.id.message);
    }

    private void prepareMessage() {
        Message message = (Message) getIntent().getSerializableExtra(MESSAGE);
        sender.setText(message.getSender());
        messageContent.setText(message.getMessage());
    }
}
