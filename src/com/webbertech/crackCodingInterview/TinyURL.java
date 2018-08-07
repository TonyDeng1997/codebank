package com.webbertech.crackCodingInterview;

public class TinyURL {

    private static final String ALPHABET = "http://stackoverflow.com/questions/742013/how-to-code-a-url-shortener";
   // private static final int    BASE     = ALPHABET.length();

    private static final int    BASE     = 62;
    
    public static String encode(int num) {
        StringBuilder sb = new StringBuilder();
        while ( num > 0 ) {
            sb.append( ALPHABET.charAt( num % BASE ) );
            num /= BASE;
        }
        return sb.reverse().toString();   
    }

    public static int decode(String str) {
        int num = 0;
        for ( int i = 0; i < str.length(); i++ )
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        return num;
    }   
    
    public static void main(String[] args) {
    	System.out.println(encode(2231333));
    }
}



