package com.wyh.dfs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadGraph {
	private Scanner scanner;
	
	public ReadGraph(Graph graph,String filename) {
		
		readFile(filename);
		
		try {
			int V=scanner.nextInt();
			if(V<0)
				throw new IllegalArgumentException("number of vertices in a graph must be nonnegative.");
			
			assert V==graph.V();//确认文件里读出的点数和图中的点数是一致的
			
			int E=scanner.nextInt();
			
			if(E<0)
				throw new IllegalArgumentException("number of edges in a graph must be nonnegative.");
			//有多少边，则循环多少次读取，从0开始读
			for(int i=0;i<E;i++) {
				int v=scanner.nextInt();
				int w=scanner.nextInt();
				assert v>=0 && v<V;
				assert w>=0 && v<V;
				graph.addEdge(v, w);
			}
		} 
		catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
	}
	private void readFile(String filename) {
		assert filename !=null;
		try {
			File file=new File(filename);
			if(file.exists()) {
				FileInputStream fis=new FileInputStream(file);
				scanner=new Scanner(new BufferedInputStream(fis),"UTF-8");
				scanner.useLocale(Locale.ENGLISH);
			}
			else
				throw new IllegalArgumentException(filename+"dosen't exist.");
		} 
		catch (IOException ioe) {
			throw new IllegalArgumentException("Could not open "+filename,ioe);
		}
	}
}
