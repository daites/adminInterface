import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestForm {
    private JPanel rootPanel;
    private JComboBox testSelectComboBox;
    private JButton testCreateButton;
    private JList itemsJList;
    private JButton cancelButton;
    private JButton finishButton;
    private JPanel formActionsJPanel;
    private JPanel itemListJPanel;
    private JPanel testSelectJPanel;
    private JTextField addItemTextField;
    private JButton addItemButton;
    private JButton deleteItemButton;
    private JLabel testSelectLabel;
    private JTextField testCreateTextField;
    private JLabel testCreateLabel;

    // used to assign id's to new Tests TODO get this from DB
    private int masterTestId = 0;

    // ArrayList of tests to be sent to db
    private ArrayList<Test> testList = new ArrayList<>();

    public TestForm() {
        // create the gui rootPanel and set dimensions
        rootPanel.setPreferredSize(new Dimension(600,400));

        //populate some tests
        addTest("Plants");
        addTest("Animals");

        // create OK button listener
        testCreateButton.addActionListener(new ActionListener() {
            /**
             * Invoked whenever the create button is clicked.
             * @param e the click event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean testExistsFlag = false;

                //get text from testCreateTextField
                String newTestName = testCreateTextField.getText();

                // iterate over testList, checking if currentComboBox matches existing testName
                for (Test test : testList) {
                    if (newTestName.equalsIgnoreCase(test.getTestName())) {
                        testExistsFlag = true;
                    }
                }

                // if test doesn't already exist, add it
                if (!testExistsFlag) {
                    addTest(newTestName);
                }
            }
        });
    }

    /**
     * add a test to testSelectComboBox and increment masterTestId
     * @param inputString
     */
    private void addTest(String inputString) {
        Test newTest = new Test(inputString, masterTestId);
        // add to testList ArrayList
        testList.add(newTest);
        // add to testSelectComboBox for display
        testSelectComboBox.addItem(newTest.getTestName());
        // increment masterTestId so next test gets new id
        masterTestId++;
    }

    // getter for rootPanel
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
