package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // File location of the CSV
        String filePath = "dataset/dataset.csv";
        String line;
        String separator = ",";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {

            String firstLine = fileReader.readLine();
            if (firstLine == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            // Extract and display headers
            String[] headers = firstLine.split(separator);
            System.out.println("Columns:");
            for (String col : headers) {
                System.out.print(col + " ");
            }
            System.out.println("\nTotal columns: " + headers.length);
            System.out.println("\nFirst 5 Records:\n");

            int rowsShown = 0;

            // Show first 5 records
            while ((line = fileReader.readLine()) != null && rowsShown < 5) {
                String[] values = line.split(separator);
                System.out.println(String.join(" ", values));
                rowsShown++;
            }

            // Count the rest of the rows
            while (fileReader.readLine() != null) {
                rowsShown++;
            }

            System.out.println("\nTotal Records (excluding header): " + rowsShown);

        } catch (IOException e) {
            System.err.println("An error occurred while accessing the CSV file:");
            e.printStackTrace();
        }
    }
}