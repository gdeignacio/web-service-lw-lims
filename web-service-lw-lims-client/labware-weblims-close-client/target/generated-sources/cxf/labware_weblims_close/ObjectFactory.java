
package labware_weblims_close;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the labware_weblims_close package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CloseAuthToken_QNAME = new QName("labware_weblims_close", "authToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: labware_weblims_close
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Close }
     * 
     */
    public Close createClose() {
        return new Close();
    }

    /**
     * Create an instance of {@link CloseResponse }
     * 
     */
    public CloseResponse createCloseResponse() {
        return new CloseResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_close", name = "authToken", scope = Close.class)
    public JAXBElement<String> createCloseAuthToken(String value) {
        return new JAXBElement<String>(_CloseAuthToken_QNAME, String.class, Close.class, value);
    }

}
