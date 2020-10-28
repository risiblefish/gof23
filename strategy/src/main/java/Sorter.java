/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-23 22:16
 **/

public class Sorter {
    public void sort(int[] a) {
        for(int i = 0 ; i < a.length ; i++) {
            int minIndex = i;
            for(int j = i+1; j < a.length ; j++) {
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(Dog[] a) {
        for(int i = 0 ; i < a.length ; i++) {
            int minIndex = i;
            for(int j = i+1; j < a.length ; j++) {
                if(a[j].getWeight() <  a[minIndex].getWeight()){
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
        }
    }
    private void swap(Dog[] a, int i, int j) {
        Dog temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(Comparable[] a) {
        for(int i = 0 ; i < a.length ; i++) {
            int minIndex = i;
            for(int j = i+1; j < a.length ; j++) {
                if(a[j].compareTo(a[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
        }
    }
    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
