package tankGame;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

//记录成绩
public class Recoder {

	private static int enemyTankNumber;
	private static ObjectOutputStream oos=null;
	private static ObjectInputStream ois=null;
	private static String path="src\\tankGameRecod.txt";

	

	
	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Recoder.path = path;
	}

	public static int getEnemyTankNumber() {
		return enemyTankNumber;
	}

	public static void setEnemyTankNumber(int enemyTankNumber) {
		Recoder.enemyTankNumber = enemyTankNumber;
	}
	
	public static void storeRecode() {
		try {

			oos =new ObjectOutputStream(new FileOutputStream(path));
			//存数据到文件里
			oos.writeInt(enemyTankNumber);
			oos.writeObject(MyPanel.myTank);
			oos.writeObject(MyPanel.enemyTank);
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void loadRecod() {
		
		try {
			ois=new ObjectInputStream(new FileInputStream(path));
			enemyTankNumber=ois.readInt();
			try {
				MyPanel.myTank=(MyTank) ois.readObject();
				MyPanel.enemyTank=(Vector<EnemyTank>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
