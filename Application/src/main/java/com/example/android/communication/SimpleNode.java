package com.example.android.communication;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SimpleNode implements Node {

    String id = "dummy";
    List<String> connectedIds = new LinkedList<>();

    @Override
    public void disconnect(String id) {
        connectedIds.remove(id);
    }

    @Override
    public void connect(String id) {
        connectedIds.add(id);
    }

    @Override
    public void send(String sourceId, Set<String> forwardedBy, String destinationId, byte[] message) {
        for (String connectedId : connectedIds) {
            if (!forwardedBy.contains(connectedId)) {
                // TODO tell lower layer about sending message to connectedId
            }
        }
    }

    @Override
    public void receive(String sourceId, Set<String> forwardedBy, String destinationId, byte[] message) {
        if (id.equals(destinationId)) {
            // TODO tell upper layer about the message

        } else {
            forwardedBy.add(id);
            send(sourceId, forwardedBy, destinationId, message);
        }
    }
}
