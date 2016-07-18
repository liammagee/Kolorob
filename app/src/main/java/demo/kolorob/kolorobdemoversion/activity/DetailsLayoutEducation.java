package demo.kolorob.kolorobdemoversion.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import demo.kolorob.kolorobdemoversion.R;
import demo.kolorob.kolorobdemoversion.database.Education.EducationResultDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Education.EducationTrainingDetailsTable;
import demo.kolorob.kolorobdemoversion.database.Education.EducationTuitionDetailsTable;
import demo.kolorob.kolorobdemoversion.model.Education.EducationNewItem;
import demo.kolorob.kolorobdemoversion.model.Education.EducationResultItemNew;
import demo.kolorob.kolorobdemoversion.model.Education.EducationTrainingDetailsItem;
import demo.kolorob.kolorobdemoversion.model.Education.EducationTuitionDetailsItem;
import demo.kolorob.kolorobdemoversion.utils.AppConstants;

/**
 * Created by israt.jahan on 7/17/2016.
 */
public class DetailsLayoutEducation extends Activity {
    Dialog dialog;
    LinearLayout upperHand,upperText,left_way,middle_phone,right_email,bottom_bar,linearLayout;
    ImageView left_image,middle_image,right_image,email_btn;
    TextView address_text,phone_text,email_text;
    int width,height;
    TextView ups_text;
    ListView courseListView,listView;
    Context con;
    EducationNewItem educationNewItem;

    ArrayList<EducationTuitionDetailsItem>educationTuitionDetailsItems;
    ArrayList<EducationTrainingDetailsItem>educationTrainingDetailsItems;
    ArrayList<EducationResultItemNew>educationResultItemNews;
    private TextView totalStudents;
    private TextView totalClasses;
    private TextView totalTeachers;
    private TextView playground;
    private TextView hostel;
    private TextView transport;
    private TextView ratingText;
    private TextView serviceDetails,result,training,tuition;
    private ImageView close_button,phone_mid,distance_left,feedback,top_logo,cross,school_logo_default;
    RadioGroup feedRadio;
    RadioButton rb1,rb2,rb3;
    String status="",phone_num="",registered="";
    String result_concate="";
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_layout_education);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        con = this;


        Intent intent = getIntent();


        if (null != intent) {
            educationNewItem = (EducationNewItem) intent.getSerializableExtra(AppConstants.KEY_DETAILS_EDU);
            // Log.d("CheckDetailsHealth","======"+healthServiceProviderItemNew);
        }


         EducationTuitionDetailsTable educationTuitionDetailsTable = new EducationTuitionDetailsTable(DetailsLayoutEducation.this);
        EducationTrainingDetailsTable educationTrainingDetailsTable = new EducationTrainingDetailsTable(DetailsLayoutEducation.this);
        EducationResultDetailsTable educationResultDetailsTable = new EducationResultDetailsTable(DetailsLayoutEducation.this);


        courseListView = (ListView) findViewById(R.id.courseListView);
        listView = (ListView) findViewById(R.id.listView5);
        linearLayout = (LinearLayout) findViewById(R.id.lll);
        upperHand = (LinearLayout) findViewById(R.id.upper_part);
        upperText = (LinearLayout) findViewById(R.id.upperText);
        left_way = (LinearLayout) findViewById(R.id.left_go_process);
        middle_phone = (LinearLayout) findViewById(R.id.middle_phone);
        right_email = (LinearLayout) findViewById(R.id.right_email);
        left_image = (ImageView) findViewById(R.id.distance_left);
        bottom_bar = (LinearLayout) findViewById(R.id.bottom_bar);
        middle_image = (ImageView) findViewById(R.id.phone_middl);
        right_image = (ImageView) findViewById(R.id.right_side_email);
        address_text = (TextView) findViewById(R.id.address_text);
        phone_text = (TextView) findViewById(R.id.phone_text);
        email_text = (TextView) findViewById(R.id.email_text);
        totalStudents = (TextView) findViewById(R.id.tv_total_students);
        totalClasses = (TextView) findViewById(R.id.tv_total_class);
        totalTeachers = (TextView) findViewById(R.id.tv_total_teachers);
        playground = (TextView) findViewById(R.id.tv_playground);
        hostel = (TextView) findViewById(R.id.tv_hostel_fac);
        transport = (TextView) findViewById(R.id.tv_transport_facility);
        ratingText=(TextView)findViewById(R.id.ratingText);
        serviceDetails=(TextView)findViewById(R.id.serviceDetails);
        close_button=(ImageView)findViewById(R.id.close_buttonc);


        top_logo=(ImageView)findViewById(R.id.top_logo);

        school_logo_default=(ImageView)findViewById(R.id.service_logo);



        distance_left = (ImageView) findViewById(R.id.distance_left);
        email_btn = (ImageView) findViewById(R.id.right_side_email);
        feedback = (ImageView) findViewById(R.id.feedback);
        checkBox = (CheckBox) findViewById(R.id.compare);


        CheckConcate("প্রতিস্টানের ধরন",educationNewItem.getEdtype());
        CheckConcate("d",educationNewItem.getShift());
        CheckConcate("পুরুষ ডাক্তার",educationNewItem.getStudentno());
        CheckConcate("মহিলা ডাক্তার",educationNewItem.getTeachersno());
        CheckConcate("রোগী এবং ডাক্তারের অনুপাত",educationNewItem.getClassno());
        CheckConcate("পুরুষ ডাক্তার",educationNewItem.getAdditional());
        CheckConcate("মহিলা ডাক্তার",educationNewItem.getMalestudent());
        CheckConcate("রোগী নার্সের অনুপাত",educationNewItem.getFemalestudent());

        CheckConcate("প্রতিস্টানের ধরন",educationNewItem.getSpecialneeds());
        CheckConcate("",educationNewItem.getWashroom_no());
        CheckConcate("পুরুষ ডাক্তার",educationNewItem.getWashroom_male());
        CheckConcate("মহিলা ডাক্তার",educationNewItem.getWashroomcleanliness());
        CheckConcate("রোগী এবং ডাক্তারের অনুপাত",educationNewItem.getWatercondition());
        CheckConcate("পুরুষ ডাক্তার",educationNewItem.getWatersource());
        CheckConcate("মহিলা ডাক্তার",educationNewItem.getAveragestudent());
        CheckConcate("রোগী নার্সের অনুপাত",educationNewItem.getWashroomfemale());

        CheckConcate("পরিচিত স্থান",educationNewItem.getLandmark());
        CheckConcate("ব্লক",educationNewItem.getAddress());
        CheckConcate("ফ্লোর",educationNewItem.getFloor());
        CheckConcate("বাড়ির নাম",educationNewItem.getHousename());
        CheckConcate("রাস্তা",educationNewItem.getRoad());
        CheckConcate("লাইন ",educationNewItem.getLine());
        CheckConcate("এভিনিউ",educationNewItem.getAvenue());
        CheckConcate("পোস্ট অফিস",educationNewItem.getPostoffice());
        CheckConcate("পুলিশ স্টেশন",educationNewItem.getPolicestation());

        CheckConcate("পুলিশ স্টেশন",educationNewItem.getNode_contact());
        CheckConcate("পুলিশ স্টেশন",educationNewItem.getNode_contact2());
        CheckConcate("পুলিশ স্টেশন",educationNewItem.getNode_email());
        CheckConcate("পুলিশ স্টেশন",educationNewItem.getNode_website());
        CheckConcate("পুলিশ স্টেশন",educationNewItem.getNode_facebook());
        CheckConcate("পুলিশ স্টেশন",educationNewItem.getNode_designation());


        timeProcessing("খোলার সময়",educationNewItem.getOpeningtime());
        timeProcessing("বন্ধে সময়",educationNewItem.getClosetime());
        CheckConcate("বিরতির সময়",educationNewItem.getBreaktime());
        CheckConcate("ছুটির দিন",educationNewItem.getOffday());
        CheckConcate("বিরতির সময়",educationNewItem.getRegisterednumber());
        CheckConcate("ছুটির দিন",educationNewItem.getRegisteredwith());
        educationResultItemNews=educationResultDetailsTable.getResultInfo(educationNewItem.getEduId());
        int result_size=educationResultItemNews.size();
        if(result_size!=0)
        {
            for(EducationResultItemNew educationResultItemNew: educationResultItemNews)
            {
                //result_concate="";

                CheckConcate("সেবার ধরন",educationResultItemNew.getExamname());
                CheckConcate("ডাক্তারের সংখা",educationResultItemNew.getStudentno());
                CheckConcate("প্রথম ভিজিট ফি",educationResultItemNew.getPassed());
                CheckConcate("এক সপ্তাহের মধ্যে ভিজিট ফি",educationResultItemNew.getGoldena());
                CheckConcate("এক মাসের মধ্যে ভিজিট ফি",educationResultItemNew.getAplus());



            }


        }
        educationTrainingDetailsItems=educationTrainingDetailsTable.gettrainingInfo(educationNewItem.getEduId());
        int training_size=educationTrainingDetailsItems.size();
        if(training_size!=0)
        {
            for(EducationTrainingDetailsItem educationTrainingDetailsItem: educationTrainingDetailsItems)
            {


                CheckConcate("সেবার ধরন",educationTrainingDetailsItem.getCourseduration());
                CheckConcate("ডাক্তারের সংখা",educationTrainingDetailsItem.getAdmissionmonth());
                CheckConcate("প্রথম ভিজিট ফি",educationTrainingDetailsItem.getCost());
                CheckConcate("এক সপ্তাহের মধ্যে ভিজিট ফি",educationTrainingDetailsItem.getTrainingnametype());
                CheckConcate("এক মাসের মধ্যে ভিজিট ফি",educationTrainingDetailsItem.getTrainingnamesubtype());




            }
        }

        educationTuitionDetailsItems=educationTuitionDetailsTable.gettuitionInfo(educationNewItem.getEduId());
        int tuition_size=educationTuitionDetailsItems.size();
        if(tuition_size!=0)
        {
            for(EducationTuitionDetailsItem educationTuitionDetailsItem: educationTuitionDetailsItems)
            {
                //result_concate="";

                CheckConcate("সেবার ধরন",educationTuitionDetailsItem.getTuitionlevel());
                CheckConcate("ডাক্তারের সংখা",educationTuitionDetailsItem.getTuitionfree());
                CheckConcate("প্রথম ভিজিট ফি",educationTuitionDetailsItem.getTuitionstipendfacility());
                CheckConcate("এক সপ্তাহের মধ্যে ভিজিট ফি",educationTuitionDetailsItem.getTuitionstipendtype());
                CheckConcate("এক মাসের মধ্যে ভিজিট ফি",educationTuitionDetailsItem.getTuitiondetails());
                CheckConcate("রিপোর্ট ফি",educationTuitionDetailsItem.getTuitionminfee());

                CheckConcate("প্রথম ভিজিট ফি",educationTuitionDetailsItem.getTuitionmaxfee());
                CheckConcate("এক সপ্তাহের মধ্যে ভিজিট ফি",educationTuitionDetailsItem.getTuitionmincoaching());
                CheckConcate("এক মাসের মধ্যে ভিজিট ফি",educationTuitionDetailsItem.getTuitionmaxcoaching());
                CheckConcate("রিপোর্ট ফি",educationTuitionDetailsItem.getTuitionadditional());


            }


        }





        serviceDetails.setText(result_concate);

        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


       /* checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int compareValue;
                compareValue= SharedPreferencesHelper.getComapreValueHealth(DetailsLayoutEducation.this);
                if(compareValue>=2)
                    AlertMessage.showMessage(con, "নতুন তথ্য নেয়া সম্ভব হচ্ছে না",
                            "আপনি ইতিমধ্যে দুটি সেবা নির্বাচিত করেছেন তুলনার জন্য");
                else if (compareValue==0)
                {
                    Log.d("compareValue", "====" + compareValue);
                    SharedPreferencesHelper.setCompareDataHealth(DetailsLayoutEducation.this,healthServiceProviderItemNew.getId(),1);
                }

                else if(compareValue==1)
                {
                    String previous_node;
                    previous_node=SharedPreferencesHelper.getComapreDataHealth(DetailsInfoActivityHealthNew.this);
                    previous_node= previous_node+" "+healthServiceProviderItemNew.getId();
                    SharedPreferencesHelper.setCompareDataHealth(DetailsInfoActivityHealthNew.this,previous_node,2);
                }


            }
        });
*/


        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) upperHand.getLayoutParams();
        //int upperhad_height=params2.height = height/6;

        upperHand.setLayoutParams(params2);


//        LinearLayout.LayoutParams params_upperText = (LinearLayout.LayoutParams) upperText.getLayoutParams();
//        // int  vd=params_upperText.height = height/24;
//        // params_upperText.width = width;
//        upperText.setLayoutParams(params_upperText);

        LinearLayout.LayoutParams params_left_way = (LinearLayout.LayoutParams) left_way.getLayoutParams();
        int lett_img = params_left_way.height = (height * 3) / 24;
        int right_img = params_left_way.width = width / 3;
        left_way.setLayoutParams(params_left_way);




        top_logo.getLayoutParams().height=width/8;
        top_logo.getLayoutParams().width=width/8;

        middle_image.getLayoutParams().height=width/8;
        middle_image.getLayoutParams().width=width/8;

        close_button.getLayoutParams().height=width/13;
        close_button.getLayoutParams().width=width/13;

        right_image.getLayoutParams().height = width/8;
        right_image.getLayoutParams().width = width/8;

        left_image.getLayoutParams().height =  width/8;
        left_image.getLayoutParams().width =  width/8;

        school_logo_default.getLayoutParams().height =  width/5;
        school_logo_default.getLayoutParams().width =  width/5;


        LinearLayout.LayoutParams params_middle_phone = (LinearLayout.LayoutParams) middle_phone.getLayoutParams();
        int vx = params_middle_phone.height = (height * 3) / 24;
        params_middle_phone.width = width / 3;
        middle_phone.setLayoutParams(params_middle_phone);





        LinearLayout.LayoutParams params_right_email = (LinearLayout.LayoutParams) right_email.getLayoutParams();
        int vc = params_right_email.height = (height * 3) / 24;
        params_right_email.width = width / 3;
        right_email.setLayoutParams(params_right_email);

        ups_text = (TextView) findViewById(R.id.ups_text);
        ups_text.setTextSize(width / 25);
        ratingText.setTextSize(width / 25);
        ups_text.setText(educationNewItem.getNamebn());

        LinearLayout.LayoutParams feedbacks = (LinearLayout.LayoutParams) feedback.getLayoutParams();
        feedbacks.height = width / 8;
        feedbacks.width = width / 8;
        feedback.setLayoutParams(feedbacks);
        feedbacks.setMargins(0, 0, width / 30, 0);



//        feedback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent feedIntent = new Intent(DetailsInfoActivityEducation.this,FeedBackActivityNew.class);
//                feedIntent.putExtra("id",educationServiceProviderItem.getIdentifierId());
//                feedIntent.putExtra("categoryId","1");
//                Log.d(">>>>","Button is clicked1 " +educationServiceProviderItem.getIdentifierId());
//
//                startActivity(feedIntent);
//
//            }
//        });


//            right_image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(educationServiceProviderItem.getEmailAddress().equals(""))
//                    {
//                        AlertMessage.showMessage(con, "ই মেইল করা সম্ভব হচ্ছে না",
//                                "ই মেইল আই ডি পাওয়া যায়নি");
//                    }
//                }
//            });
//
//            phone_mid.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
//                    if(!educationServiceProviderItem.getContactNo().equals(""))
//                    {
//                        callIntent1.setData(Uri.parse("tel:" + educationServiceProviderItem.getContactNo()));
//                        if(checkPermission())
//                            startActivity(callIntent1);
//                        else{
//                            AlertMessage.showMessage(con, "ফোনে কল দেয়া সম্ভব হচ্ছে না",
//                                    "ফোন নম্বর পাওয়া যায়নি");
//                            Toast.makeText(getApplicationContext(),
//                                    "Sorry, Phone call is not possible now. ", Toast.LENGTH_LONG)
//                                    .show();
//                        }
//                    }
//                    else {
//
//                        AlertMessage.showMessage(con, "ফোনে কল দেয়া সম্ভব হচ্ছে না",
//                                "ফোন নম্বর পাওয়া যায়নি");
//                        Toast.makeText(getApplicationContext(),
//                                "Sorry, Phone call is not possible now. ", Toast.LENGTH_LONG)
//                                .show();
//                    }
//                }
//            });


        // phermacy.setText(lat);


//        }




//        distance_left.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(AppUtils.isNetConnected(getApplicationContext())  && AppUtils.displayGpsStatus(getApplicationContext())) {
//
//
//                    String lat = educationServiceProviderItem.getLatitude().toString();
//                    // double latitude = Double.parseDouble(lat);
//                    String lon = educationServiceProviderItem.getLongitude().toString();
//                    // double longitude = Double.parseDouble(lon);
//                    String name= educationServiceProviderItem.getEduNameBan().toString();
//                    String node=educationServiceProviderItem.getIdentifierId();
//                    boolean fromornot=true;
//                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = pref.edit();
//                    editor.putString("Latitude", lat);
//                    editor.putString("Longitude", lon);
//                    editor.putString("Name", name);
//                    editor.putBoolean("Value", fromornot);
//                    editor.putString("nValue", node);
//                    editor.commit();
//
//
//                    String Longitude = pref.getString("Longitude", null);
//                    String Latitude = pref.getString("Latitude", null);
//
//                    if (Latitude != null && Longitude != null) {
//                        Double Lon = Double.parseDouble(Longitude);
//                        Double Lat = Double.parseDouble(Latitude);
//                        // implementFragment();
//                        //username and password are present, do your stuff
//                    }
//
//
//                    finish();
//
//                }
//                else if(!AppUtils.displayGpsStatus(getApplicationContext())){
//
//                    AppUtils.showSettingsAlert(DetailsInfoActivityEducation.this);
//
//                }
//
//                else
//                {
//
//                    AlertDialog alertDialog = new AlertDialog.Builder(DetailsInfoActivityEducation.this, AlertDialog.THEME_HOLO_LIGHT).create();
//                    alertDialog.setTitle("ইন্টারনেট সংযোগ বিচ্চিন্ন ");
//                    alertDialog.setMessage(" দুঃখিত আপনার ইন্টারনেট সংযোগটি সচল নয়। \n পথ দেখতে চাইলে অনুগ্রহপূর্বক ইন্টারনেট সংযোগটি সচল করুন।  ");
//                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    alertDialog.show();
//
//                }
//            }
//        });
//
//
//    }
//
//    public void verifyRegistration(View v){
//
//        Boolean register=RegisteredOrNot();
//
//        if(register.equals(false))
//        {
//            requestToRegister();
//        }
//
//        else {
//
//            feedBackAlert();
//            sendReviewToServer();
//        }
//
//
//    }

//    public void feedBackAlert()
//    {
//
//        LayoutInflater layoutInflater = LayoutInflater.from(DetailsInfoActivityEducation.this);
//        View promptView = layoutInflater.inflate(R.layout.give_feedback_dialogue, null);
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DetailsInfoActivityEducation.this);
//        alertDialogBuilder.setView(promptView);
//
//
//        final Button submit= (Button) promptView.findViewById(R.id.submit);
//
//
//        final AlertDialog alert = alertDialogBuilder.create();
//
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                declareRadiobutton();
//
//
//                alert.cancel();
//
//            }
//        });
//        // setup a dialog window
//        alertDialogBuilder.setCancelable(false);
//
//
//
//        alert.show();
//    }


//    public void sendReviewToServer()
//    {
//        int rating;
//        if(status.equals("ভাল"))
//            rating=1;
//        else if(status.equals("মোটামোট"))
//            rating=2;
//        else
//            rating=3;
//        String url = "http://www.kolorob.net/KolorobApi/api/rating/save_feedback?phone="+phone_num+"&node="+educationServiceProviderItem.getIdentifierId()+"&service="+"1"+"&rating="+rating;
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(DetailsInfoActivityEducation.this,response,Toast.LENGTH_SHORT).show();
//                        // Log.d(">>>>>","status "+response);
//                        try {
//                            JSONObject jo = new JSONObject(response);
//                            String forms;
//                            forms = jo.getString("status");
//                            Log.d(">>>>>","status "+forms);
//                            //Log.d(">>>>>","status ");
//
//                            if(forms.equals("true"))
//                            {
//                                AlertMessage.showMessage(DetailsInfoActivityEducation.this, "রেজিস্টেশনটি সফলভাবে সম্পন্ন হয়েছে",
//                                        "েজিস্টেশন করার জন্য আপনাকে ধন্যবাদ");
//                            }
//                            else
//                                AlertMessage.showMessage(DetailsInfoActivityEducation.this, "রেজিস্টেশনটি সফলভাবে সম্পন্ন হয়ে নি",
//                                        "আপনি ইতিপূর্বে রেজিস্ট্রেশন করে ফেলেছেন");
//
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(DetailsInfoActivityEducation.this,error.toString(),Toast.LENGTH_LONG).show();
//                    }
//                }) {
//
//            @Override
//            protected Map<String, String> getParams() {
//
//                Map<String, String> params = new HashMap<>();
//
//                return params;
//            }
//
//        };

//// Adding request to request queue
//
//        RequestQueue requestQueue = Volley.newRequestQueue(DetailsInfoActivityEducation.this);
//        requestQueue.add(stringRequest);
//    }

//    public void declareRadiobutton()
//    {
//        // int selected = feedRadio.getCheckedRadioButtonId();
//        // RadioButton rb1 = (RadioButton) findViewById(selected);
//        //  status = rb1.getText().toString();
//
//        // Arafat, i set it as static 1, pls change this codes;
//
//        status = "1";
//    }

//    public void requestToRegister()
//    {
//        LayoutInflater layoutInflater = LayoutInflater.from(DetailsInfoActivityEducation.this);
//        View promptView = layoutInflater.inflate(R.layout.verify_reg_dialog, null);
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DetailsInfoActivityEducation.this);
//        alertDialogBuilder.setView(promptView);
//
//
//        final ImageView yes= (ImageView)promptView.findViewById(R.id.yes);
//        final ImageView no= (ImageView)promptView.findViewById(R.id.no);
//
//        final AlertDialog alert = alertDialogBuilder.create();
//
//
//        yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentPhoneRegistration= new Intent(DetailsInfoActivityEducation.this,PhoneRegActivity.class);
//                startActivity(intentPhoneRegistration);
//
//            }
//        });
//
//
//
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alert.cancel();
//
//            }
//        });
//        // setup a dialog window
//        alertDialogBuilder.setCancelable(false);
//
//
//
//        alert.show();
//    }
//
//
//    private boolean checkPermission(){
//        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
//        if (result == PackageManager.PERMISSION_GRANTED){
//
//            return true;
//
//        } else {
//
//            return false;
//
//        }
    }

    public String English_to_bengali_number_conversion(String english_number) {
        int v = english_number.length();
        String concatResult = "";
        for (int i = 0; i < v; i++) {
            if (english_number.charAt(i) == '1')
                concatResult = concatResult + "১";
            else if (english_number.charAt(i) == '2')
                concatResult = concatResult + "২";
            else if (english_number.charAt(i) == '3')
                concatResult = concatResult + "৩";
            else if (english_number.charAt(i) == '4')
                concatResult = concatResult + "৪";
            else if (english_number.charAt(i) == '5')
                concatResult = concatResult + "৫";
            else if (english_number.charAt(i) == '6')
                concatResult = concatResult + "৬";
            else if (english_number.charAt(i) == '7')
                concatResult = concatResult + "৭";
            else if (english_number.charAt(i) == '8')
                concatResult = concatResult + "৮";
            else if (english_number.charAt(i) == '9')
                concatResult = concatResult + "৯";
            else if (english_number.charAt(i) == '0')
                concatResult = concatResult + "০";
        }
        return concatResult;
    }

//    public Boolean RegisteredOrNot()
//    {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        //  editor.putString("registered", lat);
//        registered = pref.getString("registered", null);
//        phone_num = pref.getString("phone",null);
//        // editor.commit();
//        //  if(registered.equals("yes"))
//        return true;
//        //  else
//        //   return true;
//
//
//
//

 /*   private String timeConverter(String time)
    {
        String timeInBengali="";

        String[] separated = time.split(":");





        int hour= Integer.valueOf(separated[0]);
        int times= Integer.valueOf(separated[1]);

        if(hour>6&&hour<12)
            timeInBengali="সকাল "+ English_to_bengali_number_conversion(String.valueOf(hour));
        else if(hour==12)
            timeInBengali="দুপুর  "+ English_to_bengali_number_conversion(String.valueOf(hour));
        else if(hour>12&&hour<16)
            timeInBengali="দুপুর  "+ English_to_bengali_number_conversion(String.valueOf(hour-12));
        else if(hour>15&&hour<18)
            timeInBengali="বিকেল "+ English_to_bengali_number_conversion(String.valueOf(hour-12));
        else if(hour>17&&hour<20)
            timeInBengali="সন্ধ্যা "+ English_to_bengali_number_conversion(String.valueOf(hour-12));
        else if(hour>20)
            timeInBengali="রাত "+ English_to_bengali_number_conversion(String.valueOf(hour-12));
        if(times!=0)
            timeInBengali=timeInBengali+ " টা " + English_to_bengali_number_conversion(String.valueOf(times))+" মিনিট";
        else
            timeInBengali=timeInBengali+ " টা";
        return timeInBengali;
    }
*/

    private void timeProcessing(String value1,String value2)
    {
        if(!value2.equals("null")||value2.equals("")) {
          //  String GetTime= timeConverter(value2);
           // CheckConcate(value1,GetTime);

        }
    }

    private void CheckConcate(String value1,String value2){


        if(!value2.equals("null")&&!value2.equals("")) {

            String value ="      "+ value1 +":  "+ value2;
            result_concate = result_concate + value + "\n";
        }





    }
}
