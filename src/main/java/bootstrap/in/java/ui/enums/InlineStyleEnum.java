package bootstrap.in.java.ui.enums;

import bootstrap.in.java.ui.StyleEnum;

public enum InlineStyleEnum implements StyleEnum {

	ZERO_PADDING("padding: 0px;");

	private final String style;

	InlineStyleEnum(String style) {
		this.style = style;
	}

	public String toString() {
		return this.style;
	}

}
