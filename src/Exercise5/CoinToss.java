import java.util.Random;
import java.util.*;

public class CoinToss 
{
	
 static int zero=0, one=1, heads=2, tails=3;


	public static int fairCoin()
	{
		Random randomGenerator = new Random();
		int toss = randomGenerator.nextInt(2);
		return toss;
	}
	
	public static int biasCoin(int heads, int total)
	{
		Random randomGenerator = new Random();
		int toss = randomGenerator.nextInt(total+1);
		if(toss>heads) return 1;	
		return 0;
	}
	
	public static int UnbiasingBase()
	{
		int a=0,b=0;
		int c=0;
		while(a==b)
		{
			a=biasCoin(9500,10000);
			b=biasCoin(9500,10000);
			c++;
		}
		System.out.println("Executed "+c+" times");
		return a;
	}
	

	
	public static void main(String[] args)
	{
		int N = 1000;
		int zeros=0;
		int ones=0;
		for(int i=0; i < N; i++)
		{
			int toss=UnbiasingBase();
			if(toss==0) zeros++;
			if(toss==1) ones++;
		}
		double p0=(double)zeros/N;
		double p1=(double)ones/N;
		System.out.println("Fair coin P(0)="+p0);
		System.out.println("Fair coin P(1)="+p1);
	}
}
