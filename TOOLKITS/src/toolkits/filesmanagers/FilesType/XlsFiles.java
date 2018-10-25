/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkits.filesmanagers.FilesType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import toolkits.filesmanagers.FilesType.model.IxlsModel;
import toolkits.parameters.enumExtentionFiles;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.util.ZipSecureFile;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import toolkits.parameters.commonparameter;
import toolkits.utils.date;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author User
 */
public class XlsFiles extends files implements Ifile {
    // final String fileName;
    //  final int maxRows;

    public IxlsModel OIxlsModel;
    public int maxRows;
    private  String fileName;

    public XlsFiles() {
        this.setXtention(".xls");
    }

    public void InitFiles() {
        this.setExtention(enumExtentionFiles.TEXTE);

    }

    public void setModel(IxlsModel oIxlsModel) {
        this.OIxlsModel = oIxlsModel;
    }

    public List<String> LoadDataToFiles() {
        List<String> Odata = new ArrayList<String>();
        String fichier = this.getPath_input();
        //lecture du fichier texte
        String str_SEP = commonparameter.SEPARATEUR_AROBASE;
        try {

            FileInputStream excelFile = new FileInputStream(new File(fichier));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = (Sheet) workbook.getSheetAt(this.OIxlsModel.mainSheet());
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                String stringak = this.getOdataNotNull(currentRow);
                Odata.add(stringak);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Odata;
    }

    public List<String> LoadDataToNotNullFiles() {
        List<String> Odata = new ArrayList<String>();
        String fichier = this.getPath_input();
        //lecture du fichier texte
        String str_SEP = commonparameter.SEPARATEUR_AROBASE;
        try {

            FileInputStream excelFile = new FileInputStream(new File(fichier));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = (Sheet) workbook.getSheetAt(this.OIxlsModel.mainSheet());

            // FileInputStream excelFile = new FileInputStream(new File(fichier));
            InputStream ExcelFileToRead = new FileInputStream(fichier);
            /*    XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
             Sheet datatypeSheet = (Sheet) workbook.getSheetAt(this.OIxlsModel.mainSheet());
             Iterator<Row> iterator = datatypeSheet.iterator();
             */
            HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

            HSSFSheet sheet = wb.getSheetAt(this.OIxlsModel.mainSheet());
            HSSFRow row;
            HSSFCell cell = null;

            //HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
            //HSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                String stringak = this.getOdataAll(row, cell);
                //System.out.println("int_size_of : " + int_size_of);
                Odata.add(stringak);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Odata;
    }

    public String getOdataNotNull(Row currentRow) {
        String stringak = "";
        int int_size_of = 0;
        String str_SEP = commonparameter.SEPARATEUR_AROBASE;

        for (int count = 0; count < currentRow.getLastCellNum(); count++) {
            Cell currentCell = currentRow.getCell(count, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            int_size_of++;
            // whenever we get blank cell value, we avoid it and continues the loop
            if (currentCell == null) {
                stringak = stringak + str_SEP + "0";
                continue;
            }

            if (currentCell.getCellTypeEnum() == CellType.STRING) {
                stringak = stringak + str_SEP + this.getString(currentCell.getStringCellValue());
            } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                if (currentCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    if (HSSFDateUtil.isCellDateFormatted(currentCell)) {

                        stringak = stringak + str_SEP + date.DateToString(this.getDate(currentCell.getDateCellValue()), date.formatterMysqlShort);
                    } else {
                        stringak = stringak + str_SEP + currentCell.getNumericCellValue();
                    }
                }
            } else if (currentCell.getCellTypeEnum() == CellType.BOOLEAN) {
                //System.out.print(currentCell.getBooleanCellValue() + "--");
                stringak = stringak + str_SEP + currentCell.getBooleanCellValue();
            } else {
                stringak = stringak + str_SEP + currentCell.getStringCellValue();

            }

        }

        System.out.println("int_size_of : " + int_size_of);
        /*
        
         while (currentRow.iterator().hasNext()) {
         int_size_of++;
         Cell currentCell = currentRow.iterator().next();
         if (currentCell.getCellTypeEnum() == CellType.STRING) {
         stringak = stringak + str_SEP + this.getString(currentCell.getStringCellValue());
         } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
         if (currentCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
         if (HSSFDateUtil.isCellDateFormatted(currentCell)) {

         stringak = stringak + str_SEP + date.DateToString(this.getDate(currentCell.getDateCellValue()), date.formatterMysqlShort);
         } else {
         stringak = stringak + str_SEP + currentCell.getNumericCellValue();
         }
         }
         } else if (currentCell.getCellTypeEnum() == CellType.BOOLEAN) {
         //System.out.print(currentCell.getBooleanCellValue() + "--");
         stringak = stringak + str_SEP + currentCell.getBooleanCellValue();
         } else {
         stringak = stringak + str_SEP + currentCell.getStringCellValue();

         }

         }*/
        return stringak;
    }

    public String getOdataAll(HSSFRow row, HSSFCell currentCell) {
        String stringak = "";
        int int_size_of = 0;
        String str_SEP = commonparameter.SEPARATEUR_AROBASE;
        for (int i = 0; i < row.getLastCellNum(); i++) {
            currentCell = row.getCell(i, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            System.out.print(currentCell.toString() + " ");

            if (currentCell.getCellTypeEnum() == CellType.STRING) {
                stringak = stringak + str_SEP + this.getString(currentCell.getStringCellValue());
            } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                if (currentCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    if (HSSFDateUtil.isCellDateFormatted(currentCell)) {

                        stringak = stringak + str_SEP + date.DateToString(this.getDate(currentCell.getDateCellValue()), date.formatterMysqlShort);
                    } else {
                        stringak = stringak + str_SEP + currentCell.getNumericCellValue();
                    }
                }
            } else if (currentCell.getCellTypeEnum() == CellType.BOOLEAN) {
                //System.out.print(currentCell.getBooleanCellValue() + "--");
                stringak = stringak + str_SEP + currentCell.getBooleanCellValue();
            } else {
                stringak = stringak + str_SEP + currentCell.getStringCellValue();

            }

        }
        return stringak;
    }

    public static void readXLSXFile() throws IOException {
        InputStream ExcelFileToRead = new FileInputStream("C:/Test.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        Iterator rows = sheet.rowIterator();

        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();

                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    System.out.print(cell.getStringCellValue() + " ");
                } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + " ");
                } else {
                    //U Can Handel Boolean, Formula, Errors
                }
            }
            System.out.println();
        }

    }

    private String getData(String O) {

        if (O.equals("")) {
            O = "...";
        }

        return O;
    }

    public List<Item> LoadDataItemToFiles() {
        List<Item> Odata = new ArrayList<Item>();
        String fichier = this.getPath_input();
        //lecture du fichier texte
        try {

            FileInputStream excelFile = new FileInputStream(new File(fichier));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Odata;
    }

    public void LoadFile(String path) {
        String fileName = "";   // The file name the user entered.
        fileName = path;
        int dotPos = fileName.lastIndexOf(".");
        this.setPath_input(path);
        this.setXtention(fileName.substring(dotPos));
    }

    public void LoadRessource() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void SaveToFile(List<String> Collection_data) {
        try {
            FileWriter fw = new FileWriter(this.getPath_outut());
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter fichierSortie = new PrintWriter(bw);

            for (int i = 0; i < Collection_data.size(); i++) {
                fichierSortie.println(Collection_data.get(i).toString());
            }
            fichierSortie.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void SaveToFile(String data) {
        try {
            FileWriter fw = new FileWriter(this.getPath_outut() + enumExtentionFiles.TEXTE);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter fichierSortie = new PrintWriter(bw);

            fichierSortie.println(data);

            fichierSortie.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public PrintWriter InitSaveToFile() {
        PrintWriter fichierSortie = null;
        try {
            FileWriter fw = new FileWriter(this.getPath_outut() + this.getXtention());
            BufferedWriter bw = new BufferedWriter(fw);
            fichierSortie = new PrintWriter(bw);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return fichierSortie;
    }

    public void SaveToFile(PrintWriter fichierSortie, String data) {
        try {

            fichierSortie.println(data);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void Close(PrintWriter fichierSortie) {
        try {

            fichierSortie.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void Delete() {
        File f1 = new File(this.getPath_input());
        boolean success = f1.delete();
        if (!success) {
            System.out.println("Deletion failed.");
            //  System.exit(0);
        } else {
            System.out.println("File deleted.");
        }
    }

    public void MoveTo(String directoryname) {
        // File (or directory) to be moved
        File file = new File(this.getPath_input());

        // Destination directory
        File dir = new File(directoryname);

        // Move file to new directory
        boolean success = file.renameTo(new File(dir, file.getName()));
        if (!success) {
            // File was not successfully moved
        }

    }

    public String getString(Object O) {

        if (O == null) {
            return "...";
        } else {
            return O.toString();
        }
    }

    public Date getDate(Object O) {

        if (O == null) {
            return new Date();
        } else {
            return (Date) O;
        }
    }

    private List<SXSSFWorkbook> splitWorkbook(XSSFWorkbook workbook) {

        List<SXSSFWorkbook> workbooks = new ArrayList<SXSSFWorkbook>();

        SXSSFWorkbook wb = new SXSSFWorkbook();
        SXSSFSheet sh = wb.createSheet();

        SXSSFRow newRow;
        SXSSFCell newCell;

        int rowCount = 0;
        int colCount = 0;

        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            newRow = sh.createRow(rowCount++);

            /* Time to create a new workbook? */
            if (rowCount == maxRows) {
                workbooks.add(wb);
                wb = new SXSSFWorkbook();
                sh = wb.createSheet();
                rowCount = 0;
            }

            for (Cell cell : row) {
                newCell = newRow.createCell(colCount++);
                newCell = setValue(newCell, cell);

                CellStyle newStyle = wb.createCellStyle();
                newStyle.cloneStyleFrom(cell.getCellStyle());
                newCell.setCellStyle(newStyle);
            }
            colCount = 0;
        }

        /* Only add the last workbook if it has content */
        if (wb.getSheetAt(0).getPhysicalNumberOfRows() > 0) {
            workbooks.add(wb);
        }
        return workbooks;
    }

    private SXSSFCell setValue(SXSSFCell newCell, Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                newCell.setCellValue(cell.getRichStringCellValue().getString());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    newCell.setCellValue(cell.getDateCellValue());
                } else {
                    newCell.setCellValue(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                newCell.setCellValue(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                newCell.setCellFormula(cell.getCellFormula());
                break;
            default:
                System.out.println("Could not determine cell type");
        }
        return newCell;
    }

    private void writeWorkBooks(List<SXSSFWorkbook> wbs) {
        FileOutputStream out;
        String fileName = this.getPath_input();
        try {
            for (int i = 0; i < wbs.size(); i++) {
                String newFileName = fileName.substring(0, fileName.length() - 5);
                out = new FileOutputStream(new File(newFileName + "_" + (i + 1) + ".xlsx"));
                wbs.get(i).write(out);
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void InitSplitter(final int maxRows) {

        ZipSecureFile.setMinInflateRatio(0);

        this.fileName = this.getPath_input();
        this.maxRows = maxRows;

        try {
            /* Read in the original Excel file. */
            OPCPackage pkg = OPCPackage.open(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(pkg);
            XSSFSheet sheet = workbook.getSheetAt(0);

            /* Only split if there are more rows than the desired amount. */
            if (sheet.getPhysicalNumberOfRows() >= maxRows) {
                List<SXSSFWorkbook> wbs = splitWorkbook(workbook);
                writeWorkBooks(wbs);
            }
            pkg.close();
        } catch (EncryptedDocumentException | IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
