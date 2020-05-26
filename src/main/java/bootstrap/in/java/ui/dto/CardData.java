package bootstrap.in.java.ui.dto;

public class CardData {

	private String img;
	private String title;
	private String text;
	private String buttonText;
	private String width;

	public CardData(String img, String title, String text, String buttonText, String width) {
		super();
		this.img = img;
		this.title = title;
		this.text = text;
		this.buttonText = buttonText;
		this.width = width;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

}
