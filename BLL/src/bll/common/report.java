/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.common;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import multilangue.Translate;
import toolkits.parameters.commonparameter;
import toolkits.parameters.enumExtentionFiles;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author CENDRINE
 */
public class report extends bll.bllBase {
//sdgfdsfsdfsd
    Font Ofonts_header_2 = new Font();
    Font Ofonts_header_title = new Font();
    public String tittle;

    public Document buidHeader_without_logo(Document document, String REPORT_TITTLE) {

        try {
            Font Ofonts_tittle_report = new Font();
            Ofonts_tittle_report = new Font(Font.TIMES_ROMAN, 14, Font.BOLD);

            Font Ofonts_header = new Font();
            Ofonts_header = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);

            Font Ofonts_header_group = new Font();
            Ofonts_header_group = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
            Ofonts_header_group.setStyle(Font.ITALIC);

            Font Ofonts_header_eleve = new Font();
            Ofonts_header_eleve = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
            Ofonts_header_eleve.setStyle(Font.ITALIC);

            Font Ofonts_data = new Font();
            Ofonts_data = new Font(Font.TIMES_ROMAN, 7);

            Font Ofonts_data_moyenne_total = new Font();
            Ofonts_data_moyenne_total = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);

            PdfPTable table_header = new PdfPTable(2);
            table_header.setWidthPercentage(120);




            PdfPCell cell_left = new PdfPCell(new Phrase("REPUBLIQUE DU CAMEROUN", Ofonts_header));
            cell_left.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_left.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_left);

            PdfPCell cell_right = new PdfPCell(new Phrase("ARCHIDIOCESE DE YAOUNDE", Ofonts_header));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_left = new PdfPCell(new Phrase("MINISTERE DES ENSEIGNEMENTS SECONDAIRES", Ofonts_header));
            cell_left.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_left.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_left);

            cell_right = new PdfPCell(new Phrase(jdom.APP_NAME, Ofonts_header));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_left = new PdfPCell(new Phrase("DELEGATION REGIONALE DU CENTRE", Ofonts_header_2));
            cell_left.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_left.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_left);

            cell_right = new PdfPCell(new Phrase("BP: 15 DOuala Tel: " , Ofonts_header_2));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_right = new PdfPCell(new Phrase("", Ofonts_header_2));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_right = new PdfPCell(new Phrase("www.google.com", Ofonts_header_2));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);


            PdfPTable table_header_tittle = new PdfPTable(1);
            table_header_tittle.setWidthPercentage(120);
            PdfPCell cell_center = new PdfPCell(new Phrase(REPORT_TITTLE, Ofonts_tittle_report));
            cell_center.setBorder(PdfPCell.NO_BORDER);
            cell_center.setHorizontalAlignment(Element.ALIGN_CENTER);
            table_header_tittle.addCell(cell_center);

            cell_center = new PdfPCell(new Phrase("ANNEE SCOLAIRE 15555", Ofonts_header));
            cell_center.setBorder(PdfPCell.NO_BORDER);
            cell_center.setHorizontalAlignment(Element.ALIGN_CENTER);
           // table_header_tittle.addCell(cell_center);

           // document.add(table_header);
            document.add(table_header_tittle);



        } catch (Exception e) {
            e.printStackTrace();
            new logger().OCategory.error(e.getMessage());
        }

        return document;
    }

    public Document buidHeader_with_logo(Document document, String REPORT_TITTLE) {


        try {
            Font Ofonts_tittle_report = new Font();
            Ofonts_tittle_report = new Font(Font.TIMES_ROMAN, 14, Font.BOLD);

            Font Ofonts_header = new Font();
            Ofonts_header = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);

            Font Ofonts_header_group = new Font();
            Ofonts_header_group = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
            Ofonts_header_group.setStyle(Font.ITALIC);

            Font Ofonts_header_eleve = new Font();
            Ofonts_header_eleve = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
            Ofonts_header_eleve.setStyle(Font.ITALIC);

            Font Ofonts_data = new Font();
            Ofonts_data = new Font(Font.TIMES_ROMAN, 7);

            Font Ofonts_data_moyenne_total = new Font();
            Ofonts_data_moyenne_total = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);

            PdfPTable table_header = new PdfPTable(2);
            table_header.setWidthPercentage(120);




            PdfPCell cell_left = new PdfPCell(new Phrase("REPUBLIQUE DU CAMEROUN", Ofonts_header));
            cell_left.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_left.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_left);

            PdfPCell cell_right = new PdfPCell(new Phrase("ARCHIDIOCESE DE YAOUNDE", Ofonts_header));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_left = new PdfPCell(new Phrase("MINISTERE DES ENSEIGNEMENTS SECONDAIRES", Ofonts_header));
            cell_left.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_left.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_left);

            cell_right = new PdfPCell(new Phrase(jdom.APP_NAME, Ofonts_header));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_left = new PdfPCell(new Phrase("DELEGATION REGIONALE DU CENTRE", Ofonts_header_2));
            cell_left.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_left.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_left);

            cell_right = new PdfPCell(new Phrase("BP: 458 Douala Tel: ", Ofonts_header_2));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_right = new PdfPCell(new Phrase("", Ofonts_header_2));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            cell_right = new PdfPCell(new Phrase("www.google.com", Ofonts_header_2));
            cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_right.setBorder(PdfPCell.NO_BORDER);
            table_header.addCell(cell_right);

            Image imagePicEleve = null;
            try {
                imagePicEleve = Image.getInstance(jdom.scr_report_file_logo);
                imagePicEleve.scaleAbsolute(85, 100);
                imagePicEleve.setBorder(Rectangle.BOX);
                imagePicEleve.setBorderColor(Color.WHITE);
                imagePicEleve.setBorderWidth(5f);

                cell_right = new PdfPCell(imagePicEleve);
                cell_right.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell_right.setBorder(PdfPCell.NO_BORDER);
                table_header.addCell(cell_right);

            } catch (Exception e) {
                new logger().OCategory.error(e.getMessage());
            }

            Image imagePicLogo = null;
            try {
                imagePicLogo = Image.getInstance(jdom.scr_report_file_logo);
                imagePicLogo.scaleAbsolute(85, 100);
                imagePicLogo.setBorder(Rectangle.BOX);
                imagePicLogo.setBorderColor(Color.WHITE);
                imagePicLogo.setBorderWidth(5f);


                cell_right = new PdfPCell(imagePicLogo);
                cell_right.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell_right.setBorder(PdfPCell.NO_BORDER);
                table_header.addCell(cell_right);

            } catch (Exception e) {
                new logger().OCategory.error(e.getMessage());
            }

            PdfPTable table_header_tittle = new PdfPTable(1);
            table_header_tittle.setWidthPercentage(120);
            PdfPCell cell_center = new PdfPCell(new Phrase(REPORT_TITTLE, Ofonts_tittle_report));
            cell_center.setBorder(PdfPCell.NO_BORDER);
            cell_center.setHorizontalAlignment(Element.ALIGN_CENTER);
            table_header_tittle.addCell(cell_center);

            cell_center = new PdfPCell(new Phrase("ANNEE SCOLAIRE 1588", Ofonts_header));
            cell_center.setBorder(PdfPCell.NO_BORDER);
            cell_center.setHorizontalAlignment(Element.ALIGN_CENTER);
            table_header_tittle.addCell(cell_center);

            document.add(table_header);
            document.add(table_header_tittle);



        } catch (Exception e) {
            e.printStackTrace();
            new logger().OCategory.error(e.getMessage());
        }

        return document;
    }

    public Document initReport(String REPORT_TITTLE, Boolean logoStatut) {

        try {
            jdom.InitRessource();
        } catch (Exception ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
        jdom.LoadRessource();

        Document document = new Document(PageSize.A4, 70, 70, 70, 70);
        document.setMargins(60, 60, 20, 0);

        try {
            // step 2:
            // we create a writer
            tittle = new date().getDateTime() + "_" + new date().GetNumberRandom() + enumExtentionFiles.PDF;
            PdfWriter.getInstance(document, new FileOutputStream(jdom.scr_report_pdf + tittle));
            // step 3: we open the document
            document.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (logoStatut == false) {
            return buidHeader_without_logo(document, REPORT_TITTLE);
        } else {
            return buidHeader_with_logo(document, REPORT_TITTLE);
        }

    }

    public Document builfooter(Document document) {
        return document;
    }

    public void close(Document document) {
        try {
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
            new logger().OCategory.error(e.getMessage());
        }
    }
}
