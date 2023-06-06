import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
public class PDFSplitter 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the source PDF file:");
        String sourceFile = scanner.nextLine();
        System.out.print("Enter the path to the output directory:");
        String outputDir = scanner.nextLine();
        try 
        {
            PDDocument document = PDDocument.load(new File(sourceFile));
            Splitter splitter = new Splitter();
            java.util.List<PDDocument> pages = splitter.split(document);
            int pageNum = 1;
            for (PDDocument page : pages) 
            {
                String outputFile = outputDir + "page_" + pageNum + ".pdf";
                page.save(new File(outputFile));
                pageNum++;
                page.close();
            }
            document.close();
            System.out.println("PDF splitting completed successfully.");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            scanner.close();
        }
    }
}
