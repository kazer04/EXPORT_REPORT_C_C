/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config_editor.ui.ligneMaritimes.entty;

import java.io.Serializable;
import toolkits.parameters.commonparameter;

/**
 *
 * @author thierry
 */
public class Habillage  implements IEntity {

    java.util.List<String> LstData = null;

    @Override
    public String getTableName() {
        return "HABILLAGE";
    }

    @Override
    public int getIDposition() {
        return 0;
    }

    @Override
    public int getLabelposition() {

        return 1;
    }

    @Override
    public void setAllData(java.util.List<String> LstData) {

        this.LstData = LstData;

    }

    @Override
    public String getAllData() {
        String strTat = "";

        for (int i = 0; i < LstData.size(); i++) {

            if (i == 0) {
                strTat = LstData.get(i);

            } else {
                strTat = strTat + commonparameter.SEPARATEUR_AROBASE + LstData.get(i);
            }

        }
        return strTat;
    }

    @Override
    public Serializable getObject(int Item) {
      /*  THabillage OTHabillage = new THabillage();
        OTHabillage.setLgHABILLAGEID(LstData.get(Item).split(commonparameter.SEPARATEUR_POINT_VIRGULE)[0]);
        OTHabillage.setStrNAME(LstData.get(Item).split(commonparameter.SEPARATEUR_POINT_VIRGULE)[1]);
        OTHabillage.setIntPOIDS(new Double(LstData.get(Item).split(commonparameter.SEPARATEUR_POINT_VIRGULE)[2]));
        return OTHabillage;
*/
        return null;
    }

}
