package dal;

import dal.TCampagne;
import dal.TExportCcMontant;
import dal.TExportCcPoids;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TFile.class)
public class TFile_ { 

    public static volatile SingularAttribute<TFile, Date> dtCREATED;
    public static volatile SingularAttribute<TFile, Integer> intNBELEMENTS;
    public static volatile SingularAttribute<TFile, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TFile, String> strTYPE;
    public static volatile SingularAttribute<TFile, TCampagne> lgCAMPAGNEID;
    public static volatile CollectionAttribute<TFile, TExportCcMontant> tExportCcMontantCollection;
    public static volatile SingularAttribute<TFile, String> strSTATUT;
    public static volatile SingularAttribute<TFile, String> lgFILEID;
    public static volatile SingularAttribute<TFile, String> lgCREATEDBY;
    public static volatile SingularAttribute<TFile, String> strNAME;
    public static volatile SingularAttribute<TFile, String> strREF;
    public static volatile SingularAttribute<TFile, String> strPATH;
    public static volatile SingularAttribute<TFile, String> strRETURNDATA;
    public static volatile CollectionAttribute<TFile, TExportCcPoids> tExportCcPoidsCollection;
    public static volatile SingularAttribute<TFile, Date> dtUPDATED;
    public static volatile SingularAttribute<TFile, String> strDATA;

}