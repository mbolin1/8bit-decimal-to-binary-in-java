/*
 * Matthew Bolin
 * COSC 221
 * Section 00
 * Winter 2016
 * Machine Problem #1 (Conversion)
 * The Purpose of this program is to convert a decimal number to a binary
 * number and vice versa.
 */
/****************************************************************************************/
import java.util.Scanner;
import java.util.Stack;

public class DecToBinConv {
	Scanner scan = null;
	Stack<Integer> binStack = null;
	
	DecToBinConv(){
		scan = new Scanner(System.in);
		startApp();
	}
	
	private void startApp(){
		boolean flag =  true;
		char selected;
		
		while(flag){
			dispMenu();
			selected =  scan.next().toLowerCase().charAt(0);
			scan.nextLine();
			switch(selected){
				case '1':
					decToBin();
					break;
				case '2':
					binToDec();
					break;
				case 'e':
					flag = false;
					break;
				default:
					System.out.println("\n*********INVALID ENTRY!********\n");
					break;
			}
		}
		
		System.out.println("Thank you for using Decimal and Binary converter!");
	}
	
	private void decToBin(){
		binStack =  new Stack<Integer>();
		System.out.println("-------------------------------");
		System.out.print("Enter a Decimal number: ");
		int decNum = scan.nextInt();
		decToBinRecursive(decNum);
		String binaryNum = "";
		while(!binStack.isEmpty()){
			binaryNum +=binStack.pop();
		}
		System.out.println(decNum+" in Binary is: "+binaryNum);
		
	}
	
	private void decToBinRecursive(int n){
		if(n > 0){
			binStack.push(n%2);
			decToBinRecursive(n/2);
		}
	}
	
	private void binToDec(){
		System.out.println("-------------------------------");
		System.out.print("Enter a Binary number: ");
		String binNum = scan.nextLine();
		int sumDec=0;
		for(int i = binNum.length()-1; i >= 0;i--){
			if(binNum.charAt(i)== '1' || binNum.charAt(i)== '0'){
				if(binNum.charAt(i)=='1'){
					sumDec += Math.pow(2, Math.abs(i-(binNum.length()-1)));
				}
			}
			else{
				System.out.println("Invalid Binary Number");
				return;
			}
		}
		System.out.println(binNum+" in Decimal is "+sumDec);
	}
	
	private void dispMenu(){
		System.out.println("-------------------------------");
		System.out.println("-------Select an option--------");
		System.out.println("|1) Convert Decimal to Binary |");
		System.out.println("|2) Convert Binary to Decimal |");
		System.out.println("|E) Exit Program              |");
		System.out.println("-------------------------------");
		System.out.print  ("Select one: ");
	}
	
	public static void main(String args[]){
		DecToBinConv app = new DecToBinConv();
	}
}
