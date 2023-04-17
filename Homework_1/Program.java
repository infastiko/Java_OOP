package Homework_1;

public class Program {
    public static void main(String[] args) throws Exception {
        var alina = new Person("Alina", 50);
        var vasya = new Person("Vasiy", 55);
        var masha = new Person("Masha", 30);
        var janya = new Person("Jenya", 20);
        var oleg = new Person("Oleg", 15);
        var igor = new Person( "Igor", 52 );

        GeoTree gt = new GeoTree();
        gt.append(alina, masha);
        gt.append(alina, janya);
        gt.append(vasya, janya);
        gt.append(vasya, oleg);
        gt.append( igor, masha );

        System.out.println(new Research( gt ).findChildren( vasya));
        System.out.println(new Research( gt ).findParent( masha ));

        Printer p1 = new Printer();
        p1.print("Print in console with class Printer -> " + new Research( gt ).findParent( masha ) );
        p1.saveFile(  new Research( gt ).findChildren( vasya));
    }
}
