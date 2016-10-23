package org.knee.nonopoly.felder.immobilien;

import org.knee.nonopoly.entities.Bank;
import org.knee.nonopoly.entities.Spieler;
import org.knee.nonopoly.logik.Schiedsrichter;

import java.util.List;

/**
 * @author Nils
 */
public class Werk extends ImmobilienFeld {

    private List<Integer> faktoren;

    /**
     * Konstruktor
     *
     * @param index
     * @param name
     * @param kaufpreis
     * @param faktoren
     */
    public Werk(int index, String name, int kaufpreis, List<Integer> faktoren) {
        super(index, name, kaufpreis);
        this.immobilienTyp = ImmobilienTypen.WERK;
        this.faktoren = faktoren;
    }

    /**
     * Führt die Aktion des Feldes für den aktiven Spieler aus
     * Wird in den einzelnen Feldern überschrieben
     *
     * @param schiedsrichter
     */
    @Override
    public void fuehrePflichtAktionAus(Schiedsrichter schiedsrichter) {
        Spieler aktiverSpieler = schiedsrichter.getAktiverSpieler();
        Bank bank = schiedsrichter.getBank();

        if (besitzer == schiedsrichter.getBank()) {
            if (aktiverSpieler.getStrategie().erlaubtFeldKauf(schiedsrichter.getAktiverSpieler(), this)) {
                wirdGekauftDurchSpieler(aktiverSpieler, bank);
            }
        } else {
            int miete = schiedsrichter.getLetzterWurf().getSum() * 80;
            aktiverSpieler.ueberweiseAn(miete, besitzer);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Werk{");
        sb.append("index='").append(this.getIndex()).append('\'');
        sb.append('}');
        sb.append("name=").append(this.getName());
        sb.append('}');
        sb.append("kaufpreis=").append(this.getKaufpreis());
        sb.append('}');
        sb.append("faktoren=").append(faktoren);
        sb.append('}');
        return sb.toString();
    }
}
