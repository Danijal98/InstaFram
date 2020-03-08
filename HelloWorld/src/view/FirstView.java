package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import actions.ActionManager;
import actions.Edit;
import commandPattern.CommandManager;
import model.Cvor;
import model.WorkspaceModel;

public class FirstView extends JFrame implements ClipboardOwner{
	
	private WorkspaceModel workspaceModel;
    private MyJTree myJTree;
    private JScrollPane scrollFrame;
    private static FirstView instance;
    private Clipboard clipboard = new Clipboard("Tree editor clipboard");
    public CommandManager commandManager = new CommandManager();
    
    
	private FirstView() {
		//init
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width/2, height/2);
		setTitle("InstaFram");
		setLocationRelativeTo(null);
		setJMenuBar(new MyMenuBar());
		
		//instance
		MyToolBar myToolBar = new MyToolBar();
		
		//init jtree
		myJTree=new MyJTree();
		scrollFrame = new JScrollPane(myJTree);
		workspaceModel = new WorkspaceModel();
		myJTree.setModel(workspaceModel);
		myJTree.setAutoscrolls(true);
		
		MyWorkSpace1 myWorkSpace1 = MyWorkSpace1.getInstance();
		MyWorkSpace2 myWorkSpace2 = MyWorkSpace2.getInstance();
		MyStatusBar myStatusBar = new MyStatusBar();
		
		//dodavanja
		this.add(myToolBar, BorderLayout.NORTH);
		JPanel center = new JPanel(new BorderLayout());
		center.add(myWorkSpace1,BorderLayout.NORTH);
		center.add(myWorkSpace2,BorderLayout.SOUTH);
		this.add(myStatusBar,BorderLayout.SOUTH);
		JSplitPane split_vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT,myWorkSpace1,myWorkSpace2);
		split_vertical.setResizeWeight(0.3);
		JSplitPane split_horizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollFrame,split_vertical);
		split_horizontal.setResizeWeight(0.09);
		this.add(split_horizontal,BorderLayout.CENTER);
		
		myJTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Edit edit = new Edit();
					edit.actionPerformed(null);
				}
			}
		});
		
		//zatvaranje programa
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(ActionManager.getInstance().getExit());
	}
	
	public WorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}

	public void setWorkspaceModel(WorkspaceModel workspaceModel) {
		this.workspaceModel = workspaceModel;
	}

	public MyJTree getMyJTree() {
		return myJTree;
	}

	public void setMyJTree(MyJTree myJTree) {
		this.myJTree = myJTree;
	}

	public static FirstView getInstance() {
		if(instance==null)
			instance = new FirstView();
		return instance;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {}

	public Clipboard getClipboard() {
		return clipboard;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	
}
