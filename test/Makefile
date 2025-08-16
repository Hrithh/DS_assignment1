# Java RMI Build System
.PHONY: clean build

# Clean all compiled classes
clean:
	@echo "Cleaning project..."
	@rm -f *.class
	@echo "Clean complete. All .class files removed."

# Compile all Java sources
build:
	@echo "Compiling Java files..."
	@javac *.java
	@echo "Compilation complete. Ready to run."

# Combined clean + build (default)
all: clean build