package com.help.quickcard.qcp;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.help.quickcard.api.NdefReaderTask;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private String TAG= "MainActivity"; //For logging purpose

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textBox1);

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter == null){
            Toast.makeText(this, "This device does not support NFC.", Toast.LENGTH_SHORT)
                    .show();
            finish();
            return;
        }

        if (!nfcAdapter.isEnabled()){
            Toast.makeText(this, "Please enable NFC",
                           Toast.LENGTH_SHORT).show();
            //mTextView.setText("NFC is disabled");
        }else{
            Toast.makeText(this, "NFC is enabled", Toast.LENGTH_SHORT).show();
        }


        //PendingIntent intent = PendingIntent.getActivity(this,
         //       0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
        //setContentView(R.layout.nfcreader_view);

        //Log.i("Oncreate", "Success");
        //handleIntent(getIntent());
    }

    /*@Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("Foreground dispatch", "Discovered tag with intent: " + intent);
        handleIntent(intent);
    }*/

    /**
     * Handles the intent
     *
     * @param intent
     */
    /*private void handleIntent(Intent intent){
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {

            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

            //String[] techList = tag.getTechList();
            //String searchedTech = Ndef.class.getName();
            MifareClassic mfc = MifareClassic.get(tag);
            byte[] data;

            try{
                mfc.connect();
                boolean auth = false;
                String cardData = null;
                int secCount = mfc.getSectorCount();
                int bCount = 0;
                int bIndex = 0;


                String keyA = "a0a1a2a3a4a5";
                String keyB = "d3f7d3f7d3f7";
                byte[] akey = hexStringToByteArray(keyA);
                byte[] bkey = hexStringToByteArray(keyB);
                Log.i(TAG, "handleIntent: keyA = "+Arrays.toString(akey));

                //byte[] akey = {0xa, 0x0, 0xb, 0x0, 0xc, 0x0, 0xd, 0x0, 0xe, 0x0, 0xf, 0x0};
                for(int i =0; i < secCount; i++){
                    //if(i == 0)
                    //    auth = mfc.authenticateSectorWithKeyA(i, akey);
                    //else
                      //  auth = mfc.authenticateSectorWithKeyA(i, bkey);

                    if (mfc.authenticateSectorWithKeyA(i, MifareClassic.KEY_MIFARE_APPLICATION_DIRECTORY)) {
                        auth = true;
                    } else if (mfc.authenticateSectorWithKeyA(i, MifareClassic.KEY_DEFAULT)) {
                        auth = true;
                    } else if (mfc.authenticateSectorWithKeyA(i,MifareClassic.KEY_NFC_FORUM)) {
                        auth = true;
                    } else {
                        Log.d("TAG", "handleIntent: Authorization denied ");
                    }

                    if (auth) {
                        bCount = mfc.getBlockCountInSector(i);
                        //bIndex = 0;
                        //for(int j=0; j< bCount; j++){
                        bIndex = mfc.sectorToBlock(i);
                        //mfc.transceive()
                        try {
                            data = mfc.readBlock(bIndex);
                            Log.i(TAG, "handleIntent: success, " + bin2hex(data));
                        }catch(Exception ex){
                            Log.i(TAG, "handleIntent: auth error! "+ ex );
                        }
                        //    bIndex++;
                        //}
                    }else{
                        Log.i(TAG, "handleIntent: auth error!" );
                    }
                }

                Log.i("MFC", "handleIntent: sector count = "+secCount);

                mfc.close();
            }catch(IOException ex){
                Log.e("MFC", "handleIntent: Cannot read! "+ex.getMessage(), ex);
            }

            Log.i(TAG, "handleIntent: uid="+ bin2hex(tag.getId()));
            Log.i("MFC", "handleIntent: "+mfc);
        }


    }*/

    //To display the UID


}
