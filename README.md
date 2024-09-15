# Graph Algorithms in Java

This project implements Depth First Search (DFS), Breadth First Search (BFS), and various graph-related algorithms using custom data structures like hash tables, linked lists, and stacks. The graph is represented as an adjacency list, and the project includes methods for graph traversal, pathfinding, and checking graph properties.

## Project Structure

The project consists of multiple Java classes for graph representation, traversal algorithms (DFS, BFS), connected components detection, and utility data structures like a hash table and linked lists.

## How to Run

1. Compile all the Java files inside the `dfs_app` package.
2. Use the `DFS_App` class to run the application.
3. You will be prompted with a menu to perform various graph operations, such as reading a graph from a file, finding paths between vertices, and checking adjacency.

## Graph Input File Format

The input graph should be provided as a text file where each line represents an edge in the format:

VertexA -> VertexB: Weight, VertexC: Weight, ...


## Example Usage
javac dfs_app/*.java
java dfs_app.DFS_App


You can then interactively perform operations such as:

Reading a graph from a file
Checking if a path exists between two vertices
Finding the BFS/DFS traversal from one vertex to another
## Features
Depth First Search (DFS) and Breadth First Search (BFS)
Pathfinding between vertices
Detecting connected components
Adjacency checking
Custom data structures for graph representation
