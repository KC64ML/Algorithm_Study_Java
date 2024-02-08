class Solution {
    
    int oCnt, xCnt;
    
    boolean diagonal(char[][] boardChar, int len){
        // [0, 0]에서 [n-1, n-1]
        // 시작점 확인
        char startBoard = boardChar[0][0];
        boolean checkBoard = true;
        
        for(int i = 1; i < len; i++){
            if(boardChar[0 + i][0 + i] != startBoard){
                checkBoard = false;
                break;
            }
        }
        
        // 성공한 경우
        // startBoard가 X라면
        if(((startBoard == 'X' && oCnt == xCnt) || (startBoard == 'O' && oCnt > xCnt)) && checkBoard) return true;
        
        checkBoard = true;
        
        startBoard = boardChar[0][len - 1];
        for(int i = 1; i < len; i++){
            if(boardChar[0 + i][len - 1 - i] != startBoard){
                checkBoard = false;
                break;
            }
        }
        
        // 성공하거나 실패한 경우
        if(((startBoard == 'X' && oCnt == xCnt) || (startBoard == 'O' && oCnt > xCnt)) && checkBoard) return true;
        else return false;
    }
    
    boolean rowCheck(char[][] boardChar, int len){
        // 행 검사
        for(int i = 0; i < len; i++){
            boolean check = true;
            for(int j = 0; j < len - 1; j++){
                if(boardChar[i][j] != boardChar[i][j+1]) check = false;
            }
            // 만약 true일 때
            if(check){
                return true;
            }
        }
        
        return false;
    }
    
    
    boolean colCheck(char[][] boardChar, int len){
        for(int i = 0; i < len; i++){
            boolean check = true;
            for(int j = 0; j < len - 1; j++){
                if(boardChar[j][i] != boardChar[j+1][i]) check = false;
            }
            
            if(check){
                return true;
            }
        }
        return false;
    }
    
    public int solution(String[] board) {
        int answer = -1;
        int lenSize = board.length;
        oCnt = 0;
        xCnt = 0;
        char[][] boardChar = new char[board.length][board.length];
        
        for(int i =0; i< board.length; i++){
            for(int j =0; j< board[0].length(); j++){
                boardChar[i][j] = board[i].charAt(j);
                if(boardChar[i][j] == 'O') oCnt += 1;
                else if(boardChar[i][j] == 'X') xCnt += 1;
            }
        }
        
        // o갯수보다 x갯수가 많다면, o갯수 - x갯수의 차가 1보다 크다면 잘못된 것
        if(oCnt < xCnt || oCnt - xCnt > 1) return 0;
        
        // (2)
        // 가로, 세로, 대각선 O가 다 채워져 있는 곳이 있을 때
        // X의 개수가 O 총 개수 - 1개 여야 한다.
        // System.out.println("2번 실행");
        // (2-1) 대각선
        if(diagonal(boardChar, lenSize)){
            // System.out.println("2-1");
            if(((oCnt > xCnt) || (oCnt == 0 && xCnt == 0))) return 1;
            else if((oCnt == lenSize) && (xCnt == lenSize)) return 0;
        }
        
        // (2-2) 행 확인
        if(rowCheck(boardChar, lenSize)){
            // System.out.println("2-2");
            if((oCnt > xCnt) || (oCnt == 0 && xCnt == 0)) return 1;
            else if((oCnt == lenSize) && (xCnt == lenSize)) return 0;
        }
        
        // (2-3) 열 확인
        if(colCheck(boardChar, lenSize)){
            // System.out.println("2-3");
            if((oCnt > xCnt) || (oCnt == 0 && xCnt == 0)) return 1;
            else if((oCnt == lenSize) && (xCnt == lenSize)) return 0;
        }
        
        // System.out.println("0 , 1 : " + oCnt + " " + xCnt);
        if(oCnt == xCnt) return 1;
        
        return 0;
        
        // 참고 : https://chamdom.blog/pg2-160585/
    }
}