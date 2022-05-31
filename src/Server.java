import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String arr[]) throws Exception
    {
        LinkedList ls=new LinkedList();

        ServerSocket ss=new ServerSocket(12345);
        Socket s=ss.accept();


        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

        boolean val=true;
        while(val)
        {
            String str=din.readUTF();
            int ch=Integer.parseInt(str);

            switch(ch)
            {
                case 1: int t=Integer.parseInt(din.readUTF());
                    ls.insert(t);
                    break;
                case 2: ls.delete();
                    break;
                case 3: String tmp=ls.display();
                    dout.writeUTF("Current List: "+tmp);
                    dout.flush();
                    break;
                case 4: val=false;
                    break;
            }
        }
    }
}
