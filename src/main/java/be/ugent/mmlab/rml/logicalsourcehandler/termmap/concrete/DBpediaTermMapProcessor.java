package be.ugent.mmlab.rml.logicalsourcehandler.termmap.concrete;

import be.ugent.mmlab.rml.logicalsourcehandler.termmap.AbstractTermMapProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 */
public class DBpediaTermMapProcessor extends AbstractTermMapProcessor {

    @Override
    public List<String> extractValueFromNode(Object node, String expression) {
        HashMap<String, String> templateNode = (HashMap<String, String>) node;
        for(String key : templateNode.keySet())
            key = new String(key.getBytes(), UTF_8);
        //call the right header in the row
        List<String> list = new ArrayList();
        if (templateNode.containsKey(expression)) {
            list.add(templateNode.get(expression));
        }
        return list;
    }

    @Override
    public String cleansing(String value) {
        return value;
    }
}
