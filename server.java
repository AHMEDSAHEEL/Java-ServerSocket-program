import java.io.*;
import java.net.*;

class server{
    public static void main(String args[])throws Exception
    {
      
      ServerSocket ss = new ServerSocket(50645);
      System.out.println("clent is waiting");
      Socket s = ss.accept();
      System.out.println("connection established");
       DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str1="",str2="";
      while(!str1.equals("stop"))
      {
         str1=din.readUTF();
        System.out.println("client: "+str1);
        System.out.print("Server: ");
        str2=br.readLine();
        dout.writeUTF(str2);
        dout.flush();
      
      }
      dout.close();
      s.close();
      
    }
    }
