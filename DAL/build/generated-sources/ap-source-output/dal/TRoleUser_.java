package dal;

import dal.TRole;
import dal.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TRoleUser.class)
public class TRoleUser_ { 

    public static volatile SingularAttribute<TRoleUser, String> lgUSERROLEID;
    public static volatile SingularAttribute<TRoleUser, Date> dtCREATED;
    public static volatile SingularAttribute<TRoleUser, TRole> lgROLEID;
    public static volatile SingularAttribute<TRoleUser, String> strCREATEDBY;
    public static volatile SingularAttribute<TRoleUser, Date> dtUPDATED;
    public static volatile SingularAttribute<TRoleUser, String> strUPDATEDBY;
    public static volatile SingularAttribute<TRoleUser, TUser> lgUSERID;

}