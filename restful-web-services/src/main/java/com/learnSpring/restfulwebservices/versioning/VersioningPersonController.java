package com.learnSpring.restfulwebservices.versioning;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/name")
    public PersonV1 getFirstVersion(){
        return new PersonV1("chirag");
    }

    @GetMapping("/v2/name")
    public PersonV2 getFirstVersion2(){
        return new PersonV2("chirag",15);
    }
    @GetMapping(value = "/name",params = "version=1")
    public PersonV2 getParamFirstVersion2(){
        return new PersonV2("chirag",15);
    }
    @GetMapping(value = "/name/headers",headers = "X-API-VERSION=1")
    public PersonV2 getHeaderFirstVersion2(){
        return new PersonV2("chirag",15);
    }
}
