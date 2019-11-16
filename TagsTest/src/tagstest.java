import java.util.Scanner;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class tagstest 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		 MaxentTagger tagger = new MaxentTagger(
		         "models/english-left3words-distsim.tagger");
		 Scanner sc = new Scanner(System.in); 
	
	        
		 // The sample string
		 System.out.println(" 1.	CC	Coordinating conjunction\r\n" + 
		 		"	2.	CD	Cardinal number\r\n" + 
		 		"	3.	DT	Determiner\r\n" + 
		 		"	4.	EX	Existential there\r\n" + 
		 		"	5.	FW	Foreign word\r\n" + 
		 		"	6.	IN	Preposition or subordinating conjunction\r\n" + 
		 		"	7.	JJ	Adjective\r\n" + 
		 		"	8.	JJR	Adjective, comparative\r\n" + 
		 		"	9.	JJS	Adjective, superlative\r\n" + 
		 		"	10.	LS	List item marker\r\n" + 
		 		"	11.	MD	Modal\r\n" + 
		 		"	12.	NN	Noun, singular or mass\r\n" + 
		 		"	13.	NNS	Noun, plural\r\n" + 
		 		"	14.	NNP	Proper noun, singular\r\n" + 
		 		"	15.	NNPS	Proper noun, plural\r\n" + 
		 		"	16.	PDT	Predeterminer\r\n" + 
		 		"	17.	POS	Possessive ending\r\n" + 
		 		"	18.	PRP	Personal pronoun\r\n" + 
		 		"	19.	PRP$	Possessive pronoun\r\n" + 
		 		"	20.	RB	Adverb\r\n" + 
		 		"	21.	RBR	Adverb, comparative\r\n" + 
		 		"	22.	RBS	Adverb, superlative\r\n" + 
		 		"	23.	RP	Particle\r\n" + 
		 		"	24.	SYM	Symbol\r\n" + 
		 		"	25.	TO	to\r\n" + 
		 		"	26.	UH	Interjection\r\n" + 
		 		"	27.	VB	Verb, base form\r\n" + 
		 		"	28.	VBD	Verb, past tense\r\n" + 
		 		"	29.	VBG	Verb, gerund or present participle\r\n" + 
		 		"	30.	VBN	Verb, past participle\r\n" + 
		 		"	31.	VBP	Verb, non-3rd person singular present\r\n" + 
		 		"	32.	VBZ	Verb, 3rd person singular present\r\n" + 
		 		"	33.	WDT	Wh-determiner\r\n" + 
		 		"	34.	WP	Wh-pronoun\r\n" + 
		 		"	35.	WP$	Possessive wh-pronoun\r\n" + 
		 		"	36.	WRB	Wh-adverb");
	        System.out.println("Enter the Sentence to find the Parts of speach");
		 String sample = sc.nextLine();
		 //System.out.println("Name: "+sample); 

		 // The tagged string
		 String tagged = tagger.tagString(sample);
//
		 // Output the result
		 System.out.println("TAGGED VALUESs");
		 System.out.println(tagged);
		 System.out.println("|");
		 System.out.println("|");
		 System.out.println("|");
		 System.out.println("|");
		 String word = "NN"; 
		 String np_word = "NNP"; 
		 String ns_word = "NNS"; 
		 String nps_word = "NNPS"; 
		 
		System.out.println(countOccurences(tagged, word,np_word,ns_word,nps_word)); 
		 
		}
	static int countOccurences(String tagged, String n_word, String np_word,String ns_word,String nps_word)  
	{ 
	    // split the string by spaces in a 
	    String x[] = tagged.split(" "); 
	  
	    // search for pattern in tagged 
	    int count = 0;
	    int noun_count = 0;
	    int counter = 0;
	    for (int i = 0; i < x.length; i++)  
	    { 
	    	String y[] = x[i].split("_");
	    	
	    	for(int j=0; j < y.length; j++)
	    	{
	    		if (n_word.equals(y[j]))
	    		 {
	    			counter = 0;

    		        for (int k = 0; k < y.length; k++) 
    		        {
    		            String temp = y[k];
    		            String temp1 = y[j-1];

    		            if (k < j && temp.contentEquals(temp1)) {
    		                break;

    		            }
    		            if (temp.contentEquals(temp1)) {
    		                counter = counter + 1;

    		            }

    		            if (k == y.length - 1) 
    		            {
    		                System.out.println(">>" + y[j-1] + "<< is present >>" + counter + "<< number of times");

    		            }

    		        }

	    			  
	    		 }
	    		        
	    		    


	    		 
	    		 
	    	}
	    	
	           // if match found increase count 
	          // if (word.equals(x[i])) 
	          count++; 
	    	 
		    
	    } 
	  System.out.print("Number of nouns available are :      ");
	   System.out.println(noun_count);
	    System.out.print("Total number of words inserted :    ");
	    return count ;
	}  
	
}

























//tagstest tg=new tagstest();
			// tg.getWordsByProperty(text, "NN")
//public List getWordsByProperty(File f, String Property)
//{
		//return "";
//}


