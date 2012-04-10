package com.iiitb.utils;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Venkatesan
 */
public class RepositoryManager {

    /**
     * @param args the command line arguments
     */
    public ArrayList getPackageList() throws ParserConfigurationException {

        String packageName = null;
        ArrayList<String> packageList = new ArrayList<String>();


        try {
            String filepath = "tempRepoInfo.xml";

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node company = doc.getFirstChild();
            Element root = doc.getDocumentElement();


            for (int i = 0; i < doc.getElementsByTagName("XDB_object").getLength(); i++) {

                Node staff = doc.getElementsByTagName("XDB_object").item(i);

                // update staff attribute
                NamedNodeMap attr = staff.getAttributes();

                Node nodeAttr = attr.getNamedItem("name");

                try {
                    packageName = nodeAttr.getTextContent();
                    packageList.add(packageName);
                } catch (Exception e) {
                }

                System.out.println("The root element is " + packageName + ".\n");

            }

            for (String items : packageList) {
                System.out.println(items);
            }

        } catch (ParserConfigurationException pce) {
            System.out.println("Parse Exception");
        } catch (IOException ioe) {
             System.out.println("IO Exception");
        } catch (SAXException sae) {
             System.out.println("SAX Exception");
        }

        return packageList;
    }
}
