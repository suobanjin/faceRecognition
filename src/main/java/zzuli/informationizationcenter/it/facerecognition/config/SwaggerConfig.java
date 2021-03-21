package zzuli.informationizationcenter.it.facerecognition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author 哆啦是只小猫咪
 * @Date 2021/3/21 20:31
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nvn.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("人脸识别后台接口说明")
                        .description("前后端交互说明")
                        .version("1.0")
                        .contact(new Contact("郑州轻工业大学信息化管理中心IT创新工作室","http://ic.zzuli.edu.cn/8877/list.htm",""))
                        .license("The Apache License")
                        .licenseUrl("https://www.apache.org/licenses/")
                        .build());
    }
}
