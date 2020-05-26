package bootstrap.in.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreensService {

	@Autowired
	private FormScreenService formScreenService;
	@Autowired
	private ExpandableCardScreenService expandableCardScreenService;
	@Autowired
	private CardScreenService cardScreenService;

	public String formScreen() {
		return formScreenService.formScreen();
	}

	public String expandableCardScreen() {
		return expandableCardScreenService.expandableCard();
	}

	public String anotherExpandableCardScreen() {
		return expandableCardScreenService.anotherExpandableCard();
	}

	public String cardScreen() {
		return cardScreenService.cardScreen();
	}

}
