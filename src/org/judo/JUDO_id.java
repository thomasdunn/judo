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
 * Indonesian localization
 *
 * @author Eko SW
 * @version 1.3
 */
public class JUDO_id extends JUDO_localization {
  public JUDO_id() {
    IDE_DEFAULT_PROG_NAME = "Belum Disimpan";
    IDE_SAVE_PROG = "Simpan Program";
    IDE_ERR_INIT_JAVA = "Terjadi kesalahan dalam menginisialisasi Java, silahkan baca file README.txt yang datang bersama-sama dengan JUDO";

    IDE_FILE = "Berkas";
    IDE_FILE_NEW = "Baru";
    IDE_FILE_SAVE = "Simpan";
    IDE_FILE_SAVE_NEW_NAME = "Simpan dengan nama baru...";
    IDE_FILE_OPEN = "Buka Program...";
    IDE_FILE_DELETE = "Hapus Program...";
    IDE_FILE_EXIT = "Keluar";

    IDE_EDIT = "Ubah";
    IDE_EDIT_COPY = "Salin";
    IDE_EDIT_CUT = "Potong";
    IDE_EDIT_PASTE = "Tempel";
    IDE_EDIT_UNDO = "Batalkan perubahan";
    IDE_EDIT_GOTO_LINE = "Pergi ke Baris...";

    IDE_PROG = "Program";
    IDE_PROG_PROP = "Properti Program ...";

    IDE_RUN = "Jalankan";
    IDE_RUN_RUN = "Jalankan";
    IDE_RUN_COMPILE = "Kompilasi";

    IDE_HELP = "Bantuan";
    IDE_HELP_JUDO_HELP = "Bantuan JUDO";
    IDE_HELP_TUTORIALS = "Pelajaran-Pelajaran";
    IDE_HELP_FUNC_REF = "Referensi Fungsi di dalam JUDO";
    IDE_HELP_COLOR_REF = "Referensi Nilai Warna";
    IDE_HELP_ABOUT_JUDO = "Tentang JUDO";
    IDE_HELP_JUDO_WEBSITE = "Situs JUDO di Internet";

    IDE_BUTTON_RUN = "Jalankan";

    IDE_COMPILE_ERR = "Kesalahan Kompilasi Internal (program javac dihentikan)";
    IDE_404_ERR = "Kesalahan: Berkas %s tidak ditemukan";
    IDE_READ_FILE_ERR = "Kesalahan: Membaca berkas %s.";
    IDE_CREATE_FILE_ERR = "Kesalahan: Tidak bisa membuat berkas %s.";
    IDE_EXIT_JUDO_NO_SAVE_MSG = "Apakah Anda ingin keluar dari JUDO tanpa Menyimpan Program ini?";
    IDE_EXIT_NO_SAVE_TIT = "Keluar tanpa Menyimpan?";
    IDE_SAVE_NEW_NAME_TIT = "Simpan dengan Nama Baru";
    IDE_SAVE_TIT = "Simpan";
    IDE_PROG_EXISTS_MSG = "Program \"%s\" sudah ada. Ditimpa?";
    IDE_PROG_EXISTS_TIT = "Program sudah ada";
    IDE_NO_PROG_DIR_MSG = "Direktori Program tidak ada dan proses pembuatannya tidak bisa dilakukan.";
    IDE_ERR_SAVING_TIT = "Kesalahan dalam menyimpan";
    IDE_PROG_DIR_NOT_WRIT = "Kesalahan dalam menyimpan ke Direktori Program. Tidak bisa ditulis.";
    IDE_OPEN_NO_SAVE_MSG = "Apakah Anda ingin Membuka sebuah Program\nTanpa menyimpan perubahannya pada program yang ini?";
    IDE_OPEN_NO_SAVE_TIT = "Buka tanpa Menyimpan?";
    IDE_OPEN_ERR_TIT = "Terjadi kesalahan saat akan membuka dari Disket";
    IDE_NO_PROG_MSG = "Saat ini tidak ada Program yang bisa Dibuka.";
    IDE_NO_PROG_TIT = "Tidak ada Program yang bisa Dibuka";
    IDE_OPEN_TIT = "Buka Program";
    IDE_OPEN_PROG_MSG = "Terdapat kesalahan dalam membuka Program \"%s\"";
    IDE_OPEN_PROG_ERR_TIT = "Terjadi kesalahan dalam membuka Program";
    IDE_NO_PROG_DEL_MSG = "Saat ini tidak ada Program yang bisa Dihapus";
    IDE_NO_PROG_DEL_TIT = "Tidak ada Program yang bisa Dihapus";
    IDE_DEL_ERR_TIT = "Terjadi kesalahan saat menghapus dari Disket";
    IDE_DEL_TIT = "Hapus Program";
    IDE_NEW_WITHOUT_SAVE_MSG = "Apakah Anda ingin memulai sebuah Program Baru\n tanpa menyimpan perubahan yang Anda lakukan\npada program yang satu ini?";
    IDE_NEW_WITHOUT_SAVE_TIT = "Program Baru Tanpa Menyimpan?";
    IDE_GOTO_LINE_NUM_MSG = "Pergi Ke Nomor Baris";
    IDE_GOTO_LINE_NUM_TIT = "Pergi Ke Nomor Baris";
    IDE_LINE_NUM_GREATER_MSG = "Nomor baris harus lebih besar atau sama dengan 1";
    IDE_INV_LINE_NUM_TIT = "Nomor baris salah";
    IDE_LINE_COUNT_MSG = "Hanya terdapat %s baris di dalam Program";
    IDE_NO_LINE_NUM_MSG = "Anda tidak memasukkan sebuah nomor baris";
    IDE_LINE_NUM_INV_MSG = "Nomor baris %s bukanlah sebuah nomor baris yang benar";

    IDE_VAR_VAL_DEC_ASS_TIT = "Variabel, Nilai , Deklarasi dan Pemberian Nilai";
    IDE_JUDO_ABOUT_MSG = "JUDO - Sebuah Java IDE untuk Para Programmer Pemula\nhttp://judo.sourceforge.net\nVersi: %s\n\nJUDO, Hak cipta (C) 2001-2003 Thomas J. Dunn";

    CER_STRING_MISSING_QUOTE = "String kehilangan sebuah tanda";
    CER_EMPTY_CHAR = "Kesalahan karakter%sApakah yang Anda maksudkan adalah menggunakan karakter petik ganda (\") dan bukan dua karakter petik tunggal (')?";
    CER_UNCLOSED_CHAR = "Kesalahan karakter%sApakah yang Anda maksudkan adalah menggunakan karakter petik ganda (\") dan bukan dua karakter petik tunggal (')?";
    CER_INVALID_STATEMENT = "Bukan sebuah pernyataan Java yang benar";
    CER_CURLY_BRACE_NO_MATCH = "Kurang kurawal { } tidak seimbang jumlahnya?";
    CER_NO_VOID_MAIN = "Kesalahan: tidak ada fungsi 'void main()'";
    CER_ERR_ON_LINE = "Kesalahan pada baris ";
    CER_COMP_SUCCESS = "Kompilasi berhasil.";
    CER_UNDEF_VAR = "Variabel tidak didefinsikan ";
    CER_UNDEF_FUNC = "Fungsi tidak didefinisikan ";
    CER_UNDEF_SYMBOL = "Simbol tidak didefinisikan ";

    APP_PROG_COMPLETE = "Program Selesai";

    DEL_PROG_TO_DELETE = "Pilihlah sebuah Program untuk Dihapus";
    DEL_OK = "Hapus";
    DEL_CANCEL = "Batalkan";
    DEL_CONFIRM_TIT = "Hapus Program?";
    DEL_CONFIRM_MSG = "Apakah Anda yakin ingin menghapus program '%s'?";

    OPN_PROG_TO_OPEN = "Pilihlah sebuah Program untuk Dibuka";
    OPN_OK = "OK";
    OPN_CANCEL = "Batalkan";

    PRP_CHOOSE_PROG_PROP = "Pilihlah Properti untuk Program ini";
    PRP_GRAPHICS = "Grafik";
    PRP_TEXT = "Teks";
    PRP_TEXT_AND_GRAPHICS = "Teks dan Grafik";
    PRP_WIN_STYLE = "Gaya Jendela";
    PRP_OK = "OK";
    PRP_CANCEL = "Batalkan";

    SAV_ENTER_PROG_NAME = "Masukkan sebuah Nama Untuk Program Anda";
    SAV_SAVE = "Simpan";
    SAV_CANCEL = "Batalkan";
    SAV_CHOOSE_DIFF_NAME_MSG = "Silahkan pilih sebuah Nama Program yang berbeda";
    SAV_CHOOSE_DIFF_NAME_TIT = "Pilihlah sebuah Nama Program yang lain";
    SAV_TYPE_PROG_NAME_MSG = "Ketikkan Nama Program yang memiliki huruf dan/atau angka";
    SAV_TYPE_PROG_NAME_TIT = "Nama Program belum dimasukkan";
    SAV_ONLY_NUM_LET_SPACE_MSG = "Hanya boleh mempergunakan huruf, angka dan spasi di dalam Nama Program";
    SAV_INV_PROG_NAME = "Bukan Nama Program yang diperbolehkan";
    SAV_NO_SAV_PROG_WITH_NUM_MSG = "Jangan memulai nama program dengan angka";

    IDE_DELETE_PROG_MSG = "Terjadi kesalahan saat menghapus Program \"%s\"";
    IDE_DELETE_PROG_ERR_TIT = "Terjadi kesalahan saat menghapus Program";
    IDE_OPEN_SAMPLE_CONFIRM_MSG = "Apakah Anda ingin membuka Program Contoh\nTanpa menyimpan perubahan yang Anda lakukan pada program ini?";
    IDE_OPEN_SAMPLE_CONFIRM_TIT = "Buka Program Contoh tanpa Menyimpan Perubahan";
    APP_EXCEPTION_OCCURED = "Terjadi kesalahan selama program berjalan";
    IDE_EDIT_REDO = "Ulangi perubahan";
    IDE_EDIT_SELECT_ALL = "Pilih Semua";
    IDE_FILE_OPEN_SAMPLE = "Buka Program Contoh...";
  }
}