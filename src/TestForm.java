import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestForm {
    private JPanel rootPanel;
    private JComboBox testSelectComboBox;
    private JButton testSelectOkButton;
    private JList itemsList;
    private JButton cancelButton;
    private JButton finishButton;
    private JPanel formActionsJPanel;
    private JPanel itemListJPanel;
    private JPanel testSelectJPanel;
    private JTextField textField1;
    private JButton addItem;
    private JButton deleteItem;

    // used to assign id's to new Tests TODO get this from DB
    private int masterTestId = 0;

    // ArrayList of tests to be sent to db
    private ArrayList<Test> testList = new ArrayList<Test>();

    public TestForm() {
        // create the gui rootPanel and set dimensions
        rootPanel.setPreferredSize(new Dimension(600,400));

        // create OK button listener
        testSelectOkButton.addActionListener(new ActionListener() {
            /**
             * Invoked whenever the OK button is clicked.
             * @param e the click event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //create new Test from currentComboBoxText and current masterTestId
                String currentComboBoxText = testSelectComboBox.getSelectedItem().toString();
                Test newTest = new Test(currentComboBoxText, masterTestId);
                testList.add(newTest);
                masterTestId++;
                testSelectComboBox.addItem(newTest.getTestName());
            }
        });
    }

    // getter for rootPanel
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
