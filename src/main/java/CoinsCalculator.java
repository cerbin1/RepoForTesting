package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class CoinsCalculator {
        private final Integer[] coins;

        public CoinsCalculator(Integer... coins) {
//        Arrays.sort(coins, Collections.reverseOrder());
            this.coins = coins;
        }

        public Integer[] count(int price) {
//        final List<Integer> coinsCounter = new ArrayList<>();
//        if (price < 0) {
//            throw new IllegalArgumentException();
//        }
//        int coinsCount = coins.length;
//        for (int i = 0; i < coinsCount; i++) {
//            if (hasNextCoin(i, coinsCount)) {
//                int doubledValueOfNextCoin = coins[i + 1] * 2;
//                if (doubledValueOfNextCoin > coins[i] && price >= doubledValueOfNextCoin) {
//                    i++;
//                }
//            }
//            int coin = coins[i];
//            while (price >= coin) {
//                price -= coin;
//                coinsCounter.add(coin);
//            }
//        }
//        return coinsCounter.toArray(new Integer[0]);

            final List<Integer> coinsCounter = new ArrayList<>();
            if (isNegative(price)) {
                throw new IllegalArgumentException();
            }
            int coinsCount = coins.length;

            while (price > 0) {
                for (int i = 0; i < coinsCount; i++) {
                    int nextCoin = coins[i];
                    // musze tutaj znalezc maksymalna monete, ktora jest wielokrotnoscia kwoty
                    if(nextCoin != 1) {
                        if (price % nextCoin == 0) {
//                    while (price % nextCoin == 0 && price !=0) { // mozna tu po prostu w petli dodac aktualna monete
                            price -= nextCoin;
                            coinsCounter.add(nextCoin);
                            break;
//                    }
                        }
                    }
                }
                // tutaj pobieram najmniejsza monete jezeli nie znalazlem zadnych wielokrotnosci monety

                // tutaj trzeba robic tylko jak nie znalazlo wielokrotnosci
                if(price != 0) {
                    int najmniejsza = Integer.MAX_VALUE;
                    for (int i = 0; i < coinsCount; i++) {
                        int nextCoin = coins[i];
                        if (nextCoin < najmniejsza) {
                            najmniejsza = nextCoin;
                        }
                    }
                    coinsCounter.add(najmniejsza);
                    price -= najmniejsza;
                }

            }
            Collections.sort(coinsCounter);
            System.out.println(coinsCounter);
            // UWAGA!!!!!!!!!! a jakby tak robic osobno zlotowki osobno grosze?
            return coinsCounter.toArray(new Integer[0]);
        }

        private boolean isNegative(int price) {
            return price < 0;
        }

        private boolean hasNextCoin(int i, int coinsCount) {
            return i < coinsCount - 1;
        }
    }
