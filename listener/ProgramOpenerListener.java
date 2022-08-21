package Sidebar_Programm.listener;

import Sidebar_Programm.utilities.Utilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class ProgramOpenerListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Test");
		JButton button = (JButton) e.getSource();
		String text = button.getActionCommand();
		
		String path;

		switch (text) {
		case "eclipse":
			path = "C:\\Program Files\\JetBrains\\IntelliJ IDEA 2020.2.3\\bin\\idea64.exe";
			Utilities.startProgram(path);
			break;
		case "firefox":
			path = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
			Utilities.startProgram(path);
			break;
		case "mail":
			path = "C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE";
			Utilities.startProgram(path);
			break;
		case "textedit":
			 path = "C:\\Program Files (x86)\\Notepad++\\notepad++.exe";
			 Utilities.startProgram(path);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
