import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria Fatu
 */
public class Plants  {
 
       public static double[] sorting(double[] arr,int k,String [] type,String[] typek,int n){
         int count=0,j;
         String[] typeClone=new String[n];
         System.arraycopy(type, 0, typeClone, 0, n);
         
         for (int i = 0; i < arr.length; i++){   
            if(count==k)
                break;
            int index = i;
            
            for (j = i+1 ; j < arr.length; j++)
                if ((Math.abs(arr[j]-arr[index]))<0.01||arr[j] < arr[index]) 
                    index = j;
                typek[count]=type[index];

                double aux1 = arr[index];
                arr[index] = arr[i];
                arr[i] = aux1;

                String aux2=type[index];
                type[index]=type[i];
                type[i]=aux2;

            count++;
            
        }
        
           System.arraycopy(typeClone, 0, type, 0, n);
        return arr;
    }
     
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int n=0;
        int m=0;
        int k=0;
        int count;
        double score,tbSq,max;
        int countA,countB;
        int[][] known=new int[n][3];
        int[][] unknown=new int[n][3];
        double [] similarity = null;
        String [] type = null;
        String[]typek=null;
        BufferedWriter fw;
        fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("plants.out")));
        
        try (Scanner S = new Scanner((new FileReader("plants.in")))) {
                n=S.nextInt();
                m=S.nextInt();
                k=S.nextInt();
                known=new int[n][3];
                unknown=new int[m][3];
                type=new String[n];
                similarity=new double[n];
                typek=new String[k];
                for(int i=0;i<n;i++){
                    for(int j=0;j<3;j++)
                        known[i][j]=S.nextInt();
                    type[i]=S.next();
                }  
                
                for(int i=0;i<m;i++){
                    for(int j=0;j<3;j++)
                        unknown[i][j]=S.nextInt();
                }
         
        }catch (IOException ex) {
			Logger.getLogger(Plants.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               tbSq=(unknown[i][0]-known[j][0])*(unknown[i][0]-known[j][0])+(unknown[i][1]-known[j][1])*(unknown[i][1]-known[j][1])+(unknown[i][2]-known[j][2])*(unknown[i][2]-known[j][2]);
               score=Math.sqrt(tbSq);
               similarity[j]=score;
               
           }

            sorting(similarity,k,type,typek,n);
            count=0;
            countA=countB=0;
         
            while(count<k){
                if(typek[count].equals("A"))
                    countA++;
                else
                    countB++;
            count++;
            }
         
            if(countA<=countB)
                fw.write("Probably B");
            else
                fw.write("Probably A");
        
            fw.newLine();
        
        }
    
  fw.close();  
    }

}
    