package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SaveShortlistController {
    @PostMapping("path")
    public boolean SaveShortlist(@RequestBody shortlistEntity slEntity) {
        return slEntity.SaveShortlist();
    }
}
