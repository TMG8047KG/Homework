import java.util.Scanner;

public class st14 {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n=inp.nextInt(), x=inp.nextInt(), num;
		char[] abc = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String res = "";
		
		while(n!=0) {
			num = n % x;
			if(num >= 10) {
				res = abc[num - 10] + res;
			}else {
				res = num + res;
			}	
			n/=x;
		}
		System.out.println(res);
	}
}
