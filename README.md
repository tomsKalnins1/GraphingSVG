
  ## Trace function graph with Bezier curves
  This is a graphical calculator that outputs the functions it draws in SVG format.
  The main mechanism for this is the implementation of Schneider’s algorithm for automatically fitting Bezier curves
  to a set of digitized points.

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
 



