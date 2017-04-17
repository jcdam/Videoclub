/** Programa para gestionar videclub, que crea fichero .dat secuencial con datos almacenados
*@autor JCDAM
*@version Version 1, alta de peliculas, consulta de peliculas, y listado de peliculas almacenadas.
* Formato de menu para trabajo:
	1. Alta de película
	2. Consulta de una película a partir de su código
	3. Listar todas las películas
	0. Salir del programa

* Jesús Cañizares mejora:
* Añadir la posibilidad de borrar películas almacenadas, introduciendo su código.
* Crear un método modular para borrarPeliculas()
* Añadir la opción en menú para borrarPeliculas(), con el número 4.
* Ampliar la posibilidad de ejecución del programa en el switch de opciones
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
//_____________________________________________Opción Borrar Películas Jesús Cañizares___________________

	//__________________________Borra Película________________________________
	
	public static void borraPelicula() 
	{
		System.out.println("");
		System.out.println("Introduzca código de película a borrar");
		BufferedReader br2 = new BufferedReader (new InputStreamReader (System.in));
		int codigoBorrar= 0;
		File f2 =new File ("Videoclub2.dat");
		try
		{
			codigoBorrar = Integer.parseInt(br2.readLine());
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
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
				
					boolean append= true;
					
					while (true)
					{
						cod = dis.readInt();
						titulo = dis.readUTF();
						director = dis.readUTF();

						if (cod != codigoBorrar)
							{
								FileOutputStream fos = new FileOutputStream (f2,append);
								DataOutputStream dos = new DataOutputStream (fos);

								try
								{
									dos.writeInt(cod);
									dos.writeUTF(titulo);
									dos.writeUTF(director);
										
								} 
								catch(IOException e)
								{
									e.printStackTrace();
								}
								finally
								{
									if (dos != null)
										{
											dos.close();
											fos.close();
										}
								}
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
		f2.renameTo(f);
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
			System.out.println("4. Borrar una película a partir de su código");
			System.out.println("0. Salir del programa");
			menu = Integer.parseInt(br.readLine());

				while ((menu <0) || (menu >4)) // para valores númericos fuera de rango 0 a 4
				{
					System.out.println("Por favor, escoja un valor entre 0 y 4");
					menu = Integer.parseInt(br.readLine());
				}

			switch (menu)
			{
			case 1: System.out.println ("  ALTA PELICULA  ");Videoclub.altaPelicula();break;
			case 2: System.out.println ("  CONSULTA PELICULA POR CODIGO   ");Videoclub.consultaPelicula();break;
			case 3: System.out.println ("  LISTADO DE PELICULAS, CODIGO, TITULO, DIRECTOR   ");Videoclub.listaPelicula();break;
			case 4: System.out.println ("      BORRANDO PELICULA   ");Videoclub.borraPelicula();break;
			case 0: System.out.println (" Saliendo del programa ......... hasta pronto.");break;

			}
		}
	}

	
}
