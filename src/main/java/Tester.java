import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import ibatis.CreditDao;
import ibatis.Creditable;
import jaxb.Credit;
import jaxb.Credits;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String[] args) {

        try {
            File inputFile = new File("testxml.xml");
            File outputFile = new File("outputxml.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Credits.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            Credits credits = (Credits) jaxbUnmarshaller.unmarshal(inputFile);
            Credits outputCredits = new Credits();
            ArrayList outputCreditsList = new ArrayList<Credit>();

            Creditable manager = new CreditDao();
            Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
            SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
            for(Credit credit : credits.getCredit()) {
                manager.addCredit(credit, sqlmapClient);
                Integer id = (Integer) sqlmapClient.queryForObject("credit.getMaxId");
                credit = manager.getCreditById(id, sqlmapClient);
                outputCreditsList.add(credit);
            }
            outputCredits.setCredit(outputCreditsList);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(outputCredits, outputFile);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
