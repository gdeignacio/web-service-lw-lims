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


package es.caib.sgtsic.labware.weblims.client;

import es.caib.sgtsic.labware.weblims.authenticate.client.ClientLabwareWeblimsAuthenticate;
import es.caib.sgtsic.labware.weblims.close.client.ClientLabwareWeblimsClose;
import es.caib.sgtsic.labware.weblims.reportsbean.client.ClientLabwareWeblimsReportsBean;
import es.caib.sgtsic.util.DataHandlers;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.activation.DataHandler;


/**
 *
 * @author gdeignacio
 */
public class ClientWebServiceLabwareLims {
    
    /**
     * El objeto que almacena la instancia de la clase según el patrón sigleton.
     * 
     */
    private static ClientWebServiceLabwareLims cliente = new ClientWebServiceLabwareLims();
    
    
    /** 
    * Construye un objeto de la clase. 
    * Este método es privado para forzar el patrón singleton. 
    */
    private ClientWebServiceLabwareLims(){
        super();
    }
    
    /**
     * Recupera el objeto singleton de la clase.
     *
     * @return el objeto singleton de la clase ClientWebServiceHIS.
     */
    public static ClientWebServiceLabwareLims getCliente(){
        return cliente;
    }
    
    
    private static String getAuthentication(){
        
        ClientLabwareWeblimsAuthenticate clientLabwareWeblimsAuthenticate = ClientLabwareWeblimsAuthenticate.getCliente();
        
        String authToken = clientLabwareWeblimsAuthenticate.authenticate();
        
        return authToken;
    }
    
    private static boolean close(String authToken){
        
        ClientLabwareWeblimsClose clientLabwareWeblimsClose = ClientLabwareWeblimsClose.getCliente();
        
        boolean status = clientLabwareWeblimsClose.close(authToken);
        
        return status;
    
    }
    
    private static String getReport(String ruta){
    
        String authToken = getAuthentication();
        
        ClientLabwareWeblimsReportsBean clientLabwareWeblimsReportsBean = ClientLabwareWeblimsReportsBean.getCliente();
        
        String dataFile = clientLabwareWeblimsReportsBean.invoke(authToken, ruta);
        
        boolean status = close(authToken);
        
        return dataFile;
    }
    
    
     public static void main(String argv[]) throws FileNotFoundException, IOException{
         
       System.setProperty("es.caib.sgtsic.labware.weblims.authenticate.client.username", "WS");
       System.setProperty("es.caib.sgtsic.labware.weblims.authenticate.client.password", "webweb");
       System.setProperty("es.caib.sgtsic.labware.weblims.authenticate.client.limsDSName", "LIMSPRE");
       System.setProperty("es.caib.sgtsic.labware.weblims.authenticate.client.limsServiceName", "WEBLIMS");
       
       
       System.setProperty("es.caib.sgtsic.labware.weblims.authenticate.client.baseURL", 
               "http://esaninf32.caib.es:8080/WebLIMS/services");
       
       
         
         
       
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.username", "WS");
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.password", "webweb");
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.limsDSName", "LIMSPRE");
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.limsServiceName", "WEBLIMS");
       
       
       System.setProperty("es.caib.sgtsic.labware.weblims.close.client.baseURL", 
               "http://esaninf32.caib.es:8080/WebLIMS/services");
       
       
         
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.username", "WS");
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.password", "webweb");
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.limsDSName", "LIMSPRE");
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.limsServiceName", "WEBLIMS");
       
       
       System.setProperty("es.caib.sgtsic.labware.weblims.reportsbean.client.baseURL", 
               "http://esaninf32.caib.es:8080/WebLIMS/services");
         
         
        
         System.out.println("Proceso");

         String ruta = "\\\\ssaninf6\\lims\\PRE\\Reports\\Informes\\12431_V1.pdf";
         
         String respuesta = ClientWebServiceLabwareLims.getReport(ruta);
         
         System.out.println(respuesta);
         
         byte[] arrayByte = respuesta.getBytes();
         
        //DataHandler dh = DataHandlers.byteArrayToDataHandler(arrayByte, "application/pdf");
         
        FileOutputStream fos = new FileOutputStream("/home/gdeignacio/informe_rescatado.pdf");


        //byte[] b = DataHandlers.dataHandlerToByteArray(dh);

        fos.write(arrayByte);

        fos.close();
         
         
         
         
         /*
         DataHandler MSC1 = new DataHandler(new FileDataSource("/home/gdeignacio/MSC1.dbf"));
         
         InputStream dbf = null;
         try {
             dbf = MSC1.getInputStream();
         } catch (IOException ex) {
             Logger.getLogger(ClientWebServiceLabwareLims.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         //InputStream dbf = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/MSC1.dbf");

        //InputStream dbf = getClass().getClassLoader().getResourceAsStream("data/MSC1.dbf");
         DbfRecord rec;
         try (DbfReader reader = new DbfReader(dbf)) {
             DbfMetadata meta = reader.getMetadata();
             
             for (DbfField f: meta.getFields()){
                 
                 System.out.println("Campo:" + f.getName() + ":" + f.getType().name());
             }

            //assertEquals(5, meta.getRecordsQty());
             //assertEquals(28, meta.getFields().size());
             System.out.println("Read DBF Metadata: " + meta);
             int recCounter = 0;
             while ((rec = reader.read()) != null) {
                 //rec.setStringCharset(stringCharset);
                 System.out.println("Record is DELETED: " + rec.isDeleted());
                 System.out.println(rec.getRecordNumber());
                 System.out.println(rec.toMap());

                 Map registro = rec.toMap();

                 System.out.println(registro.get("CODCENTRO"));

                 recCounter++;
                 //assertEquals(recCounter, rec.getRecordNumber());
             }
         } catch (IOException | ParseException ex) {
             Logger.getLogger(CargaXML.class.getName()).log(Level.SEVERE, null, ex);
         }
         
               
                 
         
         CargaXML carga = new CargaXML();
         
         try {
             carga.MSC1();
             
             System.out.println("FIN");
         } catch (IOException | JAXBException ex) {
             Logger.getLogger(ClientWebServiceLabwareLims.class.getName()).log(Level.SEVERE, null, ex);
         }
                 */
         
         

    }
    
    
}
