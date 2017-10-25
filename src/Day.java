
import java.util.ArrayList;
//define Enum Day
public enum Day {
    Monday,
    Tuseday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

//    static function that returns the ArrayList that contains 30 days
    static public ArrayList<Day>month(){
        int i=0;
        ArrayList<Day> month=new ArrayList<>();
        while(i<30){
            for( Day d:Day.values()){
                if(i==30)
                    break;
                month.add(d);
                i++;
            }

        }
        return month;
    }
}

