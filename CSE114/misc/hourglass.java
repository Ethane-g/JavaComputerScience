package com.company;

public class hourglass {
    public static void main(String[] args){
        int[][] glass = new int[6][6];
        for(int i =0;i<6;i++){
            for(int j =0;j<6;j++){
                glass[i][j] = (int)(Math.random()*11);
            }
        }
        for(int i =0;i<6;i++){
            for(int j =0;j<6;j++){
                System.out.print(glass[i][j]+" ");
            }
            System.out.println();
        }
        //below is hourglass
        int largesthour=0;
        int[] target = new int[2];
        int[] where =  new int[2];
        for(int i=0;i<4;i++){
            for(int j = 0;j<4;j++){
                int temphour = 0;
                target[0]=i;
                target[1]=j;
                //top part of hourglass
                for(int a = 0;a<3;a++){
                    temphour += glass[target[0]][target[1]+a];
                }
                //middle part of hourglass
                temphour += glass[target[0]+1][target[1]+1];
                //bottom row of hourglass
                for(int a = 0;a<3;a++){
                    temphour += glass[target[0]+2][target[1]+a];
                }
                //end of hourglass
                if(i==0&&j==0){
                    largesthour=temphour;
                }
                if(largesthour<temphour){
                    largesthour=temphour;
                    where[0] = target[0];
                    where[1] = target[1];
                }
            }
        }
        System.out.println("the largest hourglass is " + largesthour + " and its location is at"+where[0]+" "+where[1]);
    }
}
