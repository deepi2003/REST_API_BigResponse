package org.deepti.REST_API;

import com.google.common.io.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController
public class RESTAPIController {
    @GetMapping("/test")
    public String health() {
        return "Hello & Welcome!!!";
}

    @GetMapping("/100KB")
    public String get100_KBResponse() {
        return getFileContents("ResponseFile/Response.txt");
    }

    @GetMapping("/500KB")
    public String get500_KBResponse() {
        return getFileContents("ResponseFile/Response_1.txt");
    }

    @GetMapping("/1MB")
    public String get1MBResponse() {
        return getFileContents("ResponseFile/Response_2.txt");
    }

    @GetMapping("/5MB")
    public String get5_MBResponse() {
        return getFileContents("ResponseFile/Response_3.txt");
    }

    @GetMapping("/10MB")
    public String get10_MBResponse() {
        return getFileContents("ResponseFile/Response_4.txt");
    }

    private static String getFileContents(String resourceName) {
        URL url = Resources.getResource(resourceName);
        String res;
        try {
            res = Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


}
