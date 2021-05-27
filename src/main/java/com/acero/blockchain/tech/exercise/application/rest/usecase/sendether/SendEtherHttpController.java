package com.acero.blockchain.tech.exercise.application.rest.usecase.sendether;

import com.acero.blockchain.tech.exercise.domain.ports.primary.EtherService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eth")
@CrossOrigin(origins = "http://localhost:3000")
public class SendEtherHttpController implements SendEtherPort{

    @Autowired
    private EtherService etherService;

    @PostMapping(path = "/send", consumes = "application/json", produces = "application/json")
    @Override
    public String sendEther(@RequestBody SendInfo sendInfo)
    {
        Gson gson = new Gson();
        return gson.toJson(etherService.send(sendInfo));
    }

}
