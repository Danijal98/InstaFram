package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view_param_edit.ParamEditView;

public class OpenParamEdit extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		ParamEditView view = new ParamEditView();
		view.setVisible(true);
	}
	
}
