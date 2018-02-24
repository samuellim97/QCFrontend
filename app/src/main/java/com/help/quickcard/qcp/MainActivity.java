package com.help.quickcard.qcp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.help.quickcard.api.QuickCardAPI;
import com.help.quickcard.qcp.Fragments.ChildAccountViewFragment;
import com.help.quickcard.qcp.Fragments.TransactionViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main controller for the prototype.
 */
public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private String TAG= "MainActivity"; //For logging purpose
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private String url="http://localhost";
    private int port = 8080;

    private RequestQueue queue;
    private QuickCardAPI api;


    /**
     * {@inheritDoc}
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_view);

        queue = Volley.newRequestQueue(this);
        api = new QuickCardAPI(queue);
        api.setUrl(url);
        api.setPort(port);
        //sendRequest();

        //NavBar navBar = new NavBar(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //setContentView(MasterView);
    }


    public void sendRequest(){
        Log.i(TAG, "onCreate: Creating http request...");
        api.pollReady();
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new HomepageFragment(), "Home");
        //adapter.addFragment(new CardPageFragment(), "NFC");
        adapter.addFragment(new TransactionViewFragment(), "Transaction History");
        adapter.addFragment(new ChildAccountViewFragment(), "Child Accounts");
        viewPager.setAdapter(adapter);
    }

    /**
     * ViewPager adapter for the main screen
     * Used to implement tabs.
     *
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList();

        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return super.getPageTitle(position);
            return position + "-" + mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }


    //@Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter == null){
            Toast.makeText(this,
                    "This device does not support NFC.",
                    Toast.LENGTH_SHORT)
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
*/
        /*ViewGroup screen1 = new FrameLayout(this);
        ViewGroup screen2 = new FrameLayout(this);

        View.inflate(this, R.layout.activity_main, screen1);
        View.inflate(this, R.layout.nfcreader_view, screen2);
        //addContentView(R.layout.activity_main);
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipperScreen);
        flipper.addView(screen1);
        flipper.addView(screen2);
*/

//        flipper.addView(screen1);
        //flipper.addView(R.layout.activity_main);


        //PendingIntent intent = PendingIntent.getActivity(this,
         //       0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
        //setContentView(R.layout.nfcreader_view);

        //Log.i("Oncreate", "Success");
        //handleIntent(getIntent());
    //}

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
   /* private void handleIntent(Intent intent){
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

*/
    //}*/

    //To display the UID


}
