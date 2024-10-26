// Evelyn Salas
// CSE 143 AO with Stuart Reges
// Homework 1
// LetterInventory is a program that takes in a phrase and returns a count for each letter

import java.util.*;

public class LetterInventory {
   
   //the capacity of the array
   public static final int CAPACITY = 26;
   //array that stores characters in a given phrase
   private int[] LetterInventory;
   //size of the array 
   private int size;
    
   // constructs an array that keeps track of the times a letter appears
   // in a phrase ignoring the case, increases the size  
   public LetterInventory(String data) {
      LetterInventory = new int[CAPACITY];
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         if (Character.isLetter(data.charAt(i))) {
            LetterInventory[data.charAt(i) - 'a']++;
            size++;
         }
      }
   }

   //returns the count of a specific letter
   //throws illegalArgumentException if character is not a letter
   public int get(char letter) {
      if(Character.isLetter(letter)) {
         letter = Character.toLowerCase(letter);
         return LetterInventory[letter - 'a'];
      } else {
         throw new IllegalArgumentException("Please enter an alphabetic letter");
      }
   }

   //sets inventory to a specific value
   //throws illegalArgument exception if the character is not a letter
   //or if the given value is negative
   public void set(char letter, int value) {
      if (Character.isLetter(letter) || value > -1) {
         letter = Character.toLowerCase(letter);
         LetterInventory[letter - 'a'] = value;
         size += value - LetterInventory[letter - 'a'];
      } else {
         throw new IllegalArgumentException("Please enter alphabetic letter");
      }
   }

   //returns the size
   public int size() {
      return size;
   }

   //returns false if inventory is empty
   public boolean isEmpty() {
      return size == 0;
   }
   
   //returns letters in inventory in bracket format and alphabetical order
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String result = "[";
         for (int i = 0; i < size; i++) {
            for (int j = 0; j < LetterInventory[i]; j++) {
               result += (char) (i + 'a');
            }
         }
         return result += "]";
      }
   }
    
   // returns the sum of this letter inventory and another
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      for(int i = 0; i < CAPACITY; i++) {
         sum.LetterInventory[i] = other.LetterInventory[i] + this.LetterInventory[i];
      }
      return sum;
   }
    
   //returns the difference of this letter inventory and another
   //returns null if difference is negative
   public LetterInventory subtract(LetterInventory other){
      LetterInventory diff = new LetterInventory("");
      for (int i = 0; i < CAPACITY; i++) {
         diff.LetterInventory[i] = this.LetterInventory[i] - other.LetterInventory[i];
      
         if (LetterInventory[i] < 0) {
            return null;
         } else {
            return diff;
         }
      }
      return diff;
   }

}