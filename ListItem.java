//An object that stores a character and the objects initial place in an array
//is used so that 
public class ListItem {
    char ch;
    int place;

//listitem builder method
    public ListItem(char c, int p){
        ch = c;
        place = p;
    }

//creates a new listitem
    public ListItem createItem(char c, int p){
        ListItem it = new ListItem(c,p);
        return it;
    }

//returns place value
    public int getPlace(){
        return place;
    }

//returns character
    public char getCh(){
        return ch;
    }
}
