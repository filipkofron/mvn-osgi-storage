package cz.kofron.storage.view.gui;

import cz.kofron.storage.model.entity.ItemGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ItemGroupDetail extends GridPane
{
	private Label nameLabel;
	private Label descLabel;
	private TextField nameTextField;
	private TextArea descTextArea;
	private Button addButton;
	private Button saveButton;
	private ActionHandler actionHandler;
	private Integer itemGroupId = null;

	public ItemGroupDetail(ActionHandler actionHandler)
	{
		this.actionHandler = actionHandler;
		nameLabel = new Label("Name:");
		descLabel = new Label("Description:");

		nameTextField = new TextField();
		descTextArea = new TextArea();

		addButton = new Button("Add");
		saveButton = new Button("Save");

		addButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				ItemGroupDetail.this.actionHandler.onAddItemGroup();
			}
		});

		saveButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				ItemGroupDetail.this.actionHandler.onSaveItemGroup();
			}
		});

		add(nameLabel, 0, 1);
		add(nameTextField, 1, 1, 1, 1);

		add(descLabel, 0, 2);
		add(descTextArea, 1, 2, 2, 1);

		add(saveButton, 1, 4, 1, 1);
		add(addButton, 2, 4, 1, 1);
	}

	public String getItemGroupName()
	{
		return nameTextField.getText();
	}

	public String getItemGroupDescription()
	{
		return descTextArea.getText();
	}
	
	public Integer getItemGroupId()
	{
		return itemGroupId;
	}
	
	public void setItemGroupId(Integer itemGroupId)
	{
		this.itemGroupId = itemGroupId;
	}
	
	public void update(ItemGroup itemGroup)
	{
		itemGroupId = itemGroup.getId();
		nameTextField.setText(itemGroup.getName());
		descTextArea.setText(itemGroup.getDescription());
	}
}
