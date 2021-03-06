/*
 * Created by JFormDesigner on Tue Mar 19 13:08:20 CST 2019
 */

package view;

import service.AccountService;
import service.AccountServiceImpl;
import utils.AES_Utils;
import utils.CodePicture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author 吴英峰
 */
public class Login {
    public Login() {
        try {
            Class.forName("utils.HibernateUtils");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        initComponents();
        initByMyself();
    }


        public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 吴英峰
        frame = new JFrame();
        userLabel = new JLabel();
        userField = new JFormattedTextField();
        pwdLabel = new JLabel();
        remenberMe = new JCheckBox();
        loginBtn = new JButton();
        userTipLabel = new JLabel();
        panel1 = new JPanel();
        titleLabel = new JLabel();
        pwdField = new JPasswordField();
        comboBox1 = new JComboBox<>();
        label4 = new JLabel();
        pwdVisibleBtn = new JButton();
        label1 = new JLabel();
        yzmField = new JFormattedTextField();
        yzmLabel = new JLabel();

        //======== frame ========
        {
            frame.setAlwaysOnTop(true);
            frame.setTitle("\u8d85\u5e02\u6536\u94f6\u7cfb\u7edf");
            Container frameContentPane = frame.getContentPane();

            //---- userLabel ----
            userLabel.setText("\u8d26\u53f7");
            userLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //---- pwdLabel ----
            pwdLabel.setText("\u5bc6\u7801");
            pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //---- remenberMe ----
            remenberMe.setText("\u8bb0\u4f4f\u6211");

            //---- loginBtn ----
            loginBtn.setText("\u767b\u5f55");

            //---- userTipLabel ----
            userTipLabel.setText("\u8d26\u53f7\u4e0d\u5b58\u5728");
            userTipLabel.setForeground(Color.red);

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
            }

            //---- titleLabel ----
            titleLabel.setText("\u8d85\u5e02\u6536\u94f6\u7cfb\u7edf");
            titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            titleLabel.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 18));

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u7ba1\u7406\u5458",
                "\u6536\u94f6\u5458"
            }));
            comboBox1.setBackground(Color.white);

            //---- label4 ----
            label4.setText("\u8eab\u4efd");
            label4.setHorizontalTextPosition(SwingConstants.CENTER);
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            //---- pwdVisibleBtn ----
            pwdVisibleBtn.setPreferredSize(new Dimension(30, 30));
            pwdVisibleBtn.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Workspace\\superMarket\\images\\eye.png"));
            pwdVisibleBtn.setIconTextGap(0);
            pwdVisibleBtn.setHorizontalTextPosition(SwingConstants.CENTER);
            pwdVisibleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- label1 ----
            label1.setText("\u9a8c\u8bc1\u7801");

            //---- yzmLabel ----
            yzmLabel.setPreferredSize(new Dimension(80, 30));
            yzmLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addComponent(pwdLabel, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addComponent(label1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                                .addGroup(frameContentPaneLayout.createSequentialGroup()
                                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(comboBox1, GroupLayout.Alignment.LEADING)
                                                .addGroup(frameContentPaneLayout.createSequentialGroup()
                                                        .addComponent(yzmField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(yzmLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(userField)
                                                .addComponent(pwdField, GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(frameContentPaneLayout.createParallelGroup()
                                                .addComponent(pwdVisibleBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userTipLabel)))
                                .addComponent(remenberMe))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))
                        .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                        .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGap(137, 137, 137)
                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                        .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userTipLabel)
                                    .addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameContentPaneLayout.createParallelGroup()
                                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(pwdVisibleBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(pwdLabel)
                                                    .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(frameContentPaneLayout.createParallelGroup()
                                                    .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(yzmField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label1))
                                                    .addComponent(yzmLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remenberMe)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(20, Short.MAX_VALUE))
            );
            frame.setSize(400, 335);
            frame.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initByMyself() {
        userTipLabel.setVisible(false);
        pwdField.setEchoChar('•');
        Object[] imageArr = CodePicture.createImage();
        ImageIcon img = new ImageIcon((BufferedImage) imageArr[1]);//创建图片对象
        yzm = imageArr[0].toString().toLowerCase();
        System.out.println(yzm);
        yzmLabel.setIcon((Icon) img);
        Properties prop = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("cookies.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            if (it.hasNext()) {
                String key = it.next();
                String pwd = AES_Utils.decode(prop.getProperty(key),
                        AES_Utils.getKey());
                System.out.println(key + ":" + pwd);
                userField.setText(key);
                pwdField.setText(pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        userField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(isNumberChanged==true){
                    AccountService as = new AccountServiceImpl();
                    Boolean isExist = as.isExist(userField.getText());
                    userTipLabel.setVisible(!isExist);
                    isNumberChanged=false;
                }

            }
        });
        userField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (isChinese(c)) {
                    e.consume();
                    return;
                }
                if (Character.isDigit(c) || Character.isLetter(c)
                        || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    isNumberChanged=true;
                    return;
                }
                e.consume();
            }

            public boolean isChinese(char c) {
                Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
                if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                    return true;
                } else if (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) {
                    return true;
                } else if (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
                    return true;
                } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
                    return true;
                } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
                    return true;
                } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C) {
                    return true;
                } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D) {
                    return true;
                } else if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
                    return true;
                } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                    return true;
                }
                return false;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown())
                    e.consume();
            }
        });

        pwdVisibleBtn.addMouseListener(new MouseAdapter() {
            boolean isVisible = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isVisible == false) {
                    isVisible = true;
                    pwdField.setEchoChar((char) 0);
                } else {
                    isVisible = false;
                    pwdField.setEchoChar('•');
                }
            }
        });

        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (userField.getText().equals("") || pwdField.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "账号或密码不能为空");
                    e.consume();
                    return;
                }
                if (yzmField.getText().toLowerCase().equals("")) {
                    JOptionPane.showMessageDialog(frame, "验证码不能为空");
                    e.consume();
                    return;
                }
                if (!yzmField.getText().toLowerCase().equals(yzm)) {
                    JOptionPane.showMessageDialog(frame, "验证码错误");
                    yzm = CodePicture.getPicture(yzmLabel).toLowerCase();
                    yzmField.setText("");
                    e.consume();
                    return;
                }
                if(userTipLabel.isVisible()){
                    JOptionPane.showMessageDialog(frame, "账号不存在，请检查账号");
                }else{
                    AccountServiceImpl accountService = new AccountServiceImpl();
                    boolean accessible = accountService.isAccessible(userField.getText(),
                            pwdField.getText(),
                            (String) comboBox1.getSelectedItem());
                    if(!accessible){
                        JOptionPane.showMessageDialog(frame, "登录失败，请检查账号密码");
                        e.consume();
                        return;
                    }
                    if (remenberMe.isSelected()) {
                        try {
                            Properties pro = new Properties();
                            FileOutputStream fo = new FileOutputStream("cookies.properties", true);
                            pro.setProperty(userField.getText(),
                                    AES_Utils.encode(pwdField.getText(), AES_Utils.getKey()));
                            pro.store(fo, null);    //comment 是注释
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        try {
                            FileOutputStream fo = new FileOutputStream("cookies.properties");
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        yzmLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    //重新获取验证码
                    yzm = CodePicture.getPicture(yzmLabel).toLowerCase();
                }
            }
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 吴英峰
    private JFrame frame;
    private JLabel userLabel;
    private JFormattedTextField userField;
    private JLabel pwdLabel;
    private JCheckBox remenberMe;
    private JButton loginBtn;
    private JLabel userTipLabel;
    private JPanel panel1;
    private JLabel titleLabel;
    private JPasswordField pwdField;
    private JComboBox<String> comboBox1;
    private JLabel label4;
    private JButton pwdVisibleBtn;
    private JLabel label1;
    private JFormattedTextField yzmField;
    private JLabel yzmLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private boolean isNumberChanged=false;
    private String yzm = null;
}
