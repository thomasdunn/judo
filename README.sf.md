Java IDE for Children and Beginning Programmers
-----------------------------------------------

### JUDO website

Downloads, help, news, share programs:  

**[http://judo.sourceforge.net/](http://judo.sourceforge.net/)**

### Releases

**v1.3.2**

* Italian translation
* Bug fix: Run a program results in "Error: Cannot create file C:\\Program Files (x86)\\JUDO\MyJUDOPrograms\\JUDOApp.java" and Run button becomes disabled

**v.1.3.1**

Many new features, including letting you write programs that read mouse movements, mouse clicks, and keyboard presses. It is also now translated into five languages. Here is what the latest function reference looks like.

* Multiple language support: English, Spanish, French, Slovenian, Indonesian
* Moved to GitHub - https://github.com/thomasdunn/judo
* Added new sample program (a game: "Look Out!")
* Removed file operations for storing to floppy disk.

### Binary downloads:

[Windows](http://judo.sourceforge.net/downloads.php)  
[MacOS X](http://judo.sourceforge.net/downloads.php)  
[Linux](http://judo.sourceforge.net/downloads.php)  

### Help

After running JUDO, go to the Help menu and select Tutorials. There are several topics to read through and learn to get you started writing your own programs.

[General help with installing or running JUDO](http://sourceforge.net/p/judo/discussion/413339/)  
[Help writing programs](http://sourceforge.net/p/judo/discussion/413338/)  

### Languages

JUDO is available in English, Spanish, French, Indonesian, and Slovenian.  If using the Windows installer, language can be selected during installation.  For other operating systems: after unpacking, the language can be selected in `judo.properties`.

### Overview

JUDO is a program written to help people learn to program,
pure and simple.  It is free software and you are encouraged
to give it to others, look at its source code, or improve it.

JUDO was developed on the Windows platform, but some care was
taken to make it cross-platform.  However, I have not tested
it, or even installed it all platforms.

I created JUDO while I was teaching a programming class to
12-14 year olds in Boston, MA.  The program I did this with
is called Citizen Schools (http://www.citizenschools.org/)
and I recommend that you check it out.  You may find similar
opportunities in your community!

Your installation of JUDO may include a copy of the Java
Development Kit from Sun Microsystems, Inc.  It is governed
by Sun Microsystems, Inc. Binary Code License Agreement.

### What a JUDO program looks like:

void main()
{
	setBackgroundColor(black);

	printLine("What is your name?");
	String name = readString();

	printLine("Hi " + name + ". Type in a color.");
	Color c = readColor();

	setColor(c);
	fillCircle(100, 30, 100);

	printLine("Now go paint a face!");

	while(true) {
		if (getMouseEvent()) {
			setColor( randomColor() );

			if (getMouseButton(1)) {
				fillCircle(getMouseX()-5, getMouseY()-5, 10);
			}
		}
	}
}


![JUDO program code and running program](http://judo.sourceforge.net/images/screenshots/screenshot_smiley.jpg "JUDO program code and running program")

**[JUDO function reference](http://judo.sourceforge.net/downloads/JUDOAppAPI.html)**

### Contributing to JUDO

Developers, if you want to help the children of the world learn to program, consider contributing to JUDO.  Here are some areas that could use attention:

* Update to latest Java version
* Testing and bug fixes on Macos X and Linux
* Installers or executable JARs for MacOS X and Linux
* Double-buffering with methods such as enableBuffering() and drawBuffer()
* Right-side, hideable JUDO Function reference UI, perhaps accordion style (in groups of functions: Graphics, I/O, Mouse, Keyboard, etc)
* Help on documentation

The majority of JUDO development happened back in 2001.  I've come a long way since then :)  JUDO could use some major refactoring or even a rewrite...

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/33c654eeeea16b351072e05ecb7872dd "githalytics.com")](http://githalytics.com/thomasdunn/judo)