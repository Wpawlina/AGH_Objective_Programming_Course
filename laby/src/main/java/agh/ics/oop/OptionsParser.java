package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;

import java.util.LinkedList;
import java.util.stream.Stream;

public class OptionsParser {
    public  static LinkedList<MoveDirection> parse(String[] options)
    {
//        //Użyłem LinkedList, ponieważ jest to struktura danych oparta na dwukierunkowej linked liscie, która pozwala na szybkie dodawanie elemntów do listy które wystepuje w mojej aplikacji bardzo często , jednak kiedy chcemy wyciagac wartosci po indeksach ArrayList jest szybsza od LinkedList ponieważ jest oparta na tablicach.
//        LinkedList<MoveDirection>Moves = new LinkedList<MoveDirection>();
//        int i=0;
//        for (String opt: options) {
//            switch (opt)
//            {
//                case "f" -> Moves.add(MoveDirection.FORWARD);
//                case "l" -> Moves.add(MoveDirection.LEFT);
//                case "r" -> Moves.add(MoveDirection.RIGHT);
//                case "b" -> Moves.add(MoveDirection.BACKWARD);
//                default -> throw new IllegalArgumentException(opt + " is not  legal move specification");
//            }
//
//        }
//        return Moves;


        return new  LinkedList<MoveDirection>(Stream.of(options).map(opt->{
           return switch (opt)
            {
                case "f"-> MoveDirection.FORWARD;
                case "b"->  MoveDirection.BACKWARD;
                case "r"->  MoveDirection.RIGHT;
                case "l"->  MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(opt + " is not  legal move specification");
            };
        }).toList());
    }
}
