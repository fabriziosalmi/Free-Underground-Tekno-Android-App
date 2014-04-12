package com.free.underground;

//import java.util.Locale;

import java.util.Calendar;

//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.SupportMapFragment;
import com.free.underground.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
//AIzaSyC3oWPXx5zJbr8DEo0Ltrm2T2xB7C3tV0E

public class MapFragment extends Fragment {
    private OnMapCompleteListener mListener;
    //public static final String ARG_PLANET_NUMBER = "planet_number";
    //public GoogleMap googleMap;
    EditText search_edit;
    ImageButton search_btn;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    public static interface OnMapCompleteListener {
        public abstract void onMapComplete();
    }


    public void onAttach(Activity activity) {
    	super.onAttach(activity);
        try {
    		Log.i("mycode","MapFragment onAttach");
            this.mListener = (OnMapCompleteListener)activity;
        }
        catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }
    
    
    public MapFragment() {
        // Empty constructor required for fragment subclasses
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		Log.i("mycode","MapFragment onCreateView");
        View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        //SupportMapFragment fm = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)); // line no : 28
        //googleMap = fm.getMap();
        // Enabling MyLocation Layer of Google Map
        //googleMap.setMyLocationEnabled(true);
		Log.i("mycode","MapFragment onMapComplete");
        this.mListener.onMapComplete();
        
        //search_edit= (EditText)rootView.findViewById(R.id.search_edit);
        
        //search_btn= (ImageButton)rootView.findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
        		Log.i("mycode","search_btn setOnClickListener "+search_edit.getText());
            }
        });

        final DatePickerDialog.OnDateSetListener datePickerListener   = new DatePickerDialog.OnDateSetListener() {
        	// when dialog box is closed, below method will be called.
        	@Override
        	public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
        		Log.i("mycode","selectedYear"+selectedYear);
        	}
        };        
        
        
        //button1= (ImageButton)rootView.findViewById(R.id.track_btn1);
        
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Log.i("mycode","button1 setOnClickListener");
        		final Calendar c = Calendar.getInstance();
        		DatePickerDialog dialog = new DatePickerDialog(getActivity(), datePickerListener, 
        				c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE));
        		dialog.show();        		
        		//getActivity().showDialog(0);	
            }
        });
        //button2= (ImageButton)rootView.findViewById(R.id.track_btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Log.i("mycode","button2 setOnClickListener");
            }
        });
        //button3= (ImageButton)rootView.findViewById(R.id.track_btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Log.i("mycode","button3 setOnClickListener");
            }
        });

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int width = metrics.widthPixels;
        //topbar.setMinimumWidth((width/100)*80);
        //int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                        //"drawable", getActivity().getPackageName());
       //((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
       // getActivity().setTitle(planet);
        return rootView;
    }
    
    
    public void onDestroyView() 
    {
       super.onDestroyView(); 
       Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));  
       FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
       ft.remove(fragment);
       ft.commit();
   }

}
