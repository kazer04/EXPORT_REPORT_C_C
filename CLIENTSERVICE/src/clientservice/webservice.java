/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. gg hbubub
 */
package clientservice;

import java.net.URL;
import java.net.URLEncoder;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class webservice {

    private String message;

    public webservice() {
        this.message = "";
    }

  public boolean send_SMS(String str_from, String text) {
        try {
            // this method needs to construct the URL string with the number and message vars
            // to send the SMS out
            String messageData = URLEncoder.encode(text, "UTF8");
            //str_to = URLEncoder.encode(str_to, "UTF8");
            str_from = URLEncoder.encode(str_from, "UTF8");

            String url = jdom.sms_gateway_outbound + "sendsms?phone=" + str_from + "&text=" + messageData + "&password=0000";

            URL sendURL = new URL(url);
            System.out.println(sendURL);
            Object response = sendURL.getContent();
            System.out.println(response + "class= " + response.getClass());
            String result = "";
            java.io.InputStream in = (java.io.InputStream) response;
            java.io.BufferedInputStream bufIn = new java.io.BufferedInputStream(in);
            for (;;) {
                int car = bufIn.read(); // Check for EOF
                if (car == -1) {
                    break;
                } else {
                    result = result + (char) car;
                }
            }
            bufIn.close();
            in.close();
            new logger().oCategory.info(result);
            return true;


        } catch (Exception ex) {
            this.setMessage(ex.getMessage());
            new logger().oCategory.fatal(this.getMessage());
            return false;
        }
    }

    public boolean send_SMS(String str_from, String str_to, String text, int int_Port) {
        String smsServer = "http://" + jdom.kannel_ip + ":" + jdom.kannel_port + "/cgi-bin/sendsms?username=" + jdom.kannel_user + "&password=" + jdom.kannel_pwd;
//http://www.lmtgroup.com/etotelecoms/SendSMS/sendmsg.php?uname=etootelecom&pass=7Et00c062622&dest=237xxxxxxxx&sender=8060&msg=test
        smsServer = "http://www.lmtgroup.com/etotelecoms/SendSMS/sendmsg.php?uname=etootelecom&pass=7Et00c062622&dest=237" + str_from + "&sender=8060&msg=test";

        try {
            // this method needs to construct the URL string with the number and message vars
            // to send the SMS out
            String messageData = URLEncoder.encode(text, "UTF8");
            str_to = URLEncoder.encode(str_to, "UTF8");
            str_from = URLEncoder.encode(str_from, "UTF8");

            String url = smsServer + "&text=" + messageData + "&to=" + str_to + "&from=" + str_from;
            String str_port_split;
            int int_port = int_Port;

            URL sendURL = new URL(url);
            System.out.println(sendURL);
            Object response = sendURL.getContent();
            System.out.println(response + "class= " + response.getClass());
            String result = "";
            java.io.InputStream in = (java.io.InputStream) response;
            java.io.BufferedInputStream bufIn = new java.io.BufferedInputStream(in);
            for (;;) {
                int car = bufIn.read(); // Check for EOF
                if (car == -1) {
                    break;
                } else {
                    result = result + (char) car;
                }
            }
            bufIn.close();
            in.close();
            new logger().oCategory.info(result);
            return true;


        } catch (Exception ex) {
            new logger().oCategory.fatal(ex.getMessage());
            return false;
        }
    }

    public boolean notifyWinningWeb(String lg_Course_ID) {
        String url = jdom.paris_portal_link + "?option=com_paris&task=DonotifyWinningWeb&lg_Course_ID=" + lg_Course_ID;
        try {
            URL sendURL = new URL(url);
            System.out.println(sendURL);
            Object response = sendURL.getContent();
            System.out.println(response + "class= " + response.getClass());
            String result = "";
            java.io.InputStream in = (java.io.InputStream) response;
            java.io.BufferedInputStream bufIn = new java.io.BufferedInputStream(in);
            for (;;) {
                int car = bufIn.read(); // Check for EOF
                if (car == -1) {
                    break;
                } else {
                    result = result + (char) car;
                }
            }
            bufIn.close();
            in.close();
            new logger().oCategory.info(result);
            return true;
        } catch (Exception ex) {
            new logger().oCategory.fatal(ex.getMessage());
            return false;
        }
    }

    public boolean viewWeb(String Url) {
        String url = Url;
        try {
            URL sendURL = new URL(url);
            System.out.println(sendURL);
            Object response = sendURL.getContent();
            System.out.println(response + "class= " + response.getClass());
            String result = "";
            java.io.InputStream in = (java.io.InputStream) response;
            java.io.BufferedInputStream bufIn = new java.io.BufferedInputStream(in);
            for (;;) {
                int car = bufIn.read(); // Check for EOF
                if (car == -1) {
                    break;
                } else {
                    result = result + (char) car;
                }
            }
            bufIn.close();
            in.close();
            new logger().oCategory.info(result);
            return true;
        } catch (Exception ex) {
            new logger().oCategory.fatal(ex.getMessage());
            return false;
        }
    }


      public String getData(String Url) {
        String url = Url;
        try {
            URL sendURL = new URL(url);
            System.out.println(sendURL);
            Object response = sendURL.getContent();
            System.out.println(response + "class= " + response.getClass());
            String result = "";
            java.io.InputStream in = (java.io.InputStream) response;
            java.io.BufferedInputStream bufIn = new java.io.BufferedInputStream(in);
            for (;;) {
                int car = bufIn.read(); // Check for EOF
                if (car == -1) {
                    break;
                } else {
                    result = result + (char) car;
                }
            }
            bufIn.close();
            in.close();
           // new logger().oCategory.info(result);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            new logger().oCategory.fatal(ex.getMessage());
            return "";
        }
    }


    public String getFillColor(String dtDebut, String dtFin, String Ref, String TableDS,String refproduit) {
        String result = "0";
        try {
            // Call Web Service Operation
            jdom.InitRessource();
            jdom.LoadRessource();
            URL url = null;
            URL baseUrl;
           /// baseUrl = GatewayrelevebiService.class.getResource(".");
           // url = new URL(baseUrl, jdom.paytus_ressource_wsdl);
           // GatewayrelevebiService service = new GatewayrelevebiService(url);

          //  return service.getGatewayrelevebiPort().getFillColor(dtDebut, dtFin, Ref, TableDS);
         

            return "#4290c7";
        } catch (Exception ex) {
            new logger().OCategory.error(ex.getMessage());
        }
        return result;
    }



        public String getFillColorWs(String dtDebut, String dtFin, String Ref, String TableDS) {
        String result = "0";
        try { // Call Web Service Operation
            jdom.InitRessource();
            jdom.LoadRessource();
            URL url = null;
            URL baseUrl;
           // baseUrl = GatewayrelevebiService.class.getResource(".");
           // url = new URL(baseUrl, jdom.paytus_ressource_wsdl);
          //  GatewayrelevebiService service = new GatewayrelevebiService(url);

           // return service.getGatewayrelevebiPort().getFillColor(dtDebut, dtFin, Ref, TableDS);
        } catch (Exception ex) {
            new logger().OCategory.error(ex.getMessage());
        }
        return result;
    }


    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set  jkk
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
