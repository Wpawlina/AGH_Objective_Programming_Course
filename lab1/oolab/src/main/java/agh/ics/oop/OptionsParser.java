package agh.ics.oop;

public class OptionsParser {
    public  static MoveDirection[] parse(String[] options)
    {
        MoveDirection[] Moves = new MoveDirection[options.length];
        int i=0;
        for (String opt: options) {
            switch (opt)
            {
                case "f" -> Moves[i]=MoveDirection.FORWARD;
                case "l" -> Moves[i]=MoveDirection.LEFT;
                case "r" -> Moves[i]=MoveDirection.RIGHT;
                case "b" -> Moves[i]=MoveDirection.BACKWARD;
            }
            i++;
        }
        return Moves;
    }
}
