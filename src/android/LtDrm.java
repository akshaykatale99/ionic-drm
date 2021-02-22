package cordova.plugin.lt.drm;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.WindowManager;
import android.app.Activity;

/**
 * This class echoes a string called from JavaScript.
 */
public class LtDrm extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("stop")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    try{
                        // Allow to make screenshots removing the FLAG_SECURE
                        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                            cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
                        }
                        callbackContext.success("Success");
                    }catch(Exception e){
                        callbackContext.error(e.toString());
                    }
                }
            });
    
            return true;
        } else if (action.equals("start")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    try{
                        // Allow to make screenshots removing the FLAG_SECURE
                        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                            cordova.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
                        }
                        callbackContext.success("Success");
                    }catch(Exception e){
                        callbackContext.error(e.toString());
                    }
                }
            });
            return true;
        } else {
            return false;
        }
        
    }

    // private void coolMethod(String message, CallbackContext callbackContext) {
    //     // callbackContext.success(message);
    //     cordova.getActivity().runOnUiThread(new Runnable() {
    //         public void run() {
    //             try{
    //                 // Allow to make screenshots removing the FLAG_SECURE
    //                 if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
    //                     cordova.cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
    //                 }
    //                 callbackContext.success("Success");
    //             }catch(Exception e){
    //                 callbackContext.error(e.toString());
    //             }
    //         }
    //     });

    //     if (message != null && message.length() > 0 && message == "on") {
    //         cordova.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
    //         callbackContext.success(message);
    //     } else {
    //         cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
    //         callbackContext.error(message);
    //     }
    // }
}
