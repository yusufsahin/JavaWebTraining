package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Person> calisanListesi = new ArrayList<Person>();
        Person p1 = new Person("John", 30);
        Person p2 = new Person("Jane", 25);
        Person p3 = new Person("Frank", 27);
        Person p4 = new Person("Bill", 33);
        Person p5 = new Person("David", 35);
        calisanListesi.add(p1);
        calisanListesi.add(p2);
        calisanListesi.add(p3);
        calisanListesi.add(p4);
        calisanListesi.add(p5);
/*
        for (Person p: calisanListesi) {
            System.out.println("Name : " +p.getName()+", Age : "+p.getAge());
        }
*/
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Calisanlar");

            // Başlık satırını oluşturma
            Row headerRow = sheet.createRow(0);
            Cell nameCell = headerRow.createCell(0);
            nameCell.setCellValue("Name");
            Cell ageCell = headerRow.createCell(1);
            ageCell.setCellValue("Age");

            // Kişilerin verilerini yazma
            int rowNum = 1;
            for (Person person : calisanListesi) {
                Row row = sheet.createRow(rowNum++);
                Cell nameDataCell = row.createCell(0);
                nameDataCell.setCellValue(person.getName());
                Cell ageDataCell = row.createCell(1);
                ageDataCell.setCellValue(person.getAge());
            }

            // Excel dosyasını kaydetme
            try (FileOutputStream outputStream = new FileOutputStream("calisanlar.xlsx")) {
                workbook.write(outputStream);
            }

            System.out.println("Excel dosyası oluşturuldu ve veriler yazıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
