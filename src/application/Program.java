package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        Scanner enter = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = enter.nextInt();
            System.out.print("Check-in date (dd/MM/yyy): ");
            Date checkIn = simpleDateFormat.parse(enter.next());
            System.out.print("Check-out date (dd/MM/yyy): ");
            Date checkOut = simpleDateFormat.parse(enter.next());

            Reservation reservation = new Reservation(checkIn, checkOut, roomNumber);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = simpleDateFormat.parse(enter.next());
            System.out.print("Check-out date (dd/MM/yyy): ");
            checkOut = simpleDateFormat.parse(enter.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        //Bad practice, you must be aware of all the mistakes.
        /* catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }*/

        enter.close();
    }
}
