package org.PokerHandSorter.CardTypes;

import org.PokerHandSorter.Enums.CardSuit;
import org.PokerHandSorter.Enums.CardValue;
import org.PokerHandSorter.Enums.CombinationRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private final List<Card> tempCardSorter;
    public final CompareRanking ranking;

    public Hand(List<Card> cards) {
        List<Card> temp = new ArrayList<>(cards);
        temp.add(new Card(CardValue.ZERO, CardSuit.NULL));
        Collections.sort(temp);
        this.tempCardSorter = Collections.unmodifiableList(temp);

        CompareRanking straightRanking = straightRanking();

        if (straightRanking != null) {
            ranking = straightRanking;
        } else {
            ranking = cardMatchRanking();
        }
    }

    @Override
    public int compareTo(Hand o) {
        return ranking.compareTo(o.ranking);
    }

    private CardValue cardValue(int cardIndex) {
        return tempCardSorter.get(cardIndex).getValue();
    }

    private CardSuit cardSuit(int cardIndex) {
        return tempCardSorter.get(cardIndex).getSuit();
    }

    private boolean isFlush() {
        for (int i = 0; i < 4; i++) {
            if (cardSuit(i) != cardSuit(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraight() {
        for (int i = 0; i < 4; i++) {
            if (cardRank(i) + 1 != cardRank(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private CompareRanking makeRanking(CombinationRank rank) {
        return new CompareRanking(rank, cardValue(4), (CardValue) null, getKickers());
    }

    private CompareRanking straightRanking() {
        boolean straight = isStraight();
        boolean flush = isFlush();
        if (straight && flush) {
            return makeRanking(CombinationRank.STRAIGHT_FLUSH);
        } else if (flush) {
            return makeRanking(CombinationRank.FLUSH);
        } else if (straight) {
            return makeRanking(CombinationRank.STRAIGHT);
        } else {
            return null;
        }
    }

    private CompareRanking cardMatchRanking() {
        CardRankingBuilder builder = new CardRankingBuilder();

        for (Card c : tempCardSorter) {
            builder.addCard(c.getValue());
        }
        return builder.build();
    }

    private int cardRank(int cardIndex) {
        return cardValue(cardIndex).ordinal();
    }

    private List<CardValue> getKickers() {
        List<CardValue> kickers = new LinkedList<CardValue>();
        for (int i = 0; i < 4; i++) {
            kickers.add(cardValue(i));
        }
        return kickers;
    }

    private static class CardRankingBuilder {
        private CardValue previous = null;
        private int counter = 0;
        private int pair = 0;
        private boolean triplesFound, quadsFound;
        private CardValue secondCheck = null;
        private CardValue thirdCheck = null;
        private List<CardValue> kicker = new ArrayList<>(5);

        public void addCard(CardValue newCard) {
            if (pairComplete(newCard)) {
                handleCardGroup(newCard);
                resetCounter(newCard);
            } else {
                counter++;
            }
        }

        private boolean pairComplete(CardValue newCard) {
            return previous != newCard;
        }

        private void handleCardGroup(CardValue newCard) {
            switch (counter) {
                case 2:
                    handlePair(newCard);
                    break;
                case 3:
                    handleTriples(newCard);
                    break;
                case 4:
                    handleQuads(newCard);
                    break;
                default:
                    addKicker();
            }
        }

        private void resetCounter(CardValue newCard) {
            previous = newCard;
            counter = 1;
        }

        private void handlePair(CardValue current) {
            pair++;
            if (secondCheck == null) {
                secondCheck = previous;
            } else if (pairHasLowerRanking(current)) {
                thirdCheck = current;
            } else {
                demotePrimary();
            }
        }

        private boolean pairHasLowerRanking(CardValue current) {
            return triplesFound || secondCheck.compareTo(current) > 0;
        }

        private void demotePrimary() {
            thirdCheck = secondCheck;
            secondCheck = previous;
        }

        private void handleTriples(CardValue value) {
            triplesFound = true;
            demotePrimary();
        }

        private void handleQuads(CardValue value) {
            quadsFound = true;
            secondCheck = previous;
        }

        private void addKicker() {
            if (previous != null) kicker.add(previous);
        }

        public CompareRanking build() {
            if (quadsFound) {
                return Rank(CombinationRank.FOUR_OF_A_KIND);
            } else if (triplesFound) {
                if (pair > 0) {
                    return Rank(CombinationRank.FULL_HOUSE);
                } else {
                    return Rank(CombinationRank.THREE_OF_A_KIND);
                }
            } else if (pair == 2) {
                return Rank(CombinationRank.TWO_PAIRS);
            } else if (pair == 1) {
                return Rank(CombinationRank.PAIR);
            } else {
                return Rank(CombinationRank.HIGH_CARD);
            }
        }

        private CompareRanking Rank(CombinationRank rank) {
            return new CompareRanking(rank, secondCheck, thirdCheck, kicker);
        }
    }
}