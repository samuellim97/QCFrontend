package com.help.quickcard.qcp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.help.quickcard.qcp.R;
import com.help.quickcard.qcp.adapters.ChildAccountItemsAdapter;
import com.help.quickcard.qcp.models.ChildAccount;

import java.util.ArrayList;

/**
 * Fragment for the screen to Display child account
 * @author Ibrahim
 */

public class ChildAccountViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup root =  (ViewGroup) inflater.inflate(R.layout.account_view, null);

        ArrayList<ChildAccount> childAccounts = new ArrayList<>();

        childAccounts.add(new ChildAccount("Kid 1"));
        childAccounts.add(new ChildAccount("Kid 2"));

        ListView listViewAccount = root.findViewById(R.id.listView_account);
        listViewAccount.setAdapter(new ChildAccountItemsAdapter(getActivity().getBaseContext(),
                childAccounts
                ));

        return root;
    }
}
