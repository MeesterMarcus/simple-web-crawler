import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Primary function of the program, this object once initialized with a URL, contains a function that will
 * crawl the website, outputting the images and links contained within the immediate domain.
 */
public class WebCrawler {

    private final String url;

    public WebCrawler(String url) {
        this.url = url;
    }

    public void crawlWebsite() throws IOException {
        Document doc = Jsoup.connect(url).get();
        printLinks(doc);
        printImages(doc);
    }

    /**
     * Loop through the elements that contain a src tag, further filter by looking for img type and print out
     * the url and alt tag.
     * @param doc : the document retrieved from Jsoup
     */
    private void printImages(Document doc) {
        Elements srcElements = doc.select("[src]");
        System.out.println("\nImages:\n");
        for (Element src : srcElements) {
            String altTag = src.attr("alt");
            String type = src.normalName();
            if (type.equals("img")) {
                System.out.println("<url>" + src.attr("abs:src") +"</url> " + "(" + altTag + ")");
            }
        }
    }

    /**
     * Loop through the elements that contain a a[href] tag in order to print out the links contained in the anchors and
     * the anchor text.
     * @param doc : the document retrieved from Jsoup
     */
    private void printLinks(Document doc) {
        Elements anchors = doc.select("a[href]");
        System.out.println("\nURLs\n");
        for (Element anchor : anchors) {
            String absoluteUrl = anchor.attr("abs:href");
            String anchorText = anchor.text();
            System.out.println("<url>" + absoluteUrl + "</url> " + " (" + anchorText + ")");

        }
    }
}
