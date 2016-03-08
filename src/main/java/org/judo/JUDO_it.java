/***************************************************************************
 * JUDO - A Java IDE for Children and Beginning Programmers
 * Copyright (C) 2001  Thomas J. Dunn
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 ***************************************************************************/

package org.judo;

/**
 * Italian localization
 *
 * @author Yuri Cervoni
 * @version 1.0
 */
public class JUDO_it extends JUDO_localization {
  public JUDO_it() {
    IDE_DEFAULT_PROG_NAME = "Senza Titolo";
    IDE_SAVE_PROG = "Salva il Programma";
    IDE_ERR_INIT_JAVA = "Errore di inizializzazione di Java, Leggere README.txt";

    IDE_FILE = "File";
    IDE_FILE_NEW = "Nuovo";
    IDE_FILE_SAVE = "Salva";
    IDE_FILE_SAVE_NEW_NAME = "Salva con nome...";
    IDE_FILE_OPEN = "Apri programma...";
    IDE_FILE_DELETE = "Elimna programma...";
    IDE_FILE_EXIT = "Esci";

    IDE_EDIT = "Modifica";
    IDE_EDIT_COPY = "Copia";
    IDE_EDIT_CUT = "Taglia";
    IDE_EDIT_PASTE = "Incolla";
    IDE_EDIT_UNDO = "Annulla";
    IDE_EDIT_GOTO_LINE = "Vai alla Linea...";

    IDE_PROG = "Programma";
    IDE_PROG_PROP = "Proprietà...";

    IDE_RUN = "Avvia";
    IDE_RUN_RUN = "Avvia";
    IDE_RUN_COMPILE = "Compila";

    IDE_HELP = "Aiuto";
    IDE_HELP_JUDO_HELP = "JUDO Guida";
    IDE_HELP_TUTORIALS = "Tutorials";
    IDE_HELP_FUNC_REF = "Indice Funzioni JUDO";
    IDE_HELP_COLOR_REF = "Indice dei colori in JUDO";
    IDE_HELP_ABOUT_JUDO = "Informazioni su JUDO";
    IDE_HELP_JUDO_WEBSITE = "Sito Web di JUDO";

    IDE_BUTTON_RUN = "Avvia";

    IDE_COMPILE_ERR = "Errore di compilazione (javac interrupted)";
    IDE_404_ERR = "Errore: File %s non trovato.";
    IDE_READ_FILE_ERR = "Errore: Impossibile leggere il file %s.";
    IDE_CREATE_FILE_ERR = "Errore: Impossibile creare il file %s.";
    IDE_EXIT_JUDO_NO_SAVE_MSG = "Vuoi uscire da JUDO senza salvare questo programma?";
    IDE_EXIT_NO_SAVE_TIT = "Esci senza Salvare?";
    IDE_SAVE_NEW_NAME_TIT = "Salva con un nuovo nome";
    IDE_SAVE_TIT = "Salva";
    IDE_PROG_EXISTS_MSG = "Il Programma \"%s\" esiste già.  Sovrascriverlo?";
    IDE_PROG_EXISTS_TIT = "Programma esistente";
    IDE_NO_PROG_DIR_MSG = "Cartella inesistente e la sua creazione è fallita.";
    IDE_ERR_SAVING_TIT = "Errore di salvataggio";
    IDE_PROG_DIR_NOT_WRIT = "Errore di Salvataggio.  Impossibile scrivere su disco.";
    IDE_OPEN_NO_SAVE_MSG = "Vuoi aprire un nuovo programma senza\nsalvare i cambiamenti ?";
    IDE_OPEN_NO_SAVE_TIT = "Aprire senza salvare?";
    IDE_NO_PROG_MSG = "Non ci sono programmi da aprire";
    IDE_NO_PROG_TIT = "Nessun programma aperto";
    IDE_OPEN_TIT = "Apri programma";
    IDE_OPEN_PROG_MSG = "Si è verificato un errore in apertura \"%s\"";
    IDE_OPEN_PROG_ERR_TIT = "Errore di apertura";
    IDE_NO_PROG_DEL_MSG = "Non ci sono programmi da cancellare";
    IDE_NO_PROG_DEL_TIT = "Nessun programma eliminato";
    IDE_DEL_TIT = "Elimina programma";
    IDE_NEW_WITHOUT_SAVE_MSG = "Vuoi creare un nuovo programma senza\nsalvare i cambiamenti ?";
    IDE_NEW_WITHOUT_SAVE_TIT = "Crea un nuovo programma senza salvare?";
    IDE_GOTO_LINE_NUM_MSG = "Vai alla linea Numero";
    IDE_GOTO_LINE_NUM_TIT = "Vai alla linea Numero";
    IDE_LINE_NUM_GREATER_MSG = "Il numero di linea deve essere maggiore o uguale a 1";
    IDE_INV_LINE_NUM_TIT = "Numero di linea non valido";
    IDE_LINE_COUNT_MSG = "Ci sono %s linee di codice in questo programma";
    IDE_NO_LINE_NUM_MSG = "Inserisci un numero di linea";
    IDE_LINE_NUM_INV_MSG = "Il numero di linea %s non è valido.";

    IDE_VAR_VAL_DEC_ASS_TIT = "Variabili, Valori, Dichiarazioni, e Assegnazioni";
    IDE_JUDO_ABOUT_MSG = "JUDO - A Java IDE for Beginning Programmers\nhttp://judo.sourceforge.net\nVersion: %s\n\nJUDO, Copyright (C) 2001-2003 Thomas J. Dunn";

    CER_STRING_MISSING_QUOTE = "Nella Stringa manca \"";
    CER_EMPTY_CHAR = "Caratteri vuoti%sSei sicuro di aver usato le doppie virgolette e non quelle singole?";
    CER_UNCLOSED_CHAR = "Errore caratteri Error%sSei sicuro di aver usato le doppie virgolette e non quelle singole?";
    CER_INVALID_STATEMENT = "Codice Java non valido";
    CER_CURLY_BRACE_NO_MATCH = "Parentesi { } non corrispondono";
    CER_NO_VOID_MAIN = "Errore: manca'void main()'";
    CER_ERR_ON_LINE = "Errore alla linea ";
    CER_COMP_SUCCESS = "Compilazione eseguita con successo.";
    CER_UNDEF_VAR = "Variabile non definita ";
    CER_UNDEF_FUNC = "Funzione non definita ";
    CER_UNDEF_SYMBOL = "Simbolo non definito ";

    APP_PROG_COMPLETE = "Programma completato";

    DEL_PROG_TO_DELETE = "Scegli un programma da eliminare";
    DEL_OK = "Elimina";
    DEL_CANCEL = "Cancella";
    DEL_CONFIRM_TIT = "Eliminare il programma?";
    DEL_CONFIRM_MSG = "Sei sicuro di eliminare il programma '%s'?";

    OPN_PROG_TO_OPEN = "Scegli il programma da aprire";
    OPN_OK = "OK";
    OPN_CANCEL = "Cancella";

    PRP_CHOOSE_PROG_PROP = "Scegli le proprietà per questo programma";
    PRP_GRAPHICS = "Grafica";
    PRP_TEXT = "Testo";
    PRP_TEXT_AND_GRAPHICS = "Testo e Grafica";
    PRP_WIN_STYLE = "Stile finestra";
    PRP_OK = "OK";
    PRP_CANCEL = "Cancella";

    SAV_ENTER_PROG_NAME = "Inserisci un nome per il tuo programma";
    SAV_SAVE = "Salva";
    SAV_CANCEL = "Cancella";
    SAV_CHOOSE_DIFF_NAME_MSG = "Scegli un nome differente per il programma";
    SAV_CHOOSE_DIFF_NAME_TIT = "Scegli un nome differente per il programma";
    SAV_TYPE_PROG_NAME_MSG = "Digita un Nome che abbia lettere e/o numeri";
    SAV_TYPE_PROG_NAME_TIT = "Nessun nome inserito";
    SAV_ONLY_NUM_LET_SPACE_MSG = "Usa solo lettere, numeri e spazi per il nome del programma";
    SAV_INV_PROG_NAME = "Nome del programma non valido";
    SAV_NO_SAV_PROG_WITH_NUM_MSG = "Il nome del programma non può iniziare con un numero";


    IDE_DELETE_PROG_MSG = "Si è verificato un errore all'eliminazione del programma \"%s\"";
    IDE_DELETE_PROG_ERR_TIT = "Errore di eliminazione del programma";
    IDE_OPEN_SAMPLE_CONFIRM_MSG = "Vuoi aprire un esempio senza\nsalvare i cambiamenti?";
    IDE_OPEN_SAMPLE_CONFIRM_TIT = "Aprire un esempio senza salvare?";
    APP_EXCEPTION_OCCURED = "Si è verificato un errore a Runtime";
    IDE_EDIT_REDO = "Ripeti";
    IDE_EDIT_SELECT_ALL = "Seleziona tutto";
    IDE_FILE_OPEN_SAMPLE = "Apri Esempio...";
  }
}