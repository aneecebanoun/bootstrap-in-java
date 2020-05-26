package bootstrap.in.java.ui;

import java.util.ArrayList;
import java.util.List;

public abstract class UIAdaptor implements UI {

	private String tagName = "";
	private String id;
	private String name;
	private List<String> cssClasses = new ArrayList<>();
	private List<String> tagAttributes = new ArrayList<>();
	private String columnCss = "";

	public UIAdaptor() {
		this.id = generateTagId();
		this.name = id;

	}

	@Override
	public abstract String render();

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getTagName() {
		return tagName;
	}

	@Override
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public List<String> getCssClasses() {
		return cssClasses;
	}

	@Override
	public void setCssClasses(List<String> cssClasses) {
		this.cssClasses = cssClasses;
	}

	@Override
	public List<String> getTagAttributes() {
		return tagAttributes;
	}

	@Override
	public void setTagAttributes(List<String> tagAttributes) {
		this.tagAttributes = tagAttributes;
	}

	@Override
	public String getColumnCss() {
		return columnCss;
	}

	@Override
	public void setColumnCss(String columnCss) {
		this.columnCss = columnCss;
	}

	@Override
	public final String toString() {
		return render();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
