package org.anonhyme.server.logic;


public class LocalType {

    public LocalType() {
    }

    public String getLocalType(String local) {
        if (local.equals("C1-3125") ||
                local.equals("C1-3024")
                ) return "Laboratoire";
        if (local.equals("C1-5125") ||
                local.equals("C1-5126") ||
                local.equals("C1-5127") ||
                local.equals("C1-5128")
                ) return "Salle de tutorat";
        return "Aucune type de local";
    }
}

