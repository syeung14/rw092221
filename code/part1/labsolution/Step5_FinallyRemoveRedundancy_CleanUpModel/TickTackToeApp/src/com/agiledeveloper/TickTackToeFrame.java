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

        for (int i = 0; i < 3; i++)
        {
             for (int j = 0; j < 3; j++)
             {
                 buttons[i][j] = createButton();
             }
        }
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
            _frame.buttons[0][0].doClick();
            _frame.buttons[2][0].doClick();
            _frame.buttons[0][1].doClick();
            _frame.buttons[2][2].doClick();
            _frame.buttons[0][2].doClick();
            assertTrue(_frame._match);
        }

        public void testColumnMatch()
        {
            assertFalse(_frame._match);
            _frame.buttons[0][0].doClick();
            _frame.buttons[0][1].doClick();
            _frame.buttons[2][2].doClick();
            _frame.buttons[1][1].doClick();
            _frame.buttons[2][0].doClick();
            _frame.buttons[2][1].doClick();
            assertTrue(_frame._match);
        }

        public void testDiagonalMatch()
        {
            assertFalse(_frame._match);
            _frame.buttons[2][0].doClick();
            _frame.buttons[2][2].doClick();
            _frame.buttons[0][2].doClick();
            _frame.buttons[0][0].doClick();
            _frame.buttons[1][1].doClick();
            assertTrue(_frame._match);
        }

        public void testNoWinner()
        {
            assertFalse(_frame._match);
            _frame.buttons[0][0].doClick();
            _frame.buttons[0][1].doClick();
            _frame.buttons[0][2].doClick();
            _frame.buttons[1][2].doClick();
            _frame.buttons[1][1].doClick();
            _frame.buttons[2][2].doClick();
            _frame.buttons[2][1].doClick();
            _frame.buttons[2][0].doClick();
            _frame.buttons[1][0].doClick();
            assertFalse(_frame._match);
        }

        public void testRowTwo()
        {
        	assertFalse(_frame._match);
        	_frame.buttons[1][1].doClick();
        	_frame.buttons[0][1].doClick();
        	_frame.buttons[1][2].doClick();
        	_frame.buttons[2][0].doClick();
        	_frame.buttons[1][0].doClick();
        	assertTrue(_frame._match);
        }

        public void testRowThree()
        {
        	assertFalse(_frame._match);
        	_frame.buttons[2][2].doClick();
        	_frame.buttons[1][1].doClick();
        	_frame.buttons[2][0].doClick();
        	_frame.buttons[0][2].doClick();
        	_frame.buttons[2][1].doClick();
        	assertTrue(_frame._match);
        }

        public void testColumnOne()
        {
        	assertFalse(_frame._match);
        	_frame.buttons[0][2].doClick();
        	_frame.buttons[0][0].doClick();
        	_frame.buttons[2][2].doClick();
        	_frame.buttons[1][0].doClick();
        	_frame.buttons[1][2].doClick();
        	_frame.buttons[2][0].doClick();
        	assertTrue(_frame._match);
        }

        public void testColumnThree()
        {
        	assertFalse(_frame._match);
        	_frame.buttons[0][0].doClick();
        	_frame.buttons[1][2].doClick();
        	_frame.buttons[1][0].doClick();
        	_frame.buttons[0][2].doClick();
        	_frame.buttons[1][1].doClick();
        	_frame.buttons[2][2].doClick();
        	assertTrue(_frame._match);
        }

        public void testLeftDiagonalMatch()
        {
        	assertFalse(_frame._match);
        	_frame.buttons[2][2].doClick();
        	_frame.buttons[1][0].doClick();
        	_frame.buttons[0][0].doClick();
        	_frame.buttons[1][2].doClick();
        	_frame.buttons[1][1].doClick();
        	assertTrue(_frame._match);
        }


        public static void main(String[] args)
        {
            junit.swingui.TestRunner.run(TestRunner.class);
        }
    }
}
