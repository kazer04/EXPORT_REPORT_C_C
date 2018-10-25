package dal;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TInboudMessage.class)
public class TInboudMessage_ { 

    public static volatile SingularAttribute<TInboudMessage, Date> dtCREATED;
    public static volatile SingularAttribute<TInboudMessage, String> lgINBOUNDMESSAGEID;
    public static volatile SingularAttribute<TInboudMessage, String> strPHONE;
    public static volatile SingularAttribute<TInboudMessage, String> strSTATUT;
    public static volatile SingularAttribute<TInboudMessage, String> strMESSAGE;
    public static volatile SingularAttribute<TInboudMessage, Date> dtUPDATED;

}