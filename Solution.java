import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        long x=n;
        Integer [] binary=new Integer[32];
        Integer [] trueBinary=new Integer[32];
        Integer [] flippedBinary=new Integer[32];
        Integer [] bitsArrayReversed=new Integer[32];

        int quotient=0;
        int i;
        for(i=0;x!=1;i++)
        {
            if(x%2==0)
            {
                binary[i]=0;
                x=x/2;
            }

            else
            {
                binary[i]=1;
                x=x/2;
            }
        }
        if(x==1)
        {
            binary[i]=1;
        }
        
        for(int j=0;j<binary.length;j++)
        {
            if(binary[j]==null)
            {
                binary[j]=0;
            }

        }

        // for(int temp:binary)
        // {
        //     System.out.println(temp);
        // }
        int index=0;

        for(int y=binary.length-1;y>=0;y--)
        {
            trueBinary[index]=binary[y];
            index++;

        }





        for(int m=0;m<trueBinary.length;m++)
        {
            if(trueBinary[m]==1)
            {
                flippedBinary[m]=0;
            }
            else
            {
                flippedBinary[m]=1;
            }
        }



        int counter=0;

        for(int io=(flippedBinary.length-1);io>=0;io--)
        {
            
            bitsArrayReversed[counter]=flippedBinary[io];
            counter++;
            
        }


        double sum=0;
        for(int iol=0;iol<bitsArrayReversed.length;iol++)
        {
            
            sum=sum+(bitsArrayReversed[iol]* Math.pow(2,iol));

        }
        return (long)sum;

   


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
