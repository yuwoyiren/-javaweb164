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
	
	//�����������̳߳�
	  ExecutorService threadPool = Executors.newFixedThreadPool(5);
		ServerSocket severe =  new  ServerSocket(8001);
		System.out.println("�������������ȴ��ͻ�����");
		int count = 0;

while(true) {
	
			Runnable ts = new Runnable(){
			
				@Override
				public void run() {
					try {
					// TODO Auto-generated method stub
					Socket cilent;
				
						cilent = severe.accept();
						System.out.println("�¿ͻ����������");
					//
					System.out.println("----------------------");
					
					
					//����������
					DataInputStream dis = new DataInputStream(new BufferedInputStream(cilent.getInputStream(),1024));
					//���������
					DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(cilent.getOutputStream(),1024));
					//��ͻ��˷�����Ϣ
					System.out.println("�������ɹ�");
					
					String st =  dis.readUTF();
					System.out.println("��ȡ�ɹ�");
					if(st.equals("hello.html")) {
						FileInputStream fl = new FileInputStream("C:\\Users\\���\\Desktop\\���JAVAʵѵ\\doc\\hello-serve.html");
						InputStreamReader flr = new InputStreamReader(fl,"UTF-8");
						StringBuffer sBuffer = new StringBuffer();
						while(flr.ready()) {
							sBuffer.append((char)flr.read());
							dos.writeChars(sBuffer.toString());
							dos.flush();
						}
						System.out.println(sBuffer.toString());
						String st2 =  dis.readUTF();
						System.out.println("��ȡ�ɹ�"+st2);
						HelloWorld hWorld = new HelloWorld();
						//д��helloworld.class����
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
		//�����߳�
		new Thread(ts).start();
		
	
}
}
}
