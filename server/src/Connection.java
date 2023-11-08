import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

class Connection extends Thread {
    DataInputStream input;
    DataOutputStream output;
    Socket client;

    public Connection(Socket s) {
        try {
            client = s;
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Erro IO Conexao: " + e.getMessage());
        }
    }

    public void run() {
        try {
            String response = "";
            Game game = null;
            do {

                response = input.readUTF().toUpperCase().trim();

                if(response.equals("JOGAR")) {

                    game = new Game();
                    game.selectRandomWord();

                    output.writeUTF(game.getHiddenWord());
                }else if(game != null) {
                    if(game.verifyEndGame(response)) {
                        if(game.isVictory()) {
                            output.writeUTF("Você Ganhou!! A palavra era: " + game.getWord());
                        }
                        output.writeUTF("Você Perdeu!! A palavra era: " + game.getWord());
                        output.writeUTF("END");
                        break;
                    }

                    output.writeUTF("Letras testadas: " + game.getWrongGuesses()
                            + "\nChances: " + game.getChances()
                            + "\nPalavra: " + game.getHiddenWord());
                }

            }while (!response.equals("SAIR"));
        } catch (EOFException e) {
            System.out.println("Conexao: EOFException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Conexao: IOException " + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                System.out.println("Conexao: erro close do socket");
            }
        }
    }

}