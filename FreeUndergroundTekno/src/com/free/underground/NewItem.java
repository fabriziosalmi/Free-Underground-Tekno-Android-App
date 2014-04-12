package com.free.underground;


import com.free.underground.R;

//import android.app.DatePickerDialog;
import android.content.Intent;
//import android.database.Cursor;
import android.graphics.BitmapFactory;
//import android.net.Uri;
import android.os.Bundle;
//import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.ImageButton;
import android.widget.ImageView;

public class NewItem extends Fragment{
	View rootView;
	public NewItem(){

	}
	@Override 
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i("mycode", "NewItem onActivityCreated");
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		Log.i("mycode","NewItem onCreateView");
        rootView = inflater.inflate(R.layout.new_item, container, false);
        Button buttonPhoto= (Button)rootView.findViewById(R.id.btnPhoto);
        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                getActivity().startActivityForResult(i, 1);
            }
        });
        
        
        return rootView;
    }

   public void setPhoto(String picturePath){
       ImageView imageView = (ImageView) rootView.findViewById(R.id.imgView);
       imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

   }
}
