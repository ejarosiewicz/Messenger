package ej.com.messenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ej.com.messenger.model.database.Pojo;
import ej.com.messenger.utils.DataHolder;
import ej.com.messenger.utils.Requester;
import ej.com.messages.R;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText loginEdit;
    EditText passwordEdit;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uiSetup();
    }

    private void uiSetup() {
        loginEdit = (EditText)findViewById(R.id.loginEdit);
        passwordEdit= (EditText)findViewById(R.id.passwordEdit);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    private void makeRequest(String login, String password){
        Requester.getInstance().getApiInterface().getData(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Pojo>() {
                    @Override
                    public void onCompleted() {
                        MainActivity.start(LoginActivity.this);
                        LoginActivity.this.finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(LoginActivity.this,"Błąd sieci",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Pojo pojo) {
                        DataHolder.getInstance().setPojo(pojo);
                    }
                });
    }

    @Override
    public void onClick(View view) {
        String login = loginEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        if (login == null || login.isEmpty()) {
            loginEdit.setHint("Login nie może być pusty");
        } else if (password == null || password.isEmpty()) {
            passwordEdit.setHint("Hasło nie może być puste");
        } else {
            makeRequest(login,password);
        }
    }
}
