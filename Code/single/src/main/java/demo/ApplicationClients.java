package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
public class ApplicationClients {

    private final List<ApplicationClient> clients = new ArrayList<>();

    public List<ApplicationClient> getClients() {
        return this.clients;
    }

}
