package cn.yyljlyy.hadoop.hdfs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HDFSDemo {
	FileSystem fs =null;
	@Before
	public void init() throws Exception{
		FileSystem fs = FileSystem.get(new URI("hdfs://hadoop01.yyljlyy:9000"),new Configuration());
	}
	@Test
	public void testUpload() throws Exception{
		//读取本地文件系统的文件
		FileInputStream in = new FileInputStream("e://test.txt");
		OutputStream out = fs.create(new Path("/test.txt"));
		IOUtils.copyBytes(in, out, 4096,true);
	}
	@Test
	public void testMkdir(){
		
	}	
	public static void main(String[] args) throws Exception {
		FileSystem fs = FileSystem.get(new URI("hdfs://hadoop01.yyljlyy:9000"),
				new Configuration());
		InputStream in = fs.open(new Path("/jdk1.7"));
		OutputStream out = new FileOutputStream("e://jdk1.7");
		IOUtils.copyBytes(in, out, 4096, true);
 	}
}
