package com.github.iodone.scapring.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.{ComponentScan, Configuration, EnableAspectJAutoProxy}
import org.springframework.scheduling.annotation.{EnableAsync, EnableScheduling}

/**
 * @ClassName SpringBootScalaIntegration
 * @Description SpringBoot启动类
 * @Version 1.0
 */

@ServletComponentScan
//@ComponentScan(basePackages = Array("com.github.iodone.scapring"))
@EnableScheduling
@EnableAspectJAutoProxy
@EnableAsync
@SpringBootApplication(exclude = Array(classOf[DataSourceAutoConfiguration]))
class SpringBootScalaIntegration extends SpringBootServletInitializer {

}

object SpringBootScalaIntegration extends App {
  SpringApplication.run(classOf[SpringBootScalaIntegration])
}
