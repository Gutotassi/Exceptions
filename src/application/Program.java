package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner enter = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = enter.nextInt();
        System.out.print("Check-in date (dd/MM/yyy): ");
        Date checkIn = simpleDateFormat.parse(enter.next());
        System.out.print("Check-out date (dd/MM/yyy): ");
        Date checkOut = simpleDateFormat.parse(enter.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(checkIn, checkOut, roomNumber);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyy): ");
            checkIn = simpleDateFormat.parse(enter.next());
            System.out.print("Check-out date (dd/MM/yyy): ");
            checkOut = simpleDateFormat.parse(enter.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }

        enter.close();
    }
}
