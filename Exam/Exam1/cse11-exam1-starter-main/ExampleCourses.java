import tester.*;

class Time {
    int hh;
    int mm;

    Time(int hh, int mm){
        this.hh = hh;
        this.mm = mm;
    }
}

class Course {
    String courseName;
    Time startTime;
    Time endTime;

    Course(String courseName, Time startTime, Time endTime){
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    int shiftToRemoveOverlap(Course other){
        if((other.startTime.hh*60 + other.startTime.mm) > (this.endTime.hh*60 + this.endTime.mm) || (this.startTime.hh*60 + this.startTime.mm) > (other.endTime.hh*60 + other.endTime.mm)){
            if((this.endTime.hh*60 + this.endTime.mm) < (this.startTime.hh*60 + this.startTime.mm) && (other.endTime.hh*60 + other.endTime.mm) < (other.startTime.hh*60 + other.startTime.mm)){
                if((((this.endTime.hh+24)*60 + this.endTime.mm) - (other.startTime.hh*60 + other.startTime.mm)) < (((other.endTime.hh+24)*60 + other.endTime.mm) - (this.startTime.hh*60 + this.startTime.mm))){
                    return ((this.endTime.hh+24)*60 + this.endTime.mm) - (other.startTime.hh*60 + other.startTime.mm);
                } else {
                    return ((other.endTime.hh+24)*60 + other.endTime.mm) - (this.startTime.hh*60 + this.startTime.mm);
                }
            } else {
                return 0;
            }
        } else {
            if((this.endTime.hh*60 + this.endTime.mm) < (this.startTime.hh*60 + this.startTime.mm)){
                if((((this.endTime.hh+24)*60 + this.endTime.mm) - ((other.startTime.hh+24)*60 + other.startTime.mm)) < (((other.endTime.hh+24)*60 + other.endTime.mm) - (this.startTime.hh*60 + this.startTime.mm))){
                    return ((this.endTime.hh+24)*60 + this.endTime.mm) - ((other.startTime.hh+24)*60 + other.startTime.mm);
                } else {
                    return ((other.endTime.hh+24)*60 + other.endTime.mm) - (this.startTime.hh*60 + this.startTime.mm);
                }
            } else if ((other.endTime.hh*60 + other.endTime.mm) < (other.startTime.hh*60 + other.startTime.mm)){
                if((((this.endTime.hh+24)*60 + this.endTime.mm) - (other.startTime.hh*60 + other.startTime.mm)) < (((other.endTime.hh+24)*60 + other.endTime.mm) - ((this.startTime.hh+24)*60 + this.startTime.mm))){
                    return ((this.endTime.hh+24)*60 + this.endTime.mm) - (other.startTime.hh*60 + other.startTime.mm);
                } else {
                    return ((other.endTime.hh+24)*60 + other.endTime.mm) - ((this.startTime.hh+24)*60 + this.startTime.mm);
                }
            } else {
                if((this.startTime.hh*60 + this.startTime.mm) < (other.startTime.hh*60 + other.startTime.mm) && (this.endTime.hh*60 + this.endTime.mm) > (other.endTime.hh*60 + other.endTime.mm)){
                    return (other.endTime.hh*60 + other.endTime.mm) - (other.startTime.hh*60 + other.startTime.mm);
                } else if((this.startTime.hh*60 + this.startTime.mm) < (other.startTime.hh*60 + other.startTime.mm) && (this.endTime.hh*60 + this.endTime.mm) < (other.endTime.hh*60 + other.endTime.mm)){
                    return (this.endTime.hh*60 + this.endTime.mm) - (other.startTime.hh*60 + other.startTime.mm);
                } else if((this.startTime.hh*60 + this.startTime.mm) > (other.startTime.hh*60 + other.startTime.mm) && (this.endTime.hh*60 + this.endTime.mm) > (other.endTime.hh*60 + other.endTime.mm)){
                    return (other.endTime.hh*60 + other.endTime.mm) - (this.startTime.hh*60 + this.startTime.mm);
                } else {
                    return (this.endTime.hh*60 + this.endTime.mm) - (this.startTime.hh*60 + this.startTime.mm);
                }
            }
        }
    }

    int timeBetween(Course other){
        if((other.startTime.hh*60 + other.startTime.mm) > (this.endTime.hh*60 + this.endTime.mm) || (this.startTime.hh*60 + this.startTime.mm) > (other.endTime.hh*60 + other.endTime.mm)){
            if((this.endTime.hh*60 + this.endTime.mm) < (this.startTime.hh*60 + this.startTime.mm) && (other.endTime.hh*60 + other.endTime.mm) < (other.startTime.hh*60 + other.startTime.mm)){
                return 0;
            } else if((this.endTime.hh*60 + this.endTime.mm) < (this.startTime.hh*60 + this.startTime.mm)){
                return (other.startTime.hh*60 + other.startTime.mm) - (this.endTime.hh*60 + this.endTime.mm);
            } else if((other.endTime.hh*60 + other.endTime.mm) < (other.startTime.hh*60 + other.startTime.mm)){
                return (this.startTime.hh*60 + this.startTime.mm) - (other.endTime.hh*60 + other.endTime.mm);
            } else {
                if ((this.endTime.hh*60 + this.endTime.mm) < (other.startTime.hh*60 + other.startTime.mm)){
                    return (other.startTime.hh*60 + other.startTime.mm) - (this.endTime.hh*60 + this.endTime.mm);
                } else {
                    return (this.startTime.hh*60 + this.startTime.mm) - (other.endTime.hh*60 + other.endTime.mm);
                }
            }
        } else {
            return 0;
        }
    }
}

class ExampleCourses {

    // Courses A and B
    Time aStarts = new Time(10, 50);
    Time aEnds = new Time(11, 40);
    Course courseA = new Course("Course A", aStarts, aEnds);
    Time bStarts = new Time(11, 00);
    Time bEnds = new Time(11, 50);
    Course courseB = new Course("Course B", bStarts, bEnds);

    
    int overlapAB = this.courseA.shiftToRemoveOverlap(courseB);
    int betweenAB = this.courseA.timeBetween(courseB);

    // Courses C and D
    Time cStarts = new Time(10, 50);
    Time cEnds = new Time(11, 40);
    Course courseC = new Course("Course C", cStarts, cEnds);
    Time dStarts = new Time(8, 00);
    Time dEnds = new Time(9, 50);
    Course courseD = new Course("Course D", dStarts, dEnds);

    
    int overlapCD = this.courseC.shiftToRemoveOverlap(courseD);
    int betweenCD = this.courseC.timeBetween(courseD);

    // Courses E and F
    Time eStarts = new Time(23, 30);
    Time eEnds = new Time(1, 30);
    Course courseE = new Course("Course E", eStarts, eEnds);
    Time fStarts = new Time(1, 00);
    Time fEnds = new Time(2, 00);
    Course courseF = new Course("Course F", fStarts, fEnds);

    int overlapEF = this.courseE.shiftToRemoveOverlap(courseF);
    int betweenEF = this.courseE.timeBetween(courseF);
}