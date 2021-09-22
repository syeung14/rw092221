package com.agiledeveloper;

import junit.framework.TestCase;

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
            PlacePegAndToggle(theButton);

            _match = checkRowMatch()
                    || checkColumnMatch()
                    || checkDiagonalMatch();

            if (_match)
            {
//                JOptionPane.showMessageDialog(TickTackToeFrame.this,
//                        new String("We have a winner"));
            }
        }

        private void PlacePegAndToggle(JButton theButton)
        {
            theButton.setText("O");
            if (nextPegIsX) theButton.setText("X");
            theButton.setEnabled(false);
            nextPegIsX = !nextPegIsX;
        }

        private boolean checkDiagonalMatch()
        {
            boolean result = false;
            // Check for diagonal match
            if (button00.getText().equals(button11.getText()) &&
                    button11.getText().equals(button22.getText()) &&
                    !button00.getText().equals(""))
            {
                result = true;
            }
            if (button20.getText().equals(button11.getText()) &&
                    button11.getText().equals(button02.getText()) &&
                    !button20.getText().equals(""))
            {
                            result = true;
            }

            return result;
        }

        private boolean checkRowMatch()
        {
            // We removed duplication in frameInit.
            // But the duplication here will have to wait
            // a little longer.
            boolean result = false;
            // Check for a winner by row match
            if (button00.getText().equals(button01.getText()) &&
                    button01.getText().equals(button02.getText()) &&
                    !button00.getText().equals(""))
            {
                result = true;
            }
            if (button10.getText().equals(button11.getText()) &&
                    button11.getText().equals(button12.getText()) &&
                    !button10.getText().equals(""))
            {
                result = true;
            }
            if (button20.getText().equals(button21.getText()) &&
                    button21.getText().equals(button22.getText()) &&
                    !button20.getText().equals(""))
            {
                result = true;
            }
            return result;
        }

        private boolean checkColumnMatch()
        {
            boolean result = false;

            if (button00.getText().equals(button10.getText()) &&
                    button10.getText().equals(button12.getText()) &&
                    !button00.getText().equals(""))
            {
                result = true;
            }
            if (button01.getText().equals(button11.getText()) &&
                    button11.getText().equals(button21.getText()) &&
                    !button01.getText().equals(""))
            {
                result = true;
            }
            if (button02.getText().equals(button12.getText()) &&
                    button12.getText().equals(button22.getText()) &&
                    !button02.getText().equals(""))
            {
                result = true;
            }
            return result;
        }
    }

    protected void frameInit()
    {
        super.frameInit();
        getContentPane().setLayout(new GridLayout(3, 3));

        // Row0
        button00 = createButton();
        button01 = createButton();
        button02 = createButton();

        // Row1
        button10 = createButton();
        button11 = createButton();
        button12 = createButton();

        // Row2
        button20 = createButton();
        button21 = createButton();
        button22 = createButton();
    }

    private JButton createButton()
    {
        JButton button = new JButton();
        button.addActionListener(new ActionHandler());
        getContentPane().add(button);
        return button;
    }

//    public static void main(String[] args)
//    {
//        JFrame frame = new TickTackToeFrame();
//        frame.setSize(200, 200);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }

    public static class TestRunner extends TestCase
    {
        private TickTackToeFrame _frame;

        protected void setUp() throws Exception
        {
            _frame = new TickTackToeFrame();
            _frame.setSize(200, 200);
            _frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            _frame.setVisible(true);
        }

        public void testRowMatch()
        {
            assertFalse(_frame._match);
            _frame.button00.doClick();
            _frame.button20.doClick();
            _frame.button01.doClick();
            _frame.button22.doClick();
            _frame.button02.doClick();
            assertTrue(_frame._match);
        }

        public void testColumnMatch()
        {
            assertFalse(_frame._match);
            _frame.button00.doClick();
            _frame.button01.doClick();
            _frame.button22.doClick();
            _frame.button11.doClick();
            _frame.button20.doClick();
            _frame.button21.doClick();
            assertTrue(_frame._match);
        }

        public void testDiagonalMatch()
        {
            assertFalse(_frame._match);
            _frame.button20.doClick();
            _frame.button22.doClick();
            _frame.button02.doClick();
            _frame.button00.doClick();
            _frame.button11.doClick();
            assertTrue(_frame._match);
        }

        public void testNoWinner()
        {
            assertFalse(_frame._match);
            _frame.button00.doClick();
            _frame.button01.doClick();
            _frame.button02.doClick();
            _frame.button12.doClick();
            _frame.button11.doClick();
            _frame.button22.doClick();
            _frame.button21.doClick();
            _frame.button20.doClick();
            _frame.button10.doClick();
            assertFalse(_frame._match);
        }

        public void testRowTwo()
        {
        	assertFalse(_frame._match);
        	_frame.button11.doClick();
        	_frame.button01.doClick();
        	_frame.button12.doClick();
        	_frame.button20.doClick();
        	_frame.button10.doClick();
        	assertTrue(_frame._match);
        }

        public void testRowThree()
        {
        	assertFalse(_frame._match);
        	_frame.button22.doClick();
        	_frame.button11.doClick();
        	_frame.button20.doClick();
        	_frame.button02.doClick();
        	_frame.button21.doClick();
        	assertTrue(_frame._match);
        }

        public void testColumnOne()
        {
        	assertFalse(_frame._match);
        	_frame.button02.doClick();
        	_frame.button00.doClick();
        	_frame.button22.doClick();
        	_frame.button10.doClick();
        	_frame.button12.doClick();
        	_frame.button20.doClick();
        	assertTrue(_frame._match);
        }

        public void testColumnThree()
        {
        	assertFalse(_frame._match);
        	_frame.button00.doClick();
        	_frame.button12.doClick();
        	_frame.button10.doClick();
        	_frame.button02.doClick();
        	_frame.button11.doClick();
        	_frame.button22.doClick();
        	assertTrue(_frame._match);
        }

        public void testLeftDiagonalMatch()
        {
        	assertFalse(_frame._match);
        	_frame.button22.doClick();
        	_frame.button10.doClick();
        	_frame.button00.doClick();
        	_frame.button12.doClick();
        	_frame.button11.doClick();
        	assertTrue(_frame._match);
        }


        public static void main(String[] args)
        {
            junit.swingui.TestRunner.run(TestRunner.class);
        }
    }
}
