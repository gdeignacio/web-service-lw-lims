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

import es.caib.sgtsic.labware.weblims.close.utils.UtilsIO;

/**
 *
 * @author gdeignacio
 */
public class DatosConexionLabwareWebLimsClose {
    
    public static final String qname = "labware_weblims_close";
    
    public static final String codapp = "es.caib.sgtsic";
    public static final String codclient = "labware.weblims.close.client";
    
    public static final String username = UtilsIO.NVL(System.getProperty(codapp + "." + codclient + ".username"), "").trim();
    public static final String password = UtilsIO.NVL(System.getProperty(codapp + "." + codclient + ".password"), "").trim();
    public static final String baseURL = UtilsIO.NVL(System.getProperty(codapp + "." + codclient + ".baseURL"), "").trim();

    public static final String WebServiceLabwareWeblimsCloseName = "labware_weblims_close";
    
    public static final String name = WebServiceLabwareWeblimsCloseName;
    
    public static final String WebServiceLabwareWeblimsCloseContext = "/" + WebServiceLabwareWeblimsCloseName;

    public static final String context = WebServiceLabwareWeblimsCloseContext;
    
    public static final String wsdlEnding = "?wsdl";

    public static final String wsdlLocationWebServiceLabwareWeblimsClose = baseURL +  
            WebServiceLabwareWeblimsCloseContext + wsdlEnding;
    
    public static final String wsdl = wsdlLocationWebServiceLabwareWeblimsClose;
    
    public static final String limsDSName = UtilsIO.NVL(System.getProperty(codapp + "." + codclient + ".limsDSName"), "").trim();
    
    public static final String limsServiceName = UtilsIO.NVL(System.getProperty(codapp + "." + codclient + ".limsServiceName"), "").trim();
           
            
    static{
        if (username == null) System.out.println("La propiedad " + codapp + "." + codclient + ".username no está bien definida.");
        if (password == null) System.out.println("La propiedad " + codapp + "." + codclient + ".password no está bien definida.");
        if (baseURL == null) System.out.println("La propiedad  " + codapp + "." + codclient + ".baseURL no está bien definida.");
        if (username == null || password == null || baseURL == null) throw new RuntimeException("Configuración de WS para " + codclient + " no completada");
    }
    
    
    
    
    
    
    
    
}
