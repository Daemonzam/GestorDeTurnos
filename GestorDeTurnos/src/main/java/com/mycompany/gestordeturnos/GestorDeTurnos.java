
package com.mycompany.gestordeturnos;

import controladores.ControlMetodos;
import java.util.List;
import java.util.Scanner;

public class GestorDeTurnos {

    public static void main(String[] args) {
        ControlMetodos control = new ControlMetodos();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Agregar veterinario");
            System.out.println("3. Agregar turno");
            System.out.println("4. Confirmar turno");
            System.out.println("5. Salir");
            System.out.print("Ingrese el número de la opción deseada: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la mascota: ");
                    String nombreMascota = scanner.next();
                    Mascota mascota = new Mascota(1, nombreMascota);

                    control.crearMascota(mascota);
                    System.out.println("Mascota registrada exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del veterinario: ");
                    String nombreVeterinario = scanner.next();
                    Veterinario veterinario = new Veterinario(1, nombreVeterinario);

                    control.crearVeterinario(veterinario);
                    System.out.println("Veterinario agregado exitosamente.");
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la mascota: ");
                    String nombreMascotaTurno = scanner.next();
                    Mascota mascotaTurno = new Mascota(1, nombreMascotaTurno);

                    System.out.print("Ingrese el nombre del veterinario: ");
                    String nombreVeterinarioTurno = scanner.next();
                    Veterinario veterinarioTurno = new Veterinario(1, nombreVeterinarioTurno);

                    control.agendarTurno(mascotaTurno, veterinarioTurno);
                    System.out.println("Turno agregado exitosamente.");
                    break;

                case 4:
                    List<Turnos> turnosDisponibles = control.obtenerTurnosDisponibles();
                    System.out.println("Turnos disponibles:");
                    for (Turnos turno : turnosDisponibles) {
                        System.out.println("ID: " + turno.getId() + " - Mascota: " + turno.getMascota().getNombre());
                    }

                    System.out.print("Ingrese el ID del turno a confirmar: ");
                    int idTurnoConfirmar = scanner.nextInt();

                    System.out.print("Ingrese el nombre del veterinario: ");
                    String nombreVeterinarioConfirmacion = scanner.next();
                    Veterinario veterinarioConfirmacion = new Veterinario(1, nombreVeterinarioConfirmacion);

                    control.confirmarTurno(idTurnoConfirmar, veterinarioConfirmacion);
                    System.out.println("Turno confirmado exitosamente.");
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }

        scanner.close();
    }
}
