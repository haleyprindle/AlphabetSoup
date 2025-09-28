//Name: Haley Prindle
//Date: 09/24/25
//Description: This program helps the alphabet soup™ company produce soup that only contains letters that spell out specific words in order to influence customers subliminally.

public class Soup {
    //these are instance variables 
    private String letters;
    private String company;

    //this is a constructor it sets the instance variables (more on this later in the year)
    public Soup(){
        letters ="";
        company = "none";
    }


    //sets the name of the company to the provided name
    public void setCompany(String company){
        this.company = company;
    }

    //returns the company name
    public String getCompany(){
        return company;
    }

    //returns letters
    public String getLetters(){
        return letters;
    }

//below are the functions you'll be writing.

    //adds a word to the pool of letters known as "letters"
    //precondition- The value word contains a non-empty, non null string.
    //poscondition- returns nothing because it is a void.
    public void add(String word){
    if (word==null) return;
    letters = letters + word;

    }


    //Use Math.random() to get a random character from the letters string and return it.
    //precondition- Doesn't take any input
    //poscondition- returns a random letter as a char
    public char randomLetter(){
        int n = (int)(Math.random() *letters.length());

        char randomLetter = letters.charAt(n);
        return randomLetter;
    }


    //returns the letters currently stored with the company name placed directly in the center of all
    //the letters
    //precondition- Doesn't take any inputs
    //poscondition- returns a non null string
    public String companyCentered(){
        int n = letters.length () /2;
        String s = letters.substring (0,n) + company + letters.substring (n,letters.length());
        return s;
    } 


    //should remove the first available vowel from letters. If there are no vowels this method has no effect.
    //precondition- Takes no inputs
    //poscondition- returns nothing because it is a void.
    public void removeFirstVowel(){
      letters = letters.replaceFirst("[AUIOUaeiou]", "");  
    }

    //should remove "num" letters from a random spot in the string letters. You may assume num never exceeds the length of the string.
    //precondition- Num is not negative or greater than the string length
    //poscondition- returns nothing because it is a void.
    public void removeSome(int num){
        if (num<0) return;
        int maxRight = letters.length()-num+1;
        int startingIndex = (int)(Math.random()*maxRight);
        int endingIndex = startingIndex+num-1;
        letters= letters.substring(0, startingIndex) + letters.substring(endingIndex+1);
    }

    //should remove the word "word" from the string letters. If the word is not found in letters then it does nothing.
    //precondition- The value word contains a non-empty, non null string.
    //poscondition- returns nothing because it is a void.
    public void removeWord(String word){
        if (word==null) return;
        String tempString = ""; // build the new version of letters with word removed
        int  searchStart = 0; // index in letters to start searching for word
        int findLocation=-1; // index where word is found, -1 if not found
        boolean found = false; // is true if the word is found 1 or more times
        boolean complete = false; // is true when there are no more characters to search
        while(!complete)
        {
            findLocation = letters.indexOf(word, searchStart);
            if(findLocation > -1) // word is found
            {
                tempString += letters.substring(searchStart,findLocation);
                searchStart=findLocation+word.length(); // determine where we will start searching for another occurance of the word
                found = true;
            }
            else{
                complete=true; // there are no more occurrances of the word 
                if(found) // if there are one or more occurances of the word, write out any remaining characters 
                    tempString += letters.substring(searchStart);
            }
        }
        if(found)
        {
            letters = tempString; // if we removed 1 or more occurances of word, update letters
        }
    }
}
