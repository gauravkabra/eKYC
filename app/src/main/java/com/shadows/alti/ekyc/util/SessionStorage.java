package com.shadows.alti.ekyc.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by melahi on 9/6/2015.
 */
public class SessionStorage {

    private static SessionStorage instance = new SessionStorage();

    private static Map<String,Object> map= new HashMap<String,Object>();

    private SessionStorage() {}

    public static synchronized SessionStorage getInstance() {
            if ( instance == null ){
                instance = new SessionStorage();
            }
            return instance;
    }

    public Object getValue(String key){
        return map.get(key);
    }

    public void put(String key,Object value){

        map.put(key,value);
    }

    public static void clearAll(){
        map.clear();
    }

}
