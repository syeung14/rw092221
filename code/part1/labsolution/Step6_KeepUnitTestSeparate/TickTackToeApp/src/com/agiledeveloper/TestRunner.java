package com.agiledeveloper;

import junit.framework.TestCase;
import javax.swing.*;

public class TestRunner extends TestCase
    {
        private TickTackToeFrame _frame;

        protected void setUp() throws Exception
        {
            _frame = new TickTackToeFrame();
            _frame._displayResult = false;
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
