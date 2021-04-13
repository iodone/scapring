package com.github.iodone.scapring.app.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.{ByteArrayHttpMessageConverter, HttpMessageConverter}
import org.springframework.http.{HttpHeaders, MediaType}
import org.springframework.web.servlet.config.annotation.{ContentNegotiationConfigurer, CorsRegistry, DefaultServletHandlerConfigurer, WebMvcConfigurationSupport}

@Configuration
class WebMvcConfig extends WebMvcConfigurationSupport{

  override def configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer): Unit = {
    configurer.enable()
  }

  override def configureContentNegotiation(configurer: ContentNegotiationConfigurer): Unit = {
    configurer.mediaType("json", MediaType.APPLICATION_JSON)
  }

  override def addCorsMappings(registry: CorsRegistry): Unit = {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedHeaders("*")
      .allowedMethods("*")
      .allowCredentials(true)
      .exposedHeaders(HttpHeaders.SET_COOKIE)
  }

  override def configureMessageConverters(converters: java.util.List[HttpMessageConverter[_]]): Unit = { //添加二进制流导出转换
    converters.add(new ByteArrayHttpMessageConverter)
    //json 字符串转scala case class
    converters.add(new MappingJackson2HttpMessageConverter(ObjectMapper.instance))
    // 新增 x-www-form-urlencoded 消息转换器
//    converters.add(new FormMappingJackson2HttpMessageConverter)
  }
}

object ObjectMapper {
  val instance = new ObjectMapper()
  instance.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
  instance.registerModule(new DefaultScalaModule)
  instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
}



