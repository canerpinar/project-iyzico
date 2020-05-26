package com.projectiyzico.entity;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;


public class DigestHelp {
    private DigestHelp() {
    }

    public static String decodeString(String content) {
        return StringUtils.isNotBlank(content) ? new String(Base64.decodeBase64(content)) : null;
    }
}
