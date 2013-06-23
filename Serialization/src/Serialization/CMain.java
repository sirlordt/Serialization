package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CDataType1 DataType1 = new CDataType1();

		DataType1.strDataObject = "DataType1";
		DataType1.strDataType1 = "DataType1";

		CDataType2 DataType2 = new CDataType2();

		DataType2.strDataObject = "DataType2";
		DataType2.strDataType2 = "DataType2";

		try {

			FileOutputStream fileOut1 = new FileOutputStream( "DataType1.ser" );

			ObjectOutputStream out1 = new ObjectOutputStream( fileOut1 );
			out1.writeObject( DataType1 );
			out1.close();
			fileOut1.close();

			DataType1 = null;
			
			FileOutputStream fileOut2 = new FileOutputStream( "DataType2.ser" );

			ObjectOutputStream out2 = new ObjectOutputStream( fileOut2 );
			out2.writeObject( DataType2 );
			out2.close();
			fileOut2.close();

			DataType2 = null;
			
		}
		catch( Exception Ex ) {

			Ex.printStackTrace();

		}		
		
		CDataObject DataType1Des;
		
		CDataObject DataType2Des;
		
		try {

			FileInputStream fileIn1 = new FileInputStream( "DataType1.ser" );
			ObjectInputStream in1 = new ObjectInputStream( fileIn1 );
			
			DataType1Des = ( CDataObject ) in1.readObject();
			in1.close();
			fileIn1.close();
			
			System.out.println( DataType1Des.strDataObject );
			
			FileInputStream fileIn2 = new FileInputStream( "DataType2.ser" );
			ObjectInputStream in2 = new ObjectInputStream( fileIn2 );
			
			DataType2Des = ( CDataObject ) in2.readObject();
			in2.close();
			fileIn2.close();
			
			System.out.println( DataType2Des.strDataObject );
			
		}
		catch( IOException Ex ) {
			
			Ex.printStackTrace();
			return;
			
		}
		catch( ClassNotFoundException c) {
		
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
			
		}		
		
	}

}
