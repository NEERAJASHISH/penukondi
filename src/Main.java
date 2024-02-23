import java.util.*;

class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
        String name;
		int age;
		boolean start = true;
		Theatre robinTheatre = new Theatre("robin", 5, 11);
		robinTheatre.getSeat();
		System.out.println("welcome to the robin theatre");
		System.out.println("please enter your name");
	    name = scanner.nextLine();
		System.out.println("please enter your age");
		age = scanner.nextInt();
		
		

		while(start) {
			
			System.out.println("please choose one of the below options " + name);
			System.out.println(" 1 :  To book a seat "
					+          " 2  : To cancel a seat "
					+          " 3  : To end the booking ");
			
			System.out.println("Enter the choice :  ");
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1 :  
				
		        System.out.println("Enter the seat number");
		        scanner.nextLine();
		        String seat1 = scanner.nextLine();
		        System.out.println("please pay the ticket price  100 " + " to book the ticket ");
		        int a = scanner.nextInt();
		        robinTheatre.reserve_seats(seat1,a);
				break;

				
			case 2 : 
				System.out.println("Enter the seat number that you want to cancel");
				scanner.nextLine();
				String seat2 = scanner.nextLine();
				robinTheatre.unreserve_seat_number(seat2);
				break;
				
			case 3 :
				start = false;
				break;		
			}	
			
		}

	}
		
		 
	}
	



/*
 * Theatre theatre = new Theatre("robin", 5, 5); theatre.getSeat();
 * theatre.reserve_seats("A00"); //theatre.reserve_seats("A00");
 */
class Seat {
	
	private final String seat_number;
	private boolean reserved = false;
	
	
	
	public Seat(String seat_number) {
		this.seat_number = seat_number;	
	}
	
	
	
	
	public boolean reserve() {
		
		if(!reserved) {
			reserved = true;
			System.out.println("The seat " + seat_number + " is reserved successfully ");
		    return true;
		}
		else {
			System.out.println("The seat has been booked already");
	     	return false;
		}
		
	}
	
	public boolean unreserve_seat() {
		if(reserved) {
			reserved = false;
			System.out.println("The amount has been credited back of ruppes 100 to your account ");
			System.out.println("The seat " + seat_number + " has been unreserved successfully!!!");
			
		}
		return true;
		
	}


	public String getSeat_number() {
		return seat_number;
	}

}

class Theatre {
	
    private final String name;
    private ArrayList<Seat> seats = new ArrayList<>();
    private final int price = 100;
    
    public Theatre(String name,int number_of_rows,int number_of_seats) {
    	this.name = name;
    	int lastrows = 'A' + (number_of_rows -1);
    	for(char rows = 'A';rows<=lastrows;rows++ ) {
    		for(int i = 0 ;i<number_of_seats;i++) {
    		Seat seat = new Seat( rows + toString().format("%02d", i));	
    		seats.add(seat);
    	}
    }   	 	
}
    
    public void reserve_seats(String seat_number,int price) {
    	if(price == this.price) {
    	Seat reserve_seat = null;
    	for(Seat seat : seats) {
    		if(seat.getSeat_number().equals(seat_number) ) {
    			reserve_seat = seat;
    			reserve_seat.reserve();
    			break;			
    		}	
    	}
    }
    	else {
    		System.out.println("The ticket price is rupees : 100 invalid !!!!! \n " +
    	              " your have entered " + price + " which is insufficient !!!!");
    	}
    }
    
    public void unreserve_seat_number(String seat_number) {
    	
    	Seat unreserved = null;
    	for(Seat seat : seats) {
    		if(seat.getSeat_number().equals(seat_number)) {
    			unreserved = seat;
    			unreserved.unreserve_seat();
    			break;
    		}	
 }
}
    public void getSeat() {
    	for(Seat seat : seats) {
    		System.out.println(seat.getSeat_number());
    	}
    }
}

