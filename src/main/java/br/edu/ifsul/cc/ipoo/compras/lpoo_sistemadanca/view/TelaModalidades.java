package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.view;

import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model.Modalidade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class TelaModalidades extends JFrame {

    /**
     * Creates new form TelaModalidades
     */
        private JList<Modalidade> lstModalidades;
        private DefaultListModel<Modalidade> listModel;
        private JButton btnNovo;
        private PersistenciaJPA persistenciaJPA;
        private JButton btnEditar;
        private JButton btnRemover;

    public TelaModalidades() {
        persistenciaJPA = new PersistenciaJPA();

        setTitle("Modalidades");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        lstModalidades = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lstModalidades);

        btnNovo = new JButton("Nova Modalidade");
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novaModalidade();
            }
        });

        btnEditar = new JButton("Editar Modalidade");
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarModalidade();
            }
        });

        btnRemover = new JButton("Remover Modalidade");
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerModalidade();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(btnNovo);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnRemover);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);

        carregarModalidades();
    }

    private void novaModalidade() {
        String descricao = JOptionPane.showInputDialog(this, "Digite a descrição da nova modalidade:");
        if (descricao != null && !descricao.trim().isEmpty()) {
            Modalidade modalidade = new Modalidade();
            modalidade.setDescricao(descricao);
            try {
                persistenciaJPA.persist(modalidade);
                listModel.addElement(modalidade);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar a modalidade: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void carregarModalidades() {
        try {
            List<Modalidade> modalidades = persistenciaJPA.getModalidades();
            for (Modalidade modalidade : modalidades) {
                listModel.addElement(modalidade);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar as modalidades: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void editarModalidade() {
        Modalidade selected = lstModalidades.getSelectedValue();
        if (selected != null) {
            String descricao = JOptionPane.showInputDialog(this, "Edite a descrição da modalidade:", selected.getDescricao());
            if (descricao != null && !descricao.trim().isEmpty()) {
                selected.setDescricao(descricao);
                try {
                    persistenciaJPA.persist(selected);
                    lstModalidades.repaint();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao editar a modalidade: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma modalidade para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void removerModalidade() {
        Modalidade selected = lstModalidades.getSelectedValue();
        if (selected != null) {
            try {
                persistenciaJPA.remover(selected);
                listModel.removeElement(selected);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao remover a modalidade: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma modalidade para remover.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaModalidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
