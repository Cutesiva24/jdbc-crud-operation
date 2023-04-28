package com.palle;

import java.util.ArrayList;

public class HrDetails {

	public static void main(String[] args)
	{
		//HrCreateInsert.create();
		
		//HrCreateInsert.insert(1, "suma", "suma12@gmail.com", 3, 6434512345l);
		//HrCreateInsert.insert(2, "siva", "siva2@gmail.com", 4, 9878765650l);
		//HrCreateInsert.insert(3, "kishore","kish@yahoo.com", 6, 7789865432l);
		//HrCreateInsert.insert(4, "prashad", "pras@outlook.com", 2, 9956453210l); 
	
		//HrCreateInsert.delete(3);
		
		//HrCreateInsert.update("sudhan", "sud@yahoo.com", 4);
		
		 ArrayList<Hr> al=HrCreateInsert.display();
		 System.out.println(" ID  NAME      EMAIL     EXP     MOBILE ");
		 
		 for(Hr h : al)
		 {
			 System.out.println(h.getId()+ "  "+ h.getName()+ "   " + h.getEmail()+ "  " + h.getExp()+ "  " + h.getMobile());
		 }
		
	}

}
