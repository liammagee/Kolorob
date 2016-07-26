package demo.kolorob.kolorobdemoversion.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
<<<<<<< HEAD
import android.media.MediaPlayer;
import android.os.AsyncTask;
=======
import android.graphics.drawable.AnimationDrawable;
>>>>>>> master
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import demo.kolorob.kolorobdemoversion.R;
import demo.kolorob.kolorobdemoversion.database.CategoryTable;
import demo.kolorob.kolorobdemoversion.database.DatabaseHelper;
import demo.kolorob.kolorobdemoversion.database.Education.EducationNewTable;
import demo.kolorob.kolorobdemoversion.database.Education.EducationResultDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Education.EducationTrainingDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Education.EducationTuitionDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Entertainment.EntertainmentServiceProviderTableNew;
import demo.kolorob.kolorobdemoversion.database.Entertainment.EntertainmetTypeTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialBillsTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialInsuranceTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialLoanTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialPaymentTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialServiceDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialServiceNewTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialServiceProviderTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialSocialTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialTaxTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialTransactionTable;
import demo.kolorob.kolorobdemoversion.database.Financial.FinancialTuitionTable;
import demo.kolorob.kolorobdemoversion.database.Government.GovernmentNewTable;
import demo.kolorob.kolorobdemoversion.database.Government.GovernmentServiceDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Health.HealthServiceProviderTableNew;
import demo.kolorob.kolorobdemoversion.database.Health.HealthSpecialistTableDetails;
import demo.kolorob.kolorobdemoversion.database.Health.HealthVaccineTableDetails;
import demo.kolorob.kolorobdemoversion.database.LegalAid.LegalAidDetailsTable;
import demo.kolorob.kolorobdemoversion.database.LegalAid.LegalAidServiceProviderTableNew;
import demo.kolorob.kolorobdemoversion.database.SubCategoryTable;
import demo.kolorob.kolorobdemoversion.database.SubCategoryTableNew;
import demo.kolorob.kolorobdemoversion.helpers.AppDialogManager;
import demo.kolorob.kolorobdemoversion.interfaces.RetryCallBackForNoInternet;
import demo.kolorob.kolorobdemoversion.interfaces.VolleyApiCallback;
import demo.kolorob.kolorobdemoversion.model.CategoryItem;
import demo.kolorob.kolorobdemoversion.model.Education.EducationNewItem;
import demo.kolorob.kolorobdemoversion.model.Education.EducationResultItemNew;
import demo.kolorob.kolorobdemoversion.model.Education.EducationTrainingDetailsItem;
import demo.kolorob.kolorobdemoversion.model.Education.EducationTuitionDetailsItem;
import demo.kolorob.kolorobdemoversion.model.Entertainment.EntertainmentServiceProviderItemNew;
import demo.kolorob.kolorobdemoversion.model.Entertainment.EntertainmentTypeItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialBillsItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialInsuranceItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialLoanItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialNewItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialPaymentItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialServiceDetailsItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialServiceProviderItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialSocialItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialTaxItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialTransactionItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialTuitionItem;
import demo.kolorob.kolorobdemoversion.model.Government.GovernmentNewItem;
import demo.kolorob.kolorobdemoversion.model.Government.GovernmentServiceDetailsItem;
import demo.kolorob.kolorobdemoversion.model.Health.HealthServiceProviderItemNew;
import demo.kolorob.kolorobdemoversion.model.Health.HealthSpecialistItemDetails;
import demo.kolorob.kolorobdemoversion.model.Health.HealthVaccineItemDetails;
import demo.kolorob.kolorobdemoversion.model.LegalAid.LeagalAidDetailsItem;
import demo.kolorob.kolorobdemoversion.model.LegalAid.LegalAidServiceProviderItemNew;
import demo.kolorob.kolorobdemoversion.model.SubCategoryItem;
import demo.kolorob.kolorobdemoversion.model.SubCategoryItemNew;
import demo.kolorob.kolorobdemoversion.utils.AppConstants;
import demo.kolorob.kolorobdemoversion.utils.AppUtils;

import static demo.kolorob.kolorobdemoversion.parser.VolleyApiParser.getRequest;

//import demo.kolorob.kolorobdemoversion.adapters.Trialholder;
/**
 * Created by Yeakub Hassan Rafi on 27-Dec-15.
 * @author mity,arafat
 */

public class OpeningActivity extends Activity {
    public static final String DB_NAME = "kolorob.db";
    private final static int SPLASH_TIME_OUT = 500;
    private static final int INTERNET_PERMISSION = 1;
    String user="kolorobapp";
    String pass="2Jm!4jFe3WgBZKEN";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    AlertDialog alertDialog;
    private GoogleApiClient client;
    private AnimationDrawable frameAnimation;
    private Context ctx;
    public static final String EDU_PROVIDER_TABLE = "edu_provider";
    public  SQLiteDatabase db3;
    ProgressDialog pd;
    public int height,width;
    Boolean  firstRun;
    private int EntDataSize,HealthDatSize;
    private static final int ANIM_INTERVAL = 200;
    int countofDb;
    ArrayList<SubCategoryItem>si2=new ArrayList<>();
    ArrayList<SubCategoryItemNew>si3=new ArrayList<>();

    // LM's variables
    private Toast t = null;
    static int countOfDBLocal = 0;

    public int getCountofDb() {
        return countofDb;
    }
    // ArrayList<Trialholder>holdertrial=new ArrayList<>();
    public void setCountofDb(int countofDb) {
        this.countofDb = countofDb;
    }



    Context context;
    ImageView rotateImage;
    private Handler handler;
    int in = 0;
    View view=null;



    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_opening);

        ImageView kolorobLogo = (ImageView) findViewById(R.id.iv_kolorob_logo);//need to add bengali


        context = this;

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        width=displayMetrics.widthPixels;
        height=displayMetrics.heightPixels;

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        firstRun = settings.getBoolean("firstRun", false);
        if (firstRun == false)//if running for first time
        {
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("firstRun", true);
            editor.commit();

            if(!AppUtils.isNetConnected(getApplicationContext())) {
                alertDialog = new AlertDialog.Builder(OpeningActivity.this).create();
                alertDialog.setTitle("ইন্টারনেট সংযোগ বিচ্ছিন্ন");
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setMessage(" কলরব প্রথমবারের মত শুরু হতে যাচ্ছে। অনুগ্রহ পূর্বক ইন্টারনেট সংযোগটি চালু করুন ।  ");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                SharedPreferences settings = getSharedPreferences("prefs", 0);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putBoolean("firstRun", false);
                                editor.commit();
                                finish();
                            }
                        });
                alertDialog.show();
            }
            else



            {
//                pd = new ProgressDialog(OpeningActivity.this, ProgressDialog.STYLE_SPINNER);
//                pd.setIndeterminate(true);
//                pd.show(OpeningActivity.this, AppConstants.WAITTAG, AppConstants.WAITDET);
                LoadData();

                //   pd.dismiss();
            }
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(OpeningActivity.this).create();
            alertDialog.setTitle("আপনি কি তথ্য হালনাগাদ করতে চান? ");
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "না",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Log.e("open4",String.valueOf(getCountofDb()));
                            Intent i = new Intent(OpeningActivity.this, PlaceSelectionActivity.class);
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            startActivity(i);

                            dialog.dismiss();
                            finish();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "হ্যাঁ",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            if (AppUtils.isNetConnected(getApplicationContext())) {
                                countofDb = 0 ;
                                SharedPreferences settings = getSharedPreferences("prefs", 0);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putInt("KValue", countofDb);
                                editor.commit();
//                                pd = new ProgressDialog(OpeningActivity.this, ProgressDialog.STYLE_SPINNER);
//                                pd.setIndeterminate(true);
//                                pd.show(OpeningActivity.this, AppConstants.WAITTAG, AppConstants.WAITDET);

                                LoadData();
                                // Hack to get things working
//                                editor.putInt("KValue", 7);
//                                editor.commit();

                            } else {
                                AlertDialog alertDialog = new AlertDialog.Builder(OpeningActivity.this).create();

                                alertDialog.setTitle("ইন্টারনেট সংযোগ বিচ্ছিন্ন");
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.setMessage(" দুঃখিত আপনার ইন্টারনেট সংযোগটি সচল নয়।  ");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                Log.e("open3",String.valueOf(countofDb));
                                                Intent i = new Intent(OpeningActivity.this, PlaceSelectionActivity.class);
                                                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                                                startActivity(i);
                                                dialog.dismiss();
                                                finish();
                                            }
                                        });
                                alertDialog.show();

                            }

                        }
                    });

            alertDialog.show();
            alertDialog.setCanceledOnTouchOutside(false);
        }
    }
    public void LoadData() {

        /*
        @@@@ arafat, you have to control wheel from here
        moving wheel while loading data into local database
         */
        final OpeningActivity activity = this;
        rotateImage = (ImageView) findViewById(R.id.rotate_image);
        final Handler handler = new Handler();
        Runnable runner = new Runnable() {
            @Override
            public void run() {

                if (activity.countofDb >= 7) {
                    //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    overridePendingTransition(0, 0);
                    handler.removeCallbacks(this);
                    finish();
                    return;
                }
                //Create a loop
                handler.postDelayed(this, 1000);
            }

        };
        handler.postDelayed(runner, 1000);

        if ((AppUtils.isNetConnected(getApplicationContext()) )&&(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)== PackageManager.PERMISSION_GRANTED )
                ) {


            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/sp/health?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                @Override
                public void onResponse(int status, String apiContent) {
                    if (status == AppConstants.SUCCESS_CODE) {
                    try {
                        JSONArray allData=new JSONArray(apiContent);
                        HealthDatSize=allData.length();
                        for(int i=0;i<HealthDatSize;i++)
                        {
                            JSONObject jsonObject=allData.getJSONObject(i);
                            SaveHealthtData(jsonObject);

                        }

                        //   saveEntertainmentServiceProvider(jo.getJSONArray(AppConstants.KEY_DATA));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/refs_old?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            if (status == AppConstants.SUCCESS_CODE) {


                                try {
                                    JSONArray jo = new JSONArray(apiContent);
                                    new SaveCategoryListTask(activity).execute(jo);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );
            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/categories?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            if (status == AppConstants.SUCCESS_CODE) {

                                try {

                                    JSONArray jo = new JSONArray(apiContent);

                                    new SaveSubCategoryNewListTask(activity).execute(jo);
                                    SubCategoryTableNew subCategoryTableNew = new SubCategoryTableNew(OpeningActivity.this);
                                    si3 = subCategoryTableNew.getAllSubCat();
                                    si3.size();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );
//
//

            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/refs?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            if (status == AppConstants.SUCCESS_CODE) {


                                try {
                                    JSONArray jo = new JSONArray(apiContent);

                                    new SavenewEduTask(activity).execute(jo);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );
                getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/sp/education?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            if (status == AppConstants.SUCCESS_CODE) {

                                try {
                                    JSONObject jo = new JSONObject(apiContent);
                                    String apiSt = jo.getString(AppConstants.KEY_STATUS);
                                    if (apiSt.equals(AppConstants.KEY_SUCCESS))
                                        new SaveSubCategoryListTask(activity).execute(jo.getJSONArray(AppConstants.KEY_DATA));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );


            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/sp/entertainment?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                @Override
                public void onResponse(int status, String apiContent) {


                    try {

                        JSONArray allData = new JSONArray(apiContent);
                        new SaveEntertainmentDataTask(activity).execute(allData );

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/sp/financial?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            if (status == AppConstants.SUCCESS_CODE) {
                                try {

                                    JSONArray jo = new JSONArray(apiContent);
                                    new SavenewFinanceTask(activity).execute(jo);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );
            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/sp/government?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            if (status == AppConstants.SUCCESS_CODE) {
                                try {

                                    JSONArray jo = new JSONArray(apiContent);
                                    new SavenewGovTask(activity).execute(jo);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );


            getRequest(OpeningActivity.this, "http://kolorob.net/demo/api/sp/legal?username="+user+"&password="+pass+" ", new VolleyApiCallback() {
                        @Override
                        public void onResponse(int status, String apiContent) {
                            try {

                                JSONArray legal_array = new JSONArray(apiContent);
                                new SaveLegaltDataTask(activity).execute(legal_array);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );



        } else {
            if (!AppUtils.isNetConnected(getApplicationContext())) {

                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                db3 = db.getReadableDatabase();
                if (db.isTableExists(db3, EDU_PROVIDER_TABLE)) {
                    pd.dismiss();
                    Log.e("open1", String.valueOf(countofDb));
                    Intent a = new Intent(getApplicationContext(), PlaceChoiceActivity2.class);//Default Activity
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //getApplicationContext().startActivity(a);
                    (getApplicationContext()).startActivity(a);

                    activity.finish();
                } else {
                    AppDialogManager.showNoInternetDialog(activity, new RetryCallBackForNoInternet() {
                        @Override
                        public void retry() {
                            LoadData();
                        }
                    });
                }

            } else if (ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},
                            INTERNET_PERMISSION);
                }
            }

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(activity).addApi(AppIndex.API).build();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (pd != null)
            pd.dismiss();
    }

    private Animation slideInFromRightAnim() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f
        );
        inFromRight.setDuration(ANIM_INTERVAL *
                (int) (200 *
                        (AppConstants.CAT_LIST_LG_WIDTH_PERC
                                - AppConstants.CAT_LIST_SM_WIDTH_PERC)
                )
        );
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        slideInFromRightAnim();
        super.onStart();

        System.out.println("----main activity---onStart---");


        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    // Callback with the request from calling requestPermissions(...)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == INTERNET_PERMISSION) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeToastWithShortbread("Internet permission granted");
            } else {
                makeToastWithShortbread("Inter permission denied");
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    public void makeToastWithShortbread(String message) {
        if (t != null) {
            t.cancel();
            t = null;
        }
        t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        if (t != null)
            t.show();
    }


    // ASYNC TASKS
    abstract class GenericSaveDBTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
        private Context ctx;

        public GenericSaveDBTask(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        protected void onPostExecute(Result result) {
            if (((Long)result).longValue() == 0.0) { // Means the task is successful
                countofDb++;
                SharedPreferences settings = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("KValue", countofDb);
                editor.commit();
                Log.d("tasks", "Tasks remaining: " + ( 7 - countofDb ) );
                makeToastWithShortbread("Tasks remaining: " + ( 7 - countofDb ) );
            }
        }

    }

    class SaveCategoryListTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveCategoryListTask(Context ctx) {
            super(ctx);
        }

        @Override
        protected Long doInBackground(JSONArray... categoryArrays) {
            JSONArray categoryArray = categoryArrays[0];
            CategoryTable catTable = new CategoryTable(OpeningActivity.this);
            catTable.dropTable();
            int catCount = categoryArray.length();
            for (int i = 0; i < catCount; i++) {
                try {
                    JSONObject jo = categoryArray.getJSONObject(i);
                    CategoryItem ci = CategoryItem.parseCategoryItem(jo);
                    catTable.insertItem(ci);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
    }

    class SaveSubCategoryNewListTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveSubCategoryNewListTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... categoryArrays) {
            JSONArray subcat = categoryArrays[0];
            SubCategoryTableNew subCategoryTableNew=new SubCategoryTableNew(OpeningActivity.this);
            subCategoryTableNew.dropTable();

            int legalaidServiceProviderCount = subcat.length();

            for (int i = 0; i < legalaidServiceProviderCount; i++) {
                try {
                    JSONObject jo = subcat.getJSONObject(i);
                    SubCategoryItemNew et = SubCategoryItemNew.parseSubCategoryItem(jo);
                    subCategoryTableNew.insertItem(et);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
    }

    class SaveSubCategoryListTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveSubCategoryListTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonObjects) {
            JSONArray subCategoryArray = jsonObjects[0];
            SubCategoryTable subCatTable = new SubCategoryTable(OpeningActivity.this);
            subCatTable.dropTable();
            int subCatCount = subCategoryArray.length();
            for (int i = 0; i < subCatCount; i++) {
                try {
                    JSONObject jo = subCategoryArray.getJSONObject(i);
                    SubCategoryItem si = SubCategoryItem.parseSubCategoryItem(jo);
                    subCatTable.insertItem(si);

                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            si2 = subCatTable.getAllSubCategories(1);
            si2.size();
            return new Long(0);
        }
    }


    class SaveHealthtDataTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveHealthtDataTask(Context ctx) {
            super(ctx);
        }
=======
    private void SaveEntertainmentData(JSONObject jsonObject, int i) {
        EntertainmentServiceProviderTableNew entertainmentServiceProviderTableNew= new EntertainmentServiceProviderTableNew(OpeningActivity.this);
        //entertainmentServiceProviderTableNew.dropTable();
        try {
            EntertainmentServiceProviderItemNew entertainmentServiceProviderItemNew=EntertainmentServiceProviderItemNew.parseEntertainmentServiceProviderItem(jsonObject,i);
            entertainmentServiceProviderTableNew.insertItem(entertainmentServiceProviderItemNew);

            if (jsonObject.has("rspot_details"))
            {
                JSONArray rspot_details=jsonObject.getJSONArray("rspot_details");
                int rspot_detailsSize=rspot_details.length();
>>>>>>> master

        protected Long doInBackground(JSONArray... jsonArrays) {
            JSONArray allData = jsonArrays[0];
            HealthServiceProviderTableNew healthServiceProviderTableNew = new HealthServiceProviderTableNew(OpeningActivity.this);
            HealthDatSize = allData.length();

            for (int i = 0; i < HealthDatSize; i++) {
                try{
                    JSONObject jsonObject = allData.getJSONObject(i);
                    HealthServiceProviderItemNew healthServiceProviderItemNew = HealthServiceProviderItemNew.parseHealthServiceProviderItem(jsonObject);
                    healthServiceProviderTableNew.insertItemHealth(healthServiceProviderItemNew);
                    if (jsonObject.has("health_vaccine_details")) {
                        JSONArray healthVaccine = jsonObject.getJSONArray("health_vaccine_details");
                        int HealthVaccineDataSize = healthVaccine.length();

                        for (int v = 0; v < HealthVaccineDataSize; v++) {
                            JSONObject healthVaccineItem = healthVaccine.getJSONObject(v);
                            SaveHealthVaccineData(healthVaccineItem, jsonObject.getInt("id"));
                        }
                    }
                    if (jsonObject.has("health_specialist_details")) {
                        JSONArray health_specialist_details = jsonObject.getJSONArray("health_specialist_details");
                        int HealthVaccineDataSize = health_specialist_details.length();

<<<<<<< HEAD

                        for (int v = 0; v < HealthVaccineDataSize; v++) {
                            JSONObject healthSpecialistItem = health_specialist_details.getJSONObject(v);
                            SaveSpecialistData(healthSpecialistItem, jsonObject.getInt("id"));
                        }
                    }


                }catch(JSONException e){
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
=======
                for (int v=0;v<rspot_detailsSize;v++)
                {
                    JSONObject rspot_detailsSizeItem= rspot_details.getJSONObject(v);
                    Saverspot_detailsData(rspot_detailsSizeItem,jsonObject.getInt("id"));

                }
            }
>>>>>>> master

        private void SaveSpecialistData(JSONObject jsonObject,int foreign_key)
        {
            HealthSpecialistTableDetails healthVaccineTableDetails= new HealthSpecialistTableDetails(OpeningActivity.this);
            try {
                HealthSpecialistItemDetails healthSpecialistItemDetails=HealthSpecialistItemDetails.parseHealthSpecialistItem(jsonObject,foreign_key);
                healthVaccineTableDetails.insertItemHealth(healthSpecialistItemDetails);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        }

        private void SaveHealthVaccineData(JSONObject jsonObject,int foreign_key)
        {
            HealthVaccineTableDetails healthVaccineTableDetails= new HealthVaccineTableDetails(OpeningActivity.this);
            try {
                HealthVaccineItemDetails healthVaccineItemDetails=HealthVaccineItemDetails.parseHealthVaccinesItem(jsonObject,foreign_key);
                healthVaccineTableDetails.insertItemHealth(healthVaccineItemDetails);


<<<<<<< HEAD

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    class SaveEntertainmentDataTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveEntertainmentDataTask(Context ctx) {
            super(ctx);
        }
=======
>>>>>>> master

        protected Long doInBackground(JSONArray... jsonArrays) {
            JSONArray allData = jsonArrays[0];
            int entDataSize = allData.length();

            for (int i = 0; i < entDataSize; i++) {
                try {
                    JSONObject jsonObject = allData.getJSONObject(i);
                    EntertainmentServiceProviderTableNew entertainmentServiceProviderTableNew= new EntertainmentServiceProviderTableNew(OpeningActivity.this);
                    //entertainmentServiceProviderTableNew.dropTable();
                    EntertainmentServiceProviderItemNew entertainmentServiceProviderItemNew=EntertainmentServiceProviderItemNew.parseEntertainmentServiceProviderItem(jsonObject,i);
                    entertainmentServiceProviderTableNew.insertItem(entertainmentServiceProviderItemNew);

<<<<<<< HEAD
                    if (jsonObject.has("rspot_details"))
                    {
                        JSONArray rspot_details=jsonObject.getJSONArray("rspot_details");
                        int rspot_detailsSize=rspot_details.length();

                        for (int v=0;v<rspot_detailsSize;v++)
                        {
                            JSONObject rspot_detailsSizeItem= rspot_details.getJSONObject(v);
                            Saverspot_detailsData(rspot_detailsSizeItem,jsonObject.getInt("id"));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }

        private void Saverspot_detailsData(JSONObject jsonObject,int foreign_key)
        {
            EntertainmetTypeTable entertainmetTypeTable= new EntertainmetTypeTable(OpeningActivity.this);
            try {

                EntertainmentTypeItem entertainmentTypeItem=EntertainmentTypeItem.parseEntertainmentTypeItem(foreign_key,jsonObject);
                entertainmetTypeTable.insertItem(entertainmentTypeItem);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }


    class SavenewFinanceTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SavenewFinanceTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonArrays) {
            JSONArray financial = jsonArrays[0];
            FinancialServiceNewTable financialServiceNewTable=new FinancialServiceNewTable(OpeningActivity.this);

            FinancialServiceDetailsTable financialServiceDetailsTable=new FinancialServiceDetailsTable(OpeningActivity.this);

            financialServiceDetailsTable.dropTable();

            financialServiceNewTable.dropTable();


            int legalaidServiceProviderCount = financial.length();

            for (int i = 0; i < legalaidServiceProviderCount; i++) {
                try {
                    JSONObject jo = financial.getJSONObject(i);
                    FinancialNewItem et = FinancialNewItem.parseFinancialMapInfoItem(jo);
                    financialServiceNewTable.insertItem(et);


                    if(jo.has("fin_service_details"))// need id in fin_service_details
                    {
                        JSONArray service_details = jo.getJSONArray("fin_service_details");
                        for( int j=0;j<service_details.length();j++)
                        {
                            JSONObject joes= service_details.getJSONObject(j);
                            FinancialServiceDetailsItem financialServiceDetailsItem = FinancialServiceDetailsItem.parseFinancialServiceDetailsItem(joes);
                            financialServiceDetailsTable.insertItem(financialServiceDetailsItem);

                        }

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
    }


    class SavenewGovTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SavenewGovTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonArrays) {
            JSONArray Gov = jsonArrays[0];
            GovernmentNewTable governmentNewTable=new GovernmentNewTable(OpeningActivity.this);

            GovernmentServiceDetailsTable governmentServiceDetailsTable=new GovernmentServiceDetailsTable(OpeningActivity.this);

            governmentServiceDetailsTable.dropTable();

            governmentNewTable.dropTable();


            int Govcount = Gov.length();

            for (int i = 0; i < Govcount; i++) {
                try {
                    JSONObject jo = Gov.getJSONObject(i);
                    GovernmentNewItem et =GovernmentNewItem.parseGovernmentNewItem(jo);
                    governmentNewTable.insertItem(et);

                    if(jo.has("govservice_details"))// need id in fin_service_details
                    {
                        JSONArray service_details = jo.getJSONArray("govservice_details");
                        for( int j=0;j<service_details.length();j++)
                        {
                            JSONObject joes= service_details.getJSONObject(j);
                            GovernmentServiceDetailsItem governmentServiceDetailsItem = GovernmentServiceDetailsItem.parseGovernmentServiceDetailsItem(joes);
                            governmentServiceDetailsTable.insertItem(governmentServiceDetailsItem);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
    }
=======


    /**
     * Written by : arafat
     */


    private void savenewEdu(JSONArray edu ) {
        EducationNewTable educationNewTable= new EducationNewTable(OpeningActivity.this);
        EducationResultDetailsTable educationResultDetailsTable= new EducationResultDetailsTable(OpeningActivity.this);
        EducationTrainingDetailsTable educationTrainingDetailsTable=new EducationTrainingDetailsTable(OpeningActivity.this);
        EducationTuitionDetailsTable educationTuitionDetailsTable=new EducationTuitionDetailsTable(OpeningActivity.this);
        educationNewTable.dropTable();
        educationResultDetailsTable.dropTable();
        educationTrainingDetailsTable.dropTable();
        educationTuitionDetailsTable.dropTable();
>>>>>>> master


    class SaveLegaltDataTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveLegaltDataTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonArrays) {
            JSONArray legal_array = jsonArrays[0];
            int p = legal_array.length();


            for (int i = 0; i < p; i++) {
                try {
                    JSONObject jsonObject = legal_array.getJSONObject(i);
                    LegalAidServiceProviderTableNew legalAidServiceProviderTableNew= new LegalAidServiceProviderTableNew(OpeningActivity.this);
                    LegalAidServiceProviderItemNew legalAidServiceProviderItemNew=LegalAidServiceProviderItemNew.parseLegalAidServiceProviderItemNew(jsonObject);
                    legalAidServiceProviderTableNew.insertItem(legalAidServiceProviderItemNew);
                    if (jsonObject.has("lservice_details"))
                    {
                        JSONArray lservice_details=jsonObject.getJSONArray("lservice_details");
                        int lservice_detailsSize=lservice_details.length();

                        for (int v=0;v<lservice_detailsSize;v++)
                        {
                            JSONObject lservice_detailsSizeItem= lservice_details.getJSONObject(v);
                            SaveLegalDetailsData(lservice_detailsSizeItem,jsonObject.getInt("id"));
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
        }
            return new Long(0);
        }

        private void SaveLegalDetailsData(JSONObject jsonObject,int foreign_key)
        {
            LegalAidDetailsTable legalAidDetailsTable= new LegalAidDetailsTable(OpeningActivity.this);
            try {
                LeagalAidDetailsItem leagalAidDetailsItem=LeagalAidDetailsItem.parseLegalAidDetailsItem(jsonObject,foreign_key);
                legalAidDetailsTable.insertItem(leagalAidDetailsItem);




            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    class SaveEducationServiceProviderTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveEducationServiceProviderTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonObjects) {
            JSONArray educationServiceProvider = jsonObjects[0];
            EducationServiceProviderTable educationServiceProviderTable = new EducationServiceProviderTable(OpeningActivity.this);
            educationServiceProviderTable.dropTable();
            EducationFeeTable educationFeeTable = new EducationFeeTable(OpeningActivity.this);
            EducationCourseTable educationCourseTable = new EducationCourseTable(OpeningActivity.this);
            educationCourseTable.dropTable();
            educationFeeTable.dropTable();
            EducationCourseItem Eci =null;
            EducationFeeItem Etf=null;
            EducationServiceProviderItem et=null;
            int eduServiceProviderCount = educationServiceProvider.length();
            for (int i = 0; i < eduServiceProviderCount; i++) {
                try {
                    JSONObject jo = educationServiceProvider.getJSONObject(i);
                    et = EducationServiceProviderItem.parseEducationServiceProviderItem(jo);
                    educationServiceProviderTable.insertItem(et);

                    if(jo.has("EducationServiceProviderCourse"))
                    {
                        JSONArray eduCourse = jo.getJSONArray("EducationServiceProviderCourse");
                        for( int k=0;k<eduCourse.length();k++)
                        {
                            JSONObject joesCourse= eduCourse.getJSONObject(k);

                            Eci = EducationCourseItem.parseEducationCourseItem(joesCourse);
                            educationCourseTable.insertItem(Eci);

                        }

                    }
                    if (jo.has("EduExamFees"))
                    {
                        JSONArray eduExamFees = jo.getJSONArray("EduExamFees");

                        for( int j=0;j<eduExamFees.length();j++)
                        {
                            JSONObject joes= eduExamFees.getJSONObject(j);

                            Etf = EducationFeeItem.parseEducationFeeItem(joes);
                            educationFeeTable.insertItem(Etf);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
    }

    class SaveHealthServiceProviderTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveHealthServiceProviderTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonObjects) {
            JSONArray healthServiceProvider = jsonObjects[0];
            HealthServiceProviderTable healthServiceProviderTable = new HealthServiceProviderTable(OpeningActivity.this);
            healthServiceProviderTable.dropTable();
            HealthVaccinesTable healthVaccinesTable = new  HealthVaccinesTable(OpeningActivity.this);
            healthVaccinesTable.dropTable();
            HealthSpecialistTable healthSpecialistTable  = new  HealthSpecialistTable (OpeningActivity.this);
            healthSpecialistTable.dropTable();
            HealthPharmacyTable healthPharmacyTable = new HealthPharmacyTable(OpeningActivity.this);
            healthPharmacyTable.dropTable();
            int healthServiceProviderCount = healthServiceProvider.length();
            for (int i = 0; i < healthServiceProviderCount; i++) {
                try {
                    JSONObject jo = healthServiceProvider.getJSONObject(i);
                    HealthServiceProviderItem et = HealthServiceProviderItem.parseHealthServiceProviderItem(jo);
                    // healthServiceProviderTable.insertItemHealth(et);

                    if(jo.has("specialist"))
                    {
                        JSONArray specialist = jo.getJSONArray("specialist");

                        for( int m=0;m<specialist.length();m++)
                        {
                            JSONObject joes= specialist.getJSONObject(m);

                            HealthSpecialistItem ets =  HealthSpecialistItem.parseHealthSpecialistItem(joes);
                            healthSpecialistTable.insertItemHealth(ets);

                        }

                    }
                    if(jo.has("vaccine"))
                    {
                        JSONArray vaccine = jo.getJSONArray("vaccine");

                        for( int n=0;n<vaccine.length();n++)
                        {
                            JSONObject joes= vaccine.getJSONObject(n);

                            HealthVaccinesItem etd =  HealthVaccinesItem.parseHealthVaccinesItem(joes);
                            healthVaccinesTable.insertItemHealth(etd);

<<<<<<< HEAD
                        }

                    }
                    if(jo.has("pharmacy"))
                    {
                        JSONArray pharmacy = jo.getJSONArray("pharmacy");

                        for( int k=0;k<pharmacy.length();k++)
                        {
                            JSONObject joes= pharmacy.getJSONObject(k);
                            HealthPharmacyItem etl = HealthPharmacyItem.parseHealthPharmacyItem(joes);
                            healthPharmacyTable.insertItemHealthPharmacy(etl);
=======
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }




    private void savesubcat(JSONArray subcat ) {
        SubCategoryTableNew subCategoryTableNew=new SubCategoryTableNew(OpeningActivity.this);



        subCategoryTableNew.dropTable();

        int legalaidServiceProviderCount = subcat.length();

        for (int i = 0; i < legalaidServiceProviderCount; i++) {
            try {
                JSONObject jo = subcat.getJSONObject(i);
                SubCategoryItemNew et = SubCategoryItemNew.parseSubCategoryItem(jo);
                subCategoryTableNew.insertItem(et);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

>>>>>>> master

                        }

                    }

<<<<<<< HEAD
=======
    }
    private void savesubcat2(JSONArray subcat ) {
        SubCategoryTable subCategoryTable=new SubCategoryTable(OpeningActivity.this);



        subCategoryTable.dropTable();
>>>>>>> master


<<<<<<< HEAD
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
=======
        for (int i = 0; i < legalaidServiceProviderCount; i++) {
            try {
                JSONObject jo = subcat.getJSONObject(i);
                SubCategoryItem et = SubCategoryItem.parseSubCategoryItem(jo);
                subCategoryTable.insertItem(et);
            } catch (JSONException e) {
                e.printStackTrace();
>>>>>>> master
            }
            return new Long(0);
        }




    }

<<<<<<< HEAD
    class SaveEntertainmentServiceProviderTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SaveEntertainmentServiceProviderTask(Context ctx) {
            super(ctx);
        }
=======
    private void saveSubCategoryList(JSONArray subCategoryArray) {
        SubCategoryTable subCatTable = new SubCategoryTable(OpeningActivity.this);
        subCatTable.dropTable();
        int subCatCount = subCategoryArray.length();
        for (int i = 0; i < subCatCount; i++) {
            try {
                JSONObject jo = subCategoryArray.getJSONObject(i);
                SubCategoryItem si = SubCategoryItem.parseSubCategoryItem(jo);
                subCatTable.insertItem(si);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        countofDb++;
        si2=subCatTable.getAllSubCategories(1);
        si2.size();
    }
>>>>>>> master

        protected Long doInBackground(JSONArray... jsonObjects) {
            JSONArray entertainmentServiceProvider = jsonObjects[0];
            EntertainmentServiceProviderTable entertainmentServiceProviderTable = new EntertainmentServiceProviderTable(OpeningActivity.this);
            entertainmentServiceProviderTable.dropTable();
            EntertainmentBookTable entertainmentBookTable = new EntertainmentBookTable(OpeningActivity.this);
            entertainmentBookTable.dropTable();
            EntertainmentFieldTable entertainmentFieldTable = new EntertainmentFieldTable(OpeningActivity.this);
            entertainmentFieldTable.dropTable();
            EntertainmentTheatreTable entertainmentTheatreTable = new EntertainmentTheatreTable(OpeningActivity.this);
            entertainmentTheatreTable.dropTable();
            EntertainmentFitnessTable entertainmentFitnessTable = new EntertainmentFitnessTable(OpeningActivity.this);
            entertainmentFitnessTable.dropTable();
            int entServiceProviderCount = entertainmentServiceProvider.length();
            for (int i = 0; i < entServiceProviderCount; i++) {
                try {
                    JSONObject jo = entertainmentServiceProvider.getJSONObject(i);
                    EntertainmentServiceProviderItem et = EntertainmentServiceProviderItem.parseEntertainmentServiceProviderItem(jo);
                    entertainmentServiceProviderTable.insertItem(et);


                    if(jo.has("EntFitnessBeauty"))
                    {
                        JSONArray EntFitnessBeauty = jo.getJSONArray("EntFitnessBeauty");

                        for( int m=0;m<EntFitnessBeauty.length();m++)
                        {
                            JSONObject joes= EntFitnessBeauty.getJSONObject(m);
                            EntertainmentFitnessItem ets = EntertainmentFitnessItem.parseEntertainmentFitnessItem(joes);
                            entertainmentFitnessTable.insertItem(ets);

                        }

                    }

                    if(jo.has("EntBookShop"))
                    {
                        JSONArray EntBookShop = jo.getJSONArray("EntBookShop");
                        for( int j=0;j<EntBookShop.length();j++)
                        {
                            JSONObject joes= EntBookShop.getJSONObject(j);
                            EntertainmentBookShopItem ets = EntertainmentBookShopItem.parseEntertainmentBookShopItem(joes);
                            entertainmentBookTable.insertItem(ets);

                        }

                    }

                    if(jo.has("EntField"))
                    {
                        JSONArray EntField = jo.getJSONArray("EntField");
                        for( int k=0;k<EntField.length();k++)
                        {
                            JSONObject joes= EntField.getJSONObject(k);
                            EntertainmentFieldItem ets = EntertainmentFieldItem.parseEntertainmentFieldItem(joes);
                            entertainmentFieldTable.insertItem(ets);

                        }


                    }

                    if(jo.has("EntTheatre"))
                    {
                        JSONArray EntTheatre = jo.getJSONArray("EntTheatre");
                        for( int l=0;l<EntTheatre.length();l++)
                        {
                            JSONObject joes= EntTheatre.getJSONObject(l);
                            EntertainmentTheatreItem etc = EntertainmentTheatreItem.parseEntertainmentTheatreItem(joes);
                            entertainmentTheatreTable.insertItem(etc);

                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
<<<<<<< HEAD
    }


    class SavenewEduTask extends GenericSaveDBTask<JSONArray, Integer, Long> {
        public SavenewEduTask(Context ctx) {
            super(ctx);
        }

        protected Long doInBackground(JSONArray... jsonObjects) {
            JSONArray edu = jsonObjects[0];
            EducationNewTable educationNewTable= new EducationNewTable(OpeningActivity.this);
            EducationResultDetailsTable educationResultDetailsTable= new EducationResultDetailsTable(OpeningActivity.this);
            EducationTrainingDetailsTable educationTrainingDetailsTable=new EducationTrainingDetailsTable(OpeningActivity.this);
            EducationTuitionDetailsTable educationTuitionDetailsTable=new EducationTuitionDetailsTable(OpeningActivity.this);
            educationNewTable.dropTable();
            educationResultDetailsTable.dropTable();
            educationTrainingDetailsTable.dropTable();
            educationTuitionDetailsTable.dropTable();


            int eduServiceProviderCount = edu.length();

            for (int i = 0; i < eduServiceProviderCount; i++) {
                try {
                    JSONObject jo = edu.getJSONObject(i);
                    EducationNewItem et = EducationNewItem.parseEducationNewItem(jo);
                    educationNewTable.insertItem(et);


                    if(jo.has("tution_details"))//
                    {
                        JSONArray service_details = jo.getJSONArray("tution_details");
                        for( int j=0;j<service_details.length();j++)
                        {
                            JSONObject joes= service_details.getJSONObject(j);
                            EducationTuitionDetailsItem educationTuitionDetailsItem = EducationTuitionDetailsItem.parseEducationTuitionDetailsItem(joes);
                            educationTuitionDetailsTable.insertItem(educationTuitionDetailsItem);

                        }
=======

        countofDb++;

//        if (firstRun == false)//if running for first time
//        {
//            pd.dismiss();
//          //  Intent i = new Intent(OpeningActivity.this, LocationAskActivity.class);
//         //   overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//            //Activity to be     launched For the First time
//            // Intent i = new Intent(OpeningActivity.this, FeedbackActivity.class);//Activity to be     launched For the First time
//            startActivity(i);
//
//        } else {


        //    }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

                    }
                    if(jo.has("result_details"))//
                    {
                        JSONArray service_details = jo.getJSONArray("result_details");
                        for( int j=0;j<service_details.length();j++)
                        {
                            JSONObject joes= service_details.getJSONObject(j);
                            EducationResultItemNew educationResultItemNew=EducationResultItemNew.parseEducationResultItemNew(joes);
                            educationResultDetailsTable.insertItem(educationResultItemNew);

                        }

                    }
                    if(jo.has("training_details"))//
                    {
                        JSONArray service_details = jo.getJSONArray("training_details");
                        for( int j=0;j<service_details.length();j++)
                        {
                            JSONObject joes= service_details.getJSONObject(j);
                            EducationTrainingDetailsItem educationTrainingDetailsItem = EducationTrainingDetailsItem.parseEducationTrainingDetailsItem(joes);
                            educationTrainingDetailsTable.insertItem(educationTrainingDetailsItem);
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f
        );
        inFromRight.setDuration(ANIM_INTERVAL *
                (int) (200 *
                        (AppConstants.CAT_LIST_LG_WIDTH_PERC
                                - AppConstants.CAT_LIST_SM_WIDTH_PERC)
                )
        );
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }

    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        slideInFromRightAnim();
        super.onStart();

                        }

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    return new Long(-1);
                }
            }
            return new Long(0);
        }
    }
}
