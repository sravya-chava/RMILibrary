import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class RmiServer{
    public static void main(String args[])
    {

        while (true) {
            try{
                ServerSocket serverSocket=new ServerSocket(2014);
                Socket childSocket=null;
                childSocket=serverSocket.accept();
                System.out.println("New client is connected : " + childSocket);
                DataInputStream input = new DataInputStream(childSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(childSocket.getOutputStream());
                ObjectOutputStream objout = new ObjectOutputStream(childSocket.getOutputStream());
                Thread t = new subServer(childSocket,objout,input, output);
                t.start();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
            }
        }
class subServer extends  Thread{
        Socket childSocket;
        DataInputStream input;
        DataOutputStream output;
        ObjectOutputStream objout;
        subServer(Socket childSocket, ObjectOutputStream objout, DataInputStream input, DataOutputStream output){
            this.childSocket = childSocket;
            this.objout = objout;
            this.input = input;
            this.output = output;
        }
        public void run(){
        RmiServant servantobj1 = new RmiServant();
        RmiServant2 servantobj2 = new RmiServant2();
           String name1 = "firstobj";
           String name2 = "secondobj";
            try {
                output.writeUTF(name1);
                objout.writeObject(servantobj1);
                output.writeUTF(name2);
                objout.writeObject(servantobj2);


            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Two Objects registered");
}
}
