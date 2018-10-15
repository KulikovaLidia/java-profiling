package com.acme.chat.server;

import com.acme.chat.client.ChatClient;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DDD, Eric Evance
 */
public class MessageController {
    private HistoryController historyController;
    private Collection<ChatClient> clients = new HashSet<>(); //TODO hypotesis to profile

    public MessageController(HistoryController historyController) {
        this.historyController = historyController;
    }

    /**
     *   XA resource + JTA(JavaEE) -> Saga
     */
    public void send(String message) {
        notifyClients(message);
        historyController.update(message);
    }

    public List<String> getHistory(File file, String encoding) {
        return historyController.getHistory(file, encoding).stream().collect(Collectors.toList());
    }

    public void subscribeOn(ChatClient client) {
        clients.add(client);
    }

    private void notifyClients(final String message) {
        clients.forEach(client -> client.onMessage(message));
    }
}
