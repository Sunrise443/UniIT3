package lab4;

//вариант 1, ошибки с открытием и закрытием файлов

import java.io.*;


/*
Программа копирует содержимое одного файла в другой
При этом она обрабатывает возможные ошибки связанные с 
открытием и закрытием файла
*/

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("lab4/file1.txt");
            outputStream = new FileOutputStream("lab4/file2.txt");
            
            //буфер для хранения прочитанных байтов (необходимо переводить информацию в байты)
            byte[] buffer = new byte[256];
            int count;

            //чтение и запись данных
            while ((count=inputStream.read(buffer))!=-1) {
                outputStream.write(buffer, 0, count);
            }
            System.out.println("Информация из файла была записана в другой файл.");
            
        } catch (IOException e) {
            System.out.println("Ошибка при открытии или чтении файла: " + e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файлов: " + e.getMessage());
            }
        }
    }
}
