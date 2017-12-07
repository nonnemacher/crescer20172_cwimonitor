package br.com.cwi.monitor.agent;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSFileStore;

/**
 * @author carloshenrique@cwi.com.br
 */
public class RunOshi {

	public static void main(String[] args) {

		SystemInfo si = new SystemInfo();
		final CentralProcessor processor = si.getHardware().getProcessor();
		final int cores = processor.getPhysicalProcessorCount();

		for (OSFileStore s : si.getOperatingSystem().getFileSystem().getFileStores()) {
			System.out.println(s.getDescription() + " == " + s.getMount() + " == " + (s.getTotalSpace() / 1024 / 1024) + "m == " + (s.getUsableSpace() / 1024 / 1024));
		}

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.out.println(">>> " + (processor.getSystemCpuLoad()) * 100);
		}
	}
}
