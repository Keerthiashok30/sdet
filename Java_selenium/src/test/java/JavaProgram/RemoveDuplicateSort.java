package JavaProgram;

import java.util.*;

public class RemoveDuplicateSort 
{
	public static void main(String[] args)
	{
		
		int[] array = {10,40,70,70,80,40};
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<array.length;i++)
		{
		     set.add(array[i]);
		}
		System.out.println(set);
		
		 List<Integer> list = new ArrayList<Integer>(set); 
	     Collections.sort(list); 
	     System.out.println(list);
	     Collections.reverse(list);
	     System.out.println(list);
	     
	}

}
