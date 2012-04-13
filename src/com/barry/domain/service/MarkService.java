package com.barry.domain.service;

import android.util.Log;

import com.barry.domain.Mark;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MarkService implements IMarkService{

	private String tag = MarkService.class.getName();
	
	@Override
	public void storeMark(Mark mark) {
		// must store a Mark to the system(file or DB)
		// get the current location
		//TODO: get location
		// let's turn it to JSON
		String json = getJSONFromMark(mark);
		Log.d(tag, "JSON=" + json);
		
		
	}
	
	
	public String getJSONFromMark(Mark mark){
		String json = null;
		Gson gson = new Gson();
		try{	
			json= gson.toJson(mark);
		}catch (Exception e) {
			Log.e(tag, "Caught exception trying to convert Mark to JSON. ERROR:"+e.toString());
			e.printStackTrace();
		}
		
		return json;
	}
	

}
