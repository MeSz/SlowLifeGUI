package SlowLifeGUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Cell extends JButton {

    private boolean _beenAlive = false;

    private int _maxSize = 10000;
    
    /**
     * Font being set at the MainFrame level
     */
    public Cell() {
	super(" ");
	setFont(new Font("Courier", Font.PLAIN, 12));
	addActionListener(new CellButtonListener());
    }

    /**
     * Font being set at the MainFrame level
     */
    public Cell(boolean alive) {
	super(" ");
	setFont(new Font("Courier", Font.PLAIN, 12));
	addActionListener(new CellButtonListener());
	setAlive(alive);
    }

    public void resetBeenAlive() {
	_beenAlive = false;
    }

    public void reset() {
	resetBeenAlive();
	setAlive(false);
    }
    
    public boolean getAlive() {
	String text = getText();
	return (text.equals("X"));
    }

    /**
     * Optimized toString()
     * @return 
     */
    @Override
    public String toString() {
	String currentState = getText();
        
        if (currentState.equals("X")) {
            return currentState;
	} else {
	    return ".";
	}
    }
    
    public String toString_OLD() {
	String toReturn = new String("");
	String currentState = getText();
	for (int j = 0; j < _maxSize; j++) {
	    toReturn += currentState;
	}
	if (toReturn.substring(0,1).equals("X")) {
	    return toReturn.substring(0,1);
	} else {
	    return ".";
	}
    }
    
    public void setAlive(boolean a) {
	// note that "if (a)" and "if (a == true)"
	// really say the same thing!
	if (a) {
	    _beenAlive = true;
	    setText("X");
	    setBackground(Color.RED);
	} else {
	    setText(" ");
	    if (_beenAlive) {
		setBackground(Color.GREEN);
	    } else {
		setBackground(Color.GRAY);
	    }
	}
	setContentAreaFilled(true);
        setOpaque(true);
    }

    class CellButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

        /**
         * Optimized actionPerformed()
         * 
         * @param e 
         */
	public void actionPerformed(ActionEvent e) {
	    Cell source = (Cell) e.getSource();
	    String currentText = source.getText();
            
	    resetBeenAlive();
	    if (currentText.equals(" ")) {
		setAlive(true);
	    } else {
		setAlive(false);
	    }
	}
        
        public void actionPerformed_OLD(ActionEvent e) {
	    Cell source = (Cell) e.getSource();
	    String currentText = source.getText();
	    resetBeenAlive();
	    if (currentText.equals(" ")) {
		setAlive(true);
	    } else if (currentText.equals("X")) {
		setAlive(false);
	    } else {
		// This shouldn't happen
		setAlive(false);
	    }
	}
    
    }

}
