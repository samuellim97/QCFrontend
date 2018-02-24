package com.help.quickcard.qcp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.help.quickcard.qcp.R;
import com.help.quickcard.qcp.TransactionItemsAdapter;
import com.help.quickcard.qcp.Views.TransactionItemView;
import com.help.quickcard.qcp.models.UserTransaction;

import java.util.ArrayList;

/**
 * Fragment for view to display Transaction records.
 */

public class TransactionViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.transaction_view, null);
        TransactionItemView transaction_item = new TransactionItemView(getContext(),
                                                        "#INV 1000, McDonalds beef burger", "McDonalds", "28.80");

        //LinearLayout tableArea = (LinearLayout) root.findViewById(R.id.transactionTableDataView);
        //ViewGroup tableArea = (ViewGroup) root.getChildAt(0);
        //tableArea.addView(transaction_item);
        ArrayList<UserTransaction> transactionList = new ArrayList<>();
        transactionList.add(new UserTransaction("#INV 1000, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1001, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1002, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1003, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1004, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1005, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1006, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1007, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1008, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1009, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1010, McDonalds beef burger", "McDonalds", "28.0"));
        transactionList.add(new UserTransaction("#INV 1011, McDonalds beef burger", "McDonalds", "28.0"));


        TransactionItemsAdapter adapter = new TransactionItemsAdapter(getActivity().getBaseContext(),
                        transactionList
                );
        ListView listView = (ListView) root.findViewById(R.id.listView_transaction);
        listView.setAdapter(adapter);
        //View tv = inflater.inflate(R.layout.transaction_view, root);
        //root.addView(tv);
        return root;
    }
}
