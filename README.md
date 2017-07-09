# Inane
Inane is an esoteric programming language written in Java. It produces a file 
named "b.bin" as output (memento of the 'a.out' fame). b.bin is a raw binary
file.

## How it works
When you run Inane, you pass in your source file as parameter to the program
and get a b.bin file as output.

## Syntax

## Compiling Inane
Inane can be compiled from source code. Get the Inane.java file and compile with

`javac Inane.java`

Note that Inane requires a one parameter to be passed to it which is the name of the file that contains Inane code. You can then run Inane with

`java Inane source_file`

Where *source_file* is the name of the file Inane should be executed on. At the end of the process, a file named *b.bin* is created as a result.