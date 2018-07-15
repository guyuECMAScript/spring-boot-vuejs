package com.gg.springbootvuejs.common.utils;

public class StringUtils {                                                                                                                                                                                       
    public static boolean allIsNotNull(String... s){       
    	if(s.length<=0){
    		return false;
    	}
        for(String str : s)     {
        	if(str == null){
        		return false;
        	}
        }
        return true;                                                                                                                                                                                            
    }                                                                                                                                                                                                            
    public static boolean allIsNotEmpty(String... s){                                                                                                                                                            
    	if(s.length<=0){
    		return false;
    	}
        for(String str : s)     {
        	if(str == null || str.trim().length()<=0){
        		return false;
        	}
        }
        return true;                                                                                                                                                                                            
    }                                                                                                                                                                                                            
}