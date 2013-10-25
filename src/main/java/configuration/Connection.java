package configuration;

/**
 * User: Mariola
 * Date: 25.10.13
 */
public class Connection {
    private String connectionUrl;

    public Connection(String connectionUrl){
         this.connectionUrl = connectionUrl;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
