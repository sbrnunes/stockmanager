package org.snmco.stock.stockhandler.util;

import org.springframework.validation.MessageCodesResolver;


public class CustomMessageCodeResolver implements MessageCodesResolver {
    @Override
    public String[] resolveMessageCodes(String errorCode, String objectName) {
        return new String[]{errorCode, objectName};
    }

    @Override
    public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class<?> fieldType) {
        return new String[]{errorCode, objectName};
    }
}
