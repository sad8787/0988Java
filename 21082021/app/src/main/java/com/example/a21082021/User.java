package com.example.a21082021;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String name;
    private String lastname;
    private String fonNumber;
    private UUID uuid;

    public User(UUID uuid ){
        this.uuid=uuid;
    }
    public User(){
        uuid=UUID.randomUUID();
    }

    public String getFonNomer() {
        return fonNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setFonNumber(String fonNumber) {
        this.fonNumber = fonNumber;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

}
