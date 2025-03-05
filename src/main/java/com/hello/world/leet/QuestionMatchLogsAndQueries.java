package com.hello.world.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionMatchLogsAndQueries {

    // Q1: Find and match logs and queries in a given list of strings

    public String[] matchLogsAndQueries(String[] logs, String[] queries) {

        List<String> foundList = new ArrayList<>();

        String regexp = "([\\s\\S]*|[\\w\\W]*)";

        for(String query : queries) {
            String regexpMather = query+regexp;
            for (String s : logs) {
                if (s.matches(regexpMather)) {
                    foundList.add(s);
                }
            }
        }

        return foundList.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] input = {"Error: File not found", "Warning: Low memory", "Info: Process started"};
        String[] queries = {"Error", "Info"};

        QuestionMatchLogsAndQueries queryMatcher = new QuestionMatchLogsAndQueries();

        System.out.println(Arrays.toString(queryMatcher.matchLogsAndQueries(input, queries)));
    }
}
