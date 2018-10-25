package dal;

import dal.TLanguage;
import dal.TNotification;
import dal.TRoleUser;
import dal.TSkin;
import dal.TUserFone;
import dal.TUserImprimante;
import dal.TUserServices;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TUser.class)
public class TUser_ { 

    public static volatile SingularAttribute<TUser, Boolean> bCHANGEPASSWORD;
    public static volatile SingularAttribute<TUser, String> strSTATUT;
    public static volatile CollectionAttribute<TUser, TNotification> tNotificationCollection1;
    public static volatile SingularAttribute<TUser, TLanguage> lgLanguageID;
    public static volatile SingularAttribute<TUser, Integer> strIDS;
    public static volatile SingularAttribute<TUser, TSkin> lgSKINID;
    public static volatile CollectionAttribute<TUser, TRoleUser> tRoleUserCollection;
    public static volatile SingularAttribute<TUser, String> function;
    public static volatile CollectionAttribute<TUser, TNotification> tNotificationCollection;
    public static volatile SingularAttribute<TUser, String> lgEMPLACEMENTID;
    public static volatile SingularAttribute<TUser, Date> dtUPDATED;
    public static volatile SingularAttribute<TUser, Integer> intCONNEXION;
    public static volatile SingularAttribute<TUser, Boolean> bIsConnected;
    public static volatile SingularAttribute<TUser, String> strPASSWORD;
    public static volatile SingularAttribute<TUser, String> strMAIL;
    public static volatile SingularAttribute<TUser, String> strLASTNAME;
    public static volatile SingularAttribute<TUser, Date> dtCREATED;
    public static volatile SingularAttribute<TUser, String> strCREATEDBY;
    public static volatile SingularAttribute<TUser, String> strUPDATEDBY;
    public static volatile SingularAttribute<TUser, String> strLOGIN;
    public static volatile CollectionAttribute<TUser, TUserServices> tUserServicesCollection;
    public static volatile SingularAttribute<TUser, Date> dtLASTACTIVITY;
    public static volatile SingularAttribute<TUser, Date> strLASTCONNECTIONDATE;
    public static volatile CollectionAttribute<TUser, TUserImprimante> tUserImprimanteCollection;
    public static volatile SingularAttribute<TUser, String> strPHONE;
    public static volatile SingularAttribute<TUser, String> strFUNCTION;
    public static volatile CollectionAttribute<TUser, TUserFone> tUserFoneCollection;
    public static volatile SingularAttribute<TUser, String> strFIRSTNAME;
    public static volatile SingularAttribute<TUser, String> lgUSERID;

}