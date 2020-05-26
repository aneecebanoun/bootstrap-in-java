package bootstrap.in.java.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import bootstrap.in.java.ui.Container;
import bootstrap.in.java.ui.GenericHtmlTag;
import bootstrap.in.java.ui.InputField;
import bootstrap.in.java.ui.Row;
import bootstrap.in.java.ui.Select;
import bootstrap.in.java.ui.TextArea;
import bootstrap.in.java.ui.UI;
import bootstrap.in.java.ui.enums.BootstrapStyleEnum;

@Service
public class FormScreenService {
	private static final String WHITE_BG_RIGHT_ALIGNED_LABEL = "background-color: white; text-align: right;";
	private static final String FORM_FOOTER_CELL = "background-color: rgba(69, 85, 232, 0.42); height: 5em; width:100%";
	private static final String FORM_FOOTER = "background-color: rgba(69, 85, 232, 0.42); height: 5em;";
	private static final String FORM_BODY_CENTER_REGION = "background-color: white; height: 40em; width:100%";
	private static final String FORM_BODY = "background-color: rgba(69, 85, 232, 0.42); height: 40em;";
	private static final String FORM_ROOT = "height: 50em;";
	private static final String FORM_HEADER = "background-color: rgba(0, 12, 31, 0.62); height: 5em;";
	private static final String FORM_HEADER_CELL = "background-color: rgba(0, 12, 31, 0.62); height: 5em;";

	public String formScreen() {
		Container container = new Container();
		container.setFluid(true);
		container.addStyleAttribute(FORM_ROOT, true);
		container.addRow(getHeader());
		container.addRow(getBody());
		container.addRow(getFooter());
		String htmlContent = container.render();
		return container.prettyHtml(htmlContent);
	}

	private Row getBody() {
		Row body = new Row();
		body.addStyleAttribute(FORM_BODY, true);
		body.addColumnComponent(getBodyEastRegion());
		body.addColumnComponent(getBodyCenterRegion());
		body.addColumnComponent(getBodyWestRegion());
		return body;
	}

	private GenericHtmlTag getBodyCenterRegion() {
		GenericHtmlTag centerCell = new GenericHtmlTag(UI.DIV);
		centerCell.addStyleAttribute(FORM_BODY_CENTER_REGION, true);
		centerCell.setData(getFormContainer().render());
		centerCell.setBsColumnNumber("10");
		return centerCell;
	}

	private Container getFormContainer() {
		Container container = new Container();
		container.setFluid(true);
		container.addRow(getRowSeperator());
		container.addRow(getRowSeperator());
		container.addRow(getRowSeperator());
		container.addRow(getRowColorSeperator());
		container.addRow(getFirstRow());
		container.addRow(getRowSeperator());
		container.addRow(getSecondRow());
		container.addRow(getRowSeperator());
		container.addRow(getThirdRow());
		container.addRow(getRowSeperator());
		container.addRow(getFourthRow());
		container.addRow(getRowSeperator());
		return container;
	}

	private Row getSecondRow() {
		Row r2 = new Row();
		r2.addColumnComponent(getRighAlignedBgWhiteLabel("1", "Date: "));
		r2.addColumnComponent(InputField.createInputDate("2", "2002-08-20"));
		r2.addColumnComponent(getRighAlignedBgWhiteLabel("1", "Time: "));
		r2.addColumnComponent(InputField.createInputTime("2", "17:45"));
		r2.addColumnComponent(getRighAlignedBgWhiteLabel("1", "Month: "));
		r2.addColumnComponent(InputField.createInputMonth("2", "2002-08"));
		r2.addColumnComponent(getRighAlignedBgWhiteLabel("1", "Week: "));
		r2.addColumnComponent(InputField.createInputWeek("2", "2002-W33"));
		return r2;
	}

	private Row getRowSeperator() {
		Row r = new Row();
		InputField sep = getRighAlignedBgWhiteLabel("12", "");
		sep.addCssClass(BootstrapStyleEnum.WHITE_BORDER);
		r.addColumnComponent(sep);
		return r;
	}

	private Row getRowColorSeperator() {
		Row r = new Row();
		r.addColumnComponent(getRighAlignedBgWhiteLabel("2", "Choose Colour"));
		r.addColumnComponent(InputField.createColourInput("10", "#1a71ff"));
		return r;
	}

	private Row getThirdRow() {
		Row r3 = new Row();
		r3.addColumnComponent(getRighAlignedBgWhiteLabel("3", "Favourite Programing language: "));
		Select multiSelect = new Select("3",
				new HashSet<String>(Arrays.asList("Java", "JavaScript", "C#", "C (and C++)", "Ruby", "Groovy")), true);
		multiSelect.addSelectedData("Java");
		multiSelect.addSelectedData("JavaScript");
		r3.addColumnComponent(multiSelect);
		r3.addColumnComponent(getRighAlignedBgWhiteLabel("1", "Comments"));
		r3.addColumnComponent(TextArea.createTextArea("5", "  "));
		return r3;
	}

	private Row getFourthRow() {
		Row r = new Row();
		r.addColumnComponent(InputField.createInputSubmit("12", "GOOD TO GO!").addCssClass("btn btn-success"));
		return r;
	}

	private Row getFirstRow() {
		Row r1 = new Row();
		InputField firstNameField = InputField.createInputText("3", "");
		firstNameField.addPlaceHolderAttribute("First Name");
		r1.addColumnComponent(firstNameField);
		InputField lastNameField = InputField.createInputText("3", "");
		lastNameField.addPlaceHolderAttribute("Last Name");
		r1.addColumnComponent(lastNameField);
		InputField password = InputField.createInputPassword("2", "");
		password.addPlaceHolderAttribute("Password");
		r1.addColumnComponent(password);
		r1.addColumnComponent(getRighAlignedBgWhiteLabel("2", "Age Group: "));
		Select select = new Select("2", new HashSet<String>(Arrays.asList("20-30", "30-45", "45-60", "60-75")), false);
		r1.addColumnComponent(select);
		return r1;
	}

	private InputField getRighAlignedBgWhiteLabel(String col, String text) {
		InputField ageLabel = InputField.createInputText(col, text);
		ageLabel.addStyleAttribute(WHITE_BG_RIGHT_ALIGNED_LABEL, true);
		ageLabel.addAttribute("readOnly", "readOnly");
		return ageLabel;
	}

	private GenericHtmlTag getBodyWestRegion() {
		GenericHtmlTag westCell = new GenericHtmlTag(UI.DIV);
		westCell.setData("   ");
		westCell.setBsColumnNumber("1");
		westCell.addStyleAttribute(FORM_BODY, true);
		return westCell;
	}

	private GenericHtmlTag getBodyEastRegion() {
		GenericHtmlTag eastCell = new GenericHtmlTag(UI.DIV);
		eastCell.setData("   ");
		eastCell.setBsColumnNumber("1");
		eastCell.addStyleAttribute(FORM_BODY, true);
		return eastCell;
	}

	private Row getFooter() {
		Row footer = new Row();
		footer.addStyleAttribute(FORM_FOOTER, true);
		GenericHtmlTag footerCell = new GenericHtmlTag(UI.DIV);
		footerCell.setData("   ");
		footerCell.setBsColumnNumber("12");
		footerCell.addStyleAttribute(FORM_FOOTER_CELL, true);
		footer.addColumnComponent(footerCell);
		return footer;
	}

	private Row getHeader() {
		Row header = new Row();
		GenericHtmlTag headerCell = new GenericHtmlTag(UI.DIV);
		headerCell.setData("   ");
		headerCell.setBsColumnNumber("12");
		header.addStyleAttribute(FORM_HEADER, true);
		headerCell.addStyleAttribute(FORM_HEADER_CELL, true);
		header.addColumnComponent(headerCell);
		return header;
	}

}
