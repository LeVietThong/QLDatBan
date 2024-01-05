/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Cat.DanhMuc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import quanlydatban.ChonBanJPanel;
import quanlydatban.ThucDonJPanel;
import quanlydatban.HoaDonJPanel;
import quanlydatban.DatBanJPanel;

/**
 *
 * @author truon
 */
public class CtrlScSwch {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMuc> listItem = null;
    
    public CtrlScSwch(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "ChonBan";
        
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ChonBanJPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMuc> listItem) {
        this.listItem = listItem;
        
        for(DanhMuc item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "ChonBan":
                    node = new ChonBanJPanel();
                    break;
                case "ChonMon":
                    node = new ThucDonJPanel();
                    break;
                case "DatBan":
                    node = new DatBanJPanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    break;
                default:
                    node = new ChonBanJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(242,242,242));
                jlbItem.setBackground(new Color(242,242,242));
            }
        }
        private void setChangeBackground(String kind) {
            for(DanhMuc item: listItem) {
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJpn().setBackground(new Color(96,100,191));
                    item.getJlb().setBackground(new Color(96,100,191));
                }else{
                    item.getJpn().setBackground(new Color(242,242,242));
                    item.getJlb().setBackground(new Color(242,242,242));
                }
            }
        }
        
    }
}
