import java.awt.*;
import java.util.Scanner;
public class ParaGrapher extends Grapher{
    double tMin, tMax, tStep;
    int scalar;
    public ParaGrapher(String name, int xDim, int yDim, double tMin, double tMax, double tStep, int scalar){
        super(name, xDim, yDim, 0);
        this.tMin = tMin;
        this.tMax = tMax;
        this.tStep = tStep;
        this.scalar = scalar;
    }
    @Override
    public void paint(Graphics g){    
        // adding specifications  
        g.setColor(Color.BLUE);    
        g.drawLine(this.getYDim() / 2, 0, this.getXDim() / 2, this.getYDim());
        g.drawLine(0, this.getYDim() / 2, this.getXDim(), this.getYDim() / 2);
    
    
        g.setColor(Color.GREEN);
            for(double t = tMin; t < tMax; t+= tStep){
                int x = functionX(t);
                int y = functionY(t);
                g.drawOval(x, y, 3, 3);
        }
    }
    public int functionX(double t){
        return this.getXDim()/2+(int)Math.round((scalar*(
            //80 * Math.cos(t) + 120 * Math.cos((2 * t)/3)
            Math.sin(5 * t)
        )));
    }
    public int functionY(double t){
        return this.getYDim()/2 - (int)Math.round((scalar*(
            //80 * Math.sin(t) - 120 * Math.sin((2 * t)/3)
             Math.sin(6 * t)
        )));
    }
    public static void main(String[] args){
        ParaGrapher pg = new ParaGrapher("ParaGrapher", 400, 400, 0, 20, 0.01, 100);







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