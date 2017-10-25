
import java.util.ArrayList;

public enum Day {
    Monday,
    Tuseday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

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

