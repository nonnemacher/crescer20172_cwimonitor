package br.com.cwi.monitor.agent.service.machine;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSFileStore;

/**
 * @author Alvaro
 */
public class MachineInfoOshiImplementation implements MachineInfo {

    private final SystemInfo systemInfo;

    public MachineInfoOshiImplementation() {
        this.systemInfo = new SystemInfo();
    }

    @Override
    public String getComputerName() {
        return systemInfo.getHardware().getComputerSystem().getModel();
    }

    @Override
    public double getMemory() {
        double totalMemory = systemInfo.getHardware().getMemory().getTotal() / 1024 / 1024;
        double availableMemory = systemInfo.getHardware().getMemory().getAvailable() / 1024 / 1024;
        double memoryPercentageUsed = (availableMemory / totalMemory) * 100;

        return memoryPercentageUsed;
    }

    @Override
    public double getTotalMemory() {
        return systemInfo.getHardware().getMemory().getTotal() / 1024 / 1024 / 1000;
    }

    @Override
    public double getCpu() {
        final CentralProcessor processor = systemInfo.getHardware().getProcessor();
        double cpuPercentageUsed = processor.getSystemCpuLoad() * 100;

        return cpuPercentageUsed;
    }

    @Override
    public int getNumberOfCores() {
        final CentralProcessor processor = systemInfo.getHardware().getProcessor();
        return processor.getLogicalProcessorCount();
    }
    
    @Override
    public double getOccupiedDisk() {
        double totalUsableSpace = 0;
        double totalSpace = 0;
        double spaceAvg = 0;
        for (OSFileStore s : systemInfo.getOperatingSystem().getFileSystem().getFileStores()) {
            totalUsableSpace += s.getUsableSpace();
            totalSpace += s.getTotalSpace();
        }
        
        return (totalSpace / 1024 / 1024 / 1024) - (totalUsableSpace / 1024 / 1024 / 1024) ;
    }

    @Override
    public double getFreeDisk() {
        double totalUsableSpace = 0;
        double totalSpace = 0;
        double spaceAvg = 0;
        for (OSFileStore s : systemInfo.getOperatingSystem().getFileSystem().getFileStores()) {
            totalUsableSpace += s.getUsableSpace();
        }

        return totalUsableSpace / 1024 / 1024 / 1024;
    }

    public double getDisk() {
        double totalUsableSpace = 0;
        double totalSpace = 0;
        double spaceAvg = 0;
        for (OSFileStore s : systemInfo.getOperatingSystem().getFileSystem().getFileStores()) {
            totalUsableSpace += s.getUsableSpace();
            totalSpace += s.getTotalSpace();
        }
        spaceAvg = totalUsableSpace / totalSpace * 100;

        return spaceAvg;
    }
}
