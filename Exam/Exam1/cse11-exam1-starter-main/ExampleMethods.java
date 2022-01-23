import tester.*;

class ExampleMethods {

    // Method 1
    String timeAfterWait(int hour, int minute, int tPassed){
        if ((minute + tPassed) >= 0){
            if ((hour + (minute + tPassed)/60)%24 < 10 && ((minute + tPassed)%60) < 10){
                return "0" + (hour + (minute + tPassed)/60)%24 + ":0" + ((minute + tPassed)%60);
            } else if((hour + (minute + tPassed)/60)%24 < 10){
                return "0" + (hour + (minute + tPassed)/60)%24 + ":" + ((minute + tPassed)%60);
            } else if(((minute + tPassed)%60) < 10){
                return (hour + (minute + tPassed)/60)%24 + ":0" + ((minute + tPassed)%60);
            } else {
                return (hour + (minute + tPassed)/60)%24 + ":" + ((minute + tPassed)%60);
            }
        } else {
            if (((hour + (minute + tPassed)/60)%24 - 1) > 0){
                if (((hour + (minute + tPassed)/60)%24 - 1) < 10 && (60 + (minute + tPassed)%60) < 10){
                    if ((minute + tPassed)%60 == 0){
                        return "0" + ((hour + (minute + tPassed)/60)%24) + ":0" + (minute + tPassed)%60;
                    } else {
                        return "0" + ((hour + (minute + tPassed)/60)%24 - 1) + ":0" + (60 + (minute + tPassed)%60);
                    }
                } else if (((hour + (minute + tPassed)/60)%24 - 1) < 10){
                    if ((minute + tPassed)%60 == 0){
                        return "0" + (hour + (minute + tPassed)/60)%24 + ":" + (minute + tPassed)%60;
                    } else {
                        return "0" + ((hour + (minute + tPassed)/60)%24 -1) + ":" + (60 + (minute + tPassed)%60);
                    }
                } else if ((60 + (minute + tPassed)%60) < 10){
                    if ((minute + tPassed)%60 == 0){
                        return (hour + (minute + tPassed)/60)%24 + ":0" + (minute + tPassed)%60;
                    } else {
                        return ((hour + (minute + tPassed)/60)%24 - 1) + ":0" + (60 + (minute + tPassed)%60);
                    }
                } else {
                    if ((minute + tPassed)%60 == 0){
                        return (hour + (minute + tPassed)/60)%24 + ":0" + (minute + tPassed)%60;
                    } else {
                        return ((hour + (minute + tPassed)/60)%24 - 1) + ":" + (60 + (minute + tPassed)%60);
                    }
                }
            } else {
                if ((24 + ((hour + (minute + tPassed)/60)%24 - 1)) < 10 && (60 + (minute + tPassed)%60) < 10){
                    if ((minute + tPassed)%60 == 0){
                        return "0" + (24 + (hour + (minute + tPassed)/60)%24) + ":0" + (minute + tPassed)%60;
                    } else {
                        return "0" + (24 + ((hour + (minute + tPassed)/60)%24 - 1)) + ":0" + (60 + (minute + tPassed)%60);
                    }
                } else if ((24 + ((hour + (minute + tPassed)/60)%24 - 1)) < 10){
                    if ((minute + tPassed)%60 == 0){
                        return "0" + (24 + (hour + (minute + tPassed)/60)%24) + ":" + (minute + tPassed)%60;
                    } else {
                        return "0" + (24 + ((hour + (minute + tPassed)/60)%24 - 1)) + ":" + (60 + (minute + tPassed)%60);
                    }
                } else if ((60 + (minute + tPassed)%60) < 10){
                    if ((minute + tPassed)%60 == 0){
                        return (24 + (hour + (minute + tPassed)/60)%24) + ":0" + (minute + tPassed)%60;
                    } else {
                        return (24 + ((hour + (minute + tPassed)/60)%24 - 1)) + ":0" + (60 + (minute + tPassed)%60);
                    }
                } else {
                    if ((minute + tPassed)%60 == 0){
                        return (24 + (hour + (minute + tPassed)/60)%24) + ":0" + (minute + tPassed)%60;
                    } else {
                        return (24 + ((hour + (minute + tPassed)/60)%24 - 1)) + ":" + (minute + tPassed)%60;
                    }
                }
            }
        }
    }

    // Test 1
    String ETA1 = this.timeAfterWait(23, 30, 20);

    // Method 2
    String flipString(String str, String delim){
        if (str.contains(delim)){
            return str.substring((str.indexOf(delim)+1), str.length()) + delim + str.substring(0, str.indexOf(delim));
        } else {
            return str;
        }
    }

    // Test 2
    String lastBeforeFirst = this.flipString("John Hopfield", " ");
    String randomTest = this.flipString("Google.com", ".");
}
