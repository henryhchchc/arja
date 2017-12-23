package us.msu.cse.repair;

public class ParameterInfoMain {
	public static void main(String args[]) {
		System.out.println("                Parameters available for all the approaches   ");
		System.out.println("*************************************************************************************");
		
		System.out.println("-DsrcJavaDir  : the root directory of source code");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DbinJavaDir  : the root directory of all the compiled classes of source code");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DbinTestDir  : the root directory of all the compiled classes of test code");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-Ddependences : the dependences (jar files) of the buggy program, \n"
				+ "	        separated by \":\", and at least including a junit jar");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DpatchOutputRoot  : the directory of the output test-suite adequate patches, "
				+ "\n                     default $current dir$/patches_id");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-Dthr : " + "the threshold of suspiciousness, default 0.1");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DmaxNumberOfModificationPoints : " + "the maximum number of modification points "
				+ "\n                                  considered, default 40");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DjvmPath: the path of the executable JVM, e.g., /usr/bin/java");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DwaitTime: the allowed maximum time (ms) to execute all the considered "
				          + "\n            tests of a program variant, default 6000ms");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DgzoltarDataDir : the root directory of the output of Gzoltar 1.6.2,"
				        + "\n                   e.g., .../gzoltar-data, default not used");
		System.out.println("*************************************************************************************");
		
		
		
		System.out.println();
		System.out.println("               Parameters available for Arja, GenProg and RSRepair   ");
		System.out.println("*************************************************************************************");
		System.out.println("-DingredientMode : the ingreidient mode (File, Package or Application), "
				+ "	\n                   default Package");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DpopulationSize : " + "the population size, default 40");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-DmaxGenerations : " + "the maximum number of generations, default 50");
		System.out.println("*************************************************************************************");
		
		System.out.println();
		System.out.println("                      Parameters available for Arja  ");
		System.out.println("*************************************************************************************");
		System.out.println("-DingredientScreenerName : the ingreidient screening method (Direct, VarTypeMatch,"
				+ "\n                           MethodTypeMatch or VMTypeMatch), default Direct ");	
		System.out.println("*************************************************************************************");
	}
}
