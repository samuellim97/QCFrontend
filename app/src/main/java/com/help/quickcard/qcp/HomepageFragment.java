package com.help.quickcard.qcp;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.android.volley.RequestQueue;

/**
 * Controller for the homepage
 * Created by shath on 04/02/18.
 */

public class HomepageFragment extends android.support.v4.app.Fragment{
    private String TAG= "HomepageFragment"; //For logging purpose

    // private RequestQueue rq;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //View root = new FrameLayout(getContext());
        View root = inflater.inflate(R.layout.activity_main,
				     null);
        Button btn = root.findViewById(R.id.btnSend);

        final MainActivity activity = (MainActivity) getActivity();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: Send button clicked");
                activity.sendRequest();
            }
        });
        //rq = activity.getQueue();

        return root;
    }
}
