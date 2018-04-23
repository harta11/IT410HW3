/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

/**
 *
 * @author gmuclass
 */
public class Credits {
        private String label;
        private String value;

    public Credits(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public Credits() {
        this.label = "";
        this.value = "";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Credits {" + "label=" + label + ", value=" + value + '}';
    }
    
}
