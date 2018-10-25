package dal;

import dal.TCampagneMois;
import dal.TCampagneMontant;
import dal.TCampagnePoids;
import dal.TFile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TCampagne.class)
public class TCampagne_ { 

    public static volatile SingularAttribute<TCampagne, Date> dtCREATED;
    public static volatile SingularAttribute<TCampagne, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TCampagne, String> lgCAMPAGNEID;
    public static volatile CollectionAttribute<TCampagne, TCampagneMontant> tCampagneMontantCollection;
    public static volatile SingularAttribute<TCampagne, String> strSTATUT;
    public static volatile CollectionAttribute<TCampagne, TFile> tFileCollection;
    public static volatile SingularAttribute<TCampagne, String> lgCREATEDBY;
    public static volatile SingularAttribute<TCampagne, Integer> intID;
    public static volatile CollectionAttribute<TCampagne, TCampagnePoids> tCampagnePoidsCollection;
    public static volatile SingularAttribute<TCampagne, String> strNAME;
    public static volatile SingularAttribute<TCampagne, String> strDEBUTMOIS;
    public static volatile CollectionAttribute<TCampagne, TCampagneMois> tCampagneMoisCollection;
    public static volatile SingularAttribute<TCampagne, Date> dtUPDATED;
    public static volatile SingularAttribute<TCampagne, String> strFINMOIS;

}