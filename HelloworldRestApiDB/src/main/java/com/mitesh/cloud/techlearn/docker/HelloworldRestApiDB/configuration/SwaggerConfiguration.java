package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact DEFAULT_CONTACT=new Contact("Mitesh Upadhyay", 
															"www.mitesh.com",
															"miteshupadhyay@gmail.com");
	
	
	public static final ApiInfo viApiInfo=new ApiInfo
								("My API Info", "My API Info",
								"1.0", "termsOfServiceUrl", 
								DEFAULT_CONTACT, "license", "licenseUrl");


	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES=
					new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	private ApiInfo apiInfoV1() {
		return new ApiInfoBuilder()
				.title("My API Info")
				.description("This is the sample API")
				.termsOfServiceUrl("www.miteshupadhyay.com")
				.version("v1")
				.build();
	}
	
	
	@Bean
	public Docket apiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V1")
				.select()
                .apis(RequestHandlerSelectors.basePackage("com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.controller"))
                .paths(PathSelectors.any())
                .build()
				.apiInfo(apiInfoV1())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages());		
		
	}
	
	@Bean
	public Docket apiV2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V2")
				.select()
                .apis(RequestHandlerSelectors.basePackage("com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.controller"))
                .paths(PathSelectors.any())
                .build()
				.apiInfo(viApiInfo)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages());		
		
	}
	
	
	private List<ResponseMessage> getCustomizedResponseMessages(){
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(500).message("Server has crashed!!").responseModel(new ModelRef("Error")).build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("You shall not pass!!").build());
        return responseMessages;
    }
	
}
