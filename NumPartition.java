import java.util.ArrayList;
import java.util.List;

public class NumPartition extends Objective {

     private List<Integer> listOfInteger;

     public NumPartition(List<Integer> listOfInteger){
         this.listOfInteger = listOfInteger;
         this.name = "NumPartition";
         this.lastValue = null;
     }

    public double sumOfIntegerToOne(Data D){
        double sum = 0.0;
        for (int i = 0; i < D.numberOfBits(); i++){
            if (D.getCurrentBit() == 1){
                sum += this.listOfInteger.get(D.getCurrentBitPointer());
            }
            D.moveToNextBit();
        }
        return sum;
    }

    public double sumOfIntegerToZero(Data D){
        double sum = 0.0;
        for (int i = 0; i < D.numberOfBits(); i++){
            if (D.getCurrentBit() == 0){
                sum += this.listOfInteger.get(D.getCurrentBitPointer());
            }
            D.moveToNextBit();
        }
        return sum;
    }

    @Override
    public Data solutionSample() {
        return new Data(listOfInteger.size(), 0.5);
    }

    @Override
    public double value(Data D) {
         this.lastValue = Math.abs(sumOfIntegerToOne(D) - sumOfIntegerToZero(D));
        return this.lastValue;
    }

    public static void main(String[] args){

         List<Integer> listOfInteger = new ArrayList<>();
         listOfInteger.add(3);
         listOfInteger.add(1);
         listOfInteger.add(1);
         listOfInteger.add(2);
         listOfInteger.add(2);
         listOfInteger.add(1);

         NumPartition numPartition = new NumPartition(listOfInteger);
         Data D = numPartition.solutionSample();

         System.out.println(numPartition);
         System.out.println("Sample solution : " + D);
         System.out.println("evaluating the objective function in the sample solution : "
                            + numPartition.value(D));
         System.out.println(numPartition);
    }
}
