package com.dz.io.datastructures;

import java.util.*;

public class GraphNode<T> {
    private T value;
    private Set<GraphNode<T>> neighbours;

    public GraphNode(T value) {
        this.value = value;
        neighbours = new HashSet<>();
    }

    public static <T> GraphNode<T> of(T value){
        return new GraphNode<>(value);
    }

    public void connect(GraphNode<T> node){
        if(this == node) throw new IllegalArgumentException("Can not connect to itself");
        this.neighbours.add(node);
        node.neighbours.add(this);
    }

    public static <T> Optional<GraphNode<T>> BFS(T value, GraphNode<T> start){

        Queue<GraphNode<T>> queue = new ArrayDeque<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        queue.add(start);

        GraphNode<T> current;

        while(!queue.isEmpty()){
            current = queue.poll();
            System.out.println("Node Visited with value : " + current.value);
            if(current.value.equals(value)){
                return Optional.of(current);
            }else{
                visited.add(current);
                queue.addAll(current.neighbours);
                queue.removeAll(visited);
            }
        }

        return Optional.empty();
    }

    public static <T> void DFS(T value, GraphNode<T> start){

        Deque<GraphNode<T>> stack = new ArrayDeque<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        stack.add(start);
        GraphNode<T> current;

        while(!stack.isEmpty()){
            current = stack.pop();
            visited.add(current);
            current.neighbours.stream().filter(t -> !visited.contains(t)).forEach(stack::push);
        }
    }

    public static void main(String[] args) {
        GraphNode<Integer> start = new GraphNode<>(10);
        GraphNode<Integer> firstNeighbor = new GraphNode<>(2);
        start.connect(firstNeighbor);

        GraphNode<Integer> firstNeighborNeighbor = new GraphNode<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        GraphNode<Integer> secondNeighbor = new GraphNode<>(4);
        start.connect(secondNeighbor);
    }
}
