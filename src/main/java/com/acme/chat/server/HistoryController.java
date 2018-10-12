package com.acme.chat.server;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryController {

    public void update(String message) {
        throw new UnsupportedOperationException();
    }

    public Collection<String> getHistory(File file) {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    new FileInputStream(file)),
                            "windows-1251"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to get history!");

        } catch (UnsupportedEncodingException e) {
            System.out.println("Incorrect enconding");

        }

        return reader.lines().collect(Collectors.toList());
    }

}
