package com.help.quickcard.qcp.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.help.quickcard.qcp.R;
import com.help.quickcard.qcp.models.ChildAccount;

/**
 * Created by shath on 25/02/18.
 */

public class ChildAccountItemView extends LinearLayout {
    private ChildAccount childAccount;

    private TextView tvAccountName, tvBalance, tvStatus;

    public ChildAccountItemView(Context context, ChildAccount childAccount) {
        super(context);
        this.childAccount = childAccount;
        init(context);
    }

    public ChildAccountItemView(Context context, @Nullable AttributeSet attrs, ChildAccount childAccount) {
        super(context, attrs);
        this.childAccount = childAccount;
        init(context);
    }

    public ChildAccountItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, ChildAccount childAccount) {
        super(context, attrs, defStyleAttr);
        this.childAccount = childAccount;
        init(context);
    }

    private void init(Context context){
        inflateLayout(context);
        update();
    }

    /**
     * Updates data according to the child model
     */
    public void update(){
        tvAccountName.setText(childAccount.getAccountName());
        tvBalance.setText(Double.toString(childAccount.getBalance()));
        tvStatus.setText(Boolean.toString(childAccount.isActive()));
    }

    private void inflateLayout(Context context){
        LayoutInflater layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.itemcard_child_accounts, this);

        tvAccountName = (TextView) findViewById(R.id.tvChildName);
        tvBalance = (TextView) findViewById(R.id.tvChildBalance);
        tvStatus = (TextView) findViewById(R.id.tvChildAccountStatus);
    }
}
