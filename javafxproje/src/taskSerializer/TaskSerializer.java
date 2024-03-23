package taskSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.model;

public class TaskSerializer {
private static final String DATA_PATH ="data.bin";

public static void serialize(Object[] tasks)throws IOException {
	
	try(var serializer =new ObjectOutputStream(new FileOutputStream(DATA_PATH))){
		serializer.writeObject(tasks);
	}
}
public static model[] deserialize () throws IOException,ClassNotFoundException{
	
	try(var deserialize=new ObjectInputStream(new FileInputStream(DATA_PATH))){
		
		Object[] task= (Object[]) deserialize.readObject();
		model[] dizi = new model[task.length];
		for (int i =0 ;i<task.length;i++) {
			dizi[i]=(model)task[i];
		}
		return dizi;
	}
}
}
