[![Build Status](https://travis-ci.org/NicoleCarpenter/game-of-life.svg?branch=continuous-integration)](https://travis-ci.org/NicoleCarpenter/game-of-life)

# Conway's Game of Life

Conway's Game of Life is a console application built with Clojure. It is a zero player game where an initial game state evolves based on the position of the cells on the board. 

The game is played on a two dimensional grid where alive (populated) cells are filled and dead (non-populated) cells are blank. Each cell is surrounded by up to eight neigboring cells. The state of the board from generation to generation is determined by four [rules](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life):

1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by over-population.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction. 

New generations continue to evolve indefinitely unless all cells die or are grouped into smaller clusters not close enough to reproduce. 

## Requirements

* [Clojure](https://clojure.org/)
* [Java](https://java.com/en/download/)
* [Leiningen](http://leiningen.org/)

## Running the Application

In your desired location in terminal, clone the repo

```
git clone git@github.com:NicoleCarpenter/game-of-life.git
```

Then `cd` into the application's root directory

```
cd game-of-life
```

From there, to run the application, type

```
lein run
```

## Running the Tests

From the root directory, type

```
lein spec
```