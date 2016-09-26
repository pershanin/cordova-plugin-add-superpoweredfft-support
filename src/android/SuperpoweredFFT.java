package com.pershanin.SuperpoweredFFT;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

public class SuperpoweredFFT extends CordovaPlugin {

	public static final String ACTION_SUPERPOWERED_FFT_COMPLEX = "getComplex"; 
	
	static {
        System.loadLibrary("SuperpoweredExample");
    }
	
	private native void SuperpoweredExample(String apkPath, long[] offsetAndLength);
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_SUPERPOWERED_FFT_COMPLEX.equals(action)) { 
				JSONObject arg_object = args.getJSONObject(0);
				Intent calIntent = new Intent(Intent.ACTION_EDIT);
				
				this.cordova.getActivity().startActivity(calIntent);
			   
				real = (float) arg_object.getDouble("real");
				imag = (float) arg_object.getDouble("imag");
				logSize = (int) arg_object.getInt("logSize");
				forward = (boolean) arg_object.getBoolean("forward");
				
				SuperpoweredExample.SuperpoweredFFTComplex(real, imag, logSize, forward);
				
				callbackContext.success(real);
				return true;
			}
			callbackContext.error("Invalid action");
			return false;
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		} 
	}
	
}