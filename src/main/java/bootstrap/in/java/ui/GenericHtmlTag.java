package bootstrap.in.java.ui;

public class GenericHtmlTag extends UIAdaptor implements ColumnComponent {

	private String data;
	private String bsColumnNumber;

	public GenericHtmlTag(String tagName) {
		this.setTagName(tagName);
	}

	@Override
	public String render() {
		if (UI.BR.equals(getTagName())) {
			return START_OPEN_TAG + BR + END_OPEN_TAG;
		}
		StringBuilder htmlTag = new StringBuilder(createOpeningTag());
		if (data != null) {
			htmlTag.append(data);
		}
		htmlTag.append(createClosingTag());
		return htmlTag.toString();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String getBsColumnNumber() {
		return bsColumnNumber;
	}

	@Override
	public void setBsColumnNumber(String bsColumnNumber) {
		this.bsColumnNumber = bsColumnNumber;
	}
	
	@Override
	public ColumnComponent addCssClass(String cssClass) {
		return (ColumnComponent) super.addCssClass(cssClass);
	}

}
