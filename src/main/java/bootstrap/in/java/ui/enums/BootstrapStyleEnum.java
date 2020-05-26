package bootstrap.in.java.ui.enums;

import bootstrap.in.java.ui.StyleEnum;

public enum BootstrapStyleEnum implements StyleEnum {

	FORM_CONTROL("form-control"),
	PRIMARY_BORDER("border border-primary"), 
	SECONDARY_BORDER("border border-secondary"),
	WHITE_BORDER("border border-white"), 
	MUTED_BORDER("border border-muted"),
	BORDER_LEFT("border-left"),
	H_100("h-100"),
	W_100("w-100"),
	D_FLEX("d-flex"),
	FLEX_FILL("flex-fill"),
	JUSTIFY_CONTENT_CENTER("justify-content-center"),
	ALIGN_ITEMS_CENTER("align-items-center"),
	TEXT_DARK("text-dark"),
	CARD_BODY("card-body"), 
	CARD_TITLE("card-title"),
	CARD_TEXT("card-text"),
	WHITE_BACKGROUND("bg-white"),
	CARD("card"),
	CARD_IMG_TOP("card-img-top"),
	LARGE_BUTTON("btn btn-lg"),
	PRIMARY_BUTTON("btn btn-primary");
	

	private final String style;

	BootstrapStyleEnum(String style) {
		this.style = style;
	}

	public String toString() {
		return this.style;
	}

}
