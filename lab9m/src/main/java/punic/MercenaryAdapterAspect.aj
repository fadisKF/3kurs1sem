package punic;

import punic.Mercenary;
import punic.Warrior;

public aspect MercenaryAdapterAspect {

declare parents: Mercenary implements Warrior;

public void Mercenary.info() {
    this.showUnit();
}
}