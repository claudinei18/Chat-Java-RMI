import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface ServidorChat extends Remote {
    public void enviarMensagem(String mensagem) throws RemoteException;
    public ArrayList<String> lerMensagem() throws RemoteException;

	public void enviarLog(String mensagem) throws RemoteException;
    public ArrayList<String> lerLog() throws RemoteException;
}
