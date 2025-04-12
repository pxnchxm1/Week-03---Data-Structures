public class CompareBufferBuilder {

    public static long builderTime(String s){
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return System.nanoTime() - startTime;
    }
    public static long bufferTime(String s){
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        sbf.append(s);
        return System.nanoTime() - startTime;
    }
    public static void main(String[] args) {
        String s = "hello world";
        long time1 = builderTime(s);
        long time2 = bufferTime(s);
        System.out.println("Time taken by StringBuilder is "+ time1);
        System.out.println("Time taken by StringBuffer is "+ time2);
        if(time1>time2){
            System.out.println("StringBuffer is faster");
        }else{
            System.out.println("StringBuilder is faster");
        }
    }
}
