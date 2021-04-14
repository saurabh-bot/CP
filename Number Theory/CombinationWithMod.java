static long mul(long a, long b){
		return (a%MOD * b%MOD)%MOD;
}
static long fact(long n){
	long ans=1;
	for(int i=2; i<=n; i++)
		ans = mul(ans, i);
	return ans;
}
static long fastPow(long a, long b){
	long result =1;
	while(b>0){
		if(b%2==1)result = mul(result, a);
		a = mul(a, a);
		b/=2;
	}
	return result;
}
static long modInv(long x){
	return fastPow(x, MOD-2);
}	
static long nCr(long n, long r){
	return mul(fact(n), mul(modInv(fact(n-r)), modInv(fact(r))));
}