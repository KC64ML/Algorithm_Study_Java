import java.util.*;

class Solution {
    
    private static class Node{
        public final int x;
        public final int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    // U, R, D, L
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private boolean[][][] visited;
    
    
    private boolean isWithInRange(int row, int col){
        return 0 <= row && 0 <= col && row <= 10 && col <= 10;
    }
    
    private int bfs(char[] dirs){
        // Set<String> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        // 0 ~ 10, 0 ~ 10 좌표
        visited = new boolean[11][11][4];
        map.put('U', 0);
        map.put('R', 1);
        map.put('D', 2);
        map.put('L', 3);
        int result = 0;
        
        int curX = 5;
        int curY = 5;
        
        for(int i = 0; i < dirs.length; i++){
            int dirIndex = map.get(dirs[i]);
            int nx = curX + dx[dirIndex];
            int ny = curY + dy[dirIndex];
            
            if(!isWithInRange(ny, nx)) continue;
            
            if(!visited[ny][nx][dirIndex] && !visited[curY][curX][(dirIndex + 2) % 4]){
                // System.out.println("현재 좌표 : " + (nx - 5) + " " + (ny - 5) + " " + dirIndex);
                visited[ny][nx][dirIndex] = true;
                visited[curY][curX][(dirIndex + 2) % 4] = true;
                result += 1;
            }
            
       
            
            // set.add(new String(nx + "" + ny));
            curY = ny;
            curX = nx;
        }
        
//         for(String inSet : set){
//             System.out.println(inSet);
//         }
        
//         return set.size();
        return result;
        
    }
    
    public int solution(String dirs) {
        
        return bfs(dirs.toCharArray());
    }
}