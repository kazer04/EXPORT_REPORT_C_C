package dal;

import dal.TRolePrivelege;
import dal.TRoleUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TRole.class)
public class TRole_ { 

    public static volatile CollectionAttribute<TRole, TRolePrivelege> tRolePrivelegeCollection;
    public static volatile SingularAttribute<TRole, String> strNAME;
    public static volatile SingularAttribute<TRole, Date> dtCREATED;
    public static volatile CollectionAttribute<TRole, TRoleUser> tRoleUserCollection;
    public static volatile SingularAttribute<TRole, String> lgROLEID;
    public static volatile SingularAttribute<TRole, String> strTYPE;
    public static volatile SingularAttribute<TRole, String> strSTATUT;
    public static volatile SingularAttribute<TRole, String> strDESIGNATION;
    public static volatile SingularAttribute<TRole, Date> dtUPDATED;

}