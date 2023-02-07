/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author Acer
 */
public class Consultation extends JFrame implements ActionListener{

    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton sortBtn;
    JButton sortBtn1;
    JButton sortBtn2;
    JButton sortBtn3;
    JButton addConsultation;
    JButton clearFields;
    JButton availability;
    JButton deleteRow;
    JLabel label;
    JLabel label2;
    JLabel printName;
    JLabel name;
    JLabel snamePatient;
    JLabel surnamePatient;
    JLabel date;
    JLabel telNum;
    JLabel docFee;
    JLabel doctorName;
    JLabel cDate;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JTable doctorTable;
    JTable conDetails;
    JTextArea textArea;
    JLabel homePic;
    String[] doctorNames,cost;
    String pID;
    JPanel doctDetails;
    JPanel patientDetails;
    ArrayList<Doctor> docTableInfo = new ArrayList<>();
    ArrayList<String> autoDocSet = new ArrayList<>();
    HashMap<String,ArrayList<String>> map = new HashMap<>();
    
    ArrayList<Patient> patientInfo = new ArrayList<>();
    
    CardLayout c1 =new CardLayout();
    JPanel channelPanel;
    JPanel printChannelPanel;
    
    JTextField pName;
    JTextField sName;
    JTextField cNum;
    JTextField patientID;
    
    DefaultTableModel dftb2;
    
    JDateChooser dateOfBirth;
    JDateChooser dateChoose;
    JComboBox combo1;
    JComboBox combo;
    

    public Consultation() throws FileNotFoundException{
        
        //Initialise patientInfo array by loading data from text(Consultation.txt) file.
        if(patientInfo.isEmpty()){
            patientInfo=loadChannelData(patientInfo);
        }
        //Initializing the hashmap by getting date and doctors from patientInfo array
        if(map.isEmpty()){
        
           ArrayList<String> list = null;
           
            for (int i = 0; i < patientInfo.size(); i++) {
                
                
                    String doctor = patientInfo.get(i).getDocChannel();
                    String date = patientInfo.get(i).getDate();
            
            if(map.containsKey(date)){

               
                list = map.get(date);
                list.add(doctor);
                
                
            } else {
 
                list = new ArrayList<String>();
                list.add(doctor);
                map.put(date, list);
                
                }
            }
           
        
        }
        this.setSize(850,562);
        this.setTitle("Skin Consultation Manager");
        this.setLayout(new BorderLayout(0,0));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Loading home page to JPanel panel3
        mainPage();
        this.setVisible(true);
    }
    //Copying doctor array values 
    public void docInfo(ArrayList<Doctor> doctor){
        docTableInfo=doctor;
    }
    
    //All action listner method for buttons in GUI
    public void actionPerformed(ActionEvent evt){

        //Load Doctor form to panel3
        if(evt.getSource() == btn1){
                 doctorForm();
        } 
        
        //Sort Surnames of doctors in JTable doctor list     
        if(evt.getSource() == sortBtn){
             TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>();
              
               
            doctorTable.setAutoCreateRowSorter(true);
            DefaultRowSorter sorter = ((DefaultRowSorter) doctorTable.getRowSorter());
            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
            
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
            
            
        }
        //Sort Medical License Number of doctors in JTable doctor list 
         if(evt.getSource() == sortBtn1){
             TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>();
              
               
            doctorTable.setAutoCreateRowSorter(true);
            DefaultRowSorter sorter = ((DefaultRowSorter) doctorTable.getRowSorter());
            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
            
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
            
            
        }
         //Sort First Name of doctors in JTable doctor list 
        if(evt.getSource() == sortBtn2){
             TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>();
              
               
            doctorTable.setAutoCreateRowSorter(true);
            DefaultRowSorter sorter = ((DefaultRowSorter) doctorTable.getRowSorter());
            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
            
            sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
            
            
        }
        //Sort Specialisation of doctors in JTable doctor list 
        if(evt.getSource() == sortBtn3){
             TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>();
              
               
            doctorTable.setAutoCreateRowSorter(true);
            DefaultRowSorter sorter = ((DefaultRowSorter) doctorTable.getRowSorter());
            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
            
            sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
            
            
        }
        //Loads patient form to JPanel panel3
        if(evt.getSource()== btn2){
 
               patientForm();
    
        }
        //Add patient Consultation to JTable consultation list 
        if(evt.getSource()== addConsultation ){
        
           
           String p1 = pName.getText();
           String p2 = sName.getText();
           String p3 = cNum.getText();
           String p4 = (String)combo1.getSelectedItem();    
           String p6 = textArea.getText();
           //Encrypts patient Notes saved
           char[] encrypt = p6.toCharArray();
           String encryptedData="";
            for (char s : encrypt) {
                encryptedData+= ""+(s+=5);
            }

           String p5 = (String)combo.getSelectedItem();    
           
           try{
           Date d1 = dateOfBirth.getDate();
           String strDate = DateFormat.getDateInstance().format(d1);
           
           Date d2 = dateChoose.getDate();
           String strDate1 = DateFormat.getDateInstance().format(d2);
           
           //Checking on that particular date who are the doctors added 
           ArrayList<String> list = null;
           if(map.containsKey(strDate1)){

              
                   if(map.get(strDate1).contains(p5)){
            
                      int i=0;
                      //If doctor has allocated on that date reload another doctor who is available on that date
                      while(map.get(strDate1).contains(doctorNames[i])) { 
                      i++;
                      }

                      combo.setSelectedItem(doctorNames[i]);

                       p5=doctorNames[i];
                       i=0;
                  }
              
                list = map.get(strDate1);
                list.add(p5);
                
              
            } else {
                //If Theres no such date added to hashmap add both date and doctor
                list = new ArrayList<String>();
                list.add(p5);
                map.put(strDate1, list);
                
            }
           //Set text into patient details panel
           name.setText(p1);
           surnamePatient.setText(p2);
           telNum.setText(p3);
           docFee.setText(p4);
           doctorName.setText(p5);
           date.setText(strDate);
           cDate.setText(strDate1);
           
           
           //If fields are empty informing patient to fill all the details
           if(pName.getText().isEmpty()|| sName.getText().isEmpty()|| cNum.getText().isEmpty()|| textArea.getText().isEmpty() ||dateChoose.getDate()==null ||dateOfBirth.getDate()==null){
                JOptionPane.showMessageDialog(null,"Enter all the Patient details"); 
          //If fields are not empt save the details as array of objects into class patient      
          }else{
           patientInfo.add(new Patient(p5,strDate1,p1,p2,strDate,p3,encryptedData,p4));
           saveConsultation();
           JOptionPane.showMessageDialog(null,"Your Consultation has been placed succesfully!");
          }
           //If channel date and date of birth is empty inform patient to select the dates
           }catch(NullPointerException e){
               JOptionPane.showMessageDialog(null,"Enter all the Patient details");  
           
           }

            /*for (Patient patient : patientInfo) {
                System.out.println(patient.toString());
            }*/
       
        //When clear button clicked to set the field to be empty        
        }if(evt.getSource()==clearFields){
        
             pName.setText(null);
             sName.setText(null);
             dateOfBirth.setCalendar(null);
             cNum.setText(null);
             dateChoose.setCalendar(null);
             combo.setSelectedItem(doctorNames[0]);
             combo1.setSelectedItem(cost[0]);
             
             name.setText("             ");
             surnamePatient.setText("              ");
             date.setText("            ");
             telNum.setText("          ");
             docFee.setText("       ");
             doctorName.setText("                                    ");
             cDate.setText("          ");
             textArea.setText("          ");
        }
        //Check the particular date the doctor is available or not
        if(evt.getSource()==availability){
            
          String p5 = (String)combo.getSelectedItem();    
           
          try{
          Date d2 = dateChoose.getDate();
          String strDate1 = DateFormat.getDateInstance().format(d2);
           
         
          ArrayList<String> list = null;
              
           if(map.containsKey(strDate1)){

                  int i;
                  if(map.get(strDate1).contains(p5)){
                      //if  doctor not available inform
                      JOptionPane.showMessageDialog(null,"Doctor is not Available!");
                      i=0;
                      while(map.get(strDate1).contains(doctorNames[i])) {
                      
                      i++;
                      }

                      combo.setSelectedItem(doctorNames[i]);
                       p5=doctorNames[i];
                       i=0;
                  }
                  
                //if  doctor available inform
                JOptionPane.showMessageDialog(null,"Doctor Available!");  
                list = map.get(strDate1);
            
                
            } else {
                //If the particular date is not in slots display doctor available
                JOptionPane.showMessageDialog(null,"Doctor Available!");
                list = new ArrayList<String>();
                list.add(p5);
            }
           //If dates not selected in patient form inform
           }catch(NullPointerException e){
               JOptionPane.showMessageDialog(null,"Select a Date!");  
           
           }
          

        }
        //Remove panel3 components and load the home page
        if(evt.getSource()==btn3){    
            
            panel3.removeAll();    
            panel3.add(homePic);
            super.revalidate();
            super.repaint();
     
        }
        //Load the consultation panel to panel3 and viewing the added consultations
        if(evt.getSource()==btn4){

           consultationDetails();
           
        }
        //Get the Patient  ID and delete the consultation you want 
        if(evt.getSource()==deleteRow){
        
           String pId = patientID.getText();
           
           
           for (int i = 0; i < patientInfo.size(); i++) {
             //Get contact Patient Id and delete the consultation
           
               if(dftb2.getValueAt(i, 0).equals(pId)){

                 patientInfo.remove(i);
                 dftb2.removeRow(i);
                 System.out.println("Consultation has been removed successfully!");
                 break;
             }
        }
           //Save the consultation to the JLabel after record deleted
           saveConsultation();
        }
        
        
    }
    
     
        //Main page Panel
        public void mainPage(){
  
         
        label = new JLabel("\t\tWestminster Skin Consultation Manager\t\t");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        label.setSize(300,200);
        
        panel1= new JPanel();
        panel2= new JPanel();
        panel3= new JPanel();
        
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER,60,50));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,60,20));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        panel1.setPreferredSize(new Dimension(150,520));
        panel2.setPreferredSize(new Dimension(850,95)); 
        panel3.setPreferredSize(new Dimension(665,415));
        panel1.setBackground(new Color(39,60,117));
        panel2.setBackground(new Color(47, 54, 64));
        panel3.setBackground(Color.BLACK);
        
        btn1= new JButton("     Doctor     ");
        btn1.addActionListener(this);
        btn2 = new JButton("    Patient     ");
        btn2.addActionListener(this);
        btn3 = new JButton("      Home      ");
        btn3.addActionListener(this);
        btn4 = new JButton("Consultations");
        btn4.addActionListener(this);
        btn1.setBackground(new Color(0, 151, 230));
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Serif", Font.BOLD, 16));
        btn2.setBackground(new Color(0, 151, 230));
        btn2.setFont(new Font("Serif", Font.BOLD, 16));
        btn2.setForeground(Color.WHITE);
        btn3.setBackground(new Color(0, 151, 230));
        btn3.setFont(new Font("Serif", Font.BOLD, 16));
        btn3.setForeground(Color.WHITE);
        btn4.setBackground(new Color(0, 151, 230));
        btn4.setFont(new Font("Serif", Font.BOLD, 16));
        btn4.setForeground(Color.WHITE);
        
       
        this.add(panel1,BorderLayout.WEST);
        this.add(panel2,BorderLayout.NORTH);
        this.add(panel3,BorderLayout.CENTER);
               
        ImageIcon image = new ImageIcon(getClass().getResource("mainImage_1.jpg"));
        homePic = new JLabel(image);       
        
        panel3.add(homePic);
        panel1.add(btn1);
        panel1.add(btn2);  
        panel1.add(btn4);
        panel1.add(btn3);
        panel2.add(label);

    }

    
    //Doctor Form Panel
    public void doctorForm(){
    
                //Remove all the components from panel3
                panel3.removeAll();
                //Columnn names for JTable doctor
                String[] colNames={"Medical License No","NAME","Surname","Specialisation"};
                
                DefaultTableModel dftb = new DefaultTableModel(colNames,0);
     
                doctorTable = new JTable(dftb);
                doctorTable.setPreferredScrollableViewportSize(new Dimension(650,135));
                doctorTable.setRowHeight(30);
              
                //Populate JTable doctor 
                for(int i =0;i<docTableInfo.size();i++){
                   String licenseNo= docTableInfo.get(i).getMediLicenceNum();
                   String name= docTableInfo.get(i).getName();
                   String sName= docTableInfo.get(i).getSurname();
                   String specialisation= docTableInfo.get(i).getSpecialisation();
                   
                   Object[] info ={licenseNo,name,sName,specialisation};
                   
                   dftb.addRow(info);
                   
                }
               
                
                sortBtn = new JButton("Sort Surname");
                sortBtn.addActionListener(this);
                
                sortBtn1 = new JButton("Sort M-License Number");
                sortBtn1.addActionListener(this);
                
                sortBtn2 = new JButton("Sort First Name");
                sortBtn2.addActionListener(this);
                
                sortBtn3 = new JButton("Sort Specialisation");
                sortBtn3.addActionListener(this);
                

                doctDetails = new JPanel();
                doctDetails.setBackground(new Color(74, 105, 189));
                doctDetails.setPreferredSize(new Dimension(680,420));
                doctDetails.setLayout(new FlowLayout(FlowLayout.CENTER,18,35));  
                
                JLabel doctorList = new JLabel("Doctor List");
                doctorList.setFont(new Font("Serif", Font.BOLD, 30));
                doctorList.setForeground(Color.WHITE);
                
                JScrollPane scroll = new JScrollPane(doctorTable);
                scroll.setLocation(400, 500);
                
                 ImageIcon image = new ImageIcon(getClass().getResource("dociUi.png"));
                 JLabel docImage = new JLabel(image);
                
                doctDetails.add(doctorList);
                doctDetails.add(docImage);
                doctDetails.add(scroll);
                doctDetails.add(sortBtn1);
                doctDetails.add(sortBtn2);
                doctDetails.add(sortBtn);
                doctDetails.add(sortBtn3);
                doctDetails.setVisible(true);
                
                panel3.add(doctDetails);

                //Refresh the panel after adding components
                super.revalidate();
                super.repaint();
                
                
       
    } 
    
    public void patientForm(){
    
        //Remove all the components from panel3
        panel3.removeAll();    
          
        patientDetails = new JPanel();         
        patientDetails.setBackground(Color.GRAY);
        patientDetails.setLayout(new BorderLayout(0,0));
        
        channelPanel = new JPanel();
        channelPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,14));
        channelPanel.setBackground(new Color(74, 105, 189));
        channelPanel.setPreferredSize(new Dimension(683,310));

        printChannelPanel = new JPanel();
        printChannelPanel.setLayout(new FlowLayout(FlowLayout.LEFT,15,4));  
        printChannelPanel.setPreferredSize(new Dimension(683,135));        
          
        patientDetails.add(channelPanel,BorderLayout.NORTH);
        patientDetails.add(printChannelPanel,BorderLayout.SOUTH);
            
        JLabel channel = new JLabel("Doctor  Channel");
        channel.setFont(new Font("Serif", Font.BOLD, 28));
        channel.setForeground(Color.WHITE);
        
        JLabel selectDoc = new JLabel("Select Doctor");
        selectDoc.setFont(new Font("Serif", Font.BOLD, 15));
        selectDoc.setForeground(Color.WHITE);
        
        JLabel selectTime = new JLabel("Select Date        ");
        selectTime.setFont(new Font("Serif", Font.BOLD, 15));
        selectTime.setForeground(Color.WHITE);
        
        
        doctorNames = new String[docTableInfo.size()];
        
        for (int i = 0; i < docTableInfo.size(); i++) {
            
            String name = docTableInfo.get(i).getName();
            String sName = docTableInfo.get(i).getSurname();
            doctorNames[i]= "Dr"+" "+name+" "+sName;
        }
        //Load doctor first name and surname to combo box
        combo = new JComboBox(doctorNames);        
        combo.setPreferredSize(new Dimension(150,25));

        dateChoose = new JDateChooser();
        dateChoose.setPreferredSize(new Dimension(150,25));
        
        JLabel patientName = new JLabel("Patient Name");
        patientName.setFont(new Font("Serif", Font.BOLD, 15));
        patientName.setForeground(Color.WHITE);
        //Gives Patient to type the name 
        pName = new JTextField();
        pName.setPreferredSize(new Dimension(150,25));
        
        JLabel surname = new JLabel("Patient Surname");
        surname.setFont(new Font("Serif", Font.BOLD, 15));
        surname.setForeground(Color.WHITE);
        //Gives Patient to type the Surname 
        sName = new JTextField();
        sName.setPreferredSize(new Dimension(150,25));
        
        JLabel DOB = new JLabel("Date Of Birth");
        DOB.setFont(new Font("Serif", Font.BOLD, 15));
        DOB.setForeground(Color.WHITE);
        //Gives Patient select the date of birth
        dateOfBirth = new JDateChooser();
        dateOfBirth.setPreferredSize(new Dimension(150,25));
        
        JLabel contactNumber = new JLabel("Contact Number");
        contactNumber.setFont(new Font("Serif", Font.BOLD, 15));
        contactNumber.setForeground(Color.WHITE);
        //Gives Patient to type the contact Number 
        cNum = new JTextField();
        cNum.setPreferredSize(new Dimension(150,25));
        
        JLabel notes = new JLabel("Notes            ");
        notes.setFont(new Font("Serif", Font.BOLD, 15));
        notes.setForeground(Color.WHITE);
        //Gives Patient to type notes 
        textArea= new JTextArea();
        textArea.setPreferredSize(new Dimension(150,75));
        
        JScrollPane textScroll = new JScrollPane(textArea);
        textScroll.setPreferredSize(new Dimension(150,65));
        
        
        JLabel costHrs = new JLabel("Cost(Per hour)   ");
        costHrs.setFont(new Font("Serif", Font.BOLD, 15));
        costHrs.setForeground(Color.WHITE);
        
       
        JLabel adjustR = new JLabel("");
        adjustR.setPreferredSize(new Dimension(150,0));
        JLabel adjustL = new JLabel("");
        adjustL.setPreferredSize(new Dimension(150,0));
 
        //Initialise array for cost
        cost = new String[4];
        
        cost[0]="£15(1hrs) First Channel";
        cost[1]="£25(1hrs)";
        cost[2]="£50(2hrs)";
        cost[3]="£50(3hrs)";
        
        combo1 = new JComboBox(cost);
        
        combo1.setPreferredSize(new Dimension(140,25));
        
        addConsultation = new JButton("Add Consultation");
        addConsultation.addActionListener(this);
        clearFields = new JButton("Clear");
        clearFields.addActionListener(this);
        
        availability = new JButton("Check Availability");
        availability.addActionListener(this);
        
        //load image to channel panel
        ImageIcon image = new ImageIcon(getClass().getResource("dCl_prev.png"));

        JLabel dChannel = new JLabel(image);
        
        channelPanel.add(adjustR);
        channelPanel.add(channel);
        channelPanel.add(dChannel);
        channelPanel.add(adjustL);
        channelPanel.add(selectDoc);
        channelPanel.add(combo);
        channelPanel.add(selectTime);
        channelPanel.add(dateChoose); 
        channelPanel.add(patientName);
        channelPanel.add(pName);
        channelPanel.add(surname);
        channelPanel.add(sName);
        channelPanel.add(DOB);
        channelPanel.add(dateOfBirth);
        channelPanel.add(contactNumber);
        channelPanel.add(cNum);
        channelPanel.add(notes);
        channelPanel.add(textScroll);
        channelPanel.add(costHrs);
        channelPanel.add(combo1);
        channelPanel.add(availability);
        channelPanel.add(addConsultation);
        channelPanel.add(clearFields);
                
        JLabel conDetails = new JLabel("Channel Details");
        conDetails.setFont(new Font("Serif", Font.BOLD, 20));
        conDetails.setForeground(Color.BLACK);
        
        printName = new JLabel("First Name:     ");
        printName.setFont(new Font("Serif", Font.BOLD, 15));
        printName.setForeground(Color.BLACK);
        
        name = new JLabel("             ");
        name.setFont(new Font("Serif", Font.PLAIN, 15));
        name.setForeground(Color.BLACK);
        
        snamePatient = new JLabel("Surname: ");
        snamePatient.setFont(new Font("Serif", Font.BOLD, 15));
        snamePatient.setForeground(Color.BLACK);
        
        surnamePatient = new JLabel("              ");
        surnamePatient.setFont(new Font("Serif", Font.PLAIN, 15));
        surnamePatient.setForeground(Color.BLACK);
        
        JLabel blank = new JLabel("            ");
        blank.setFont(new Font("Serif", Font.PLAIN, 15));
        blank.setPreferredSize(new Dimension(200,0));
        
        JLabel blank1 = new JLabel("            ");
        blank1.setFont(new Font("Serif", Font.PLAIN, 15));
        blank1.setPreferredSize(new Dimension(30,0));
        
        JLabel dOfBirth = new JLabel("Date Of Birth: ");
        dOfBirth.setFont(new Font("Serif", Font.BOLD, 15));
        dOfBirth.setForeground(Color.BLACK);
        
        date = new JLabel("            ");
        date.setFont(new Font("Serif", Font.PLAIN, 15));
        date.setForeground(Color.BLACK);
        
        JLabel blank2 = new JLabel("            ");
        blank2.setFont(new Font("Serif", Font.PLAIN, 15));
        blank2.setPreferredSize(new Dimension(50,0));
        
        
        JLabel contactNum = new JLabel("Contact Number: ");
        contactNum.setFont(new Font("Serif", Font.BOLD, 15));
        contactNum.setForeground(Color.BLACK);
        
        telNum = new JLabel("          ");
        telNum.setFont(new Font("Serif", Font.PLAIN, 15));
        telNum.setForeground(Color.BLACK);
        
        
        JLabel costChannel = new JLabel("Cost: ");
        costChannel.setFont(new Font("Serif", Font.BOLD, 15));
        costChannel.setForeground(Color.BLACK);
        
        docFee = new JLabel("       ");
        docFee.setFont(new Font("Serif", Font.PLAIN, 15));
        docFee.setForeground(Color.BLACK);
                
        JLabel blank3 = new JLabel("            ");
        blank3.setFont(new Font("Serif", Font.PLAIN, 15));
        blank3.setPreferredSize(new Dimension(198,0));
        
        JLabel docName = new JLabel("Doctor: ");
        docName.setFont(new Font("Serif", Font.BOLD, 15));
        docName.setForeground(Color.BLACK);
        
        doctorName = new JLabel("                                    ");
        doctorName.setFont(new Font("Serif", Font.PLAIN, 15));
        doctorName.setForeground(Color.BLACK);
                
        JLabel channelDate = new JLabel("Date: ");
        channelDate.setFont(new Font("Serif", Font.BOLD, 15));
        channelDate.setForeground(Color.BLACK);
        
        cDate = new JLabel("          ");
        cDate.setFont(new Font("Serif", Font.PLAIN, 15));
        cDate.setForeground(Color.BLACK);
        
        JLabel blank4 = new JLabel("            ");
        blank4.setPreferredSize(new Dimension(70,0));
        
        JLabel blank5 = new JLabel("");
        blank5.setPreferredSize(new Dimension(250,0));
        
        JLabel blank6 = new JLabel("");
        blank6.setPreferredSize(new Dimension(250,0));
        
        printChannelPanel.add(blank5);
        printChannelPanel.add(conDetails);
        printChannelPanel.add(blank6);
        printChannelPanel.add(printName);
        printChannelPanel.add(name);
        printChannelPanel.add(blank1);
        printChannelPanel.add(dOfBirth);
        printChannelPanel.add(date);
        printChannelPanel.add(blank);
        printChannelPanel.add(snamePatient);
        printChannelPanel.add(surnamePatient);
        printChannelPanel.add(blank2);
        printChannelPanel.add(contactNum);
        printChannelPanel.add(telNum);
        printChannelPanel.add(blank3);
        printChannelPanel.add(docName);
        printChannelPanel.add(doctorName);
        printChannelPanel.add(channelDate);
        printChannelPanel.add(cDate);
        printChannelPanel.add(blank4);
        printChannelPanel.add(costChannel);
        
        printChannelPanel.add(docFee);
        
        
        panel3.add(patientDetails);   
        //refresh panel
        super.revalidate();
        super.repaint(); 
    
    }
    //Consultations panell
    private void consultationDetails() {
        
                panel3.removeAll(); 
                
                panel4= new JPanel();
        
                String[] colNames2={"PID","Doctor","Channel Date","Patient Name","Surname","DOB","Contact","Note","Cost"};

                dftb2 = new DefaultTableModel(colNames2,0);
                
     
                conDetails = new JTable(dftb2);
                conDetails.setModel(dftb2);
                conDetails .setPreferredScrollableViewportSize(new Dimension(655,135));
                conDetails .setRowHeight(30);
              
                //load all the consultations that have been saved into Jtable
                for(int i =0;i<patientInfo.size();i++){
                   String docName = patientInfo.get(i).getDocChannel();
                   String date= patientInfo.get(i).getDate();
                   String pName= patientInfo.get(i).getName();
                   String sName= patientInfo.get(i).getSurname();
                   String dob= patientInfo.get(i).getDob();
                   String cNum= patientInfo.get(i).getContactNum();
                   String cost= patientInfo.get(i).getCost();
                   String note= patientInfo.get(i).getNote();
                   pID= "P00"+(i+1);
                   Object[] info1 ={pID,docName,date,pName,sName,dob,cNum,note,cost};
                   
                   dftb2.addRow(info1);
                   
                }
                
                JLabel phoneDel= new JLabel("Enter Patient ID:  ");
                JLabel gap= new JLabel("        ");
                phoneDel.setFont(new Font("Serif", Font.BOLD, 16));
                phoneDel.setForeground(Color.WHITE);
                
                patientID = new JTextField("");
                patientID.setPreferredSize(new Dimension(180,25));
                
                deleteRow = new JButton("Delete Consultation");
                deleteRow.setFont(new Font("Serif", Font.BOLD, 16));
                deleteRow.setForeground(Color.red);
                deleteRow.addActionListener(this);
                
                panel4.setBackground(new Color(74, 105, 189));
                panel4.setPreferredSize(new Dimension(680,420));
                panel4.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
  
                JLabel consultations = new JLabel("Consultations");
                consultations.setFont(new Font("Serif", Font.BOLD, 30));
                consultations.setForeground(Color.WHITE);
                ImageIcon image = new ImageIcon(getClass().getResource("consiprevUI.png"));
                JLabel channelImage = new JLabel(image);
                
                JScrollPane scroll = new JScrollPane(conDetails);
                scroll.setLocation(400, 500);
                
                panel4.add(consultations);
                panel4.add(channelImage);
                panel4.add(scroll);
                panel4.add(phoneDel);
                panel4.add(patientID);
                panel4.add(gap);
                panel4.add(deleteRow);
                panel4.setVisible(true);
                panel3.add(panel4);
                //Refresh page
                super.revalidate();
                super.repaint();
    }
    //Save consultation details in text file "Consultation.txt"
    public void saveConsultation(){
          
         try {
        FileWriter myWriter = new FileWriter("D:\\Consultation.txt");
        
        
        for (Patient printlist : patientInfo) {
             myWriter.write(printlist.toString()+"\n");
             
         }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
    }
    //get saved data in "Consultation.txt" Array again
    private static ArrayList<Patient> loadChannelData(ArrayList<Patient> patientInfo) throws FileNotFoundException  {
        
        
        File file = new File("D:\\Consultation.txt");
        Scanner readFile = new Scanner(file);
        
        StringTokenizer  token= null;
        
        //Using tokens get the relevant details, passing  as arguments into array of objects 
        String docChannel ="";
        String date ="";
        String name ="";
        String surname ="";
        String dob ="";
        String contactNum ="";
        String note="";
        String cost="";
        
        
        
        
        while(readFile.hasNextLine()){
        token = new StringTokenizer(readFile.nextLine(),"||");
        
        docChannel =token.nextToken();
        date =token.nextToken();
        name =token.nextToken();    
        surname =token.nextToken();
        dob =token.nextToken();
        contactNum =token.nextToken();
        note =token.nextToken();
        cost =token.nextToken();
        
        
       patientInfo.add(new Patient(docChannel,date,name,surname,dob,contactNum,note,cost));
        
        }
       return patientInfo;
    } 

    
   
}
