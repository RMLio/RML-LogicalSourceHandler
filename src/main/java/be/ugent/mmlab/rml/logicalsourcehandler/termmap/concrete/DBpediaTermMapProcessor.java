package be.ugent.mmlab.rml.logicalsourcehandler.termmap.concrete;

import be.ugent.mmlab.rml.logicalsourcehandler.termmap.AbstractTermMapProcessor;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 */
public class DBpediaTermMapProcessor extends AbstractTermMapProcessor {

    public List<String> extractValueFromNode(Object node, String expression) {
        HashMap<String, String> templateNode = (HashMap<String, String>) node;
        for(String key : templateNode.keySet())
            try {
                key = new String(key.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        //call the right header in the row
        List<String> list = new ArrayList();
        if (templateNode.containsKey(expression)) {
            list.add(templateNode.get(expression));
        }
        return list;
    }

    public String cleansing(String value) {
        return value;
    }
}
