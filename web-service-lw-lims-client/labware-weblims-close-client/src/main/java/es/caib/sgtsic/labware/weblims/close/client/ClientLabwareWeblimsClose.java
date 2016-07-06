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
package es.caib.sgtsic.labware.weblims.close.client;

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
import labware_weblims_close.LabwareWeblimsClose;
import labware_weblims_close.LabwareWeblimsClosePortType;

/**
 *
 * @author gdeignacio
 */
public class ClientLabwareWeblimsClose {
    
    /**
     * El objeto que almacena la instancia de la clase según el patrón sigleton.
     * 
     */
    private static ClientLabwareWeblimsClose cliente = new ClientLabwareWeblimsClose();
   
    /** 
    * Construye un objeto de la clase. 
    * Este método es privado para forzar el patrón singleton. 
    */
    private ClientLabwareWeblimsClose(){
        super();
    }
    
    /**
     * Recupera el objeto singleton de la clase.
     *
     * @return el objeto singleton de la clase ClientLabwareWeblimsClose.
     */
    public static ClientLabwareWeblimsClose getCliente(){
        return cliente;
    }
    
    private static final QName SERVICE_NAME = new QName(DatosConexionLabwareWebLimsClose.qname, 
            DatosConexionLabwareWebLimsClose.name);

    private LabwareWeblimsClosePortType getServicePort(){
        
        URL wsdlURL = null;

        
        try {
            wsdlURL = new URL(DatosConexionLabwareWebLimsClose.wsdl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientLabwareWeblimsClose.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabwareWeblimsClose ss = new LabwareWeblimsClose(wsdlURL, SERVICE_NAME);
        LabwareWeblimsClosePortType port = ss.getLabwareWeblimsCloseHttpSoap12Endpoint();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                DatosConexionLabwareWebLimsClose.baseURL + 
                        DatosConexionLabwareWebLimsClose.context);
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList(DatosConexionLabwareWebLimsClose.username));
        headers.put("Password", Collections.singletonList(DatosConexionLabwareWebLimsClose.password));
        req.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        return port;
    
    }
    
    private LabwareWeblimsClosePortType getOpenServicePort(){
        
        URL wsdlURL = null;

        try {
            wsdlURL = new URL(DatosConexionLabwareWebLimsClose.wsdl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientLabwareWeblimsClose.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabwareWeblimsClose ss = new LabwareWeblimsClose(wsdlURL, SERVICE_NAME);
        LabwareWeblimsClosePortType port = ss.getLabwareWeblimsCloseHttpSoap12Endpoint();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                DatosConexionLabwareWebLimsClose.baseURL + 
                        DatosConexionLabwareWebLimsClose.context);
       

        return port;
    
    }
    
    
    private static boolean close(LabwareWeblimsClosePortType port, String authToken){
   
        boolean _return = port.close(authToken);
        return _return;
        
    }
    
 
    public boolean close(String authToken){
        
        LabwareWeblimsClosePortType port = getOpenServicePort();
       
        boolean response = close(port, authToken);
        
        return response;
        
    }
    
    
    public static void main(String args[]) throws Exception {


       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.username", "WS");
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.password", "webweb");
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.limsDSName", "LIMSPRE");
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.limsServiceName", "WEBLIMS");
       
       
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.baseURL", 
               "http://esaninf32.caib.es:8080/WebLIMS/services");
       
       
       ClientLabwareWeblimsClose client = ClientLabwareWeblimsClose.getCliente();
       
       LabwareWeblimsClosePortType port = client.getOpenServicePort();
       
       String authToken = "";
       
       boolean response = ClientLabwareWeblimsClose.close(port, authToken);
              
       
       System.out.println(response);


     }
    
   
}
