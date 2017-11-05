package com.foodngo.fooservice.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller("/product")
public class ProductsController {

    @GetMapping("/all")
    public List<String> all() {
        return Arrays.asList("sth", "sth2");
    }



}
