package solitaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Stack;
import solitaire.Card.Suit;
import java.util.Stack;
import solitaire.*;

public class TestM {
    Solitaire toTest;
    Card heartsTwo = new Card(2, Suit.Hearts);
    Card spadesFive = new Card(5, Suit.Spades);
    Card heartsSix = new Card(6, Suit.Hearts);
    Card clubsFive = new Card(5, Suit.Clubs);
    Card diamondsFour= new Card(4, Suit.Diamonds);
    Card diamondsThree= new Card(3, Suit.Diamonds);
    Card spadesThree= new Card(3, Suit.Spades);
    Card diamondsFive = new Card(5, Suit.Diamonds);
    Card heartsAce = new Card(1, Suit.Hearts);
    Card spadesFour = new Card(4, Suit.Spades);
    Card spadesSeven = new Card(7, Suit.Spades);
    Card heartsFive = new Card(5, Suit.Hearts);
    Card heartsFour = new Card(4, Suit.Hearts);
    Card clubsThree= new Card(3, Suit.Clubs);
    Card clubsFour= new Card(4, Suit.Clubs);
    
    @BeforeEach
    void setUp() {
        toTest = new Solitaire();
        ArrayList<Stack <Card>> columns= new ArrayList<Stack <Card>>();
        for(int i=0; i<7;i++) {
            columns.add(new Stack<Card>());
        }
        
        columns.get(0).push(heartsTwo);
        columns.get(1).push(diamondsFive);
        columns.get(2).push(clubsFour);
        columns.get(2).push(heartsSix);
        columns.get(2).push(clubsFive);
        columns.get(2).push(diamondsFour);
        columns.get(2).push(diamondsThree);
        columns.get(3).push(spadesThree);
        columns.get(4).push(spadesSeven);
        columns.get(5).push(heartsFive);
        columns.get(6).push(heartsFour);
        
        toTest.centerPiles= columns;
        
        //in my program pile keeps track of the face up cards. Replace this code with appropriate structure for your 
        //implementation of the face up pile drawn from the deck.
        toTest.faceUpDeckCards= new Stack<Card>();
        toTest.faceUpDeckCards.add(spadesFive);
        
        //in my program hearts keeps track of the final pile for hearts. Replace this code with the appropriate structure
        //for your implementation of the final pile.
        toTest.heartsFinal= new Stack<Card>();
        toTest.heartsFinal.add(heartsAce);
        
        //in my program spades keeps track of the final pile for spades. Replace this code with the appropriate structure
        //for your implementation of the final pile.
        toTest.spadesFinal = new Stack<Card>();
        toTest.spadesFinal.add(spadesFour);
        
        //in my program clubs keeps track of the final pile for clubs. Replace this code with the appropriate structure
        //for your implementation of the final pile.
        toTest.clubsFinal = new Stack<Card>();
        toTest.clubsFinal.add(clubsThree);
    }
    
    //true cases
    @Test // done
    void fromCenterToFinal(){
        assertTrue(toTest.legalMove(heartsTwo, heartsAce));
    }
    
    @Test
    void fromPileToFinal(){
        assertTrue(toTest.legalMove(spadesFive, spadesFour));
    }
    
    @Test
    void fromCenterToCenter(){
        assertTrue(toTest.legalMove(heartsTwo, spadesThree));
    }
    
    @Test
    void fromCenterToCenterStacked() {
        assertTrue(toTest.legalMove(heartsSix, spadesSeven));
    }
    
    @Test
    void fromFinalToCenter() {
        assertTrue(toTest.legalMove(spadesFour, heartsFive));
    }
    
    //false cases
    @Test
    void fromCenterToPile() {
        assertFalse(toTest.legalMove(heartsFour, spadesFive));
    }
    @Test
    void fromCenterToPile2() {
        assertFalse(toTest.legalMove(spadesThree, spadesFive));
    }
    @Test
    void fromCenterToMiddleCenter() {
        assertFalse(toTest.legalMove(heartsFour, clubsFive));
    }
    @Test
    void fromPileToMiddleCenter() {
        assertFalse(toTest.legalMove(spadesFive, heartsSix));
    }
    @Test
    void fromFinaltoMiddleCenter() {
        assertFalse(toTest.legalMove(clubsThree, diamondsFour));
    }
    @Test
    void fromCenterToFinalWrong() {
        assertFalse(toTest.legalMove(clubsFour, clubsThree));
    }
    @Test
    void fromCenterToFinalWrong2() {
        assertFalse(toTest.legalMove(heartsFour, clubsThree));
    }
    @Test
    void fromFinaltoPile() {
        assertFalse(toTest.legalMove(heartsFour, clubsThree));
    }
    
    
}