import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class CircleServer implements Circle {
    public CircleServer() {}

    public static void main(String[] args) {
        try {
            CircleServer server = new CircleServer();
            Circle stub = (Circle) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CircleService", stub);

            System.out.println("Servidor de cálculo de áreo do circulo iniciado....\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Implementação do cálculo da área a partir do raio
    public double areaFromRadius(double radius) throws RemoteException {
    	System.out.println("Cálculo da área a partir do raio iniciado....");
        return Math.PI * radius * radius;
    }

    // Implementação do cálculo da área a partir do diâmetro
    public double areaFromDiameter(double diameter) throws RemoteException {
    	System.out.println("Cálculo da área a partir do diâmetro iniciado....");
        double radius = diameter / 2;
        return Math.PI * radius * radius;
    }

    // Implementação do cálculo da área a partir da circunferência
    public double areaFromCircumference(double circumference) throws RemoteException {
    	System.out.println("Cálculo da área a partir do circunferência iniciado....");
        double radius = circumference / (2 * Math.PI);
        return Math.PI * radius * radius;
    }
}
