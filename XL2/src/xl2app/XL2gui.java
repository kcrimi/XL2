package xl2app;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class XL2gui extends JFrame {
	ProjectController project;
	JPanel contentPane;
	JTabbedPane projectPane;
	JLabel lblProjectTitle;
	PhasePanel phasePanel;
	RevenuePanel revenuePanel;
	CostPanel costPanel;
	FundingPanel fundingPanel;
	JMenuItem 
		mntmNew,
		mntmSaveCtrls,
		mntmSaveAs,
		mntmOpenCtrlo,
		mntmClose,
		mntmExitCtrlq,
		mntmCashFlowSummary,
		mntmBudgetReport,
		mntmViewFullExcel,
		mntmUserManual;
	JMenu mnReports, mnHelp;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XL2gui frame = new XL2gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public XL2gui() {
		project = new ProjectController(this);
		
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("bin/icon.jpg"));
		setTitle("XL2");
		setBounds(100, 100, 650, 536);
		
		//Set the default closing method to the one in the projectController
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				((XL2gui) we.getSource()).project.exit();
			}
		});
		
		//Create Menu Bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Create File Menu
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.newProject();
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
				
		mntmSaveCtrls = new JMenuItem("Save");
		mntmSaveCtrls.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				project.save();
			}
		});
		mntmSaveCtrls.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSaveCtrls.setEnabled(true);
		mnFile.add(mntmSaveCtrls);
		
		mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.saveAs();
			}
		});
		mntmSaveAs.setEnabled(true);
		mnFile.add(mntmSaveAs);
		
		mntmOpenCtrlo = new JMenuItem("Open");
		mntmOpenCtrlo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				project.open();
			}
		});
		mntmOpenCtrlo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpenCtrlo);
		
		JMenu mnOpenRecent = new JMenu("Open Recent");
		mnOpenRecent.setEnabled(false);
		mnFile.add(mnOpenRecent);
		
		mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.closeProject();
			}
		});
		mnFile.add(mntmClose);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		mntmExitCtrlq = new JMenuItem("Exit");
		mntmExitCtrlq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.exit();
			}
		});
		mntmExitCtrlq.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnFile.add(mntmExitCtrlq);
		
		mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		mntmCashFlowSummary = new JMenuItem("Cash Flow Summary");
		mntmCashFlowSummary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.cashFlowSummary();
			}
		});
		mnReports.add(mntmCashFlowSummary);
		
		mntmBudgetReport = new JMenuItem("Budget Report");
		mntmBudgetReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.budgetSummary();
			}
		});
		mnReports.add(mntmBudgetReport);
		
		JMenuItem mntmSensitivityAnalysis = new JMenuItem("Sensitivity Analysis");
		mntmSensitivityAnalysis.setEnabled(false);
		mnReports.add(mntmSensitivityAnalysis);
		
		JSeparator separator_1 = new JSeparator();
		mnReports.add(separator_1);
		
		mntmViewFullExcel = new JMenuItem("View Full Excel Model");
		mntmViewFullExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.excelView();
			}
		});
		mnReports.add(mntmViewFullExcel);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmUserManual = new JMenuItem("User Manual");
		mntmUserManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.userManual();
			}
		});
		mnHelp.add(mntmUserManual);
		
		//END MENU BAR
		
		//Create Content Pane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		lblProjectTitle = new JLabel("File Name Place Holder");
		lblProjectTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProjectTitle.setForeground(new Color(230, 230, 250));
		lblProjectTitle.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblProjectTitle.setVisible(false);
		contentPane.add(lblProjectTitle);
		
		projectPane = new JTabbedPane(JTabbedPane.LEFT);
		projectPane.setFont(new Font("Calibri", Font.PLAIN, 16));
		projectPane.setVisible(false);
		contentPane.add(projectPane);
		
		phasePanel = new PhasePanel(project);
		phasePanel.setBorder(null);
		projectPane.addTab("Phases", null, phasePanel, null);
		phasePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		revenuePanel = new RevenuePanel(project);
		projectPane.addTab("Revenue", null, revenuePanel, null);
		revenuePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		costPanel = new CostPanel(project);
		projectPane.addTab("Costs", null, costPanel, null);
		
		fundingPanel = new FundingPanel(project);
		projectPane.addTab("Funding", null, fundingPanel, null);
		
		project.updateMenu();
	}
}
