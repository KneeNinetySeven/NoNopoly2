package org.knee.nonopoly.felder.immobilien;

import org.knee.nonopoly.felder.Feld;
import org.knee.nonopoly.felder.FeldTypen;

/**
 * Created by Nils on 24.09.2016.
 */
public abstract class ImmobilienFeld extends Feld {

    private int kaufpreis;
    public ImmobilienTypen immobilienTyp;

    public ImmobilienFeld(int index, String name, int kaufpreis) {
        super(index, name);
        this.kaufpreis = kaufpreis;
        this.typ = FeldTypen.IMMOBILIENFELD;
        this.immobilienTyp = ImmobilienTypen.ABSTRACT;
    }

    public boolean istImmobilienTyp(ImmobilienTypen testImmoTyp){
        return this.immobilienTyp == testImmoTyp;
    }

    public int getKaufpreis() {
        return kaufpreis;
    }

    public void setKaufpreis(int kaufpreis) {
        this.kaufpreis = kaufpreis;
    }
}