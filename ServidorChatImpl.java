import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class ServidorChatImpl extends java.rmi.server.UnicastRemoteObject implements ServidorChat {
    //StringBuffer mensagens;
    ArrayList<String> mensagens;
    int nMensagens;

	ArrayList<String> logs;
    int nLogs;

	int chatCount;


    public ServidorChatImpl() throws RemoteException {
        super();
        this.mensagens = new ArrayList<String>();
        this.logs = new ArrayList<String>();
		this.chatCount = 0;
//this.mensagens = new StringBuffer();
    }
    public void enviarMensagem(String mensagem) throws RemoteException{
//mensagens.append(mensagem+”\n”);
        mensagens.add(mensagem);
    }
    /*
    public String lerMensagem() throws RemoteException{
    return new String(mensagens);
    }
    * */
    public ArrayList<String> lerMensagem() throws RemoteException{
        return mensagens;
    }

	/*
	LOG
	*/

	public void enviarLog(String mensagem) throws RemoteException{
	//mensagens.append(mensagem+”\n”);
        logs.add(mensagem);
    }
    /*
    public String lerMensagem() throws RemoteException{
    return new String(mensagens);
    }
    * */
    public ArrayList<String> lerLog() throws RemoteException{
        return logs;
    }

	public boolean setChatCount(int opt){
		if(opt == 0){
			chatCount++;
		}else if(opt == 1){
			chatCount--;
		}else{
			return false;
		}

		return true;
	}

	public int getCount(){
		return chatCount;
	}
}
