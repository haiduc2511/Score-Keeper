package com.example.ghidiemdanhbai.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> convertStringToArrayList(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return new ArrayList<>();
        }

        String[] itemsArray = inputString.split(", ");

        List<String> resultList = new ArrayList<>(Arrays.asList(itemsArray));

        return resultList;
    }
    public static String convertArrayListToString(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        result.append(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            result.append(", ").append(list.get(i));
        }

        return result.toString();
    }

    public static String convertArrayListToString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        result.append(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            result.append(", ").append(list.get(i));
        }

        return result.toString();
    }
}
