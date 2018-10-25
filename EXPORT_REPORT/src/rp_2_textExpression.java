/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP PC
 */
public class rp_2_textExpression {

    public String getdata(String str_ovalue) {

        if (str_ovalue.equals("A_POIDS_THEORIQUE")) {
            str_ovalue = "POIDS THEORIQUE";
        } else if (str_ovalue.equals("B_POIDS_REEL")) {
            str_ovalue = "POIDS REEL";
        } else if (str_ovalue.equals("C_ECART")) {
            str_ovalue = "ECART";
        }
        return str_ovalue;
    }

    public Double getvaluereel(String str_ovalue, Double O) {

        if (str_ovalue.equals("B_POIDS_REEL")) {
            return O;
        } else {
            return 0.0;
        }

    }
    
    public Double getvalueecart(String str_ovalue, Double O) {

        if (str_ovalue.equals("C_ECART")) {
            return O;
        } else {
            return 0.0;
        }

    }
    
    public Double getvaluetheo(String str_ovalue, Double O) {

        if (str_ovalue.equals("A_POIDS_THEORIQUE")) {
            return O;
        } else {
            return 0.0;
        }

    }
}
