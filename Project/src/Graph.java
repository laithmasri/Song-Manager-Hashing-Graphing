/**
 * This is the Graph class
 * 
 * @author laith21
 * @version Nov 23rd
 */
public class Graph {
    private DLList<Integer>[] adjList;
    private DLList<Integer> freeList;
    private int numOfNodes;
    private int size;

    // for printing
    private int[] parentArray;
    private int[] wgtArray;
    private int numComponents;

    // for matrix
    private int[][] matrix;
    private int indexOfLargest;

    /**
     * This is the constructor of the class.
     * 
     * @param listSize
     *            Represents the size of the list.
     */
    @SuppressWarnings("unchecked")
    public Graph(int listSize) {
        adjList = new DLList[listSize];
        freeList = new DLList<Integer>();
        size = listSize;
        numOfNodes = 0;
        for (int x = 0; x < listSize; x++) {
            freeList.add(x);
        }
    }


    /**
     * This method adds a new node to the adjacency list.
     * 
     * @return The index where the new node has been added.
     */
    public int addNode() {
        if (numOfNodes == size) {
            adjList = expandList();
        }
        int addedIndex = freeList.removeIndex(0);
        adjList[addedIndex] = new DLList<Integer>();
        adjList[addedIndex].add(addedIndex);
        numOfNodes++;
        return addedIndex;
    }


    /**
     * This method is used to add an edge between two existing nodes.
     * 
     * @param firstNode
     *            Represents the index of the first node.
     * @param secondNode
     *            Represents the index of the second node.
     */
    public void addEdge(int firstNode, int secondNode) {
        adjList[firstNode].add(secondNode);
        adjList[secondNode].add(firstNode);
    }


    /**
     * This method is used to remove a node.
     * 
     * @param index
     *            Represents the node we want to remove.
     */
    public void removeNode(int index) {
        if (numOfNodes == 0) {
            return;
        }
        DLList<Integer> allEdges = adjList[index];
        int numOfEdges = allEdges.size() - 1;
        while (numOfEdges >= 1) {
            removeEdge(index, adjList[index].get(1));
            numOfEdges--;
        }
        freeList.add(0, index);
        numOfNodes--;

    }


    /**
     * This method is used to remove an edge between two nodes.
     * 
     * @param mainNode
     *            Represents the first node.
     * @param subNode
     *            Represents the second node.
     */
    public void removeEdge(int mainNode, int subNode) {
        adjList[mainNode].remove(subNode);
        adjList[subNode].remove(mainNode);
    }


    /**
     * This method checks if the two nodes have an edge between them.
     * 
     * @param firstNode
     *            Represents the first node.
     * @param secondNode
     *            Represents the second node.
     * @return True if there is an edge and false otherwise.
     */
    public boolean hasEdge(int firstNode, int secondNode) {
        DLList<Integer> currList = adjList[firstNode];
        for (int x = 0; x < currList.size(); x++) {
            if (currList.get(x) == secondNode) {
                return true;
            }
        }
        return false;
    }


    /**
     * This is a helper method to expand the adjacency list.
     */
    @SuppressWarnings("unchecked")
    private DLList<Integer>[] expandList() {
        DLList<Integer>[] temp = adjList;
        adjList = new DLList[size * 2];
        size = size * 2;
        for (int x = 0; x < temp.length; x++) {
            adjList[x] = temp[x];
            freeList.add(numOfNodes + x);
        }
        return adjList;

    }


    /**
     * This is the print method for the graph.
     */
    public void print() {
        if (numOfNodes == 0) {
            System.out.println("There are 0 connected components");
            System.out.println(
                "The largest connected component has 0 elements");
            System.out.println("The diameter of the largest component is 0");
            return;
        }
        initializeArrays();
        for (int x = 0; x < adjList.length; x++) {
            if (adjList[x] != null) {
                for (int y = 0; y < adjList[x].size(); y++) {
                    if (adjList[x].get(y) != null) {
                        union(x, adjList[x].get(y));
                    }

                }
            }
        }
        System.out.println("There are " + numComponents
            + " connected components");
        System.out.println("The largest connected component has "
            + getElementNum() + " elements");
        System.out.println("The diameter of the largest component is "
            + floyd());
    }


    /**
     * This is a helper method used to find the num of elements in the largest
     * connected component.
     * 
     * @return
     */
    private int getElementNum() {
        int max = wgtArray[0];
        for (int x = 1; x < wgtArray.length; x++) {
            if (wgtArray[x] > max) {
                max = wgtArray[x];
                indexOfLargest = x;
            }
        }
        return max;
    }


    /**
     * This method is used to merge two subtrees if they're different.
     * 
     * @param first
     *            Represents the first node.
     * @param second
     *            Represents the second node.
     */
    private void union(int first, int second) {
        int rootOne = find(first);
        int rootTwo = find(second);
        if (rootOne != rootTwo) {
            if (wgtArray[rootTwo] > wgtArray[rootOne]) {
                parentArray[rootOne] = rootTwo;
                wgtArray[rootTwo] += wgtArray[rootOne];
            }
            else {
                parentArray[rootTwo] = rootOne;
                wgtArray[rootOne] += wgtArray[rootTwo];
            }
            numComponents--;
        }
    }


    /**
     * This method is used to find the root of the index's tree.
     * 
     * @param index
     *            Represents the current node.
     * @return The root of the index's tree.
     */
    private int find(int index) {
        while (parentArray[index] != -1) {
            index = parentArray[index];
        }
        return index;
    }


    /**
     * This is a helper method, used to initialize
     * the arrays for union find.
     */
    private void initializeArrays() {
        numComponents = numOfNodes;
        parentArray = new int[adjList.length];
        wgtArray = new int[adjList.length];
        for (int x = 0; x < adjList.length; x++) {
            parentArray[x] = -1;
            wgtArray[x] = 1;
        }
    }


    /**
     * This method finds the diameter of the largest connected component using
     * Floyd's algorithm.
     * 
     * @return The diameter of the largest connected component.
     */
    private int floyd() {
        initMatrix();
        for (int x = 0; x < numOfNodes; x++) {
            for (int y = 0; y < numOfNodes; y++) {
                for (int z = 0; z < numOfNodes; z++) {
                    if ((matrix[y][x] != Integer.MAX_VALUE)
                        && (matrix[x][z] != Integer.MAX_VALUE) && ((matrix[y][x]
                            + matrix[x][z]) < matrix[y][z])) {
                        matrix[y][z] = (matrix[y][x]) + (matrix[x][z]);
                    }
                }
            }
        }
        return findMaxDiameter();
    }


    /**
     * This method is used to find the max diameter from the matrix.
     * 
     * @return The maximum diameter.
     */
    private int findMaxDiameter() {
        int max = 0;
        for (int x = 0; x < numOfNodes; x++) {
            for (int y = 0; y < numOfNodes; y++) {
                if ((matrix[x][y] != Integer.MAX_VALUE)
                    && (matrix[x][y] > max)) {
                    max = matrix[x][y];
                }
            }
        }
        return max;
    }


    /**
     * This is a helper method that is used to initialize the matrix.
     * 
     * @return The initialized matrix.
     */
    private void initMatrix() {
        matrix = new int[numOfNodes][numOfNodes];
        for (int x = 0; x < numOfNodes; x++) {
            for (int y = 0; y < numOfNodes; y++) {
                int rootOne = find(x);
                int rootTwo = find(y);
                if (x == y) {
                    matrix[x][y] = 0;
                }
                else if (hasEdge(x, y) && (rootOne == rootTwo)
                    && (rootOne == indexOfLargest)) {
                    matrix[x][y] = 1;
                }

                else {
                    matrix[x][y] = Integer.MAX_VALUE;
                }
            }
        }
    }
}
