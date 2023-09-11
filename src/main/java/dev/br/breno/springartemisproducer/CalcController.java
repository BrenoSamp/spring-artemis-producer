package dev.br.breno.springartemisproducer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.br.breno.springartemisproducer.Model.Calc;

@RestController
public class CalcController {

    @Autowired
    MessageService messageService;

    @PostMapping("/calc")
    public void send(@RequestBody Calc calc) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Crie um ObjectMapper para converter o JSON em um objeto Java
            String json = objectMapper.writeValueAsString(calc);
            messageService.send(json, "calc");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
