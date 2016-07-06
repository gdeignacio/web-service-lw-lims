
package com.labware.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.labware.webservice package. 
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

    private final static QName _InvokeRutaFileC_QNAME = new QName("http://www.labware.com/webservice", "rutaFileC");
    private final static QName _InvokeAuthToken_QNAME = new QName("http://www.labware.com/webservice", "authToken");
    private final static QName _InvokeResponseReturn_QNAME = new QName("http://www.labware.com/webservice", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.labware.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Invoke }
     * 
     */
    public Invoke createInvoke() {
        return new Invoke();
    }

    /**
     * Create an instance of {@link InvokeResponse }
     * 
     */
    public InvokeResponse createInvokeResponse() {
        return new InvokeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.labware.com/webservice", name = "rutaFileC", scope = Invoke.class)
    public JAXBElement<String> createInvokeRutaFileC(String value) {
        return new JAXBElement<String>(_InvokeRutaFileC_QNAME, String.class, Invoke.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.labware.com/webservice", name = "authToken", scope = Invoke.class)
    public JAXBElement<String> createInvokeAuthToken(String value) {
        return new JAXBElement<String>(_InvokeAuthToken_QNAME, String.class, Invoke.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.labware.com/webservice", name = "return", scope = InvokeResponse.class)
    public JAXBElement<String> createInvokeResponseReturn(String value) {
        return new JAXBElement<String>(_InvokeResponseReturn_QNAME, String.class, InvokeResponse.class, value);
    }

}
