
  ## Trace function graph with Bezier curves
  This is a graphical calculator that outputs the functions it draws in SVG format. All Adobe programs that are used in publishing, namely,
  Adobe InDesign and Adobe Illustrator which work with vector graphics accept SVG format, so the output of the program can imported there
  directly.
  The main mechanism for this is the implementation of Schneider’s algorithm for automatically fitting Bezier curves
  to a set of digitized points. The prgram takes in text input, uses a recursive descent parser to create a syntax tree and based on that draws the output.
  Each function and operation has class that extends a general Function class and each node of the tree belongs to one of Function subclasses. At each mouse
  scroll to zoom in or out the syntax tree is refreshed accordingly.

  I totally have to rewrite most of the code and rename all the files because this is a total mess.

  ## Purpose
  When working with math books usually me or my colleagues had to draw them by hand, so as one of my beginner projects I wanted to automate
  the process of drawing these graphs, by creating a set of points for the function graphs and using the algorithm mentioned above to trace those points to
  be scalable vector graphics a. k. a (SVG) which the right format for the graphics when creating textbooks.

  ## Dependencies
  This uses no external libraries. 
   
  ## What this does
  This program draws parametric equations, explicit functions and polar coordinate equations, has a basic interface that accepts
  string input for functions and directory to save the file to. It outputs one file per per function even if there are many functions
  being drawn and names the file by the input that created the function.

Due to operating systems not accepting all symbols in file names, like '*', '/' etc. they are denoted by the abbreviation their name, like
"mult" for '*', "div" for '/'.
 



