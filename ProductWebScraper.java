import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class ProductWebScraper {
    public static void main(String[] args) {
        // URL of the website to scrape
        String url = "https://books.toscrape.com";

        try {
            // Fetch the HTML document from the URL
            System.out.println("Fetching data from: " + url);
            Document doc = Jsoup.connect(url).get();

            // Extract book titles, prices, availability, and ratings
            Elements books = doc.select("article.product_pod");

            // Display the data on the console
            System.out.println("Extracted Data:");
            for (Element book : books) {
                String title = book.select("h3 a").attr("title");
                String price = book.select("p.price_color").text();
                String availability = book.select("p.instock.availability").text().trim();
                String rating = getRating(book.select("p.star-rating").attr("class"));

                System.out.println("- Title: " + title);
                System.out.println("  Price: " + price);
                System.out.println("  Availability: " + availability);
                System.out.println("  Rating: " + rating);
            }

            // Save the data to a CSV file
            saveToCSV(books);

        } catch (IOException e) {
            System.err.println("An error occurred while fetching data: " + e.getMessage());
        }
    }

    // Method to save the extracted data to a CSV file
    private static void saveToCSV(Elements books) {
        String fileName = "books_data.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write the header
            writer.append("Title,Price,Availability,Rating\n");

            // Write each book's data to the file
            for (Element book : books) {
                String title = book.select("h3 a").attr("title");
                String price = book.select("p.price_color").text();
                String availability = book.select("p.instock.availability").text().trim();
                String rating = getRating(book.select("p.star-rating").attr("class"));

                writer.append("\"").append(title).append("\",")
                        .append(price).append(",")
                        .append(availability).append(",")
                        .append(rating).append("\n");
            }

            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    // Method to convert rating class to star count
    private static String getRating(String ratingClass) {
        if (ratingClass.contains("One")) return "1";
        if (ratingClass.contains("Two")) return "2";
        if (ratingClass.contains("Three")) return "3";
        if (ratingClass.contains("Four")) return "4";
        if (ratingClass.contains("Five")) return "5";
        return "0"; // Default if no rating is found
    }
}
