package bootstrap.in.java.ui;

import java.util.HashSet;
import java.util.Set;

import bootstrap.in.java.ui.enums.BootstrapStyleEnum;

public class Select extends UIAdaptor implements ColumnComponent {

	private String bsColumnNumber;
	private Set<String> data = new HashSet<>();
	private Set<String> selectedData = new HashSet<>();
	private Boolean multiSelect = false;

	public Select(String bsColumnNumber, Set<String> data, Boolean multiSelect) {
		super();
		this.bsColumnNumber = bsColumnNumber;
		this.data = data;
		this.multiSelect = multiSelect;
	}

	@Override
	public String render() {
		setTagName(UI.SELECT);
		if (multiSelect) {
			addAttribute("multiple", "multiple");
		}
		addCssClass(BootstrapStyleEnum.FORM_CONTROL);
		StringBuilder selectTag = new StringBuilder(createOpeningTag());
		getData().stream().forEach(e -> addOption(e, selectTag));
		selectTag.append(createClosingTag());
		return selectTag.toString();
	}

	private void addOption(String data, StringBuilder selectTag) {
		GenericHtmlTag option = new GenericHtmlTag(UI.OPTION);
		if (selectedData.stream().anyMatch(selectedData -> data.trim().equals(selectedData.trim()))) {
			option.addAttribute("selected", "selected");
		}
		option.setData(data);
		selectTag.append(option.render());
	}

	@Override
	public String getBsColumnNumber() {
		return bsColumnNumber;
	}

	@Override
	public void setBsColumnNumber(String bsColumnNumber) {
		this.bsColumnNumber = bsColumnNumber;
	}

	public Set<String> getData() {
		return data;
	}

	public void setData(Set<String> data) {
		this.data = data;
	}

	public void addSelectedData(String selectedData) {
		if (!multiSelect) {
			this.selectedData.clear();
		}
		this.selectedData.add(selectedData);
	}

	public Boolean getMultiSelect() {
		return multiSelect;
	}

	public void setMultiSelect(Boolean multiSelect) {
		this.multiSelect = multiSelect;
	}

}
