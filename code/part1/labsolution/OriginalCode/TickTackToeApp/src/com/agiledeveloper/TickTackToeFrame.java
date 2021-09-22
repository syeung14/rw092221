package com.agiledeveloper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TickTackToeFrame extends JFrame
{
	private boolean _match = false;
    private boolean nextPegIsX = true;
    JButton button00;
    JButton button01;
    JButton button02;
    JButton button10;
    JButton button11;
    JButton button12;
    JButton button20;
    JButton button21;
    JButton button22;

    private class ActionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton theButton = (JButton) e.getSource();
            theButton.setText("O");
            if (nextPegIsX) theButton.setText("X");
            theButton.setEnabled(false);
            nextPegIsX = !nextPegIsX;

            // Check for a winner by row match
            if (button00.getText().equals(button01.getText()) &&
                    button01.getText().equals(button02.getText()) &&
                    !button00.getText().equals(""))
            {
                _match = true;
            }
            if (button10.getText().equals(button11.getText()) &&
                    button11.getText().equals(button12.getText()) &&
                    !button10.getText().equals(""))
            {
                _match = true;
            }
            if (button20.getText().equals(button21.getText()) &&
                    button21.getText().equals(button22.getText()) &&
                    !button20.getText().equals(""))
            {
                _match = true;
            }

            // Check for a winner by column match
            if (button00.getText().equals(button10.getText()) &&
                    button10.getText().equals(button12.getText()) &&
                    !button00.getText().equals(""))
            {
                _match = true;
            }
            if (button01.getText().equals(button11.getText()) &&
                    button11.getText().equals(button21.getText()) &&
                    !button01.getText().equals(""))
            {
                _match = true;
            }
            if (button02.getText().equals(button12.getText()) &&
                    button12.getText().equals(button22.getText()) &&
                    !button02.getText().equals(""))
            {
                _match = true;
            }

            // Check for diagonal match
            if (button00.getText().equals(button11.getText()) &&
                    button11.getText().equals(button22.getText()) &&
                    !button00.getText().equals(""))
            {
                _match = true;
            }
            if (button20.getText().equals(button11.getText()) &&
                    button11.getText().equals(button02.getText()) &&
                    !button20.getText().equals(""))
            {
                            _match = true;
            }
            
            if (_match)
            {
                JOptionPane.showMessageDialog(TickTackToeFrame.this,
                        new String("We have a winner"));
            }
        }
    }

    protected void frameInit()
    {
        super.frameInit();
        getContentPane().setLayout(new GridLayout(3, 3));

        // Row0
        button00 = new JButton();
        button00.addActionListener(new ActionHandler());
        getContentPane().add(button00);

        button01 = new JButton();
        button01.addActionListener(new ActionHandler());
        getContentPane().add(button01);

        button02 = new JButton();
        button02.addActionListener(new ActionHandler());
        getContentPane().add(button02);

        // Row1
        button10 = new JButton();
        button10.addActionListener(new ActionHandler());
        getContentPane().add(button10);

        button11 = new JButton();
        button11.addActionListener(new ActionHandler());
        getContentPane().add(button11);

        button12 = new JButton();
        button12.addActionListener(new ActionHandler());
        getContentPane().add(button12);

        // Row2
        button20 = new JButton();
        button20.addActionListener(new ActionHandler());
        getContentPane().add(button20);

        button21 = new JButton();
        button21.addActionListener(new ActionHandler());
        getContentPane().add(button21);

        button22 = new JButton();
        button22.addActionListener(new ActionHandler());
        getContentPane().add(button22);
    }

    public static void main(String[] args)
    {
        JFrame frame = new TickTackToeFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
