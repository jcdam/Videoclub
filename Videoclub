/** Programa para gestionar videclub, que crea fichero .dat secuencial con datos almacenados
*@autor JCDAM
*@version Version 1, alta de peliculas, consulta de peliculas, y listado de peliculas almacenadas.
* Formato de menu para trabajo:
	1. Alta de película
	2. Consulta de una película a partir de su código
	3. Listar todas las películas
	0. Salir del programa
*/

import java.io.*;

class Videoclub
{
	static File f = new File ("Videoclub.dat");

	public static void altaPelicula() 
	{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		boolean append = true;

		try 
		{
			FileOutputStream fos = new FileOutputStream (f,append); 
			DataOutputStream dos = new DataOutputStream (fos);
		
			System.out.println("Introduzca código película");
			int codigo = Integer.parseInt(br.readLine());
			dos.writeInt(codigo);
			System.out.println("Introduzca título película");
			String titulo = br.readLine();
			dos.writeUTF(titulo);
			System.out.println("Introduzca director película");
			String director = br.readLine();
			dos.writeUTF(director);
			
			if (dos != null)
			{
				dos.close();
				fos.close();
			}
		}
		catch (FileNotFoundException fnf)
		{
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

//_______________________________Consultar Películas____________________________
	
	public static void consultaPelicula() 
	{
		System.out.println("");
		System.out.println("Introduzca código de película a buscar");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		int codigoBuscar= 0;
		try
		{
			codigoBuscar = Integer.parseInt(br.readLine());
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try 
		{	
			if (f.exists())
			{
				fis = new FileInputStream (f);
				dis = new DataInputStream (fis);
				
					int cod;
					String titulo;
					String director;
					while (true)
					{
						cod = dis.readInt();
						titulo = dis.readUTF();
						director = dis.readUTF();
							if (cod == codigoBuscar)
								{
									System.out.print("La Pelicula correspondiente al codigo "+cod+" es: "+titulo+" director: "+director);
								}
					}
			}
		} 
		
		catch (EOFException eof)
		{
			System.out.println("----------------------------------------");
		}			
		catch (FileNotFoundException fnf)
		{
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if (dis != null)
				{
					dis.close();
					fis.close();				
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
//_______________________Listar las Peliculas__________________________________

		public static void listaPelicula() 
	{
		System.out.println("");		
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try 
		{	
			if (f.exists())
			{
				fis = new FileInputStream (f);
				dis = new DataInputStream (fis);
				
					int cod;
					String titulo;
					String director;
					while (true)
					{
						cod = dis.readInt();
						titulo = dis.readUTF();
						director = dis.readUTF();
						System.out.println("Codigo :"+cod+" -> Titulo: "+titulo+" -> Director: "+director);
					}
			}
			System.out.println("Saliendo de consulta.......");
		} // cierre try
		
		catch (EOFException eof)
		{
			System.out.println("----");
		}			
		catch (FileNotFoundException fnf)
		{
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if (dis != null)
				{
					dis.close();
					fis.close();				
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}


	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int menu = 1;
		
		while (menu !=0)
		{
			System.out.println("--------------------------VIDEOCLUB----------------------------");
			System.out.println("MENU: Escoge una accion");

			System.out.println("1. Alta de película");
			System.out.println("2. Consulta de una película a partir de su código");
			System.out.println("3. Listar todas las películas");
			System.out.println("0. Salir del programa");
			menu = Integer.parseInt(br.readLine());

				while ((menu <0) || (menu >3)) // para valores númericos fuera de rango 0 a 3
				{
					System.out.println("Por favor, escoja un valor entre 0 y 3");
					menu = Integer.parseInt(br.readLine());
				}

			switch (menu)
			{
			case 1: System.out.println ("  ALTA PELICULA  ");Videoclub.altaPelicula();break;
			case 2: System.out.println ("  CONSULTA PELICULA POR CODIGO   ");Videoclub.consultaPelicula();break;
			case 3: System.out.println ("  LISTADO DE PELICULAS, CODIGO, TITULO, DIRECTOR   ");Videoclub.listaPelicula();break;
			case 0: System.out.println (" Saliendo del programa ......... hasta pronto.");break;

			}
		}
	}
}
