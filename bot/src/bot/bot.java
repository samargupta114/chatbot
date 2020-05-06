package hack2020;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.LabelUI;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.lang.Math;

public class bot extends JFrame implements KeyListener{
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(15,50);
	JTextArea input=new JTextArea(5,50);
//	JButton button = new JButton("EXIT");
	
		JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
	);
		


	
	String[][] chatBot={
		//standard greetings
		{"HI","HELLO", "HOLA", "OLA ", "hi","hello","hallo","HALLO","hola","ola","howdy", "hey"},
		{ "Hey there , I'm VIKI your personal healthcare assistant \n \tHow are you feeling today ? \n \t a. BAD \n  \t b.VERYBAD \n  \t c. SOMETHING ELSE "},
		
		{ "bad", "verybad", "something else", "BAD", "VERY BAD", "SOMETHING ELSE"},
		{"What discomfort are you feeling \n \t Choose from the following options?? \n \t a) HEADACHE \n \t b) COUGH \n \t c) MUSCLE PAIN "},
		//headache
		
		{"headache", "HEADACHE"},
		{"I,m sorry to hear that , What kind of headache ?? \n" 
				+ "\t1) Headache over temple?? {type temple} \n"
				+ "\t2) Sinus headache(pain in facial sinuses)? {type sinus} \n" 
				+ "\t3) Temporal headache? {type temporal}"},
		//headache over temples
		
		{"temple"}, 
		{"OK ! I just need a little more information. \n" + "\tPlease select any of the following \n"+ "\t1.one or both side of my forehead \n" + "\t2.at the back \n" + "\t3. On one side \n" + "\t4. All over \n" + "\t5.Somewhere else \n" }, 
		
		//sinus headache
		{"sinus"},
		{"OK ! I just need a little more information. \n" + "\tPlease select any of the following \n"+ "\t1.one or both side of my forehead \n" + "\t2.at the back \n" + "\t3. On one side \n" + "\t4. All over \n" + "\t5.Somewhere else \n" }, 
		
		//temporal headache
		{"temporal"},
		{"OK ! I just need a little more information. \n" + "\tPlease select any of the following \n"+ "\t1.one or both side of my forehead \n" + "\t2.at the back \n" + "\t3. On one side \n" + "\t4. All over \n" + "\t5.Somewhere else \n" }, 
		
		{"1", "2", "3", "4", "5", "1 ", "2 ", "3 ", "4 ","5 "},
		{"Is this the worst headache you can imagine \n" + "\tyes"  + "\n\tno" },
		
		//ans for yes
		{"yes", "YES", "yes"},
		{"Does your headache come and go , or is it there all the time?"},
		
		{"no", "NO"},
		{"Does your headache come and go or is it there all the time ?"},
		
		{"come and go", "It's there all the time", "it's there all the time", "it comes and goes" , "all the time"},
		{"OK WE UNDERSTAND YOUR CONDITION \n" + "\tKindly tell us your location. \n" + "\teast delhi \t" + "north delhi \t" + "south delhi \t" + "west delhi \t"}, 
		
		{"east delhi", "EAST DELHI"}, 
		{"WE ARE PROVIDING YOU WITH THE BEST PANEL OF DOCTORS IN YOUR AREA \n"+ "\tDr. Amit Batra\r\n" + 
				"\tAddress: Mangalam Cardio Neuro Clinic, 66, Vikas Marg, Opposite Deepak Memorial, Hargobind Enclave, Karkardooma, Delhi, 110092\r\n" + 
				"\tPhone: 099996 62292"+
				" Do You need any more assistance ? Type 'start' for yes , 'end' for no"},
		
		
		
		{"north delhi", "NORTH DELHI"}, 
		{ "WE ARE PROVIDING YOU WITH THE BEST PANEL OF DOCTORS IN YOUR AREA \n"+ 
				"\tDr Vipin Satija\r\n" + 
				"\tAddress: Agrawal medical centre, 2, Ashok Vihar Phase 1 Rd, Ashok Vihar II, " +
				" Pocket C 2, Phase 2, Ashok Vihar, Delhi, 110052\r\n" + 
				"\tPhone: 095400 99633"}, 
		
		{"south delhi", "SOUTH DELHI"}, 
		{"WE ARE PROVIDING YOU WITH THE BEST PANEL OF DOCTORS IN YOUR AREA \n" + 
				"\tDr. Sumanto Chatterjee\r\n" + 
				"\tAddress: E791, Bipin Chandra Pal Marg, Block E, Chittaranjan, New Delhi, Delhi 110019\r\n" + 
				"\tPhone: 081302 21560"}, 
		
		{"west delhi", "WEST DEHLI"} , 
		{ "WE ARE PROVIDING YOU WITH THE BEST PANEL OF DOCTORS IN YOUR AREA \n"+ "\tDr. Sweta Singla\r\n" + 
				"\tAddress: C-2, 144, Major P Srikumar Marg, Block C4A, Block C2C, Janakpuri, New Delhi, Delhi 110058\r\n" + 
				"\tPhone: 011 2808 2828"}, 
		{"start"},
		{"What discomfort are you feeling \n \t Choose from the following options?? \n \t a) HEADACHE \n \t b) COUGH \n \t c) MUSCLE PAIN"},
		
		{"end" } , 
		{ "Your welcome. It's our pleasure to help you "} ,
		
		//cough
		{"cough", "COUGH"},
		{"I,m sorry to hear that , What kind of COUGH ?? \n" 
				+ "\t1) Coughing {type intense} \n"
				+ "\t2) Coughing blood? {type bloody} \n" 
				+ "\t3) Coughing at night? {type nighty}"},
	   
		{"intense","bloody","nighty"},
		{"OK ! I just need a little more information. \n" + "\tPlease select any of the following \n"+ "\tI.Clear or White phlegm (type clear phlegm) \n" + "\tII.Yellow, green, or brown phlegm (type colorful phlegm)\n" + "\tIII. Blood (type blood)\n" },
		
		{"blood", "clear phlegm", "colorful phlegm"}, 
		{"Is this the worst Cough you can imagine \n" + "\tFOR YES TYPE ya"  + "\n\tFOR NO TYPE nah" },
		
		{"ya", "yaa", "nah"} , 
		{"Does your Cough come and go or is it there all the time ?"},
		
		//MUSCLE PAIN
		{"MUSCLE PAIN", "muscle pain"}, 
		{"I,m sorry to hear that , What kind of MUSCLE PAIN ?? \n" 
				+ "\t1) Aching muscles ?{type aching} \n"
				+ "\t2) Cramping muscles? {type cramp} \n" 
				+ "\t3) Muscle tightness? {type tightness}"},
		
		{"aching", "cramp", "tightness"},
		{"OK ! I just need a little more information. \n" + "\tPlease select any of the following \n"+ "\tI.Proble in Biscep (type biceps) \n" + "\tII.Problem in Tricep (type triceps)\n" + "\tIII. Problem in Shoulder (type shoulder)\n" },
		
		{"biceps","triceps","shoulder"} , 
		{"Is this the worst Muscle pain you can imagine \n" + "\tFOR YES TYPE-: true"  + "\n\tFOR NO TYPE-: false" },
		
		{"true", "false", "TRUE", "FALSE"} , 
		{"Does your Cough come and go or is it there all the time ?"},
		
		//question greetings
		{"how are you","how r you","how r u","how are u"},
		{"good","doing well"},
		//yes
		{"yes"},
		{"no","NO","NO!!!!!!!"},
		//default
		{"pls correct your option/choice", "You may have typed wrong", " Kindly Check your reply ", 
		"(VINY IS NOT ABLE TO REPLY . PLEASE CHECK YOUR REPLY)"}
		//asking
		
		
	};
	
//	public void BackImage() {
//		setSize(600,400);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//
//		setLayout(new BorderLayout());
//	setContentPane(new JLabel(new ImageIcon("Desktop/how-chatbots-and-ai-are-changing-the-healthcare-industry_1")));
//	setLayout(new FlowLayout());
//	JLabel L1 = new JLabel();
//	add(L1);
//	setSize(600,400);
//	
//	}
	
//	public void Background(bot var) {
//		this.var= var;
//		image = (new ImageIcon("https://www.scnsoft.com/blog-pictures/healthcare/how-chatbots-and-ai-are-changing-the-healthcare-industry_1.png").getImage());
//	}
//	
	
	
	public static void main(String[] args){
		new bot();
	}
	
	
	public bot(){
		super("VINY - HEALTHCARE CHATBOT");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false); //isko nahi chedna
		input.addKeyListener(this);
		
		
		
//		setLayout(new BorderLayout());
//		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Parth Bhutani\\Desktop\\kjkj.png")));
//		setLayout(new FlowLayout());
//	JLabel L1= new JLabel();
//		add(L1);
//	  setSize(600,400);
		
		p.add(scroll);
		p.add(input);
	p.setBackground(new Color(0,200,200));
	
	
		add(p);
		
		setVisible(true);
//for background
		dialog.setBackground(getBackground());
		
		
		
		
		
	
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote.trim();
			byte response=0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			int j=0;//which group we're checking
			while(response==0){
				if(inArray(quote.toLowerCase(),chatBot[j*2])){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n-->VINY\t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatBot.length-1 && response==0){
					response=1;
				}
			}
			
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n-->VINY\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}
		
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
}