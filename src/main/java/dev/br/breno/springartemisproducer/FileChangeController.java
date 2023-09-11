package dev.br.breno.springartemisproducer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileChangeController {

    @Autowired
    MessageService messageService;

    @PostMapping("/file-change")
    public void send(@RequestParam MultipartFile file) {
        try {
            byte[] fileContent = file.getBytes();

            messageService.send(new String(fileContent), "file-change");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
