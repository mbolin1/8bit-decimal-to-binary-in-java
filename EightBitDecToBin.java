/*
 * Matthew Bolin
 * COSC 221
 * Section 00
 * Winter 2016
 * Machine Problem #1 (Conversion)
 * The Purpose of this program is to convert a decimal number (0-255)
 * to an 8-bit binary number and vice versa.
 */
/****************************************************************************************/
import java.util.Scanner;
import java.util.Stack;

public class EightBitDecToBin {
	Scanner scan = null;
	Stack<Integer> binStack = null;
	
	EightBitDecToBin(){
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
		boolean flag = true;
		int decNum=0;
		while(flag){
			System.out.println("Please enter Decimal number(0-255): ");
			try{
				decNum = scan.nextInt();
			}
			catch(Exception e){
				scan = new Scanner(System.in);
				decNum=-1;
			}
			if(decNum >= 0 && decNum <= 255){
				flag = false;
			}else{
				System.out.println("\n*********INVALID ENTRY!********\n");
			}
		}
		decToBinRecursive(decNum);
		String binNum = "00000000";
		while(!binStack.isEmpty()){
			binNum += binStack.pop();
		}
		binNum = binNum.substring(binNum.length() - 8, binNum.length());
		System.out.println(decNum + " in Binary is "+ binNum);
	}
	
	private void decToBinRecursive(int n){
		if(n > 0){
			binStack.push(n%2);
			decToBinRecursive(n/2);
		}
	}
	
	private void binToDec(){
		while(true){
			int sumDec=0;
			boolean flag=true;
			System.out.println("Please enter an 8-bit Binary Number: ");
			String binNum =  scan.next();
			if(binNum.length()!=8){
				System.out.println("\n*********INVALID ENTRY!********\n");
			}else{
				for(int i=0; i<binNum.length();i++){
					if(binNum.charAt(i)!= '1'&&binNum.charAt(i)!='0'){
						System.out.println("\n*********INVALID ENTRY!********\n");
						flag=false;
						break;
					}
				}
				if(flag){
					for(int i= binNum.length()-1; i>=0;i--){
						if(binNum.charAt(i)=='1')
							sumDec += Math.pow(2, Math.abs(i-(binNum.length()-1)));
					}
					System.out.println(binNum+" in decimal is "+sumDec);
					return;
				}
			}
		}
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
		EightBitDecToBin app = new EightBitDecToBin();
	}
}

/* Output
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 1
Please enter Decimal number(0-255): 
0
0 in Binary is 00000000
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 1
Please enter Decimal number(0-255): 
255
255 in Binary is 11111111
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 1
Please enter Decimal number(0-255): 
256

*********INVALID ENTRY!********

Please enter Decimal number(0-255): 
abba

*********INVALID ENTRY!********

Please enter Decimal number(0-255): 
54
54 in Binary is 00110110
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 2
Please enter an 8-bit Binary Number: 
abababab

*********INVALID ENTRY!********

Please enter an 8-bit Binary Number: 
1010101010101010

*********INVALID ENTRY!********

Please enter an 8-bit Binary Number: 
00000000
00000000 in decimal is 0
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 2
Please enter an 8-bit Binary Number: 
11111111
11111111 in decimal is 255
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 2
Please enter an 8-bit Binary Number: 
10101010
10101010 in decimal is 170
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 2
Please enter an 8-bit Binary Number: 
01010101
01010101 in decimal is 85
-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: 3

*********INVALID ENTRY!********

-------------------------------
-------Select an option--------
|1) Convert Decimal to Binary |
|2) Convert Binary to Decimal |
|E) Exit Program              |
-------------------------------
Select one: e
Thank you for using Decimal and Binary converter!

 */
