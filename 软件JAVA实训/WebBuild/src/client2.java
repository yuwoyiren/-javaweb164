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
		//�����ͻ���ָ�򱾵�8001�˿�
		Socket client = new Socket("localhost", 8001);
		System.out.println("��������ɹ�����");
	   //���������
		DataOutputStream doStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream(),1024));
		// ����������
		DataInputStream diStream = new DataInputStream(new BufferedInputStream(client.getInputStream(),1024));
		
		

		String rdString = "hello.html";
		doStream.writeUTF(rdString);
		doStream.flush();
		System.out.println("���ͳɹ�");
		
		String string = new String(diStream.readUTF());
		File infile = new File("C:\\Users\\���\\Desktop\\���JAVAʵѵ\\doc\\hello.html");
		FileWriter fileWriter = new FileWriter(infile);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		bWriter.write(rdString);
		System.out.println(	string);
		

	}
}
