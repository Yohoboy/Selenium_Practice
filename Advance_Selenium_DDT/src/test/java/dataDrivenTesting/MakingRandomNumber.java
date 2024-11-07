package dataDrivenTesting;

import java.util.Random;

public class MakingRandomNumber 
{

	public static void main(String[] args) 
	{
		Random random = new Random();
		int randomnumber = random.nextInt(10000);
		System.out.println(randomnumber);
		

	}

}
