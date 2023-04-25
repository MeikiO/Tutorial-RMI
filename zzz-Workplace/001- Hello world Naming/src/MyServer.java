import java.rmi.*;  
import java.rmi.registry.*;  
public class MyServer{  
	public static void main(String args[]){  
		try{  
			Adder stub=new AdderRemote();  
			Naming.rebind("127.0.0.1",stub);  
		}catch(Exception e){System.out.println(e);}  
	}  
}  