import java.util.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.lang.*;
public class RmiClient
{
    public static void main(String args[]) throws Exception
    {
        try
         {
            InetAddress ip = InetAddress.getByName("localhost");
            Socket childSocket = new Socket(ip,8302);
            DataOutputStream output = new DataOutputStream(childSocket.getOutputStream());
            DataInputStream input = new DataInputStream(childSocket.getInputStream());
            final ObjectInputStream mapInputStream = new ObjectInputStream(input);
            //.readObject();
            registryClass remObj = new registryClass();

            output.writeUTF();
            RmiServant palindromeobj = remObj.lookup(firstobj);
            RmiServant patternobj = remObj.lookup(secondobj);
            Scanner scn = new Scanner(System.in);
            int returnvalue = 0;
            int[] indexArray = new int[2];
            int flag = 0;
            String clientInput = " ";
            String patternInput = " ";
            String clientOption;

            System.out.println("Please enter your option 1.IntegerPalindromeCheck 2.StringPalindromeCheck 3.PatternMatcher");
            clientOption = scn.nextLine();

            if(clientOption.equals("1"))
            {
                System.out.println("Please enter your number");
                clientInput = scn.nextLine();
                //returnvalue = palindromeobj.palindromecheck(clientInput);
                if (returnvalue == 1)
                {
                    System.out.println("The given Numebr is a Palindrome");
                }
                else
                {
                    System.out.println("The given Number is not a Palindrome");
                }
            }
            else if(clientOption.equals("2"))
            {
                System.out.println("Please enter your String");
                clientInput = scn.nextLine();
                //returnvalue = palindromeobj.palindromecheck(clientInput);
                if (returnvalue == 1)
                {
                    System.out.println("The given string is a Palindrome");
                }
                else
                {
                    System.out.println("The given string is not a Palindrome");
                }
            }
            else
            {
                System.out.println("Please enter your word to apply pattern matching");
                clientInput= scn.nextLine();
                System.out.println("Please enter the pattern you are checking for");
                patternInput= scn.nextLine();
                System.out.println("Your Input String is :" + clientInput);
                System.out.println("Your Pattern to be matched is :" + patternInput);
                //indexArray = patternobj.patternmatching(patternInput,clientInput);
                if(indexArray[0]!=0 && indexArray[1]!=0) {
                    System.out.println("Pattern found");
                    System.out.println("print start index is "+indexArray[0]);
                    System.out.println("print end index is "+indexArray[1]);
                }else{
                    System.out.println("Pattern Not found");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception" + e);
        }
        finally {
            //mapInputStream.close();
        }
    }
}