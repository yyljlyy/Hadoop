package cn.yyljlyy.hadoop.RPC;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient {
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Bizable proxy = RPC.getProxy(Bizable.class, 10010, new InetSocketAddress("192.168.8.100", 9527), conf);
		String result = proxy.sayHi("mm");
		System.out.println(result);
	}
}
