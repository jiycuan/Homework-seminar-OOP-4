import java.util.Arrays;

public class Maze {

    public static void main(String[] args) {

        String maze[][] = new String [21][21];

        // Создаём базу для лабиринта - массив 21 на 21 и заполняем его значками #
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                maze[i][j] = "#";
            }
        }

        // Запускаем внутрь кротика, который будет прогрызать в массиве породы из решёток рандомный путь.

        
        int count = 10000;
        while (count > 0) {
            mole(maze);
            count--;
        }
        

        for (String[] arr : maze) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void mole(String[][] maze) {
        int coordinate1 = (int) (Math.random() * 11)*2;
        int coordinate2 = (int) (Math.random() * 11)*2;

        if (maze[coordinate1][coordinate2] == "#") {
            maze[coordinate1][coordinate2] = " ";
            move(maze, coordinate1, coordinate2);
        }
    }

    public static void move(String[][] maze, int coordinate1, int coordinate2) {
        int arbiter = (int) (Math.random() * 4);
        if (arbiter == 0 & coordinate1-2 > 0) {
            coordinate1 = coordinate1-2;
            maze[coordinate1-1][coordinate2] = " ";
            maze[coordinate1-2][coordinate2] = " ";
            coordinate1 = coordinate1-2;
            move(maze, coordinate1, coordinate2);
        }
        if (arbiter == 1 & coordinate1+2 < 20) {
            maze[coordinate1+1][coordinate2] = " ";
            maze[coordinate1+2][coordinate2] = " ";
            coordinate1 = coordinate1+2;
            move(maze, coordinate1, coordinate2);
        }
        if (arbiter == 2 & coordinate2-2 > 0) {
            maze[coordinate1][coordinate2-1] = " ";
            maze[coordinate1][coordinate2-2] = " ";
            coordinate2 = coordinate2-2;
            move(maze, coordinate1, coordinate2);
        }
        if (arbiter == 3 & coordinate2+2 < 20) {
            maze[coordinate1][coordinate2+1] = " ";
            maze[coordinate1][coordinate2+2] = " ";
            coordinate2 = coordinate2+2;
            move(maze, coordinate1, coordinate2);
        }
    }
}
