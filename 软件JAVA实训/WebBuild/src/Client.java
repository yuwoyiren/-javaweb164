import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.security.spec.MGF1ParameterSpec;


public class Client {
public static void main(String[] args) throws Exception, IOException {
	//创建客户端指向本地8001端口
	Socket client = new Socket("localhost", 8001);
	System.out.println("与服务器成功连接");
   //创建输出流
	DataOutputStream doStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream(),1024));
	// 创建输入流
	DataInputStream diStream = new DataInputStream(new BufferedInputStream(client.getInputStream(),1024));
	
	

	String rdString1 = "hello.html";
	doStream.writeUTF(rdString1);
	doStream.flush();
	System.out.println("发送成功");
	
	String string = new String(diStream.readUTF());
	FileInputStream fl = new FileInputStream("C:\\Users\\张皓\\Desktop\\软件JAVA实训\\doc\\hello.html");
	InputStreamReader flr = new InputStreamReader(fl,"UTF-8");
	StringBuffer sBuffer = new StringBuffer();
	sBuffer.append((char)flr.read());
	doStream.writeChars(sBuffer.toString());
	doStream.flush();
	System.out.println(	string);
	
	String rdString2 = "HelloWorld.action";
	doStream.writeUTF(rdString2);
	doStream.flush();
	System.out.println("发送成功");
	
	//写入消息到hello2.html
	String string2 = new String(diStream.readUTF());
	File flFile = new File("C:\\Users\\张皓\\Desktop\\软件JAVA实训\\doc\\hello2.html");
	FileInputStream fl2 = new FileInputStream(flFile);
	InputStreamReader flr2 = new InputStreamReader(fl2,"UTF-8");
	StringBuffer sBuffer2 = new StringBuffer();
	sBuffer2.append((char)flr.read());
	doStream.writeChars(sBuffer2.toString());
	doStream.flush();
	System.out.println(	string);
	System.out.println("写入文件成功");
	

		diStream.close();
		doStream.close();
		client.close();
	
}


}
