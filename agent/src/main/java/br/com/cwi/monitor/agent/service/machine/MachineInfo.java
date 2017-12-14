package br.com.cwi.monitor.agent.service.machine;

/**
 * @author Alvaro
 */
public interface MachineInfo {

    public String getComputerName();
    
    public double getMemory();
    
    public double getTotalMemory();
    
    public double getCpu();
    
    public int getNumberOfCores();
    
    public double getFreeDisk();
    
    public double getOccupiedDisk();

}
