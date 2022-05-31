import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String arr[]) throws Exception
    {
        Socket s=new Socket("localhost",12345);

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        Scanner sc=new Scanner(System.in);

        boolean val=true;
        while(val)
        {
            System.out.print("\n\nLINKED LIST Implementation \n ");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Display");
            System.out.println("4.Exit");
            System.out.println("  \n\nYour choice:");
            int ch=sc.nextInt();
            dout.writeUTF(""+ch);
            dout.flush();
            switch(ch)
            {
                case 1: System.out.print("\nData to be inserted: ");
                    int t=sc.nextInt();
                    dout.writeUTF(""+t);
                    dout.flush();
                    break;
                case 2:
                    break;
                case 3: String tmp=din.readUTF();
                    System.out.println("\n"+tmp);
                    break;
                case 4: val=false;
                    break;
            }
        }
    }
}
