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
 * Spanish localization
 *
 * @author Gabriel Reyes
 * @version 1.3
 */
public class JUDO_es extends JUDO_localization {
  public JUDO_es() {
    IDE_DEFAULT_PROG_NAME = "Sin titulo";
    IDE_SAVE_PROG = "Salvar programa";
    IDE_ERR_INIT_JAVA = "Error de Inicializacion de Java, Por favor lea README.txt que viene con JUDO";

    IDE_FILE = "Archivo";
    IDE_FILE_NEW = "Nuevo";
    IDE_FILE_SAVE = "Salvar";
    IDE_FILE_SAVE_NEW_NAME = "Salvar como...";
    IDE_FILE_SAVE_FLOPPY = "Salvar a  disco 3 1/2";
    IDE_FILE_SAVE_FLOPPY_NEW_NAME = "Salvar a  disco 3 1/2 con nuevo nombre...";
    IDE_FILE_OPEN = "Abrir Programa...";
    IDE_FILE_OPEN_FLOPPY = "Abrir programa en disco de 3 1/2...";
    IDE_FILE_DELETE = "Borrar programa...";
    IDE_FILE_DELETE_FLOPPY = "Borrar programa en disco de 3 1/2...";
    IDE_FILE_EXIT = "Salir";

    IDE_EDIT = "Editar";
    IDE_EDIT_COPY = "Copiar";
    IDE_EDIT_CUT = "Cortar";
    IDE_EDIT_PASTE = "Pegar";
    IDE_EDIT_UNDO = "Deshacer";
    IDE_EDIT_GOTO_LINE = "Ir a la linea...";

    IDE_PROG = "Programa";
    IDE_PROG_PROP = "Propiedades del programa...";

    IDE_RUN = "Ejecutar";
    IDE_RUN_RUN = "Ejecutar";
    IDE_RUN_COMPILE = "Compilar";

    IDE_HELP = "Ayuda";
    IDE_HELP_JUDO_HELP = "Ayuda de JUDO";
    IDE_HELP_TUTORIALS = "Tutoriales";
    IDE_HELP_FUNC_REF = "Referencia de funciones de JUDO";
    IDE_HELP_COLOR_REF = "Referencia de valores de colores";
    IDE_HELP_ABOUT_JUDO = "Acerca de JUDO";
    IDE_HELP_JUDO_WEBSITE = " pagina web de JUDO";

    IDE_BUTTON_RUN = "Ejecutar";

    IDE_COMPILE_ERR = "Error Interno de compilacion (javac interrumpido)";
    IDE_404_ERR = "Error: archivo %s no fue encontrado.";
    IDE_READ_FILE_ERR = "Error: Leyendo archivo %s.";
    IDE_CREATE_FILE_ERR = "Error: No se pudo crear el archivo %s.";
    IDE_EXIT_JUDO_NO_SAVE_MSG = "Quiere salir de JUDO sin salvar este programa?";
    IDE_EXIT_NO_SAVE_TIT = "Salir sin salvar?";
    IDE_SAVE_NEW_NAME_TIT = "Salvalar con nombre nuevo";
    IDE_SAVE_TIT = "Salvar";
    IDE_PROG_EXISTS_MSG = " El Programa \"%s\" ya existe.  desea reemplazalo?";
    IDE_PROG_EXISTS_TIT = "El programa ya existe";
    IDE_NO_FLOPPY_MSG = "Parece no haber disco en la unidad de 3 1/2.  si es que lo hay intente expulsandolo e introduzcalo nuevamente, salve una vez mas.";
    IDE_FLOPPY_ERR_TIT = "Error al salvar al disco de 3 1/2";
    IDE_FLOPPY_WRITE_PROT_MSG = "Asegurese de que el disco de 3 1/2 no esta esta protegido contra escritura.\nvea en la parte trasera del disco. en la esquina superior derecha,\nahi hay una pequeña etiqueta negra deslizable.  Precione hacia abajo\nsi es que no esta ahi ya y trate de salvar de nuevo.";
    IDE_NO_PROG_DIR_MSG = "El directorio de programa no existe y su cracion fallo.";
    IDE_ERR_SAVING_TIT = "Error al salvar";
    IDE_PROG_DIR_NOT_WRIT = "Error al salvar el directorio de programa. no es escribible.";
    IDE_OPEN_NO_SAVE_MSG = "Quiere abrir un Programa sin\n Salvar los cambios de este programa?";
    IDE_OPEN_NO_SAVE_TIT = "Abrir sin salvar?";
    IDE_OPEN_NO_FLOPPY_MSG = "Parece no haber disco en la unidad de 3 1/2.  si es que lo hay intente expulsandolo e introduzcalo nuevamente y abra una vez mas.";
    IDE_OPEN_ERR_TIT = "Error al abrir desde la unidad de 3 1/2";
    IDE_NO_PROG_MSG = "Por el momento no hay programas que abrir";
    IDE_NO_PROG_TIT = "No hay programas que abrir";
    IDE_OPEN_TIT = "abrir programa";
    IDE_OPEN_PROG_MSG = "Hubo un error al abrir el programa \"%s\"";
    IDE_OPEN_PROG_ERR_TIT = "Error al abrir el programa";
    IDE_NO_PROG_DEL_MSG = "Por el momento no hay programas que borrar";
    IDE_NO_PROG_DEL_TIT = "No hay programas que borrar";
    IDE_DEL_NO_FLOPPY_MSG = "Parece no haber disco en la unidad de 3 1/2.  si es que lo hay intente expulsandolo e introduzcalo nuevamente y borre una vez mas.";
    IDE_DEL_ERR_TIT = "Error al borrar en el disco de 3 1/2";
    IDE_DEL_TIT = "Borrar Programa";
    IDE_NEW_WITHOUT_SAVE_MSG = "Quiere empezar un nuevo programa sin\nSalvar los cambios a este programa?";
    IDE_NEW_WITHOUT_SAVE_TIT = "Nuevo programa sin salvar?";
    IDE_GOTO_LINE_NUM_MSG = "Ir a la linea numero";
    IDE_GOTO_LINE_NUM_TIT = "Ir a la linea numero";
    IDE_LINE_NUM_GREATER_MSG = "El numero de la linea deve de ser mas grande o igual a 1";
    IDE_INV_LINE_NUM_TIT = "Numero de linea invalido";
    IDE_LINE_COUNT_MSG = "El programa Solo tiene %s Lineas ";
    IDE_NO_LINE_NUM_MSG = "No introdujo el numero de linea";
    IDE_LINE_NUM_INV_MSG = "El numero de linea %s No es un numero valido.";

    IDE_VAR_VAL_DEC_ASS_TIT = "Variables, Valores, Declaraciones, y tareas";
    IDE_JUDO_ABOUT_MSG = "JUDO - Un IDE Java  para programadores novatos\nhttp://judo.sourceforge.net\nVersion: %s\n\nJUDO, Copyright (C) 2001-2003 Thomas J. Dunn";

    CER_STRING_MISSING_QUOTE = "String faltante a \"";
    CER_EMPTY_CHAR = "Caracter vacio%sQuiso usted usar comillas (\") en vez de doble apostrofe('') ?";
    CER_UNCLOSED_CHAR = "Error en el caracter%sQuiso usted usar comillas (\") en vez de doble apostrofe('') ?";
    CER_INVALID_STATEMENT = "No es una declaracion java valida";
    CER_CURLY_BRACE_NO_MATCH = "corchetes { } no corresponden?";
    CER_NO_VOID_MAIN = "Error: falta  'void main()'";
    CER_ERR_ON_LINE = "Error en la linea ";
    CER_COMP_SUCCESS = "Compilacion exitosa.";
    CER_UNDEF_VAR = "Variable indefinida";
    CER_UNDEF_FUNC = "Funcion indefinida ";
    CER_UNDEF_SYMBOL = "Simbolo indefinido ";

    APP_PROG_COMPLETE = "Programa completo";

    DEL_PROG_TO_DELETE = "Escoja un programa para borrar";
    DEL_OK = "Borrar";
    DEL_CANCEL = "Cancelar";
    DEL_CONFIRM_TIT = "Borrar programa?";
    DEL_CONFIRM_MSG = "Esta usted seguro que desea borar el programa '%s'?";

    OPN_PROG_TO_OPEN = "Seleccione un programa para abrir";
    OPN_OK = "OK";
    OPN_CANCEL = "Cancelar";

    PRP_CHOOSE_PROG_PROP = "Seleccione las propiedades para este programa";
    PRP_GRAPHICS = "Graficos";
    PRP_TEXT = "Texto";
    PRP_TEXT_AND_GRAPHICS = "Text & Graphics";
    PRP_WIN_STYLE = "Estilo de ventana";
    PRP_OK = "OK";
    PRP_CANCEL = "Cancelar";

    SAV_ENTER_PROG_NAME = "Escriba un nuevo nombre para su programa";
    SAV_SAVE = "Salvar";
    SAV_CANCEL = "Cancelar";
    SAV_CHOOSE_DIFF_NAME_MSG = "Por favor Seleccione un nombre difrente para su programa";
    SAV_CHOOSE_DIFF_NAME_TIT = "Seleccione un nombre difrente para su programa";
    SAV_TYPE_PROG_NAME_MSG = "Escriba un nombre para su programa que contenga letras y/o numeros";
    SAV_TYPE_PROG_NAME_TIT = "No introdujo un nombre para el programa";
    SAV_ONLY_NUM_LET_SPACE_MSG = "Solo use letras, numeros, y espacios en un nombre de programa";
    SAV_INV_PROG_NAME = "No es un nombre de programa valido";
    SAV_NO_SAV_PROG_WITH_NUM_MSG = "No comience el nombre de programa con un numero";


    IDE_DELETE_PROG_MSG = "Hubo un error al borrar el programa \"%s\"";
    IDE_DELETE_PROG_ERR_TIT = "Error al borrar el programa";
    IDE_OPEN_SAMPLE_CONFIRM_MSG = "Quiere abrir un programa de muestra sin\nSalvr los cambios a este?";
    IDE_OPEN_SAMPLE_CONFIRM_TIT = "Abrir un programa de muestra sin salvar?";
    APP_EXCEPTION_OCCURED = "Ha ocurrido un error de compilacion";
    IDE_EDIT_REDO = "Rehacer";
    IDE_EDIT_SELECT_ALL = "Seleccionar todo";
    IDE_FILE_OPEN_SAMPLE = "Abrir programa de muestra...";
  }
}