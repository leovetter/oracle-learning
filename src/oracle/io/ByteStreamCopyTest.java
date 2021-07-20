package oracle.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteStreamCopyTest {
	
	public ByteStreamCopyTest() {
		
	}

	public void byteStreamCopyFile() {
		
		byte[] b = new byte[128];
		
		try (FileInputStream fis = new FileInputStream("E:\\oracle-learning\\resources\\amnesty.txt")) {
			
			FileOutputStream fos = new FileOutputStream("E:\\oracle-learning\\resources\\amnesty_copie.txt");
			System.out.println("Bytes available: " + fis.available());
			
			int count = 0; int read = 0;
			while((read = fis.read(b)) != -1) {
				System.out.println("Bytes read: " + read);
				fos.write(b);
				count += read;
			}
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void charStreamCopyFile() {
		
		char[] c = new char[128];
		
		try (FileReader fr = new FileReader("E:\\oracle-learning\\resources\\amnesty.txt")) {
			
			FileWriter fw = new FileWriter("E:\\oracle-learning\\resources\\amnesty_copie.txt");
			
			int count = 0; int read = 0;
			while((read = fr.read(c)) != -1) {
				System.out.println("Bytes read: " + read);
				fw.write(c);
				count += read;
			}
			fr.close();
			fw.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lineStreamCopyTest() {
				
		// Example use of InputStream methods
		try (BufferedReader bufInput = new BufferedReader(new FileReader("E:\\oracle-learning\\resources\\amnesty.txt"))) {
			
			BufferedWriter bufOutptut = new BufferedWriter(new FileWriter("E:\\oracle-learning\\resources\\amnesty_copie.txt"));
			
			String line = "";
			while((line = bufInput.readLine()) != null) {
				bufOutptut.write(line);
				bufOutptut.newLine();
			}
			bufInput.close();
			bufOutptut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void byteChanelCopyTest(){
		
		try (FileChannel fcIn = new FileInputStream("E:\\oracle-learning\\resources\\amnesty.txt").getChannel();
			 FileChannel fcOut = new FileOutputStream("E:\\oracle-learning\\resources\\amnesty_copie.txt").getChannel() ) {
			
				ByteBuffer buff = ByteBuffer.allocate((int) fcIn.size());
			
				fcIn.read(buff);
				buff.position(0);
				fcOut.write(buff);
				
				fcIn.close();
				fcOut.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
