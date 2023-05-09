import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    InputPanel tomegPanel;
    InputPanel magassagPanel;
    InputPanel indexPanel;
    JPanel buttonPanel;
    JButton calcButton;

    public MainFrame() {                    //Ctrl+. generate constructor
        this.initComponent();
        this.addComponent();
        this.handleEvent();
        this.setFrame();                      
    }

    private void initComponent() {
        this.tomegPanel = new InputPanel("Tömeg (kg)");
        this.magassagPanel = new InputPanel("Magasság");
        this.buttonPanel = new JPanel();
        this.indexPanel = new InputPanel("Testtömeg index");
        this.calcButton = new JButton("Számit");
        this.buttonPanel.add(this.calcButton);
    } 

    private void addComponent() {
        this.add(this.tomegPanel);
        this.add(this.magassagPanel);
        this.add(this.buttonPanel);
        this.add(this.indexPanel);
        this.buttonPanel.add(this.calcButton);
    }

    private void handleEvent() {
        this.calcButton.addActionListener( e -> {
            startCalc();
        });
    }

    private void startCalc() {
        String tomegStr = this.tomegPanel.getValue();
        if(!this.checkInput(tomegStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }
        double tomeg = Double.parseDouble(tomegStr);
        String magassagStr = this.magassagPanel.getValue();
        if(!this.checkInput(magassagStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }
        double magassag = Double.parseDouble(magassagStr);
        Double testtomegIndex = this.calcBodyIndex(tomeg, magassag);
        this.indexPanel.setValue(testtomegIndex.toString());
    }

    public double calcBodyIndex(double weight, double height) {
        return weight / Math.pow(height, 2);
    }

    public boolean checkInput(String input) {
        boolean ok = false;
        if(input.matches("[0-9.]+")) {
            ok = true;
        }
        return ok;
    }
    
    private void setFrame(){
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(400, 300);
        this.pack();                //setsize helyett van ez felveszi a componentek mértetét
        this.setVisible(true);
    }

    
}
