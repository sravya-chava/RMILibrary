import java.io.Serializable;
import java.lang.*;
import java.net.*;

public class RmiServant2 implements  RmiInterface2,Serializable {
    public int palindromecheck(String input)
    {

        StringBuffer str = new StringBuffer(input);
        String str1 = str.toString();
        StringBuffer str2 = str.reverse();
        int returnvalue = str1.compareTo(str2.toString());
        if (returnvalue == 0)
            return 1;
        else
            return 0;
    }
}
