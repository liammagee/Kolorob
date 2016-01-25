package demo.kolorob.kolorobdemoversion.fragment;

/**
 * Created by Mazharul.Islam1 on 1/24/2016.
 */
import android.content.Context;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import demo.kolorob.kolorobdemoversion.R;
//import demo.kolorob.kolorobdemoversion.activity.RouteActivity;
import demo.kolorob.kolorobdemoversion.helpers.RouteDrawer;
import demo.kolorob.kolorobdemoversion.utils.AppConstants;

/**
 * A fragment that launches other parts of the demo application.
 */
public class MapRouteDrawingFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,LocationListener {

    MapView mMapView;
    private GoogleMap googleMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    public static final String TAG = MapRouteDrawingFragment.class.getSimpleName();
    private static final int MAP_ZOOM_AMOUNT=17;
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.route_drawer_fragment, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();

        double latitude = 17.385044;
        double longitude = 78.486671;

        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        String Latitude=pref.getString("Latitude", null);
        String Longitude =pref.getString("Longitude", null);
        int locationNameId= pref.getInt("LocationNameId", 0);
        // Toast.makeText(getApplicationContext(), "Your Longitude is " + Longitude,                Toast.LENGTH_SHORT).show();
        // Toast.makeText(getApplicationContext(), "Your Latitude is " + Latitude,                Toast.LENGTH_SHORT).show();




        Double Lon= Double.parseDouble(Longitude);
        Double Lat= Double.parseDouble(Latitude);




        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(Lat, Lon)).title("Hello Maps");

        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(Lat, Lon)).zoom(13).build();


        double latitude1=23.7795;
        double longitude1= 90.4046;


        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));



        mGoogleApiClient = new GoogleApiClient.Builder(this.getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000);


        return v;
    }





    private String getDirectionsUrl(double lat1,double lon1, double lat2, double lon2){

        String str_origin = "origin="+lat1+","+lon1;

        String str_dest = "destination="+lat2+","+lon2;

        String sensor = "sensor=false";

        String waypoints = "";



        String parameters = str_origin+"&"+str_dest+"&"+sensor+"&"+waypoints;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;


        return url;
    }





    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.d("Exception ", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    @Override
    public void onConnected(Bundle bundle) {

        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        else {
            handleNewLocation(location);
        }

    }

    private void handleNewLocation(Location location) {

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        // Toast.makeText(getApplicationContext(), "Now I am in onResume ", Toast.LENGTH_SHORT).show();

        String Longitude=pref.getString("Latitude", null);
        String Latitude=pref.getString("Longitude", null);
        int locationNameId=pref.getInt("LocationNameId", 0);
        // Toast.makeText(getApplicationContext(), "Your Longitude is " + Longitude,                Toast.LENGTH_SHORT).show();
        // Toast.makeText(getApplicationContext(), "Your Latitude is " + Latitude,                Toast.LENGTH_SHORT).show();



        Double Lon= Double.parseDouble(Longitude);
        Double Lat= Double.parseDouble(Latitude);
        //  Toast.makeText(getApplicationContext(), "Your Longitude is " + Lon,                Toast.LENGTH_SHORT).show();
        // Toast.makeText(getApplicationContext(), "Your Latitude is " + Lat,                Toast.LENGTH_SHORT).show();
        //implementFragment();


        LatLng latLng1 =new LatLng(Lat,Lon);


        getYourRoute(currentLatitude,currentLongitude,Lon,Lat);
        //  MarkerOptions options1 = new MarkerOptions()
        //  .position(latLng1)
        //  .title("You are here!");

        // googleMap.addMarker(options1);


        getYourRoute(currentLatitude, currentLongitude, Lon, Lat);
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("I am here!");

        googleMap.addMarker(options);

        if(locationNameId==1) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(AppConstants.BAUNIA).zoom(MAP_ZOOM_AMOUNT).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
        }

        else if(locationNameId==2)
        {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(AppConstants.PARIS).zoom(MAP_ZOOM_AMOUNT).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
        }

        Location loc1 = new Location("");
        loc1.setLatitude(currentLatitude);
        loc1.setLongitude(currentLongitude);

        Location loc2 = new Location("");
        loc2.setLatitude(Lon);
        loc2.setLongitude(Lat);

        float distanceInMeters = loc1.distanceTo(loc2)/1000;
        float timeneeded= (distanceInMeters/5)*60;
        float drivingtime= (distanceInMeters/60)*60;

        Toast.makeText(getActivity(),"দূরত্ব "+distanceInMeters+" কিলোমিটার", Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(),"আপনি হেটে "+timeneeded+"মিনিটের মধ্যে পৌছাতে পারবেন", Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(),"আপনি গাড়ীতে "+drivingtime+"মিনিটের মধ্যে পৌছাতে পারবেন", Toast.LENGTH_LONG).show();


        editor.clear();
        editor.commit();

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(this.getActivity(), CONNECTION_FAILURE_RESOLUTION_REQUEST);

            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {

            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
        }

    }

    @Override
    public void onLocationChanged(Location location) {

    }


    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                RouteDrawer routeDrawer = new RouteDrawer();

                routes = routeDrawer.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {

            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = result.get(i);

                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                lineOptions.addAll(points);
                lineOptions.width(5);
                lineOptions.color(Color.BLUE);
            }
            //setUpMapIfNeeded();
            googleMap.addPolyline(lineOptions);

        }
    }




    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            String data = "";

            try{
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task", e.toString());
            }
            return data;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            parserTask.execute(result);

        }
    }





    public void getYourRoute(double latitude1,double longitude1,double latitude2,double longitude2)
    {
        double lat1=latitude1;
        double long1= longitude1;
        double lat2= latitude2;
        double long2=longitude2;

        String url = getDirectionsUrl(lat1, long1,lat2,long2);

        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(url);

    }


    @Override
    public void onResume() {



        super.onResume();
        mMapView.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}