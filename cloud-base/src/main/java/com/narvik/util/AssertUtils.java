package com.narvik.util;

import com.narvik.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * @author narvik.su
 */
public class AssertUtils {

    public static void asserts(final String message) {
        throw new BizException(message);
    }

    public static void asserts(Integer code, final String message) {
        throw new BizException(code, message);
    }

    public static void checkTrue(final boolean expression, final String message) {
        if (expression) {
            throw new BizException(message);
        }
    }

    public static void checkFalse(final boolean expression, final String message) {
        if (!expression) {
            throw new BizException(message);
        }
    }

    public static void notNull(final Object object, final String message) {
        if (object == null) {
            throw new BizException(message);
        }
    }

    public static void notEmpty(final Collection collection, final String message) {
        if (collection == null || collection.size() == 0) {
            throw new BizException(message);
        }
    }

    public static void notEmpty(final CharSequence s, final String message) {
        if (StringUtils.isEmpty(s)) {
            throw new BizException(message);
        }
    }

    public static void notBlank(final CharSequence s, final String message) {
        if (StringUtils.isBlank(s)) {
            throw new BizException(message);
        }
    }

}