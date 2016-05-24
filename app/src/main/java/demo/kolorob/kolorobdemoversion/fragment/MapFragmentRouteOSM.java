package demo.kolorob.kolorobdemoversion.fragment;

import android.Manifest;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.bonuspack.routing.RoadNode;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.FolderOverlay;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.infowindow.InfoWindow;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;

import demo.kolorob.kolorobdemoversion.R;
import demo.kolorob.kolorobdemoversion.model.Education.EducationServiceProviderItem;
import demo.kolorob.kolorobdemoversion.model.Entertainment.EntertainmentServiceProviderItem;
import demo.kolorob.kolorobdemoversion.model.FInancial.FinancialServiceProviderItem;
import demo.kolorob.kolorobdemoversion.model.Health.HealthServiceProviderItem;
import demo.kolorob.kolorobdemoversion.model.Job.JobServiceProviderItem;
import demo.kolorob.kolorobdemoversion.model.LegalAid.LegalAidServiceProviderItem;
import demo.kolorob.kolorobdemoversion.utils.AppConstants;
import demo.kolorob.kolorobdemoversion.utils.AppUtils;

/**
 * Created by israt.jahan on 5/5/2016.

 */
public class MapFragmentRouteOSM extends Fragment implements View.OnClickListener, MapEventsReceiver, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    Drawable newMarker;
    Marker marker;
    MyLocationNewOverlay mylocation;
    private LinearLayout subcatlistholder;
    String stlat, stlong,centername;
    int ind = 0;
    Polyline roadOverlay;
    Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    List<String> listData = new ArrayList<String>();
double laat,longg;
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    private String locationName;
    private int locationNameId;
    private static double VIEW_WIDTH;
    private int primaryIconWidth;
double roadlength;
    public int getLocationNameId() {
        return locationNameId;
    }

    public void setLocationNameId(int locationNameId) {
        this.locationNameId = locationNameId;
        if (locationNameId == AppConstants.PLACE_BAUNIABADH) {
            listData.add(AppConstants.BAUNIABADH);
            listData.add(AppConstants.PARIS_ROAD);
        } else {
            listData.add(AppConstants.PARIS_ROAD);
            listData.add(AppConstants.BAUNIABADH);
        }
    }

    private ArrayList<HealthServiceProviderItem> healthServiceProvider = null;
    GeoPoint markerlocation, userlocation;
    Marker usermarker;
    private ArrayList<EntertainmentServiceProviderItem> entertainmentServiceProvider = null;
    private ArrayList<LegalAidServiceProviderItem> legalaidServiceProvider = null;
    private ArrayList<JobServiceProviderItem> jobServiceProvider = null;
    private ArrayList<FinancialServiceProviderItem> financialServiceProvider = null;
    private ArrayList<EducationServiceProviderItem> educationServiceProvider = null;
    MapView mapView, mapp;
    private int categoryId;

    ArrayAdapter arrayAdapter;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public void setEntertainmentServiceProvider(ArrayList<EntertainmentServiceProviderItem> et) {
        this.entertainmentServiceProvider = et;
    }

    public void setLegalaidServiceProvider(ArrayList<LegalAidServiceProviderItem> et) {
        this.legalaidServiceProvider = et;
    }

    public void setFinancialServiceProvider(ArrayList<FinancialServiceProviderItem> et) {
        this.financialServiceProvider = et;
    }

    public void setEducationServiceProvider(ArrayList<EducationServiceProviderItem> et) {
        educationServiceProvider = et;
    }

    int subcategotyId;
    View rootView;
    ArrayList<OverlayItem> anotherOverlayItemArray, anotherOverlayItemArrayfinal, anotherOverlayItemArray2, anotherOverlayItemArray3, anotherOverlayItemArray4, anotherOverlayItemArray7, anotherOverlayItemArray8, anotherOverlayItemArray5, anotherOverlayItemArray6;

    public MapFragmentRouteOSM() {

    }

    LocationManager locationManager;
    String provider;
    boolean havePolyLine;
    ItemizedIconOverlay<OverlayItem> anotherItemizedIconOverlay, anotherItemizedIconOverlay2, anotherItemizedIconOverlay7, anotherItemizedIconOverlay8, anotherItemizedIconOverlay3, anotherItemizedIconOverlay4, anotherItemizedIconOverlay5, anotherItemizedIconOverlay6;
    ArrayList<ItemizedIconOverlay> overlayholder = null;

    public ArrayList<HealthServiceProviderItem> getHealthServiceProvider() {
        return healthServiceProvider;
    }

    public void setHealthServiceProvider(ArrayList<HealthServiceProviderItem> et) {
        this.healthServiceProvider = et;
    }

    boolean statusofservice = false;
    Location location;
    IMapController mapViewController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        LayoutInflater li = LayoutInflater.from(getActivity());

        double latDouble, longDouble;
        int i = 0;

        super.onCreate(savedInstanceState);


        rootView = inflater.inflate(R.layout.fragment_map, container,
                false);
        VIEW_WIDTH = AppUtils.getScreenWidth(getActivity()) * AppConstants.CAT_LIST_LG_WIDTH_PERC;
        primaryIconWidth = (int) Math.floor(VIEW_WIDTH * 0.80);
        mapView = (MapView) rootView.findViewById(R.id.mapview);
        havePolyLine = false;
        if (havePolyLine) {
            mapView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        setMapView(mapView);

        mapView.setClickable(true);


        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.setUseDataConnection(true);


        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setTilesScaledToDpi(true);

        mapViewController = mapView.getController();
        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        String Latitude = pref.getString("Latitude", null);
        String Longitude = pref.getString("Longitude", null);
         centername = pref.getString("Name", null);
        locationNameId = pref.getInt("LocationNameId", 0);
        double lat = Double.parseDouble(Latitude);
        double lon = Double.parseDouble(Longitude);
        markerlocation = new GeoPoint(lat, lon);
        Marker centermarker = new Marker(mapView);
        centermarker.setPosition(markerlocation);
        centermarker.setTitle("Destination");

        mapView.getOverlays().add(centermarker);

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        final int gpsVersion = getResources().getInteger(com.google.android.gms.R.integer.google_play_services_version);

        // Showing status
        if (gpsVersion >= 8400000) {
            Toast.makeText(getActivity(), "Playservice available", Toast.LENGTH_SHORT).show();
            statusofservice = true;
            buildGoogleApiClient();
        } else {
            Toast.makeText(getActivity(), "Not available", Toast.LENGTH_SHORT).show();
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, getActivity(), requestCode);
            dialog.show();//dialog needs to be modified more of an alert dialog
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

            // Creating an empty criteria object
            Criteria criteria = new Criteria();

            // Getting the name of the provider that meets the criteria
            provider = locationManager.getBestProvider(criteria, false);


            if (provider != null && !provider.equals("")) {

                // Get the location from the given provider
                location = locationManager.getLastKnownLocation(provider);


                locationManager.requestLocationUpdates(provider, 60000, 0.0f, this);


                if (location != null) {
                    onLocationChanged(location);
                    Drawroute(userlocation, markerlocation);
                } else
                    Toast.makeText(getActivity(), "Location can't be retrieved", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getActivity(), "No Provider Found", Toast.LENGTH_SHORT).show();
            }
        }
        mapViewController.setZoom(18);
        mapViewController.setCenter(markerlocation);



        //---
        MapEventsOverlay mapEventsOverlay = new MapEventsOverlay(getActivity(), this);
        mapView.getOverlays().add(0, mapEventsOverlay);
        //Add Scale Bar
        ScaleBarOverlay myScaleBarOverlay = new ScaleBarOverlay(mapView);
        mapView.getOverlays().add(myScaleBarOverlay);


        ImageButton curButton = (ImageButton) rootView.findViewById(R.id.currlocation);
        curButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mLastLocation != null|| location!=null) {
                    Location setloc;
                    if (mLastLocation!=null) {
                        setloc=mLastLocation;
                        onLocationChanged(mLastLocation);



                    }
                    else {
                        setloc=location;
                        onLocationChanged(location);}
                    Drawroute(userlocation, markerlocation);
                    mapViewController.animateTo(new GeoPoint(setloc));
                }
            }
        });



        return rootView;
    }
public void calltransportlayout()
{
    RelativeLayout trlayout,headlayout;
    TextView disttext,Bustext,Ricksawtext,Cngtext,Walkingtext,headtext;
    trlayout=(RelativeLayout)rootView.findViewById(R.id.transportdetailslayout);
    trlayout.setVisibility(View.VISIBLE);
    headlayout=(RelativeLayout)rootView.findViewById(R.id.headerlayout);
    headlayout.setVisibility(View.VISIBLE);
    headtext=(TextView)rootView.findViewById(R.id.headtext);
    headtext.setText(centername);
    String distance= String.format("%.2f", roadlength);
    disttext=(TextView)rootView.findViewById(R.id.distancetext);
    Cngtext=(TextView)rootView.findViewById(R.id.cngtext);
    Bustext=(TextView)rootView.findViewById(R.id.bustext);
    Ricksawtext=(TextView)rootView.findViewById(R.id.ricksawtext);
    Walkingtext=(TextView)rootView.findViewById(R.id.walkingtext);
    disttext.setText(getString(R.string.distance) +": " +distance );
    double Busfare=roadlength*1.55;
            if (Busfare <=7.00)Bustext.setText( "7 " + "Taka ");
    else {
                String Bfare=String.format("%.2f", Busfare);
                Bustext.setText(Bfare + " Taka ");
            }
}
    public void Drawroute(GeoPoint Ulocation, GeoPoint Mlocation) {
        mapView.getOverlays().remove(roadOverlay);
        RoadManager roadManager = new OSRMRoadManager(getActivity());
        ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();
        waypoints.add(userlocation);
        waypoints.add(markerlocation);
        Road road = roadManager.getRoad(waypoints);
        if (road.mStatus != Road.STATUS_OK)
            Toast.makeText(getActivity(), "Error when loading the road - status=" + road.mStatus, Toast.LENGTH_SHORT).show();

        roadOverlay = RoadManager.buildRoadOverlay(road, getActivity());
        roadOverlay.setColor(Color.YELLOW);
        roadlength=road.mLength;
        mapView.getOverlays().add(roadOverlay);
        havePolyLine = true;
        if (havePolyLine) {
            mapView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        //3. Showing the Route steps on the map
        FolderOverlay roadMarkers = new FolderOverlay(getActivity());
        mapView.getOverlays().add(roadMarkers);
        Drawable nodeIcon = getResources().getDrawable(R.drawable.marker_node);
        for (int ii = 0; ii < road.mNodes.size(); ii++) {
            RoadNode node = road.mNodes.get(ii);
            Marker nodeMarker = new Marker(mapView);
            nodeMarker.setPosition(node.mLocation);
            nodeMarker.setIcon(nodeIcon);

            //4. Filling the bubbles
            nodeMarker.setTitle("Step " + ii);
            nodeMarker.setSnippet(node.mInstructions);
            nodeMarker.setSubDescription(Road.getLengthDurationText(getActivity(), node.mLength, node.mDuration));
            Drawable iconContinue = getResources().getDrawable(R.drawable.ic_continue);
            nodeMarker.setImage(iconContinue);
            //4. end

            roadMarkers.add(nodeMarker);
            mapView.invalidate();
        }
        calltransportlayout();
    }

    @Override
    public boolean singleTapConfirmedHelper(GeoPoint p) {
        // Toast.makeText(getActivity(), "Tap on (" + p.getLatitude() + "," + p.getLongitude() + ")", Toast.LENGTH_SHORT).show();
        InfoWindow.closeAllInfoWindowsOn(mapView);
        return true;
    }

    @Override
    public boolean longPressHelper(GeoPoint p) {
        return false;
    }


    @Override
    public void onClick(View v) {

    }


    public MapView getMapView() {
        return mapView;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    public void onLocationChanged(Location location) {
        // Getting reference to TextView tv_longitude
        if (statusofservice == false) {
            mapView.getOverlays().remove(usermarker);
            Toast.makeText(getActivity(), "Tap on locationmanager (" + location.getLatitude() + "," + location.getLongitude() + ")", Toast.LENGTH_SHORT).show();
            usermarker = new Marker(mapView);
          laat = location.getLatitude();
          longg = location.getLongitude();
            userlocation = new GeoPoint(laat, longg);
            usermarker.setPosition(userlocation);
            mapView.getOverlays().add(usermarker);
        } else {
            mapView.getOverlays().remove(usermarker);
            stlat = String.valueOf(location.getLatitude());
            stlong = String.valueOf(location.getLongitude());
            laat = location.getLatitude();
            longg = location.getLongitude();
            usermarker = new Marker(mapView);
            userlocation = new GeoPoint(laat, longg);
            usermarker.setPosition(userlocation);
            mapView.getOverlays().add(usermarker);
            Toast.makeText(getActivity(), "Tap on (" + stlat + "," + stlong + ")", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(100); // Update location every second

//        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, getActivity());


        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            stlat = String.valueOf(mLastLocation.getLatitude());
            stlong = String.valueOf(mLastLocation.getLongitude());
            double laat = mLastLocation.getLatitude();
            double longg = mLastLocation.getLongitude();
            userlocation=new GeoPoint(laat,longg);
            usermarker=new Marker(mapView);
            usermarker.setPosition(userlocation);
            mapView.getOverlays().add(usermarker);
            Drawroute(userlocation, markerlocation);

        }
         Toast.makeText(getActivity(), "Tap on (" + stlat + "," + stlong + ")", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }



    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
    synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();


    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("s", "onStart fired ..............");
        if(statusofservice==true)
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {

        if(statusofservice==true) {
            mGoogleApiClient.disconnect();
            Log.d("s", "isConnected ...............: " + mGoogleApiClient.isConnected());
        }


        super.onStop();
        Log.d("s", "onStop fired ..............");
    }


}
