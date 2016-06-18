package ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import jaxb.Credit;

public interface Creditable {

    Credit addCredit(Credit credit, SqlMapClient sqlmapClient);

    Credit getCreditById(Integer id, SqlMapClient sqlmapClient);

    void deleteCreditById(Integer id, SqlMapClient sqlmapClient);
}

