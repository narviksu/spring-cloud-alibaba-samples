package com.narvik.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

import java.io.StringWriter;
import java.util.List;

/**
 * @author narvik.su
 */
public class JsonUtils {
    //线程安全，可以单例
    private static ObjectMapper commonMapper;
    //带驼峰转换的mapper,尽管Jackson线程安全,但是为了方便配置暂时新起一个实例去做
    private static ObjectMapper camelMapper;

    static {
        commonMapper = new ObjectMapper();
        //忽略实体没定义的字段
        commonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        camelMapper = new ObjectMapper();
        //忽略实体没定义的字段
        camelMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //驼峰配置
        camelMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//        camelMapper.setPropertyNamingStrategy(new TargetLowerCamelCaseStrategy());
    }

    public static ObjectMapper getObjectMapper(boolean castCamel) {
        if (castCamel) {
            return camelMapper;
        } else {
            return commonMapper;
        }
    }

    /**
     * 创建一个{}
     */
    public static ObjectNode createJsonObject() {
        return commonMapper.createObjectNode();
    }

    /**
     * 创建[]
     */
    public static ArrayNode createJsonArray() {
        return commonMapper.createArrayNode();
    }

    /**
     * https://stackoverflow.com/questions/11828368/convert-java-object-to-jsonnode-in-jackson
     * 先转String再转JsonNode，如果需要转ObjectNode或者ArrayNode，外面自己强转
     * String类型看{@link #json2Bean(String, Class)}
     */
    public static JsonNode bean2JsonNode(Object obj) {
        try {
            if (obj instanceof String) {
                throw new IllegalAccessException("source must not be String");
            }
            String jsonStr = bean2Json(obj);
            return json2Bean(jsonStr, JsonNode.class);
        } catch (Exception e) {
            throw new RuntimeException("convert error", e);
        }
    }

    public static String bean2Json(Object obj) {
        return bean2Json(obj, false);
    }

    /**
     * String类型看{@link #json2Bean(String, Class)}
     */
    public static String bean2Json(Object obj, boolean castCamel) {
        try {
            if (obj instanceof String) {
                throw new IllegalAccessException("source must not be String");
            }
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createGenerator(sw);
            if (castCamel) {
                camelMapper.writeValue(gen, obj);
                gen.close();
            } else {
                commonMapper.writeValue(gen, obj);
                gen.close();
            }
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException("convert error", e);
        }
    }

    public static String bean2JsonForceCamel(Object obj) {
        return convertToLowerCameJson(JsonUtils.bean2Json(obj));
    }

    public static <T> T bean2Bean(Object obj, Class<T> objClass) {
        return json2Bean(bean2Json(obj), objClass, false);
    }

    public static <T> T bean2Bean(Object obj, Class<T> objClass, boolean castCamel) {
        return json2Bean(bean2Json(obj), objClass, castCamel);
    }

    public static <T> T bean2BeanForceCamel(Object obj, Class<T> objClass) {
        return json2Bean(convertToLowerCameJson(bean2Json(obj)), objClass);
    }

    public static <T> T bean2Bean(Object obj, TypeReference<T> valueTypeRef) {
        return json2Bean(bean2Json(obj), valueTypeRef, false);
    }

    public static <T> T bean2Bean(Object obj, TypeReference<T> valueTypeRef, boolean castCamel) {
        return json2Bean(bean2Json(obj), valueTypeRef, castCamel);
    }

    public static <T> T bean2BeanForceCamel(Object obj, TypeReference<T> valueTypeRef) {
        return json2Bean(convertToLowerCameJson(bean2Json(obj)), valueTypeRef, false);
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return json2Bean(jsonStr, objClass, false);
    }

    public static <T> T json2Bean(String jsonStr, TypeReference<T> valueTypeRef) {
        return json2Bean(jsonStr, valueTypeRef, false);
    }

    /**
     * 带泛型复杂类型转换
     */
    public static <T> T json2Bean(String jsonStr, TypeReference<T> valueTypeRef, boolean castCamel) {
        try {
            if (castCamel) {
                return camelMapper.readValue(jsonStr, valueTypeRef);
            } else {
                return commonMapper.readValue(jsonStr, valueTypeRef);
            }
        } catch (Exception e) {
            throw new RuntimeException("convert to TypeReference error", e);
        }
    }

    /**
     * 一般的转换
     */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass, boolean castCamel) {
        try {
            if (castCamel) {
                return camelMapper.readValue(jsonStr, objClass);
            } else {
                return commonMapper.readValue(jsonStr, objClass);
            }
        } catch (Exception e) {
            throw new RuntimeException("convert to Class error", e);
        }
    }

    public static class TargetLowerCamelCaseStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
        @Override
        public String translate(String input) {
            if (input == null) return input; // garbage in, garbage out
            int length = input.length();
            StringBuilder result = new StringBuilder(length);
            int resultLength = 0;
            boolean nextNeedUpper = false;
            for (int i = 0; i < length; i++) {
                char c = input.charAt(i);
                if (c != '_') {
                    if (nextNeedUpper) {
                        c = Character.toUpperCase(c);
                        nextNeedUpper = false;
                    }
                    resultLength++;
                    result.append(c);
                } else {
                    if (i != 0) {
                        nextNeedUpper = true;
                    }
                }
            }
            return resultLength > 0 ? result.toString() : input;
        }
    }


    public final static void convert(Object json) {
        if (json instanceof ArrayNode) {
            ArrayNode arr = (ArrayNode) json;
            for (Object obj : arr) {
                convert(obj);
            }
        } else if (json instanceof ObjectNode) {
            ObjectNode jo = (ObjectNode) json;
            List<String> keys = Lists.newArrayList(jo.fieldNames());
            //此处不能直接遍历keys，不然将报ConcurrentModificationException异常
            String[] array = keys.toArray(new String[keys.size()]);
            for (String key : array) {
                Object value = jo.get(key);
                if (key.startsWith("_")) {
                    convert(value);
                    continue;
                }
                String[] keyStrs = key.split("_");
                if (keyStrs.length > 1) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < keyStrs.length; i++) {
                        String ks = keyStrs[i];
                        if (!"".equals(ks)) {
                            if (i == 0) {
                                sb.append(ks);
                            } else {
                                int c = ks.charAt(0);
                                if (c >= 97 && c <= 122) {
                                    int v = c - 32;
                                    sb.append((char) v);
                                    if (ks.length() > 1) {
                                        sb.append(ks.substring(1));
                                    }
                                } else {
                                    sb.append(ks);
                                }
                            }
                        }
                        jo.remove(key);
                        jo.putPOJO(sb.toString(), value);
                    }
                    convert(value);
                }
            }
        }

    }


    public final static String convertToLowerCameJson(String json) {
        Object obj = JsonUtils.json2Bean(json, JsonNode.class);
        convert(obj);
        return JsonUtils.bean2Json(obj);
    }


}