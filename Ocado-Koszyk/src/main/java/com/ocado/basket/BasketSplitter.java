package com.ocado.basket;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

        Map<String, Integer> occurrence = new HashMap<>();

        for (String item : items) {
            for (String option : deliveryOptions.get(item)) {
                if (occurrence.containsKey(option)) {
                    occurrence.put(option, occurrence.get(option)+1);
                } else {
                    occurrence.put(option, 1);
                }
            }
        }


        List<Map.Entry<String, Integer>> sortedOccurrence = new ArrayList<>(occurrence.entrySet());
        Collections.sort(sortedOccurrence, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        Map<String, List<String>> finalResult = new HashMap<>();
        List<String> productList = new ArrayList<>();

        List<String> helpItemsList = new ArrayList<>(items);

        while (true) {

            List<Map.Entry<String, Integer>> sortOccurrence = computeOccurrence(helpItemsList);
            if (sortOccurrence.isEmpty()) {
                break;
            }
            for (Map.Entry<String, Integer> e : sortOccurrence ){

                if (productList.size() == helpItemsList.size()) {
                    break;
                } else {
                    List<String> helpProductList = new ArrayList<>();
                    List<String> helpItemList2 = new ArrayList<>(helpItemsList);
                    for (String item : helpItemList2 ) {
                        if (!productList.contains(item)){
                            if (deliveryOptions.get(item).contains(e.getKey())){
                                helpProductList.add(item);
                                productList.add(item);
                                helpItemsList.remove(item);
                            }
                        }
                    }
                    if (!helpProductList.isEmpty()) {
                        finalResult.put(e.getKey(), helpProductList);
                    }

                }
            }

        }

        System.out.println(finalResult);



//        for (Map.Entry<String, Integer> e : sortedOccurrence ){
//
//
//            if (productList.size() == items.size()) {
//                break;
//            } else {
//                List<String> helpProductList = new ArrayList<>();
//                for (String item : items ) {
//                    if (!productList.contains(item)){
//                        if (deliveryOptions.get(item).contains(e.getKey())){
//                            helpProductList.add(item);
//                            productList.add(item);
//                        }
//                    }
//                }
//                if (!helpProductList.isEmpty()) {
//                    finalResult.put(e.getKey(), helpProductList);
//                }
//
//            }
//        }
//        System.out.println(finalResult);

        return null;
    }

    public List<Map.Entry<String, Integer>> computeOccurrence(List<String> items){

        Map<String, Integer> occurrence = new HashMap<>();

        for (String item : items) {
            for (String option : deliveryOptions.get(item)) {
                if (occurrence.containsKey(option)) {
                    occurrence.put(option, occurrence.get(option)+1);
                } else {
                    occurrence.put(option, 1);
                }
            }
        }


        List<Map.Entry<String, Integer>> sortedOccurrence = new ArrayList<>(occurrence.entrySet());
        Collections.sort(sortedOccurrence, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return sortedOccurrence;

    }

}
