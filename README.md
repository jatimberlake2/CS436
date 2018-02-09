# CS436
Various assignments from CS 436 : Computer Security, some code and some concepts

CaesarCipher.java takes a string provided by the user and encrypts it by shifting every letter k values over in the alphabet, where the default k value is 8. The modulus operator is called in order to keep the values within the range of ASCII characters representing the alphabet, accounting for capital and lowercase letters as well.

OneTimePad.java takes a string provided by the user and encrypts it by ading the individual ASCII values of each character to the ASCII values of each of the characters in the one time pad string. The modulus operator is called in order to keep the values within the range of ASCII characters representing the alphabet, accounting for capital and lowercase letters as well. If the input string length exceeds the one time pad, then the values used to add to each character will start over at the beginning of the one time pad. This will provide perfect encryption, provided both parties have the one time pad. The default one time pad string is "thequickbrownfoxjumpsoverthelazydog" in this program. Several lines are commented out which show the intermediate steps in producing the calculations.

The midterm assignment and my answers are also provided.
