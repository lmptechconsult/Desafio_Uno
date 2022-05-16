package com.previred.desafio.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

	@Value("${api.host.baseurl}")
	private String apiHost;
	@Value("${api.resource}")
	private String apiResource;
	@Value("${path.input.json}")
	private String pathInputJson;
	@Value("${path.output.json}")
	private String pathOutputJson;

	public String getPathInputJson() {
		return pathInputJson;
	}

	public void setPathInputJson(String pathInputJson) {
		this.pathInputJson = pathInputJson;
	}

	public String getPathOutputJson() {
		return pathOutputJson;
	}

	public void setPathOutputJson(String pathOutputJson) {
		this.pathOutputJson = pathOutputJson;
	}

	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

	public String getApiResource() {
		return apiResource;
	}

	public void setApiResource(String apiResource) {
		this.apiResource = apiResource;
	}

}
