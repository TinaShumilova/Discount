package org.example;

public class Client {
    private boolean statusVIP;

    public Client(boolean statusVIP){
        this.statusVIP=statusVIP;
    }

    public Client(){
        this.statusVIP=false;
    }

    public void setStatusVIP(boolean statusVIP) {
        this.statusVIP = statusVIP;
    }

    public boolean getStatusVIP(){
        return statusVIP;
    }
}
