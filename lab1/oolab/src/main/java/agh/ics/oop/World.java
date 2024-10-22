package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
       // World.run(args);
        MoveDirection[] Moves=OptionsParser.parse(args);
        World.run(Moves);
        System.out.println("system zakończył działanie");
    }
    public static  void run(MoveDirection[] args)
    {
        for (MoveDirection arg : args) {
            switch (arg)
            {
                case MoveDirection.FORWARD -> System.out.println("zwierzak idzie do przodu");
                case  MoveDirection.LEFT -> System.out.println("zwierzak skręca w lewo");
                case  MoveDirection.RIGHT -> System.out.println("zwierzak skręca w prawo");
                case  MoveDirection.BACKWARD -> System.out.println("zwierzak idzie do tyłu");
            }

        }


    }
    /*public static  void run(String[] args)
    {

        System.out.println("Zwierzak idze do przodu");
        String result="";
        for (String arg : args) {
            result += arg+",";
        }
        result=result.substring(0, result.length()-1);
        System.out.println(result);

    }*/


  /*  public static  void run(String[] args)
    {

        for (String arg : args) {
            switch (arg) {
                case "f" -> System.out.println("zwierzak idzie do przodu");
                case "l" -> System.out.println("zwierzak skręca w lewo");
                case "r" -> System.out.println("zwierzak skręca w prawo");
                case "b" -> System.out.println("zwierzak idzie do tyłu");
            }

        }
    }*/

}
