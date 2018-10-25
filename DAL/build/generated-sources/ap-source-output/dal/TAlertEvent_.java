package dal;

import dal.TAlertEventUserFone;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TAlertEvent.class)
public class TAlertEvent_ { 

    public static volatile SingularAttribute<TAlertEvent, Date> dtDateEnvoi;
    public static volatile SingularAttribute<TAlertEvent, String> strERRORCODE;
    public static volatile SingularAttribute<TAlertEvent, Integer> intMaxMessages;
    public static volatile SingularAttribute<TAlertEvent, String> strSMSFrenchText;
    public static volatile SingularAttribute<TAlertEvent, String> strMAILFrenchText;
    public static volatile SingularAttribute<TAlertEvent, String> lgUIDWhoLastUpdate;
    public static volatile SingularAttribute<TAlertEvent, String> strEvent;
    public static volatile CollectionAttribute<TAlertEvent, TAlertEventUserFone> tAlertEventUserFoneCollection;
    public static volatile SingularAttribute<TAlertEvent, String> strMAILEnglishText;
    public static volatile SingularAttribute<TAlertEvent, Date> dtLastEnterDate;
    public static volatile SingularAttribute<TAlertEvent, String> lgUIDWhoNew;
    public static volatile SingularAttribute<TAlertEvent, String> strSMSEnglishText;
    public static volatile SingularAttribute<TAlertEvent, Boolean> bIsCommand;
    public static volatile SingularAttribute<TAlertEvent, Boolean> bRowActive;
    public static volatile SingularAttribute<TAlertEvent, BigDecimal> decNumPercent;

}