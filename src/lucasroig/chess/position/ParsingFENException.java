package lucasroig.chess.position;


public class ParsingFENException extends Exception{

    public ParsingFENException(String fen, String message) {
        this(fen + " , " + message);
    }
    
    public ParsingFENException(String fen){
        super("Unable to parse FEN : " + fen);
    }
}
