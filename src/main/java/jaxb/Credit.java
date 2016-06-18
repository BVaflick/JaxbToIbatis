package jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Credit {

    String name;
    String maxAmount;
    String term;
    String rate;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    @XmlElement
    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getTerm() {
        return term;
    }

    @XmlElement
    public void setTerm(String term) {
        this.term = term;
    }

    public String getRate() {
        return rate;
    }

    @XmlElement
    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Credit[" +
                "name='" + name + '\'' +
                ", maxAmount='" + maxAmount + '\'' +
                ", term='" + term + '\'' +
                ", rate='" + rate + '\'' +
                "]";
    }
}
