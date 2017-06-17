public class Teste{

	public static void main(String[] args){

		final int testMemorySize = 16;

		HacksVirtualMachine hvm = new HacksVirtualMachine(testMemorySize);
		boolean condition;

		testFiles = {
					"teste_01.rom",
					}

		for( file:testFiles )

			if ( !hvm.loadRom(file) )
				System.err.println("Falha ao ler arquivo!");
			
			else			
				do
					condition = hvm.exec();
				while(condition);

					
	}
}