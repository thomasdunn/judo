/***************************************************************************
 ***************************************************************************
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
 * Slovenian localisation
 *
 * @author Saša Divjak
 * @version 1.3
 */
public class JUDO_si extends JUDO_localization {
  public JUDO_si() {
    IDE_DEFAULT_PROG_NAME = "Neimenovano";
    IDE_SAVE_PROG = "Shrani program";
    IDE_ERR_INIT_JAVA = "Napaka pri inicializaciji jave, preberi datoteko README.txt ki prihaja z JUDO";

    IDE_FILE = "Datoteka";
    IDE_FILE_NEW = "Nova";
    IDE_FILE_SAVE = "Shrani";
    IDE_FILE_SAVE_NEW_NAME = "Shrani z novim imenom...";
    IDE_FILE_OPEN = "Odpri Program...";
    IDE_FILE_DELETE = "Brisanje programa...";
    IDE_FILE_EXIT = "Izstop";

    IDE_EDIT = "Uredi";
    IDE_EDIT_COPY = "Kopiraj";
    IDE_EDIT_CUT = "Izre\u017Ei";
    IDE_EDIT_PASTE = "Prilepi";
    IDE_EDIT_UNDO = "Preklic";
    IDE_EDIT_GOTO_LINE = "Pojdi na vrstico...";

    IDE_PROG = "Program";
    IDE_PROG_PROP = "Lastnosti programa...";

    IDE_RUN = "Izvajaj";
    IDE_RUN_RUN = "Izvajaj";
    IDE_RUN_COMPILE = "Prevedi";

    IDE_HELP = "Pomo\u010D";
    IDE_HELP_JUDO_HELP = "Pomo\u010D JUDO";
    IDE_HELP_TUTORIALS = "U\u010Dbeniki";
    IDE_HELP_FUNC_REF = "Opis funkcij JUDO";
    IDE_HELP_COLOR_REF = "Opis vrednosti barv";
    IDE_HELP_ABOUT_JUDO = "Nekaj o JUDO";
    IDE_HELP_JUDO_WEBSITE = "Spletna stran JUDO";

    IDE_BUTTON_RUN = "Izvajaj";

    IDE_COMPILE_ERR = "Interna napaka pri prevajanju (prekinitev javac)";
    IDE_404_ERR = "Napaka: datoteke %s ne najdem.";
    IDE_READ_FILE_ERR = "Napaka: pri branju datoteke %s.";
    IDE_CREATE_FILE_ERR = "Napaka: ne morem tvoriti datoteke %s.";
    IDE_EXIT_JUDO_NO_SAVE_MSG = "Ali \u017Eeli\u0161 izstopiti iz JUDO ne da bi shranil ta program?";
    IDE_EXIT_NO_SAVE_TIT = "Izstop brez shranjevanja?";
    IDE_SAVE_NEW_NAME_TIT = "Shrani z novim imenom";
    IDE_SAVE_TIT = "Shrani";
    IDE_PROG_EXISTS_MSG = "Program \"%s\" \u017Ee obstaja.  Ali naj ga zamenjam?";
    IDE_PROG_EXISTS_TIT = "Program \u017Ee obstaja";
    IDE_NO_PROG_DIR_MSG = "Programski direktorij ne obstaja in ga ne morem tvoriti.";
    IDE_ERR_SAVING_TIT = "Napaka pri shranjevanju";
    IDE_PROG_DIR_NOT_WRIT = "Napaka pri shranjevanju v programski direktorij.  Ta ne dovoljuje zapisovanja.";
    IDE_OPEN_NO_SAVE_MSG = "Ali naj odprem program\n ne da bi shranil spremembe tega?";
    IDE_OPEN_NO_SAVE_TIT = "Odprem brez shranjevanja?";
    IDE_OPEN_ERR_TIT = "Napaka pri odpiranju z diskete";
    IDE_NO_PROG_MSG = "Tu trenutno ni programov, ki jih lahko odprem";
    IDE_NO_PROG_TIT = "Ni programov za odpiranje";
    IDE_OPEN_TIT = "Odpri program";
    IDE_OPEN_PROG_MSG = "Napaka pri odpiranju programa \"%s\"";
    IDE_OPEN_PROG_ERR_TIT = "Napaka pri odpiranju programa";
    IDE_NO_PROG_DEL_MSG = "Trenutno tu ni programov, ki jih lahko zbri\u0161em";
    IDE_NO_PROG_DEL_TIT = "Ni programov za brisanje";
    IDE_DEL_ERR_TIT = "Napaka pri brisanju z diskete";
    IDE_DEL_TIT = "Brisanje programa";
    IDE_NEW_WITHOUT_SAVE_MSG = "Ali naj po\u017Eenem nov program,\n ne da bi shranil spremembe tega?";
    IDE_NEW_WITHOUT_SAVE_TIT = "Nov program brez shranjevanja";
    IDE_GOTO_LINE_NUM_MSG = "Pojdi na vrstico \u0161tevilka";
    IDE_GOTO_LINE_NUM_TIT = "Pojdi na vrstico \u0161tevilka";
    IDE_LINE_NUM_GREATER_MSG = "\u0160tevilka vrstice mora biti enaka ali ve\u010Dja od 1";
    IDE_INV_LINE_NUM_TIT = "Neveljavna \u0161tevilka vrstice";
    IDE_LINE_COUNT_MSG = "program ima le  %s vrstic";
    IDE_NO_LINE_NUM_MSG = "nisi vnesel \u0161tevilke vrstice";
    IDE_LINE_NUM_INV_MSG = "\u0160tevilka vrstice %s ni veljavna.";

    IDE_VAR_VAL_DEC_ASS_TIT = "Spremenljivke, Vrednosti, deklaracije in prireditve";
    IDE_JUDO_ABOUT_MSG = "JUDO - Javino razvojno okolje za programerje za\u010Detnike\nhttp://judo.sourceforge.net\nVersion: %s\n\nJUDO, Copyright (C) 2001-2003 Thomas J. Dunn";

    CER_STRING_MISSING_QUOTE = "V nizu manjka narekovaj \"";
    CER_EMPTY_CHAR = "Prazni znaki %s Ali si nameraval uporabiti dvojni narekovaj ali dva apostrofa?";
    CER_UNCLOSED_CHAR = "Napa\u010Den znak%sAli si nameraval uporabiti dvojni narekovaj in ne dveh apostrofov?";
    CER_INVALID_STATEMENT = "Neveljaven stavek java";
    CER_CURLY_BRACE_NO_MATCH = "zaviti oklepaji { } se ne ujemajo?";
    CER_NO_VOID_MAIN = "Napaka: manjka 'void main()'";
    CER_ERR_ON_LINE = "Napaka v vrstici ";
    CER_COMP_SUCCESS = "Prevajanje je uspe\u0161no.";
    CER_UNDEF_VAR = "Nedefinirana spremenljivka ";
    CER_UNDEF_FUNC = "Nedefinirana funkcija ";
    CER_UNDEF_SYMBOL = "Nedefiniran simbol ";

    APP_PROG_COMPLETE = "Program je popoln";

    DEL_PROG_TO_DELETE = "Izberi program za brisanje";
    DEL_OK = "Brisanje";
    DEL_CANCEL = "Pozabi";
    DEL_CONFIRM_TIT = "Brisanje programa?";
    DEL_CONFIRM_MSG = "Ali naj res zbri\u0161em program '%s'?";

    OPN_PROG_TO_OPEN = "Izberi program, ki bo odprt";
    OPN_OK = "V redu";
    OPN_CANCEL = "Pozabi";

    PRP_CHOOSE_PROG_PROP = "Izberi lastnosti tega programa";
    PRP_GRAPHICS = "Grafika";
    PRP_TEXT = "Tekst";
    PRP_TEXT_AND_GRAPHICS = "Tekst in grafika";
    PRP_WIN_STYLE = "Stil Window";
    PRP_OK = "V redu";
    PRP_CANCEL = "Pozabi";

    SAV_ENTER_PROG_NAME = "Bnesi ime za svoj program";
    SAV_SAVE = "Shrani";
    SAV_CANCEL = "Pozabi";
    SAV_CHOOSE_DIFF_NAME_MSG = "Prosim izberi drugo ime programa";
    SAV_CHOOSE_DIFF_NAME_TIT = "Izberi drugo ime programa";
    SAV_TYPE_PROG_NAME_MSG = "Vnesi ime programa, ki vsebuje \u010Drke oziroma \u0161tevilke";
    SAV_TYPE_PROG_NAME_TIT = "Nisi vnesel imena programa";
    SAV_ONLY_NUM_LET_SPACE_MSG = "V imenu programa uporabljaj le \u010Drke, \u0161tevilke in presledke";
    SAV_INV_PROG_NAME = "To ni veljavno ime programa";
    SAV_NO_SAV_PROG_WITH_NUM_MSG = "Na za\u010Denjaj imena programa s \u0161tevilko";


    IDE_DELETE_PROG_MSG = "Pri\u0161lo je do napake pri brisanju programa \"%s\"";
    IDE_DELETE_PROG_ERR_TIT = "Napaka pri brisanju programa";
    IDE_OPEN_SAMPLE_CONFIRM_MSG = "Ali naj odprem primer programa\nbrez shranjevanja sprememb v tem?";
    IDE_OPEN_SAMPLE_CONFIRM_TIT = "Odprem primer programa brez shranjevanja?";
    APP_EXCEPTION_OCCURED = "Napaka pri izvajanju programa";
    IDE_EDIT_REDO = "Stori ponovno";
    IDE_EDIT_SELECT_ALL = "Izberi vse";
    IDE_FILE_OPEN_SAMPLE = "Odpri primer programa...";
  }
}