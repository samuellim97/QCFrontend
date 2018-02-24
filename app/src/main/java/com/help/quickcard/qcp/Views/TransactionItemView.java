package com.help.quickcard.qcp.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.help.quickcard.qcp.R;
import com.help.quickcard.qcp.models.UserTransaction;

/**
 * Created by shath on 23/02/18.
 */
public class TransactionItemView extends LinearLayout{
    private TextView tvItem, tvCompany, tvAmount;
    private String itemName, companyName, amount;
    private UserTransaction data;

    public TransactionItemView(Context context) {
        super(context);
        inflateLayout(context);
    }

    public TransactionItemView(Context context, UserTransaction t) {
        super(context);
        this.data = t;
        setAmount(t.getAmount());
        setCompanyName(t.getCompanyName());
        setItemName(t.getItemName());
        inflateLayout(context);
        update();
    }

    /**
     * @deprecated in favour of Model based constructor
     * @param context
     * @param itemName
     * @param companyName
     * @param amount
     */
    public TransactionItemView(Context context, String itemName, String companyName, String amount) {
        super(context);
        this.itemName = itemName;
        this.companyName = companyName;
        this.amount = amount;
        inflateLayout(context);
        update();
    }

    public TransactionItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(context);
    }

    private void inflateLayout(Context context){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_transaction, this);

        tvItem    = (TextView) findViewById(R.id.tvItem);
        tvCompany = (TextView) findViewById(R.id.tvCompany);
        tvAmount  = (TextView) findViewById(R.id.tvAmount);
    }



    public void update(){
        tvItem.setText(getItemName());
        tvCompany.setText(getCompanyName());
        tvAmount.setText(getAmount());
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
