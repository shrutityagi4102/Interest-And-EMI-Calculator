import java.util.*;

public class interestandemicalculator {

    public static void si(float p, float r, float t){
       float sinterest = (p*r*t)/100;
       float amount = p + sinterest;
       System.out.println("-----------------------------------------------------------");
       System.out.print("\nSimple Interest is: Rs. " +sinterest);
       System.out.print("\nTotal Amount is: Rs. " +amount);
       System.out.println("\n-----------------------------------------------------------");
       
    }
    
    public static void ci(float p, float r, float t, int n){
       double amount = p * Math.pow(1 + (r/ n), n * t);
       double cinterest = amount - p;
       System.out.println("-------------------------------------------------------------------------");
       System.out.println("\nCompound Interest after " + t + " years: Rs. "+cinterest+"\n");
       System.out.println("Amount after " + t + " years: Rs. "+amount);
       System.out.println("\n-------------------------------------------------------------------------");

    }

    public static void emi(float p, float r, float t){
       float emi;
       r = r / (12 * 100); // one month interest
       t = t * 12; // one month period
       emi = (p * r * (float)Math.pow(1 + r, t))/ (float)(Math.pow(1 + r, t) - 1);
       System.out.println("-----------------------------------------------------------");
       System.out.println("\nEMI: Rs. "+emi);
       System.out.println("\n-----------------------------------------------------------");

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N,unit,option;
        float P,R,T;
        boolean check = true;
        System.out.println("\t---------------------------------\t");
        System.out.println("\t    INTEREST AND EMI CALCULATOR   \t");
        System.out.println("\t---------------------------------\t");

        System.out.println("\nPlease Enter the Principal (in Rupees) : ");
        P  = sc.nextFloat();
        System.out.println("\nPlease Enter the Annual Rate : ");
        R  = sc.nextFloat();
        System.out.println("\nPlease Enter the Time : ");
        T  = sc.nextFloat();
        
        while (check){
            
            System.out.println("\nPlease Enter the respective option for Unit of Time period : "); 
            System.out.println("1. Years");
            System.out.println("2. Months");
            System.out.println("3. Weeks");
            System.out.println("4. Days\n");
            unit  = sc.nextInt(); 
            
            switch(unit){
               case 1:{
                   check = false;
                   break;
               }
              
               case 2:
                {
                   T/=12;
                   check = false;
                   break;
                }
                
                case 3:
                {
                   T/=52;
                   check = false;
                   break;
                }
                

                case 4:
                {
                   T/=365;
                   check = false;
                   break;
                }
                
                default:
                {
                    System.out.println("\nPlease enter a valid option");
                }    
            }
        }

        check = true;
        while (check){

            System.out.println("\nPlease Enter the respective option for the calculation you wish to perform : "); 
            System.out.println("1. Simple Interest");
            System.out.println("2. Compound Interest");
            System.out.println("3. EMI");
            System.out.println("4. EXIT\n");
            option  = sc.nextInt(); 
            
            switch(option)
            {
                // simple interest
                case 1:
                {
                    si(P,R,T);
                    break;
                }
                
                // compound interest
                case 2:
                {
                    System.out.println("\nEnter the compounding period: ");
                    N = sc.nextInt();
                    ci(P,R,T,N);
                    break;
                }

                // EMI
                case 3:
                {
                    emi(P,R,T);
                    break;
                    // return (emi);
                }

                case 4:
                {   System.out.println("-----------------------------------------------------------");
                    System.out.println("\nTHANK YOU !\n");
                    System.out.println("-----------------------------------------------------------");
                    check = false;
                    break;
                }

                default:
                {
                    System.out.println("\nPlease enter a valid option");
                } 
            }
        }
    }
}