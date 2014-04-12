package com.free.underground;


import com.free.underground.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailForm extends Fragment{
	View rootView;
	public DetailForm(){

	}
	@Override 
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i("mycode", "DetailForm onActivityCreated");
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		Log.i("mycode","DetailForm onCreateView");
        rootView = inflater.inflate(R.layout.detail_form, container, false);
         
        return rootView;
    }

}
