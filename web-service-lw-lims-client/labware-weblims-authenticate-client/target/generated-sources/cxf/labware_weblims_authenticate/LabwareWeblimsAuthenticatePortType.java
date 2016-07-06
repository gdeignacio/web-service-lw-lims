package labware_weblims_authenticate;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.12
 * Wed Jul 06 14:46:58 CEST 2016
 * Generated source version: 2.2.12
 * 
 */
 
@WebService(targetNamespace = "labware_weblims_authenticate", name = "labware_weblims_authenticatePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface LabwareWeblimsAuthenticatePortType {

    @WebResult(name = "return", targetNamespace = "labware_weblims_authenticate")
    @Action(input = "urn:authenticateWithRole", output = "urn:authenticateWithRoleResponse")
    @RequestWrapper(localName = "authenticateWithRole", targetNamespace = "labware_weblims_authenticate", className = "labware_weblims_authenticate.AuthenticateWithRole")
    @WebMethod(action = "urn:authenticateWithRole")
    @ResponseWrapper(localName = "authenticateWithRoleResponse", targetNamespace = "labware_weblims_authenticate", className = "labware_weblims_authenticate.AuthenticateWithRoleResponse")
    public java.lang.String authenticateWithRole(
        @WebParam(name = "username", targetNamespace = "labware_weblims_authenticate")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "labware_weblims_authenticate")
        java.lang.String password,
        @WebParam(name = "role", targetNamespace = "labware_weblims_authenticate")
        java.lang.String role,
        @WebParam(name = "limsDSName", targetNamespace = "labware_weblims_authenticate")
        java.lang.String limsDSName,
        @WebParam(name = "limsServiceName", targetNamespace = "labware_weblims_authenticate")
        java.lang.String limsServiceName
    );

    @WebResult(name = "return", targetNamespace = "labware_weblims_authenticate")
    @Action(input = "urn:authenticate", output = "urn:authenticateResponse")
    @RequestWrapper(localName = "authenticate", targetNamespace = "labware_weblims_authenticate", className = "labware_weblims_authenticate.Authenticate")
    @WebMethod(action = "urn:authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "labware_weblims_authenticate", className = "labware_weblims_authenticate.AuthenticateResponse")
    public java.lang.String authenticate(
        @WebParam(name = "username", targetNamespace = "labware_weblims_authenticate")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "labware_weblims_authenticate")
        java.lang.String password,
        @WebParam(name = "limsDSName", targetNamespace = "labware_weblims_authenticate")
        java.lang.String limsDSName,
        @WebParam(name = "limsServiceName", targetNamespace = "labware_weblims_authenticate")
        java.lang.String limsServiceName
    );
}
