# Predictive-Text-Entry
Predictive Text Entry

Predictive Text Entry

1 Prototypes and design 

  This part deals with building a "prototype" for the predictive text problem, 
  which is not expected to be efficient, but it will be simple and allow you to compare it with the 
  efficient implementation to be done in later parts. Write the first two methods in a class named 
  PredictivePrototype inside the package predictive.

  Write a method wordToSignature with the type: The method takes a word and returns a numeric signature. 
  For example, "home" should return "4663". If the word has any non-alphabetic characters, replace them 
  with a " " (space) in the resulting signature. Accumulate the result character-by-character. 
  You should do this using the StringBuffer class rather than String. Explain, in your comments, 
  why this will be more efficient.

  Write another method signatureToWords with the type: It takes the given numeric signature and returns a set of 
  possible matching words from the dictionary. The returned list must not have duplicates and each word should 
  be in lower-case. The method signatureToWords will need to use the dictionary to find words that match the 
  string signature and return all the matching words. In this part of the exercise, you should not store the 
  dictionary in your Java program. Explain in the comments why this implementation will be inefficient.

  Create command-line programs (classes with main methods) as follows:

    Words2SigProto for calling the wordToSignature method, and
  Sigs2WordsProto for calling the signatureToWords method. Each program must accept a list of strings and call 
  the appropriate method to do the conversion.


2 Storing and searching a dictionary 

  In the remaining parts of the worksheet, you are asked to implement a number 
  of dictionary classes that will be more efficient than the prototype. All of these classes should implement this interface: 

        public interface Dictionary{ 
          public Set signatureToWords(String signature); 
       } 
  
  The required method signatureToWords finds the possible words that could correspond to a given signature and returns 
  them as a set. In this part, you will read and store the dictionary in memory as a list of pairs. As the list will be 
  sorted and in memory, a faster look-up technique can be used.

  Create a class named ListDictionary. 
  Write a constructor for the class ListDictionary that takes a String path to the dictionary, reads stores it in an ArrayList. 
  Each entry of the ArrayList must be a pair, consisting of the word that has been read in and its signature. 
  For this purpose, you will need to create a class named WordSig that pairs words and signatures (see the hints). 
  The wordToSignature method will be the same so you can re-use the code from the first part. 

  The signatureToWords method must be re-written as an instance method in the List- Dictionary class to use 
  the stored dictionary. The ArrayList must be stored in sorted order and the signatureToWords method must use 
   binary search to perform the look-ups.

  Design and create a command-line program Sigs2WordsList for testing the ListDictionary class. Compare the time taken 
  to complete the execution of Sigs2WordsList and Sigs2- WordsProto with the same large input(s). Is it possible to make 
  the time difference between Sigs2WordsList and Sigs2WordsProto noticeable? Make a note of the data you use and your 
  timing results.

3 More efficiency 

  This part involves creating an improved implementation of the Dictionary interface using a Map data 
  structure.

  Implement a new class MapDictionary. Write a constructor for the class MapDictionary that takes a String path to 
  the dictionary and stores the dictionary in a generic multi-valued Map. In this context, a "multi-valued map" is a 
  data structure that maps each signature to set of words. Using a Map, data can be retrieved quickly by looking up a 
  signature as in ListDictionary, but now it does not require scanning either side of the index as earlier. MapDictionary 
  will also allow efficient insertion of new words in the dictionary while still allowing fast look-up. You must choose 
  a Map implementation from the Java Collections API. Explain how the map works and justify your choice in a comment. 

  Write a method signatureToWords that returns, in a Set, only the matching whole words for the given signature. 
  The character length of each returned word must be the same as the input signature.

   Create a program Sigs2WordsMap that uses the MapDictionary class. It should be possible to modify just one line 
  in your Sigs2WordsList program so that it can work with any given implementation of the Dictionary interface.

4 Prefix-matching 

  This part involves creating another improved implementation of the Dictionary interface using 
  your own tree data structure. This should allow the words or parts of words that match partial signatures, so that 
  the users will be able to see the parts of the words they are typing as they type.

  Implement a new class TreeDictionary that now stores the dictionary in your own tree implementation. 
  It should support efficient search as well as efficient insertion of new words. In addition, TreeDictionary 
  should support finding words when only some initial part of the signature (a prefix) is known. This is so that the 
  user can see the part of the word they intend to type as they are typing. The TreeDictionary class forms a recursive 
  data structure, similar to, but more general than binary trees in the Worksheet 2 of this semester. This tree differs 
  in that each node now has up to eight branches, one for each number (2-9) that is allowed in a signature. 
  Each path of the tree (from the root to a node) represents a signature or part of a signature. 
  At each node of the tree, you must store a collection of all the words that can possibly match the 
  partial signature along the path. That means that every word that has a prefix corresponding to the partial signature 
  appears in the collection. For example, if the dictionary has the words a, ant and any, then the words at nodes 
  corresponding to paths would be as follows:

    at node 2, we have a, ant and any,
    at node 2; 6, we have ant and any.
    at node 2; 6; 8, we have only ant. 

  Write a constructor for the class TreeDictionary that takes a String path to the dictionary and populates 
  the tree with words. Write a method signatureToWords that returns, in a Set, the matching words (and prefixes of words) 
  for the given signature. The character length of each of the returned words or prefixes must be the same as the input 
  signature.
  Create a program Sigs2WordsTree, similar to Sigs2WordsMap, that uses the TreeDictionary class. Compare the time 
  taken to complete the execution of Sigs2WordsMap and Sigs2WordsTree with large inputs. Is it possible to make the 
  time difference between Sigs2WordsList and Sigs2WordsMap or Sigs2WordsTree and Sigs2WordsMap noticeable? Again, 
  make a note of the data you use and your timing results.
