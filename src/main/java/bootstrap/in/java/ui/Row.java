package bootstrap.in.java.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bootstrap.in.java.ui.enums.BootstrapStyleEnum;
import bootstrap.in.java.ui.enums.InlineStyleEnum;

public class Row extends UIAdaptor {

	private List<ColumnComponent> columnComponents = new ArrayList<>();

	public Row() {
		this.setTagName(UI.DIV);
		getCssClasses().add("row");
	}

	@Override
	public String render() {
		StringBuilder rowBody = new StringBuilder();
		columnComponents.stream().forEach(columnComponent -> rowBody.append(rendercColumnComponent(columnComponent)));
		StringBuilder row = new StringBuilder(createOpeningTag());
		row.append(rowBody);
		row.append(createClosingTag());
		return row.toString();
	}

	private String rendercColumnComponent(ColumnComponent columnComponent) {
		if (columnComponent.getBsColumnNumber() == null) {
			return "";
		}
		StringBuilder columnComponentContent = new StringBuilder();
		Container cell = new Container();
		cell.addStyleAttribute(InlineStyleEnum.ZERO_PADDING, true);
		cell.getCssClasses()
				.addAll(Arrays.asList("col-" + columnComponent.getBsColumnNumber(),
						BootstrapStyleEnum.FLEX_FILL.toString(), BootstrapStyleEnum.JUSTIFY_CONTENT_CENTER.toString(),
						columnComponent.getColumnCss()));
		columnComponentContent.append(cell.createOpeningTag());
		columnComponentContent.append(columnComponent.render());
		columnComponentContent.append(cell.createClosingTag());
		return columnComponentContent.toString();
	}

	public void addColumnComponent(ColumnComponent columnComponent) {
		columnComponents.add(columnComponent);
	}

	public Boolean containsColumnComponent(ColumnComponent columnComponent) {
		return columnComponents.contains(columnComponent);
	}

}
