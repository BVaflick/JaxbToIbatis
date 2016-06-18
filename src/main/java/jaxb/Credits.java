package jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Credits {

    ArrayList<Credit> credits;

    public ArrayList<Credit> getCredit() {
        return credits;
    }

    @XmlElement
    public void setCredit(ArrayList<Credit> credit) {
        this.credits = credit;
    }

    @Override
    public String toString() {
        return credits.toString();
    }
}
