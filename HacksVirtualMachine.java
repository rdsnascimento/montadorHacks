import java.nio.file.*;
// pra leitura da Rom

import java.util.regex
// expressões regulares

public class HacksVirtualMachine {

	public short ram[];
	public short rom[];

	public short D, A; // registradores
	public int PC; 

	public HacksVirtualMachine(int memorySize){

		PC = D = A = 0;

		ram = new short [memorySize];
		rom = new short [memorySize];			
	}
	
	public HacksVirtualMachine(){
		this( (int)Math.pow(2,15) ); 
		// caso default é a memória máxima = 15 bits , 2^15
	}
	
	public boolean loadRom(String fileName) {
		try {
			Path file = FileSystems.getDefault().getPath(fileName);
			byte fileBuffer[] = Files.readAllBytes(file);
			// I/O max usage
			
			for(int i = 0, j = 0; i < fileBuffer.length/2; i++)
				rom[i] = (short) (fileBuffer[j++] | (fileBuffer[j++] << 8) );
			// cada short recebe 2 bytes					
		}
		catch(Exception e){
			System.err.println("Exception: " + e);
			return false;					
		}
		
		return true;
	}

	public boolean exec() {
		/* função que faz Tudo,
		isto é, executa as instruções

		/* 16 bits divididos em 
			?, a, c, d, j

			? 3 bits - não recebeu nome na especificação, mas é 0 pra tipo-A ou 111 pra tipo-C
			a 1 bit  - qual lado da tabela de instrução
			c 6 bits - função da instrução
			d 3 bits - destino da ALU
			j 3 bits - jump
		*/ 

		// Ou String instruction = Integer.toBinaryString(rom[PC++]);	
		// Ou int instruction = rom[PC++];	
		// fetch instrução e já incrementa PC
		// antes era mais eficiente, mas foooo... vai com String e RegExp


		
		// debug
		System.out.println("Instrução: " + instruction);

		
		

		System.err.println("Instrução " + instruction + " desconhecida");
		return false;							
	}
}