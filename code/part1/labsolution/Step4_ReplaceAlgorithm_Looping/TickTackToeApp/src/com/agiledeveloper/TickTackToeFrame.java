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
    JButton buttons[][];

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
            if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                    buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                    !buttons[0][0].getText().equals(""))
            {
                result = true;
            }
            if (buttons[2][0].getText().equals(buttons[1][1].getText()) &&
                    buttons[1][1].getText().equals(buttons[0][2].getText()) &&
                    !buttons[2][0].getText().equals(""))
            {
                            result = true;
            }

            return result;
        }

        private boolean checkRowMatch()
        {
            boolean result = false;
            for (int i = 0; i < 3; i++)
            {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().equals(""))
                {
                    result = true;
                }
            }
            return result;
        }

        private boolean checkColumnMatch()
        {
            boolean result = false;

            for (int i = 0; i < 3; i++)
            {
                if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().equals(""))
                {
                    result = true;
                }
            }
            return result;
        }
    }

    protected void frameInit()
    {
        super.frameInit();
        getContentPane().setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];

        // Row0
        buttons[0][0] = createButton();
        buttons[0][1] = createButton();
        buttons[0][2] = createButton();
        button00 = buttons[0][0];
        button01 = buttons[0][1];
        button02 = buttons[0][2];

        // Row1
        buttons[1][0] = createButton();
        buttons[1][1] = createButton();
        buttons[1][2] = createButton();
        button10 = buttons[1][0];
        button11 = buttons[1][1];
        button12 = buttons[1][2];

        // Row2
        buttons[2][0] = createButton();
        buttons[2][1] = createButton();
        buttons[2][2] = createButton();
        button20 = buttons[2][0];
        button21 = buttons[2][1];
        button22 = buttons[2][2];
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
