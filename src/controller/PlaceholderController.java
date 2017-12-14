package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PlaceholderController {

    public static class GhostText implements FocusListener, DocumentListener, PropertyChangeListener {
    	public final JTextArea textArea;
    	public boolean isEmpty;
    	public Color ghostColor;
    	public Color foregroundColor;
    	public final String ghostText;

        public GhostText(final JTextArea textArea, String ghostText) {
            super();
            this.textArea = textArea;
            this.ghostText = ghostText;
            this.ghostColor = Color.GRAY;
            textArea.addFocusListener(this);
            registerListeners();
            updateState();
            if (!this.textArea.hasFocus()) {
                focusLost(null);
            }
        }

        public void delete() {
            unregisterListeners();
            textArea.removeFocusListener(this);
        }

        public void registerListeners() {
        	textArea.getDocument().addDocumentListener(this);
        	textArea.addPropertyChangeListener("foreground", this);
        }

        public void unregisterListeners() {
        	textArea.getDocument().removeDocumentListener(this);
        	textArea.removePropertyChangeListener("foreground", this);
        }

        public Color getGhostColor() {
            return ghostColor;
        }

        public void setGhostColor(Color ghostColor) {
            this.ghostColor = ghostColor;
        }

        public void updateState() {
            isEmpty = textArea.getText().length() == 0;
            foregroundColor = textArea.getForeground();
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                	textArea.setText("");
                	textArea.setForeground(Color.ORANGE);
                } finally {
                    registerListeners();
                }
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                	textArea.setText(ghostText);
                	textArea.setForeground(ghostColor);
                } finally {
                    registerListeners();
                }
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            updateState();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateState();
        }

    }

}