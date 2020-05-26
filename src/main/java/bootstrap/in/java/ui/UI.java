package bootstrap.in.java.ui;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public interface UI {

	final static String START_OPEN_TAG = "<";
	final static String START_CLOSE_TAG = "</";
	final static String END_TAG = " >";
	final static String END_OPEN_TAG = " />";
	final static String INPUT = "input";
	final static String DIV = "div";
	final static String SELECT = "select";
	final static String OPTION = "option";
	final static String TEXTAREA = "textarea";
	final static String BUTTON = "button";
	final static String LABEL = "label";
	final static String IMG = "img";
	final static String BR = "br";
	final static String I = "i";
	final static String H_5 = "h5";
	final static String A = "a";
	final static String P = "p";
	

	String render();

	String getId();

	void setId(String id);

	String getTagName();

	String getName();

	void setName(String name);

	void setTagName(String tagName);

	List<String> getCssClasses();

	void setCssClasses(List<String> cssClasses);

	List<String> getTagAttributes();

	void setTagAttributes(List<String> tagAttributes);

	String getColumnCss();

	void setColumnCss(String columnCss);

	default String getReadyCssClasses() {
		if (getCssClasses() == null || getCssClasses().isEmpty()) {
			return "";
		}
		StringBuilder cssClasses = new StringBuilder();
		getCssClasses().stream().forEach(cssClass -> cssClasses.append(" " + cssClass));
		return tagAttr("class", cssClasses.toString().trim());
	}

	default String createOpeningTag() {
		StringBuilder tag = new StringBuilder(START_OPEN_TAG + getTagName() + " ");
		tag.append(getReadyCssClasses());
		tag.append(getReadyTagAttributes());
		tag.append(END_TAG);
		return tag.toString();
	}

	default String tagAttr(String name, String value) {
		return " " + name + "='" + value + "' ";
	}

	default String createClosingTag() {
		return START_CLOSE_TAG + getTagName() + END_TAG;
	}

	default String getReadyTagAttributes() {
		boolean nameExist = getTagAttributes().stream().anyMatch(attribute -> attribute.trim().startsWith("name"));
		if (!nameExist) {
			addAttribute("name", getName());
		}
		getTagAttributes().add(tagAttr("id", getId()));
		StringBuilder attributes = new StringBuilder();
		getTagAttributes().stream().forEach(attribute -> attributes.append(" " + attribute));
		return attributes.toString().trim();
	}

	default UI addCssClass(String cssClass) {
		if (!getCssClasses().contains(cssClass)) {
			getCssClasses().add(cssClass);
		}
		return this;
	}

	default UI addAttribute(String name, String value) {
		String attr = tagAttr(name, value);
		if (!getTagAttributes().contains(attr)) {
			getTagAttributes().add(attr);
		}
		return this;
	}

	default Boolean containsAttributeName(String name) {
		return getTagAttributes().stream().anyMatch(attr -> attr.startsWith(name));
	}

	default void removeAttributeName(String name) {
		if (containsAttributeName(name)) {
			getTagAttributes().remove(name);
		}
	}

	default UI addPlaceHolderAttribute(String value) {
		return addAttribute("placeholder", value);
	}

	default UI addStyleAttribute(StyleEnum value, Boolean replace) {
		return addStyleAttribute(value.toString(), replace);
	}

	default UI addStyleAttribute(String value, Boolean replace) {
		if (!containsAttributeName("style")) {
			return addAttribute("style", value);
		}
		String originalStyle = getTagAttributes().stream().filter(attr -> attr.startsWith("style")).findFirst().get();
		originalStyle = originalStyle.replace("style=", "").trim();
		originalStyle = originalStyle.endsWith(";") ? originalStyle : originalStyle + "; ";
		removeAttributeName("style");
		if (replace) {
			return addAttribute("style", value);
		}
		return addAttribute("style", originalStyle + value.trim());
	}

	default UI addCssClasses(String... cssClasses) {
		for (String cssClass : cssClasses) {
			if (!getCssClasses().contains(cssClass)) {
				getCssClasses().add(cssClass);
			}
		}
		return this;
	}

	default UI addCssClass(StyleEnum cssClass) {
		if (!getCssClasses().contains(cssClass.toString())) {
			getCssClasses().add(cssClass.toString());
		}
		return this;
	}

	default UI addCssClasses(StyleEnum... cssClasses) {
		for (StyleEnum cssClass : cssClasses) {
			if (!getCssClasses().contains(cssClass.toString())) {
				getCssClasses().add(cssClass.toString());
			}
		}
		return this;
	}

	default String prettyHtml(String html) {

		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			StreamResult result = new StreamResult(new StringWriter());
			StreamSource source = new StreamSource(new StringReader(html));
			transformer.transform(source, result);
			html = result.getWriter().toString();
			html = html.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return html;
	}

	default String generateTagId() {
		String id = "";
		while (true) {
			String tempId = UUID.randomUUID().toString();
			try {
				Integer.parseInt("" + tempId.charAt(0));
			} catch (NumberFormatException ex) {
				id = tempId.replace("-", "");
				break;
			}
		}
		return id;
	}

}
