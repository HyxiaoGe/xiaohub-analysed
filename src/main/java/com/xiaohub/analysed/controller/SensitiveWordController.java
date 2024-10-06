package com.xiaohub.analysed.controller;

import com.xiaohub.analysed.base.BaseResponse;
import com.xiaohub.analysed.service.SensitiveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/sensitive")
public class SensitiveWordController {

    @Autowired
    private SensitiveWordService sensitiveWordService;

    @PostMapping("/check-word-compliance")
    public BaseResponse checkWordCompliance(@RequestBody Object obj) {
        String prompt = ((LinkedHashMap<?, ?>) obj).get("prompt").toString();
        Boolean compliance = sensitiveWordService.checkWordCompliance(prompt);
        return new BaseResponse(compliance);
    }

}
