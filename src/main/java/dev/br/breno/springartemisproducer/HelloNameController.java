package dev.br.breno.springartemisproducer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import dev.br.breno.springartemisproducer.Model.HelloName;

@RestController
public class HelloNameController {

    @Autowired
    MessageService messageService;

    @PostMapping("/hello-name")
    public void send(@RequestBody HelloName helloName) {
        try {
            messageService.send(helloName.getName(), "hello-name");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
