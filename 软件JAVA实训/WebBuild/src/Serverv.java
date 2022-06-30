import java.awt.Taskbar;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Serverv  {
public static void main(String[] args)throws Exception, IOException,InterruptedException {
	
	//创建服务器线程池
	  ExecutorService threadPool = Executors.newFixedThreadPool(5);
		ServerSocket severe =  new  ServerSocket(8001);
		System.out.println("创建服务器，等待客户访问");
		int count = 0;

while(true) {
	
			Runnable ts = new Runnable(){
			
				@Override
				public void run() {
					try {
					// TODO Auto-generated method stub
					Socket cilent;
				
						cilent = severe.accept();
						System.out.println("新客户进入服务器");
					//
					System.out.println("----------------------");
					
					
					//创建输入流
					DataInputStream dis = new DataInputStream(new BufferedInputStream(cilent.getInputStream(),1024));
					//创建输出流
					DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(cilent.getOutputStream(),1024));
					//向客户端发送消息
					System.out.println("创建流成功");
					
					String st =  dis.readUTF();
					System.out.println("读取成功");
					if(st.equals("hello.html")) {
						FileInputStream fl = new FileInputStream("C:\\Users\\张皓\\Desktop\\软件JAVA实训\\doc\\hello-serve.html");
						InputStreamReader flr = new InputStreamReader(fl,"UTF-8");
						StringBuffer sBuffer = new StringBuffer();
						while(flr.ready()) {
							sBuffer.append((char)flr.read());
							dos.writeChars(sBuffer.toString());
							dos.flush();
						}
						System.out.println(sBuffer.toString());
						String st2 =  dis.readUTF();
						System.out.println("读取成功"+st2);
						HelloWorld hWorld = new HelloWorld();
						//写回helloworld.class内容
						dos.writeUTF(hWorld.getString());
						dos.flush();
						
						dos.close();
						dis.close();
						cilent.close();
						
					}
					
				}
					catch(Exception e) {
						e.getStackTrace();
					}
			}
		};
		//运行线程
		new Thread(ts).start();
		
	
}
}
}
