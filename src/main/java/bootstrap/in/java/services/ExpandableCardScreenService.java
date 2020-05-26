package bootstrap.in.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootstrap.in.java.ui.Container;
import bootstrap.in.java.ui.GenericHtmlTag;
import bootstrap.in.java.ui.Row;
import bootstrap.in.java.ui.StyleEnum;
import bootstrap.in.java.ui.UI;
import bootstrap.in.java.ui.dto.CardData;
import bootstrap.in.java.ui.enums.BootstrapStyleEnum;
import bootstrap.in.java.ui.enums.CustomStyleEnum;

@Service
public class ExpandableCardScreenService {

	@Autowired
	private CardScreenService cardScreenService;

	public String expandableCard() {
		Container card = new Container();
		card.setFluid(false);
		card.addCssClasses(BootstrapStyleEnum.WHITE_BORDER, CustomStyleEnum.CARD_STYLE);
		Container expandableContainer = createExpandableContainer(card.getId());
		Container headerContainer = createHeaderContainer(expandableContainer.getId());
		card.getInnerContainer().add(headerContainer);
		card.getInnerContainer().add(expandableContainer);
		return card.prettyHtml(card.render());
	}

	public String anotherExpandableCard() {
		Container card = new Container();
		card.setFluid(false);
		card.addCssClasses(BootstrapStyleEnum.WHITE_BORDER, CustomStyleEnum.CARD_STYLE);
		CardData readyCardData = cardScreenService.getReadyCardData();
		readyCardData.setWidth("");
		cardScreenService.setCardData(readyCardData);
		Container expandableContainer = cardScreenService.getCard();
		expandableContainer.setFluid(false);
		expandableContainer.addCssClasses(getExpandableRootCssClasses());
		expandableContainer.addAttribute("data-parent", "#" + card.getId());
		Container headerContainer = createHeaderContainer(expandableContainer.getId());
		card.getInnerContainer().add(headerContainer);
		card.getInnerContainer().add(expandableContainer);
		return card.prettyHtml(card.render());
	}

	private Container createHeaderContainer(String expandableContainerId) {
		Container headerContainer = new Container();
		headerContainer.addCssClasses(BootstrapStyleEnum.WHITE_BACKGROUND, BootstrapStyleEnum.MUTED_BORDER);
		Row cardRow = new Row();
		headerContainer.addRow(cardRow);
		cardRow.addColumnComponent(getHeaderImageContainer());
		cardRow.addColumnComponent(getMidHeader());
		cardRow.addColumnComponent(getExpandableButtonContainer(expandableContainerId));
		return headerContainer;

	}

	private Container getMidHeader() {
		Container midHeader = new Container();
		midHeader.setBsColumnNumber("7");
		GenericHtmlTag br = new GenericHtmlTag(UI.BR);
		midHeader.getNonGridTags().add(br);
		GenericHtmlTag midHeaderTop = getMidHeaderTop();
		midHeader.getNonGridTags().add(midHeaderTop);
		midHeader.getNonGridTags().add(br);
		GenericHtmlTag midHeaderBottom = getMidHeaderBottom();
		midHeader.getNonGridTags().add(midHeaderBottom);
		return midHeader;
	}

	private GenericHtmlTag getMidHeaderBottom() {
		GenericHtmlTag span2 = new GenericHtmlTag("span");
		span2.setData("Littlehampton");
		span2.addCssClass(CustomStyleEnum.MID_HEADER_FONT_BOTTOM);
		return span2;
	}

	private GenericHtmlTag getMidHeaderTop() {
		GenericHtmlTag span1 = new GenericHtmlTag("span");
		span1.setData("*****");
		span1.addCssClass(CustomStyleEnum.MID_HEADER_FONT_TOP);
		return span1;
	}

	private Container getHeaderImageContainer() {
		Container headerImageContainer = new Container();
		headerImageContainer.setBsColumnNumber("3");
		headerImageContainer.addCssClasses(getMidCenterStyle());
		headerImageContainer.addCssClass(BootstrapStyleEnum.WHITE_BORDER);
		GenericHtmlTag img = new GenericHtmlTag(UI.IMG);
		img.addAttribute("src", "littlehampton-east-beach.jpg");
		img.addStyleAttribute("object-fit: cover; max-width:100%; max-height:100%;", true);
		headerImageContainer.getNonGridTags().add(img);
		return headerImageContainer;
	}

	private Container getExpandableButtonContainer(String expandableContainerId) {
		Container crCol3 = new Container();
		crCol3.addCssClasses(getMidCenterStyle());
		crCol3.setBsColumnNumber("2");
		Container button = new Container();
		crCol3.getInnerContainer().add(button);
		button.addCssClasses(getButtonStyle());
		button.addAttribute("data-toggle", "collapse");
		button.addAttribute("href", "#" + expandableContainerId);
		GenericHtmlTag icon = new GenericHtmlTag(UI.DIV);
		icon.addCssClasses(getButtonIconStyle());
		icon.setData("&#xf0de;");
		button.getNonGridTags().add(icon);
		return crCol3;
	}

	private StyleEnum[] getButtonIconStyle() {
		return new StyleEnum[] { CustomStyleEnum.FA, CustomStyleEnum.CIRCLE_BUTTON_ICON,
				CustomStyleEnum.CENTER_DIV_TEXT, BootstrapStyleEnum.D_FLEX, BootstrapStyleEnum.JUSTIFY_CONTENT_CENTER,
				BootstrapStyleEnum.ALIGN_ITEMS_CENTER };
	}

	private StyleEnum[] getMidCenterStyle() {
		return new StyleEnum[] { BootstrapStyleEnum.H_100, BootstrapStyleEnum.W_100, BootstrapStyleEnum.D_FLEX,
				BootstrapStyleEnum.JUSTIFY_CONTENT_CENTER, BootstrapStyleEnum.ALIGN_ITEMS_CENTER,
				BootstrapStyleEnum.MUTED_BORDER, BootstrapStyleEnum.BORDER_LEFT };
	}

	private StyleEnum[] getButtonStyle() {
		return new StyleEnum[] { CustomStyleEnum.CIRCLE_BUTTON, BootstrapStyleEnum.TEXT_DARK, BootstrapStyleEnum.D_FLEX,
				BootstrapStyleEnum.JUSTIFY_CONTENT_CENTER, BootstrapStyleEnum.ALIGN_ITEMS_CENTER };
	}

	private Container createExpandableContainer(String parentId) {

		Container expandableRoot = getExpandableRootContainer(parentId);

		Container innerCollapse = new Container();
		expandableRoot.getInnerContainer().add(innerCollapse);

		Container topRowContainer = new Container();
		topRowContainer.setBsColumnNumber("12");

		innerCollapse.addCssClasses(BootstrapStyleEnum.CARD_BODY, CustomStyleEnum.CARD_STYLE);
		Row topRowRow1 = new Row();
		GenericHtmlTag row1Col1 = new GenericHtmlTag(UI.DIV);
		row1Col1.setBsColumnNumber("2");
		row1Col1.setData(getMapIcon().render());
		GenericHtmlTag row1Col2 = new GenericHtmlTag(UI.DIV);
		row1Col2.setBsColumnNumber("10");
		row1Col2.setData(getTopText().render());
		topRowRow1.addColumnComponent(row1Col1);
		topRowRow1.addColumnComponent(row1Col2);
		topRowContainer.addRow(topRowRow1);

		Row topRow = new Row();

		topRow.addColumnComponent(topRowContainer);
		innerCollapse.addRow(topRow);

		Row topRowRow2 = new Row();

		topRowContainer.addRow(topRowRow2);

		GenericHtmlTag row2Col1 = new GenericHtmlTag(UI.DIV);
		row2Col1.setBsColumnNumber("2");
		row2Col1.setData(" ");
		topRowRow2.addColumnComponent(row2Col1);

		GenericHtmlTag row2Col2 = new GenericHtmlTag(UI.DIV);
		row2Col2.setBsColumnNumber("10");
		row2Col2.setData(getBottomText().render());
		topRowRow2.addColumnComponent(row2Col2);

		Row buttonRow = new Row();
		innerCollapse.addRow(buttonRow);
		Container buttonRowContainer = new Container();
		buttonRowContainer.addCssClass(CustomStyleEnum.CARD_BODY_BUTTON_CONTAINER);
		buttonRowContainer.setBsColumnNumber("12");
		buttonRow.addColumnComponent(buttonRowContainer);

		buttonRowContainer.getNonGridTags().add(getExpandableButton());

		return expandableRoot;
	}

	private StyleEnum[] getExpandableRootCssClasses() {
		return new StyleEnum[] { BootstrapStyleEnum.WHITE_BACKGROUND, BootstrapStyleEnum.MUTED_BORDER,
				CustomStyleEnum.COLLAPSE, CustomStyleEnum.CARD_STYLE };
	}

	private Container getExpandableRootContainer(String parentId) {
		Container expandableRoot = new Container();
		expandableRoot.addCssClasses(getExpandableRootCssClasses());
		expandableRoot.addAttribute("data-parent", "#" + parentId);
		return expandableRoot;
	}

	private GenericHtmlTag getExpandableButton() {
		GenericHtmlTag cardBodyButtonContainer = new GenericHtmlTag(UI.BUTTON);
		cardBodyButtonContainer.addCssClasses(BootstrapStyleEnum.LARGE_BUTTON, CustomStyleEnum.CARD_BODY_BUTTON);
		cardBodyButtonContainer.addAttribute("type", "button");
		cardBodyButtonContainer.setData(getButtonSpan().render());
		return cardBodyButtonContainer;
	}

	private GenericHtmlTag getButtonSpan() {
		GenericHtmlTag cardBodyButtonContainerSpan = new GenericHtmlTag("span");
		cardBodyButtonContainerSpan.addCssClass(CustomStyleEnum.CARD_BUTTON_FONT);
		cardBodyButtonContainerSpan.setData("SELECT THIS CARD");
		return cardBodyButtonContainerSpan;
	}

	private GenericHtmlTag getBottomText() {
		GenericHtmlTag row2Col2Span = new GenericHtmlTag("span");
		row2Col2Span.setData("LITTLE-HAMPTON");
		row2Col2Span.addCssClass(CustomStyleEnum.CARD_BODY_FONT_BOTTOM);
		return row2Col2Span;
	}

	private GenericHtmlTag getTopText() {
		GenericHtmlTag row1Col2Span = new GenericHtmlTag("span");
		row1Col2Span.addCssClass(CustomStyleEnum.CARD_BODY_FONT_TOP);
		row1Col2Span.setData("LOCATION");
		return row1Col2Span;
	}

	private GenericHtmlTag getMapIcon() {
		GenericHtmlTag mapIcon = new GenericHtmlTag(UI.I);
		mapIcon.addCssClasses(CustomStyleEnum.MATERIAL_ICONS, CustomStyleEnum.MAP_ICON_FONT_SIZE);
		mapIcon.setData("&#xe55f;");
		return mapIcon;
	}

}
