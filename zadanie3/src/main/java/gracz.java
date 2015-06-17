/**
 * Klasa gracza przechowujaca imie gracza oraz ilosc punktow
 *
 * @author Kamil Best
 */
class Gracz {
    private String imieGracza;

    Gracz(String imie) {
        imieGracza = imie;
    }

    /**
     * zwraca podane imie gracza
     *
     * @return String imieGracza
     */
    public String zwrocImie() {
        return imieGracza;
    }
}
