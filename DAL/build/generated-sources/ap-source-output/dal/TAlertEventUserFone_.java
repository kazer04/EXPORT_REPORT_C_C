package dal;

import dal.TAlertEvent;
import dal.TUserFone;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TAlertEventUserFone.class)
public class TAlertEventUserFone_ { 

    public static volatile SingularAttribute<TAlertEventUserFone, String> lgID;
    public static volatile SingularAttribute<TAlertEventUserFone, String> dtCREATED;
    public static volatile SingularAttribute<TAlertEventUserFone, TUserFone> lgUSERFONEID;
    public static volatile SingularAttribute<TAlertEventUserFone, String> strSTATUT;
    public static volatile SingularAttribute<TAlertEventUserFone, TAlertEvent> strEvent;

}