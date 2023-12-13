public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] graph = {
                {0, 4, 3, 0, 0, 0, 0},
                {4, 0, 0, 0, 12, 5, 0},
                {3, 0, 0, 7, 10, 0, 0},
                {0, 0, 7, 0, 2, 0, 0},
                {0, 12, 10, 2, 0, 0, 5},
                {0, 5, 0, 0, 0, 0, 16},
                {0, 0, 0, 0, 5, 16, 0}
        };

        int[] visited = new int[nodes.length];
        int totalWeight = 0;

        initializeVisitedArray(visited);
        setZeroEdgesToMax(graph);

        visited[0] = 1;

        for (int counter = 0; counter < nodes.length - 1; counter++) {
            int minWeight = Integer.MAX_VALUE;
            int sourceNode = 0;
            int destinationNode = 0;

            for (int i = 0; i < nodes.length; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < nodes.length; j++) {
                        if (visited[j] == 0 && minWeight > graph[i][j]) {
                            minWeight = graph[i][j];
                            sourceNode = i;
                            destinationNode = j;
                        }
                    }
                }
            }

            visited[destinationNode] = 1;
            totalWeight += minWeight;
            System.out.println("Edge: " + nodes[sourceNode] + " ---> " + nodes[destinationNode] + ", Weight: " + minWeight);
        }

        System.out.println("Total Weight of Minimum Spanning Tree: " + totalWeight);
    }

    private static void initializeVisitedArray(int[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
    }

    private static void setZeroEdgesToMax(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }
}
