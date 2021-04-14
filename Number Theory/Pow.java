//Iterative approach for calculating power fastly using binary exponentiation
static long fastPow(long a, long b){
		long result =1;
		while(b>0){
			if(b%2==1)result *=a;
			a *=a;
			b/=2;
		}
		return result;
}
//Recursive approach of calculaing power using binary exponentiation
static long fastPow(long base, long exp) {
		if (exp==0) return 1;
		long half=fastPow(base, exp/2);
		if (exp%2==0) return half*half;
		return half*half*base;
}