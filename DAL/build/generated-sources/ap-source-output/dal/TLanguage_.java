package dal;

import dal.TUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TLanguage.class)
public class TLanguage_ { 

    public static volatile SingularAttribute<TLanguage, String> strDescription;
    public static volatile SingularAttribute<TLanguage, String> strCode;
    public static volatile SingularAttribute<TLanguage, String> lgLanguageID;
    public static volatile SingularAttribute<TLanguage, String> strLocalCty;
    public static volatile CollectionAttribute<TLanguage, TUser> tUserCollection;
    public static volatile SingularAttribute<TLanguage, String> strLocalLg;

}