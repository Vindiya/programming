import java.util.*;

class tempCodeRunnerFile {

    public static void main(String[] args) {
        int[][] dungeon = {{0,0,0,1},
                            {1,0,0,0},
                            {0,1,0,1},
                            {1,0,0,1}};
        int sx = 0, sy=0, tx=3, ty=2;
        System.out.println(shortTestPath(dungeon, sx, sy, tx,ty));
        
    }
    public static int shortTestPath(int[][] matrix, int sx, int sy, int tx, int ty) {
        Queue<Integer> xQueue = new LinkedList<Integer>();
        Queue<Integer> yQueue = new LinkedList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int hr[] = {1,-1,0,0};
        int vc[] = {0,0,1,-1};
        xQueue.add(sx);
        yQueue.add(sy);
        boolean found=false;
        int nodesInLayer = 1, nodesInNextLayer = 0;
        int moveCount=0;
        while(!xQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();
            if(x==tx && y==ty) {
                found=true;
                break;
            }
            for(int i=0; i<4; i++) {
                int nx = x+hr[i];
                int ny = y+vc[i];
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                if(matrix[nx][ny]==1 || visited[nx][ny]) continue;
                xQueue.add(nx);
                yQueue.add(ny);
                visited[nx][ny] = true;
                nodesInNextLayer++;
            }
            nodesInLayer--;
            if(nodesInLayer==0) {
                nodesInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }
        if(found) {
            return moveCount;
        }
        return -1;
    }
}