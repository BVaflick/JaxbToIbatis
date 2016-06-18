package ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import jaxb.Credit;

public class CreditDao implements Creditable {

    public Credit addCredit(Credit credit, SqlMapClient sqlmapClient) {
        try {
            Integer id = (Integer) sqlmapClient.queryForObject("credit.getMaxId");
            id = id == null ? 1 : id + 1;
            sqlmapClient.insert("credit.addCredit", credit);
            credit = getCreditById(id, sqlmapClient);
            return credit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Credit getCreditById(Integer id, SqlMapClient sqlmapClient) {
        try {
            Credit credit = (Credit) sqlmapClient.queryForObject("credit.getCreditById", id);
            return credit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCreditById(Integer id, SqlMapClient sqlmapClient) {
        try {
            sqlmapClient.delete("credit.deleteCreditById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
