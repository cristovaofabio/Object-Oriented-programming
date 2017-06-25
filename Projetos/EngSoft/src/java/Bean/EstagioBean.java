package Bean;

import Outros.Estagio;
import Outros.EstagioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author aluno_imd
 */
@ManagedBean
public class EstagioBean {
    
    private Estagio estagio;
    public static int temEstagio;
    public static String mensagemEnviar;
    private List<Estagio> estagios;
    EstagioDAO DAO;

    public String getMensagemEnviar() {
        return mensagemEnviar;
    }

    public void setMensagemEnviar(String mensagemEnviar) {
        EstagioBean.mensagemEnviar = mensagemEnviar;
    }

    public int getTemEstagio() {
        return temEstagio;
    }

    public void setTemEstagio(int temEstagio) {
        this.temEstagio = temEstagio;
    }
    
    public EstagioBean(){
        this.DAO = new EstagioDAO();
        this.estagio=new Estagio();
    }
    public Estagio getEstagio() {
        return estagio;
    }
    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }
    
    public void adicionar(){
        this.DAO.adiciona(this.estagio);
        this.estagio=new Estagio();
    }
    public List<Estagio> getEstagios(String email) throws SQLException{
        this.estagios=DAO.getlista(email);
        return estagios;
    }
    public void excluir(Estagio umEstagio){
        this.estagios.remove(umEstagio);
        this.DAO.remove(umEstagio);
    }
    public String receber(int id){
        this.temEstagio = id;
        System.out.println("Id do estágio: "+temEstagio);
        return "EnviarEmail?faces-redirect=true";
    }
    public void notificar(int id) throws SQLException{
        String email;
       
        email=this.DAO.listaEmail(id);
           Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("meuEmail", "MinhaSenha");
                             }
                        });
            /** Ativa Debug para sessão */
            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("meuEmail")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(email);  
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Informações de estágio");//Assunto
                  message.setText(mensagemEnviar);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  System.out.println("Feito!!!");
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }
}
