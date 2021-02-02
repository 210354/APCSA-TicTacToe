

public class Cell {
		
    private String mark;
    
    Cell(int num)
    {
        mark = " ";
    }
    
    public void setX()
    {
        mark = "X";
    }
    
    public void setO()
    {
        mark = "O";
    }
    
    public void setMark(String m)
    {
        this.mark = m;
    }
    public String getMark()
    {
        return mark;
    }
    
    
    public String paint()
    {
            return mark;
    }
}