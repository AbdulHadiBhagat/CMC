package Complains;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ComplainManager {

	public ComplainManager() {
		// TODO Auto-generated constructor stub
	}
	public boolean login = false;
	public ComplainManager( String name ,String Pass  ) {
		if(name == "Hadi" && Pass == "Bhagguuu")
		{
			
		System.out.println("Login Successfull");
		login = true;
			
		}
	}
	
	public void Respond() throws IOException
	{
		String[] responds = new String[10];
		FileInputStream fIn=null;
		   ObjectInputStream oIn=null;
		fIn= new FileInputStream("Responds.txt");
		int index = -1;
	    oIn = new ObjectInputStream(fIn);
	    for (int i = 0; i < responds.length; i++) {
			responds[i] = oIn.readLine();
			if(responds[i] == "")
			{
				index = i;
				break;
			}
		}
		FileOutputStream fOut;
		ObjectOutputStream oOut;
		System.out.println("1. Resolved");
		System.out.println("2. Cant Be Resolved / Unauthorized will send further");
		System.out.println("3. Read Pending");
		fOut = new FileOutputStream ("Responds.txt");
		oOut = new ObjectOutputStream(fOut);
		 int a = System.in.read();
		 if(a == 1)
		 {
			oOut.writeObject(new String (cf[index].ComplainId + " Resolved"));
		 }
		 else if (a==2)
		 {
			 oOut.writeObject(new String (cf[index].ComplainId + "Cant Be Resolved / Unauthorized will send further"));
		 }
		 else if ( a== 3)
		 {

			 oOut.writeObject(new String (cf[index].ComplainId + "Read Pending"));
		 }
		 
		 
		
	}
	ComplainInfo[] cf;
	public void ReadComplain() throws ClassNotFoundException
	{
		FileInputStream fIn=null;
		   ObjectInputStream oIn=null;
			   
		   try{
		    fIn= new FileInputStream("Complains.Ser");
		    oIn = new ObjectInputStream(fIn);
		    
		    cf = new ComplainInfo[10];
		    
		    
				cf= (ComplainInfo[])oIn.readObject();
			 
			
		    for (int i = 0; i < cf.length; i++) {
		    	if(cf[i].readkro == false)
		    	{

		    			System.out.println(cf[i].ComplainTitle);
		    			System.out.println(cf[i].Complains);
		    			cf[i].readkro = true;
		    			
		    	}
			 
			}
		   }catch (IOException e )
		   {

			   
		   }
	finally 
	{
		
	}
	}
}
