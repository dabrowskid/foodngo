package com.foodngo.fooservice.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @GetMapping("/all")
    public List<String> all() {
        return Arrays.asList("sth", "sth2");
    }


}
