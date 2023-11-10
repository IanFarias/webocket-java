# websocket-java - Jogo da Forca

### Integrantes: Ian Farias Paixão e Milena Pinto Petersen 


## Tecnologias 
- Java 8
- IDE IntelliJ
- java.net

## Execução
### Executar com IntelliJ
#### Server
- Abrir o projeto /server no intellij
- Rodar o main localizado no arquivo Server.java
![image](https://github.com/IanFarias/websocket-java/assets/64112672/d6aa4590-0cab-4d00-9541-3b851977158f)
- Clicar no icone de start para rodar.
![image](https://github.com/IanFarias/websocket-java/assets/64112672/6d553073-96a9-4a93-9d00-9ab79b6219b5)
- O servidor irá rodar utilizando a porta padrão definida no projeto (6789)

#### Client
- Com o servidor rodando, abrir o projeto /client em outra aba no intellij
- Rodar o main localizado no arquivo Main.java
  
![image](https://github.com/IanFarias/websocket-java/assets/64112672/060476db-7998-4349-a99a-966a1e89b2f9)

- Clicar no icone de start para rodar.
  
![image](https://github.com/IanFarias/websocket-java/assets/64112672/85fed30a-6548-47cc-a550-646723734d0e)

- O cliente irá conectar utilizando no servidor utilizando a porta padrão definida (6789)

Ao final o jogo estará rodando no console.


### Executar com Terminal

Da mesma forma que a execução com a IDE, inicializar primeiro o servidor, depois o cliente. 
A diferença é que na hora de executar o comando de inicialização é possivel passar parametros no args.

Para o servidor é possivel escolher a porta.
Para o client é possivel dizer o host e a porta.
