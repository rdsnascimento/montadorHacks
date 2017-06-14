import java.nio.file.*;

public class Hex_to_Rom {

	public static void main(String args[]){

		int hexadecimal[] = { // mesmo testeROM_xxx.hex
								0b0000000000000010,
								0b1110000010010000,
								0b0000000000000010,
								0b1110000010010000,
								0b0000000000000011,
								0b1110000010010000,
								0b1110001100001000,
								0b1010101010101010
								};
		
		byte rom[] = new byte [hexadecimal.length *2];

		// precisei escrever os literais em int, porque o compilador reclama, mas já os passo ao vetor de bytes
		for(int i = 0; i < hexadecimal.length; i++){			
			
			rom[i*2 +1] = (byte)hexadecimal[i];
			hexadecimal[i] >>= 8;
			rom[i*2] = (byte)(hexadecimal[i]);
		}
		
		try {
			Path file = FileSystems.getDefault().getPath("teste_01.rom");
			Files.write(file, rom);		
		}
		catch(Exception e){
			System.out.println("Exception: " + e);
		}
	}
}