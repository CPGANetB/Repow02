import java.awt.List;
import java.util.*;
//Es es Master
public class EjScanner {
    public static void main(String[] arguments) {
        Scanner input = new Scanner(System.in);
        String nombre = "";
        double score = 0;
        int c = 1;
        ArrayList<Participante> arLis = new ArrayList<>();

        //Participante participan = new Participante();

        nombre = "Participantes";
        System.out.println(nombre);

        do {
            Scanner one = new Scanner(System.in);
            System.out.println("Ingrese Nombre (o 0 salir):");
            Participante participan = new Participante();
            nombre = one.next();

            participan.setNombre(nombre);

            if (!nombre.equals("0")) {
                Scanner two = new Scanner(System.in);
                System.out.println("Ingrese Score:");
                score = two.nextDouble();
                participan.setScore(score);
                arLis.add(participan);
                System.out.println("Nombre: " + nombre + " Score: " + score + " ");
                c++;


            }
        } while (!nombre.equals("0"));
        System.out.println("Datos ingresados: " + --c);
        /*
        Comparator comparador = Collections.reverseOrder();
        Collections.sort(arLis, comparador);
*/

        Collections.sort(arLis, new Comparator<Participante>() {

            @Override
            public int compare(Participante p1, Participante p2) {
                // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
                return new Double(p2.getScore()).compareTo(new Double(p1.getScore()));
            }
        });

        // Declaramos el Iterador e imprimimos los Elementos del ArrayList
        Participante elemento;
        Iterator nombreIterator = arLis.iterator();
        System.out.println("Ranking según datos: ");
        while (nombreIterator.hasNext()) {
            elemento = (Participante) nombreIterator.next();
            System.out.print(elemento.getNombre() + " => " + elemento.getScore() + "\n");
        }
        /*Plan B
        for (int i = 0; i < arLis.size(); i++) {
            System.out.println(arLis.get(i).getNombre()+" : "+arLis.get(i).getScore());
        }
        /*
        itrParticipan = participan.iterator();
        while(itrParticipan.hasNext()){
            Participantes parti = itrParticipan.next();
            System.out.println(parti.getNombre() + " "
                    + parti.getScore() + "-");
        } */

    }


    public static class Participante {
        /*
                public Participante() {
                }

                public Participante(String nombre, double score) {
                    this.nombre = nombre;
                    this.score = score;
                }
        */
        String nombre = "";
        double score = 0;

        public String getNombre() {
            return nombre;
        }


        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return this.getNombre() + "  =  " + this.getScore();
        }


    }
}
