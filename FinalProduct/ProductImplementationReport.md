# Team Implementation Report
*This section should describe the technical details of your implementation.  The subheadings and italicised text below may be used to guide you.*

## Technical Description
*This section should describe the software implementation in prose form.  Focus on how the code was designed and built.* 
The generator first creates 2 points at the sides of the square, followed by a random route from start to end.
The rest of the maze was created randomly.

The solver then uses Depth First search or breadth first search algorithms to find all possible paths & then compare them by the number of moves made.
THen it will choos ethe one with the least amount of moves
