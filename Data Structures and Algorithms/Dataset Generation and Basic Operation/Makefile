# binary search program makefile
#Talifhani Nemaangani
#15 April 2023


JAVAC=/usr/bin/javac
JAVACDOC= javadoc
JAVA =/usr/bin/java
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc


$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) -sourcepath $(SRCDIR) $<

CLASSES=Edge.class Vertex.class Path.class \
         GraphException.class Graph.class DatasetGenerator.class Operationresults.class\
         


CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)




clean:
	rm $(BINDIR)/*.class 

javadoc: 
			$(JAVACDOC) -d $(DOCDIR) -sourcepath $(SRCDIR) -classpath $(BINDIR) $(SRCDIR)/*java

run: $(CLASS_FILE)
		$(JAVA) -cp bin DatasetGenerator
			$(JAVA) -cp bin Operationresults
		
			
	 
 

	
