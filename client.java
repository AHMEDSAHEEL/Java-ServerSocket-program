import java.io.*;
import java.net.*;

class client{
    public static void main(String args[])throws Exception
    {
    
      
     Socket s = new Socket("localhost",50645);
      System.out.println("clent is ready");
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str1="",str2="";
      while(!str1.equals("stop"))
      {
        System.out.print("client: ");
        str1=br.readLine();
        dout.writeUTF(str1);
        dout.flush();
        str2=din.readUTF();
        System.out.println("server: "+str2);
      }
      dout.close();
      s.close();

      
    


    }
}