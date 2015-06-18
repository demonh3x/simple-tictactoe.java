# simple-tictactoe.java

## Description

This is an implementation of the tic-tac-toe game (or Noughts and crosses, Xs and Os) in Java.

This is an attempt to produce simple code ([KISS](http://c2.com/cgi/wiki?KeepItSimple), [4 Rules of simple design](http://c2.com/cgi/wiki?XpSimplicityRules) (+ [Book by Corey Haines](https://leanpub.com/4rulesofsimpledesign)), [Simplest thing that could work](https://en.wikiquote.org/wiki/Ward_Cunningham#The_Simplest_Thing_that_Could_Possibly_Work), [Simple made easy](http://www.infoq.com/presentations/Simple-Made-Easy), etc...)

## Features

##### Board sizes
* 3x3

##### Dumb computer player
* Chooses first available space

##### UI
* CLI

## Dependencies

##### Execution
* [JRE 7](http://www.oracle.com/technetwork/java/javase/downloads/jre7-downloads-1880261.html)

##### Testing
* [AssertJ](http://joel-costigliola.github.io/assertj/) 2.1.0

## Running

The script `bin/tictactoe_cli` will run the game. 

It receives two arguments: the types of the players (human / computer).

For example, to run a human vs computer game would be:

`bin/tictactoe_cli human computer`
