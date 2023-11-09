import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaOpcao {

	private JFrame frmMenu;
	private JTextField txtOpcao;
	int numeroContas = 0;
	private HashMap<String, ContaBancaria> contas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcao window = new TelaOpcao();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaOpcao() {
		initialize();
		contas = new HashMap<>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("MENU");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha uma opção:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(130, 11, 231, 37);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1 - Criar conta");
		lblNewLabel_1.setBounds(70, 50, 91, 14);
		frmMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2 - Procurar Conta");
		lblNewLabel_2.setBounds(70, 75, 110, 14);
		frmMenu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("3 - Apagar Conta");
		lblNewLabel_3.setBounds(70, 100, 102, 14);
		frmMenu.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("4 - Gerar relatório");
		lblNewLabel_4.setBounds(70, 125, 131, 14);
		frmMenu.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("0 - Sair");
		lblNewLabel_5.setBounds(70, 150, 46, 14);
		frmMenu.getContentPane().add(lblNewLabel_5);
		
		txtOpcao = new JTextField();
		txtOpcao.setBounds(130, 210, 163, 29);
		frmMenu.getContentPane().add(txtOpcao);
		txtOpcao.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = Integer.parseInt(txtOpcao.getText());
				switch (opcao) {
				case 0: {
					JOptionPane.showMessageDialog(null, "Obrigado!");
					System.exit(0);
					break;
				}
				case 1: {
					frmMenu.dispose();
					
					// Opção de criar conta
                    String[] tipos = {"Poupança", "Corrente"};
                    JRadioButton radioButtonPoupanca = new JRadioButton("Poupança");
                    JRadioButton radioButtonCorrente = new JRadioButton("Corrente");

                    // Grupo de botões para permitir apenas uma seleção
                    ButtonGroup group = new ButtonGroup();
                    group.add(radioButtonPoupanca);
                    group.add(radioButtonCorrente);

                    JTextField txtSaldo = new JTextField();

                    Object[] message = {
                        "Nova Conta",
                        "Tipo:",
                        radioButtonPoupanca,
                        radioButtonCorrente,
                        "Número da conta: " + (++numeroContas),
                        "Saldo em R$:",
                        txtSaldo
                    };

                    int option = JOptionPane.showOptionDialog(null, message, "Criar Conta",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    if (option == JOptionPane.OK_OPTION) {
                        // Botão de criar conta foi pressionado
                        if (radioButtonPoupanca.isSelected() || radioButtonCorrente.isSelected()) {
                            // Pelo menos uma opção de conta foi selecionada
                            if (!txtSaldo.getText().isEmpty()) {
                                // O saldo foi inserido
                                double saldo = Double.parseDouble(txtSaldo.getText());
                                if (radioButtonPoupanca.isSelected()) {
                                    // A opção de Poupança foi selecionada
                                    JOptionPane.showMessageDialog(null, "Conta Poupança criada com sucesso!");
                                } else if (radioButtonCorrente.isSelected()) {
                                    // A opção de Corrente foi selecionada
                                    JOptionPane.showMessageDialog(null, "Conta Corrente criada com sucesso!");
                                }
                                frmMenu.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor, insira um saldo.", "Erro ao criar a conta", JOptionPane.ERROR_MESSAGE);
                                numeroContas--;
                                frmMenu.setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, selecione um tipo de conta.", "Erro ao criar a conta", JOptionPane.ERROR_MESSAGE);
                            numeroContas--;
                            frmMenu.setVisible(true);
                        }
                    }
                    break;
				}
				case 2: {
					String numeroConta = JOptionPane.showInputDialog("DIGITE O NÚMERO DA CONTA:");
					if (contaExiste(numeroConta)) {
				        Object[] options = {"1-DEPOSITAR", "2-SACAR", "3-TRANSFERIR", "4-GERAR RELATÓRIO", "0-VOLTAR"};
				        int choice = JOptionPane.showOptionDialog(null,
				                "Escolha uma opção:",
				                "Opções",
				                JOptionPane.YES_NO_CANCEL_OPTION,
				                JOptionPane.WARNING_MESSAGE,
				                null,
				                options,
				                options[0]);

				        switch (choice) {
				            case 0: // 1-DEPOSITAR
				                // Implemente o código para depositar aqui
				                break;
				            case 1: // 2-SACAR
				                // Implemente o código para sacar aqui
				                break;
				            case 2: // 3-TRANSFERIR
				                // Implemente o código para transferir aqui
				                break;
				            case 3: // 4-GERAR RELATÓRIO
				                // Implemente o código para gerar relatório aqui
				                break;
				            case 4: // 0-VOLTAR
				                // Voltar para o menu
				                break;
				            default:
				                break;
				        }
				    } else {
				        JOptionPane.showMessageDialog(null, "Conta inexistente ou inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
				    }
					break;
				}
				case 3: {
					break;
				}
				case 4: {
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcao);
				}
				
			}

			private boolean contaExiste(String numeroConta) {
				return contas.containsKey(numeroConta);
			}
			
		});
		btnEnviar.setBounds(306, 209, 89, 29);
		frmMenu.getContentPane().add(btnEnviar);
	}
	
}
