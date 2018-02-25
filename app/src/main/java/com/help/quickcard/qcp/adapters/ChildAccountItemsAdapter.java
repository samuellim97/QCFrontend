package com.help.quickcard.qcp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.help.quickcard.qcp.Views.ChildAccountItemView;
import com.help.quickcard.qcp.models.ChildAccount;

import java.util.List;

/**
 * Created by shath on 25/02/18.
 */

public class ChildAccountItemsAdapter extends ArrayAdapter<ChildAccount> {
    public ChildAccountItemsAdapter(@NonNull Context context, @NonNull List<ChildAccount> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return new ChildAccountItemView(getContext(), getItem(position));
    }
}
