package dal;

import dal.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TNotification.class)
public class TNotification_ { 

    public static volatile SingularAttribute<TNotification, String> strCONTENT;
    public static volatile SingularAttribute<TNotification, String> lgID;
    public static volatile SingularAttribute<TNotification, Date> dtCREATED;
    public static volatile SingularAttribute<TNotification, String> strTYPE;
    public static volatile SingularAttribute<TNotification, String> strREFRESSOURCE;
    public static volatile SingularAttribute<TNotification, TUser> lgUSERIDIN;
    public static volatile SingularAttribute<TNotification, String> strSTATUT;
    public static volatile SingularAttribute<TNotification, Date> dtUPDATED;
    public static volatile SingularAttribute<TNotification, String> strDESCRIPTION;
    public static volatile SingularAttribute<TNotification, TUser> lgUSERIDOUT;

}