import java.rmi.*;

public interface Circle extends Remote {
    // Métodos para calcular a área a partir de diferentes parâmetros
    public double areaFromRadius(double radius) throws RemoteException;
    public double areaFromDiameter(double diameter) throws RemoteException;
    public double areaFromCircumference(double circumference) throws RemoteException;
}
