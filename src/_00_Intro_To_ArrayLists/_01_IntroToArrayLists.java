package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList<String> list = new ArrayList<String>();
        // 2. Add five Strings to your list
    	list.add("Meddle");
    	list.add("Dark Side of the Moon");
    	list.add("Wish You Were Here");
    	list.add("Animals");
    	list.add("The Wall");
        // 3. Print all the Strings using a standard for-loop
    	for (int i = 0; i < list.size(); i++)
    	{
    		System.out.println(list.get(i));
    	}
    	System.out.print("\n");
        // 4. Print all the Strings using a for-each loop
    	for (String s : list)
    	{
    		System.out.println(s);
    	}
    	System.out.print("\n");
        // 5. Print only the even numbered elements in the list.
    	for (int i = 1; i < list.size(); i += 2)
    	{
    		System.out.println(list.get(i));
    	}
    	System.out.print("\n");
        // 6. Print all the Strings in reverse order.
    	for (int i = list.size() - 1; i <= 0; i --)
    	{
    		System.out.println(list.get(i));
    	}
    	System.out.print("\n");
        // 7. Print only the Strings that have the letter 'e' in them.
        for (String s : list)
        {
        	if (s.contains("e"))
        	{
        		System.out.println(s);
        	}
        }
    }
}
