import java.io.Serializable;
import java.lang.*;
import java.util.regex.*;
public class RmiServant implements RmiInterface, Serializable
{
    int returnvalue = 0;
    boolean matchOutput;
    int[] indexArray = new int[2];
     public int[] patternmatching(String inputPattern, String inputString)
    {

        int[] indexArray = new int[2];
        int returnvalue = 0;
        boolean matchOutput;
        System.out.println(inputPattern + inputString);
        Pattern patternString = Pattern.compile(inputPattern);
        Matcher matcher = patternString.matcher(inputString);
        matchOutput = false;
        int x=0,y=0;
        while (matcher.find())
        {
            x=matcher.start();
            y=matcher.end();
            System.out.println("Found the text "+ matcher.group()+" starting at index "+ x + " and ending at index "+ y);
            matchOutput=true;
        }
        if (matchOutput == true)
        {
            indexArray[0] =x;
            indexArray[1] =y;
        }
        else
        {
            indexArray[0] = x;
            indexArray[1] = y;

        }
        return indexArray;

    }

}