import java.io.IOException;

/**
 * @author Marcus Lorenzana
 * Date: 04/08/2021
 * Description: This program does a simple crawl of a website, outputting the urls and images contained in the
 * immediate domain. I will be using the Jsoup to leverage it's HTML parsing capabilities.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // ensure that url argument was passed
        if (args.length == 1) {
            String url = args[0];
            System.out.println("Crawling "+ url +"...");
            WebCrawler webCrawler = new WebCrawler(url);
            webCrawler.crawlWebsite();
        } else {
            System.err.println("Please pass a URL as command line argument (including http(s)://)");
        }

    }
}
