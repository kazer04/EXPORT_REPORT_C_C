package dal;

import dal.TPrivilege;
import dal.TRole;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TRolePrivelege.class)
public class TRolePrivelege_ { 

    public static volatile SingularAttribute<TRolePrivelege, Date> dtCREATED;
    public static volatile SingularAttribute<TRolePrivelege, TRole> lgROLEID;
    public static volatile SingularAttribute<TRolePrivelege, String> lgROLEPRIVILEGE;
    public static volatile SingularAttribute<TRolePrivelege, TPrivilege> lgPRIVILEGEID;
    public static volatile SingularAttribute<TRolePrivelege, String> strCREATEDBY;
    public static volatile SingularAttribute<TRolePrivelege, Date> dtUPDATED;
    public static volatile SingularAttribute<TRolePrivelege, String> strUPDATEDBY;

}