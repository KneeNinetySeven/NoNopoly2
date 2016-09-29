package org.knee.nonopoly.logik;

import org.knee.nonopoly.entities.Bank;
import org.knee.nonopoly.entities.SpielerFabrik;
import org.knee.nonopoly.entities.spielerStrategien.StrategieFabrik;
import org.knee.nonopoly.logik.logging.ProtokollantFabrik;

import java.util.ArrayList;

/**
 * Created by Nils on 11.09.2016.
 */
public class SchiedsrichterFabrik {

    private ArrayList<SpielerFabrik> teilnehmer;
    private Bank bank;
    private ProtokollantFabrik protokollant;

    public SchiedsrichterFabrik(){
        this.setProtokollant(new ProtokollantFabrik());
        this.bank = new Bank();
        this.teilnehmer = new ArrayList<SpielerFabrik>();
    }



    public ProtokollantFabrik getProtokollant() {
        return protokollant;
    }

    private void setProtokollant(ProtokollantFabrik protokollant) {
        this.protokollant = protokollant;
    }

    public ArrayList<SpielerFabrik> getTeilnehmer() {
        return teilnehmer;
    }

    public void registriereTeilnehmer(String name, StrategieFabrik strategie){
        this.teilnehmer.add(SpielerFabrik.spielerErzeugen(name, strategie));
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}