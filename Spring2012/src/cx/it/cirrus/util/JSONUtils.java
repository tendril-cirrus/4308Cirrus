/*
 * Insert License Here
 */

package cx.it.cirrus.util;

import java.util.ArrayList;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils {

    public static <T> ArrayList<T> getResponseAsArrayList(
            ArrayList<String> JSONArrayList, Class<T> classToReturn) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ArrayList<T> returnList = new ArrayList<T>();

        Log.d("JSONUtils", JSONArrayList.toString());

        for (String s : JSONArrayList) {
            returnList.add(gson.fromJson(s, classToReturn));
        }

        return returnList;
    }

    public static <T> T getJsonAsObject(String json, 
                                             Class<T> classToReturn) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.fromJson(json, classToReturn);

    }

    public static <T> String getObjectAsJson(T obj, Class<T> objClass){
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.toJson(obj, objClass);
    }

}
