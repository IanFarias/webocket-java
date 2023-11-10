import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {
    public static void main(String args[]) {
        Socket websocket = null;
        try {
            if(args.length > 0){
                websocket = new Socket(args[0], Integer.parseInt(args[1]));
            }else{
                websocket = new Socket("localhost", 6789);
            }

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream entrada = new DataInputStream(websocket.getInputStream());
            DataOutputStream saida = new DataOutputStream(websocket.getOutputStream());

            String userInput;

            do {
                System.out.println("Escolha: " +
                        "\n1 - Jogar" +
                        "\n2 - Sair");

                userInput = console.readLine();

                switch (userInput){
                    case "1":
                        saida.writeUTF("jogar");
                        String response = "";

                        while(true) {
                            response = entrada.readUTF();

                            if(response.equals("END")) {
                                break;
                            }

                            System.out.println(response);

                            System.out.println("Digite: ");
                            userInput = console.readLine();
                            saida.writeUTF(userInput);
                        }

                        response = entrada.readUTF();
                        System.out.println(response);
                        break;
                    case "2":
                        saida.writeUTF("sair");
                        break;
                    default:
                        saida.writeUTF(userInput);
                        break;
                }

            } while (!userInput.equals("2"));
        } catch (UnknownHostException e) {
            System.out.println("!!! Servidor desconhecido: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("!!! Nao ha mais dados de entrada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("!!! E/S: " + e.getMessage());
        } finally {
            if (websocket!=null)
                try {
                    websocket.close();
                } catch (IOException e){
                    System.out.println("!!! Encerramento do socket falhou: " + e.getMessage());
                }
        }
    }
}