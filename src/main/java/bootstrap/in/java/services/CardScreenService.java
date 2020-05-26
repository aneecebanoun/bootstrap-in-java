package bootstrap.in.java.services;

import org.springframework.stereotype.Service;

import bootstrap.in.java.ui.Container;
import bootstrap.in.java.ui.GenericHtmlTag;
import bootstrap.in.java.ui.UI;
import bootstrap.in.java.ui.dto.CardData;
import bootstrap.in.java.ui.enums.BootstrapStyleEnum;

@Service
public class CardScreenService {

	private static final String CARD_IMG = "Littlehampton_Harbour,_West_Sussex.jpg";
	private static final String CARD_TITLE = "LittleHampton";
	private static final String CARD_TEXT = "Littlehampton is a town, seaside resort and pleasure harbour, and the most populous civil parish in the Arun District of West Sussex, England.";
	private static final String CARD_BUTTON_TEXT = "VISIT LITTLEHAMPTON";
	private static final String CARD_ROOT = "width: 25rem;";

	private CardData cardData;

	public String cardScreen() {
		cardData = getReadyCardData();
		GenericHtmlTag br = new GenericHtmlTag(UI.BR);
		GenericHtmlTag root = new GenericHtmlTag(UI.DIV);
		root.setData(br.render() + getCard().render());
		return root.prettyHtml(root.render());
	}

	public Container getCard() {
		Container card = new Container();
		card.addCssClass(BootstrapStyleEnum.CARD);
		card.addStyleAttribute(cardData.getWidth(), true);
		card.getNonGridTags().add(getCardCapImage());
		card.getNonGridTags().add(getCardBodyTag());
		return card;
	}

	public CardData getReadyCardData() {
		return new CardData(CARD_IMG, CARD_TITLE, CARD_TEXT, CARD_BUTTON_TEXT, CARD_ROOT);
	}

	private Container getCardBodyTag() {
		Container cardBody = new Container();
		cardBody.addCssClass(BootstrapStyleEnum.CARD_BODY);
		cardBody.getNonGridTags().add(getCardTitleTag());
		cardBody.getNonGridTags().add(getCardTextTag());
		cardBody.getNonGridTags().add(getCardButtonTag());
		return cardBody;
	}

	private GenericHtmlTag getCardButtonTag() {
		GenericHtmlTag cardButton = new GenericHtmlTag(UI.A);
		cardButton.addCssClass(BootstrapStyleEnum.PRIMARY_BUTTON);
		cardButton.addAttribute("href", "#");
		cardButton.setData(cardData.getButtonText());
		return cardButton;
	}

	private GenericHtmlTag getCardTextTag() {
		GenericHtmlTag cardText = new GenericHtmlTag(UI.P);
		cardText.addCssClass(BootstrapStyleEnum.CARD_TEXT);
		cardText.setData(cardData.getText());
		return cardText;
	}

	private GenericHtmlTag getCardTitleTag() {
		GenericHtmlTag title = new GenericHtmlTag(UI.H_5);
		title.addCssClass(BootstrapStyleEnum.CARD_TITLE);
		title.setData(cardData.getTitle());
		return title;
	}

	private GenericHtmlTag getCardCapImage() {
		GenericHtmlTag img = new GenericHtmlTag(UI.IMG);
		img.addCssClass(BootstrapStyleEnum.CARD_IMG_TOP);
		img.addAttribute("src", cardData.getImg());
		img.addAttribute("alt", "Card image cap");
		return img;
	}

	public CardData getCardData() {
		return cardData;
	}

	public void setCardData(CardData cardData) {
		this.cardData = cardData;
	}

}
