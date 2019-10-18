package models;

import java.util.HashSet;
import java.util.Set;

public class Singltone {

    private Set<String> setId;

    private Singltone() {
        setId = new HashSet<String>();
    }

    private static class SingltoneSetHolder {
        private final static Singltone instance = new Singltone();
    }

    public static Singltone getInstance () {
        return SingltoneSetHolder.instance;
    }

    public void addSessionId (String sessionId) {
        setId.add(sessionId);
    }

    public boolean containsSessionId (String sessionId) {
        return setId.contains(sessionId);
    }
}