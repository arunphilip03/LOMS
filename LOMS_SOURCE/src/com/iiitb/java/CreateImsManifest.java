package com.iiitb.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CreateImsManifest {
  

   public void CreateExportImsManifest(String rootDir,String packageName, ArrayList<ManifestData> imsFileInfo) {

        try {
            
            //System.out.println("Manifest Code: Root Dir = "+rootDir);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("manifest");
            doc.appendChild(rootElement);

            rootElement.setAttribute("xmlns","http://www.imsproject.org/xsd/imscp_rootv1p1p2");
            rootElement.setAttribute("xmlns:imsmd","http://www.imsglobal.org/xsd/imsmd_rootv1p2p1");
            rootElement.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xmlns:adlcp","http://www.adlnet.org/xsd/adlcp_rootv1p2");
            rootElement.setAttribute("identifier","MANIFEST_selfpack02"); 
            rootElement.setAttribute("xsi:schemaLocation",
                    "http://www.imsproject.org/xsd/imscp_rootv1p1p2 imscp_rootv1p1p2.xsd "       
                    + "http://www.imsglobal.org/xsd/imsmd_rootv1p2p1 imsmd_rootv1p2p1.xsd "
                    + "http://www.adlnet.org/xsd/adlcp_rootv1p2 adlcp_rootv1p2.xsd");


            Element organizations = doc.createElement("organizations");
            rootElement.appendChild(organizations);
            organizations.setAttribute("default", "org-1");

            Element organization = doc.createElement("organization");
            organizations.appendChild(organization);
            organization.setAttribute("identifier", "org-1");
            organization.setAttribute("structure", "hierarchical");

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode(packageName)); // Setting Package Name as title
            organization.appendChild(title);
            
            int item_count = 1;
            for(ManifestData md: imsFileInfo){
//                String fName=file.getName();
//                StringTokenizer st1 = new StringTokenizer(fName, ".");
//
//                String temp = (String) st1.nextElement();
                //System.out.println("iteration:"+item_count); 
                //System.out.println(temp);
                Element item = doc.createElement("item");
                organization.appendChild(item);

                item.setAttribute("identifier", "item_"+item_count);
                item.setAttribute("identifierref", "res_"+item_count++);
                item.setAttribute("isvisible", "true");

                Element title1 = doc.createElement("title");
                title1.appendChild(doc.createTextNode(md.getFileName()));
                item.appendChild(title1);
              
            }



            Element resources = doc.createElement("resources");
            rootElement.appendChild(resources);
            item_count = 1;        
            for(ManifestData md: imsFileInfo){
//                String name = file.getName();
//                System.out.println(name);
//                System.out.println(file.getAbsoluteFile());
//                System.out.println(file.getAbsolutePath());
//                try {
//                    System.out.println(file.getCanonicalFile().toString());
//                    System.out.println(file.getCanonicalPath());
//                } catch (IOException ex) {
//                    Logger.getLogger(CreateImsManifest.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                 System.out.println(file.getParent());
//                 System.out.println(file.getParentFile());
//                  System.out.println(file.getPath());
                
                
                
                
                
                Element resource1 = doc.createElement("resource");
                resources.appendChild(resource1);
                resource1.setAttribute("identifier",  "res_"+item_count++);
                resource1.setAttribute("href",md.getHref());
                resource1.setAttribute("adlcp:scormtype", "sco");
                resource1.setAttribute("type", "webcontent");
                Element file1 = doc.createElement("file");
                resource1.appendChild(file1);
                file1.setAttribute("href", md.getHref());
            }
 


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rootDir + "/imsmanifest.xml"));        
        
            transformer.transform(source, result);

            //System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.toString();
        } catch (TransformerException tfe) {
            tfe.toString();
        }
    }
}
