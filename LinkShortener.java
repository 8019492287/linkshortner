import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class LinkShortener {
    private Map<String, String> urlMap;

    public LinkShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, originalUrl);
        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter URL to shorten: ");
                    String originalUrl = scanner.nextLine();
                    String shortUrl = linkShortener.shortenUrl(originalUrl);
                    System.out.println("Short URL: " + shortUrl);
                    break;
                case 2:
                    System.out.print("Enter short URL to expand: ");
                    String shortUrlToExpand = scanner.nextLine();
                    String expandedUrl = linkShortener.expandUrl(shortUrlToExpand);
                    if (expandedUrl != null) {
                        System.out.println("Expanded URL: " + expandedUrl);
                    } else {
                        System.out.println("Invalid short URL.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}