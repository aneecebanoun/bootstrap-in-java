package bootstrap.in.java.services;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class FtlService {

	@Autowired
	private Configuration ftlConfiguration;

	public String getTemplateHtml(Object model, String templateFile)
			throws IOException, URISyntaxException, TemplateException {
		StringWriter testWriter = new StringWriter();
		Template template = ftlConfiguration.getTemplate(templateFile);
		template.process(model, testWriter);
		return testWriter.toString();
	}
}