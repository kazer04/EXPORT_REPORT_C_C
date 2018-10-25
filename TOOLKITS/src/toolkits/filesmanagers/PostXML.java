/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkits.filesmanagers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import toolkits.parameters.commonparameter;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class PostXML {

    public static void main(String[] args) throws Exception {
        //  new PostXML().sendXML("");
    }

    public void sendXML() {
        String fileString = null;
        try {
            StringBuffer fileBuffer;
           
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = fact.newDocumentBuilder();
            jdom.InitRessource();
            jdom.LoadRessource();
            URL url = new URL(jdom.url_Pretups_request);
            String document = commonparameter.Request_Xml_File_Name;
            FileReader fr = new FileReader(document);
            char[] buffer = new char[1024 * 10];
            int bytes_read = 0;
            if ((bytes_read = fr.read(buffer)) != -1) {
                URLConnection urlc = url.openConnection();
                urlc.setRequestProperty("Content-Type", "text/xml");
                urlc.setDoOutput(true);
                urlc.setDoInput(true);
                PrintWriter pw = new PrintWriter(urlc.getOutputStream());
                // send xml to jsp
                pw.write(buffer, 0, bytes_read);
                pw.close();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                fileBuffer = new StringBuffer();
                new InputStreamReader(urlc.getInputStream());
                //   urlc.

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    fileBuffer.append(inputLine + "\n");
                    System.out.println(inputLine);
                }

                fileString = fileBuffer.toString();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new logger().OCategory.error(date.GetDateNow_Date() + " " + e.getMessage());
        }
        //writeFile (new File(commonparameter.Response_Xml_File_Name),fileString );
    }

    public static boolean writeFile(File file, String dataString) {
        try {
            PrintWriter out =
                    new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.print(dataString);
            out.flush();
            out.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    } // writeFile
}