package com.test.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.istack.internal.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** @Auther: zhouwenbin @Date: 2019/5/21 15:42 */
public class JsonUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
  private static JsonUtil instance = new JsonUtil();

  public static JsonUtil getInstance() {
    return instance;
  }

  private ObjectMapper mapper = new ObjectMapper();

  private JsonUtil() {
    mapper.registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    mapper
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
//            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .setVisibility(
                    mapper
                            .getVisibilityChecker()
                            .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                            .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                            .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                            .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE));
  }

  public @Nullable
  String toString(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      LOGGER.error(e.getMessage(), e);
      return null;
    }
  }

  public byte[] toBytes(Object o) {
    try {
      return mapper.writeValueAsBytes(o);
    } catch (JsonProcessingException e) {
      LOGGER.error(e.getMessage(), e);
      return null;
    }
  }

  public @Nullable <T> T toObject(byte[] bytes, Class<T> clazz) {
    try {
      return mapper.readValue(bytes, clazz);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
      return null;
    }
  }

  public @Nullable <T> T toObject(String str, Class<T> clazz) {
    try {
      return mapper.readValue(str, clazz);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
      return null;
    }
  }

  public <T> T toObject(String json, TypeReference<T> reference) {
    try {
      return mapper.readValue(json, reference);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
      return null;
    }
  }

  public <T> List<T> toList(String json, Class<T> clazz) {
    try {
      JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
      return mapper.readValue(json, javaType);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
      return null;
    }
  }
  /**
   * 消息传递的时候使用
   *
   * @param object
   * @return
   */
  public @Nullable String toStringSimple(Object object) {
    return toString(object);
  }

  public <T> T toObjectSimple(String str, Class<T> clazz) {
    return toObject(str, clazz);
  }

}
