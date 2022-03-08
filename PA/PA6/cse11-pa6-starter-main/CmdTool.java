import java.util.*;

interface Command{
    String[] execute(String[] data);
}

class CmdTool{
    public static void main(String[] args) {
        if(args[0].equals("-l") || args[0].equals("-list")) {
            Command[] cmds = processCmdList(args);
            Command cmdList = new CmdList(cmds);
            printArray(cmdList.execute(processCmdData(args)));
        } else {
            Command cmd = processCmd(args);
            printArray(cmd.execute(processCmdData(args)));
        }
    }

    // Helper methods
    public static void printArray(String[] data) {
        String toPrint = Arrays.toString(data);
        toPrint = toPrint.substring(1, toPrint.length() - 1).replaceAll(",", "");
        System.out.println(toPrint);
    }

    public static int countOpts(String[] args) {
        int nOpts = 0;
        for(int i = 0; i < args.length; i ++) {
            if(args[i].equals("sum") || args[i].equals("product") || args[i].equals("mean") || args[i].equals("max") ||
            args[i].equals("min") || args[i].equals("count") || args[i].equals("positive") || args[i].equals("negative") ||
            args[i].equals("greater") || args[i].equals("lesser") || args[i].equals("equal") || args[i].equals("-l") ||
            args[i].equals("-list")) {
                nOpts ++;
            }
            if(i > 0 && (args[i - 1].equals("greater") || args[i - 1].equals("lesser") || args[i - 1].equals("equal"))) {
                nOpts ++;
            }
        }
        return nOpts;
    }

    public static int countCmds(String[] args) {
        int nCmds = 0;
        for(int i = 0; i < args.length; i ++) {
            if(args[i].equals("sum") || args[i].equals("product") || args[i].equals("mean") || args[i].equals("max") ||
            args[i].equals("min") || args[i].equals("count") || args[i].equals("positive") || args[i].equals("negative") ||
            args[i].equals("greater") || args[i].equals("lesser") || args[i].equals("equal")) {
                nCmds ++;
            }
        }
        return nCmds;
    }

    public static String[] processCmdData(String[] args) {
        String[] data = Arrays.copyOfRange(args, countOpts(args), args.length);
        return data;
    }

    public static Command processCmd(String[] args) {
        if(args[0].equals("sum")) {
            Sum cmd = new Sum();
            return cmd;
        } else if(args[0].equals("product")) {
            Product cmd = new Product();
            return cmd;
        } else if(args[0].equals("mean")) {
            Mean cmd = new Mean();
            return cmd;
        } else if(args[0].equals("max")) {
            Max cmd = new Max();
            return cmd;
        } else if(args[0].equals("min")) {
            Min cmd = new Min();
            return cmd;
        } else if(args[0].equals("count")) {
            Count cmd = new Count();
            return cmd;
        } else if(args[0].equals("positive")) {
            Positive cmd = new Positive();
            return cmd;
        } else if(args[0].equals("negative")) {
            Negative cmd = new Negative();
            return cmd;
        } else if(args[0].equals("greater")) {
            Greater cmd = new Greater(args[1]);
            return cmd;
        } else if(args[0].equals("lesser")) {
            Lesser cmd = new Lesser(args[1]);
            return cmd;
        } else {
            Equal cmd = new Equal(args[1]);
            return cmd;
        }
    }

    public static Command[] processCmdList(String[] args) {
        Command[] cmdList = new Command[countCmds(args)];
        int t = 0;
        for(int i = 1; i < countOpts(args); i ++) {
            if(args[i].equals("sum") || args[i].equals("product") || args[i].equals("mean") || args[i].equals("max") ||
            args[i].equals("min") || args[i].equals("count") || args[i].equals("positive") || args[i].equals("negative") ||
            args[i].equals("greater") || args[i].equals("lesser") || args[i].equals("equal")) {
                cmdList[t] = processCmd(Arrays.copyOfRange(args, i, args.length));
                t ++;
            }
        }
        return cmdList;
    }
}

// Part 1
class Sum implements Command {
    public String[] execute(String[] data) {
        int sum = 0;
        for(String s : data) {
            sum += Integer.valueOf(s);
        }
        String[] summed = new String[] {String.valueOf(sum)};
        return summed;
    }
}

class Product implements Command {
    public String[] execute(String[] data) {
        int product = 1;
        for(String s : data) {
            product *= Integer.valueOf(s);
        }
        String[] multiplied = new String[] {String.valueOf(product)};
        return multiplied;
    }
}

class Mean implements Command {
    public String[] execute(String[] data) {
        double sum = 0;
        for(String s : data) {
            sum += Double.valueOf(s);
        }

        double mean = 0;
        if(data.length != 0) {
            mean = sum/data.length;
        }

        String[] averaged = new String[] {String.valueOf(mean)};
        return averaged;
    }
}

class Max implements Command {
    public String[] execute(String[] data) {
        int max = Integer.valueOf(data[0]);
        for(String s : data) {
            if(Integer.valueOf(s) > max) {
                max = Integer.valueOf(s);
            }
        }

        if(data.length == 0) {
            String[] maxFound = new String[]{};
            return maxFound;
        } else {
            String[] maxFound = new String[]{String.valueOf(max)};
            return maxFound;
        }
    }
}

class Min implements Command {
    public String[] execute(String[] data) {
        int min = Integer.valueOf(data[0]);
        for(String s : data) {
            if(Integer.valueOf(s) < min) {
                min = Integer.valueOf(s);
            }
        }

        if(data.length == 0) {
            String[] minFound = new String[]{};
            return minFound;
        } else {
            String[] minFound = new String[]{String.valueOf(min)};
            return minFound;
        }
    }
}

class Count implements Command {
    public String[] execute(String[] data) {
        int count = data.length;
        String[] counted = new String[]{String.valueOf(count)};
        return counted;
    }
}

class Positive implements Command {
    public String[] execute(String[] data) {
        List<String> pos = new ArrayList<String>();
        for(String s : data) {
            if(Integer.parseInt(s) > 0) {
                pos.add(s);
            }
        }
        String[] posFound = new String[pos.size()];
        posFound = pos.toArray(posFound);
        return posFound;
    }
}

class Negative implements Command {
    public String[] execute(String[] data) {
        List<String> neg = new ArrayList<String>();
        for(String s : data) {
            if(Integer.parseInt(s) < 0) {
                neg.add(s);
            }
        }
        String[] negFound = new String[neg.size()];
        negFound = neg.toArray(negFound);
        return negFound;
    }
}

// Part 2
class Greater implements Command {
    String n;

    Greater(String n) {
        this.n = n;
    }

    public String[] execute(String[] data) {
        List<String> greater = new ArrayList<String>();
        for(String s : data) {
            if(Integer.parseInt(s) > Integer.parseInt(this.n)) {
                greater.add(s);
            }
        }
        String[] greaterFound = new String[greater.size()];
        greaterFound = greater.toArray(greaterFound);
        return greaterFound;
    }
}

class Lesser implements Command {
    String n;

    Lesser(String n) {
        this.n = n;
    }

    public String[] execute(String[] data) {
        List<String> lesser = new ArrayList<String>();
        for(String s : data) {
            if(Integer.parseInt(s) < Integer.parseInt(this.n)) {
                lesser.add(s);
            }
        }
        String[] lesserFound = new String[lesser.size()];
        lesserFound = lesser.toArray(lesserFound);
        return lesserFound;
    }
}

class Equal implements Command {
    String n;

    Equal(String n) {
        this.n = n;
    }

    public String[] execute(String[] data) {
        List<String> equal = new ArrayList<String>();
        for(String s : data) {
            if(s.equals(this.n)) {
                equal.add(s);
            }
        }
        String[] equalFound = new String[equal.size()];
        equalFound = equal.toArray(equalFound);
        return equalFound;
    }
}

// Part 3
class CmdList implements Command {
    Command[] cmdList;

    CmdList(Command[] cmdList) {
        this.cmdList = cmdList;
    }

    public String[] execute(String[] data) {
        String[] currentData = data;
        for(Command c : this.cmdList) {
            currentData = c.execute(currentData);
        }
        return currentData;
    }
}

/*
        Command[] cmdList = new Command[countCmds(args)];
        cmdList[0] = processCmd(Arrays.copyOfRange(args, 1, args.length));
        String[] currentData = cmdList[0].execute(processCmdData(args));
        int t = 0;
        t ++;
        for(int i = 2; i < countOpts(args); i ++) {
            if(args[i] == "sum" || args[i] == "product" || args[i] == "mean" || args[i] == "max" ||
                args[i] == "min" || args[i] == "count" || args[i] == "positive" || args[i] == "negative") {
                String[] currentArgs = new String[currentData.length + 1];
                currentArgs[0] = args[i];
                for(int j = 0; j < currentData.length; j ++) { // Create current args array based on previous output
                    currentArgs[j + 2] = currentData[j];
                }
                cmdList[t] = processCmd(currentArgs); // Store cmd
                currentData = cmdList[t].execute(currentData); // Store new cmd output
            } else if(args[i] == "greater" || args[i] == "lesser" || args[i] == "equal") {
                String[] currentArgs = new String[currentData.length + 2];
                currentArgs[0] = args[i];
                currentArgs[1] = args[i + 1];
                for(int j = 0; j < currentData.length; j ++) { // Create current args array based on previous output
                    currentArgs[j + 2] = currentData[j];
                }
                cmdList[t] = processCmd(currentArgs); // Store cmd
                currentData = cmdList[t].execute(currentData); // Store new cmd output
            }
        }
*/