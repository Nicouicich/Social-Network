package Util;

import java.util.Random;

public class UtilThread
{
	private static Random r = new Random();

	public static void espera(int tiempo)
	{
		try
		{
			Thread.sleep(tiempo);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void espera()
	{
		UtilThread.espera(r.nextInt(3000));
	}
}