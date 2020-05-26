package bootstrap.in.java.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bootstrap.in.java.services.FtlService;
import bootstrap.in.java.services.ScreensService;
import freemarker.template.TemplateException;

@Controller
public class BootstrapInJavaController {

	@Autowired
	private ScreensService screenSamplesService;
	@Autowired
	private FtlService ftlService;

	@GetMapping(value = "/card", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String card() throws IOException, URISyntaxException, TemplateException {
		Map<String, String> tempData = new HashMap<>();
		tempData.put("htmlBody", screenSamplesService.cardScreen());
		return ftlService.getTemplateHtml(tempData, "bsSamples.ftl");
	}

	@GetMapping(value = "/expandableCard", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String expandableCard() throws IOException, URISyntaxException, TemplateException {
		Map<String, String> tempData = new HashMap<>();
		tempData.put("htmlBody", screenSamplesService.expandableCardScreen());
		return ftlService.getTemplateHtml(tempData, "bsSamples.ftl");
	}

	@GetMapping(value = "/anotherExpandableCard", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String anotherexpandableCard() throws IOException, URISyntaxException, TemplateException {
		Map<String, String> tempData = new HashMap<>();
		tempData.put("htmlBody", screenSamplesService.anotherExpandableCardScreen());
		return ftlService.getTemplateHtml(tempData, "bsSamples.ftl");
	}

	@GetMapping(value = "/formScreen", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String formScreen() throws IOException, URISyntaxException, TemplateException {
		Map<String, String> tempData = new HashMap<>();
		tempData.put("htmlBody", screenSamplesService.formScreen());
		return ftlService.getTemplateHtml(tempData, "bsSamples.ftl");
	}

}
