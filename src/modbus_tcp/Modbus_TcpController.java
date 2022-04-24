/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package modbus_tcp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;
import java.awt.Desktop;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 *
 * @author TE326187
 */
public class Modbus_TcpController implements Initializable {
            ModbusClient modbusClient;

    @FXML
    private TextField Acoil;

    @FXML
    private TextField Ainput;

    @FXML
    private TextField Areg;

    @FXML
    private Button Connect;

    @FXML
    private Button Disconnect;

    @FXML
    private TextField IP;

    @FXML
    private TextField PORT;

    @FXML
    private TextField Vcoil;

    @FXML
    private TextField Vinput;

    @FXML
    private TextField Vreg;  
    @FXML
    private Button Linkedin;
    @FXML
    private Button How;
    
    @FXML
    private void Connect(ActionEvent event)  {
        try {
        modbusClient = new ModbusClient(IP.getText(),Integer.parseInt(PORT.getText()));
        modbusClient.Connect();
        if (modbusClient.isConnected()) {
        Connect.setDisable(true);
        IP.setDisable(true);
        PORT.setDisable(true);
        }
        
        }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }
        
    }
    
     @FXML
    private void Disconnect(ActionEvent event) throws IOException {
try{
        modbusClient.Disconnect();
        
        Connect.setDisable(false);
        IP.setDisable(false);
        PORT.setDisable(false);
     
        }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }
        
        
    }
     @FXML
    private void wCoils(ActionEvent event)  {
        
        
        if (!Connect.isDisabled()){
        
        JOptionPane.showMessageDialog(null, "PLC Not Connected Yet! ");
        }
        else {
  try {

     modbusClient.WriteSingleCoil(Integer.parseInt(Acoil.getText()), Boolean.parseBoolean(Vcoil.getText()));
         }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }       catch (ModbusException ex) {
         JOptionPane.showMessageDialog(null,ex);
                }
        }
    }
     @FXML
    private void rCoils(ActionEvent event)  {
 
         if (!Connect.isDisabled()){
        
        JOptionPane.showMessageDialog(null, "PLC Not Connected Yet! ");
        }else{
        try{
        Vcoil.setText(String.valueOf(modbusClient.ReadCoils(Integer.parseInt(Acoil.getText()), 1)[0]));

         }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }       catch (ModbusException ex) {
         JOptionPane.showMessageDialog(null,ex );
                }
    }}
     @FXML
    private void rinputs(ActionEvent event)   {
  if (!Connect.isDisabled()){
        
        JOptionPane.showMessageDialog(null, "PLC Not Connected Yet! ");
        }else{
        try{
    Vinput.setText(String.valueOf(modbusClient.ReadDiscreteInputs(Integer.parseInt(Ainput.getText()), 1)[0]));

         }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }       catch (ModbusException ex) {
         JOptionPane.showMessageDialog(null,ex );
                }
    }}
    @FXML
    private void Rregi(ActionEvent event)  {
  if (!Connect.isDisabled()){
        
        JOptionPane.showMessageDialog(null, "PLC Not Connected Yet! ");
        }else{
        try{
        Vreg.setText(String.valueOf(modbusClient.ReadHoldingRegisters(Integer.parseInt(Areg.getText()), 1)[0]));
         }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }       catch (ModbusException ex) {
         JOptionPane.showMessageDialog(null,ex );
                }
    }}
     @FXML
    private void Wregi(ActionEvent event)  {
  if (!Connect.isDisabled()){
        
        JOptionPane.showMessageDialog(null, "PLC Not Connected Yet! ");
        }else{
        try{
modbusClient.WriteSingleRegister(Integer.parseInt(Areg.getText()), Integer.parseInt(Vreg.getText()));
         }catch(IOException e) {
            
         JOptionPane.showMessageDialog(null,e );

        
        }       catch (ModbusException ex) {
         JOptionPane.showMessageDialog(null,ex );
                }
    }}
    @FXML
    public void linkdin (ActionEvent event) {
      try {
        Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/hussin-tsouli-1322361a3/").toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @FXML
    public void Tutorial (ActionEvent event) {
     try {
        Desktop.getDesktop().browse(new URL("https://youtu.be/XfqZb63LNwc").toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

    }    
    
}
