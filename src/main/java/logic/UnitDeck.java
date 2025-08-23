package logic;

import java.util.ArrayList;
import java.util.Objects;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck(String deckName) {
        setDeckName(deckName);
        cardsInDeck = new ArrayList<>();
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
        for (CardCounter cardCounter : cardsInDeck) {
            if (cardCounter.getCard().equals(newCard)) {
                cardCounter.setCount(cardCounter.getCount() + count);
                return;
            }
        }
        cardsInDeck.add(new CardCounter(newCard, count));
    }

    public void removeCard(UnitCard toRemove, int count){
        if (count <= 0 || !this.existsInDeck(toRemove)) return;
        for (CardCounter cardCounter : cardsInDeck) {
            if (cardCounter.getCard().equals(toRemove)) {
                int newCount = cardCounter.getCount() - count;
                if (newCount <= 0) {
                    cardsInDeck.remove(cardCounter);
                } else {
                    cardCounter.setCount(newCount);
                }
                return;
            }
        }
    }

    public int cardCount(){
        int sum = 0;
        for (CardCounter cardCounter : cardsInDeck) {
            sum += cardCounter.getCount();
        }
        return sum;
    }

    public boolean existsInDeck(UnitCard card){
        for (CardCounter cardCounter : cardsInDeck) {
            if (cardCounter.getCard().equals(card)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnitDeck unitDeck = (UnitDeck) o;
        return Objects.equals(deckName, unitDeck.deckName);
    }

}
