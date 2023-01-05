package com.company.a;

import java.util.*;

class main {

    public static LinkedHashMap<String, String> difference(List<String> start, List<String> end) {
        LinkedHashMap<String, String> response = new LinkedHashMap<>();

        int maxLength = Math.max(start.size(), end.size());
        for (int i = 0; i < maxLength; i++) {
            int finalI = i;
            if (end.size() > i) {
                boolean exist = start.stream().anyMatch(s -> s.equals(end.get(finalI)));
                if (!response.containsKey(end.get(finalI))) {
                    if (exist) {
                        response.put(end.get(finalI), ".");
                    } else {
                        response.put(end.get(finalI), "+");
                    }
                }
            }

            if (start.size() > i) {
                boolean existEnd = end.stream().anyMatch(s -> s.equals(start.get(finalI)));
                if (!response.containsKey(start.get(finalI))) {
                    if (existEnd) {
                        response.put(start.get(finalI), ".");
                    } else {
                        response.put(start.get(finalI), "-");
                    }
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {
        List<String> start = new ArrayList<>();
        start.add("A");
        start.add("B");
        start.add("C");
        start.add("D");
        List<String> end = new ArrayList<>();
        end.add("X");
        end.add("A");
        end.add("Y");
        end.add("Z");
        end.add("D");
        System.out.print(difference(start, end));
    }

}
