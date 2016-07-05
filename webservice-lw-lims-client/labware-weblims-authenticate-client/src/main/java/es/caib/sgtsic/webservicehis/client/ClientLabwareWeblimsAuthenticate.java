/*
 * Copyright 2016 gdeignacio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.caib.sgtsic.webservicehis.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import labware_weblims_authenticate.LabwareWeblimsAuthenticate;
import labware_weblims_authenticate.LabwareWeblimsAuthenticatePortType;

/**
 *
 * @author gdeignacio
 */
public class ClientLabwareWeblimsAuthenticate {
    
    /**
     * El objeto que almacena la instancia de la clase según el patrón sigleton.
     * 
     */
    private static ClientLabwareWeblimsAuthenticate cliente = new ClientLabwareWeblimsAuthenticate();
   
    /** 
    * Construye un objeto de la clase. 
    * Este método es privado para forzar el patrón singleton. 
    */
    private ClientLabwareWeblimsAuthenticate(){
        super();
    }
    
    /**
     * Recupera el objeto singleton de la clase.
     *
     * @return el objeto singleton de la clase ClientLabwareWeblimsAuthenticate.
     */
    public static ClientLabwareWeblimsAuthenticate getCliente(){
        return cliente;
    }
    
    private static final QName SERVICE_NAME = new QName(DatosConexionLabwareWebLimsAuthenticate.qname, 
            DatosConexionLabwareWebLimsAuthenticate.WebServiceLabwareWeblimsAuthenticateName);

    private LabwareWeblimsAuthenticatePortType getServicePort(){
        
        URL wsdlURL = null;

        try {
            wsdlURL = new URL(DatosConexionLabwareWebLimsAuthenticate.wsdlLocationWebServiceLabwareWeblimsAuthenticate);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientLabwareWeblimsAuthenticate.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabwareWeblimsAuthenticate ss = new LabwareWeblimsAuthenticate(wsdlURL, SERVICE_NAME);
        LabwareWeblimsAuthenticatePortType port = ss.getLabwareWeblimsAuthenticateHttpSoap12Endpoint();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                DatosConexionLabwareWebLimsAuthenticate.baseURL + 
                        DatosConexionLabwareWebLimsAuthenticate.WebServiceLabwareWeblimsAuthenticateContext);
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList(DatosConexionLabwareWebLimsAuthenticate.username));
        headers.put("Password", Collections.singletonList(DatosConexionLabwareWebLimsAuthenticate.password));
        req.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        return port;
    
    }
    
    private LabwareWeblimsAuthenticatePortType getOpenServicePort(){
        
        URL wsdlURL = null;

        try {
            wsdlURL = new URL(DatosConexionLabwareWebLimsAuthenticate.wsdlLocationWebServiceLabwareWeblimsAuthenticate);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientLabwareWeblimsAuthenticate.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabwareWeblimsAuthenticate ss = new LabwareWeblimsAuthenticate(wsdlURL, SERVICE_NAME);
        LabwareWeblimsAuthenticatePortType port = ss.getLabwareWeblimsAuthenticateHttpSoap12Endpoint();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                DatosConexionLabwareWebLimsAuthenticate.baseURL + 
                        DatosConexionLabwareWebLimsAuthenticate.WebServiceLabwareWeblimsAuthenticateContext);
       

        return port;
    
    }
    
 
    
     private static String authenticate(LabwareWeblimsAuthenticatePortType port,
             String username, String password, String limsDSName, String limsServiceName){
        
        String _return = port.authenticate(username, password, limsDSName, limsServiceName);
        return _return;
        
    }
    
    
    public String authenticate(){
        
        LabwareWeblimsAuthenticatePortType port = getOpenServicePort();
        
        String username = DatosConexionLabwareWebLimsAuthenticate.username;
        String password = DatosConexionLabwareWebLimsAuthenticate.password;
        String limsDSName = null; 
        String limsServiceName = null;
        
        String response = port.authenticate(username, password, limsDSName, limsServiceName);
        
        return response;
        
    }
    
    
    public static void main(String args[]) throws Exception {

        /*

        URL wsdlURL = AsnNotifService.WSDL_LOCATION;
        if (args.length > 0) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        AsnNotifService ss = new AsnNotifService(wsdlURL, SERVICE_NAME);
        AsnNotif port = ss.getAsnNotifPort();
         *
         */
         // System.exit(0);

       //System.setProperty("es.caib.sgtsic.webservicehis.client.username", "$hman_cbpmd");
       //System.setProperty("es.caib.sgtsic.webservicehis.client.password", "hman_cbpmd");
       //System.setProperty("es.caib.sgtsic.webservicehis.client.baseURL", 
       //        "http://10.215.9.179:18080/pdpcmb/services");

       
       System.setProperty("es.caib.sgtsic.webservicehis.client.username", "$hman_cbpmd");
       System.setProperty("es.caib.sgtsic.webservicehis.client.password", "hman_cbpmd");
       System.setProperty("es.caib.sgtsic.webservicehis.client.baseURL", 
               "http://10.215.9.179:18080/pdpcmb/services");
       
       
       ClientLabwareWeblimsAuthenticate chis = ClientLabwareWeblimsAuthenticate.getCliente();
  
       //WebServiceHIS port = chis.getServicePort();
       
       //String datAge = "13/05/2015";
       
       //String response = ClientLabwareWeblimsAuthenticate.getHISList(port, datAge);
       
       //System.out.println("Result: "  + response);

       // parametros.setNotCodigo("1");



     }
    
    
    
    
    
}
