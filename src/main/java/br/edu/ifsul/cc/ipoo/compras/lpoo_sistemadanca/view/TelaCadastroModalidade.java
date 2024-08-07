package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.view;

import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model.Modalidade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadastroModalidade extends JDialog {
    
    private JTextField txtDescricao;
    private JList<Modalidade> lstModalidades;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JButton btnEditar;
    private Modalidade modalidade;
    private PersistenciaJPA persistenciaJPA;
    private boolean isSaved;
    private boolean isEditing;

    /**
     * Creates new form TelaCadastroModalidade
     */
    public TelaCadastroModalidade(Frame parent, boolean modal) {
        super(parent, modal);
        this.persistenciaJPA = new PersistenciaJPA(); // Cria uma nova instância de PersistenciaJPA
        this.isSaved = false;
        this.isEditing = false; // Inicialmente não estamos editando
        initializeUI();
        carregarModalidades(); // Carregar modalidades no JList
    }
    
    private void initializeUI() {
        setTitle("Cadastro e Edição de Modalidades");
        setSize(500, 400); // Ajuste o tamanho se necessário
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Create components
        txtDescricao = new JTextField();
        lstModalidades = new JList<>();
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        btnEditar = new JButton("Editar");

        // Create and set up the panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2)); // Ajuste o layout se necessário
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(txtDescricao);

        // Create and set up the panel for the list
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JLabel("Modalidades:"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(lstModalidades), BorderLayout.CENTER);

        // Add components to the main dialog
        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);

        // Create and set up the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnEditar);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarModalidade();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarModalidade();
            }
        });

        lstModalidades.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Modalidade selectedModalidade = lstModalidades.getSelectedValue();
                if (selectedModalidade != null) {
                    setModalidade(selectedModalidade);
                }
            }
        });
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
        if (modalidade != null) {
            txtDescricao.setText(modalidade.getDescricao());
            txtDescricao.setEditable(false); // Inicialmente, não é editável
            isEditing = false;
        } else {
            txtDescricao.setText("");
            txtDescricao.setEditable(false);
            isEditing = false;
        }
    }

    private void salvarModalidade() {
        if (modalidade == null) {
            modalidade = new Modalidade();
        }
        modalidade.setDescricao(txtDescricao.getText());

        try {
            if (modalidade.getId() == null) {
                persistenciaJPA.persist(modalidade); // Cria nova modalidade
            } else {
                persistenciaJPA.merge(modalidade); // Atualiza a modalidade existente
            }
            isSaved = true;
            JOptionPane.showMessageDialog(this, "Modalidade salva com sucesso!");
            carregarModalidades(); // Atualiza a lista de modalidades
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a modalidade: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarModalidade() {
        if (modalidade != null) {
            if (!isEditing) {
                txtDescricao.setEditable(true);
                isEditing = true;
                btnEditar.setText("Cancelar Edição");
            } else {
                txtDescricao.setEditable(false);
                isEditing = false;
                btnEditar.setText("Editar");
            }
        }
    }

    private void carregarModalidades() {
        try {
            List<Modalidade> modalidades = persistenciaJPA.getModalidades();
            DefaultListModel<Modalidade> listModel = new DefaultListModel<>();
            for (Modalidade modalidade : modalidades) {
                listModel.addElement(modalidade);
            }
            lstModalidades.setModel(listModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar as modalidades: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isSaved() {
        return isSaved;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastroModalidade dialog = new TelaCadastroModalidade(null, true);
            dialog.setVisible(true);
        });
    }

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

