package dal;

import dal.TSmsNotSend;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TSms.class)
public class TSms_ { 

    public static volatile CollectionAttribute<TSms, TSmsNotSend> tSmsNotSendCollection;
    public static volatile SingularAttribute<TSms, Date> dtCREATED;
    public static volatile SingularAttribute<TSms, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TSms, String> idSms;
    public static volatile SingularAttribute<TSms, String> message;
    public static volatile SingularAttribute<TSms, Date> dtUPDATED;
    public static volatile SingularAttribute<TSms, String> lgCREATEDBY;
    public static volatile SingularAttribute<TSms, String> statut;

}