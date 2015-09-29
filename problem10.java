class problem10{

public static void main(String[] args){
	boolean[] primes = new boolean[2000000 + 1];
	primes = populatePrimeArray(primes, primes.length -1);
	long sum = returnSum(primes);
	System.out.println(sum);
}

public static boolean isPrime(int n){

	if(n % 2 ==0){return false;}
	
	for(int i=3;i<=Math.sqrt(n);i+=2) {
        if(n%i==0){
            return false;}
    	}
	return true;
}
public static boolean[] populatePrimeArray(boolean[] primes, int n){
	
	for(int i=2; i<=n; i++){primes[i]=true;}
	for(int i=4; i<=n; i+=2){
		primes[i] = false;
	}
	for(int i=3; i<=n; i+=2){
		if(isPrime(i)){
			for(long j=((long)i*(long)i);j<=(long)n; j+=i){
				primes[(int)j]=false;
			}
		}
	}
	return primes;
}
public static long returnSum(boolean[] primes){
	long sum = 0;
	for(int i=1; i<=primes.length-1;i++){
		if(primes[i]==true){sum += i;}
	}
	return sum;
}
}
