// Java program to demonstrate thread states 

class thread implements Runnable  { 
	
	public void run()  { 
        
		// moving thread2 to timed waiting state 
        try {
        	Thread.sleep(1500); 
        }catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
          
        System.out.println("Estado del Hilo1 mientras se llamaba al metodo join() "
        		+ "en el Hilo2 -"+ Prueba.thread1.getState()); 
        try { 
            Thread.sleep(200); 
        }catch (InterruptedException e) { 
            e.printStackTrace(); 
        }      
    } 
} 

public class Prueba implements Runnable {

	 public static Thread thread1; 
	 public static Prueba obj; 
	    
	public static void main(String[] args) {
		obj = new Prueba(); 
        thread1 = new Thread(obj); 
          
        // thread1 created and is currently in the NEW state. 
        System.out.println("Estado del Hilo1 despues de crearlo - " + thread1.getState()); 
        thread1.start(); 
          
        // thread1 moved to Runnable state 
        System.out.println("Estado del Hilo1 despues de llamar al metodo .start() en el - " +  
        thread1.getState()); 
	}

	@Override
	public void run() {
		thread myThread = new thread(); 
        Thread thread2 = new Thread(myThread); 
          
        // thread1 created and is currently in the NEW state. 
        System.out.println("Estado del Hilo2 despues de crearlo - "+ thread2.getState()); 
        thread2.start(); 
          
        // thread2 moved to Runnable state 
        System.out.println("Estado del Hilo2 despues de llamar al metodo .start() en el - " +  
        thread2.getState()); 
          
        // moving thread1 to timed waiting state 
        try { 
            //moving thread1 to timed waiting state 
            Thread.sleep(200); 
        }catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        System.out.println("Estado del hilo1 despues de llamar al metodo .sleep() en el - "+  
        thread2.getState() ); 
          
        try { 
            // waiting for thread2 to die 
            thread2.join(); 
        }catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        System.out.println("Estado del Hilo2 cuando a finalizado su ejecucion - " +  
        thread2.getState()); 
	}
}