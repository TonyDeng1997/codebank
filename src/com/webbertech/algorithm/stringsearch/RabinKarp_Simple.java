package com.webbertech.algorithm.stringsearch;
public class RabinKarp_Simple {

	/*
	 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) 
	 * that prints all occurrences of pat[] in txt[].
	 * 
	 * Like the Naive Algorithm, Rabin-Karp algorithm also slides the pattern one by one. 
	 * But unlike the Naive algorithm, Rabin Karp algorithm matches the hash value of the pattern 
	 * with the hash value of current substring of text, 
	 * and if the hash values match then only it starts matching individual characters. 
	 * So Rabin Karp algorithm needs to calculate hash values for following strings.
	 * 	1) Pattern itself.
		2) All the substrings of text of length m.

		Since we need to efficiently calculate hash values for all the substrings of size m of text, 
		we must have a hash function which has following property.
	 * 
	 * Rehashing is done using the following formula.

		hash( txt[s+1 .. s+m] ) = d ( hash( txt[s .. s+m-1]) ¨C txt[s]*h ) + txt[s + m] ) mod q
	 * 
	 * hash( txt[s .. s+m-1] ) : Hash value at shift s.
		hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
		d: Number of characters in the alphabet
		q: A prime number
		h: d^(m-1)
	 * */
	
	//find all occurrences
	static void RabinKarpMatch(String txt, String pat, int q) {
		final int d = 256;
		int M = pat.length();
	    int N = txt.length();

	    int p = 0; // hash value for pattern
	    int t = 0; // hash value for txt
	    int h = 1;
	 
	    // The value of h would be "pow(d, M-1)%q"
	    for (int i = 0; i < M-1; i++)
	        h = (h*d)%q;
	 
	    // Calculate the hash value of pattern and first
	    // window of text
	    for (int i = 0; i < M; i++)
	    {
	        p = (d*p + pat.charAt(i))%q;
	        t = (d*t + txt.charAt(i))%q;
	    }
	 
	    // Slide the pattern over text one by one
	    for (int i = 0; i <= N - M; i++)
	    {
	 
	        // Check the hash values of current window of text
	        // and pattern. If the hash values match then only
	        // check for characters on by one
	        if ( p == t )
	        {
	        	int j ;
	            /* Check for characters one by one */
	            for (j = 0; j < M; j++)
	            {
	                if (txt.charAt(i+j) != pat.charAt(j))
	                    break;
	            }
	 
	            // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	            if (j == M)
	                System.out.println("Pattern found at index:"+ i);
	        }
	 
	        // Calculate hash value for next window of text: Remove
	        // leading digit, add trailing digit
	        if ( i < N-M )
	        {
	            t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
	 
	            // We might get negative value of t, converting it
	            // to positive
	            if (t < 0)
	            t = (t + q);
	        }
	    }
	}
	
	public static void main(String[] args) {
		String txt= "GEEKS FOR GEEKS";
	    String pat= "GEEK";
	    int q = 101; // A prime number
	    RabinKarpMatch(txt, pat, q);
	    return ;
	}
	
}
