import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
public class client2 {
	public static void main(String[] args) throws Exception, IOException {
		//创建客户端指向本地8001端口
		Socket client = new Socket("localhost", 8001);
		System.out.println("与服务器成功连接");
	   //创建输出流
		DataOutputStream doStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream(),1024));
		// 创建输入流
		DataInputStream diStream = new DataInputStream(new BufferedInputStream(client.getInputStream(),1024));
		
		

		String rdString = "hello.html";
		doStream.writeUTF(rdString);
		doStream.flush();
		System.out.println("发送成功");
		
		String string = new String(diStream.readUTF());
		File infile = new File("C:\\Users\\张皓\\Desktop\\软件JAVA实训\\doc\\hello.html");
		FileWriter fileWriter = new FileWriter(infile);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		bWriter.write(rdString);
		System.out.println(	string);
		

	}
}
