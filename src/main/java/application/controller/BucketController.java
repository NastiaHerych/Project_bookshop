package application.controller;

import application.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BucketController {

    @Autowired
    BucketService bucketService;

}
