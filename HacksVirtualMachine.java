import java.nio.file.*;

public class HacksVirtualMachine {

	private short ram[];
	private short rom[];

	private short D, A, PC; // registradores

	public HacksVirtualMachine(int memorySize){

		ram = new short [memorySize];
		rom = new short [memorySize];

		D = A = PC = 0;
	}
	/*
	public HacksVirtualMachine(){
		HacksVirtualMachine(32768);
	}
	*/
	public boolean loadRom(String fileName) {
		try {
			Path file = FileSystems.getDefault().getPath(fileName);
			byte fileBuffer[] = Files.readAllBytes(file);
			
			for(int i = 0, j = 0; i < fileBuffer.length/2; i++){
				rom[i] = (short) fileBuffer[j++];
				rom[i] |= (short)(fileBuffer[j++] << 8);
			}
			return true;

		}
		catch(Exception e){
			System.out.println("Exception: " + e);
			return false;			
		}	
	}

	public boolean exec() {
		/* 16 bits divididos em 
			trio, a, c, d, j

			trio não recebeu nome na especificação,
			a 1 bit qual lado da tabela de instrução
			c 6 bits função da instrução
			d 3 bits destino
			j 3 bits jump
		*/ 

		byte trio, a, c, d, j;
		short instruction = rom[PC];
		trio = (byte) (instruction >> 29);

		if ((trio>>18) == 0)
			A = instruction;
		else
			if(trio == 0b101)				
				return false;
			else
				if(trio == 0b100){
					a = (byte) ((instruction << 19) >> 31);
					c = (byte) ((instruction << 20) >> 26);
					d = (byte) ((instruction << 26) >> 29);
					j = (byte) ((instruction << 29) >> 29);

					/* ... continuar daqui

					Precisa tratar cada instrução, pra cada destino, com cada possibilidade de jump. Mas eu acho que um Array de funções ainda é a melhor coisa
					*/
					return true;
				}

				else{
					System.out.println("Instrução desconhecida, PC: " + PC);
					return false;
				}


		return true; // ... rever aqui, porque precisou pra compilar
	}
}