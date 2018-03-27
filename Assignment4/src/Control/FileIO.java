package Control;

import java.io.*;

public class FileIO {
	
	public void saveStringIntoFile(String filename, String data) throws IOException{
			try
			{
				FileWriter w = new FileWriter((filename+ ".txt"),true);
					w.write(data);
					w.close();
			}
			catch(IOException e)//only IO exception types
			{
				System.out.println(e.getMessage());//explain error to user
				e.printStackTrace();
			}
			catch(Exception e)//any exception type
			{
				System.out.println(e.getMessage());//explain error to user
				e.printStackTrace();
			}
			
	}
	
	public String getStringFromFile(String filename)
	{	String message = "";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename+ ".txt"));
			String sCurrentLine;
			while((sCurrentLine= br.readLine())!=null)//while stuff to read
			{
				message += sCurrentLine;
			}
			br.close();
		}
		catch(IOException e)//only IO exception types
		{
			System.out.println(e.getMessage());//explain error to user
			e.printStackTrace();
		}
		catch(Exception e)//any exception type
		{
			System.out.println(e.getMessage());//explain error to user
			e.printStackTrace();
		}
		return message;
	}//end doRead()
	
}

