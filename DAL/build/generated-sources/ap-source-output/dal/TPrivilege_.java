package dal;

import dal.TRolePrivelege;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TPrivilege.class)
public class TPrivilege_ { 

    public static volatile CollectionAttribute<TPrivilege, TRolePrivelege> tRolePrivelegeCollection;
    public static volatile SingularAttribute<TPrivilege, String> strNAME;
    public static volatile SingularAttribute<TPrivilege, Date> dtCREATED;
    public static volatile SingularAttribute<TPrivilege, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TPrivilege, String> strSTATUT;
    public static volatile SingularAttribute<TPrivilege, Date> dtUPDATED;
    public static volatile SingularAttribute<TPrivilege, String> lgPRIVELEGEIDDEP;
    public static volatile SingularAttribute<TPrivilege, String> lgPRIVELEGEID;
    public static volatile SingularAttribute<TPrivilege, String> strDESCRIPTION;
    public static volatile SingularAttribute<TPrivilege, String> lgCREATEDBY;

}