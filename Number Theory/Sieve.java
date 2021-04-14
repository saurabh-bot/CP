/*
The sieve of eretosthenes is one of the most efficient ways 
to find all primes smaller than n when n is smaller than
10 million.

------------------1st method ------------------------------

In this method we take a prime number and make its all mulitples
as false (i.e simply they can't be prime because it is divible 
by that number) and we do till given value(n).

Time Complexity: --------
(n/2 + n/3 + n/5 + n/7 + n/11 + _ _ _ _ _ _ _ )
= n(1/2 + 1/3 + 1/5 + 1/7 + 1/11 + _ _ _ _ _ _ )
=O(nlog(logn))

https://www.geeksforgeeks.org/sieve-of-eratosthenes/

*/

	static List<Integer> sieve(int n, List<Integer> list){

        //boolean array and storing true
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++) 
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) 
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                list.add(i);
        }
        return list;
    }
 
 /*------------------------- 2nd method --------------
 Time Complexity: O(n)
 https://www.geeksforgeeks.org/sieve-eratosthenes-0n-time-complexity/
 -----------------------------------------------------*/
