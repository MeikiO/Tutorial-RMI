import java.rmi.*;  
public class MyClient{  
	public static void main(String args[]){  
		try{  
			Adder stub=(Adder)Naming.lookup("127.0.0.1");  
			System.out.println("Suma hecha resultado: 34 + 4 = "+ stub.add(34,4));
		}catch(Exception e){}  
	}  
}  