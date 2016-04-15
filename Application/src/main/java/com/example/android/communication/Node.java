package com.example.android.communication;

import java.util.Set;

public interface Node {
    void disconnect(String id);
    void connect(String id);
    void send(String sourceId, Set<String> forwardedBy, String destinationId, byte[] message);
    void receive(String sourceId, Set<String> forwardedBy, String destinationId, byte[] message);
}
