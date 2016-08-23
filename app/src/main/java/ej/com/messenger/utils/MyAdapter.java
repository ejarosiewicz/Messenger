package ej.com.messenger.utils;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ej.com.messenger.MainActivity;
import ej.com.messenger.ReadActivity;
import ej.com.messenger.model.database.Message;
import ej.com.messages.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * @author Emil Jarosiewicz on 2015-05-12.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NormalViewHolder>{

    private final MainActivity mainActivity;
    private ArrayList<Message> messageList;

    static class NormalViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        TextView sender;
        public TextView message;

        NormalViewHolder(View v) {
            super(v);
            sender = (TextView) v.findViewById(R.id.sender);
            message = (TextView) v.findViewById(R.id.message);

        }
    }

    public MyAdapter(ArrayList<Message> messageList, MainActivity mainActivity) {
        this.messageList = messageList;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        NormalViewHolder vh;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        vh = new NormalViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, final int position) {
        holder.sender.setText(messageList.get(position).getSender());
        holder.message.setText(
                validateMessage(messageList.get(position).getMessage())
        );
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadActivity.start(mainActivity, messageList.get(position));
            }
        });
    }

    private String validateMessage(String message) {
        return message.length() < 200 ? message : message.substring(0, 196) + "...";
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}