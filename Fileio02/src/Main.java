import java.io.*;

public class Main {
    public static void main(String[] args)  {
        try {
            ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream("object.ser"));
            Person person= new Person("John",30);

            outputStream.writeObject(person);

            outputStream.close();

            ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream("object.ser"));

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