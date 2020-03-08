package actions;

public class ActionManager {
	
	private static ActionManager instance;
	private NodeAdderAction nodeAdderAction;
	private NodeDeleteAction nodeDeleteAction;
	private Load load;
	private Save save;
	private SaveAs saveAs;
	private OpenAddDialog openAddDialog;
	private Edit edit;
	private Close close;
	private Exit exit;
	private Cut cut;
	private Copy copy;
	private Paste paste;
	private OpenParamEdit openParamEdit;
	private Export export;
	private Import importAction;
	private Undo undo;
	private Redo redo;
	
	private ActionManager() {
		undo = new Undo();
		redo = new Redo();
		importAction = new Import();
		export = new Export();
		openParamEdit = new OpenParamEdit();
		cut = new Cut();
		copy = new Copy();
		paste = new Paste();
		exit = new Exit();
		close = new Close();
		edit = new Edit();
		openAddDialog = new OpenAddDialog();
		saveAs = new SaveAs();
		save = new Save();
		load = new Load();
		nodeDeleteAction = new NodeDeleteAction();
		nodeAdderAction = new NodeAdderAction(null);
	}
	
	public static ActionManager getInstance() {
		if(instance == null)
			instance = new ActionManager();
		return instance;
	}

	public Export getExport() {
		return export;
	}

	public void setExport(Export export) {
		this.export = export;
	}

	public Import getImportAction() {
		return importAction;
	}

	public void setImportAction(Import importAction) {
		this.importAction = importAction;
	}

	public Undo getUndo() {
		return undo;
	}

	public void setUndo(Undo undo) {
		this.undo = undo;
	}

	public Redo getRedo() {
		return redo;
	}

	public void setRedo(Redo redo) {
		this.redo = redo;
	}

	public OpenParamEdit getOpenParamEdit() {
		return openParamEdit;
	}

	public void setOpenParamEdit(OpenParamEdit openParamEdit) {
		this.openParamEdit = openParamEdit;
	}

	public Exit getExit() {
		return exit;
	}

	public void setExit(Exit exit) {
		this.exit = exit;
	}

	public Close getClose() {
		return close;
	}

	public void setClose(Close close) {
		this.close = close;
	}

	public Edit getEdit() {
		return edit;
	}

	public void setEdit(Edit edit) {
		this.edit = edit;
	}

	public OpenAddDialog getOpenAddDialog() {
		return openAddDialog;
	}

	public void setOpenAddDialog(OpenAddDialog openAddDialog) {
		this.openAddDialog = openAddDialog;
	}

	public SaveAs getSaveAs() {
		return saveAs;
	}

	public void setSaveAs(SaveAs saveAs) {
		this.saveAs = saveAs;
	}

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}

	public Load getLoad() {
		return load;
	}

	public void setLoad(Load load) {
		this.load = load;
	}

	public NodeAdderAction getNodeAdderAction() {
		return nodeAdderAction;
	}

	public void setNodeAdderAction(NodeAdderAction nodeAdderAction) {
		this.nodeAdderAction = nodeAdderAction;
	}

	public NodeDeleteAction getNodeDeleteAction() {
		return nodeDeleteAction;
	}

	public void setNodeDeleteAction(NodeDeleteAction nodeDeleteAction) {
		this.nodeDeleteAction = nodeDeleteAction;
	}

	public Cut getCut() {
		return cut;
	}

	public void setCut(Cut cut) {
		this.cut = cut;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public Paste getPaste() {
		return paste;
	}

	public void setPaste(Paste paste) {
		this.paste = paste;
	}

}
