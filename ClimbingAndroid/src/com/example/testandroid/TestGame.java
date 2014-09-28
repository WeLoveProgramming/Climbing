package com.example.testandroid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.example.testandroid.R;
import com.example.framework.implementation.AndroidGame;

import android.util.Log;


public class TestGame extends AndroidGame {
	boolean firstTimeCreate = true;
	
	@Override
    public Screen getInitScreen() {

        if (firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

       
        //map = convertStreamToString(is);

        return new SplashLoadingScreen(this);

    }
	 @SuppressWarnings("unused")
	private static String convertStreamToString(InputStream is) {

         BufferedReader reader = new BufferedReader(new InputStreamReader(is));
         StringBuilder sb = new StringBuilder();

         String line = null;
         try {
             while ((line = reader.readLine()) != null) {
                 sb.append((line + "\n"));
             }
         } catch (IOException e) {
             Log.w("LOG", e.getMessage());
         } finally {
             try {
                 is.close();
             } catch (IOException e) {
                 Log.w("LOG", e.getMessage());
             }
         }
         return sb.toString();
     }
	 



}
