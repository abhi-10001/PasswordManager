import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
 
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
 
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
    public static void main(String [] args){
        System.out.println("Welcome!");
        System.out.print("Enter password: ");
        Scanner scan = new Scanner(System.in);
        String password = scan.next();
        String test = "";
        try{
            test = toHexString(getSHA(password));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        if(test.equals("610bd05271f43b0920f118aafbcb2edb1e26c85ee9e8121d005d3d36fe078b1a")) System.out.println("Login Successful");
        else System.out.println("Wrong Password");
    }

}