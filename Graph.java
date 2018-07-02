// Sam Ervolino
// Constructs a Petersen graph and performs an iterative Depth First Search on it using a stack.

import java.util.*;

public class Graph {
	private HashSet<Vertex> visited;
	private Stack<Vertex> s;

// Initialize
	Graph() {
		visited = new HashSet<>();
		s = new Stack<>();
	}

// Push the start point, so stack isn't empty. While it isn't empty, we get
// the top of the stacks neighbors, check if the top of the stack has already
// been visited (if not print and pop, else pop it and move on to next
// iteration), and then if it's neighbors haven't been visited we add them to
// the top of the stack, effictively simulating recursion.
	public void iterativeDFS(Vertex cur) {
		s.push(cur);

		while(!s.empty()) {
			cur = s.peek();
			ArrayList<Vertex> curNeighbors = cur.getNeighbors();

			if(!visited.contains(cur)) {
				visited.add(cur);
				System.out.println(s.pop().value());
			}
			else {
				s.pop();
				continue;
			}

			if(curNeighbors != null) {
				for(Vertex v : curNeighbors) {
					if(!visited.contains(v))
						s.push(v);
				}
			}
		}
	}

	public static void main(String [] args) {
		Graph graph = new Graph();

// Constructs Petersen graph.
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Vertex i = new Vertex("i");
		Vertex j = new Vertex("j");


		ArrayList<Vertex> neighbors = new ArrayList<>();
		neighbors.add(b);
		neighbors.add(f);
		neighbors.add(e);
		a.setNeighbors(neighbors);
		
		neighbors = new ArrayList<>();
		neighbors.add(a);
		neighbors.add(g);
		neighbors.add(c);
		b.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(b);
		neighbors.add(h);
		neighbors.add(d);
		c.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(c);
		neighbors.add(i);
		neighbors.add(e);
		d.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(d);
		neighbors.add(j);
		neighbors.add(a);
		e.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(a);
		neighbors.add(h);
		neighbors.add(i);
		f.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(b);
		neighbors.add(j);
		neighbors.add(i);
		g.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(c);
		neighbors.add(f);
		neighbors.add(j);
		h.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(d);
		neighbors.add(g);
		neighbors.add(f);
		i.setNeighbors(neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(e);
		neighbors.add(g);
		neighbors.add(h);
		j.setNeighbors(neighbors);

		graph.iterativeDFS(a);
	}
}

class Vertex {
// Each Neighbor is an edge.
	private ArrayList<Vertex> neighbors;
	private String value;

	Vertex(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

	public void setNeighbors(ArrayList<Vertex> neighbors) {
		this.neighbors = new ArrayList<>(neighbors.size());
		for(int i = 0; i < neighbors.size(); i++)
			this.neighbors.add(i, neighbors.get(i));
	}

	public ArrayList<Vertex> getNeighbors() {
		return this.neighbors;
	}

}