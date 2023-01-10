JAVA_SRC = $(shell find src -name '*.java')
EXT_SRC = $(shell find external/src -name '*.java')
JAVA_FLAGS = -source 11 -target 11

.PHONY:

all: arja ext

arja: $(JAVA_SRC)
	mkdir -p bin
	javac -cp 'lib/*' -d bin $(JAVA_FLAGS) $(JAVA_SRC)

ext: $(EXT_SRC)
	mkdir -p external/bin
	javac -cp 'external/lib/*' -d external/bin $(JAVA_FLAGS) $(EXT_SRC)

clean:
	rm -rf bin
	rm -rf external/bin

