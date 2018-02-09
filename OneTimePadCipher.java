import java.util.ArrayList;
import java.util.Scanner;

public class OneTimePadCipher {

	public static void main(String[] args) {			
		String oneTimePad = "thequickbrownfoxjumpsoverthelazydog";
		//String oneTimePad = "asdsdtslrstsjndflksdfkdskhgsdlaoierittdzzzxcvbnasdfghjkqwertyuiopzxcvbnmkefjdfghsgahsjclzxasdietelkfsjhadsjasdmasddkjasdkjadfasjdhjakshfjkwjgdfsjfakdjkafhqsdasfakjbfhjasdhbasmdasdasjkdaskjdasjdasdasjkdasdswwqeqkkkrgfndfsdlkgg";
		Scanner derp = new Scanner(System.in);
		//Go forever until you stop with a "!"
		while (true)
		{
			System.out.println("Please enter something to be encrypted.\n");
			System.out.println("You may also enter a single \"!\" to quit.");
			String line = derp.nextLine();
			if (line.equals("!"))
				break;
			ArrayList<Character> sequence = new ArrayList<Character>();
			for (char character : line.toCharArray())
				sequence.add(character);			
			/*
			ArrayList<Character> sequence2 = new ArrayList<Character>();
			for (char character : oneTimePad.toCharArray())
				sequence2.add(character);
			System.out.println("Input string and associated ASCII values: ");
			for (char character : sequence)
				System.out.print(character + " (" + (int)character + "), ");
			System.out.println("\nOne Time Pad and associated ASCII values: ");
			for (char character : sequence2)
				System.out.print(character + " (" + (int)character + "), ");
			*/
			
			System.out.println("\nThe encrypted sequence is : ");
			oneTimeEncryption(sequence, oneTimePad);
			printSequence(sequence);
			System.out.println("\n\n");
		}
		derp.close();
	}
	
	private static void printSequence(ArrayList<Character> list)
	{
		/*
		for (char character : list)
		{
			if (Character.isUpperCase(character))
				System.out.print("(" + ((int)character - 65) + "), ");
			else
				System.out.print(" (" + ((int)character - 97) + "), ");
		}
		System.out.println();
		for (char character : list)
		{
			System.out.print(character + " (" + (int)character + "), ");
		}
		System.out.println();
		*/
		
		for (char character : list)
		{
			System.out.print(character);
		}
	}
	
	private static void oneTimeEncryption(ArrayList<Character> list, String OTP)
	{
		char[] OTPseq = OTP.toCharArray();
		if (OTP == "")
				return;
		for (int i = 0; i < list.size(); i++)
			//First check cases of the input One Time Pad sequence values for robustness.
		{
			//Check if the current character in the One Time Pad sequence is lower case
			if (Character.isLowerCase(OTPseq[i%OTPseq.length]))
				{	//Check if the current character in the input string is upper or lower case or a digit.
				if (Character.isUpperCase(list.get(i)) )
					list.set( i, (char)( ( ( (  (int)OTPseq[i%OTPseq.length]+(int)list.get(i)  ) % 26) + 65) ) ) ;
				else if (Character.isLowerCase(list.get(i)))
					list.set( i, (char)( ( ( (  (int)OTPseq[i%OTPseq.length]+(int)list.get(i) ) % 26) + 97) ) ) ;
				else
					list.set(i, (char) list.get(i));
				}
			//Check if the current character in the One Time Pad sequence is upper case
			else if (Character.isUpperCase(OTPseq[i%OTPseq.length]))
				{	//If the input string exceeds the One Time Pad string in length, the values of the  OTPseq will repeat.
					if (Character.isUpperCase(list.get(i)) )
						list.set( i, (char)( ( ( ( (int)OTPseq[i%OTPseq.length]+(int)list.get(i)) % 26) + 65) ) ) ;
					else if (Character.isLowerCase(list.get(i)))
						list.set( i, (char)( ( ( ( (int)OTPseq[i%OTPseq.length]+(int)list.get(i) ) % 26) + 97) ) ) ;
					else
						list.set(i, (char) list.get(i));
					}

			else
				{
					System.out.println("Not available.\nInvalid One Time Pad value(s) detected.\nSystem terminating.");
					System.exit(1);
				}

			}
	}
}
