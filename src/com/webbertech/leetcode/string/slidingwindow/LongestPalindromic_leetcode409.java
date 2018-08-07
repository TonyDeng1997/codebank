package com.webbertech.leetcode.string.slidingwindow;
/*
 * leetcode409
Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
Input:
"abccccdd"
Output:
7
\Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 * Solution: dccaccd, we can see that we have even number of c and d, and odd number of a or b
 * will make the parlindrome. So use a hash set to keep track of it,
 * if the set contains the letter, then remove it and count++. Keep counting even number 
 * of elements. Then  
 * 
 * */

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromic_leetcode409 {

 //Use hashset, for a pair, remove the old one and count++
 // if finally the hash set is not empty , it has a and b, using the 
 // above example, that means either a or b will make a palindrome string with even pairs.
 // if it is empty, then return count*2, else count*2+1;
    public static int longestPalindrome(String s) {
    	        if(s==null || s.length()==0) return 0;
    	        HashSet<Character> hs = new HashSet<Character>();
    	        int count = 0;
    	        for(int i=0; i<s.length(); i++){
    	            if(hs.contains(s.charAt(i))){
    	                hs.remove(s.charAt(i));
    	                count++;
    	            }else{
    	                hs.add(s.charAt(i));
    	            }
    	        }
    	        //then all the letters in hashset are unique, it does not
    	        // mater which one, but we add 1 to make the longest parlindrome
    	        if(!hs.isEmpty()) {
    	        	return count*2+1;
    	        }
    	        // if there are even pairs of numbers, then we return this number.
    	        return count*2;
     }
     
    /*
     * solution2: 
     * */
    public static int longestPalindromeII(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int odd = set.size();
        
        //odd is 0 means that s has all pairs of numbers so it must be a palindrome.
        // and the longest of course. Otherwise it returnes s.length()-odd+1.
        return s.length() - (odd == 0 ? 0 : odd - 1);
    }
    
     public static void main(String[] args) {
    	 /*
    	 System.out.println(isPalindrom("ccbbc"));
    	 System.out.println(isPalindrom("cbc"));
    	 System.out.println(isPalindrom("cbb"));
    	 */
    	 System.out.println(longestPalindrome("aba"));
    	 System.out.println(longestPalindrome("ccbbc"));
    	 System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
     }
}