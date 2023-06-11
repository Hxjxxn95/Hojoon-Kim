import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] graph;


    public static void Dijkstra(int n, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            for(Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        //최소거리 출력
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == INF) sb.append(0).append(' ');
            else sb.append(dist[i]).append(' ');
        }sb.append('\n');
    }
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }
       
         for(int i = 1; i <= n; i++){
            Dijkstra(n,i);
        }
         System.out.println(sb);


    }
}
