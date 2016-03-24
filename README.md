JUDO2dev
====

judo2dev is a development branch of the JUDO project. The main goal of this branch is to bring JUDO to Java 8, and thus back up to speed on modern Java. Additionally, I plan on making JUDO a portable program (think of a folder on a pendrive that can be used on any system with the JDK installed) to make it easier to teach classes to 14-18 year olds, and for the students to bring their work home.

After getting all of that working, additional features can be added. See the "future goals" list below.

Current goals:
* Make JUDOConfig read user config from distribution folder
	* Right now its set to read from ~/.judo.properties . We need to
		change this to the distribution folder.
* Read .judo files from MyJUDOPrograms
	* I think that the reading, and later writing, code can be
		be refactored out of JUDOIDE.java and made into a separate class.
		Something like JUDOProgramLoader would be the idea - a manager of
		loading, getting/setting headermap properties, and writing JUDO code.
* Write .judo files to MyJUDOPrograms
* Compile JUDO files

Future goals:
* Update to latest Java version [IN PROGRESS]
* Installers or executable JARs for MacOS X and Linux [IN PROGRESS]
* Testing and bug fixes on Macos X and Linux
* Double-buffering with methods such as enableBuffering() and drawBuffer()
* Right-side, hideable JUDO Function reference UI, perhaps accordion style (in groups of functions: Graphics, I/O, Mouse, Keyboard, etc)
* Help on documentation
* Get unit testing working with Gradle
* Get 100% code coverage
* Some kind of integration testing, if Travis CI supports it.