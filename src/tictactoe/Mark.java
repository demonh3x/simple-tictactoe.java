package tictactoe;

public enum Mark {
    X ("x", "Player x has won!"),
    O ("o", "Player o has won!"),
    NONE ("-", "It is a draw!");

    private final String resultMessage;
    private final String symbol;

    Mark(String symbol, String resultMessage) {
        this.symbol = symbol;
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public String getSymbol() {
        return symbol;
    }
}
