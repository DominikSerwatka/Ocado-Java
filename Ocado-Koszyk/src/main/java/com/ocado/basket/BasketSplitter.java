package com.ocado.basket;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BasketSplitter {
    private Map<String, List<String>> deliveryOptions;
    public BasketSplitter(String absolutePathToConfigFile) {
        this.deliveryOptions = loadDeliveryOptions(absolutePathToConfigFile);

    }

    private Map<String, List<String>> loadDeliveryOptions(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Map<String, List<String>> getDeliveryOptions(){
        return deliveryOptions;
    }

    public Map<String, List<String>> split(List<String> items) {

        return null;
    }
}
