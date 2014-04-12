package com.free.underground;
import java.util.Map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
//import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.free.underground.R;

public class DataListFragment extends ListFragment{
	JSONArray data;

	public DataListFragment(){

	}

	@Override 
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i("mycode", "DataListFragment onActivityCreated");
		data=((MainActivity)this.getActivity()).data;
		//Log.i("mycode", "data length "+data.toString());
		setEmptyText("No Data Here");
		final JSONArrayAdapter adapter = new JSONArrayAdapter(this.getActivity(),data);
		setListAdapter(adapter);

		// Start out with a progress indicator.
		//setListShown(false);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Insert desired behavior here.
		Log.i("mycode", "Item clicked: " + id);
		((MainActivity)this.getActivity()).showDetail(id);
	}

	private class JSONArrayAdapter extends BaseAdapter {
		JSONArray data;
		Context context;

		public JSONArrayAdapter(Context context,JSONArray data) {
			super();
			this.context=context;
			this.data=data;
		}

		@Override
		public int getCount() {
			return data==null ? 0:data.length();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			try {
				return data.getJSONObject(arg0);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public boolean hasStableIds(){
			return true;
		}
		
		@Override
		public boolean isEmpty(){
			return data==null || data.length()==0;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.single_item, parent, false);
			TextView textView1 = (TextView) rowView.findViewById(R.id.firstLine);
			TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
			//View rectView = (View) rowView.findViewById(R.id.icon);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
			try {
				JSONObject jo = (JSONObject) data.get(position);
				textView1.setText(jo.getString("category_title"));
				textView2.setText(jo.getString("description"));
				GradientDrawable shapeDrawable = (GradientDrawable)imageView.getBackground();
				Map<String, Object> categories=((MainActivity)context).categories;
				String key=jo.getString("category_slug");
				String scolor=(String)categories.get(key);
				int color = Color.parseColor(scolor);
				shapeDrawable.setColor(color);
                        
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			return rowView;
		}

	}

}
