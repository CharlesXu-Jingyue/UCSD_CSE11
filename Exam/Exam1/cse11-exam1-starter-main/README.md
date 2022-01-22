---
layout: with-sidebar
index: 3
name: Exam 1
released-on: "2021-01-21"
---
# Exam 1

### Release: 10am Friday January 21, 2021
### Due: 10pm Saturday January 22, 2021

**Note that this is released after class Friday, and is due the next day in the evening. We will not accept late submissions.**

This page details a take-home exam that you will complete over the next 
day. You can’t communicate with anyone about the content of the assignment
until the exam ends. You can message us privately on Piazza, but the
course staff will not give programming advice or answer most questions about the
problems. If you have technical trouble creating a screencast (detailed below)
feel free to reach out for assistance.

Do not use any online service other than Piazza to ask questions about the
assignment. Do not search for, solicit, or use solutions to the problems that
you find elsewhere for the exam. These are all violations of academic integrity
that students have committed on exams like this in the past.

You can make use of any course notes, online resources about Java and its
libraries, Java tools, and so on to complete the exam, including re-using code
from class notes.

You can review the grading policy for exams in the [syllabus](https://ucsd-cse11-w22.github.io/syllabus.html).
You will complete the programming task below and submit your work to the `Exam 1` Gradescope assignment.

Submission checklist (see long descriptions below for full details):

- [ ] `ExampleMethods.java` containing methods for Task 1
- [ ] `ExampleCourses.java` containing code for Task 2
- [ ] `video.mp4` (or another video extension) that has your screencast for Task 3

Your submission will be graded **after** the deadline. You should test thoroughly yourself to make sure your program works as expected.

## Clarifications

**Can I use a Java feature/library/method that we haven't covered in class?**

No. Strive to create a solution that only uses concepts covered so far in the course.

**I can't get my code to run on my computer.**

Ideally, you should have already solved this issue as we are running programs the same way as PA1 and PA2. But you may try reviewing the
previous public Piazza posts, which have lots of advice about fixing these
situations. Also make sure that your code doesn't have a bug before you blame
your computer or `./run`!

**I get a score of 0.0/0.0 on autograder.**

This is expected, we will reveal scores after the exam has concluded.

**It says the autograder didn't run successfully.**
 
Make sure that your code has no errors and you match the specification for **ALL** classes and method headers exactly.

**Can I submit multiple times until the deadline?**

Yes, we will grade the last submission you make before the deadline.

## Tasks

You can find the starter code in this repository [https://github.com/ucsd-cse11-w22/cse11-exam1-starter](https://github.com/ucsd-cse11-w22/cse11-exam1-starter).

For all tasks, do not make any assumptions besides the ones explicitly mentioned. You may assume all objects will be non-null.

### Task 1

In the `ExampleMethods` class, you will use the design recipe to write two methods:

- `timeAfterWait`, which takes two non-negative `int` parameters, one `int` parameter and returns a `String`. The first two parameters will represent the hour and minutes, respectively, of the start time. The third parameter will represent the amount of time, in minutes, that have passed. The result may be before, the same, or after the start time. You will return the time after waiting the specified amount of time as a string in the form of `hh:mm`. Be aware of the different times of time rollover. 

    You will use 24-hour time (Military time) to denote times. Refer to this for more information: https://en.wikipedia.org/wiki/24-hour_clock

    You may assume only valid start times.

    ```
    Example:
    
    Start: 9:15 | Duration: 15 | Result: "09:30" 
    ```

- `flipString`, which takes two `String` parameters and returns a `String`. The first is the actual string, `str`, that will be flipped and the second is string containing a delimeter, `delim`. If `str` contains `delim`, then you will flip the string around the first occurrence of `delim`. If `str` does not contain `delim`, then you will return `str`.

    ```
    Example:

    Str: "cse 11" | delim: " " | Result: "11 cse"
    ```

You are welcome to add _any number_ of additional methods to help with your implementation.

You can add tests in the provided `ExampleMethods` class.

### Task 2

The file `ExampleCourses.java` you will be writing 2 classes and 2 methods.

You will add 2 classes:

- A new class `Course` that represents a course. A `Course` object will take a `String` name, and 2 `Time` objects which denote the start and end time of the course in that order.
- A new class `Time` that represents a time. A `Time` object will take 2 `int` parameters which denote hour and minutes in 24-hour time.

Additionally, you will add 2 methods to `Course`.

- A new method called `shiftToRemoveOverlap` that takes 1 `Course` parameter and returns a `int` representing the least amount of time needed to shift a single course such that there is no overlap between the two. You will return `0` if there is any overlap between `this` course and course given as an argument, otherwise return the amount of time, in minutes, needed to shift.

    ```
    Example:

    CSE 11: 9:00 - 9:50
    CSE 12: 9:30 - 10:50

    Result: 20
    ```

- A new method called `timeBetween` take takes 1 `Course` parameter and returns an `int` representing the amount of time, in minutes, between `this` course and the course given as an argument. If the courses overlap, return `0`, else return the time between the earlier course and the later course.
    ```
    Example:

    CSE 11: 9:00 - 9:50
    CSE 12: 10:00 - 11:20

    Result: 10
    ```
You may assume that both courses occur at valid times. Make no assumptions about when courses start or end.

 

You are welcome to add _any number_ of additional methods to help with your implementation.

You may add tests in the provided `ExampleCourses` class.

### Implementation Suggestions for Task 2

1. Helper methods

    You may find it helpful to add several helper methods to help with your implementation for Task 2. Here are three that you may find helpful to use.

    ```
    Course: 
    // return true if there is overlap between this and other course
    boolean overlap(Course c);

    Time:
    // return true if this time is before other time
    boolean before(Time t);

    // return time between this time and other time
    int between(Time t);
    ```

2. Types of overlap
    
    Be aware of the 4 types of overlap

    1. Course 1 ends after Course 2 starts. 
        
        Ex: 9am - 10am and 9:30am - 10am
    2. Course 1 starts and ends after Course 2 starts and ends

        Ex: 9am - 10am and 9:15am - 9:45am
    3. Course 1 starts after Course 2 starts and ends before Course 2 ends

        Ex: 9:15am - 9:45am and 9am - 10am
    4. Course 1 starts before Course 2 ends

        Ex: 9:30am - 10:30am and 9am - 10am

    If Courses share a time boundary, they are not considered overlapping. 

    Ex: 9am - 10am and 10am - 11am are two non-overlapping courses


3. Courses starting and ending on different days

    Be aware that a course may start and end on different days. This may apply to 0, 1, or 2 courses when calling both `shiftToRemoveOverlap` and `timeBetween`.

    Ex: 11pm - 2am is a valid course time.


### Task 3 – Video
You will record a short video of no more than 5 minutes. Include:

- Show only your face and a picture ID (your student ID is preferred but any picture ID with your name on it will work) for a few seconds at the beginning. Be sure state your name as well. You don’t have to be on camera the whole time, though it’s fine if you are. Just a brief confirmation that it’s you creating the video/doing the work attached to the work itself is what we want. If you do not have a webcam, take a picture of yourself (and your picture ID) with your phone and display that picture at the start of your screen share.

Your task:
- Choose two examples for your `flipString` method, one where the delimeter is contained in the string and one where the delimeter is not contained in the string. For each, trace through the code by showing which return statement in your program runs and what value is returned by that statement. Leave a comment in the code indicating which return statement ran and the expected value for each example.
- Trace the example you wrote for `timeBetween` where the two courses do not overlap and at least 1 course starts and ends on different days. Highlight with your mouse each line that runs.

An example of what your video should look like when doing this kind of explanation is here:

[https://drive.google.com/file/d/117NfZaHXbHtMJZJmLRVeRy-1b9cY3jei/view?usp=sharing](https://drive.google.com/file/d/117NfZaHXbHtMJZJmLRVeRy-1b9cY3jei/view?usp=sharing)

PA2 has a tutorial for creating a screencast like this [https://ucsd-cse11-w22.github.io/assignments/pa2.html](https://ucsd-cse11-w22.github.io/assignments/pa2.html).

Here are some notes on how to improve your videos:

- Make sure to use a picture ID, either a student ID _with a photo_, a driver's license, or passport that has a picture of you. If you do not provide a picture ID, you may get a 0 on the exam until prove to us it was you who did the video.
- Make sure your picture ID and face are visible at the same time for three or four seconds. We must be able to pause the video and verify it's you. Again, if we can't verify it's you, you will get a 0 on the exam until prove to us it was you who did the video. Make sure to fill up the screen as much as possible with your face and picture id (i.e. don't stand far away from your camera).
- When you start recording your video, start with screen share off and camera on and show your picture ID and face (close-up!!). Then you can enable screen share (and disable camera) and walk through your code.
- Video must have sound! While highlighting your code, also make sure to explain the code. We must hear you explain it!
- Once you enable screen share, make sure to leave it on the entire time while explaining your code.
- Do not explain every test case! Only explain what you are explicitly told in the tasks above.
- Keep your videos under 5 minutes; videos even a second over 5 minutes will get a `0` on the video part, this is to ensure we can grade them promptly. To ensure you stay under 5 minutes, make sure to only explain what is described above, and do a few practices or make a script before you start recording.
