package bootstrap.in.java.ui;

import bootstrap.in.java.ui.enums.BootstrapStyleEnum;

public class InputField extends GenericHtmlTag {

	private InputField(String tagName) {
		super(tagName);

	}

	@Override
	public String render() {
		addAttribute("value", getData());
		StringBuilder inputField = new StringBuilder(createOpeningTag());
		return inputField.toString().replace(">", "/>");
	}

	private static InputField createInputField(String bsNumber, String data) {
		InputField input = new InputField(INPUT);
		input.addCssClass(BootstrapStyleEnum.FORM_CONTROL);
		input.setBsColumnNumber(bsNumber);
		input.setData(data);
		return input;
	}

	public static InputField createInputSubmit(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "submit");
		return input;
	}

	public static InputField createInputDate(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "date");
		return input;
	}

	public static InputField createInputTime(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "time");
		return input;
	}

	public static InputField createInputWeek(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "week");
		return input;
	}

	public static InputField createColourInput(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "color");
		return input;
	}


	public static InputField createInputMonth(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "month");
		return input;
	}

	
	public static InputField createInputNumber(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "number");
		return input;
	}

	
	public static InputField createInputText(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "text");
		return input;
	}

	public static InputField createInputPassword(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "password");
		return input;
	}

	public static InputField createInputHidden(String bsNumber, String data) {
		InputField input = createInputField(bsNumber, data);
		input.addAttribute("type", "hidden");
		return input;
	}

}
