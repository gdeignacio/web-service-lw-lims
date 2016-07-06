
package labware_weblims_authenticate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the labware_weblims_authenticate package. 
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

    private final static QName _AuthenticateLimsDSName_QNAME = new QName("labware_weblims_authenticate", "limsDSName");
    private final static QName _AuthenticatePassword_QNAME = new QName("labware_weblims_authenticate", "password");
    private final static QName _AuthenticateLimsServiceName_QNAME = new QName("labware_weblims_authenticate", "limsServiceName");
    private final static QName _AuthenticateUsername_QNAME = new QName("labware_weblims_authenticate", "username");
    private final static QName _AuthenticateResponseReturn_QNAME = new QName("labware_weblims_authenticate", "return");
    private final static QName _AuthenticateWithRoleRole_QNAME = new QName("labware_weblims_authenticate", "role");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: labware_weblims_authenticate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link AuthenticateWithRoleResponse }
     * 
     */
    public AuthenticateWithRoleResponse createAuthenticateWithRoleResponse() {
        return new AuthenticateWithRoleResponse();
    }

    /**
     * Create an instance of {@link AuthenticateWithRole }
     * 
     */
    public AuthenticateWithRole createAuthenticateWithRole() {
        return new AuthenticateWithRole();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "limsDSName", scope = Authenticate.class)
    public JAXBElement<String> createAuthenticateLimsDSName(String value) {
        return new JAXBElement<String>(_AuthenticateLimsDSName_QNAME, String.class, Authenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "password", scope = Authenticate.class)
    public JAXBElement<String> createAuthenticatePassword(String value) {
        return new JAXBElement<String>(_AuthenticatePassword_QNAME, String.class, Authenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "limsServiceName", scope = Authenticate.class)
    public JAXBElement<String> createAuthenticateLimsServiceName(String value) {
        return new JAXBElement<String>(_AuthenticateLimsServiceName_QNAME, String.class, Authenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "username", scope = Authenticate.class)
    public JAXBElement<String> createAuthenticateUsername(String value) {
        return new JAXBElement<String>(_AuthenticateUsername_QNAME, String.class, Authenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "return", scope = AuthenticateResponse.class)
    public JAXBElement<String> createAuthenticateResponseReturn(String value) {
        return new JAXBElement<String>(_AuthenticateResponseReturn_QNAME, String.class, AuthenticateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "return", scope = AuthenticateWithRoleResponse.class)
    public JAXBElement<String> createAuthenticateWithRoleResponseReturn(String value) {
        return new JAXBElement<String>(_AuthenticateResponseReturn_QNAME, String.class, AuthenticateWithRoleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "limsDSName", scope = AuthenticateWithRole.class)
    public JAXBElement<String> createAuthenticateWithRoleLimsDSName(String value) {
        return new JAXBElement<String>(_AuthenticateLimsDSName_QNAME, String.class, AuthenticateWithRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "password", scope = AuthenticateWithRole.class)
    public JAXBElement<String> createAuthenticateWithRolePassword(String value) {
        return new JAXBElement<String>(_AuthenticatePassword_QNAME, String.class, AuthenticateWithRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "limsServiceName", scope = AuthenticateWithRole.class)
    public JAXBElement<String> createAuthenticateWithRoleLimsServiceName(String value) {
        return new JAXBElement<String>(_AuthenticateLimsServiceName_QNAME, String.class, AuthenticateWithRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "role", scope = AuthenticateWithRole.class)
    public JAXBElement<String> createAuthenticateWithRoleRole(String value) {
        return new JAXBElement<String>(_AuthenticateWithRoleRole_QNAME, String.class, AuthenticateWithRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "labware_weblims_authenticate", name = "username", scope = AuthenticateWithRole.class)
    public JAXBElement<String> createAuthenticateWithRoleUsername(String value) {
        return new JAXBElement<String>(_AuthenticateUsername_QNAME, String.class, AuthenticateWithRole.class, value);
    }

}
