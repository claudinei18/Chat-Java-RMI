import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
public class Servidor {
    public Servidor(){
        try {
            Registry registry = LocateRegistry.createRegistry(1098);
            ServidorChat server = new ServidorChatImpl();
            Naming.rebind("rmi://localhost:1098/ServidorChat",server);
			
			

			Thread thread = new Thread(new Runnable() {
                int cont = 0;
                @Override
                public void run() {
                    try {
                        while(true){
                            if (server.lerLog().size() > cont){
                                System.out.println(server.lerLog().get(server.lerLog().size()-1));
								System.out.println("Numero de usuarios: " + server.getCount());
                                cont++;
                            }
							Thread.sleep(500);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e){
						e.printStackTrace();
					}
                }
            });
            thread.start();

        } catch (Exception e){
            System.out.println("Trouble: "+e);
        }
    }
    public static void main (String args[]){
        new Servidor();
    }
}
