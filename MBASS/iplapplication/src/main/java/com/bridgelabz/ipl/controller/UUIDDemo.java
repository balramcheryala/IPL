/**
 * 
 */
package com.bridgelabz.ipl.controller;

/**
 * @author bridgelabz
 *
 */
import java.util.*;

public class UUIDDemo {
   public static void main(String[] args) {
   // creating UUID      
   @SuppressWarnings("unused")
UUID uid = UUID.fromString("b0774692-23a9-4889-9b94-196bfe8520fa");     
        
   // checking the value of random UUID
   for(int i=0;i<100;i++){
   System.out.println("Random UUID value: "+UUID.randomUUID());    
   }    
   }
}