package game;

import board.Board;
public class Game {
    Board bd;
    public Game(Board bd){
        this.bd=bd;
    }
    public void play(){
        if(bd.size<4){
            System.out.println("No Configuration possible");
            return;
        }
        nqueen_helper(bd.mat,0);
    }
    private void nqueen_helper(char mat[][],int row){
        if(row==mat.length){
            printboard(mat);
            return;
        }
        for(int col=0;col<bd.size;col++){
            if(isSafe(mat,row,col)==true){
                mat[row][col]='0';
                nqueen_helper(mat, row+1);
                mat[row][col]='-';
            }
        }
    }
    private boolean isSafe(char mat[][],int row,int col){
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
            if(mat[i][j]=='0'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<bd.size ;i--,j++){
            if(mat[i][j]=='0'){
                return false;
            }
        }
        for(int i=row-1,j=col;i>=0;i--){
            if(mat[i][j]=='0'){
                return false;
            }
        }
        return true;
    }
    private void printboard(char mat[][]){
        for(int i=0;i<bd.size;i++){
            for(int j=0;j<bd.size;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
