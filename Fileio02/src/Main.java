import java.io.*;

public class Main {
    public static void main(String[] args)  {
        try {

            //Person nesnesini oluşturdum ve yazdım
            ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream("person.ser"));
            Person person= new Person("John",25);

            outputStream.writeObject(person);

            outputStream.close();

            //Yukarıdaki nesneyi dosya sisteminden okuyup ekrana yazdırdım
            ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream("person.ser"));

            Person restoredPerson= (Person) inputStream.readObject();

            System.out.println("Name : " + restoredPerson.getName());
            System.out.println("Age : " + restoredPerson.getAge());
            inputStream.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}