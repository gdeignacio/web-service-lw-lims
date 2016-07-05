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

import es.caib.pdpcmb.webservice.ejb.WebServiceHIS;
import es.caib.pdpcmb.webservice.ejb.WebServiceHIS_Service;
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
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author gdeignacio
 */
public class ClientWebServiceHIS {
    
    /**
     * El objeto que almacena la instancia de la clase según el patrón sigleton.
     * 
     */
    private static ClientWebServiceHIS cliente = new ClientWebServiceHIS();
   
    /** 
    * Construye un objeto de la clase. 
    * Este método es privado para forzar el patrón singleton. 
    */
    private ClientWebServiceHIS(){
        super();
    }
    
    /**
     * Recupera el objeto singleton de la clase.
     *
     * @return el objeto singleton de la clase ClientWebServiceHIS.
     */
    public static ClientWebServiceHIS getCliente(){
        return cliente;
    }
    
    private static final QName SERVICE_NAME = new QName(DatosConexionHIS.qname, DatosConexionHIS.WebServiceHISName);

    private WebServiceHIS getServicePort(){
        
        URL wsdlURL = null;

        try {
            wsdlURL = new URL(DatosConexionHIS.wsdlLocationWebServiceHIS);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientWebServiceHIS.class.getName()).log(Level.SEVERE, null, ex);
        }

        WebServiceHIS_Service ss = new WebServiceHIS_Service(wsdlURL, SERVICE_NAME);
        WebServiceHIS port = ss.getWebServiceHISPort();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, DatosConexionHIS.baseURL + DatosConexionHIS.WebServiceHISContext);
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList(DatosConexionHIS.username));
        headers.put("Password", Collections.singletonList(DatosConexionHIS.password));
        req.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        return port;
    
    }
    
    
    public String getHISList(String datAge){
        
        WebServiceHIS port = getServicePort();
        
        String parametros = datAge;
        String response = getHISList(port, parametros);
        
        return response;
    
    }
    
    private static String getHISList(WebServiceHIS port, String datAge){
    
        String _parameters = datAge;
        String _return = port.getHISList(_parameters);
        return _return;
        
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

       System.setProperty("es.caib.sgtsic.webservicehis.client.username", "$hman_cbpmd");
       System.setProperty("es.caib.sgtsic.webservicehis.client.password", "hman_cbpmd");
       System.setProperty("es.caib.sgtsic.webservicehis.client.baseURL", "http://10.215.9.179:18080/pdpcmb/services");

       
       ClientWebServiceHIS chis = ClientWebServiceHIS.getCliente();
  
       WebServiceHIS port = chis.getServicePort();
       
       String datAge = "13/05/2015";
       
       String response = ClientWebServiceHIS.getHISList(port, datAge);
       
       System.out.println("Result: "  + response);

       // parametros.setNotCodigo("1");



     }
    
    
    
    
    
}
