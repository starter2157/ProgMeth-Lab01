package logic;

import java.util.ArrayList;
import java.util.Objects;

public class UnitDeck {
    ArrayList<CardCounter> cardsInDeck;
    String deckName;

    public UnitDeck(String deckName) {
        setDeckName(deckName);
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        if(deckName.isBlank()){
            this.deckName = "Untitled Deck";
        } else {
            this.deckName = deckName;
        }
    }

    public void addCard(UnitCard newCard, int count){
        if (count <= 0) return;
        CardCounter counter = new CardCounter(newCard, count);
        if (this.existsInDeck(newCard)) {
            cardsInDeck.get(cardsInDeck.indexOf(counter)).setCount(cardsInDeck.get(cardsInDeck.indexOf(counter)).getCount()+count);
        } else {
            cardsInDeck.add(new CardCounter(newCard, count));
        }
    }

    public void removeCard(UnitCard toRemove, int count){
        if (count <= 0 || !this.existsInDeck(toRemove)) return;
        CardCounter counter = new CardCounter(toRemove, count);
        if (cardsInDeck.get(cardsInDeck.indexOf(counter)).getCount() - count <= 0){
            cardsInDeck.remove(counter);
        } else {
            cardsInDeck.get(cardsInDeck.indexOf(counter)).setCount(cardsInDeck.get(cardsInDeck.indexOf(counter)).getCount()-count);
        }
    }

    public int cardCount(){
        return cardsInDeck.size();
    }

    public boolean existsInDeck(UnitCard card){
        CardCounter counter = new CardCounter(card, 0);
        return cardsInDeck.contains(counter);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnitDeck unitDeck = (UnitDeck) o;
        return Objects.equals(deckName, unitDeck.deckName);
    }

}
