/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

/**
 *
 * @author INFODEV
 */

import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class builderPdfVisa {

    public static final String DEST = "D:\\JAVA\\PROJECTS\\RDV_VISA_PASSEPORT\\CONF\\PDF/exemple.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
      //  new builderPdfVisa().createPdf(DEST);
    }
/*
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font boldUnderlineFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLDITALIC);
        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD);
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL);

        Chunk glue = new Chunk(new VerticalPositionMark());
        Paragraph p = new Paragraph("MINISTERE DE L'INTERIEUR", boldFont);
        p.add(new Chunk(glue));
        p.add("République de Côte d'Ivoire");
        document.add(p);

        Paragraph pTitle = new Paragraph(20, "Formulaire de demande de visa / Application for visa", boldFont);
        pTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(pTitle);

        Paragraph pDureeSejour = new Paragraph(40, "Dure du séjour", paragraphFont);
        document.add(pDureeSejour);
        Paragraph pDureeSejourSub = new Paragraph("(Length of stay‐Duration)", paragraphFont);
        document.add(pDureeSejourSub);
        
        
        Paragraph pTransit = new Paragraph(40, "Transit", paragraphFont);
        document.add(pTransit);
        Paragraph pDureeSejourSub = new Paragraph("(Length of stay‐Duration)", paragraphFont);
        document.add(pDureeSejourSub);
        
        

        PdfPCell cellTitle = new PdfPCell(pTitle);

        PdfPTable table = new PdfPTable(3);
        PdfPCell cell = new PdfPCell(new Phrase("Cell 2"));
        cell.setColspan(2);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

        document.add(table);

        PdfContentByte canvas = writer.getDirectContent();
        Rectangle rect = new Rectangle(25, 50, 570, 760);
        rect.setBorder(Rectangle.BOX);
        rect.setBorderWidth(1);
        canvas.rectangle(rect);

        document.close();
    }
*/
    public PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

}
