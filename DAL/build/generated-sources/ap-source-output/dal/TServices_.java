package dal;

import dal.TUserServices;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TServices.class)
public class TServices_ { 

    public static volatile SingularAttribute<TServices, String> strNAME;
    public static volatile SingularAttribute<TServices, Date> dtCREATED;
    public static volatile SingularAttribute<TServices, String> lgSERVICESID;
    public static volatile SingularAttribute<TServices, String> strSTATUT;
    public static volatile SingularAttribute<TServices, Date> dtUPDATED;
    public static volatile SingularAttribute<TServices, String> strDESCRIPTION;
    public static volatile CollectionAttribute<TServices, TUserServices> tUserServicesCollection;

}