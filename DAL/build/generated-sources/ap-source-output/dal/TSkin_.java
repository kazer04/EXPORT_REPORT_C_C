package dal;

import dal.TUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TSkin.class)
public class TSkin_ { 

    public static volatile SingularAttribute<TSkin, String> strRESOURCE;
    public static volatile SingularAttribute<TSkin, String> strDETAILPATH;
    public static volatile SingularAttribute<TSkin, String> lgSKINID;
    public static volatile SingularAttribute<TSkin, String> strSTATUT;
    public static volatile CollectionAttribute<TSkin, TUser> tUserCollection;
    public static volatile SingularAttribute<TSkin, String> strDESCRIPTION;

}