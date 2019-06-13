import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.net.*;
import  java.io.*;
import java.lang.*;
public class registryClass implements Serializable {
    static HashMap<String,Object> h = new HashMap<String,Object>();
    public static void main(String args[]) throws IOException {
        InetAddress ip = InetAddress.getByName("localhost");
        Socket registrySocket = new Socket(ip,2014);
        DataOutputStream output = new DataOutputStream(registrySocket.getOutputStream());
        DataInputStream input = new DataInputStream(registrySocket.getInputStream());
        ObjectInputStream objin = new ObjectInputStream(registrySocket.getInputStream());
        Object obj1;
        String name1 = input.readUTF();
        try {
            obj1 = objin.readObject();
            bind(name1,obj1);
            String name2 = input.readUTF();
            obj1 =  objin.readObject();
            bind(name2,obj1);
            for (Map.Entry<String, Object> entry : h.entrySet()) {
                String key = entry.getKey();
                Object object = entry.getValue();
                System.out.println("key is :" + key);
                System.out.println(object + "object is:");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
     static void bind(String name, Object obj){
         h.put(name, obj);
     }

     static void rebind (String name, Object obj){
         h.remove(name, obj);
         h.put(name, obj);
     }

     static Object lookup (String name, Object obj){
         Object robj = h.get(name);
         return robj;
     }

     static void list ( int name, Object obj){
         for (Map.Entry<String, Object> entry : h.entrySet()) {
             String key = entry.getKey();
             Object object = entry.getValue();
             System.out.println("key is :" + key);
             System.out.println(object + "object is:");
         }
     }
     }
