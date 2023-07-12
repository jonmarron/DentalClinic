package com.jontxu.DentalClinic.data;

public class Patient {
    private final int id;
    private final String name;
    private boolean isLoyal = false;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isLoyal() {
        return isLoyal;
    }

    public void setLoyal(boolean loyal) {
        isLoyal = loyal;
    }
}
