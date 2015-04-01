import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;
import java.io.InputStreamReader;

public class AcakAdut {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("kata.txt");
			BufferedReader br = new BufferedReader(fr);
			BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<String> daftarKata = new ArrayList<String>();
			String input = "";
			while((input=br.readLine())!=null) {
				daftarKata.add(input);
			}
			int max = daftarKata.size()-1;
			while(true) {
				boolean answer = false;
				int random = rand(0, max);
				String kata = daftarKata.get(random);
				String randomed = randomPermutation(kata);
				System.out.printf("Tebak kata : %s\n",randomed);
				while(!answer) {
					System.out.print("Jawab : ");
					String jawab = brInput.readLine();
					if(jawab.equals(kata)) {
						System.out.println("HEBAT!!");
						answer = true;
					} else {
						System.out.println("SALAH EUY, Coba Lagi !");
					}
				}
			}
		}
		catch(IOException e) {
		
		}
	}
	
	public static int rand(int min, int max) {
		Random rand = new Random();
		int random = rand.nextInt((max-min)+1)+min;
		return random;
	}
	public static String randomPermutation(String input) {
		String[] arr = input.split("");
		Collections.shuffle(Arrays.asList(arr));
		String output="";
		for(int i=0; i<arr.length; i++) {
			output+=arr[i];
		}
		return output;
	}
}