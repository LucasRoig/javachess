package lucasroig.chess.position;

import org.junit.Test;
import static org.junit.Assert.*;

public class FENTest {
    
    @Test
    public void it_should_parse_a_fen_string() throws ParsingFENException{
        String startinPositionFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        FEN fen = new FEN(startinPositionFen);
        String[] splittedFen = startinPositionFen.split(" ");
        assertEquals(splittedFen[0], fen.getPositionString());
        assertEquals(splittedFen[1], fen.getSideToMove());
        assertEquals(splittedFen[2], fen.getCastlingRights());
        assertEquals(splittedFen[3], fen.getEpSquare());
        assertEquals(Integer.parseInt(splittedFen[4]), fen.getHalfMoveClock());
        assertEquals(Integer.parseInt(splittedFen[5]), fen.getFullMoveNumber());
    }
    
    @Test
    public void it_should_not_parse_a_fen_without_valid_full_move_number_and_half_move_clock(){
        String malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 a";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - a 0";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
    }
    
    @Test
    public void it_should_not_parse_a_fen_without_valid_castling_rights(){
        String malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w 0 - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
    }
    @Test
    public void it_should_not_parse_a_fen_without_valid_ep_square(){
        String malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq h9 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
    }
    
    @Test
    public void it_should_not_parse_a_fen_without_valid_side_to_move(){
        String malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR f KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
    }
    
    @Test
    public void it_should_not_parse_a_fen_without_valid_position_string(){
        String malformedFen = "w KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP w KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/9/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPPP/RNBQKBNR w KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
        
        malformedFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPFPP/RNBQKBNR w KQkq - 0 1";
        try{
            FEN fen = new FEN(malformedFen);
            fail();
        }catch(Exception e){
            assertEquals(e.getClass(), ParsingFENException.class);
        }
    }
}
