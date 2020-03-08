package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class ParametersElementsSelection implements Transferable, ClipboardOwner{
	
	static public DataFlavor elementFlavor;
	private DataFlavor[] supportedFlavors = {elementFlavor};
	public ArrayList<Parametar> parameterElements = new ArrayList<>();
	
	public ParametersElementsSelection(ArrayList<Parametar> elements) {
		parameterElements = elements;
		try {
			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Elements");
		} catch (Exception e) {
			System.err.println("data flavor error");
			e.printStackTrace();
		}
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(flavor.equals(elementFlavor))
			return (parameterElements);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(elementFlavor);
	}

}
