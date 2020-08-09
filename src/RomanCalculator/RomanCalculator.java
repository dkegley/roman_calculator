package RomanCalculator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class RomanCalculator {
	public static Scanner kbInput = new Scanner(System.in);

	public static String doMath(char operator, int firstNum, int secondNum) {
		/*
		 * This method will perform the arithmetic
		 * indicated by the operator (+ -* /),
		 * invoke convertToRoman to convert answer to Roman number,
		 * then return answer
		 * */
		int number_total = 0;
		
		String roman_total;
		if (firstNum == -1 || secondNum == -1)
			{
			roman_total = "Please input a valid roman number";
			return roman_total;
			}
		
		
			
		if (operator == '+') 
		{
			number_total = firstNum + secondNum;
		}
		else if (operator == '-') 
		{
			number_total = firstNum - secondNum;
		}
		else if (operator == '*') 
		{
			number_total = firstNum * secondNum;
		}
		else if (operator == '/') 
		{
			number_total = firstNum / secondNum;
		}
		else 
		{
			roman_total = "Your operand is bad, try again";
			return roman_total;
		}
		
		roman_total = convertToRoman(number_total);
		return roman_total;
	}
	

	public static char getOperator() {
		System.out.println("please choose an operator: +, - , * , or /");
		return kbInput.next().charAt(0);
	}

	public static int getOperands() {
	/*This routine should prompt the user to enter Roman number. 
	  convertFromRoman needs to be invoked to convert the Roman number to an integer.
	  If the input is invalid (-1 returned from convertFromRoman)
	  then complain and prompt the user again. 
	*/ 
		int roman_conversion;
		String number_1;
		System.out.println("Enter a Roman number: ");
		Scanner roman_number_1 = new Scanner(System.in);
		number_1 = roman_number_1.nextLine();
		
		roman_conversion = convertFromRoman(number_1);
		return roman_conversion;
	}
	public static int convertFromRoman(String romanNum) {
		/*
		 * This method will convert Roman number to integer
		 * return -1 when input is invalid
		 * 
		 * */
		int number = 0;
		romanNum = romanNum.toUpperCase();
		for (char ch : romanNum.toCharArray())
		{

			if (ch != 'M' && ch != 'D' && ch != 'C' && ch != 'L' && ch != 'X' && ch != 'V' && ch != 'I' && ch != ' ')
			{
			return -1;
			}
			
				
			
		}
		
		for (int i = 0; i < romanNum.length(); i++)
		{
			char c = romanNum.charAt(i);
			
			if (c == 'M' ) 
			{
				number += 1000;
			}
			else if (c == 'D' )
			{
				number += 500;
			}
			else if (c == 'C')
			{
				number += 100;
			}
			else if (c == 'L')
			{
				number += 50;
			}
			else if (c == 'X')
			{
				number += 10;
			}
			else if (c == 'V')
			{
				number += 5;
			}
			else if(c == 'I')
			{
				number += 1;
			}
		}
		return number;
	}
	public static String convertToRoman(int num) {
		/*
		 * This method will convert integer to Roman number
		 * */
		ArrayList<String> roman_total = new ArrayList<String>();
		int i = 0;
		String output;
		while (num >= 1000)
		{
			num -= 1000;
			roman_total.add("M");
			i += 1;
		}
		while (num >= 500)
		{
			num -= 500;
			roman_total.add("D");
			i += 1;
		}
		while (num >= 100)
		{
			num -= 100;
			roman_total.add("C");
			i += 1;
		}
		while (num >= 50)
		{
			num -= 50;
			roman_total.add("L");
			i += 1;
		}
		while (num >= 10)
		{
			num -= 10;
			roman_total.add("X");
			i += 1;
		}
		while (num >= 5)
		{
			num -= 5;
			roman_total.add("V");
			i += 1;
		}
		while (num >= 1)
		{
			num -= 1;
			roman_total.add("I");
			i += 1;
		}
		output = String.join(",", roman_total);
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result;
		do {

			result = doMath(getOperator(), getOperands(), getOperands());

			System.out.println(result);
			System.out.println("do you want to continue? y/n");
			kbInput.nextLine();
		} while (kbInput.nextLine().charAt(0) == 'y');
		System.out.println("Have a nice day!");
	}

}
/**
 please choose an operator: +, - , * , or /
+
Enter a Roman number: 
M
Enter a Roman number: 
mCxV
M,M,C,X,V
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
-
Enter a Roman number: 
XX
Enter a Roman number: 
v
X,V
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
*
Enter a Roman number: 
x
Enter a Roman number: 
lx
D,C
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
/
Enter a Roman number: 
dc
Enter a Roman number: 
x
L,X
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
+
Enter a Roman number: 
mmc
Enter a Roman number: 
lxvii
M,M,C,L,X,V,I,I
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
-
Enter a Roman number: 
m
Enter a Roman number: 
cxi
D,C,C,C,L,X,X,X,V,I,I,I,I
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
^
Enter a Roman number: 
M
Enter a Roman number: 
M
Your operand is bad, try again
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
+
Enter a Roman number: 
axi
Enter a Roman number: 
d
Please input a valid roman number
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
xi
Enter a Roman number: 
xi8i
Enter a Roman number: 
x
Please input a valid roman number
do you want to continue? y/n
y
please choose an operator: +, - , * , or /
+
Enter a Roman number: 
xi
Enter a Roman number: 
xii
X,X,I,I,I
do you want to continue? y/n
n
Have a nice day!
 **/



