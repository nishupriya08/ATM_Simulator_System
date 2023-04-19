package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    JTextField emailTextField, panTextField, aadharTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;

    SignupTwo(String formno) {

        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religions = new JLabel("Religion:");
        religions.setFont(new Font("Raleway", Font.BOLD, 20));
        religions.setBounds(100, 140, 100, 30);
        add(religions);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categories = new JLabel("Category:");
        categories.setFont(new Font("Raleway", Font.BOLD, 20));
        categories.setBounds(100, 190, 200, 30);
        add(categories);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomes = new JLabel("Income:");
        incomes.setFont(new Font("Raleway", Font.BOLD, 20));
        incomes.setBounds(100, 240, 200, 30);
        add(incomes);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educational = new JLabel("Educational:");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupations = new JLabel("Occupation:");
        occupations.setFont(new Font("Raleway", Font.BOLD, 20));
        occupations.setBounds(100, 390, 200, 30);
        add(occupations);

        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel existAccount = new JLabel("Existing Account:");
        existAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existAccount.setBounds(100, 590, 200, 30);
        add(existAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existAccGroup = new ButtonGroup();
        existAccGroup.add(eyes);
        existAccGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
          String sreligion = (String) religion.getSelectedItem();
          String scategory = (String) category.getSelectedItem();
          String sincome = (String) income.getSelectedItem();
          String seducation = (String) education.getSelectedItem();
          String soccupation = (String) occupation.getSelectedItem();
          String seniorCitizen = null;
          if(syes.isSelected()) {
              seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
              seniorCitizen = "No";
        }
        String existingAccount = null;
        if(eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);

               //Signup3 Object
               setVisible(false);
               new SignupThree(formno).setVisible(true);

            } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

        new SignupTwo("");
    }
}
