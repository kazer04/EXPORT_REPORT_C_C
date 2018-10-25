package dal;

import dal.TMenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-30T13:45:14")
@StaticMetamodel(TModule.class)
public class TModule_ { 

    public static volatile SingularAttribute<TModule, String> strIconehover;
    public static volatile SingularAttribute<TModule, String> strIconeout;
    public static volatile SingularAttribute<TModule, String> strLink;
    public static volatile SingularAttribute<TModule, String> lgMODULEID;
    public static volatile CollectionAttribute<TModule, TMenu> tMenuCollection;
    public static volatile SingularAttribute<TModule, String> pKey;
    public static volatile SingularAttribute<TModule, String> strStatus;
    public static volatile SingularAttribute<TModule, String> strVALUE;
    public static volatile SingularAttribute<TModule, String> strDESCRIPTION;
    public static volatile SingularAttribute<TModule, String> strIcone;
    public static volatile SingularAttribute<TModule, String> strLinkdefault;
    public static volatile SingularAttribute<TModule, Integer> intPRIORITY;

}