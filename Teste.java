public class Teste{

	public static void main(String[] args){

		HacksVirtualMachine hvm = new HacksVirtualMachine(16);
		
		if ( !hvm.loadRom("teste_01.rom") )
			System.out.println("Falha ao ler arquivo!");
		
		else {

			boolean condition = true;
			while(condition)
				condition = hvm.exec();

		}
	}
}