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

    public Collection<String> getHistory(File file, String encoding) {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream, encoding);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            return reader.lines().collect(Collectors.toList());
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to get history!");

        } catch (UnsupportedEncodingException e) {
            System.out.println("Incorrect enconding");

        }
        return null;
    }

}
