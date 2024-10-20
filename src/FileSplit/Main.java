
package FileSplit;


import java.io.*;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Minta input nama file
        System.out.print("Masukkan nama file: ");
        String fileName = sc.nextLine();

        // Minta input ukuran potongan
        System.out.print("Masukkan ukuran potongan (dalam jumlah karakter): ");
        int chunkSize = sc.nextInt();

        // Custom LinkedList untuk menyimpan potongan
        CustomLinkedList chunks = new CustomLinkedList();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line;
            int charCount = 0;

            // Baca file baris per baris
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
                charCount += line.length() + 1; // +1 untuk newline

                // Potong jika sudah mencapai ukuran yang ditentukan
                while (charCount >= chunkSize) {
                    String chunk = sb.substring(0, chunkSize);
                    chunks.add(chunk);
                    sb.delete(0, chunkSize);
                    charCount -= chunkSize;
                }
            }

            // Tambahkan sisa potongan jika ada
            if (sb.length() > 0) {
                chunks.add(sb.toString());
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
            return;
        }

        // Tampilkan potongan
        System.out.println("\nPotongan file:");
        while (!chunks.isEmpty()) {
            System.out.println(chunks.poll());
        }

        sc.close();
    }
}

