package com.xiaohub.analysed.service;

import com.xiaohub.analysed.util.SensitiveWordUtil;
import org.springframework.stereotype.Service;

@Service
public class SensitiveWordService {

    public Boolean checkWordCompliance(String word) {
        return SensitiveWordUtil.isSensitiveWord(word);
    }

}
