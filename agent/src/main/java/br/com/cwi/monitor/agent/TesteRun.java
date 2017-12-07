package br.com.cwi.monitor.agent;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

/**
 * @author carloshenrique@cwi.com.br
 */
@Log
public class TesteRun {

	@Getter
	@Setter
	@ToString
	public static class CollectorDto {

		int cpuCores, threadCount;
		long cpuProcessTime, uptime, memoryFree, memoryTotal, memoryFreePercent;
		double loadAvg, systemCpuLoad, user;
		String osName, osVersion, osArchitecture;

	}

	public static void main(String[] args) {

		final CollectorDto collector = new CollectorDto();

		OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

		int cores = Runtime.getRuntime().availableProcessors();

		long freeMemory = (operatingSystemMXBean.getFreePhysicalMemorySize() / 1024) / 1024;
		long totalMemory = (operatingSystemMXBean.getTotalPhysicalMemorySize() / 1024) / 1024;
		long memoryFreePercent = (freeMemory * 100) / totalMemory;

		String osArch = operatingSystemMXBean.getArch();
		String osName = operatingSystemMXBean.getName();
		String osVersion = operatingSystemMXBean.getVersion();

		double loadAvg = operatingSystemMXBean.getSystemLoadAverage();

		int threadCount = threadMXBean.getThreadCount();
		long allThreadsCpuTime = 0L;

		long[] threadIds = threadMXBean.getAllThreadIds();
		for (int i = 0; i < threadIds.length; i++) {
			allThreadsCpuTime += threadMXBean.getThreadCpuTime(threadIds[i]);
		}

		long uptime = runtimeMXBean.getUptime();

		collector.setCpuCores(cores);
		collector.setCpuProcessTime(allThreadsCpuTime);

		collector.setSystemCpuLoad(operatingSystemMXBean.getSystemCpuLoad());

		collector.setUptime(uptime);
		collector.setThreadCount(threadCount);
		collector.setLoadAvg(loadAvg);
		collector.setOsName(osName);
		collector.setOsVersion(osVersion);
		collector.setOsArchitecture(osArch);
		collector.setMemoryFree(freeMemory);
		collector.setMemoryTotal(totalMemory);
		collector.setMemoryFreePercent(memoryFreePercent);

		System.out.println("Metricas >> " + collector);

	}

}
