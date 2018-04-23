package lucasroig.chess.position;


public class CastlingRights {
    private boolean blackLongCastle = false;
    private boolean blackShortCastle = false;
    private boolean whiteShortCastle = false;
    private boolean whiteLongCastle = false;

    public void setBlackLongCastle(boolean blackLongCastle) {
        this.blackLongCastle = blackLongCastle;
    }

    public void setBlackShortCastle(boolean blackShortCastle) {
        this.blackShortCastle = blackShortCastle;
    }

    public void setWhiteShortCastle(boolean whiteShortCastle) {
        this.whiteShortCastle = whiteShortCastle;
    }

    public void setWhiteLongCastle(boolean whiteLongCastle) {
        this.whiteLongCastle = whiteLongCastle;
    }

    public boolean canBlackLongCastle() {
        return blackLongCastle;
    }

    public boolean canBlackShortCastle() {
        return blackShortCastle;
    }

    public boolean canWhiteShortCastle() {
        return whiteShortCastle;
    }

    public boolean canWhiteLongCastle() {
        return whiteLongCastle;
    }
    
    
}
