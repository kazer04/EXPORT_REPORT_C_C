package dal;

import dal.TSms;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TSmsNotSend.class)
public class TSmsNotSend_ { 

    public static volatile SingularAttribute<TSmsNotSend, String> expediteur;
    public static volatile SingularAttribute<TSmsNotSend, Date> dtCREATED;
    public static volatile SingularAttribute<TSmsNotSend, String> lgUPDATEDBY;
    public static volatile SingularAttribute<TSmsNotSend, String> idSms;
    public static volatile SingularAttribute<TSmsNotSend, String> messages;
    public static volatile SingularAttribute<TSmsNotSend, Double> credit;
    public static volatile SingularAttribute<TSmsNotSend, TSms> idSmsMaster;
    public static volatile SingularAttribute<TSmsNotSend, Date> dtUPDATED;
    public static volatile SingularAttribute<TSmsNotSend, String> destinateur;
    public static volatile SingularAttribute<TSmsNotSend, String> statut;
    public static volatile SingularAttribute<TSmsNotSend, String> lgCREATEDBY;

}