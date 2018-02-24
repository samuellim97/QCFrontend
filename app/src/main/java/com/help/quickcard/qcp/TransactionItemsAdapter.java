package com.help.quickcard.qcp;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.help.quickcard.qcp.Views.TransactionItemView;
import com.help.quickcard.qcp.models.UserTransaction;

import java.util.List;

/**
 * Created by shath on 24/02/18.
 */

public class TransactionItemsAdapter extends ArrayAdapter<UserTransaction>{
    List<UserTransaction> transactionList;


    public TransactionItemsAdapter(@NonNull Context context,
                                   @NonNull List<UserTransaction> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return new TransactionItemView(getContext(), getItem(position));
    }
}
