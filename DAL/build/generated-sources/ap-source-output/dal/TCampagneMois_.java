package dal;

import dal.TCampagne;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TCampagneMois.class)
public class TCampagneMois_ { 

    public static volatile SingularAttribute<TCampagneMois, Integer> intMOIS;
    public static volatile SingularAttribute<TCampagneMois, Integer> intANNEE;
    public static volatile SingularAttribute<TCampagneMois, String> lgID;
    public static volatile SingularAttribute<TCampagneMois, Date> dtCREATED;
    public static volatile SingularAttribute<TCampagneMois, String> strNAME;
    public static volatile SingularAttribute<TCampagneMois, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TCampagneMois, String> strPRODUIT;
    public static volatile SingularAttribute<TCampagneMois, TCampagne> lgCAMPAGNEID;
    public static volatile SingularAttribute<TCampagneMois, String> strSTATUT;
    public static volatile SingularAttribute<TCampagneMois, Date> dtUPDATED;
    public static volatile SingularAttribute<TCampagneMois, String> lgCREATEDBY;

}