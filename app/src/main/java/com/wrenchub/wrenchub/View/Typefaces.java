package com.wrenchub.wrenchub.View;


import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

public class Typefaces {

    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static Typeface getTypeFace(Context context, String assetPath){

        synchronized (cache){
            if (!cache.containsKey(assetPath)){
                try {
                    Typeface typeface = Typeface.createFromAsset(context.getAssets(), assetPath);
                    cache.put(assetPath, typeface);
                }catch (Exception e){
                    Log.e("TypeFaces", "Typeface not loaded.");
                    return null;
                }
            }
        }

        return cache.get(assetPath);

    }

}
