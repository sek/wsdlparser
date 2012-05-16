package com.stankurdziel.stackoverflow.question10611034;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class WsdlParser {

    public String[] listOperations(String filename) throws FileNotFoundException, SAXException,
            IOException, ParserConfigurationException {
        Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new FileInputStream(filename));
        NodeList elements = d.getElementsByTagName("operation");
        ArrayList<String> operations = new ArrayList<String>();
        for (int i = 0; i < elements.getLength(); i++) {
            operations.add(elements.item(i).getAttributes().getNamedItem("name").getNodeValue());
        }
        return operations.toArray(new String[operations.size()]);
    }

    public String[] listOperationsUnique(String filename) throws FileNotFoundException,
            SAXException, IOException, ParserConfigurationException {
        String[] nonUnique = listOperations(filename);
        HashSet<String> unique = new HashSet<String>(Arrays.asList(nonUnique));
        return unique.toArray(new String[unique.size()]);
    }
}
