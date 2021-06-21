package com.example.zoovienew.Customer.Model;

public class SearchLocationModel
{
    String loactionName;
    Boolean isSelected;

    public SearchLocationModel(String loactionName, Boolean isSelected) {
        this.loactionName = loactionName;
        this.isSelected = isSelected;
    }

    public String getLoactionName() {
        return loactionName;
    }

    public void setLoactionName(String loactionName) {
        this.loactionName = loactionName;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
