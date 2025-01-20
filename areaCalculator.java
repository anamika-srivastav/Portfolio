import java.util.Scanner; 
import java.lang.Math; 

public class areaCalculator { 
    
    public static void main(String args[]){ 
        
        double sideLength; 
        double sideWidth; 
        double radius; 
        final double pi = Math.PI; 
        char shapeSelected; 
        int loops = 0; 
        
        Scanner scanner = new Scanner(System.in);
        
        do { 
            
            if (loops >= 1 ) {
                System.out.println("Invalid input please try again"); 
            }
            
        menu(); 
        
    
        String userInput = scanner.nextLine();
        
      
        shapeSelected = (char) userInput.charAt(0); 
        
        loops += 1; 
        
        
        } 
        
        while ((shapeSelected != 'S' ) && (shapeSelected != 's') && (shapeSelected != 'R' )  && (shapeSelected != 'r') && (shapeSelected != 'C') && (shapeSelected !='c')&& (shapeSelected != 'X')&&
        (shapeSelected != 'x')); 
            
            
            
            switch (shapeSelected) { 
                
                case 'S' : case 's' : 
                    
                    System.out.println("Please enter the side length: "); 
                    
                    String lengthUserInput = scanner.nextLine();
                    
                 
                     
                     sideLength = Double.parseDouble(lengthUserInput); 
                    
                    System.out.println("Area of your square is: " + (sideLength * sideLength)); 
                    
                    
                    
                    break; 
                
                case 'R': case  'r': 
                    
                     System.out.println("Please enter the side length: "); 
                     
                     String rectLengthUserInput = scanner.nextLine();
                     
                     sideLength = Double.parseDouble(rectLengthUserInput); 
                     
                      System.out.println("Please enter the side width: "); 
                      
                       String rectWidthUserInput = scanner.nextLine();
                       
                       sideWidth = Double.parseDouble(rectWidthUserInput); 
                       
                        System.out.println("Area of your rectangle is: " + (sideLength * sideWidth)); 
                      
                      
                      break; 
                      
                case 'C' : case 'c': 
                    
                     
                         System.out.println("Please enter the radius: "); 
                     
                     String radiusUserInput = scanner.nextLine();
                     
                     radius = Double.parseDouble(radiusUserInput); 
                     
                     
                     System.out.println("Area of your circle is: " + (radius * radius * pi)); 
                     
                     break; 
                
                case 'X' : case 'x' : 
                    
                        System.out.println("Quit"); 
                    break; 
                    
                    
                      default: 
                      
                      break; 
                  
            
                
                
            }
           
    }
    
     public static void menu(){ 
            
            System.out.println(" ***Area Calculator***"); 
            System.out.println("S  --  Square"); 
            System.out.println("R  --  Rectangle"); 
            System.out.println("C  --  Circle"); 
            System.out.println("X -- quit"); 
            
        }
        
    
    
        


}