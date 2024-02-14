import java.util.*;
import java.io.*;

public class Main {

    private static int p, m, l, n;

    private static class Player{
        public final int level;
        public final String nickname;

        Player(int level, String nickname){
            this.level = level;
            this.nickname = nickname;
        }
    }

    private static class Room{
        public final int roomManagerLevel;
        public final List<Integer> list = new ArrayList<>();

        Room(int roomManagerLevel, int index){
            this.roomManagerLevel = roomManagerLevel;
            list.add(index);
        }

        public final void add(int index){
            list.add(index);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        p = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        Player[] players = new Player[p];
        Room[] rooms = new Room[p];
        int roomSize = 0;

        for(int i = 0; i < p; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            players[i] = new Player(
                    Integer.parseInt(tokenizer.nextToken())
                    , tokenizer.nextToken(
            ));

            int roomIndex = 0;
            for(; roomIndex < roomSize; roomIndex++){
                // +-10, 방 최대인원 보다 적은 인원 수로 가득찼다면
                if(Math.abs(rooms[roomIndex].roomManagerLevel - players[i].level) <= 10 && rooms[roomIndex].list.size() < m){
//                    System.out.println("i : " + i + " roomManger : " + rooms[roomIndex].roomManagerLevel +
//                            " player : " + players[i].level + " " + players[i].nickname +
//                            " listSize : " + rooms[roomIndex].list.size());

//                    for(int number : rooms[roomIndex].list ) System.out.print(number + " ");
//                    System.out.println();
                    rooms[roomIndex].list.add(i);
//                    for(int number : rooms[roomIndex].list ) System.out.print(number + " ");
//                    System.out.println();
                    break;
                }
            }

            // 현재 사용자가 들어갈 방이 없을 때
            if(roomIndex == roomSize){
                rooms[roomIndex] = new Room(players[i].level, i);
                roomSize++;
            }
        }

        for(int roomIndex = 0; roomIndex < roomSize; roomIndex++){
            // 정렬
            Collections.sort(rooms[roomIndex].list, (m1, m2) -> (players[m1].nickname.compareTo(players[m2].nickname)));
            if(rooms[roomIndex].list.size() == m) builder.append("Started!").append("\n");
            else builder.append("Waiting!").append("\n");

            for(int userIndex : rooms[roomIndex].list){
                builder.append(players[userIndex].level + " " + players[userIndex].nickname).append("\n");
            }
        }

        System.out.print(builder);
        reader.close();
    }
}