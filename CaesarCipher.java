import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {	
		System.out.println("Please enter something to be encrypted.");
		System.out.println("Puncuation and special characters will stay the same.");
		System.out.println();
		Scanner derp = new Scanner(System.in);
		while (true)
		{
			System.out.println("Enter a single \"!\" to quit.");
			String line = derp.nextLine();
			if (line.equals("!"))
				break;
			ArrayList<Character> sequence = new ArrayList<Character>();
			for (char letter : line.toCharArray())
				sequence.add(letter);
			System.out.println("The encrypted sequence is : ");
			encryptSequence(sequence);
			printSequence(sequence);
			System.out.println();
			System.out.println();
		}
		derp.close();
	}
	
	private static void printSequence(ArrayList<Character> list)
	{
		for (char letter : list)
		{
			System.out.print(letter);
		}
	}
	
	private static void encryptSequence(ArrayList<Character> list)
	{
		int E, k = 8;
		for (int i = 0; i < list.size(); i++ ){
			if (Character.isUpperCase(list.get(i)))
				E = (((int) list.get(i)-65)+k)%26+65;
			else if (Character.isLowerCase(list.get(i)))
				E = (((int) list.get(i)-97)+k)%26+97;
			else if (Character.isDigit(list.get(i)))
				E = (((int) list.get(i)-48)+k)%10+48;
			else
				E = (int) list.get(i);
			list.set(i, (char) E);
		}
	}
}
