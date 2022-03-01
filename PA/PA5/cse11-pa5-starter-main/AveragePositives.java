class AveragePositives {
    public static void main(String[] args) {
        double sum = 0;
        int nPositive = 0;
        for(int i = 0; i < args.length; i ++) {
            if(Double.parseDouble(args[i]) > 0) {
                sum += Double.parseDouble(args[i]);
                nPositive ++;
            }
        }
        if(nPositive == 0) {
            System.out.println(0);
        } else {
            double mean = sum/nPositive;
            System.out.println(mean);
        }
    }
}