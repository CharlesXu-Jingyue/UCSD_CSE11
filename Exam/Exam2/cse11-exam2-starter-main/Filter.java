class Filter {
    // Task 3: Filter
    // Your code here
    public static void main(String[] args) {
        if(args.length > 1) {
            if(args[0].equals("even")) {
                int l = 0;
                for(int i = 1; i < args.length; i++) {
                    if(Integer.parseInt(args[i])%2 == 0) {
                        l++;
                    }
                }
                String[] evenNumbers = new String[l];
                int t = 0;
                for(int i = 1; i < args.length; i++) {
                    if(Integer.parseInt(args[i])%2 == 0) {
                        evenNumbers[t] = args[i];
                        t++;
                    }
                }
                String toString = "";
                for(String s: evenNumbers) {
                    toString += (s + " ");
                }
                toString = toString.substring(0, toString.length() - 1);
                System.out.println(toString);
            } else if(args[0].equals("odd")) {
                int l = 0;
                for(int i = 1; i < args.length; i++) {
                    if(Integer.parseInt(args[i])%2 == 1) {
                        l++;
                    }
                }
                String[] oddNumbers = new String[l];
                int t = 0;
                for(int i = 1; i < args.length; i++) {
                    if(Integer.parseInt(args[i])%2 == 1) {
                        oddNumbers[t] = args[i];
                        t++;
                    }
                }
                String toString = "";
                for(String s: oddNumbers) {
                    toString += (s + " ");
                }
                toString = toString.substring(0, toString.length() - 1);
                System.out.println(toString);
            }
        }
    }
}