import tester.*;

class FinalPart2_Sanity {
    void testMode(Tester t) {
        Mode m = new Mode();
        t.checkExpect(1, m.mode(new int[]{1,2,3,3,2,1,1}));
    }

    void testToText(Tester t) {
        Point p = new Point(1,1);
        
        Region r1 = new RectRegion(p, p);
        Region r2 = new CircleRegion(p, 1);
        Region r3 = new UnionRegion(r2, r1);
        Region r4 = new IntersectRegion(r3, r2);

        t.checkExpect("Rectangle", r1.toText());
        t.checkExpect("Circle", r2.toText());
        t.checkExpect("Union(Circle, Rectangle)", r3.toText());
        t.checkExpect("Intersect(Union(Circle, Rectangle), Circle)", r4.toText());
    }
}

// Testing Prime
// java Prime 1 2 3 4 5 6 7 8 9
// 1
// 2
// 3
// 5
// 7