package socket_;

// TCP    0.0.0.0:8888           0.0.0.0:0              LISTENING
//��cmd������netstat -an|more ���Է�ҳ�鿴���б����Ķ˿����
//�Թ���Ա������netstat  -anb ���Բ鿴�������ж˿ڶ�����Щ�����ʹ��
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server03SocketTcp {

	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket=new ServerSocket(8888);
		System.out.println("Sever Listerning");
		
		Socket socket=serverSocket.accept();
		String path="src\\1Copy.png";
		BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(path));
		
//		/*�������⣺
//		�Խ�Զ�̷���ˣ������ܳɹ����ͣ����Ǳ�Connection reset��
//         ԭ��:���ǿͻ����ڽ��ܷ���˵���Ӧʱ��û�ж�ѭ��while ((info = br.readLine()) != null)��������Ϣ�����жϣ������޷�����ѭ��ֱ���Զ˹ر����ӣ�Ȼ��ͻ������쳣��
//		 */
//		/*
//		 * java.net.SocketException: Connection reset/Connect reset by peer: Socket write errorָ���ӱ����á�
//		 * ����������������ֱ��Ӧ���ִ��󣺵�һ�������ͨ�ŵ�һ���Ѿ��� Socket �رգ������������رջ�������Ϊ�쳣�˳���
//		 * ��ʱ���ͨ�ŵ���һ������д���ݣ��ͻᴥ������쳣��Connect reset by peer��������Է����ڳ��Դ� TCP �����ж����ݣ�
//		 * ����׳� Connection reset �쳣��Ϊ�˱�����Щ�쳣�������ڱ�д����ͨ�ų���ʱҪȷ���������˳�ǰҪ�����ر����е��������ӡ�
//		 * ���ͨ�ŵ���һ���Ĺر����Ӳ�������������һ���ر����Ӻ��Լ�ҲҪ�رո����ӡ�
//		 */
		
		//����������һ���쳣���������׳�java.net.SocketException: Connection reset  ��Ȼ����һ���ͻ����׳���Exception in thread "main" java.io.FileNotFoundException: E:\javaTestFil\1.png (ϵͳ�Ҳ���ָ����·����)
		//û������nnd���ļ�·������ˣ�������ȥ�ҷ�������ߵ�����
		//�������׳�java.net.SocketException: Connection reset��ԭ��Ӧ���ǿͻ�����Ϊ�쳣û�������������ݣ�Ȼ���ڱ߽�����socket�رգ����û�м�⵽���룬�����һֵ��reade����ط������ţ�Ȼ��ͻ���socket�رպ����
		//��֪ͨҲӦ�ùر�socket�������׳����������õ��쳣
		
		bufferedOutputStream.write(bufferedInputStream.readAllBytes());
//		byte[] data=StreamUtils.streamToByteArray(bufferedInputStream);
//		bufferedOutputStream.write(data);
		
		
		System.out.println("Copy complement");
		OutputStream out=socket.getOutputStream();
		out.write("�յ�����  ������".getBytes());
		
		//
		out.close();
		bufferedInputStream.close();
		bufferedOutputStream.close();
		socket.close();
		serverSocket.close();
		
	}
}
