import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private String word;

    private String hiddenWord;

    private List<String> wrongGuesses;

    private Integer chances;

    final List<String> WORDS =
            new ArrayList<>(
                    Arrays.asList(
                            "ALGORITMO",
                            "PROGRAMAÇAO",
                            "COMPUTADOR",
                            "REDES",
                            "PROTOCOLO",
                            "JAVA",
                            "WEBSOCKET",
                            "ROTEADOR",
                            "SWITCH",
                            "LINGUAGEM",
                            "LOGICA"
                    ));

    public Game() {
        this.wrongGuesses = new ArrayList<>();
        this.chances = 6;
    }

    public boolean isVictory() {
        return this.hiddenWord.equals(word) && this.chances > 0;
    }

    public boolean verifyEndGame(String guess) {
        if(this.wrongGuesses.contains(guess)) return false;

        if(guess.length() > 1 ) {
            if(guess.equals(this.word)) {
                setHiddenWord(guess);
                return true;
            }else {
                this.chances--;
            }
        }

        if (guess.length() == 1) {
            char ch = guess.charAt(0);
            if (this.word.indexOf(ch) != -1) {
                this.revealCharacters(ch);
            }else  {
                this.wrongGuesses.add(guess);
                this.chances--;
            }
        }

        if(this.chances <= 0) return true;

        return this.word.equals(this.hiddenWord) ;
    }

    private void createHiddenWord() {
        StringBuilder hidden = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            hidden.append("_");
        }

        setHiddenWord(hidden.toString());
    }
    private void revealCharacters(char ch) {
        StringBuilder updatedWord = new StringBuilder(this.getHiddenWord());
        for (int i = 0; i < this.word.length(); i++) {
            if (this.word.charAt(i) == ch) {
                updatedWord.setCharAt(i, ch);
            }
        }
        setHiddenWord(updatedWord.toString());
    }

    public void selectRandomWord() {
        int wordIndex = (int) Math.floor(Math.random() * this.WORDS.size());

        setWord(this.WORDS.get(wordIndex));
        createHiddenWord();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public List<String> getWrongGuesses() {
        return this.wrongGuesses;
    }

    public void setWrongGuesses(List<String> wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }

    public Integer getChances() {
        return chances;
    }

    public void setChances(Integer chances) {
        this.chances = chances;
    }
}
