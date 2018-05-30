package io.kaluh.java8.basic.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Explain Serialization. Overriding writeObject method.
 * https://howtodoinjava.com/core-java/serialization/custom-serialization-readobject-writeobject/
 * 
 * 
 * To customize serialization and deserialization, define readObject() and
 * writeObject() methods in this class.
 * 
 * Inside writeObject() method, write class attributes using writeXXX methods
 * provided by ObjectOutputStream.
 * 
 * Inside readObject() method, read class attributes using readXXX methods
 * provided by ObjectInputStream.
 * 
 * Please note that the sequence of class attributes in read and write methods
 * MUST BE same.
 * 
 * @author Z462725
 *
 */
public class CustomSerialization implements Serializable {

	private static final long serialVersionUID = 7829136421241571165L;

	private String firstName;
	private String lastName;
	private int accountNumber;
	private Date dateOpened;

	public CustomSerialization(String firstName, String lastName, int accountNumber, Date dateOpened) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.dateOpened = dateOpened;
	}

	public CustomSerialization() {
		super();
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final int getAccountNumber() {
		return accountNumber;
	}

	public final Date getDateOpened() {
		return new Date(dateOpened.getTime());
	}

	public final void setFirstName(String aNewFirstName) {
		firstName = aNewFirstName;
	}

	public final void setLastName(String aNewLastName) {
		lastName = aNewLastName;
	}

	public final void setAccountNumber(int aNewAccountNumber) {
		accountNumber = aNewAccountNumber;
	}

	public final void setDateOpened(Date aNewDate) {
		Date newDate = new Date(aNewDate.getTime());
		dateOpened = newDate;
	}

	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		firstName = aInputStream.readUTF();
		lastName = aInputStream.readUTF();
		accountNumber = aInputStream.readInt();
		dateOpened = new Date(aInputStream.readLong());
	}

	private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
		aOutputStream.writeUTF(firstName);
		aOutputStream.writeUTF(lastName);
		aOutputStream.writeInt(accountNumber);
		aOutputStream.writeLong(dateOpened.getTime());
	}

	public static void main(String[] args) {
		// Create new User object
		CustomSerialization myDetails = new CustomSerialization("Lokesh", "Gupta", 102825,
				new Date(Calendar.getInstance().getTimeInMillis()));

		// Serialization code
		try {
			FileOutputStream fileOut = new FileOutputStream("User.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(myDetails);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// De-serialization code
		CustomSerialization deserializedUser = null;
		try {
			FileInputStream fileIn = new FileInputStream("User.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			deserializedUser = (CustomSerialization) in.readObject();
			in.close();
			fileIn.close();

			// verify the object state
			System.out.println(deserializedUser.getFirstName());
			System.out.println(deserializedUser.getLastName());
			System.out.println(deserializedUser.getAccountNumber());
			System.out.println(deserializedUser.getDateOpened());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}
}
