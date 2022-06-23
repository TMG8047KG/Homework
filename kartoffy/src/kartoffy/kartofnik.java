package kartoffy;

import java.util.Arrays;
import java.util.Scanner;

public class kartofnik {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int choose = inp.nextInt();
		
		if(choose == 1)
			purviKartof();
		else if(choose == 2)
			ftoriKartof();
		else if(choose == 3)
			trofiKrotofi();
		else if(choose == 4)
			domatenKartof();
		inp.close();
	}
	
	static void purviKartof() {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int[] arr = new int[n+1];
		int sec = 0;
		
		for(int i = 0; i<n; i++) {
			arr[i]= inp.nextInt();
		}
		inp.close();
		Arrays.sort(arr);
		
		for(int i = 0; i<n;i++) {
			if(arr[i]<arr[i+1]) {
				sec = arr[i];
			}
		}
		System.out.println(sec);
		
	}
	
	static void ftoriKartof() {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int eli[] = new int[n+1];
		int a = 0, b = 0, lenght = 0, temp=0, num = 0;
		
		for(int i = 0; i < n; i++) {
			eli[i] = inp.nextInt();
		}
		
		Arrays.sort(eli);
		
		eli[n]=eli[n-1]+1;
		
        while (a<n) {
            while (eli[a]==eli[b]) {
            	b++;
            }
            lenght = b - a;
            a++;
            if(lenght > temp) {
            	temp = lenght;
            	num = eli[a];
            } 
        }
        System.out.println("voila:" + num);
		
		inp.close();
	}
	
	static void trofiKrotofi() {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int arr[] = new int[n+1];
		
		for(int i = 0; i<n;i++) {
			arr[i] = inp.nextInt();
		}
		
		for(int i = 1; i<n;i+=2) {
			arr[i] = (arr[i-1]+arr[i+1])/2;
		}
		
		for(int i = 0; i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
		inp.close();
	}
	
	
	//Chaos Mode ON (Music involved)
	static void domatenKartof() {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int domatenikartofi[] = new int[n];
		int a = inp.nextInt();
		int b = inp.nextInt();
		int c = inp.nextInt();
		//I got this feeling on a summer day
		int summerdays = inp.nextInt();
		int iFoundU = 0;
		
		domatenikartofi[a] = 1;
		domatenikartofi[b] = 1;
		domatenikartofi[c] = 1;
		
		
		
		for(int i = summerdays;i < 0; i --) {
			for(int domat = 1; domat<n;domat++) {
				if(domatenikartofi[domat]==1) {
					domatenikartofi[domat+1]=1;
					domatenikartofi[domat-1]=1;
				}
			}
		}
		
		
		for(int i = 1; i<n;i++) {
			System.out.print(domatenikartofi[i] + " ");
		}
		
		for(int i = 1; i<n;i++) {
			if(domatenikartofi[i] == 0) {
				iFoundU++;
			}
		}
		System.out.println(iFoundU);
		inp.close();
	}

}
