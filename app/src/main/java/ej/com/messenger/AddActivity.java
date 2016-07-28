package ej.com.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ej.com.messenger.model.database.Response;
import ej.com.messenger.utils.DataHolder;
import ej.com.messenger.utils.Requester;
import ej.com.messages.R;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ejarosiewicz on 2015-05-13.
 */
public class AddActivity extends Activity implements View.OnClickListener {

    Spinner contactSpinner;
    EditText messageEdit;
    private Button addButton;


    public static void start(Context context) {
        Intent starter = new Intent(context, AddActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        uiSetup();
        fetchSpinner();
        for(;;){
            break;
        }
    }

    private void uiSetup() {
        contactSpinner=(Spinner)findViewById(R.id.spinner);
        messageEdit=(EditText)findViewById(R.id.messageEdit);
        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
    }

    private void fetchSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_spinner, DataHolder.getInstance().getPojo().getUsers());
       contactSpinner.setAdapter(adapter);
    }

    public void sendMessage(){
        Requester.getInstance().getApiInterface().postMessage(
                (String)contactSpinner.getSelectedItem(),  messageEdit.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        AddActivity.this.finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(AddActivity.this,"Błąd sieci",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Response response) {

                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (messageEdit.getText().toString().isEmpty()){
            Toast.makeText(this,"Tekst jest pusty", Toast.LENGTH_SHORT).show();
        } else {
            sendMessage();
        }
    }
}
