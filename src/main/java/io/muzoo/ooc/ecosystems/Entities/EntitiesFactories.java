package io.muzoo.ooc.ecosystems.Entities;

import io.muzoo.ooc.ecosystems.Entities.*;

public class EntitiesFactories {
    public static Entities createEntities(String entitesClass, boolean radomAge){
        switch (entitesClass){
            case "Rabbit":
                Rabbit rabbit = new Rabbit(radomAge);
                return rabbit;
            case"Fox":
                Fox fox = new Fox(radomAge);
                return fox;
            case"Tiger":
                Tiger tiger = new Tiger(radomAge);
                return tiger;
            case "Hunter":
                Hunter hunter = new Hunter();
                return hunter;
            default:
                return null;
        }

    }
}
