package dal;

import dal.TImprimante;
import dal.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TUserImprimante.class)
public class TUserImprimante_ { 

    public static volatile SingularAttribute<TUserImprimante, TImprimante> lgIMPRIMANTEID;
    public static volatile SingularAttribute<TUserImprimante, String> strNAME;
    public static volatile SingularAttribute<TUserImprimante, Date> dtCREATED;
    public static volatile SingularAttribute<TUserImprimante, String> strSTATUT;
    public static volatile SingularAttribute<TUserImprimante, Date> dtUPDATED;
    public static volatile SingularAttribute<TUserImprimante, String> strDESCRIPTION;
    public static volatile SingularAttribute<TUserImprimante, String> lgUSERIMPRIMQNTEID;
    public static volatile SingularAttribute<TUserImprimante, TUser> lgUSERID;

}