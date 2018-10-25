package dal;

import dal.TServices;
import dal.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TUserServices.class)
public class TUserServices_ { 

    public static volatile SingularAttribute<TUserServices, String> lgUSERSERVICESID;
    public static volatile SingularAttribute<TUserServices, Date> dtCREATED;
    public static volatile SingularAttribute<TUserServices, TServices> lgSERVICESID;
    public static volatile SingularAttribute<TUserServices, String> strSTATUT;
    public static volatile SingularAttribute<TUserServices, Date> dtUPDATED;
    public static volatile SingularAttribute<TUserServices, TUser> lgUSERID;

}