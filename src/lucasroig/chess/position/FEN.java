package lucasroig.chess.position;

import java.util.Arrays;
import java.util.List;

public class FEN {
    public static FEN STARTING_FEN = FEN.getStartingFen();
    private static FEN getStartingFen(){
        FEN fen = null;
        try{
            fen = new FEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        }catch(ParsingFENException e){
            System.err.println("Error parsing starting position fen. This should not happen.");
        }
        return fen;
    }
    
    private String positionString;
    private String sideToMove;
    private String castlingRights;
    private String epSquare;
    private int halfMoveClock;
    private int fullMoveNumber;
    
    public FEN(String fen) throws ParsingFENException {
        this.validateFenString(fen);
        String[] splittedFen = fen.split(" ");
        this.positionString = splittedFen[0];
        this.sideToMove = splittedFen[1];
        this.castlingRights = splittedFen[2];
        this.epSquare = splittedFen[3];
        try{
            this.halfMoveClock = Integer.parseInt(splittedFen[4]);
            this.fullMoveNumber = Integer.parseInt(splittedFen[5]);
        }catch(Exception e){
            throw new ParsingFENException(fen,"Half move clock or full move number is not a number");
        }
    }
    
    private void validateFenString(String fen) throws ParsingFENException{
        String[] splittedFen = fen.split(" ");
        if(splittedFen.length != 6) throw new ParsingFENException(fen, "Wrong number of fields");
        if(!this.validateCastlingRights(splittedFen[2])) throw new ParsingFENException(fen, "Wrong castlingRights");
        if(!this.validateEpSquare(splittedFen[3])) throw new ParsingFENException(fen, "Wrong castlingRights");
        if(!this.validateSideToMove(splittedFen[1])) throw new ParsingFENException(fen, "Wrong castlingRights");
        if(!this.validatePositionString(splittedFen[0])) throw new ParsingFENException(fen, "Wrong castlingRights");
    }
    
    private boolean validateCastlingRights(String castlingRights){
        if(castlingRights.equals("-")) return true;
        if(castlingRights.length() > 4) return false;
        for(int i = 0;i<castlingRights.length();i++){
            char c = castlingRights.charAt(i);
            if(c!='k' && c!='K' && c!='q' && c!='Q') return false;
        }
        return true;
    }
    
    private boolean validateEpSquare(String epSquare){
        if(epSquare.equals("-")) return true;
        if(epSquare.length() != 2) return false;
        char column = epSquare.charAt(0);
        if(column != 'a' && column != 'b' && column != 'c' && column != 'd' && column != 'e' 
                && column != 'f' && column != 'g' && column != 'h') return false;
        char line = epSquare.charAt(1);
        return line == '3' || line == '6';
    }
    
    private boolean validateSideToMove(String sideToMove){
        return sideToMove.equals("w") || sideToMove.equals("b");
    }
    
    private boolean validatePositionString(String positionString){
        String[] lines = positionString.split("/");
        List<Character> allowedChars = Arrays.asList('P','p','Q','q','K','k','N','n','B','b','R','r',
                '1','2','3','4','5','6','7','8');
        if(lines.length != 8) return false;
        for(String line : lines){
            int lineSize = 0;
            for(int i=0; i<line.length(); i++){
                char c = line.charAt(i);
                if(!allowedChars.contains(c)) return false;
                
                if(Character.isDigit(c)) lineSize += ((int) c - 48);
                else lineSize ++;
            }
            if(lineSize != 8) return false;
        }
        return true;
    }

    public String getPositionString() {
        return positionString;
    }

    public String getSideToMove() {
        return sideToMove;
    }

    public String getCastlingRights() {
        return castlingRights;
    }

    public String getEpSquare() {
        return epSquare;
    }

    public int getHalfMoveClock() {
        return halfMoveClock;
    }

    public int getFullMoveNumber() {
        return fullMoveNumber;
    }
}
