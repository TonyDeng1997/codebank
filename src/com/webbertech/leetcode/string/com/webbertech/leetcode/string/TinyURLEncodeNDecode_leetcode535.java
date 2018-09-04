package com.webbertech.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode 535 Tiny URL
 * 
 * The same questions as leetcode 534 design tiny URL.
 * 
 * TinyURL is a URL shortening service where you enter a URL 
 * such as https://leetcode.com/problems/design-tinyurl and 
 * it returns a short URL such as http://tinyurl.com/4e9iAk.

   Design the encode and decode methods for the TinyURL service. 
   There is no restriction on how your encode/decode algorithm should work. 
   You just need to ensure that a URL can be encoded to a tiny URL and 
   the tiny URL can be decoded to the original URL.

 Solution1: Use hashcode, and play with it, this hides the purpose f 
            this question.
            
 Solution2: randomly generated 6 digits of characters from a-zA-Z string.
 * */

public class TinyURLEncodeNDecode_leetcode535 {
	static Map<String, String> index = new HashMap<String, String>();
    static Map<String, String> revIndex = new HashMap<String, String>();
    static String BASE_HOST = "http://tinyurl.com/";
    static String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
    	// if map or db contains the longURL and it has been encoded already,
    	// just return it.
    	if (revIndex.containsKey(longUrl)) { 
        	return BASE_HOST + revIndex.get(longUrl);
        }
        
    	//otherwise, create 6 digits characters randomly form a-zA-Z0-9 string.
    	
    	// key is the tinyURL
    	String key = null;
        
        // Core logic starts here
    	// It has no relationship with the original long url. 
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));  //if this short string exists, then redo it
        
        //Once key is generated, then store it in both maps
        index.put(key, longUrl);
        revIndex.put(longUrl, key);
        
        return BASE_HOST + key;
    }

    //In reality it is going to be stored in database, and 
    // not decodable, the only thing here is to use map to 
    // decode it.
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }
    
    
   // This function is used to test the core algorithm in the above
   static String testFunction() {
    	// key is the tinyURL
    	String key = null;
        
        // Core logic starts here
    	// It has no relationship with the original long url. 
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
            	//Math.random returns 0-1.
            	int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        
        return key;
    }
    
   
  // solutionII Encodes a URL to a shortened URL.
   public static String encodeII(String longUrl) {
       
       if (index.containsKey(longUrl)) {
           return BASE_HOST+index.get(longUrl);
       }
       int hashCode = Math.abs(longUrl.hashCode());
       
       while(String.valueOf(hashCode).length() > 6) {
           hashCode=hashCode/6;
       }
       
       System.out.println(hashCode);
       StringBuilder sb = new StringBuilder();
       for (int i=0;i<6;i++) {
    	   char c = String.valueOf(hashCode).charAt(i);

          sb.append(charSet.charAt(c));
       }
       String shortURL = sb.toString(); 
       index.put(longUrl, shortURL);
       revIndex.put(shortURL, longUrl);
       return BASE_HOST + shortURL;
   }
   
    public static void main(String[] args) {
    	/*
    	// test randomness
    	System.out.println(Math.random());
    	System.out.println(Math.random());
    	System.out.println(Math.random());
    	System.out.println(Math.random());
    	System.out.println(Math.random());
    	
    	// randomness pretty good.
    	System.out.println(Math.random()*52);
    	System.out.println(Math.random()*52);
    	System.out.println(Math.random()*52);
    	System.out.println(Math.random()*52);
    	System.out.println(Math.random()*52);
    	
    	// test
    	System.out.println(testFunction() );
    	System.out.println(testFunction() );
    	System.out.println(testFunction() );
    	System.out.println(testFunction() );
    	*/
    	//TODO just some thought about another algorithm using the 
    	// hashcode of the original string.
    	String longURL = "https://leetcode.com/problems/design-tinyurl";
    	
    	/*(
    	System.out.println(longURL.hashCode());
    	int hashCode = longURL.hashCode();
    	hashCode = Math.abs(hashCode);
    	while(String.valueOf(hashCode).length()>6) {
    		hashCode/=6;
    	}
    	System.out.println(hashCode);
    	*/
    	System.out.println(encode(longURL));
    }
}