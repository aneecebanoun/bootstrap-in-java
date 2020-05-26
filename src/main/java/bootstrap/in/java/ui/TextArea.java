package bootstrap.in.java.ui;

import bootstrap.in.java.ui.enums.BootstrapStyleEnum;

public class TextArea extends GenericHtmlTag {

	private TextArea() {
		super(UI.TEXTAREA);
	}
	
	public static TextArea createTextArea(String bsNumber, String data) {
		TextArea textArea = new TextArea();
		textArea.addCssClass(BootstrapStyleEnum.FORM_CONTROL);
		textArea.setBsColumnNumber(bsNumber);
		textArea.setData(data);
		return textArea;
	}

}
