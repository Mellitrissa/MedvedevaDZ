package org.example;

import java.util.*;

public class Phonebook {
   private Map<String, List<String>> phonebook;

   public Phonebook(){
       this.phonebook= new HashMap<>();
   }
   public void add (String surname, String phoneNumber){
       List<String> phoneNumbers = phonebook.getOrDefault(surname, new ArrayList<>());
       phoneNumbers.add(phoneNumber);
       phonebook.put(surname, phoneNumbers);
   }
   public List <String> get (String surname){
      return phonebook.getOrDefault(surname, Collections.emptyList());
   }
}
