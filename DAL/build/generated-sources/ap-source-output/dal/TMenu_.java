package dal;

import dal.TModule;
import dal.TSousMenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TMenu.class)
public class TMenu_ { 

    public static volatile SingularAttribute<TMenu, String> lgMENUID;
    public static volatile SingularAttribute<TMenu, TModule> lgMODULEID;
    public static volatile CollectionAttribute<TMenu, TSousMenu> tSousMenuCollection;
    public static volatile SingularAttribute<TMenu, String> pKey;
    public static volatile SingularAttribute<TMenu, String> strStatus;
    public static volatile SingularAttribute<TMenu, String> strVALUE;
    public static volatile SingularAttribute<TMenu, String> strDESCRIPTION;
    public static volatile SingularAttribute<TMenu, Integer> intPRIORITY;

}