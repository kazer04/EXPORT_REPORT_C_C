package dal;

import dal.TCampagne;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TCampagnePoids.class)
public class TCampagnePoids_ { 

    public static volatile SingularAttribute<TCampagnePoids, Integer> intANNEE;
    public static volatile SingularAttribute<TCampagnePoids, String> strTYPEPRODUIT;
    public static volatile SingularAttribute<TCampagnePoids, String> lgID;
    public static volatile SingularAttribute<TCampagnePoids, Date> dtCREATED;
    public static volatile SingularAttribute<TCampagnePoids, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TCampagnePoids, String> strTYPEEXPORTATEUR;
    public static volatile SingularAttribute<TCampagnePoids, String> strPRODUIT;
    public static volatile SingularAttribute<TCampagnePoids, TCampagne> lgCAMPAGNEID;
    public static volatile SingularAttribute<TCampagnePoids, String> strSTATUT;
    public static volatile SingularAttribute<TCampagnePoids, String> strPORTEMBARQUEMENT;
    public static volatile SingularAttribute<TCampagnePoids, Double> intPOIDS;
    public static volatile SingularAttribute<TCampagnePoids, String> lgCREATEDBY;
    public static volatile SingularAttribute<TCampagnePoids, Integer> intID;
    public static volatile SingularAttribute<TCampagnePoids, Integer> intMOIS;
    public static volatile SingularAttribute<TCampagnePoids, String> strNAME;
    public static volatile SingularAttribute<TCampagnePoids, String> strREFEXPORT;
    public static volatile SingularAttribute<TCampagnePoids, Date> dtUPDATED;

}