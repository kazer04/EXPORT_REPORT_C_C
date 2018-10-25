package dal;

import dal.TUserImprimante;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TImprimante.class)
public class TImprimante_ { 

    public static volatile SingularAttribute<TImprimante, String> lgIMPRIMANTEID;
    public static volatile SingularAttribute<TImprimante, String> strNAME;
    public static volatile SingularAttribute<TImprimante, Date> dtCREATED;
    public static volatile CollectionAttribute<TImprimante, TUserImprimante> tUserImprimanteCollection;
    public static volatile SingularAttribute<TImprimante, String> strSTATUT;
    public static volatile SingularAttribute<TImprimante, Date> dtUPDATED;
    public static volatile SingularAttribute<TImprimante, String> strDESCRIPTION;

}