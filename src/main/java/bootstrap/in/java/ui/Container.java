package bootstrap.in.java.ui;

import java.util.ArrayList;
import java.util.List;

public class Container extends UIAdaptor implements ColumnComponent {

	private List<Row> rows = new ArrayList<>();
	private List<Container> innerContainer = new ArrayList<>();
	private List<ColumnComponent> nonGridTags = new ArrayList<>();
	private String bsColumnNumber;
	private Boolean fluid = true;

	public Container() {
		this.setTagName(UI.DIV);
	}

	@Override
	public String render() {
		getCssClasses().add(fluid ? "container-fluid" : "container");
		StringBuilder containerBody = new StringBuilder();
		StringBuilder container = new StringBuilder();
		if (!innerContainer.isEmpty() || !nonGridTags.isEmpty()) {
			innerContainer.stream().filter(iContainer -> !iContainer.equals(this))
					.forEach(iContainer -> containerBody.append(iContainer.render()));
			nonGridTags.stream().filter(nonGridTag -> !nonGridTag.equals(this))
					.forEach(nonGridTag -> containerBody.append(nonGridTag.render()));
		} else {
			rows.stream()
					.forEach(row -> containerBody.append((!row.containsColumnComponent(this) ? row.render() : "")));
		}
		container.append(createOpeningTag());
		container.append(containerBody);
		container.append(createClosingTag());
		return container.toString();
	}

	public void addRow(Row row) {
		rows.add(row);
	}

	public Boolean getFluid() {
		return fluid;
	}

	public void setFluid(Boolean fluid) {
		this.fluid = fluid;
	}

	@Override
	public String getBsColumnNumber() {
		return bsColumnNumber;
	}

	public void setBsColumnNumber(String bsColumnNumber) {
		this.bsColumnNumber = bsColumnNumber;
	}

	public List<Container> getInnerContainer() {
		return innerContainer;
	}

	public void setInnerContainer(List<Container> innerContainer) {
		this.innerContainer = innerContainer;
	}

	public List<ColumnComponent> getNonGridTags() {
		return nonGridTags;
	}

	public void setNonGridTags(List<ColumnComponent> nonGridTags) {
		this.nonGridTags = nonGridTags;
	}
	
	@Override
	public ColumnComponent addCssClass(String cssClass) {
		return (ColumnComponent) super.addCssClass(cssClass);
	}

}
