package dev.br.breno.springartemisproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${spring.artemis.broker-url}")
    private String brokerUrl;

    @Value("${spring.artemis.user}")
    private String artemisUser;

    @Value("${spring.artemis.password}")
    private String artemisPassword;

    @GetMapping("/config")
    public String getConfig() {
        return "Broker URL: " + brokerUrl + "\nArtemis User: " + artemisUser + "\nArtemis Password: " + artemisPassword;
    }
}