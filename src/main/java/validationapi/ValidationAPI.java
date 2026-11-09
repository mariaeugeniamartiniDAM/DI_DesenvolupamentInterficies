package validationapi;

/**
 * Biblioteca pròpia de validació de formularis.
 *
 * Regles obligatòries:
 *  - El nom de l'usuari no pot estar buit i ha de començar amb majúscula.
 *  - Els cognoms són obligatoris.
 *  - El DNI és obligatori, i ha de tenir 9 caràcters:
 *                                                  8 xifres i una lletra,
 *                                                  o una lletra, 7 xifres i una lletra.
 *  - El telèfon és obligatori, només dígits i de 15 caràcters com a màxim.
 *
 * Els mètodes llancen ValidationException amb una clau de text. Això permet
 * que la interfície mostri el missatge en l'idioma que correspongui.
 */
public final class ValidationAPI {

    public static final int LONGITUD_DNI = 9;
    private static final String PATRO_DNI = "(?:[0-9]{8}[A-Za-z] | [A-Za-z][0-9]{7}[A-Za-z])";
    public static final int MAX_TELEFON = 15;

    private ValidationAPI() {
    }

    public static void validarNomUsuari(String nom) throws ValidationException {
        if (esBuit(nom)) {
            throw new ValidationException("nom.buit");
        }

        String text = nom.trim();
        char primeraLletra = text.charAt(0);

        // Regla obligatòria: el nom ha de començar amb una lletra majúscula.
        if (!Character.isLetter(primeraLletra) || !Character.isUpperCase(primeraLletra)) {
            throw new ValidationException("nom.majuscula");
        }

        // Només lletres, espais, apòstrofs i guions.
        if (!text.matches("[\\p{L}][\\p{L} '\\-]*")) {
            throw new ValidationException("nom.format");
        }
    }

    public static void validarCognom(String cognom, String clauBuit) throws ValidationException {
        if (esBuit(cognom)) {
            throw new ValidationException(clauBuit);
        }
    }

    public static void validarDni(String dni) throws ValidationException {
        if (esBuit(dni)) {
            throw new ValidationException("dni.buit");
        }

        String text = dni.trim();
        if (text.length() != LONGITUD_DNI || !text.matches(PATRO_DNI)) {
            throw new ValidationException("dni.format");
        }
    }

    public static void validarTelefon(String telefon) throws ValidationException {
        if (esBuit(telefon)) {
            throw new ValidationException("telefon.buit");
        }

        String text = telefon.trim();
        if (text.length() > MAX_TELEFON || !text.matches("\\d+")) {
            throw new ValidationException("telefon.format");
        }
    }

    public static void validarCampObligatori(String valor, String clauBuit) throws ValidationException {
        if (esBuit(valor)) {
            throw new ValidationException(clauBuit);
        }
    }

    public static void validarNomJoc(String nom) throws ValidationException {
        if (esBuit(nom)) {
            throw new ValidationException("nom.joc.buit");
        }
    }

    public static boolean esBuit(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}
