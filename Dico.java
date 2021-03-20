/**
 * @(#)Dico.java
 *
 *
 * @author endisl
 * @version 1.00
 */

/* O Dico Animado permite encontrar a definição de uma palavra e ver a imagem da mesma com animação. 
   Pode ser uma maneira lúdica de aprendizagem de novos vocábulos.
   As principais características da interface :
   - Possibilidade de digitar uma palavra sem se preocupar com maíuscula e minúscula, e também sem se preocupar com os espaços no inicio e/ou no final da palavra
     Exemplo : "Casa", "casa" e "CaSa" retornarão a mesma definição.
               " ponte", "ponte  " e "  ponte  " retornarão a mesma definição.     
   - O usuário é convidado a clicar sempre no botão "Validar" ou dar "Enter" para validar a palavra digitada.     
   - A interface exibe 3 mensagens de aviso :
     Duas delas depois de aparecer, a interface volta ao seu estado inicial.
     Uma outra depois de aparecer, a interface é parcialmente limpada deixando ao usuário a possibilidade de validar a palavra que digitou.
   - Possibilidade de mudar o visual da interface.
   - Possibilidade de ativar ou desativar a animação da imagem exibida.
   - A caixa de escolha é uma alternativa mais rápida para a entrada das palavras na caixa de texto, basta clicar na palavra escolhida.   
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//criando a interface gráfica que contem todos os elementos e que implementa a ação na própria classe

public class Dico extends JFrame implements ActionListener, MouseListener {
	
	//definição dos elementos da GUI
	private JPanel p1,p2,p3,p4,p5;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JTextField tf1,tf2;
    private JMenuBar b1;
    private JMenu m1,m2,m3;
    private JMenuItem mi1,mi2,mi3,mi4,mi5;
    private ImageIcon img;
    private JRadioButton rbtn1,rbtn2;
    private ButtonGroup bg=new ButtonGroup();
    private JComboBox box1;
    private JButton btn1;

    //String para cada opção do JComboBox	    	
    private String categ[]={"Avião","Casa","Estrada","Olho","Ponte"};
    	
    //definição dos campos da classe de modo que todos os elementos da interface são declarados aqui
    public Dico() 
    {       	
    	
    	setTitle("Dico Animado"); //título da interface
    	
    	//colocando o ícone na barra de título
    	Toolkit kit = Toolkit.getDefaultToolkit();  
		Image img = kit.getImage("../TrabalhoPC2/dico.png");  
		setIconImage(img);    	   	
    	
    	setLocation(20,20); //localização inicial da interface    	
    	setSize(750,280); //dimensões da interface    	        	
    	setDefaultCloseOperation(EXIT_ON_CLOSE); //botão fechar termina o programa     	   	
    	createContents(); //criar elementos da GUI    	    	
    	setVisible(true); //exibir a interface    	
    	
    }
    
        
    //criação dos JPanels e do JMenu
    
    private void createContents()
    {
    	
    	p1=createJPanel1(); //criando o JPanel1
    	p2=createJPanel2(); //criando o JPanel2
    	p3=createJPanel3(); //criando o JPanel3
    	p4=createJPanel4(); //criando o Jpanel4
    	p5=createJPanel5(); //criando o JPanel5 : engloba todos os JPanels    	
    	createJMenu1(); //criando o método para os menus
    	add(p5); //adicionado o JPanel5 à Janela
    }
    
    //criação do JMenu
    public void createJMenu1()
    {
    	
    	b1=new JMenuBar(); //criando objeto JMenuBar

    	//criando objetos JMenu
    	m1=new JMenu("Arquivo"); 
    	m2=new JMenu("Visual");
    	m3=new JMenu("Ajuda");
		
		//criando objetos dos sub JMenus    		    
    	mi1=new JMenuItem("Sair"); 
    	mi2=new JMenuItem("Default");
    	mi3=new JMenuItem("Aparência 1");
    	mi4=new JMenuItem("Aparência 2");
    	mi5=new JMenuItem("Sobre o Dico Animado");
				
		//adicionando tratamento de evento aos itens de menu
		mi1.addActionListener(this); 
		mi2.addActionListener(this); 
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		
		//adicionando itens aos JMenus    		
		m1.add(mi1);     		
    	m2.add(mi2);
    	m2.add(mi3);
    	m2.add(mi4);
    	m3.add(mi5);
    	
    	//adicionando os JMenus na barra
    	b1.add(m1); 
    	b1.add(m2);
    	b1.add(m3);
    	    	
    	setJMenuBar(b1); //modificando a barra de menus para a Janela
    		
    }
    
    //criação do JPanel p1
    private JPanel createJPanel1()
    {
    	p1=new JPanel(); //criando efetivamente o JPanel p1
    	
    	//criando labels
    	l1=new JLabel("Digite a palavra");
    	l2=new JLabel("Procure a palavra");    
    	l3=new JLabel("Definição");   	
    	    	
    	p1.setLayout(new GridLayout(3,1)); //definindo o layout para o JPanel p1
        	 
    	//adicionando todos os componentes ao JPanel p1 	    	
    	p1.add(l1);    
    	p1.add(l3);    	
    	p1.add(l2);  	    	
		
    	return p1; //retornando JPanel p1 com elementos    	    			
    }
    
    //criação do JPanel p2
    private JPanel createJPanel2()
    {    	
    	p2=new JPanel(); //criando efetivamente o JPanel p2    	
    	
    	//criando caixas de texto e caixa de escolha
    	tf2=new JTextField("");   	
    	tf1=new JTextField("");
    	box1=new JComboBox(categ);     	
    	    	
    	tf1.addActionListener(this); //adicionando listener a caixa de texto
    	    	
    	box1.addActionListener(this); //adicionando listener a caixa de combinação    	
    	 	
    	tf2.setEditable(false); //caixa de texto não editável
    	    	   	    	    	
    	p2.setLayout(new GridLayout(3,1)); //definindo o layout para o JPanel p2
    	
    	//adicionando todos os componentes ao JPanel p2    		    	
    	p2.add(tf1);    	
    	p2.add(tf2);    	
    	p2.add(box1);    	
    	    	    	
    	return p2; //retornando JPanel p2 com elementos    
    }
    
    //criação do JPanel p3
    private JPanel createJPanel3()
    {
    	
    	p3=new JPanel(); //criando efetivamente o JPanel p3
    	    	
    	p3.setLayout(new FlowLayout()); //definindo o layout para o JPanel p3
    	
    	//criando botões de rádio e label
    	rbtn1=new JRadioButton("Ativar a animação",true);
    	rbtn2=new JRadioButton("Desativar a animação",false);
    	l5=new JLabel("");
		    	    	    	
    	//agrupando os botões de rádio
    	bg.add(rbtn1);
    	bg.add(rbtn2);    	   	
    	    	
    	//adicionando listener aos botões de rádio
    	rbtn1.addActionListener(this);
    	rbtn2.addActionListener(this);
    	
    	//adicionando todos os componentes ao JPanel p3
    	p3.add(l5);
    	p3.add(rbtn1);
    	p3.add(rbtn2);    	
    	
    	return p3; //retornando JPanel p3 com elementos    
    }
    
    //criação do JPanel p4
    private JPanel createJPanel4()
    {
    	p4=new JPanel(); //criando efetivamente o JPanel p4
    	    	
    	btn1=new JButton("Validar"); //criando botão
    	
    	//adicionando listeners aos botões  
    	btn1.addActionListener(this); 
    	btn1.addMouseListener(this);    	  	
        	    	
    	p4.setLayout(new GridLayout(3,1)); //definindo o layout para o JPanel p4          		    	
    
    	p4.add(btn1); //adicionando o componente ao JPanel p4 
    		
    	return p4; //retornando JPanel p4 com elementos    	
    }
    
    //criação do JPanel p5 para inserir os JPanels
    private JPanel createJPanel5()
    {    	
    	p5=new JPanel(); //criando efetivamente o JPanel p5
    	    	
    	p5.setLayout(new BorderLayout(10,10)); //definindo o layout para o JPanel p5 e deixando espaço entre os componentes
    	
    	//adicionando os paneis ao panel geral
    	p5.add(p1,BorderLayout.WEST);
    	p5.add(p2,BorderLayout.CENTER);
    	p5.add(p3,BorderLayout.SOUTH);
    	p5.add(p4,BorderLayout.EAST);
    	    	    	
    	return p5; //retornando JPanel p5 com elementos
    }
    
    //tratamento de eventos
    public void actionPerformed(ActionEvent e)
    {
    	int res=-1; //variável auxiliar
    	
    	//criando dois vetores de imagens que se encontram no mesmo diretório que o arquivo .CLASS
    	
    	Icon imagem1[]={new ImageIcon(getClass().getResource("avião.gif")),
    					new ImageIcon(getClass().getResource("casa.gif")),
    					new ImageIcon(getClass().getResource("estrada.gif")),
    					new ImageIcon(getClass().getResource("olho.gif")),
    					new ImageIcon(getClass().getResource("ponte.gif"))};
    					   		
    	Icon imagem2[]={new ImageIcon(getClass().getResource("avião.png")),
    					new ImageIcon(getClass().getResource("casa.png")),
    					new ImageIcon(getClass().getResource("estrada.png")),
    					new ImageIcon(getClass().getResource("olho.png")),
    					new ImageIcon(getClass().getResource("ponte.png"))};
    	    		   		
    	
    	//criando o vetor de palavras
    	String palavra[]={"avião","casa","estrada","olho","ponte"};
    		
    	//criando o vetor de definições
    	String definicao[]={"Veículo aéreo com asas geralmente impulsionado por um ou mais motores.",
    	   					"Prédio ou parte dele onde uma pessoa ou uma família moram.",
    	   					"Caminho público, largo, geralmente pavimentado e preparado para o trânsito de veículos.",
    	   					"Em uma pessoa ou animal, órgão que possibilita ver.",
    	   					"Construção que liga dois lugares separados por curso de água ou depressão de terreno."};
    	
    	
    	//atribuindo o conteúdo das caixas de texto as variáveis string
    	String str1=tf1.getText();    			   			   		    		    			
    	String str2=tf2.getText();
    	
    	String str3=str1.trim(); //ignorando os espaços no início e no final da string
    	
    	//-- Evento para o botão Validar --//
    	    	
    	if((e.getSource()==btn1) || (e.getSource()==tf1))
    	{   		   			   			   		    		    			
    		//laço para obter o índice da palavra digitada dentro do vetor    		    			    			    			    			
    		for(int i=0;i<palavra.length;i++)
    		{
    		 	if(str3.equalsIgnoreCase(palavra[i])) //comparação entre duas strings não levando em conta maiúscula e minúscula
    		 	{
    		 		res=i; //atualiza a variável auxiliar com o índice da palavara digitada dentro do vetor
    		 		break; //interrompe o laço   			 	    			 	
    		 	}
    		
    		}
    		    		
    		//condição que analisa o texto entrado na caixa de texto "Digite a palavra" e retorna resultados apropriados 
    		if(res!=-1)	
    		{
    			tf2.setText(definicao[res]); //atualiza a caixa de texto "Definição" com a definição da palavra digitada
    			//condição para saber qual botão de rádio está selecionado já no início e durante a execução do programa
    			if(rbtn1.isSelected()) 
    				l5.setIcon(imagem1[res]); //atualiza o label "Imagem" com a imagem animada
    			else if(rbtn2.isSelected())
    				l5.setIcon(imagem2[res]); //atualiza o label "Imagem" com a imagem inanimada
    		}
    		else
    		{    			
    			if(str3.equalsIgnoreCase(""))    				
    			{
    				l5.setIcon(null); //limpa o label "Imagem"
    				tf1.setText(""); //limpa a caixa de texto "Digite a palavra"
    				tf2.setText(""); //limpa a caixa de texto "Definição
    				JOptionPane.showMessageDialog(null,"Nenhuma palavra digitada.","Aviso",JOptionPane.WARNING_MESSAGE); //Retorna mensagem de aviso caso a caixa de texto "Digite a palavra" não contiver nenhum caráter ou contiver só espaços
    			}
    			
    			else
    			{    				
    				l5.setIcon(null); //limpa o label "Imagem"
    				tf1.setText(""); //limpa a caixa de texto "Digite a palavra"
    				tf2.setText(""); //limpa a caixa de texto "Definição
    				JOptionPane.showMessageDialog(null,"Palavra '"+str1+"' não encontrada! Por favor consulte a lista de palavras disponíveis.","Aviso",JOptionPane.WARNING_MESSAGE); //Retorna mensagem de aviso caso a caixa de texto "Digite a palavra" contiver uma palavra não listada
    				    				
    			}    			
    			
    		}    	   	    		 	    			
    		
    	}    	    	
    	
    	//-- Evento para a caixa de combinação --//
    	
    	if((e.getSource()==box1))
    	{
    		tf1.setText((String)box1.getSelectedItem());//atualiza a caixa de texto "Digite a palavra" de acordo com o elemento selecionado
    		
    	}
    	    	   	
    	
    	//-- Evento para o botão de rádio Ativar a animação --//
    	
    	//laço para obter o índice da palavra digitada dentro do vetor  
    	if((e.getSource()==rbtn1))
    	{    		 			   			   		    		    			
    		    		    			    			    			    			
    		for(int i=0;i<palavra.length;i++)
    		{
    		 	if(str3.equalsIgnoreCase(palavra[i]))
    		 	{
    		 		res=i;
    		 		break; 
    		 	}
    		
    		}    		    		
    		
    		//condição para saber qual imagem mostrar de acordo com a palavra digitada
    		if(res!=-1 && str2.equalsIgnoreCase(definicao[res]))	
    		{    				
    			l5.setIcon(imagem1[res]); //atualiza o label "Imagem" com a imagem animada					    			
    		}
    		else
    		{
    			if(str3.equalsIgnoreCase(""))
    			{
    				l5.setIcon(null); //limpa o label "Imagem"
    				tf1.setText(""); //limpa a caixa de texto "Digite a palavra"
    				tf2.setText(""); //limpa a caixa de texto "Definição     					
    			}
    					
    			else
    			{
    				l5.setIcon(null); //limpa o label "Imagem"
    				tf2.setText(""); //limpa a caixa de texto "Definição  
    				JOptionPane.showMessageDialog(null,"Valide primeiro a palavra digitada.","Aviso",JOptionPane.WARNING_MESSAGE); //Retorna mensagem de aviso caso a palavra na caixa de texto "Digite a palavra" não for validada com o botão "Procurar"
    			}
    					
    		}    			
    		
    	}

    	//-- Evento para o botão de rádio Desativar a animação --//
    	
    	//Todos os comentários para o evento precedente : Ativar a animação, valem também para este evento
    	
    	if((e.getSource()==rbtn2))
    	{    	
    		    		    			    			    			    			
    		for(int i=0;i<palavra.length;i++)
    		{
    		 	if(str3.equalsIgnoreCase(palavra[i]))
    		 	{
    		 		res=i;
    		 		break;   			 	    			 	
    		 	}
    		
    		}
    		    		
    		
    		if(res!=-1 && str2.equalsIgnoreCase(definicao[res]))	
    		{
    			l5.setIcon(imagem2[res]); //atualiza o label "Imagem" com a imagem inanimada    				
    		}
    		else
    		{
    			if(str3.equalsIgnoreCase(""))
    			{
    				l5.setIcon(null);
    				tf1.setText("");
    				tf2.setText("");    					
    			}
    					
    			else
    			{
    				l5.setIcon(null);
    				tf2.setText("");
    				JOptionPane.showMessageDialog(null,"Valide primeiro a palavra digitada.","Aviso",JOptionPane.WARNING_MESSAGE);    				    				 
    			}
    					
    		}
    		
    	}
    	
    	//-- Evento para o sub Menu Arquivo:Sair --//
    	
    	if((e.getSource()==mi1))
    	{    		
    		System.exit(0); //fecha o programa    	
    	}
    	
    	//-- Evento para o sub Menu Visual:Default --//
    	
    	if((e.getSource()==mi2))
    	{    		
    		//Limpa a cor do fundo dos componentes e paineis    		
    		rbtn1.setBackground(null);    		
    		rbtn2.setBackground(null);    		
    		tf2.setBackground(null);
    		p1.setBackground(null);
    		p2.setBackground(null);
    		p3.setBackground(null);
    		p4.setBackground(null);
    		p5.setBackground(null);
    	}
    	
    	//-- Evento para o sub Menu Visual:Aparência1 --//
    	
    	if((e.getSource()==mi3))
    	{    		
    		//Muda a cor do fundo dos componentes e paineis			
    		rbtn1.setBackground(Color.WHITE);
    		rbtn2.setBackground(Color.WHITE);    		
    		tf2.setBackground(Color.WHITE);
    		p1.setBackground(Color.WHITE);
    		p2.setBackground(Color.WHITE);
    		p3.setBackground(Color.WHITE);
    		p4.setBackground(Color.WHITE);    		
    		p5.setBackground(Color.WHITE);    		    		
    	}
    	
    	//-- Evento para o sub Menu Visual:Aparência2 --//
    	
    	if((e.getSource()==mi4))
    	{   
    		//Muda a cor do fundo dos componentes e paineis    		
    		rbtn1.setBackground(Color.LIGHT_GRAY);
    		rbtn2.setBackground(Color.LIGHT_GRAY);    		
    		tf2.setBackground(Color.LIGHT_GRAY);
    		p1.setBackground(Color.LIGHT_GRAY);
    		p2.setBackground(Color.LIGHT_GRAY);
    		p3.setBackground(Color.LIGHT_GRAY);
    		p4.setBackground(Color.LIGHT_GRAY);
    		p5.setBackground(Color.LIGHT_GRAY);
    		    		 
    	}       	
    	    	    	
    	//-- Evento para o sub Menu Ajuda:Sobre o Dico Animado --//
    	
    	if((e.getSource()==mi5))
    	{    		
    		JOptionPane.showMessageDialog(null,"Trabalho de Programação de Computadores II"+"\n"+"Unesp FEG"+"\n"+"Novembro de 2012","Sobre o Dico Animado",JOptionPane.PLAIN_MESSAGE); //Breve descrição do Programa
    	}    	
    	    		
    }
    
    //Métodos da interface MouseListener
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
		
    //Metodo que trata o evento de entrada do mouse
    public void mouseEntered(MouseEvent e)
    {
    	if (e.getSource()==btn1)
     		btn1.setBackground(Color.CYAN); //muda a cor do fundo do botão "Validar"     	
   	}
    
    //Metodo que trata o evento de saída do mouse  
   	public void mouseExited(MouseEvent e)
   	{
   		if (e.getSource()==btn1)
     		btn1.setBackground(null); //limpa a cor do fundo do botão "Validar"     	
   	}   	         	  
          
    //criação e teste da interface criada    
    public static void main(String args[])
    {
    	Dico d1=new Dico();
    }
    
}
    