import java.util.LinkedList;
import java.util.Queue;

public class Flow {

    //Parent Vertex Array
    public static Vertex<V>[] parentArr;

    public void maximizeFlowNetwork(Graph fN, int s, int t){

        while(breadthFirstPathSearch(fN,s, t) == 1){

            int path_flow = Integer.MAX_VALUE;
            for(Vertex<V> v = FN.getVertex(t); v != FN.getVertex(s); v = parentArr[v]){
                Vertex<V> u = parentArr[v];
                path_flow = Math.min(path_flow, (FN.getEdge(u,v).flowCapacity() - FN.getEdge(u,v).flow()));
            }

            for(Vertex<V> v = FN.getVertex(t); v != FN.getVertex(s); v = parentArr[v]){
                Vertex<V> u = parentArr[v];
                FN.getEdge(u,v).flow() += path_flow;
                FN.getEdge(v,u).flow() -= path_flow;
            }

        }

    }

    //Increase flow on path equal to maxFlow calculated above
                for (currNodeLabel=fN.numVertices();currNodeLabel!=s;currNodeLabel=parent[currNodeLabel]) {
        //Accounting for the forward flow
        currEdge = fN.getEdge(fN.getVertex(parent[currNodeLabel]),fN.getVertex(currNodeLabel));
        currEdge.flow = currEdge.flow+maxFlow;
        //Accounting for the back flow
        Edge currEdgeReverse = fN.getEdge(fN.getVertex(currNodeLabel), fN.getVertex(parent[currNodeLabel]));
        currEdgeReverse.flow = currEdgeReverse.flow-maxFlow;
    }
    public int breadthFirstPathSearch(Graph FN, int s, int d){
        int size = d-s;
        parentArr = new Vertex<V>[size];
        int[] visitedArr = new int[size];
        LinkedListQueue<Vertex<V>> queue = new LinkedListQueue<>();

        for(int visited: visitedArr)
            visited = 0;

        queue.enqueue(FN.getVertex(s));
        visitedArr[s] = 1;
        parentArr[s] = null;

        while (queue.size()!=0)
        {
            Vertex<V> v = queue.dequeue();

            for (Edge<E> e: FN.outgoingEdges(v))
            {
                if (visitedArr[FN.opposite(v,e).getLabel()]==0 && e.flow() < e.flowCapacity())
                {
                    Vertex<V> child = FN.opposite(v,e);
                    queue.add(child);
                    parentArr[child.getLabel()] = v.
                    visitedArr[child.getLabel()] = 1;
                }
            }
        }

        if(visitedArr[d] == 1)
            return 1;

        return 0;
    }


}
