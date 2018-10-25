/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config_editor.ui.ligneMaritimes.entty;

import java.io.Serializable;

/**
 *
 * @author thierry
 */
public interface IEntity extends Serializable {

    String getTableName();

    int getIDposition();

    int getLabelposition();
    
     void setAllData(java.util.List<String> LstData);
    String getAllData();
    
    Serializable getObject(int Item);
}
