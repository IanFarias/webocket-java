import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args[]) {
        try {
            int port = 6789; // porta do servico

            if (args.length > 0) port = Integer.parseInt(args[0]);

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("*** Servidor ***");
            System.out.println("*** Porta de escuta (listen): " + port);

            while (true) {
                // accept bloqueia ateh que chegue um pedido de conexao de um cliente
                Socket client = serverSocket.accept();

                System.out.println("*** conexao aceita de (remoto): " + client.getRemoteSocketAddress());
                // quando chega, cria nova thread para atender em especial o cliente
                Connection c = new Connection(client);
            }
        } catch (IOException e) {
            System.out.println("Erro na escuta: " + e.getMessage());
        }
    }


}

