import java.util.*;
public class twentyFourtyEightFinaleGameColor
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in)) {
            int[][] num=new int[4][4];
            for(int i=0; i<2; i++)
            {
                int locationRow=(int)(Math.random()*(num.length-1-0+1)+0);
                int locationCol=(int)(Math.random()*(num.length-1-0+1)+0);
                int chanceFour=(int)(Math.random()*(100-0+1)+0);
                if(chanceFour>=90)
                {
                    num[locationRow][locationCol]=4;
                }
                else
                {
                    num[locationRow][locationCol]=2;
                }
            }
            print2D(num);
            try 
            {
                while(true)
                {
                    if(searchWin(num))
                    {
                        System.out.println("Winner winner!");
                    }
                    String dir=input.nextLine();
                    if(dir.equals("a"))
                    {
                        left(num);
                    }
                    else if(dir.equals("w"))
                    {
                        up(num);
                    }
                    else if(dir.equals("d"))
                    {
                        right(num);
                    }
                    else
                    {
                        down(num);
                    }
                    num=randomNum(num);
                    System.out.println("\nNew round");
                    print2D(num);
                }
            }
            catch(Exception e) 
            {
                System.out.println("\nGame Over");
            }
        }
    }

    public static int[][] left(int[][] arr)
    {
        int[][] array=arr;
        String direction="left";
        array=push(array,direction);
        array=push(array,direction);
        array=add(array, direction);
        array=push(array, direction);
        array=push(array, direction);
        return array;
    }

    public static int[][] right(int[][] arr)
    {
        int[][] array=arr;
        String direction="right";
        array=push(array,direction);
        array=push(array,direction);
        array=add(array, direction);
        array=push(array, direction);
        array=push(array, direction);
        return array;
    }

    public static int[][] up(int[][] arr)
    {
        int[][] array=arr;
        String direction="up";
        array=push(array,direction);
        array=push(array,direction);
        array=add(array, direction);
        array=push(array, direction);
        array=push(array, direction);
        return array;
    }

    public static int[][] down(int[][] arr)
    {
        int[][] array=arr;
        String direction="down";
        array=push(array,direction);
        array=push(array,direction);
        array=add(array, direction);
        array=push(array, direction);
        array=push(array, direction);
        return array;
    }
    
    public static int[][] add(int[][] arr, String direction)
    {
        int[][] array=arr;
        if(direction.equals("up"))
        {
            for(int column=0; column<array[0].length; column++)
            {
                for(int row=array.length-1; row>0; row--)
                {
                    if(array[row][column]==array[row-1][column] && array[row][column]!=0)
                    {
                        array[row][column]=array[row-1][column]+array[row][column];
                        array[row-1][column]=0;
                    }
                }
            }
        }
        else if(direction.equals("down"))
        {
            for(int column=0; column<array[0].length; column++)
            {
                for(int row=0; row<array.length-1; row++)
                {
                    if(array[row][column]==array[row+1][column] && array[row][column]!=0)
                    {
                        array[row][column]=array[row+1][column]+array[row][column];
                        array[row+1][column]=0;
                    }
                }
            }
        }
        else if(direction.equals("left"))
        {
            for(int row=0; row<array.length; row++)
            {
                for(int column=0; column<array[0].length-1; column++)
                {
                    if(array[row][column]==array[row][column+1] && array[row][column]!=0)
                    {
                        array[row][column]=array[row][column+1]+array[row][column];
                        array[row][column+1]=0;
                    }
                }
            }
        }
        else
        {
            for(int row=0; row<array.length; row++)
            {
                for(int column=array[0].length-1; column>0; column--)
                {
                    if(array[row][column]==array[row][column-1] && array[row][column]!=0)
                    {
                        array[row][column]=array[row][column-1]+array[row][column];
                        array[row][column-1]=0;
                    }
                }
            }
        }
        return array;
    }

    public static int[][] push(int [][] arr, String direction)
    {
        int[][] array=arr;
        if(direction.equals("up"))
        {
            for(int column=0; column<array[0].length; column++)
            {
                for(int row=0; row<array.length-1; row++)
                {
                    if(array[row][column]==0)
                    {
                        array[row][column]=array[row+1][column];
                        array[row+1][column]=0;
                    }
                }
            }
        }
        else if(direction.equals("down"))
        {
            for(int column=0; column<array[0].length; column++)
            {
                for(int row=array.length-1; row>0; row--)
                {
                    if(array[row][column]==0)
                    {
                        array[row][column]=array[row-1][column];
                        array[row-1][column]=0;
                    }
                }
            }
        }
        else if(direction.equals("left"))
        {
            for(int row=0; row<array.length; row++)
            {
                for(int column=0; column<array[0].length-1; column++)
                {
                    if(array[row][column]==0)
                    {
                        array[row][column]=array[row][column+1];
                        array[row][column+1]=0;
                    }
                }
            }
        }
        else
        {
            for(int row=0; row<array.length; row++)
            {
                for(int column=array.length-1; column>0; column--)
                {
                    if(array[row][column]==0)
                    {
                        array[row][column]=array[row][column-1];
                        array[row][column-1]=0;
                    }
                }
            }
        }
        return array;
    }
    public static int[][] randomNum(int[][] arr)
    {
        int[][] array=arr;
        ArrayList<zeroObject> allZero=new ArrayList<zeroObject>();
        for(int row=0; row<array.length; row++)
        {
            for(int col=0; col<array[0].length; col++)
            {
                if(array[row][col]==0)
                {
                    allZero.add(new zeroObject(row, col));
                }
            }
        }
        int location=(int)(Math.random()*(allZero.size()-1-0+1)+0);
        int chanceFour=(int)(Math.random()*(100-0+1)+0);
        int row=allZero.get(location).getRow();
        int col=allZero.get(location).getCol();
        if(chanceFour>=90)
        {
            array[row][col]=4;
        }
        else
        {
            array[row][col]=2;
        }

        return array;
    }
    public static void print2D(int mat[][])
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                if(mat[i][j]==0){
                    System.out.print(ANSI_WHITE+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==2)
                {
                    System.out.print(ANSI_WHITE_BACKGROUND+ANSI_BLACK+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==4)
                {
                    System.out.print(ANSI_WHITE_BACKGROUND+ANSI_BLACK+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==8)
                {
                    System.out.print(ANSI_RED_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==16)
                {
                    System.out.print(ANSI_RED_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==32)
                {
                    System.out.print(ANSI_RED_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==64)
                {
                    System.out.print(ANSI_RED_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==128)
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==256)
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==512)
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else if(mat[i][j]==1024)
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }
                else
                {
                    System.out.print(ANSI_YELLOW_BACKGROUND+mat[i][j] +ANSI_RESET+" ");
                }

            }
            System.out.println();
        }
    }
    public static boolean searchWin(int[][] arr)
    {
        for(int row=0; row<arr.length; row++)
        {
            for(int col=0; col<arr[0].length; col++)
            {
                if(arr[row][col]==2048)
                {
                    return true;
                }
            }
        }
        return false;
    }
}