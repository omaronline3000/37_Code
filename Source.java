import java.util.*;
import java.io.*;

class Converter {
    private long old_number;
    private String new_number;
    private static String Author;
    Converter(){
        Author = "Pyramid";
    }
    Converter(String Author){
        this.Author = Author;
    }
    public void SetAuthor(String name){
        Author = name;
    }
    public String GetAuthor(){
        return Author;
    }
    
    public String Encode(long number){
        old_number = number;
        long Operation_coff = 37 * old_number;
        StringBuffer str_Operator = new StringBuffer(Operation_coff+"");
        str_Operator.reverse();
        for(int i = 0 ;  i < str_Operator.length() ; i++){
                if(i % 2 != 0)
                    str_Operator.insert(i,'0');
        }
        long long_operator = Long.parseLong(str_Operator.toString());
        long_operator/=37;
        new_number = long_operator+"";
        return new_number;

    }

    public String Decode(long number){
        old_number = number;
        old_number*=37;
        StringBuffer str_Operator = new StringBuffer(old_number+"");
        for(int i = 0 ; i < str_Operator.length() ; i++){
            if(str_Operator.charAt(i) == '0'){
                str_Operator.delete(i, i+1);
            }
        }
        str_Operator.reverse();
        long long_operator = Long.parseLong(str_Operator.toString());
        long_operator/=37;
        new_number = long_operator+"";
        return new_number;
    }

}

public class Source {
    public static void main(String[] args){
    Scanner input  = new Scanner(System.in);
    Converter cv = new Converter();
    boolean repeat = true;
    while (repeat) {
      
    System.out.println("\nChoose any option : \n\n\n"+
    "1 - Enter Encrypter's name\n\n\n"+
    "2 - Enter the number to Encrypt\n\n\n"+
    "3 - Enter the number to Decrypt\n\n\n"+
    "4 - Knowing the current Author\n\n\n"+
    "5 - Log out.\n"
    );
    System.out.print("Enter: ");
    Byte choice = input.nextByte();
    switch (choice) {
        case 1:
            System.out.print("Name: ");
            String Author_Name = input.next();
            cv.SetAuthor(Author_Name);
            break;
        case 2:
            System.out.print("Number to Encrypt: ");
            long en_Number = input.nextLong();
            System.out.printf("the Encrypted number is %s%n",cv.Encode(en_Number));
            new Scanner(System.in).nextLine();
            break;
        case 3:
            System.out.print("Number to Decrypt: ");
            long de_Number = input.nextLong();
            System.out.printf("The Decrypted number is %s%n",cv.Decode(de_Number));
            new Scanner(System.in).nextLine();
            break;
        case 4:
                System.out.format("the current author is %s%n",cv.GetAuthor());
                new Scanner(System.in).nextLine();
             break;
        case 5:
                System.out.println("\nGood Bye!!\n");
                repeat = false;
                break;

        default:
            System.out.println("Invalid Choice.\n");
            break;
            }
        }
    }
}
