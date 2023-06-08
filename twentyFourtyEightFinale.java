import java.util.*;
public class twentyFourtyEightFinale
{
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in)) {
            int[][] num=new int[4][4];
            for(int i=0; i<4; i++)
            {
                for(int j=0; j<4; j++)
                {
                    int inputs=input.nextInt();
                    num[i][j]=inputs;
                }
            }
            int dir=input.nextInt();
            if(dir==0)
            {
                print2D(left(num));
            }
            else if(dir==1)
            {
                print2D(up(num));
            }
            else if(dir==2)
            {
                print2D(right(num));
            }
            else
            {
                print2D(down(num));
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

    public static void print2D(int mat[][])
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}