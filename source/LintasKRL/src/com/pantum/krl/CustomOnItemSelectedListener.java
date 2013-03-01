package com.pantum.krl;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
	LintasKRLActivity context;
	
	public CustomOnItemSelectedListener(LintasKRLActivity context){
		this.context = context;
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		String currentStation = parent.getItemAtPosition(pos).toString();
		Log.i(this.toString(), context.map.toString()+" "+currentStation);
		boolean isFound = false;
		for (int i = 0; i < context.map.size() && !isFound; i++) {
			String currentKey = context.map.get(currentStation);
			if(currentKey != null){
				context.wv.loadUrl("http://infoka.krl.co.id/to/"+currentKey);
				isFound = true;
			}
		}
	}

	public void onNothingSelected(AdapterView<?> arg0) {}

}