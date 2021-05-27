package com.acero.blockchain.tech.exercise.application.rest.usecase.obtainbalance;

import com.acero.blockchain.tech.exercise.domain.ports.primary.EtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eth")
@CrossOrigin(origins = "http://localhost:3000")
public class ObtainBalanceHttpController implements ObtainEthBalancePort {

    @Autowired
    EtherService etherService;

    @GetMapping(path = "/balance", consumes = "application/json", produces = "application/json")
    @Override
    public ObtainBalanceResponseModel obtainBalance(@RequestParam String account) {
        return new ObtainBalanceResponseModel(etherService.obtainEthBalance(account));
    }
}
