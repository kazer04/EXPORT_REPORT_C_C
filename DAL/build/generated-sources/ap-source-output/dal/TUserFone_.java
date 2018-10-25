package dal;

import dal.TAlertEventUserFone;
import dal.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TUserFone.class)
public class TUserFone_ { 

    public static volatile SingularAttribute<TUserFone, Date> dtCREATED;
    public static volatile SingularAttribute<TUserFone, String> strPHONE;
    public static volatile SingularAttribute<TUserFone, String> lgUSERFONEID;
    public static volatile SingularAttribute<TUserFone, String> strSTATUT;
    public static volatile SingularAttribute<TUserFone, Date> dtUPDATED;
    public static volatile CollectionAttribute<TUserFone, TAlertEventUserFone> tAlertEventUserFoneCollection;
    public static volatile SingularAttribute<TUserFone, TUser> lgUSERID;

}