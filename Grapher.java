import java.awt.*;
import java.util.Scanner;
public class Grapher extends Canvas{
    private String name;
    private int xDim, yDim, aocFreq;
    public Grapher(String name, int xDim, int yDim, int aocFreq){
        this.name = name;
        this.xDim = xDim;
        this.yDim = yDim;
        this.aocFreq = aocFreq;
        setBackground(Color.BLACK);
        setSize(xDim, yDim);
        this.setup();
        System.out.println("Grapher \"" + this.name + "\" initialized.");
    }
    public void setup(){
        Frame f = new Frame(this.name); 
        f.pack();
        f.add(this);
        f.setLayout(null);    
        f.setSize(this.xDim, this.yDim);    
        f.setVisible(true);  
        System.out.println(this);
    }
    public void paint(Graphics g){    
        // adding specifications  
        g.setColor(Color.BLUE);    
        g.drawLine(this.xDim / 2, 0, this.xDim / 2, this.yDim);
        g.drawLine(0, this.yDim / 2, this.xDim, this.yDim / 2);
    
    
        g.setColor(Color.GREEN); 
        
        for(int x = -xDim/2; x < this.xDim/2; x++){
            int x0 = x + xDim / 2;
            g.setColor(Color.GREEN);
            int y1 = this.function(x);
            int y2 = this.function(x+1); // Think Trapezoidal Riemann approximation or distance formula.

    
            g.drawOval(x0, y1, 1, 1); // Points of Function
            g.drawLine(x0, y1, x0+1, y2);

            
                if(this.aocFreq != 0 && (x % this.aocFreq == 0) && y1 != 0){
                    g.setColor(Color.YELLOW);
                    g.drawLine(x0, this.yDim / 2, x0, y1); // Integral (Area under Curve)
                }
            }
    }
    public int function(int x){
        double 
        // Set y equal to a function in terms of x.
        
        y = 0.0001 * Math.pow(x, 3)  // 0.0001x^3
        
        ;


        return this.yDim / 2 - (int)Math.round(y);
    }
    public int getXDim(){return this.xDim;}
    public int getYDim(){return this.yDim;}
    public String toString(){
        return this.name + ", " + this.xDim + " x " + this.yDim;
    }
    public static void main(String[] args){
        
        Grapher g = new Grapher("Graph", 400, 400, 20);
        System.out.println(g);








        
        // (IGNORE) Exit Window Stuff
        Scanner input = new Scanner(System.in);
        String in = "...";
        while(!in.equals("")){
            System.out.print("Press [Enter] to exit.");
            in = input.nextLine();
        }
        System.exit(0);
    }

}