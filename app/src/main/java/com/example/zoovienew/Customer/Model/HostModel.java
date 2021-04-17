package com.example.zoovienew.Customer.Model;

public class HostModel {
    String hostName, HostAddress;

    public HostModel(String hostName, String hostAddress) {
        this.hostName = hostName;
        HostAddress = hostAddress;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostAddress() {
        return HostAddress;
    }

    public void setHostAddress(String hostAddress) {
        HostAddress = hostAddress;
    }
}
