package DBConnector.MySqlScripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class SiteDataInsert {

    Connection connection = null;

    public void insertDataToTable(Map<String, Object> siteData, String tableName) {

        String sqlQeryInser = "INSERT INTO "+tableName+" (announc_type, announc_group, announc_sub_group, announc_available, announc_date, announce_title, announce_price,announce_region, announce_owner, owner_on_site_from, owner_phone)\n" +
                "VALUES\n" +
                "    ('"+siteData.get("announceType")+"', '"+siteData.get("announcGroup")+"', '"+siteData.get("announcSubGroup")+"', '"+siteData.get("announce_available")+"',  '"+siteData.get("announcUpdeted")+"', '"+siteData.get("goodsTitle")+"','"+siteData.get("goodsPrice")+"',  '"+siteData.get("announcRegion")+"', '"+siteData.get("ownerName")+"',  '"+siteData.get("onSiteFrom")+"', '"+siteData.get("phoneNumber")+"'),\n" +
                ";";

        try{

            Statement statement = connection.createStatement();
            statement.executeQuery(sqlQeryInser);

            System.out.println("========== Entry added ============");

            statement.close();
            connection.close();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
