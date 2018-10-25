package dal;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TEventLog.class)
public class TEventLog_ { 

    public static volatile SingularAttribute<TEventLog, String> lgEVENTLOGID;
    public static volatile SingularAttribute<TEventLog, String> strTABLECONCERN;
    public static volatile SingularAttribute<TEventLog, String> strMODULECONCERN;
    public static volatile SingularAttribute<TEventLog, Date> dtCREATED;
    public static volatile SingularAttribute<TEventLog, String> strSTATUT;
    public static volatile SingularAttribute<TEventLog, String> strCREATEDBY;
    public static volatile SingularAttribute<TEventLog, Date> dtUPDATED;
    public static volatile SingularAttribute<TEventLog, String> strUPDATEDBY;
    public static volatile SingularAttribute<TEventLog, String> strDESCRIPTION;
    public static volatile SingularAttribute<TEventLog, String> matriculeEleve;

}