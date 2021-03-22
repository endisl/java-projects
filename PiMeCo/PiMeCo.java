/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pimeco;

import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.*;
import java.net.URL;
//import java.util.Formatter;

/**
 *
 * @author Endi
 */
public class JFPiMeCo extends javax.swing.JFrame {

    // Janela a abrir     
    int jan = 1;
    
    //Dados: Carregamento
    public double Ned, Med1;
    
    //Dados: Propriedades do Aço
    public double E, G, fy, fu;
    
    //Dados: Pilar
    public double L, ho, a, d, n;
    
    //Dados: Banzos
    public double Ab, Ixb, Iyb, Itb, Iwb, rob, xob;
    
    //Dados: Diagonais
    public double Ad, Ixd, Iyd, Itd, Iwd, rod, xod;
    
    //Dados: Montantes
    public double Am, Ixm, Iym, Itm, Iwm, rom, xom;
    
    //Dados: Chapas de Ligação
    public double hc, ec;
    
    //Dados: Ligação Soldada
    public double fw, tef, l1, l2, l3;
    
    //Resultados: Esforço de Compressão Máximo
    public double Sv, Nbed, Ief, eo, Ncr, Med2;
       
    //Resultados: Esforço Cortante Máximo
    public double Ved;
            
    //Resultados: Resistência à Flambagem No Plano da Barra
    public double Lxbn, Lybn, Lzbn, Nexbn, Neybn, Nezbn, Nexzbn, Nebn, lambn, chibn, sigbn, bwb, bfb, tb, bbnAL, bbnAA, lampbnAL, lampbnAA, befbnAL, befbnAA, Aefbn, Nbyrd, divbn;
    
    //Resultados: Resistência à Flambagem Fora do Plano da Barra
    public double Lxbf, Lybf, Lzbf, Nexbf, Neybf, Nezbf, Nexzbf, Nebf, lambf, chibf, sigbf, bbfAL, bbfAA, lampbfAL, lampbfAA, befbfAL, befbfAA, Aefbf, Nbxrd, divbf;    
    
    //Resultados: Resistência à Flambagem das Diagonais
    public double Lxd, Lyd, Lzd, Nexd, Neyd, Nezd, Nexzd, Nedd, lamd, chid, sigd, bwd, bfd, td, bdAL, bdAA, lampdAL, lampdAA, befdAL, befdAA, Aefd, Ndrd, Ndsd, divd;
    
    //Resultados: Resistência à Flambagem dos Montantes
    public double Lxm, Lym, Lzm, Nexm, Neym, Nezm, Nexzm, Nem, lamm, chim, sigm, bwm, bfm, tm, bmAL, bmAA, lampmAL, lampmAA, befmAL, befmAA, Aefm, Nmrd, divm;
    
    //Resultados: Resistência à Tração de um Elemento da Treliça
    public double Ct, xgd, Ntrd1, Ntrd2, Ntsd, Ntrd, divt;
    
    //Resultados: Resistênica da Ligação Soldada Diagonal - Banzo
    public double Lf, Frd, divl;
    
    //Resultados: Resultado Final
    public String div1r, div2r, div3r, div4r, div5r, div6r;
    
    
    
    //PILAR COM CHAPAS
    
    //Resultados: Esforço de Compressão Máximo
    public double Svc, Nbedc, Iefc, eoc, Ncrc, Med2c, mu, I1, ioz, lamz, Ic, B, C;
    
    //Resultados: Resistência à Flambagem No Plano da Barra
    public double Lxbnc, Lybnc, Lzbnc, Nexbnc, Neybnc, Nezbnc, Nexzbnc, Nebnc, lambnc, chibnc, sigbnc, bwbc, bfbc, tbc, bbncAL, bbncAA, lampbncAL, lampbncAA, befbncAL, befbncAA, Aefbnc, Nbyrdc, divbnc;
    
    //Resultados: Resistência à Flambagem Fora do Plano da Barra
    public double Lxbfc, Lybfc, Lzbfc, Nexbfc, Neybfc, Nezbfc, Nexzbfc, Nebfc, lambfc, chibfc, sigbfc, bbfcAL, bbfcAA, lampbfcAL, lampbfcAA, befbfcAL, befbfcAA, Aefbfc, Nbxrdc, divbfc; 
                
    //Resultados: Solicitações no Painel de Extremidade
    public double Vsdc, Nb1sdc, Mb1sdc, Vcsdc, Mcsdc;
    
    //Resultados: Resistência das Chapas no Painel de Extremidade
    public double Vcrdc, Mcrdc, divVc, divMc;
    
    //Resultados: Resistência do Banzo no Painel de Extremidade
    public double Nb1rd, Mb1rd, Wyb, divMNb;
    
    //Resultados: Resistênica da Ligação Soldada Chapa - Banzo
    public double Lfc, Frdc, Ntsdc, divlc;  
    
   
    //Variáveis para LookAndFeel
    private UIManager.LookAndFeelInfo[] looks;
    private int lf;
    
    
    //Variáveis para chamar JDialogs
  
    private JDPerfilU jdpu;
    private JDPerfilL jdpl;
    private JDPerfisCadastrados jdp;
    private JDSobre1 jds1;
    private JDLigS jdligs;
    
    
    /**
     * Creates new form JFPiMeCo
     */
    public JFPiMeCo() {
        
        initComponents();         
        this.jdpu = new JDPerfilU(this, true);          //perfil U
        this.jdpl = new JDPerfilL(this, true);          //perfil L
        this.jdp = new JDPerfisCadastrados(this, true); //perfis cadastrados
        this.jds1 = new JDSobre1(this, true);           //sobre
        this.jdligs = new JDLigS(this, true);           //ligação soldada
        
        //Icone do Programa
        URL url = this.getClass().getResource("/imagens_pmc/Icon_Pimeco.png");  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);         
	this.setIconImage(iconeTitulo); 
        
    }   
            
    
    // Para usar Look and Feel do Windows
    private void mudaLookAndFeel(int index) 
    {
        looks = UIManager.getInstalledLookAndFeels();
        try { UIManager.setLookAndFeel(looks[index].getClassName());
              SwingUtilities.updateComponentTreeUI(this);} 
        catch (Exception e) {
            e.printStackTrace();}   
    
    }     
    
    
    
    //Método: Esforço de compressão máximo nas barras PT
    
    public void EsforcoCompressaoPT()
    {               
                        
        ho = Double.parseDouble(jTho.getText());
        Ab = Double.parseDouble(jTAb.getText());
        Ief = 0.5 * Math.pow(ho,2) * Ab;        
               
        n = Double.parseDouble(jTn.getText());
        E = Double.parseDouble(jTE.getText());
        Ad = Double.parseDouble(jTAd.getText());
        a = Double.parseDouble(jTa.getText());
        d = Double.parseDouble(jTd.getText());
        Am = Double.parseDouble(jTAm.getText());       
        
        
        //N-shape        
        if (jan==1) 
        {            
            Sv = (n*E*Ad*a*Math.pow(ho,2))/(Math.pow(d,3)*(1+((Ad*Math.pow(ho,3))/(Am*Math.pow(d,3)))));                                    
        }
        
        
        //V-shape
        else if (jan==3)
        {
            Sv = (n*E*Ad*a*Math.pow(ho,2))/(2*Math.pow(d,3));                                    
        }
        
        
        //K-shape
        else if (jan==4)
        {
            Sv = (n*E*Ad*a*Math.pow(ho,2))/(Math.pow(d,3));                                    
        }
        
        
        //X-shape
        else if (jan==5)
        {
            Sv = (2*n*E*Ad*a*Math.pow(ho,2))/(Math.pow(d,3));                                    
        }               
        
        
        
        L = Double.parseDouble(jTL.getText());
        eo = L/500;                                            
               
        Ncr = Math.pow(Math.PI,2)*E*Ief/(Math.pow(L,2));
                
        Ned = Double.parseDouble(jTNed.getText());
        Med1 = Double.parseDouble(jTMed1.getText());       
        Med2 = (Ned*eo*0.01 + Med1)/(1-(Ned/Ncr) - (Ned/Sv));
                
        Nbed = Ned/2 + (100*Med2*ho*Ab)/(2*Ief);                
               
    }
    
    
    // Rigidez das chapas PC
    
    public void RigidezChapas()
    {
        
        hc = Double.parseDouble(jThc.getText());
        ec = Double.parseDouble(jTec.getText());
        Iyb = Double.parseDouble(jTIyb.getText());
        a = Double.parseDouble(jTa.getText());
        ho = Double.parseDouble(jTho.getText());
        n = Double.parseDouble(jTn.getText());
        
        Ic = ec*Math.pow(hc,3)/12;
        
        C=n*Ic/ho;
        
        B=10*Iyb/a;            
        
    }
    
    
     //Método: Esforço de compressão máximo nas barras PC
    
    public void EsforcoCompressaoPC()
    {               
                        
        ho = Double.parseDouble(jTho.getText());
        Ab = Double.parseDouble(jTAb.getText());
        Iyb = Double.parseDouble(jTIyb.getText());
        
        I1 = 0.5*Math.pow(ho,2)*Ab + 2*1*Iyb;
        
        ioz = Math.sqrt(0.5*I1/Ab);
        
        L = Double.parseDouble(jTL.getText());
        
        lamz = L/ioz;
        
        if(lamz<=75)
            {mu=1;}
        else if(lamz>=75 && lamz<=150)
            {mu=2-lamz/75;}
        else if(lamz>=150)
            {mu=0;}
        
        Iefc = 0.5*Math.pow(ho,2)*Ab +2*mu*Iyb;        
               
        n = Double.parseDouble(jTn.getText());
        E = Double.parseDouble(jTE.getText());
        a = Double.parseDouble(jTa.getText());
        
        hc = Double.parseDouble(jThc.getText());
        ec = Double.parseDouble(jTec.getText());
        Ic = ec*Math.pow(hc,3)/12;
        
        
        if (C>B)
        {
            Svc = 2*Math.pow(Math.PI,2)*E*Iyb/Math.pow(a,2);            
        }
        else
        {                       
            Svc = 24*E*Iyb/(Math.pow(a,2)*(1+(2*Iyb/(n*Ic))*(ho/a)));           
        }
        
                        
        eoc = L/500;                                            
               
        Ncrc = Math.pow(Math.PI,2)*E*Iefc/(Math.pow(L,2));
                
        Ned = Double.parseDouble(jTNed.getText());
        Med1 = Double.parseDouble(jTMed1.getText());       
        Med2c = (Ned*eoc*0.01 + Med1)/(1-(Ned/Ncrc) - (Ned/Svc));
                
        Nbedc = Ned/2 + (100*Med2c*ho*Ab)/(2*Iefc);                
               
    }
        
    
    
    // Método: Solicitações no Painel de Extremidade PC
    
    public void SolicPainelExtrem()
    {
            
        //"Vsdc" aqui só quis um "if else" para rodar quando Med1=0. ué! mdr (07/01/16)
        
        if (Med1!=0)
        {
            Vsdc = (1/(0.01*L))*(4-(4-Math.PI)*((0.01*eo*Ned)/(0.01*eo*Ned+Med1)))*Med2c;                               
        }
        
        else            
        {
            Vsdc = Math.PI*Med2c/(L*0.01);
        }
               
               
        Nb1sdc = 0.5*Ned;
        Mb1sdc = Vsdc*a*0.01/4;
        Vcsdc = Vsdc*a/ho;
        Mcsdc = Vsdc*a*0.01/2;
        
    }
    
    
    
    // Método: Resistência das Chapas no Pianel de Extremidade PC
    
    public void ResChapasPainExt()
    {
        
        Vcrdc = 0.6*fy*hc*ec/1.1;
        
        divVc = Vcsdc/Vcrdc;
        
        Mcrdc = 0.01*ec*Math.pow(hc,2)*fy/(4*1.1);
        
        divMc = Mcsdc/Mcrdc;
        
    }
    
    
    
    // Método: Resistência do Banzo no Pianel de Extremidade PC
    
    public void ResBanzoPainExt()
    {
        
        Nb1rd = Nbyrdc;
                
        Wyb = Double.parseDouble(jTWyb.getText());
        
        Mb1rd = 0.01*Wyb*fy/1.1;             
                        
        divMNb = Nb1sdc/Nb1rd + Mb1sdc/Mb1rd;
                
        
    }
    
    
    
            
    //Método: Esforço Cortante Máximo PT
    
    public void EsforcoCortante()
    {
        
        Ved = (1/(0.01*L))*(4-(4-Math.PI)*((0.01*eo*Ned)/(0.01*eo*Ned+Med1)))*Med2;      
        
    }    
    
    
    //Método: Resistência à Flambagem No Plano do Banzo  PT / PC
    
    public void ResFlamNoPlanoBarraPT()
    {
        
        bfb = Double.parseDouble(jTbfb.getText());
        bwb = Double.parseDouble(jTbwb.getText());
        tb = Double.parseDouble(jTtb.getText());
        
        Ixb = Double.parseDouble(jTIxb.getText());
        Iyb = Double.parseDouble(jTIyb.getText());
        Itb = Double.parseDouble(jTItb.getText());
        Iwb = Double.parseDouble(jTIwb.getText());
        
        rob = Double.parseDouble(jTrob.getText());        
        
        xob = Double.parseDouble(jTxob.getText());
        
        fy = Double.parseDouble(jTfy.getText());
        
        G = Double.parseDouble(jTG.getText());
        
        
        // 1. Instabilidade da barra por flexão, por torção ou por flexo-torção
        
            // 1.1. Cálculo da Força normal de flambagem global elástica
        
                // 1.1.1. Comprimentos de flambagem
        
        Lxbn = Lybn = Lzbn = a;
        
                // 1.1.2. Força normal de flambagem global elástica
                
        Nexbn = (Math.pow(Math.PI,2)*E*Ixb)/(Math.pow(Lxbn,2));         
        
        Neybn = (Math.pow(Math.PI,2)*E*Iyb)/(Math.pow(Lybn,2));
        
        Nezbn = (1/(Math.pow(rob,2)))*(((Math.pow(Math.PI,2)*E*Iwb)/(Math.pow(Lzbn,2)))+G*Itb)  ;
        
        Nexzbn = (Nexbn + Nezbn)/(2*(1-(Math.pow(xob/rob,2))))*(1-Math.sqrt(1-((4*Nexbn*Nezbn*(1-(Math.pow(xob/rob,2))))/(Math.pow(Nexbn+Nezbn,2)))));
        
        Nebn = Math.min(Nexbn, Nexzbn);
        
        
            // 1.2. Cálculo da tensão de trabalho
        
                // 1.2.1. Índice de esbeltez
        
        lambn = Math.sqrt(Ab*fy/Nebn);
        
                // 1.2.2. Fator de redução
        
        if (lambn <= 1.5)
        {
            chibn = Math.pow(0.658, Math.pow(lambn, 2));            
        }
        
        else
        {
            chibn = 0.877/Math.pow(lambn, 2);            
        }          
        
                // 1.2.3. Tensão de trabalho
        
        sigbn = chibn*fy;
        
        
            // 1.3. Cálculo da área efetiva
        
                // 1.3.1. Elemento AL
        
        bbnAL = bfb - 2*tb;
        
        lampbnAL = (bbnAL/tb)/(0.95*Math.sqrt(0.43*E/sigbn));
        
        if (lampbnAL <= 0.673)
        {
            befbnAL = bbnAL;            
        }
        
        else
        {
            befbnAL = bbnAL*(1-(0.22/lampbnAL))/lampbnAL;            
        }
        
                // 1.3.2. Elemento AA
        
        bbnAA = bwb - 4*tb;
        
        lampbnAA = (bbnAA/tb)/(0.95*Math.sqrt(4*E/sigbn));
        
        if (lampbnAA <= 0.673)
        {
            befbnAA = bbnAA;            
        }        
        
        else
        {
            befbnAA = bbnAA*(1-(0.22/lampbnAA))/lampbnAA;            
        }
        
                // 1.3.2. Área efetiva
        
        if (befbnAL==bbnAL && befbnAA==bbnAA)
        {
            Aefbn = Ab;
        }
        
        else
        {            
            befbnAA = befbnAA + 2*tb;  // em vez de befbnAA = befbnAA + 4*tb e befbnAL + 2*tb  para compensar as áreas adicionais (inexistentes devido à curva)
            befbnAL = befbnAL + tb;
            Aefbn = befbnAA*tb*0.01 + 2*befbnAL*tb*0.01;   //não foi feito Aefbn = befbnAA*tb*0.01 + 2*(befbnAL-tb)*tb*0.01 porque já foi feito befbnAL = befbnAL + tb e não befbnAL = befbnAL + 2*tb

                    //de mm2 para cm2 e etc.  //04-02-2016 15h50  //Ndionson
            
        }
        
        
            // 1.4. Cálculo da força norma resistente de cálculo
        
        Nbyrd = chibn*Aefbn*fy/1.2;
        
        
        // Critério de resistência
        
        divbn = Nbed/Nbyrd;        
        
    }
    
    
    public void ResFlamNoPlanoBarraPC()
    {
        
        bfb = Double.parseDouble(jTbfb.getText());
        bwb = Double.parseDouble(jTbwb.getText());
        tb = Double.parseDouble(jTtb.getText());
        
        Ixb = Double.parseDouble(jTIxb.getText());
        Iyb = Double.parseDouble(jTIyb.getText());
        Itb = Double.parseDouble(jTItb.getText());
        Iwb = Double.parseDouble(jTIwb.getText());
        
        rob = Double.parseDouble(jTrob.getText());        
        
        xob = Double.parseDouble(jTxob.getText());
        
        fy = Double.parseDouble(jTfy.getText());
        
        G = Double.parseDouble(jTG.getText());
        
        
        // 1. Instabilidade da barra por flexão, por torção ou por flexo-torção
        
            // 1.1. Cálculo da Força normal de flambagem global elástica
        
                // 1.1.1. Comprimentos de flambagem
        
        Lxbnc = Lybnc = Lzbnc = a;
        
                // 1.1.2. Força normal de flambagem global elástica
                
        Nexbnc = (Math.pow(Math.PI,2)*E*Ixb)/(Math.pow(Lxbnc,2));         
        
        Neybnc = (Math.pow(Math.PI,2)*E*Iyb)/(Math.pow(Lybnc,2));
        
        Nezbnc = (1/(Math.pow(rob,2)))*(((Math.pow(Math.PI,2)*E*Iwb)/(Math.pow(Lzbnc,2)))+G*Itb)  ;
        
        Nexzbnc = (Nexbnc + Nezbnc)/(2*(1-(Math.pow(xob/rob,2))))*(1-Math.sqrt(1-((4*Nexbnc*Nezbnc*(1-(Math.pow(xob/rob,2))))/(Math.pow(Nexbnc+Nezbnc,2)))));
        
        Nebnc = Math.min(Nexbnc, Nexzbnc);
        
        
            // 1.2. Cálculo da tensão de trabalho
        
                // 1.2.1. Índice de esbeltez
        
        lambnc = Math.sqrt(Ab*fy/Nebnc);
        
                // 1.2.2. Fator de redução
        
        if (lambnc <= 1.5)
        {
            chibnc = Math.pow(0.658, Math.pow(lambnc, 2));            
        }
        
        else
        {
            chibnc = 0.877/Math.pow(lambnc, 2);            
        }          
        
                // 1.2.3. Tensão de trabalho
        
        sigbnc = chibnc*fy;
        
        
            // 1.3. Cálculo da área efetiva
        
                // 1.3.1. Elemento AL
        
        bbncAL = bfb - 2*tb;
        
        lampbncAL = (bbncAL/tb)/(0.95*Math.sqrt(0.43*E/sigbnc));
        
        if (lampbncAL <= 0.673)
        {
            befbncAL = bbncAL;            
        }
        
        else
        {
            befbncAL = bbncAL*(1-(0.22/lampbncAL))/lampbncAL;            
        }
        
                // 1.3.2. Elemento AA
        
        bbncAA = bwb - 4*tb;
        
        lampbncAA = (bbncAA/tb)/(0.95*Math.sqrt(4*E/sigbnc));
        
        if (lampbncAA <= 0.673)
        {
            befbncAA = bbncAA;            
        }        
        
        else
        {
            befbncAA = bbncAA*(1-(0.22/lampbncAA))/lampbncAA;            
        }
        
                // 1.3.2. Área efetiva
        
        if (befbncAL==bbncAL && befbncAA==bbncAA)
        {
            Aefbnc = Ab;
        }
        
        else
        {            
            befbncAA = befbncAA + 2*tb;
            befbncAL = befbncAL + tb;
            Aefbnc = befbncAA*tb*0.01 + 2*befbncAL*tb*0.01;            
        }
        
        
            // 1.4. Cálculo da força norma resistente de cálculo
        
        Nbyrdc = chibnc*Aefbnc*fy/1.2;
        
        
        // Critério de resistência
        
        divbnc = Nbedc/Nbyrdc;        
        
    }
    
    
    
    //Método: Resistência à Flambagem Fora do Plano do Banzo  PT / PC
    
    public void ResFlamForaPlanoBarraPT()
    {
        
        bfb = Double.parseDouble(jTbfb.getText());
        bwb = Double.parseDouble(jTbwb.getText());
        tb = Double.parseDouble(jTtb.getText());
        
        Ixb = Double.parseDouble(jTIxb.getText());
        Iyb = Double.parseDouble(jTIyb.getText());
        Itb = Double.parseDouble(jTItb.getText());
        Iwb = Double.parseDouble(jTIwb.getText());
        
        xob = Double.parseDouble(jTxob.getText());
        
        fy = Double.parseDouble(jTfy.getText());
        
        G = Double.parseDouble(jTG.getText());
        
        
        // 1. Instabilidade da barra por flexão, por torção ou por flexo-torção
        
            // 1.1. Cálculo da Força normal de flambagem global elástica
        
                // 1.1.1. Comprimentos de flambagem
        
        Lxbf = L/2;
                
        Lybf = Lzbf = a;
        
                // 1.1.2. Força normal de flambagem global elástica
                
        Nexbf = (Math.pow(Math.PI,2)*E*Ixb)/(Math.pow(Lxbf,2));        
        
        Neybf = (Math.pow(Math.PI,2)*E*Iyb)/(Math.pow(Lybf,2));
        
        Nezbf = (1/(Math.pow(rob,2)))*(((Math.pow(Math.PI,2)*E*Iwb)/(Math.pow(Lzbf,2)))+G*Itb);
        
        Nexzbf = (Nexbf + Nezbf)/(2*(1-(Math.pow(xob/rob,2))))*(1-Math.sqrt(1-((4*Nexbf*Nezbf*(1-(Math.pow(xob/rob,2))))/(Math.pow(Nexbf+Nezbf,2)))));
        
        Nebf = Math.min(Neybf, Nexzbf);
        
        
            // 1.2. Cálculo da tensão de trabalho
        
                // 1.2.1. Índice de esbeltez
        
        lambf = Math.sqrt(Ab*fy/Nebf);
        
                // 1.2.2. Fator de redução
        
        if (lambf <= 1.5)
        {
            chibf = Math.pow(0.658, Math.pow(lambf, 2));            
        }
        
        else
        {
            chibf = 0.877/Math.pow(lambf, 2);            
        }          
        
                // 1.2.3. Tensão de trabalho
        
        sigbf = chibf*fy;
        
        
            // 1.3. Cálculo da área efetiva
        
                // 1.3.1. Elemento AL
        
        bbfAL = bfb - 2*tb;
        
        lampbfAL = (bbfAL/tb)/(0.95*Math.sqrt(0.43*E/sigbf));
        
        if (lampbfAL <= 0.673)
        {
            befbfAL = bbfAL;            
        }
        
        else
        {
            befbfAL = bbfAL*(1-(0.22/lampbfAL))/lampbfAL;            
        }
        
                // 1.3.2. Elemento AA
        
        bbfAA = bwb - 4*tb;
        
        lampbfAA = (bbfAA/tb)/(0.95*Math.sqrt(4*E/sigbf));
        
        if (lampbfAA <= 0.673)
        {
            befbfAA = bbfAA;            
        }        
        
        else
        {
            befbfAA = bbfAA*(1-(0.22/lampbfAA))/lampbfAA;            
        }
        
                // 1.3.2. Área efetiva
        
        if (befbfAL==bbfAL && befbfAA==bbfAA)
        {
            Aefbf = Ab;
        }
        
        else
        {            
            befbfAA = befbfAA + 2*tb;
            befbfAL = befbfAL + tb;
            Aefbf = befbfAA*tb*0.01 + 2*befbfAL*tb*0.01;            
        }
        
        
            // 1.4. Cálculo da força norma resistente de cálculo
        
        Nbxrd = chibf*Aefbf*fy/1.2;
        
        
        // Critério de resistência
        
        divbf = Nbed/Nbxrd;        
        
    }    
    
    
    public void ResFlamForaPlanoBarraPC()
    {
        
        bfb = Double.parseDouble(jTbfb.getText());
        bwb = Double.parseDouble(jTbwb.getText());
        tb = Double.parseDouble(jTtb.getText());
        
        Ixb = Double.parseDouble(jTIxb.getText());
        Iyb = Double.parseDouble(jTIyb.getText());
        Itb = Double.parseDouble(jTItb.getText());
        Iwb = Double.parseDouble(jTIwb.getText());
        
        xob = Double.parseDouble(jTxob.getText());
        
        fy = Double.parseDouble(jTfy.getText());
        
        G = Double.parseDouble(jTG.getText());
        
        
        // 1. Instabilidade da barra por flexão, por torção ou por flexo-torção
        
            // 1.1. Cálculo da Força normal de flambagem global elástica
        
                // 1.1.1. Comprimentos de flambagem
        
        Lxbfc = L;
                
        Lybfc = Lzbfc = a;
        
                // 1.1.2. Força normal de flambagem global elástica
                
        Nexbfc = (Math.pow(Math.PI,2)*E*Ixb)/(Math.pow(Lxbfc,2));        
        
        Neybfc = (Math.pow(Math.PI,2)*E*Iyb)/(Math.pow(Lybfc,2));
        
        Nezbfc = (1/(Math.pow(rob,2)))*(((Math.pow(Math.PI,2)*E*Iwb)/(Math.pow(Lzbfc,2)))+G*Itb);
        
        Nexzbfc = (Nexbfc + Nezbfc)/(2*(1-(Math.pow(xob/rob,2))))*(1-Math.sqrt(1-((4*Nexbfc*Nezbfc*(1-(Math.pow(xob/rob,2))))/(Math.pow(Nexbfc+Nezbfc,2)))));
        
        Nebfc = Math.min(Neybfc, Nexzbfc);
        
        
            // 1.2. Cálculo da tensão de trabalho
        
                // 1.2.1. Índice de esbeltez
        
        lambfc = Math.sqrt(Ab*fy/Nebfc);
        
                // 1.2.2. Fator de redução
        
        if (lambfc <= 1.5)
        {
            chibfc = Math.pow(0.658, Math.pow(lambfc, 2));            
        }
        
        else
        {
            chibfc = 0.877/Math.pow(lambfc, 2);            
        }          
        
                // 1.2.3. Tensão de trabalho
        
        sigbfc = chibfc*fy;
        
        
            // 1.3. Cálculo da área efetiva
        
                // 1.3.1. Elemento AL
        
        bbfcAL = bfb - 2*tb;
        
        lampbfcAL = (bbfcAL/tb)/(0.95*Math.sqrt(0.43*E/sigbfc));
        
        if (lampbfcAL <= 0.673)
        {
            befbfcAL = bbfcAL;            
        }
        
        else
        {
            befbfcAL = bbfcAL*(1-(0.22/lampbfcAL))/lampbfcAL;            
        }
        
                // 1.3.2. Elemento AA
        
        bbfcAA = bwb - 4*tb;
        
        lampbfcAA = (bbfcAA/tb)/(0.95*Math.sqrt(4*E/sigbfc));
        
        if (lampbfcAA <= 0.673)
        {
            befbfcAA = bbfcAA;            
        }        
        
        else
        {
            befbfcAA = bbfcAA*(1-(0.22/lampbfcAA))/lampbfcAA;            
        }
        
                // 1.3.2. Área efetiva
        
        if (befbfcAL==bbfcAL && befbfcAA==bbfcAA)
        {
            Aefbfc = Ab;
        }
        
        else
        {            
            befbfcAA = befbfcAA + 2*tb;
            befbfcAL = befbfcAL + tb;
            Aefbfc = befbfcAA*tb*0.01 + 2*befbfcAL*tb*0.01;            
        }
        
        
            // 1.4. Cálculo da força norma resistente de cálculo
        
        Nbxrdc = chibfc*Aefbfc*fy/1.2;
        
        
        // Critério de resistência
        
        divbfc = Nbedc/Nbxrdc;        
        
    }    
    
            
    //Método: Resistência à Flambagem das Diagonais  PT
    
    public void ResFlamDiag()
    {
        
        bfd = Double.parseDouble(jTbfd.getText());
        bwd = Double.parseDouble(jTbwd.getText());
        td = Double.parseDouble(jTtd.getText());
        
        Ixd = Double.parseDouble(jTIxd.getText());
        Iyd = Double.parseDouble(jTIyd.getText());
        Itd = Double.parseDouble(jTItd.getText());
        Iwd = Double.parseDouble(jTIwd.getText());
        
        rod = Double.parseDouble(jTrod.getText());   
        
        xod = Double.parseDouble(jTxod.getText());
        
        fy = Double.parseDouble(jTfy.getText());
        
        G = Double.parseDouble(jTG.getText());
        
        
        // Esforço solicitante
        
        Ndsd = Ved*d/(n*ho);
        
        
        // 1. Instabilidade da barra por flexão, por torção ou por flexo-torção
        
            // 1.1. Cálculo da Força normal de flambagem global elástica
        
                // 1.1.1. Comprimentos de flambagem
        
        Lxd = Lyd = Lzd = d;
        
                // 1.1.2. Força normal de flambagem global elástica
                
        Nexd = (Math.pow(Math.PI,2)*E*Ixd)/(Math.pow(Lxd,2));        
        
        Neyd = (Math.pow(Math.PI,2)*E*Iyd)/(Math.pow(Lyd,2));
        
        Nezd = (1/(Math.pow(rod,2)))*(((Math.pow(Math.PI,2)*E*Iwd)/(Math.pow(Lzd,2)))+G*Itd);
        
        Nexzd = (Nexd + Nezd)/(2*(1-(Math.pow(xod/rod,2))))*(1-Math.sqrt(1-((4*Nexd*Nezd*(1-(Math.pow(xod/rod,2))))/(Math.pow(Nexd+Nezd,2)))));
        
        Nedd = Math.min(Nexd, Nexzd);
        
        
            // 1.2. Cálculo da tensão de trabalho
        
                // 1.2.1. Índice de esbeltez
        
        lamd = Math.sqrt(Ad*fy/Nedd);
        
                // 1.2.2. Fator de redução
        
        if (lamd <= 1.5)
        {
            chid = Math.pow(0.658, Math.pow(lamd, 2));            
        }
        
        else
        {
            chid = 0.877/Math.pow(lamd, 2);            
        }          
        
                // 1.2.3. Tensão de trabalho
        
        sigd = chid*fy;
        
        
            // 1.3. Cálculo da área efetiva
        
                // 1.3.1. Elemento AL
        
        bdAL = bfd - 2*td;
        
        lampdAL = (bdAL/td)/(0.95*Math.sqrt(0.43*E/sigd));
        
        if (lampdAL <= 0.673)
        {
            befdAL = bdAL;            
        }
        
        else
        {
            befdAL = bdAL*(1-(0.22/lampdAL))/lampdAL;            
        }
        
                // 1.3.2. Elemento AA
        
        bdAA = bwd - 4*td;
        
        lampdAA = (bdAA/td)/(0.95*Math.sqrt(4*E/sigd));
        
        if (lampdAA <= 0.673)
        {
            befdAA = bdAA;            
        }        
        
        else
        {
            befdAA = bdAA*(1-(0.22/lampdAA))/lampdAA;            
        }
        
        
        if (jRBLd.isSelected() || jRBLm.isSelected())
        {         
            bdAA = 0;                    
            befdAA = 0;                    
            lampdAA = 0;            
        }
        
        
        
                // 1.3.2. Área efetiva
        
        if (befdAL==bdAL && befdAA==bdAA)
        {
            Aefd = Ad;
        }
        
        else
        {
            
            if ((jRBLd.isSelected() || jRBLm.isSelected()))
            {                      
                befdAL = befdAL + td;
                Aefd = 2*befdAL*td*0.01;            
            }
        
            else if ((jRBUd.isSelected() || jRBUm.isSelected()))
            {            
                befdAA = befdAA + 2*td;
                befdAL = befdAL + td;
                Aefd = befdAA*td*0.01 + 2*befdAL*td*0.01;            
            }            
            
        }                               
                        
        
            // 1.4. Cálculo da força norma resistente de cálculo
        
        Ndrd = chid*Aefd*fy/1.2;
        
        
        // Critério de resistência
        
        divd = Ndsd/Ndrd;        
        
    }
    
    
    //Método: Resistência à Flambagem dos Montantes  PT
    
    public void ResFlamMont()
    {
        
        bfm = Double.parseDouble(jTbfm.getText());
        bwm = Double.parseDouble(jTbwm.getText());
        tm = Double.parseDouble(jTtm.getText());
        
        Ixm = Double.parseDouble(jTIxm.getText());
        Iym = Double.parseDouble(jTIym.getText());
        Itm = Double.parseDouble(jTItm.getText());
        Iwm = Double.parseDouble(jTIwm.getText());
        
        rom = Double.parseDouble(jTrom.getText());   
        
        xom = Double.parseDouble(jTxom.getText());
        
        fy = Double.parseDouble(jTfy.getText());
        
        G = Double.parseDouble(jTG.getText());
        
        
        // 1. Instabilidade da barra por flexão, por torção ou por flexo-torção
        
            // 1.1. Cálculo da Força normal de flambagem global elástica
        
                // 1.1.1. Comprimentos de flambagem
        
        Lxm = Lym = Lzm = ho;
        
                // 1.1.2. Força normal de flambagem global elástica
                
        Nexm = (Math.pow(Math.PI,2)*E*Ixm)/(Math.pow(Lxm,2));        
        
        Neym = (Math.pow(Math.PI,2)*E*Iym)/(Math.pow(Lym,2));
        
        Nezm = (1/(Math.pow(rom,2)))*(((Math.pow(Math.PI,2)*E*Iwm)/(Math.pow(Lzm,2)))+G*Itm);
        
        Nexzm = (Nexm + Nezm)/(2*(1-(Math.pow(xom/rom,2))))*(1-Math.sqrt(1-((4*Nexm*Nezm*(1-(Math.pow(xom/rom,2))))/(Math.pow(Nexm+Nezm,2)))));
        
        Nem = Math.min(Nexm, Nexzm);
        
        
            // 1.2. Cálculo da tensão de trabalho
        
                // 1.2.1. Índice de esbeltez
        
        lamm = Math.sqrt(Am*fy/Nem);
        
                // 1.2.2. Fator de redução
        
        if (lamm <= 1.5)
        {
            chim = Math.pow(0.658, Math.pow(lamm, 2));            
        }
        
        else
        {
            chim = 0.877/Math.pow(lamm, 2);            
        }          
        
                // 1.2.3. Tensão de trabalho
        
        sigm = chim*fy;
        
        
            // 1.3. Cálculo da área efetiva
        
                // 1.3.1. Elemento AL
        
        bmAL = bfm - 2*tm;
        
        lampmAL = (bmAL/tm)/(0.95*Math.sqrt(0.43*E/sigm));
        
        if (lampmAL <= 0.673)
        {
            befmAL = bmAL;            
        }
        
        else
        {
            befmAL = bmAL*(1-(0.22/lampmAL))/lampmAL;            
        }
        
                // 1.3.2. Elemento AA
        
        bmAA = bwm - 4*tm;
        
        lampmAA = (bmAA/tm)/(0.95*Math.sqrt(4*E/sigm));
        
        if (lampmAA <= 0.673)
        {
            befmAA = bmAA;            
        }        
        
        else
        {
            befmAA = bmAA*(1-(0.22/lampmAA))/lampmAA;            
        }
        
        
        if (jRBLd.isSelected() || jRBLm.isSelected())
        {         
            bmAA = 0;                    
            befmAA = 0;                    
            lampmAA = 0;            
        }
        
        
                // 1.3.2. Área efetiva
        
        if (befmAL==bmAL && befmAA==bmAA)
        {
            Aefm = Am;
        }
        
        else
        {        
            
            if ((jRBLd.isSelected() || jRBLm.isSelected()))
            {                      
                befmAL = befmAL + td;
                Aefm = 2*befmAL*td*0.01;            
            }
        
            else if ((jRBUd.isSelected() || jRBUm.isSelected()))
            {            
                befmAA = befmAA + 2*tm;
                befmAL = befmAL + tm;
                Aefm = befmAA*tm*0.01 + 2*befmAL*tm*0.01;        
            }                
                                                                   
        }
        
        
            // 1.4. Cálculo da força norma resistente de cálculo
        
        Nmrd = chim*Aefm*fy/1.2;
        
        
        // Critério de resistência
        
        divm = Ved/Nmrd;        
        
    }        
    
    
    //Método: Resistência à Tração de um Elemento da Treliça  PT
    
    public void ResTracao()
    {
        
        xgd = Double.parseDouble(jTxgd.getText());
        l1 = Double.parseDouble(jTl1.getText());
        fu = Double.parseDouble(jTfu.getText());        
        
        Ntrd1 = Ad*fy/1.1;
        
        //Cantoneiras        
        if (jRBLd.isSelected() || jRBLm.isSelected())
        {            
            Ct = 1 - 1.2*xgd/(l1*0.1);
        }
                
        //Perfis U        
        if (jRBUd.isSelected() || jRBUm.isSelected())
        {            
            Ct = 1 - 0.36*xgd/(l1*0.1);
        }
        
        
        Ntrd2 = Ct*Ad*fu/1.65;
                
        Ntrd = Math.min(Ntrd1, Ntrd2);
        
        Ntsd = Ndsd;
        
        divt = Ntsd/Ntrd;
        
    }
    
    
       
    //Método: Resistênica da Ligação Soldada Diagonal - Banzo  PT / PC
    
    public void ResLigacaoPT()
    {
        
        tef = Double.parseDouble(jTtef.getText());
        l1 = Double.parseDouble(jTl1.getText());
        l2 = Double.parseDouble(jTl2.getText());
        l3 = Double.parseDouble(jTl3.getText());
        fw = Double.parseDouble(jTfw.getText());        
        
        Lf = l1 + l2 + l3;
        
        Frd = 0.75*tef*Lf*fw*0.01/1.65;              
        
        divl = Ntsd/Frd;       
        
    }    
    
   
    public void ResLigacaoPC()
    {
        hc = Double.parseDouble(jThc.getText());
        ec = Double.parseDouble(jTec.getText());
        tef = Double.parseDouble(jTtef.getText());
        l1 = Double.parseDouble(jTl1.getText());
        l2 = Double.parseDouble(jTl2.getText());
        l3 = Double.parseDouble(jTl3.getText());
        fw = Double.parseDouble(jTfw.getText());        
        
        Lfc = l1 + l2 + l3;
        
        Frdc = 0.75*tef*Lfc*fw*0.01/1.65;              
        
        // Ntsdc = Ntrdc  Solicitação considerada como a máxima tração admitida na chapa.
        //Ntsdc = hc*ec*fy/1.1;
        
        Ntsdc = Vcsdc;  //ou Vsdc
        
        divlc = Ntsdc/Frdc;       
        
    }   
    
    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTNed = new javax.swing.JTextField();
        jTMed1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBclrdca = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTL = new javax.swing.JTextField();
        jTho = new javax.swing.JTextField();
        jTa = new javax.swing.JTextField();
        jTd = new javax.swing.JTextField();
        jTn = new javax.swing.JTextField();
        jBclrpi = new javax.swing.JButton();
        jPdetalhe = new javax.swing.JPanel();
        jLDetalhe = new javax.swing.JLabel();
        jPpilar = new javax.swing.JPanel();
        jLPilar = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jBLimpar = new javax.swing.JButton();
        jBProcessar = new javax.swing.JButton();
        jBResultados = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTtef = new javax.swing.JTextField();
        jTl1 = new javax.swing.JTextField();
        jTl2 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jTfw = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jTl3 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jBprfb = new javax.swing.JButton();
        jBclrb = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTbfb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTbwb = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTtb = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTrib = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTAb = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTIxb = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTIyb = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTxgb = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTItb = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTIwb = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTrob = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTxob = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTmb = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLWyb = new javax.swing.JLabel();
        jTWyb = new javax.swing.JTextField();
        jLWyb1 = new javax.swing.JLabel();
        jLWyb2 = new javax.swing.JLabel();
        jTWxb = new javax.swing.JTextField();
        jLWyb3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jThc = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTec = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jBclrch = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLdivF1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTG = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jBclrpa = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTfy = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTfu = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTE = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLdivF = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jBprfd = new javax.swing.JButton();
        jBclrd = new javax.swing.JButton();
        jRBLd = new javax.swing.JRadioButton();
        jRBUd = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTbfd = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTbwd = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jTtd = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jTrid = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jTAd = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jTIxd = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jTIyd = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jTxgd = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jTItd = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jTIwd = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jTrod = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jTxod = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jTmd = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLWyb4 = new javax.swing.JLabel();
        jTWyd = new javax.swing.JTextField();
        jLWyb5 = new javax.swing.JLabel();
        jLWyb6 = new javax.swing.JLabel();
        jTWxd = new javax.swing.JTextField();
        jLWyb7 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jBprfm = new javax.swing.JButton();
        jBclrm = new javax.swing.JButton();
        jRBLm = new javax.swing.JRadioButton();
        jRBUm = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jTbfm = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jTbwm = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jTtm = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jTrim = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jTAm = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jTIxm = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jTIym = new javax.swing.JTextField();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jTxgm = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jTItm = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jTIwm = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jTrom = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jTxom = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jTmm = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLWyb8 = new javax.swing.JLabel();
        jTWym = new javax.swing.JTextField();
        jLWyb9 = new javax.swing.JLabel();
        jLWyb10 = new javax.swing.JLabel();
        jTWxm = new javax.swing.JTextField();
        jLWyb11 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jBpN = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBpC = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMPerfis = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemVisualA = new javax.swing.JMenuItem();
        jMenuItemVisualB = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PIMECO - Verificação de Pilares Metálicos Compostos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DADOS"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Carregamento"));

        jLabel1.setText("<html>N<sub>Sd</sub>");
        jLabel1.setToolTipText("Esforço normal solicitante de cálculo");

        jLabel2.setText("<html>M<sub>Sd</sub>");
        jLabel2.setToolTipText("Momento fletor solicitante de cálculo");

        jLabel4.setText("kN");

        jLabel5.setText("kN.m");

        jBclrdca.setText("Clr");
        jBclrdca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrdcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBclrdca))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTNed, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jTMed1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTMed1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBclrdca))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pilar"));

        jLabel7.setText("L");
        jLabel7.setToolTipText("Altura do pilar");

        jLabel8.setText("<html>h<sub>0</sub>");
        jLabel8.setToolTipText("Distância entre os centros de gravidade dos banzos");

        jLabel9.setText("a");
        jLabel9.setToolTipText("Altura de um painel");

        jLabel10.setText("cm");

        jLabel11.setText("cm");

        jLabel12.setText("cm");

        jLabel13.setText("d");
        jLabel13.setToolTipText("Comprimento da diagonal");

        jLabel14.setText("n");
        jLabel14.setToolTipText("Número de planos da treliça");

        jLabel15.setText("cm");

        jTn.setEditable(false);
        jTn.setBackground(java.awt.Color.white);
        jTn.setToolTipText("Escolher o tipo de perfil: L ou U. Para pilares com chapas, n = 2.");

        jBclrpi.setText("Clr");
        jBclrpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrpiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTL, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTho, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBclrpi))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTL, jTa, jTd, jTn});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBclrpi))
        );

        jPdetalhe.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalhe do Pilar"));
        jPdetalhe.setPreferredSize(new java.awt.Dimension(187, 217));

        jLDetalhe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Detalhe N-shape.jpg"))); // NOI18N

        javax.swing.GroupLayout jPdetalheLayout = new javax.swing.GroupLayout(jPdetalhe);
        jPdetalhe.setLayout(jPdetalheLayout);
        jPdetalheLayout.setHorizontalGroup(
            jPdetalheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPdetalheLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLDetalhe)
                .addGap(98, 98, 98))
        );
        jPdetalheLayout.setVerticalGroup(
            jPdetalheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdetalheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLDetalhe, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPpilar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Descrição do Pilar"));

        jLPilar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Pilar treliçado N-shape.jpg"))); // NOI18N

        javax.swing.GroupLayout jPpilarLayout = new javax.swing.GroupLayout(jPpilar);
        jPpilar.setLayout(jPpilarLayout);
        jPpilarLayout.setHorizontalGroup(
            jPpilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPpilarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLPilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPpilarLayout.setVerticalGroup(
            jPpilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPpilarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLPilar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBLimpar.setText("LIMPAR");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jBProcessar.setText("PROCESSAR");
        jBProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcessarActionPerformed(evt);
            }
        });

        jBResultados.setText("RELATÓRIO");
        jBResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBProcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBResultados)
                .addGap(36, 36, 36))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBProcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBLimpar)
                        .addComponent(jBResultados)))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBLimpar, jBProcessar, jBResultados});

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ligação soldada"));

        jLabel43.setText("<html>t<sub>ef</sub>");
        jLabel43.setToolTipText("Garganta efetiva");

        jLabel47.setText("<html>l<sub>1</sub>");
        jLabel47.setToolTipText("Comprimento do filete de solda");

        jLabel55.setText("<html>l<sub>2</sub>");
        jLabel55.setToolTipText("Comprimento do filete de solda");

        jLabel56.setText("mm");

        jLabel61.setText("mm");

        jLabel62.setText("mm");

        jButton12.setText("Clr");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel35.setText("<html>f<sub>w</sub>");
        jLabel35.setToolTipText("Resistência à ruptura da solda");

        jLabel40.setText("<html>kN/cm<sup>2</sup>");

        jLabel63.setText("<html>l<sub>3</sub>");
        jLabel63.setToolTipText("Comprimento do filete de solda");

        jLabel64.setText("mm");

        jButton15.setText("LS");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTtef, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jTfw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTl3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTfw, jTl1, jTl2, jTl3, jTtef});

        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTfw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTtef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton15)))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Banzos"));
        jPanel25.setPreferredSize(new java.awt.Dimension(187, 314));

        jLabel46.setText("Perfil U :");

        jBprfb.setText("Prf");
        jBprfb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBprfbActionPerformed(evt);
            }
        });

        jBclrb.setText("Clr");
        jBclrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrbActionPerformed(evt);
            }
        });

        jLabel6.setText("<html>b<sub>f</sub>");
        jLabel6.setToolTipText("Largura nominal da mesa");

        jLabel3.setText("mm");

        jLabel16.setText("<html>b<sub>w</sub>");
        jLabel16.setToolTipText("Largura nominal da alma");

        jLabel45.setText("mm");

        jLabel17.setText("t");
        jLabel17.setToolTipText("Espessura do elemento");

        jLabel48.setText("mm");

        jLabel44.setText("<html>r<sub>i</sub>");
        jLabel44.setToolTipText("Raio interno de dobramento");

        jTrib.setToolTipText("opcional");

        jLabel70.setText("mm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTbfb, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbwb, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrib, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(jLabel45)
                    .addComponent(jLabel3)
                    .addComponent(jLabel48))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTbfb, jTbwb, jTrib, jTtb});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbfb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbwb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel17))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setText("<html>A<sub>b</sub>");
        jLabel20.setToolTipText("Área bruta da seção transversal da barra");

        jLabel49.setText("<html>cm<sup>2</sup>");

        jLabel19.setText("<html>I<sub>x</sub>");
        jLabel19.setToolTipText("Momento de inércia da seção bruta em relação ao eixo principal x");

        jLabel51.setText("<html>cm<sup>4</sup>");

        jLabel18.setText("<html>I<sub>y</sub>");
        jLabel18.setToolTipText("Momento de inércia da seção bruta em relação ao eixo principal y");

        jLabel52.setText("<html>cm<sup>4</sup>");

        jLabel26.setText("<html>x<sub>g</sub>");
        jLabel26.setToolTipText("Distância do centróide em relação à linha média da alma na direção x");

        jLabel66.setText("cm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jTAb, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTIyb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxgb, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTIxb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTAb, jTIxb, jTIyb, jTxgb});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTIxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIyb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxgb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setText("<html>I<sub>t</sub>");
        jLabel21.setToolTipText("Constante de torção");

        jLabel53.setText("<html>cm<sup>4</sup>");

        jLabel23.setText("<html>I<sub>w</sub>");
        jLabel23.setToolTipText("Constante de empenamento da seção transversal");

        jLabel54.setText("<html>cm<sup>6</sup>");

        jLabel24.setText("<html>r<sub>0</sub>");
        jLabel24.setToolTipText("Raio de giração polar da seção bruta em relação ao centro de torção");

        jLabel65.setText("cm");

        jLabel36.setText("<html>x<sub>0</sub>");
        jLabel36.setToolTipText("Distância do centro de torção ao centróide na direção x");

        jLabel67.setText("cm");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTItb, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIwb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(jLabel65)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTItb, jTIwb, jTrob, jTxob});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTItb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIwb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTmb.setToolTipText("opcional");

        jLabel69.setText("kg/m");

        jLabel27.setText("m");
        jLabel27.setToolTipText("Massa linear do elemento");

        jLWyb.setText("<html>W<sub>y</sub>");
        jLWyb.setToolTipText("Módulo de resistência elástico da seção bruta em relação ao eixo y");

        jLWyb1.setText("<html>cm<sup>3</sup>");

        jLWyb2.setText("<html>W<sub>x</sub>");
        jLWyb2.setToolTipText("Módulo de resistência elástico da seção bruta em relação ao eixo x");

        jTWxb.setToolTipText("opcional");

        jLWyb3.setText("<html>cm<sup>3</sup>");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLWyb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jTmb, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTWyb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTWxb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(jLWyb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTWxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWyb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWyb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLWyb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTWyb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBprfb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBclrb, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))))))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBclrb, jBprfb});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBclrb)
                            .addComponent(jBprfb)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chapas"));

        jLabel38.setText("h");
        jLabel38.setToolTipText("Altura da chapa");

        jLabel41.setText("cm");

        jLabel39.setText("e");
        jLabel39.setToolTipText("Espessura da chapa");

        jLabel42.setText("cm");

        jBclrch.setText("Clr");
        jBclrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jThc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTec, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBclrch))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jThc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBclrch))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Normas utilizadas"));

        jLdivF1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLdivF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLdivF1.setText("EUROCODE 3,  NBR 14762  e  NBR 6355");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLdivF1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLdivF1)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Propriedades do Aço"));

        jLabel25.setText("G");
        jLabel25.setToolTipText("Módulo de elasticidade transversal");

        jLabel28.setText("<html>kN/cm<sup>2</sup>");

        jBclrpa.setText("Clr");
        jBclrpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrpaActionPerformed(evt);
            }
        });

        jLabel29.setText("<html>f<sub>y</sub>");
        jLabel29.setToolTipText("Tensão de escoamento");

        jLabel30.setText("<html>kN/cm<sup>2</sup>");

        jLabel31.setText("<html>f<sub>u</sub>");
        jLabel31.setToolTipText("Tensão de ruptura");

        jLabel32.setText("<html>kN/cm<sup>2</sup>");

        jLabel33.setText("E");
        jLabel33.setToolTipText("Módulo de elasticidade longitudinal");

        jLabel34.setText("<html>kN/cm<sup>2</sup>");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBclrpa))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTfy, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTG, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTfu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTE, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTfy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTfu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBclrpa))
        );

        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLdivF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLdivF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLdivF.setText(".");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLdivF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLdivF)
                .addContainerGap())
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Diagonais"));
        jPanel28.setPreferredSize(new java.awt.Dimension(187, 314));

        jLabel71.setText("Perfi L ou U :");

        jBprfd.setText("Prf");
        jBprfd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBprfdActionPerformed(evt);
            }
        });

        jBclrd.setText("Clr");
        jBclrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrdActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBLd);
        jRBLd.setText("Perfil L");
        jRBLd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBLdActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBUd);
        jRBUd.setText("Perfil U");
        jRBUd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBUdActionPerformed(evt);
            }
        });

        jLabel37.setText("<html>b<sub>f</sub>");
        jLabel37.setToolTipText("Largura nominal da mesa");

        jLabel50.setText("mm");

        jLabel58.setText("<html>b<sub>w</sub>");
        jLabel58.setToolTipText("Largura nominal da alma");

        jLabel59.setText("mm");

        jLabel60.setText("t");
        jLabel60.setToolTipText("Espessura do elemento");

        jLabel68.setText("mm");

        jLabel123.setText("<html>r<sub>i</sub>");
        jLabel123.setToolTipText("Raio interno de dobramento");

        jTrid.setToolTipText("opcional");

        jLabel124.setText("mm");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTbfd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbwd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrid, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel124)
                    .addComponent(jLabel59)
                    .addComponent(jLabel50)
                    .addComponent(jLabel68))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTbfd, jTbwd, jTrid, jTtd});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbfd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel60))
                .addGap(7, 7, 7)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel124))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel125.setText("<html>A<sub>d</sub>");
        jLabel125.setToolTipText("Área bruta da seção transversal da barra");

        jLabel126.setText("<html>cm<sup>2</sup>");

        jLabel127.setText("<html>I<sub>x</sub>");
        jLabel127.setToolTipText("Momento de inércia da seção bruta em relação ao eixo principal x");

        jLabel128.setText("<html>cm<sup>4</sup>");

        jLabel129.setText("<html>I<sub>y</sub>");
        jLabel129.setToolTipText("Momento de inércia da seção bruta em relação ao eixo principal y");

        jLabel130.setText("<html>cm<sup>4</sup>");

        jLabel131.setText("<html>x<sub>g</sub>");
        jLabel131.setToolTipText("Distância do centróide em relação à linha média da alma na direção x");

        jLabel132.setText("cm");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jTAd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTIyd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxgd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTIxd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel132)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTAd, jTIxd, jTIyd, jTxgd});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTIxd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIyd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxgd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel133.setText("<html>I<sub>t</sub>");
        jLabel133.setToolTipText("Constante de torção");

        jLabel134.setText("<html>cm<sup>4</sup>");

        jLabel135.setText("<html>I<sub>w</sub>");
        jLabel135.setToolTipText("Constante de empenamento da seção transversal");

        jLabel136.setText("<html>cm<sup>6</sup>");

        jLabel137.setText("<html>r<sub>0</sub>");
        jLabel137.setToolTipText("Raio de giração polar da seção bruta em relação ao centro de torção");

        jLabel138.setText("cm");

        jLabel139.setText("<html>x<sub>0</sub>");
        jLabel139.setToolTipText("Distância do centro de torção ao centróide na direção x");

        jLabel140.setText("cm");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTItd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel140)
                    .addComponent(jLabel138)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTItd, jTIwd, jTrod, jTxod});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTItd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTmd.setToolTipText("opcional");

        jLabel72.setText("kg/m");

        jLabel57.setText("m");
        jLabel57.setToolTipText("Massa linear do elemento");

        jLWyb4.setText("<html>W<sub>y</sub>");
        jLWyb4.setToolTipText("Módulo de resistência elástico da seção bruta em relação ao eixo y");

        jTWyd.setToolTipText("opcional");

        jLWyb5.setText("<html>cm<sup>3</sup>");

        jLWyb6.setText("<html>W<sub>x</sub>");
        jLWyb6.setToolTipText("Módulo de resistência elástico da seção bruta em relação ao eixo x");

        jTWxd.setToolTipText("opcional");

        jLWyb7.setText("<html>cm<sup>3</sup>");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jLWyb4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jTmd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTWyd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTWxd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(jLWyb5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTWxd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWyb6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWyb7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLWyb4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTWyd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addGap(18, 18, 18)
                        .addComponent(jRBLd)
                        .addGap(18, 18, 18)
                        .addComponent(jRBUd)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(0, 49, Short.MAX_VALUE)
                                .addComponent(jBprfd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBclrd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBclrd, jBprfd});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBLd)
                    .addComponent(jRBUd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBprfd)
                            .addComponent(jBclrd)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Montantes"));
        jPanel29.setPreferredSize(new java.awt.Dimension(187, 314));

        jLabel97.setText("Perfil L ou U :");

        jBprfm.setText("Prf");
        jBprfm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBprfmActionPerformed(evt);
            }
        });

        jBclrm.setText("Clr");
        jBclrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclrmActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBLm);
        jRBLm.setText("Perfil L");
        jRBLm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBLmActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBUm);
        jRBUm.setText("Perfil U");
        jRBUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBUmActionPerformed(evt);
            }
        });

        jLabel143.setText("<html>b<sub>f</sub>");
        jLabel143.setToolTipText("Largura nominal da mesa");

        jLabel144.setText("mm");

        jLabel145.setText("<html>b<sub>w</sub>");
        jLabel145.setToolTipText("Largura nominal da alma");

        jLabel146.setText("mm");

        jLabel147.setText("t");
        jLabel147.setToolTipText("Espessura do elemento");

        jLabel148.setText("mm");

        jLabel149.setText("<html>r<sub>i</sub>");
        jLabel149.setToolTipText("Raio interno de dobramento");

        jTrim.setToolTipText("opcional");

        jLabel150.setText("mm");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel147)
                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTbfm, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbwm, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrim, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel150)
                    .addComponent(jLabel146)
                    .addComponent(jLabel144)
                    .addComponent(jLabel148))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTbfm, jTbwm, jTrim, jTtm});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbfm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel144))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTbwm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel146))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel148)
                    .addComponent(jLabel147))
                .addGap(7, 7, 7)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel150))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel151.setText("<html>A<sub>m</sub>");
        jLabel151.setToolTipText("Área bruta da seção transversal da barra");

        jLabel152.setText("<html>cm<sup>2</sup>");

        jLabel153.setText("<html>I<sub>x</sub>");
        jLabel153.setToolTipText("Momento de inércia da seção bruta em relação ao eixo principal x");

        jLabel154.setText("<html>cm<sup>4</sup>");

        jLabel155.setText("<html>I<sub>y</sub>");
        jLabel155.setToolTipText("Momento de inércia da seção bruta em relação ao eixo principal y");

        jLabel156.setText("<html>cm<sup>4</sup>");

        jLabel157.setText("<html>x<sub>g</sub>");
        jLabel157.setToolTipText("Distância do centróide em relação à linha média da alma na direção x");

        jLabel158.setText("cm");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jTAm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTIym, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxgm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTIxm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel158)
                    .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTAm, jTIxm, jTIym, jTxgm});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTIxm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIym, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxgm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel158))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel159.setText("<html>I<sub>t</sub>");
        jLabel159.setToolTipText("Constante de torção");

        jLabel160.setText("<html>cm<sup>4</sup>");

        jLabel161.setText("<html>I<sub>w</sub>");
        jLabel161.setToolTipText("Constante de empenamento da seção transversal");

        jLabel162.setText("<html>cm<sup>6</sup>");

        jLabel163.setText("<html>r<sub>0</sub>");
        jLabel163.setToolTipText("Raio de giração polar da seção bruta em relação ao centro de torção");

        jLabel164.setText("cm");

        jLabel165.setText("<html>x<sub>0</sub>");
        jLabel165.setToolTipText("Distância do centro de torção ao centróide na direção x");

        jLabel166.setText("cm");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTItm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIwm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel166)
                    .addComponent(jLabel164)
                    .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTItm, jTIwm, jTrom, jTxom});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTItm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTIwm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel166))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTmm.setToolTipText("opcional");

        jLabel73.setText("kg/m");

        jLabel74.setText("m");
        jLabel74.setToolTipText("Massa linear do elemento");

        jLWyb8.setText("<html>W<sub>y</sub>");
        jLWyb8.setToolTipText("Módulo de resistência elástico da seção bruta em relação ao eixo y");

        jTWym.setToolTipText("opcional");

        jLWyb9.setText("<html>cm<sup>3</sup>");

        jLWyb10.setText("<html>W<sub>x</sub>");
        jLWyb10.setToolTipText("Módulo de resistência elástico da seção bruta em relação ao eixo x");

        jTWxm.setToolTipText("opcional");

        jLWyb11.setText("<html>cm<sup>3</sup>");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jLWyb8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jTmm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTWym, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTWxm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73)
                    .addComponent(jLWyb9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTmm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTWxm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWyb10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWyb11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLWyb9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLWyb8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTWym, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addGap(18, 18, 18)
                        .addComponent(jRBLm)
                        .addGap(18, 18, 18)
                        .addComponent(jRBUm)
                        .addGap(0, 381, Short.MAX_VALUE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(0, 46, Short.MAX_VALUE)
                                .addComponent(jBprfm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBclrm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jPanel29Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBclrm, jBprfm});

        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBLm)
                    .addComponent(jRBUm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBprfm)
                            .addComponent(jBclrm)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPpilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPdetalhe, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPpilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPdetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPdetalhe.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBpN.setText("N-shape");
        jBpN.setFocusable(false);
        jBpN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBpN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBpN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpNActionPerformed(evt);
            }
        });
        jToolBar1.add(jBpN);

        jButton2.setText("V-shape");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton13.setText("K-shape");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton13);

        jButton3.setText("X-shape");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jBpC.setText("Chapas");
        jBpC.setFocusable(false);
        jBpC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBpC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBpC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpCActionPerformed(evt);
            }
        });
        jToolBar1.add(jBpC);

        jMenu1.setText("Arquivo");
        jMenu1.setNextFocusableComponent(jTNed);

        jMenuItem4.setText("Sair");
        jMenuItem4.setNextFocusableComponent(jTNed);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pilares");
        jMenu2.setNextFocusableComponent(jTNed);

        jMenu10.setText("Treliçado");
        jMenu10.setNextFocusableComponent(jTNed);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("N-shape     ");
        jMenuItem1.setNextFocusableComponent(jTNed);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("V-shape");
        jMenuItem2.setNextFocusableComponent(jTNed);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem2);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setText("K-shape");
        jMenuItem6.setNextFocusableComponent(jTNed);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem6);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("X-shape");
        jMenuItem3.setNextFocusableComponent(jTNed);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem3);

        jMenu2.add(jMenu10);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Chapas");
        jMenuItem5.setNextFocusableComponent(jTNed);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMPerfis.setText("Perfis");
        jMPerfis.setNextFocusableComponent(jTNed);
        jMPerfis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMPerfisMouseClicked(evt);
            }
        });
        jMPerfis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPerfisActionPerformed(evt);
            }
        });

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Perfis Cadastrados");
        jMenuItem7.setNextFocusableComponent(jTNed);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMPerfis.add(jMenuItem7);

        jMenuBar1.add(jMPerfis);

        jMenu4.setText("Visual");
        jMenu4.setNextFocusableComponent(jTNed);

        jMenuItemVisualA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemVisualA.setText("Visual A     ");
        jMenuItemVisualA.setNextFocusableComponent(jTNed);
        jMenuItemVisualA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualAActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemVisualA);

        jMenuItemVisualB.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemVisualB.setText("Visual B");
        jMenuItemVisualB.setNextFocusableComponent(jTNed);
        jMenuItemVisualB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualBActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemVisualB);

        jMenuBar1.add(jMenu4);

        jMenu8.setText("Ajuda");
        jMenu8.setNextFocusableComponent(jTNed);

        jMenuItemSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemSobre.setText("Sobre...");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemSobre);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcessarActionPerformed
        
       
        if (jan==1 || jan==3 || jan==4 || jan==5)
        {
            try
            {
                
            
            EsforcoCompressaoPT();
        
            EsforcoCortante();

            ResFlamNoPlanoBarraPT();

            ResFlamForaPlanoBarraPT();

            ResFlamDiag();

            ResFlamMont();

            ResTracao();

            ResLigacaoPT();
            
            
            jLdivF.setVisible(true);
        
            //System.out.printf("Nezb = %.5f\n",Nezbn);             


            //Resultado Final

            JFResPT obj1 = new JFResPT();


                // Resistência à flambagem no plano do banzo 

                if (divbn>1)
                    {
                        obj1.jLdivbn.setText("NÃO ACEITO !");
                        obj1.jLdivbn1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivbn.setText("OK !");

                        if(divbn<1)
                                {
                                    obj1.jLdivbn1.setText("< 1");
                                }
                        else
                        obj1.jLdivbn1.setText("= 1");
                    }


                // Resistência à flambagem fora do plano do banzo

                    if (divbf>1)
                    {
                        obj1.jLdivbf.setText("NÃO ACEITO !");
                        obj1.jLdivbf1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivbf.setText("OK !");

                        if(divbf<1)
                                {
                                    obj1.jLdivbf1.setText("< 1");
                                }
                        else
                        obj1.jLdivbf1.setText("= 1");
                    }


                // Resistência à flambagem das diagonais

                    if (divd>1)
                    {
                        obj1.jLdivd.setText("NÃO ACEITO !");
                        obj1.jLdivd1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivd.setText("OK !");

                        if(divd<1)
                                {
                                    obj1.jLdivd1.setText("< 1");
                                }
                        else
                        obj1.jLdivd1.setText("= 1");
                    }


                // Resistência à flambagem dos montantes

                    if (divm>1)
                    {
                        obj1.jLdivm.setText("NÃO ACEITO !");
                        obj1.jLdivm1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivm.setText("OK !");

                        if(divm<1)
                                {
                                    obj1.jLdivm1.setText("< 1");
                                }
                        else
                        obj1.jLdivm1.setText("= 1");
                    }


                // Resistência à tração

                    if (divt>1)
                    {
                        obj1.jLdivt.setText("NÃO ACEITO !");
                        obj1.jLdivt1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivt.setText("OK !");

                        if(divt<1)
                                {
                                    obj1.jLdivt1.setText("< 1");
                                }
                        else
                        obj1.jLdivt1.setText("= 1");
                    }      



                // Resistência da ligação soldada

                    if (divl>1)
                    {
                        obj1.jLdivl.setText("NÃO ACEITO !");
                        obj1.jLdivl1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivl.setText("OK !");

                        if(divl<1)
                                {
                                    obj1.jLdivl1.setText("< 1");
                                }
                        else
                        obj1.jLdivl1.setText("= 1");
                    }


            div1r = obj1.jLdivbn.getText();
            div2r = obj1.jLdivbf.getText();
            div3r = obj1.jLdivd.getText();
            div4r = obj1.jLdivm.getText();
            div5r = obj1.jLdivt.getText();
            div6r = obj1.jLdivl.getText();        

            if (div1r.equals("OK !") && div1r.equals(div2r) && div2r.equals(div3r) && div3r.equals(div4r) && div4r.equals(div5r) && div5r.equals(div6r) && div6r.equals(div1r))
                jLdivF.setText("PILAR ACEITO !");

            else
                jLdivF.setText("PILAR NÃO ACEITO !");
            
            
            JOptionPane.showMessageDialog(this, "Dados processados com sucesso!");
            
            jBResultados.setEnabled(true);
            
             }
        
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "Dados não processados!");
                
                jBResultados.setEnabled(false);
                
                jLdivF.setText(" ");
                
            }
            

            }
        
        
        // JANELA COM CHAPAS
        
        else
        {
            try
                
            {
                
                EsforcoCompressaoPC();
            
            RigidezChapas();
            
            ResFlamNoPlanoBarraPC();

            ResFlamForaPlanoBarraPC();
            
            SolicPainelExtrem();
            
            ResChapasPainExt();
            
            ResBanzoPainExt();
            
             ResLigacaoPC();        
                


            jLdivF.setVisible(true); 
                      


            //Resultado Final

            JFResPC obj1 = new JFResPC();


                // Resistência à flambagem no plano do banzo 

                if (divbnc>1)
                    {
                        obj1.jLdivbn.setText("NÃO ACEITO !");
                        obj1.jLdivbn1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivbn.setText("OK !");

                        if(divbnc<1)
                                {
                                    obj1.jLdivbn1.setText("< 1");
                                }
                        else
                        obj1.jLdivbn1.setText("= 1");
                    }


                // Resistência à flambagem fora do plano do banzo

                    if (divbfc>1)
                    {
                        obj1.jLdivbf.setText("NÃO ACEITO !");
                        obj1.jLdivbf1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivbf.setText("OK !");

                        if(divbfc<1)
                                {
                                    obj1.jLdivbf1.setText("< 1");
                                }
                        else
                        obj1.jLdivbf1.setText("= 1");
                    }

                    
                    
                // Resistência Chapas Painel Extremidade
                    
                    // Cisalhamento

                    if (divVc>1)
                    {
                        obj1.jLdivVc.setText("NÃO ACEITO !");
                        obj1.jLdivVc1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivVc.setText("OK !");

                        if(divVc<1)
                                {
                                    obj1.jLdivVc1.setText("< 1");
                                }
                        else
                        obj1.jLdivVc1.setText("= 1");
                    }

                    
                    // Flexão pura

                    if (divMc>1)
                    {
                        obj1.jLdivMc.setText("NÃO ACEITO !");
                        obj1.jLdivMc1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivMc.setText("OK !");

                        if(divMc<1)
                                {
                                    obj1.jLdivMc1.setText("< 1");
                                }
                        else
                        obj1.jLdivMc1.setText("= 1");
                    }
                    
                   
                    
                    
                // Resistência Banzo Painel Extremidade
                    
                    // Flambagem, Banzo submetido à flexo-compressão

                    if (divMNb>1)
                    {
                        obj1.jLdivMNb.setText("NÃO ACEITO !");
                        obj1.jLdivMNb1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivMNb.setText("OK !");

                        if(divMNb<1)
                                {
                                    obj1.jLdivMNb1.setText("< 1");
                                }
                        else
                        obj1.jLdivMNb.setText("= 1");
                    }    
                   
                    
                    
                    
                // Resistência da ligação soldada

                    if (divlc>1)
                    {
                        obj1.jLdivlc.setText("NÃO ACEITO !");
                        obj1.jLdivlc1.setText("> 1");
                    }
                    else
                    {
                        obj1.jLdivlc.setText("OK !");

                        if(divlc<1)
                                {
                                    obj1.jLdivlc1.setText("< 1");
                                }
                        else
                        obj1.jLdivlc1.setText("= 1");
                    }


            div1r = obj1.jLdivbn.getText();
            div2r = obj1.jLdivbf.getText();
            div3r = obj1.jLdivVc.getText();
            div4r = obj1.jLdivMc.getText();
            div5r = obj1.jLdivMNb.getText();
            div6r = obj1.jLdivlc.getText();            
                   

            if (div1r.equals("OK !") && div1r.equals(div2r) && div2r.equals(div3r) && div3r.equals(div4r) && div4r.equals(div5r) && div5r.equals(div6r) && div6r.equals(div1r))
                jLdivF.setText("PILAR ACEITO !");

            else
                jLdivF.setText("PILAR NÃO ACEITO !"); 
            
            JOptionPane.showMessageDialog(this, "Dados processados com sucesso!");
            
            jBResultados.setEnabled(true);
                
                
            }
            
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "Dados não processados!");
                
                jBResultados.setEnabled(false);
                
                jLdivF.setText(" ");
                
            }  


               
            
        }
        
        
        
        
            
        
        
    }//GEN-LAST:event_jBProcessarActionPerformed

    
    
    private void jBResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResultadosActionPerformed
       
        if (jan==1 || jan==3 || jan==4 || jan==5) {
            
            jBResultados.setEnabled(false);
            
            JFResPT obj1 = new JFResPT();           
        
            obj1.show();
            
            
            // JANELA PILAR TRELIÇADO
            
        
            // Esforço de compressão       
                
            String Ief$ = String.format("%.2f", Ief);
            String Sv$ = String.format("%.2f", Sv);
            String eo$ = String.format("%.2f", eo);
            String Ncr$ = String.format("%.2f", Ncr);
            String Med2$ = String.format("%.2f", Med2);
            String Nbed$ = String.format("%.2f", Nbed);             
        
            obj1.jTIef.setText(Ief$);
            obj1.jTSv.setText(Sv$);
            obj1.jTeo.setText(eo$);
            obj1.jTNcr.setText(Ncr$);
            obj1.jTMed2.setText(Med2$);
            obj1.jTNbed.setText(Nbed$);       


            // Esforço cortante máximo

            String Ved$ = String.format("%.2f", Ved);

            obj1.jTVed.setText(Ved$);


            // Resistência à flambagem no plano do banzo

            String Lxb$ = String.format("%.2f", Lxbn);
            String Lyb$ = String.format("%.2f", Lybn);
            String Lzb$ = String.format("%.2f", Lzbn);

            String Nexb$ = String.format("%.2f", Nexbn);
            String Neyb$ = String.format("%.2f", Neybn);
            String Nezb$ = String.format("%.2f", Nezbn);
            String Nexzb$ = String.format("%.2f", Nexzbn);
            String Neb$ = String.format("%.2f", Nebn);

            String lamb$ = String.format("%.2f", lambn);
            String chib$ = String.format("%.2f", chibn);
            String sigb$ = String.format("%.2f", sigbn);

            String bbAL$ = String.format("%.2f", 0.10*bbnAL);
            String lampbAL$ = String.format("%.2f", lampbnAL);
            String befbAL$ = String.format("%.2f", 0.10*befbnAL);

            String bbAA$ = String.format("%.2f", 0.10*bbnAA);
            String lampbAA$ = String.format("%.2f", lampbnAA);
            String befbAA$ = String.format("%.2f", 0.10*befbnAA);

            String Aefb$ = String.format("%.2f", Aefbn);        
            String Nbyrd$ = String.format("%.2f", Nbyrd);
            String divb$ = String.format("%.2f", divbn);

            String Nbsdn$ = String.format("%.2f", Nbed);

            obj1.jTLxb.setText(Lxb$);
            obj1.jTLyb.setText(Lyb$);
            obj1.jTLzb.setText(Lzb$);

            obj1.jTNexb.setText(Nexb$);
            obj1.jTNeyb.setText(Neyb$);
            obj1.jTNezb.setText(Nezb$);
            obj1.jTNexzb.setText(Nexzb$);
            obj1.jTNeb.setText(Neb$);        

            obj1.jTlamb.setText(lamb$);
            obj1.jTchib.setText(chib$);
            obj1.jTsigb.setText(sigb$);

            obj1.jTbAL.setText(bbAL$);
            obj1.jTlampbAL.setText(lampbAL$);
            obj1.jTbefbAL.setText(befbAL$);

            obj1.jTbAA.setText(bbAA$);
            obj1.jTlampbAA.setText(lampbAA$);
            obj1.jTbefbAA.setText(befbAA$);

            obj1.jTAefb.setText(Aefb$);        
            obj1.jTNbyrd.setText(Nbyrd$);
            obj1.jTdivb.setText(divb$); 

            obj1.jTNbsdn.setText(Nbsdn$);
            
            
            if (divbn>1)
                {
                    obj1.jLdivbn.setText("NÃO ACEITO !");
                    obj1.jLdivbn1.setText("> 1");
                }
                else
                {
                    obj1.jLdivbn.setText("OK !");

                    if(divbn<1)
                            {
                                obj1.jLdivbn1.setText("< 1");
                            }
                    else
                    obj1.jLdivbn1.setText("= 1");
                }
                        


            // Resistência à flambagem fora do plano do banzo

            String Lxbf$ = String.format("%.2f", Lxbf);
            String Lybf$ = String.format("%.2f", Lybf);
            String Lzbf$ = String.format("%.2f", Lzbf);

            String Nexbf$ = String.format("%.2f", Nexbf);
            String Neybf$ = String.format("%.2f", Neybf);
            String Nezbf$ = String.format("%.2f", Nezbf);
            String Nexzbf$ = String.format("%.2f", Nexzbf);
            String Nebf$ = String.format("%.2f", Nebf);

            String lambf$ = String.format("%.2f", lambf);
            String chibf$ = String.format("%.2f", chibf);
            String sigbf$ = String.format("%.2f", sigbf);

            String bbfAL$ = String.format("%.2f", 0.10*bbfAL);
            String lampbfAL$ = String.format("%.2f", lampbfAL);
            String befbfAL$ = String.format("%.2f", 0.10*befbfAL);

            String bbfAA$ = String.format("%.2f", 0.10*bbfAA);
            String lampbfAA$ = String.format("%.2f", lampbfAA);
            String befbfAA$ = String.format("%.2f", 0.10*befbfAA);

            String Aefbf$ = String.format("%.2f", Aefbf);        
            String Nbxrd$ = String.format("%.2f", Nbxrd);
            String divbf$ = String.format("%.2f", divbf);

            String Nbsdf$ = String.format("%.2f", Nbed);

            obj1.jTLxbf.setText(Lxbf$);
            obj1.jTLybf.setText(Lybf$);
            obj1.jTLzbf.setText(Lzbf$);

            obj1.jTNexbf.setText(Nexbf$);
            obj1.jTNeybf.setText(Neybf$);
            obj1.jTNezbf.setText(Nezbf$);
            obj1.jTNexzbf.setText(Nexzbf$);
            obj1.jTNebf.setText(Nebf$);        

            obj1.jTlambf.setText(lambf$);
            obj1.jTchibf.setText(chibf$);
            obj1.jTsigbf.setText(sigbf$);

            obj1.jTbfAL.setText(bbfAL$);
            obj1.jTlampbfAL.setText(lampbfAL$);
            obj1.jTbefbfAL.setText(befbfAL$);

            obj1.jTbfAA.setText(bbfAA$);
            obj1.jTlampbfAA.setText(lampbfAA$);
            obj1.jTbefbfAA.setText(befbfAA$);

            obj1.jTAefbf.setText(Aefbf$);        
            obj1.jTNbxrd.setText(Nbxrd$);
            obj1.jTdivbf.setText(divbf$);

            obj1.jTNbsdf.setText(Nbsdf$);
            
            
            if (divbf>1)
                {
                    obj1.jLdivbf.setText("NÃO ACEITO !");
                    obj1.jLdivbf1.setText("> 1");
                }
            else
            {
                obj1.jLdivbf.setText("OK !");

                if(divbf<1)
                        {
                            obj1.jLdivbf1.setText("< 1");
                        }
                else
                obj1.jLdivbf1.setText("= 1");
            }
            
            
            // Resistência à flambagem das diagonais

            String Lxd$ = String.format("%.2f", Lxd);
            String Lyd$ = String.format("%.2f", Lyd);
            String Lzd$ = String.format("%.2f", Lzd);

            String Nexd$ = String.format("%.2f", Nexd);
            String Neyd$ = String.format("%.2f", Neyd);
            String Nezd$ = String.format("%.2f", Nezd);
            String Nexzd$ = String.format("%.2f", Nexzd);
            String Nedd$ = String.format("%.2f", Nedd);

            String lamd$ = String.format("%.2f", lamd);
            String chid$ = String.format("%.2f", chid);
            String sigd$ = String.format("%.2f", sigd);

            String bdAL$ = String.format("%.2f", 0.10*bdAL);
            String lampdAL$ = String.format("%.2f", lampdAL);
            String befdAL$ = String.format("%.2f", 0.10*befdAL);

            String bdAA$ = String.format("%.2f", 0.10*bdAA);
            String lampdAA$ = String.format("%.2f", lampdAA);
            String befdAA$ = String.format("%.2f", 0.10*befdAA);

            String Aefd$ = String.format("%.2f", Aefd);        
            String Ndrd$ = String.format("%.2f", Ndrd);
            String divd$ = String.format("%.2f", divd);

            String Ndsd$ = String.format("%.2f", Ndsd);

            obj1.jTLxd.setText(Lxd$);
            obj1.jTLyd.setText(Lyd$);
            obj1.jTLzd.setText(Lzd$);

            obj1.jTNexd.setText(Nexd$);
            obj1.jTNeyd.setText(Neyd$);
            obj1.jTNezd.setText(Nezd$);
            obj1.jTNexzd.setText(Nexzd$);
            obj1.jTNedd.setText(Nedd$);        

            obj1.jTlamd.setText(lamd$);
            obj1.jTchid.setText(chid$);
            obj1.jTsigd.setText(sigd$);

            obj1.jTbdAL.setText(bdAL$);
            obj1.jTlampdAL.setText(lampdAL$);
            obj1.jTbefdAL.setText(befdAL$);

            obj1.jTbdAA.setText(bdAA$);
            obj1.jTlampdAA.setText(lampdAA$);
            obj1.jTbefdAA.setText(befdAA$);

            obj1.jTAefd.setText(Aefd$);        
            obj1.jTNdrd.setText(Ndrd$);
            obj1.jTdivd.setText(divd$); 

            obj1.jTNdsd.setText(Ndsd$); 
            
                       
            if (divd>1)
            {
                obj1.jLdivd.setText("NÃO ACEITO !");
                obj1.jLdivd1.setText("> 1");
            }
            else
            {
                obj1.jLdivd.setText("OK !");

                if(divd<1)
                        {
                            obj1.jLdivd1.setText("< 1");
                        }
                else
                obj1.jLdivd1.setText("= 1");
            }


            // Resistência à flambagem dos montantes                      

            String Lxm$ = String.format("%.2f", Lxm);
            String Lym$ = String.format("%.2f", Lym);
            String Lzm$ = String.format("%.2f", Lzm);

            String Nexm$ = String.format("%.2f", Nexm);
            String Neym$ = String.format("%.2f", Neym);
            String Nezm$ = String.format("%.2f", Nezm);
            String Nexzm$ = String.format("%.2f", Nexzm);
            String Nem$ = String.format("%.2f", Nem);

            String lamm$ = String.format("%.2f", lamm);
            String chim$ = String.format("%.2f", chim);
            String sigm$ = String.format("%.2f", sigm);

            String bmAL$ = String.format("%.2f", 0.10*bmAL);
            String lampmAL$ = String.format("%.2f", lampmAL);
            String befmAL$ = String.format("%.2f", 0.10*befmAL);

            String bmAA$ = String.format("%.2f", 0.10*bmAA);
            String lampmAA$ = String.format("%.2f", lampmAA);
            String befmAA$ = String.format("%.2f", 0.10*befmAA);

            String Aefm$ = String.format("%.2f", Aefm);        
            String Nmrd$ = String.format("%.2f", Nmrd);
            String divm$ = String.format("%.2f", divm);

            String Nmsd$ = String.format("%.2f", Ved);

            obj1.jTLxm.setText(Lxm$);
            obj1.jTLym.setText(Lym$);
            obj1.jTLzm.setText(Lzm$);

            obj1.jTNexm.setText(Nexm$);
            obj1.jTNeym.setText(Neym$);
            obj1.jTNezm.setText(Nezm$);
            obj1.jTNexzm.setText(Nexzm$);
            obj1.jTNem.setText(Nem$);        

            obj1.jTlamm.setText(lamm$);
            obj1.jTchim.setText(chim$);
            obj1.jTsigm.setText(sigm$);

            obj1.jTbmAL.setText(bmAL$);
            obj1.jTlampmAL.setText(lampmAL$);
            obj1.jTbefmAL.setText(befmAL$);

            obj1.jTbmAA.setText(bmAA$);
            obj1.jTlampmAA.setText(lampmAA$);
            obj1.jTbefmAA.setText(befmAA$);

            obj1.jTAefm.setText(Aefm$);        
            obj1.jTNmrd.setText(Nmrd$);
            obj1.jTdivm.setText(divm$);

            obj1.jTNmsd.setText(Nmsd$);
            
            
            if (divm>1)
                {
                    obj1.jLdivm.setText("NÃO ACEITO !");
                    obj1.jLdivm1.setText("> 1");
                }
                else
                {
                    obj1.jLdivm.setText("OK !");

                    if(divm<1)
                            {
                                obj1.jLdivm1.setText("< 1");
                            }
                    else
                    obj1.jLdivm1.setText("= 1");
                }
                        
        
            // Resistência à tração                      

            String At$ = String.format("%.2f", Ad);
            String Ct$ = String.format("%.2f", Ct);
            
            String Ntrd1$ = String.format("%.2f", Ntrd1);
            String Ntrd2$ = String.format("%.2f", Ntrd2);
            String Ntrd$ = String.format("%.2f", Ntrd);
            
            String Ntsd$ = String.format("%.2f", Ntsd);
            
            String divt$ = String.format("%.2f", divt);            
            
            obj1.jTAt.setText(At$);
            obj1.jTCt.setText(Ct$);
                        
            obj1.jTNtrd1.setText(Ntrd1$);
            obj1.jTNtrd2.setText(Ntrd2$);
            obj1.jTNtrd.setText(Ntrd$);
            
            obj1.jTNtsd.setText(Ntsd$);            
            
            obj1.jTdivt.setText(divt$);
                       
            
            if (divt>1)
            {
                obj1.jLdivt.setText("NÃO ACEITO !");
                obj1.jLdivt1.setText("> 1");
            }
            else
            {
                obj1.jLdivt.setText("OK !");

                if(divt<1)
                        {
                            obj1.jLdivt1.setText("< 1");
                        }
                else
                obj1.jLdivt1.setText("= 1");
            }                 
            
            
            // Resistência da ligação diagonal - banzo
            
            String Lf$ = String.format("%.2f", Lf);
            String tef$ = String.format("%.2f", tef);
            
            String Frd$ = String.format("%.2f", Frd);
                        
            String Ntsdl$ = String.format("%.2f", Ntsd);
            
            String divl$ = String.format("%.2f", divl);            
            
            obj1.jTLf.setText(Lf$);
            obj1.jTtef.setText(tef$);
                        
            obj1.jTFrd.setText(Frd$);
            
            obj1.jTNtsdl.setText(Ntsdl$);                      
            
            obj1.jTdivl.setText(divl$); 
            

            if (divl>1)
            {
                obj1.jLdivl.setText("NÃO ACEITO !");
                obj1.jLdivl1.setText("> 1");
            }
            else
            {
                obj1.jLdivl.setText("OK !");

                if(divl<1)
                        {
                            obj1.jLdivl1.setText("< 1");
                        }
                else
                obj1.jLdivl1.setText("= 1");
            }
            
            
            
            // Resultado Final
                                  
            
            obj1.jLdivF.setText(jLdivF.getText());              
                        
            
            
            
        }
        
        
        
        
        // JANELA PILAR COM CHAPAS DE LIGAÇÃO
        
        
        else if (jan==2){
            
            jBResultados.setEnabled(false);
            
            JFResPC obj1 = new JFResPC();           
        
            obj1.show();
            
            
            // Esforço de compressão       
                
            String Ief$ = String.format("%.2f", Iefc);
            String Sv$ = String.format("%.2f", Svc);
            String eo$ = String.format("%.2f", eoc);
            String Ncr$ = String.format("%.2f", Ncrc);
            String Med2$ = String.format("%.2f", Med2c);
            String Nbed$ = String.format("%.2f", Nbedc);             
        
            obj1.jTIef.setText(Ief$);
            obj1.jTSv.setText(Sv$);
            obj1.jTeo.setText(eo$);
            obj1.jTNcr.setText(Ncr$);
            obj1.jTMed2.setText(Med2$);
            obj1.jTNbed.setText(Nbed$);
            
            
            // Rigidez das chapas
            
            String Ic$ = String.format("%.2f", Ic);
            String B$ = String.format("%.2f", B);
            String C$ = String.format("%.2f", C);                        
        
            obj1.jTIc.setText(Ic$);
            obj1.jTB.setText(B$);
            obj1.jTC.setText(C$);           
            

            if (C<B)
            {
                obj1.jLRC.setText("RIGIDEZ DAS CHAPAS A CONSIDERAR !");
                obj1.jLRC1.setText("< ");
            }
            else if (C==B)
            {
                obj1.jLRC.setText("CONDIÇÃO DE RIGIDEZ OK !");
                obj1.jLRC1.setText("= ");
            }
            else if(C>B)
            {
                obj1.jLRC.setText("CONDIÇÃO DE RIGIDEZ OK !");
                obj1.jLRC1.setText("> ");
            }
               
            
            
            // Resistência à flambagem no plano do banzo

            String Lxb$ = String.format("%.2f", Lxbnc);
            String Lyb$ = String.format("%.2f", Lybnc);
            String Lzb$ = String.format("%.2f", Lzbnc);

            String Nexb$ = String.format("%.2f", Nexbnc);
            String Neyb$ = String.format("%.2f", Neybnc);
            String Nezb$ = String.format("%.2f", Nezbnc);
            String Nexzb$ = String.format("%.2f", Nexzbnc);
            String Neb$ = String.format("%.2f", Nebnc);

            String lamb$ = String.format("%.2f", lambnc);
            String chib$ = String.format("%.2f", chibnc);
            String sigb$ = String.format("%.2f", sigbnc);

            String bbAL$ = String.format("%.2f", 0.10*bbncAL);
            String lampbAL$ = String.format("%.2f", lampbncAL);
            String befbAL$ = String.format("%.2f", 0.10*befbncAL);

            String bbAA$ = String.format("%.2f", 0.10*bbncAA);
            String lampbAA$ = String.format("%.2f", lampbncAA);
            String befbAA$ = String.format("%.2f", 0.10*befbncAA);

            String Aefb$ = String.format("%.2f", Aefbnc);        
            String Nbyrd$ = String.format("%.2f", Nbyrdc);
            String divb$ = String.format("%.2f", divbnc);

            String Nbsdn$ = String.format("%.2f", Nbedc);

            obj1.jTLxb.setText(Lxb$);
            obj1.jTLyb.setText(Lyb$);
            obj1.jTLzb.setText(Lzb$);

            obj1.jTNexb.setText(Nexb$);
            obj1.jTNeyb.setText(Neyb$);
            obj1.jTNezb.setText(Nezb$);
            obj1.jTNexzb.setText(Nexzb$);
            obj1.jTNeb.setText(Neb$);        

            obj1.jTlamb.setText(lamb$);
            obj1.jTchib.setText(chib$);
            obj1.jTsigb.setText(sigb$);

            obj1.jTbAL.setText(bbAL$);
            obj1.jTlampbAL.setText(lampbAL$);
            obj1.jTbefbAL.setText(befbAL$);

            obj1.jTbAA.setText(bbAA$);
            obj1.jTlampbAA.setText(lampbAA$);
            obj1.jTbefbAA.setText(befbAA$);

            obj1.jTAefb.setText(Aefb$);        
            obj1.jTNbyrd.setText(Nbyrd$);
            obj1.jTdivb.setText(divb$); 

            obj1.jTNbsdn.setText(Nbsdn$);
            
            
            if (divbnc>1)
                {
                    obj1.jLdivbn.setText("NÃO ACEITO !");
                    obj1.jLdivbn1.setText("> 1");
                }
                else
                {
                    obj1.jLdivbn.setText("OK !");

                    if(divbnc<1)
                            {
                                obj1.jLdivbn1.setText("< 1");
                            }
                    else
                    obj1.jLdivbn1.setText("= 1");
                }
                        


            // Resistência à flambagem fora do plano do banzo

            String Lxbf$ = String.format("%.2f", Lxbfc);
            String Lybf$ = String.format("%.2f", Lybfc);
            String Lzbf$ = String.format("%.2f", Lzbfc);

            String Nexbf$ = String.format("%.2f", Nexbfc);
            String Neybf$ = String.format("%.2f", Neybfc);
            String Nezbf$ = String.format("%.2f", Nezbfc);
            String Nexzbf$ = String.format("%.2f", Nexzbfc);
            String Nebf$ = String.format("%.2f", Nebfc);

            String lambf$ = String.format("%.2f", lambfc);
            String chibf$ = String.format("%.2f", chibfc);
            String sigbf$ = String.format("%.2f", sigbfc);

            String bbfAL$ = String.format("%.2f", 0.10*bbfcAL);
            String lampbfAL$ = String.format("%.2f", lampbfcAL);
            String befbfAL$ = String.format("%.2f", 0.10*befbfcAL);

            String bbfAA$ = String.format("%.2f", 0.10*bbfcAA);
            String lampbfAA$ = String.format("%.2f", lampbfcAA);
            String befbfAA$ = String.format("%.2f", 0.10*befbfcAA);

            String Aefbf$ = String.format("%.2f", Aefbfc);        
            String Nbxrd$ = String.format("%.2f", Nbxrdc);
            String divbf$ = String.format("%.2f", divbfc);

            String Nbsdf$ = String.format("%.2f", Nbedc);

            obj1.jTLxbf.setText(Lxbf$);
            obj1.jTLybf.setText(Lybf$);
            obj1.jTLzbf.setText(Lzbf$);

            obj1.jTNexbf.setText(Nexbf$);
            obj1.jTNeybf.setText(Neybf$);
            obj1.jTNezbf.setText(Nezbf$);
            obj1.jTNexzbf.setText(Nexzbf$);
            obj1.jTNebf.setText(Nebf$);        

            obj1.jTlambf.setText(lambf$);
            obj1.jTchibf.setText(chibf$);
            obj1.jTsigbf.setText(sigbf$);

            obj1.jTbfAL.setText(bbfAL$);
            obj1.jTlampbfAL.setText(lampbfAL$);
            obj1.jTbefbfAL.setText(befbfAL$);

            obj1.jTbfAA.setText(bbfAA$);
            obj1.jTlampbfAA.setText(lampbfAA$);
            obj1.jTbefbfAA.setText(befbfAA$);

            obj1.jTAefbf.setText(Aefbf$);        
            obj1.jTNbxrd.setText(Nbxrd$);
            obj1.jTdivbf.setText(divbf$);

            obj1.jTNbsdf.setText(Nbsdf$);
            
            
            if (divbfc>1)
                {
                    obj1.jLdivbf.setText("NÃO ACEITO !");
                    obj1.jLdivbf1.setText("> 1");
                }
            else
            {
                obj1.jLdivbf.setText("OK !");

                if(divbfc<1)
                        {
                            obj1.jLdivbf1.setText("< 1");
                        }
                else
                obj1.jLdivbf1.setText("= 1");
            }
            
                        
            
            // Solicitações no Painel de Extremidade

            
            String Vsdc$ = String.format("%.2f", Vsdc);
            String N1bsdc$ = String.format("%.2f", Nb1sdc);
            String M1bsdc$ = String.format("%.2f", Mb1sdc);
            String Vcsdc$ = String.format("%.2f", Vcsdc);
            String Mcsdc$ = String.format("%.2f", Mcsdc);

                       
            obj1.jTVsdc.setText(Vsdc$);
            obj1.jTNb1sdc.setText(N1bsdc$);
            obj1.jTMb1sdc.setText(M1bsdc$);
            obj1.jTVcsdc.setText(Vcsdc$);
            obj1.jTMcsdc.setText(Mcsdc$);        

           
             // Resistência das Chapas no Painel de Extremidade
            
                // Resistência ao cisalhamento
                
                String Vcrdc$ = String.format("%.2f", Vcrdc);
                String Vcsdc1$ = String.format("%.2f", Vcsdc);
                String divVc$ = String.format("%.2f", divVc);                        

                obj1.jTVcrdc.setText(Vcrdc$);
                obj1.jTVcsdc1.setText(Vcsdc1$);
                obj1.jTdivVc.setText(divVc$);           


                if (divVc>1)
                {
                    obj1.jLdivVc.setText("NÃO ACEITO !");
                    obj1.jLdivVc1.setText("> 1");
                }
                else
                {
                    obj1.jLdivVc.setText("OK !");

                    if(divVc<1)
                            {
                                obj1.jLdivVc1.setText("< 1");
                            }
                    else
                    obj1.jLdivVc1.setText("= 1");
                }

            
                // Resistência ao cisalhamento
                
                String Mcrdc$ = String.format("%.2f", Mcrdc);
                String Mcsdc1$ = String.format("%.2f", Mcsdc);
                String divMc$ = String.format("%.2f", divMc);                        

                obj1.jTMcrdc.setText(Mcrdc$);
                obj1.jTMcsdc1.setText(Mcsdc1$);
                obj1.jTdivMc.setText(divMc$);           


                if (divMc>1)
                {
                    obj1.jLdivMc.setText("NÃO ACEITO !");
                    obj1.jLdivMc1.setText("> 1");
                }
                else
                {
                    obj1.jLdivMc.setText("OK !");

                    if(divMc<1)
                            {
                                obj1.jLdivMc1.setText("< 1");
                            }
                    else
                    obj1.jLdivMc1.setText("= 1");
                }
            
            
            // Resistência do Banzo no Painel de Extremidade
            
                // Banzo submetido {a flexo-compressão                              
                
                                                              
                String Nb1rd$ = String.format("%.2f", Nb1rd);
                String Mb1rd$ = String.format("%.2f", Mb1rd);
                String divMNb$ = String.format("%.2f", divMNb);                        

                obj1.jTNb1rd.setText(Nb1rd$);
                obj1.jTMb1rd.setText(Mb1rd$);
                obj1.jTNb1sd1.setText(N1bsdc$);
                obj1.jTMb1sd1.setText(M1bsdc$);
                obj1.jTdivMNb.setText(divMNb$);           


                if (divMNb>1)
                {
                    obj1.jLdivMNb.setText("NÃO ACEITO !");
                    obj1.jLdivMNb1.setText("> 1");
                }
                else
                {
                    obj1.jLdivMNb.setText("OK !");

                    if(divMNb<1)
                            {
                                obj1.jLdivMNb1.setText("< 1");
                            }
                    else
                    obj1.jLdivMNb1.setText("= 1");
                }
                
                
                
                
            // Resistência da Ligação soldada Chapa - Banzo
            
            String Lfc$ = String.format("%.2f", Lfc);
            String tefc$ = String.format("%.2f", tef);
            
            String Frdc$ = String.format("%.2f", Frdc);
                        
            String Ntsdc$ = String.format("%.2f", Ntsdc);
            
            String divlc$ = String.format("%.2f", divlc);            
            
            obj1.jTLfc.setText(Lfc$);
            obj1.jTtefc.setText(tefc$);
                        
            obj1.jTFrdc.setText(Frdc$);
            
            obj1.jTNtsdc.setText(Ntsdc$);                      
            
            obj1.jTdivlc.setText(divlc$); 
            

            if (divlc>1)
            {
                obj1.jLdivlc.setText("NÃO ACEITO !");
                obj1.jLdivlc1.setText("> 1");
            }
            else
            {
                obj1.jLdivlc.setText("OK !");

                if(divlc<1)
                        {
                            obj1.jLdivlc1.setText("< 1");
                        }
                else
                obj1.jLdivlc1.setText("= 1");
            }
                
                
                
            // Resultado Final
                                  
            obj1.jLdivF.setText(jLdivF.getText());      
                
            
            
            
        }
        
            
        

            
        
        
        
        
        
        
    }//GEN-LAST:event_jBResultadosActionPerformed

    
    
    
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItemVisualAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualAActionPerformed
        mudaLookAndFeel(3);
        lf=3;
    }//GEN-LAST:event_jMenuItemVisualAActionPerformed

    private void jMenuItemVisualBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualBActionPerformed
        mudaLookAndFeel(4);
        lf=4;
    }//GEN-LAST:event_jMenuItemVisualBActionPerformed

    private void jBclrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrbActionPerformed
        
        jTbfb.setText(" "); jTbwb.setText(" "); jTtb.setText(" "); jTAb.setText(" "); jTIxb.setText(" "); jTIyb.setText(" "); jTWxb.setText(" "); jTWyb.setText(" ");
        jTItb.setText(" "); jTIwb.setText(" "); jTrob.setText(" "); jTxob.setText(" "); jTxgb.setText(" "); jTmb.setText(" "); jTrib.setText(" ");
        
    }//GEN-LAST:event_jBclrbActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        jan = 1; //Iniciando a tela com pilar N-shape
        
        lf = 3; //Iniciando a tela com look and feel 3
        
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
        jLdivF.setVisible(false);
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        jBResultados.setEnabled(false);
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);   
          
        
    }//GEN-LAST:event_formWindowOpened

    
    private void jBclrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrdActionPerformed
        
        jTbfd.setText(" "); jTbwd.setText(" "); jTtd.setText(" "); jTAd.setText(" "); jTIxd.setText(" "); jTIyd.setText(" "); jTWxd.setText(" "); jTWyd.setText(" ");
        jTItd.setText(" "); jTIwd.setText(" "); jTrod.setText(" "); jTxod.setText(" "); jTxgd.setText(" "); jTmd.setText(" "); jTrid.setText(" ");
        
    }//GEN-LAST:event_jBclrdActionPerformed

    private void jBclrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrmActionPerformed
        
        jTbfm.setText(" "); jTbwm.setText(" "); jTtm.setText(" "); jTAm.setText(" "); jTIxm.setText(" "); jTIym.setText(" "); jTWxm.setText(" "); jTWym.setText(" ");
        jTItm.setText(" "); jTIwm.setText(" "); jTrom.setText(" "); jTxom.setText(" "); jTxgm.setText(" "); jTmm.setText(" "); jTrim.setText(" ");
        
    }//GEN-LAST:event_jBclrmActionPerformed

    
    
    // Janela Pilar N-shape
    
    private void jBpNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpNActionPerformed
        
        jan = 1;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Pilar treliçado N-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Detalhe N-shape.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);        
        
                
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");                      
        
                
    }//GEN-LAST:event_jBpNActionPerformed

    
    // Janela Pilar com chapas
    
    private void jBpCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpCActionPerformed
        
        jan = 2;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Pilar com chapas.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Detalhe chapas.jpg")));
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfd.setText(""); jTbwd.setText(""); jTtd.setText(""); jTrid.setText(""); jTAd.setText("");
        jTIxd.setText(""); jTIyd.setText(""); jTxgd.setText(""); jTItd.setText(""); jTIwd.setText("");
        jTrod.setText(""); jTxod.setText(""); jTmd.setText(""); jTWxd.setText(""); jTWyd.setText("");
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jTbfm.setText(""); jTbwm.setText(""); jTtm.setText(""); jTrim.setText(""); jTAm.setText("");
        jTIxm.setText(""); jTIym.setText(""); jTxgm.setText(""); jTItm.setText(""); jTIwm.setText("");
        jTrom.setText(""); jTxom.setText(""); jTmm.setText(""); jTWxm.setText(""); jTWym.setText("");
        
        jThc.setEnabled(true);
        jTec.setEnabled(true);
        jBclrch.setEnabled(true);        
        
        jRBLd.setEnabled(false); jRBLm.setEnabled(false);
        jRBUd.setEnabled(false); jRBUm.setEnabled(false);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        jBprfd.setEnabled(false); jBprfm.setEnabled(false);
        jBclrd.setEnabled(false); jBclrm.setEnabled(false);
        
        jTn.setText("2");
        
        jTd.setText(" "); jTd.setEnabled(false);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");
                
                        
        
    }//GEN-LAST:event_jBpCActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        jan = 4;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/K-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/K-shape_det.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");
        
                
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        jan = 3;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/V-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/V-shape_det.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");
        
                
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jan = 5;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/X-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/X-shape_det.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        
        this.jdligs.mudaLookAndFeel(lf);                
        
        this.jdligs.setVisible(true);        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jBprfbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprfbActionPerformed
                
        this.jdpu.mudaLookAndFeel(lf);                
        
        this.jdpu.setVisible(true);       
                       
        //this.jdpu.setLocationRelativeTo(null);              
        
        this.jTbfb.setText(this.jdpu.getBf());
        
        this.jTbwb.setText(this.jdpu.getBw());
        
        this.jTtb.setText(this.jdpu.getT());
        
        this.jTrib.setText(this.jdpu.getRi());
        
        this.jTAb.setText(this.jdpu.getA());
        
        this.jTIxb.setText(this.jdpu.getIx());
        
        this.jTIyb.setText(this.jdpu.getIy());
        
        this.jTxgb.setText(this.jdpu.getXg());
        
        this.jTItb.setText(this.jdpu.getIt());
        
        this.jTIwb.setText(this.jdpu.getIw());
        
        this.jTxob.setText(this.jdpu.getXo());
        
        this.jTrob.setText(this.jdpu.getRo());
        
        this.jTmb.setText(this.jdpu.getM());
        
        this.jTWxb.setText(this.jdpu.getWx());
        
        this.jTWyb.setText(this.jdpu.getWy());        
                
        
    }//GEN-LAST:event_jBprfbActionPerformed

    private void jBprfdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprfdActionPerformed

        //Abre JDialog Perfil L
        
        if(jRBLd.isSelected()||jRBLm.isSelected()){
            
            this.jdpl.mudaLookAndFeel(lf);
        
            this.jdpl.setVisible(true);       
                       
            //this.jdpl.setLocationRelativeTo(null);              
        
            this.jTbfd.setText(this.jdpl.getBf());
        
            this.jTbwd.setText(this.jdpl.getBw());
        
            this.jTtd.setText(this.jdpl.getT());
        
            this.jTrid.setText(this.jdpl.getRi());
        
            this.jTAd.setText(this.jdpl.getA());
        
            this.jTIxd.setText(this.jdpl.getIx());
        
            this.jTIyd.setText(this.jdpl.getIy());
        
            this.jTxgd.setText(this.jdpl.getXg());
        
            this.jTItd.setText(this.jdpl.getIt());
        
            this.jTIwd.setText(this.jdpl.getIw());
        
            this.jTxod.setText(this.jdpl.getXo());
        
            this.jTrod.setText(this.jdpl.getRo());
        
            this.jTmd.setText(this.jdpl.getM());
        
            this.jTWxd.setText(this.jdpl.getWx());
        
            this.jTWyd.setText(this.jdpl.getWy());
            
        }
        
        
        //Abre JDialog Perfil U
        
        else if(jRBUd.isSelected()||jRBUm.isSelected()){
            
            this.jdpu.mudaLookAndFeel(lf);
        
            this.jdpu.setVisible(true);       
                       
            //this.jdpl.setLocationRelativeTo(null);              
        
            this.jTbfd.setText(this.jdpu.getBf());
        
            this.jTbwd.setText(this.jdpu.getBw());
        
            this.jTtd.setText(this.jdpu.getT());
        
            this.jTrid.setText(this.jdpu.getRi());
        
            this.jTAd.setText(this.jdpu.getA());
        
            this.jTIxd.setText(this.jdpu.getIx());
        
            this.jTIyd.setText(this.jdpu.getIy());
        
            this.jTxgd.setText(this.jdpu.getXg());
        
            this.jTItd.setText(this.jdpu.getIt());
        
            this.jTIwd.setText(this.jdpu.getIw());
        
            this.jTxod.setText(this.jdpu.getXo());
        
            this.jTrod.setText(this.jdpu.getRo());
        
            this.jTmd.setText(this.jdpu.getM());
        
            this.jTWxd.setText(this.jdpu.getWx());
        
            this.jTWyd.setText(this.jdpu.getWy());
            
        }
        
        
    }//GEN-LAST:event_jBprfdActionPerformed

    private void jBprfmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprfmActionPerformed
        
        //Abre JDialog Perfil L
        
        if(jRBLd.isSelected()||jRBLm.isSelected()){
            
            this.jdpl.mudaLookAndFeel(lf);
        
            this.jdpl.setVisible(true);       
                       
            //this.jdpl.setLocationRelativeTo(null);              
        
            this.jTbfm.setText(this.jdpl.getBf());
        
            this.jTbwm.setText(this.jdpl.getBw());
        
            this.jTtm.setText(this.jdpl.getT());
        
            this.jTrim.setText(this.jdpl.getRi());
        
            this.jTAm.setText(this.jdpl.getA());
        
            this.jTIxm.setText(this.jdpl.getIx());
        
            this.jTIym.setText(this.jdpl.getIy());
        
            this.jTxgm.setText(this.jdpl.getXg());
        
            this.jTItm.setText(this.jdpl.getIt());
        
            this.jTIwm.setText(this.jdpl.getIw());
        
            this.jTxom.setText(this.jdpl.getXo());
        
            this.jTrom.setText(this.jdpl.getRo());
        
            this.jTmm.setText(this.jdpl.getM());
        
            this.jTWxm.setText(this.jdpl.getWx());
        
            this.jTWym.setText(this.jdpl.getWy());
            
        }
        
        
        //Abre JDialog Perfil U
        
        else if(jRBUd.isSelected()||jRBUm.isSelected()){
            
            this.jdpu.mudaLookAndFeel(lf);
        
            this.jdpu.setVisible(true);       
                       
            //this.jdpl.setLocationRelativeTo(null);              
        
            this.jTbfm.setText(this.jdpu.getBf());
        
            this.jTbwm.setText(this.jdpu.getBw());
        
            this.jTtm.setText(this.jdpu.getT());
        
            this.jTrim.setText(this.jdpu.getRi());
        
            this.jTAm.setText(this.jdpu.getA());
        
            this.jTIxm.setText(this.jdpu.getIx());
        
            this.jTIym.setText(this.jdpu.getIy());
        
            this.jTxgm.setText(this.jdpu.getXg());
        
            this.jTItm.setText(this.jdpu.getIt());
        
            this.jTIwm.setText(this.jdpu.getIw());
        
            this.jTxom.setText(this.jdpu.getXo());
        
            this.jTrom.setText(this.jdpu.getRo());
        
            this.jTmm.setText(this.jdpu.getM());
        
            this.jTWxm.setText(this.jdpu.getWx());
        
            this.jTWym.setText(this.jdpu.getWy());
            
        }
        
    }//GEN-LAST:event_jBprfmActionPerformed

    private void jBclrdcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrdcaActionPerformed
       
        jTNed.setText(" ");
        jTMed1.setText(" ");
        
    }//GEN-LAST:event_jBclrdcaActionPerformed

    private void jBclrpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrpaActionPerformed
        
        jTE.setText(" ");
        jTG.setText(" ");
        jTfy.setText(" ");
        jTfu.setText(" ");
        
    }//GEN-LAST:event_jBclrpaActionPerformed

    private void jBclrpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrpiActionPerformed
        
        jTL.setText(" ");
        jTho.setText(" ");
        jTa.setText(" ");
        jTd.setText(" ");
        jTn.setText(" ");
        
    }//GEN-LAST:event_jBclrpiActionPerformed

    private void jBclrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclrchActionPerformed
        
        jThc.setText(" ");
        jTec.setText(" ");
        
    }//GEN-LAST:event_jBclrchActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        jTfw.setText(" ");
        jTtef.setText(" ");
        jTl1.setText(" ");
        jTl2.setText(" ");
        jTl3.setText(" ");
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        
        jTNed.setText(" ");
        jTMed1.setText(" ");
        
        jTE.setText(" ");
        jTG.setText(" ");
        jTfy.setText(" ");
        jTfu.setText(" ");
        
        jTL.setText(" ");
        jTho.setText(" ");
        jTa.setText(" ");
        jTd.setText(" ");
        jTn.setText(" ");
        
        jThc.setText(" ");
        jTec.setText(" ");
        
        jTfw.setText(" ");
        jTtef.setText(" ");
        jTl1.setText(" ");
        jTl2.setText(" ");
        jTl3.setText(" ");
        
        jTbfb.setText(" "); jTbwb.setText(" "); jTtb.setText(" "); jTAb.setText(" "); jTIxb.setText(" "); jTIyb.setText(" "); jTWxb.setText(" "); jTWyb.setText(" ");
        jTItb.setText(" "); jTIwb.setText(" "); jTrob.setText(" "); jTxob.setText(" "); jTxgb.setText(" "); jTmb.setText(" "); jTrib.setText(" ");
        
        jTbfd.setText(" "); jTbwd.setText(" "); jTtd.setText(" "); jTAd.setText(" "); jTIxd.setText(" "); jTIyd.setText(" "); jTWxd.setText(" "); jTWyd.setText(" ");
        jTItd.setText(" "); jTIwd.setText(" "); jTrod.setText(" "); jTxod.setText(" "); jTxgd.setText(" "); jTmd.setText(" "); jTrid.setText(" ");
        
        jTbfm.setText(" "); jTbwm.setText(" "); jTtm.setText(" "); jTAm.setText(" "); jTIxm.setText(" "); jTIym.setText(" "); jTWxm.setText(" "); jTWym.setText(" ");
        jTItm.setText(" "); jTIwm.setText(" "); jTrom.setText(" "); jTxom.setText(" "); jTxgm.setText(" "); jTmm.setText(" "); jTrim.setText(" ");
        
        
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jMPerfisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPerfisActionPerformed
        
                
    }//GEN-LAST:event_jMPerfisActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
         
        this.jds1.mudaLookAndFeel(lf);                
        
        this.jds1.setVisible(true); 
                
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void jMPerfisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMPerfisMouseClicked
       
               
    }//GEN-LAST:event_jMPerfisMouseClicked

    private void jRBLdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBLdActionPerformed
                
        jRBLm.setSelected(true);
        
        jTn.setText("2");
        
        
        jTbfd.setEnabled(true); jTbwd.setEnabled(true); jTtd.setEnabled(true); jTrid.setEnabled(true); jTAd.setEnabled(true);
        jTIxd.setEnabled(true); jTIyd.setEnabled(true); jTxgd.setEnabled(true); jTItd.setEnabled(true); jTIwd.setEnabled(true);
        jTrod.setEnabled(true); jTxod.setEnabled(true); jTmd.setEnabled(true); jTWxd.setEnabled(true); jTWyd.setEnabled(true);
        
        jTbfm.setEnabled(true); jTbwm.setEnabled(true); jTtm.setEnabled(true); jTrim.setEnabled(true); jTAm.setEnabled(true);
        jTIxm.setEnabled(true); jTIym.setEnabled(true); jTxgm.setEnabled(true); jTItm.setEnabled(true); jTIwm.setEnabled(true);
        jTrom.setEnabled(true); jTxom.setEnabled(true); jTmm.setEnabled(true); jTWxm.setEnabled(true); jTWym.setEnabled(true);
        
        jBprfd.setEnabled(true); jBclrd.setEnabled(true);
        jBprfm.setEnabled(true); jBclrm.setEnabled(true);
        
        
        
    }//GEN-LAST:event_jRBLdActionPerformed

    private void jRBLmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBLmActionPerformed
       
        jRBLd.setSelected(true);
        
        jTn.setText("2");
        
        
        jTbfd.setEnabled(true); jTbwd.setEnabled(true); jTtd.setEnabled(true); jTrid.setEnabled(true); jTAd.setEnabled(true);
        jTIxd.setEnabled(true); jTIyd.setEnabled(true); jTxgd.setEnabled(true); jTItd.setEnabled(true); jTIwd.setEnabled(true);
        jTrod.setEnabled(true); jTxod.setEnabled(true); jTmd.setEnabled(true); jTWxd.setEnabled(true); jTWyd.setEnabled(true);
        
        jTbfm.setEnabled(true); jTbwm.setEnabled(true); jTtm.setEnabled(true); jTrim.setEnabled(true); jTAm.setEnabled(true);
        jTIxm.setEnabled(true); jTIym.setEnabled(true); jTxgm.setEnabled(true); jTItm.setEnabled(true); jTIwm.setEnabled(true);
        jTrom.setEnabled(true); jTxom.setEnabled(true); jTmm.setEnabled(true); jTWxm.setEnabled(true); jTWym.setEnabled(true);
        
        jBprfd.setEnabled(true); jBclrd.setEnabled(true);
        jBprfm.setEnabled(true); jBclrm.setEnabled(true);
        
    }//GEN-LAST:event_jRBLmActionPerformed

    private void jRBUdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBUdActionPerformed
        
        jRBUm.setSelected(true);
        
        jTn.setText("1");
        
        
        jTbfd.setEnabled(true); jTbwd.setEnabled(true); jTtd.setEnabled(true); jTrid.setEnabled(true); jTAd.setEnabled(true);
        jTIxd.setEnabled(true); jTIyd.setEnabled(true); jTxgd.setEnabled(true); jTItd.setEnabled(true); jTIwd.setEnabled(true);
        jTrod.setEnabled(true); jTxod.setEnabled(true); jTmd.setEnabled(true); jTWxd.setEnabled(true); jTWyd.setEnabled(true);
        
        jTbfm.setEnabled(true); jTbwm.setEnabled(true); jTtm.setEnabled(true); jTrim.setEnabled(true); jTAm.setEnabled(true);
        jTIxm.setEnabled(true); jTIym.setEnabled(true); jTxgm.setEnabled(true); jTItm.setEnabled(true); jTIwm.setEnabled(true);
        jTrom.setEnabled(true); jTxom.setEnabled(true); jTmm.setEnabled(true); jTWxm.setEnabled(true); jTWym.setEnabled(true);
        
        jBprfd.setEnabled(true); jBclrd.setEnabled(true);
        jBprfm.setEnabled(true); jBclrm.setEnabled(true);
        
    }//GEN-LAST:event_jRBUdActionPerformed

    private void jRBUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBUmActionPerformed
        
        jRBUd.setSelected(true);
        
        jTn.setText("1");
        
        
        jTbfd.setEnabled(true); jTbwd.setEnabled(true); jTtd.setEnabled(true); jTrid.setEnabled(true); jTAd.setEnabled(true);
        jTIxd.setEnabled(true); jTIyd.setEnabled(true); jTxgd.setEnabled(true); jTItd.setEnabled(true); jTIwd.setEnabled(true);
        jTrod.setEnabled(true); jTxod.setEnabled(true); jTmd.setEnabled(true); jTWxd.setEnabled(true); jTWyd.setEnabled(true);
        
        jTbfm.setEnabled(true); jTbwm.setEnabled(true); jTtm.setEnabled(true); jTrim.setEnabled(true); jTAm.setEnabled(true);
        jTIxm.setEnabled(true); jTIym.setEnabled(true); jTxgm.setEnabled(true); jTItm.setEnabled(true); jTIwm.setEnabled(true);
        jTrom.setEnabled(true); jTxom.setEnabled(true); jTmm.setEnabled(true); jTWxm.setEnabled(true); jTWym.setEnabled(true);
        
        jBprfd.setEnabled(true); jBclrd.setEnabled(true);
        jBprfm.setEnabled(true); jBclrm.setEnabled(true);
        
    }//GEN-LAST:event_jRBUmActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        jan = 1;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Pilar treliçado N-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Detalhe N-shape.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);        
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" "); 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       
        jan = 3;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/V-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/V-shape_det.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        jan = 4;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/K-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/K-shape_det.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        jan = 5;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/X-shape.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/X-shape_det.jpg")));
        
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jBprfd.setEnabled(false); jBclrd.setEnabled(false);
        jBprfm.setEnabled(false); jBclrm.setEnabled(false);
        
        jRBLd.setEnabled(true); jRBLm.setEnabled(true);
        jRBUd.setEnabled(true); jRBUm.setEnabled(true);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        
        jThc.setEnabled(false);
        jTec.setEnabled(false);
        jBclrch.setEnabled(false);
        
        
        jTn.setText(" ");
        
        jThc.setText(" "); 
        jTec.setText(" ");
        
        jTd.setEnabled(true);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" "); 
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       
        jan = 2;
        
        jLPilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Pilar com chapas.jpg")));
        
        jLDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_pmc/Detalhe chapas.jpg")));
        
        jTbfd.setEnabled(false); jTbwd.setEnabled(false); jTtd.setEnabled(false); jTrid.setEnabled(false); jTAd.setEnabled(false);
        jTIxd.setEnabled(false); jTIyd.setEnabled(false); jTxgd.setEnabled(false); jTItd.setEnabled(false); jTIwd.setEnabled(false);
        jTrod.setEnabled(false); jTxod.setEnabled(false); jTmd.setEnabled(false); jTWxd.setEnabled(false); jTWyd.setEnabled(false);
        
        jTbfd.setText(""); jTbwd.setText(""); jTtd.setText(""); jTrid.setText(""); jTAd.setText("");
        jTIxd.setText(""); jTIyd.setText(""); jTxgd.setText(""); jTItd.setText(""); jTIwd.setText("");
        jTrod.setText(""); jTxod.setText(""); jTmd.setText(""); jTWxd.setText(""); jTWyd.setText("");
        
        jTbfm.setEnabled(false); jTbwm.setEnabled(false); jTtm.setEnabled(false); jTrim.setEnabled(false); jTAm.setEnabled(false);
        jTIxm.setEnabled(false); jTIym.setEnabled(false); jTxgm.setEnabled(false); jTItm.setEnabled(false); jTIwm.setEnabled(false);
        jTrom.setEnabled(false); jTxom.setEnabled(false); jTmm.setEnabled(false); jTWxm.setEnabled(false); jTWym.setEnabled(false);
        
        jTbfm.setText(""); jTbwm.setText(""); jTtm.setText(""); jTrim.setText(""); jTAm.setText("");
        jTIxm.setText(""); jTIym.setText(""); jTxgm.setText(""); jTItm.setText(""); jTIwm.setText("");
        jTrom.setText(""); jTxom.setText(""); jTmm.setText(""); jTWxm.setText(""); jTWym.setText("");
        
        jThc.setEnabled(true);
        jTec.setEnabled(true);
        jBclrch.setEnabled(true);
                
        jRBLd.setEnabled(false); jRBLm.setEnabled(false);
        jRBUd.setEnabled(false); jRBUm.setEnabled(false);
        
        jRBLd.setSelected(false); jRBLm.setSelected(false);
        jRBUd.setSelected(false); jRBUm.setSelected(false);
        
        jBprfd.setEnabled(false); jBprfm.setEnabled(false);
        jBclrd.setEnabled(false); jBclrm.setEnabled(false);
        
        jTn.setText("2");
        
        jTd.setText(" "); jTd.setEnabled(false);
        
        jBResultados.setEnabled(false);
        
        jLdivF.setText(" ");
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        this.jdp.mudaLookAndFeel(lf);                
        
        this.jdp.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
            java.util.logging.Logger.getLogger(JFPiMeCo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPiMeCo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPiMeCo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPiMeCo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                JFPiMeCo jFrame1 = new JFPiMeCo(); //eu
                
                jFrame1.mudaLookAndFeel(3); //eu
                
                //jFrame1.mudaLookAndFeel(4);
                
                jFrame1.setVisible(true); //eu                              
                              
                //new JFPiMeCo().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBProcessar;
    private javax.swing.JButton jBResultados;
    private javax.swing.JButton jBclrb;
    private javax.swing.JButton jBclrch;
    private javax.swing.JButton jBclrd;
    private javax.swing.JButton jBclrdca;
    private javax.swing.JButton jBclrm;
    private javax.swing.JButton jBclrpa;
    private javax.swing.JButton jBclrpi;
    private javax.swing.JButton jBpC;
    private javax.swing.JButton jBpN;
    private javax.swing.JButton jBprfb;
    private javax.swing.JButton jBprfd;
    private javax.swing.JButton jBprfm;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLDetalhe;
    private javax.swing.JLabel jLPilar;
    private javax.swing.JLabel jLWyb;
    private javax.swing.JLabel jLWyb1;
    private javax.swing.JLabel jLWyb10;
    private javax.swing.JLabel jLWyb11;
    private javax.swing.JLabel jLWyb2;
    private javax.swing.JLabel jLWyb3;
    private javax.swing.JLabel jLWyb4;
    private javax.swing.JLabel jLWyb5;
    private javax.swing.JLabel jLWyb6;
    private javax.swing.JLabel jLWyb7;
    private javax.swing.JLabel jLWyb8;
    private javax.swing.JLabel jLWyb9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLdivF;
    private javax.swing.JLabel jLdivF1;
    private javax.swing.JMenu jMPerfis;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenuItem jMenuItemVisualA;
    private javax.swing.JMenuItem jMenuItemVisualB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPdetalhe;
    private javax.swing.JPanel jPpilar;
    private javax.swing.JRadioButton jRBLd;
    private javax.swing.JRadioButton jRBLm;
    private javax.swing.JRadioButton jRBUd;
    private javax.swing.JRadioButton jRBUm;
    private javax.swing.JTextField jTAb;
    private javax.swing.JTextField jTAd;
    private javax.swing.JTextField jTAm;
    private javax.swing.JTextField jTE;
    private javax.swing.JTextField jTG;
    private javax.swing.JTextField jTItb;
    private javax.swing.JTextField jTItd;
    private javax.swing.JTextField jTItm;
    private javax.swing.JTextField jTIwb;
    private javax.swing.JTextField jTIwd;
    private javax.swing.JTextField jTIwm;
    private javax.swing.JTextField jTIxb;
    private javax.swing.JTextField jTIxd;
    private javax.swing.JTextField jTIxm;
    private javax.swing.JTextField jTIyb;
    private javax.swing.JTextField jTIyd;
    private javax.swing.JTextField jTIym;
    public javax.swing.JTextField jTL;
    private javax.swing.JTextField jTMed1;
    private javax.swing.JTextField jTNed;
    private javax.swing.JTextField jTWxb;
    private javax.swing.JTextField jTWxd;
    private javax.swing.JTextField jTWxm;
    private javax.swing.JTextField jTWyb;
    private javax.swing.JTextField jTWyd;
    private javax.swing.JTextField jTWym;
    private javax.swing.JTextField jTa;
    private javax.swing.JTextField jTbfb;
    private javax.swing.JTextField jTbfd;
    private javax.swing.JTextField jTbfm;
    private javax.swing.JTextField jTbwb;
    private javax.swing.JTextField jTbwd;
    private javax.swing.JTextField jTbwm;
    private javax.swing.JTextField jTd;
    private javax.swing.JTextField jTec;
    private javax.swing.JTextField jTfu;
    private javax.swing.JTextField jTfw;
    private javax.swing.JTextField jTfy;
    private javax.swing.JTextField jThc;
    private javax.swing.JTextField jTho;
    private javax.swing.JTextField jTl1;
    private javax.swing.JTextField jTl2;
    private javax.swing.JTextField jTl3;
    private javax.swing.JTextField jTmb;
    private javax.swing.JTextField jTmd;
    private javax.swing.JTextField jTmm;
    private javax.swing.JTextField jTn;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTrib;
    private javax.swing.JTextField jTrid;
    private javax.swing.JTextField jTrim;
    private javax.swing.JTextField jTrob;
    private javax.swing.JTextField jTrod;
    private javax.swing.JTextField jTrom;
    private javax.swing.JTextField jTtb;
    private javax.swing.JTextField jTtd;
    private javax.swing.JTextField jTtef;
    private javax.swing.JTextField jTtm;
    private javax.swing.JTextField jTxgb;
    private javax.swing.JTextField jTxgd;
    private javax.swing.JTextField jTxgm;
    private javax.swing.JTextField jTxob;
    private javax.swing.JTextField jTxod;
    private javax.swing.JTextField jTxom;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the lf
     */
    public int getLf() {
        return lf;
    }
}
