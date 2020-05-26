package bootstrap.in.java.ui.enums;

import bootstrap.in.java.ui.StyleEnum;

public enum CustomStyleEnum implements StyleEnum {

	CARD_STYLE("cardStyle"), 
	CARD_BODY_BUTTON("cardBodyButton"), 
	CARD_BODY_BUTTON_CONTAINER("cardBodyButtonContainer"),
	COLLAPSE("collapse"), 
	CARD_BUTTON_FONT("cardButtonFont"), 
	CARD_BODY_FONT_BOTTOM("cardBodyFontBottom"),
	CARD_BODY_FONT_TOP("cardBodyFontTop"),
	MATERIAL_ICONS("material-icons"),
	MAP_ICON_FONT_SIZE("mapIconFont"),
	MID_HEADER_FONT_TOP("midHeaderFontTop"),
	MID_HEADER_FONT_BOTTOM("midHeaderFontBottom"),
	CIRCLE_BUTTON("circleButton"),
	CIRCLE_BUTTON_ICON("circleButtonIcon"),
	CENTER_DIV_TEXT("centerDivText"),
	FA("fa");
	private final String style;

	CustomStyleEnum(String style) {
		this.style = style;
	}

	public String toString() {
		return style;
	}
}
