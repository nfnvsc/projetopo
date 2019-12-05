# Makefile, versao 1

# A phony target is one that is not really the name of a file
# https://www.gnu.org/software/make/manual/html_node/Phony-Targets.html
.PHONY: all execute clean run

all: compile

compile: 
	javac -cp po-uilib.jar:. `find m19 -name *.java`

execute: 
	java -cp po-uilib.jar:. m19.app.App

clean:
	@echo Cleaning...
	find . -name "*.class" -delete

jar:
	jar -cf projetopo.jar `find m19 -name *.java`

