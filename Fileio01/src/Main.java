import java.io.*;

public class Main {
    public static void main(String[] args) {
//Yazma
        try{
            File myFile= new File("/Users/yusufsahin/Projects/JavaWeb/Fileio01/out/production/Fileio01/dosya.txt");
            FileWriter writer= new FileWriter(myFile,true);
            writer.write("\nMerhaba Dünya, tekrar!");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//Okuma
        try{
            File myFile= new File("/Users/yusufsahin/Projects/JavaWeb/Fileio01/out/production/Fileio01/dosya.txt");
            FileReader fileReader= new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line=null;

            while ((line=reader.readLine())!=null)
            {
                System.out.println(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
             e.printStackTrace();
        }
    }
}