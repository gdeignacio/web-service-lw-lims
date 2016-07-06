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
package es.caib.sgtsic.labware.weblims.reportsbean.client;

import com.labware.webservice.REPORTSBEAN;
import com.labware.webservice.REPORTSBEANPortType;
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


/**
 *
 * @author gdeignacio
 */
public class ClientLabwareWeblimsReportsBean {
    
    /**
     * El objeto que almacena la instancia de la clase según el patrón sigleton.
     * 
     */
    private static ClientLabwareWeblimsReportsBean cliente = new ClientLabwareWeblimsReportsBean();
   
    /** 
    * Construye un objeto de la clase. 
    * Este método es privado para forzar el patrón singleton. 
    */
    private ClientLabwareWeblimsReportsBean(){
        super();
    }
    
    /**
     * Recupera el objeto singleton de la clase.
     *
     * @return el objeto singleton de la clase ClientLabwareWeblimsReportsBean.
     */
    public static ClientLabwareWeblimsReportsBean getCliente(){
        return cliente;
    }
    
    private static final QName SERVICE_NAME = new QName(DatosConexionLabwareWebLimsReportsBean.qname, 
            DatosConexionLabwareWebLimsReportsBean.name);

    private REPORTSBEANPortType getServicePort(){
        
        URL wsdlURL = null;

        
        try {
            wsdlURL = new URL(DatosConexionLabwareWebLimsReportsBean.wsdl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientLabwareWeblimsReportsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        REPORTSBEAN ss = new REPORTSBEAN(wsdlURL, SERVICE_NAME);
        REPORTSBEANPortType port = ss.getREPORTSBEANHttpSoap12Endpoint();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                DatosConexionLabwareWebLimsReportsBean.baseURL + 
                        DatosConexionLabwareWebLimsReportsBean.context);
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList(DatosConexionLabwareWebLimsReportsBean.username));
        headers.put("Password", Collections.singletonList(DatosConexionLabwareWebLimsReportsBean.password));
        req.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        return port;
    
    }
    
    private REPORTSBEANPortType getOpenServicePort(){
        
        URL wsdlURL = null;

        try {
            wsdlURL = new URL(DatosConexionLabwareWebLimsReportsBean.wsdl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientLabwareWeblimsReportsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        REPORTSBEAN ss = new REPORTSBEAN(wsdlURL, SERVICE_NAME);
        REPORTSBEANPortType port = ss.getREPORTSBEANHttpSoap12Endpoint();

        Map<String, Object> req = ((BindingProvider) port).getRequestContext();
        req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
                DatosConexionLabwareWebLimsReportsBean.baseURL + 
                        DatosConexionLabwareWebLimsReportsBean.context);
       

        return port;
    
    }
    
    
    private static String invoke(REPORTSBEANPortType port, String authToken, String rutaFileC){
        
        String _return = port.invoke(authToken, rutaFileC);
        return _return;
        
    }
    
 
    public String invoke(String authToken, String rutaFileC){
        
        REPORTSBEANPortType port = getOpenServicePort();
       
        String response = invoke(port, authToken, rutaFileC);
        
        return response;
        
    }
    
    
    public static void main(String args[]) throws Exception {


       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.username", "WS");
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.password", "webweb");
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.limsDSName", "LIMSPRE");
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.limsServiceName", "WEBLIMS");
       
       
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.baseURL", 
               "http://esaninf32.caib.es:8080/WebLIMS/services");
       
       
       ClientLabwareWeblimsReportsBean client = ClientLabwareWeblimsReportsBean.getCliente();
       
       REPORTSBEANPortType port = client.getOpenServicePort();
       
       String rutaFileC = "\\\\ssaninf6\\lims\\PRE\\Reports\\Informes\\12431_V1.pdf";
       String authToken = "CM-03_9301c17155c006efa3bcf16fa8352f5e";
       
       String response = ClientLabwareWeblimsReportsBean.invoke(port, authToken, rutaFileC);
              
       
       System.out.println(response);


     }
    
   
}
