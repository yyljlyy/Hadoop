package cn.yyljlyy.hadoop.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCount {
	
	public static void main(String[] args) throws Exception {
		//构建Job对象
		Job job = Job.getInstance(new Configuration());
		//注意:一定要把main方法所在的类写进去
		job.setJarByClass(WordCount.class);
		//设置Mapper相关属性
		job.setMapperClass(WCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		FileInputFormat.setInputPaths(job, new Path("/words.txt"));
		//设置Reduces相关属性
		job.setReducerClass(WCReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		FileOutputFormat.setOutputPath(job, new Path("/wcount1217"));
		//等待提交任务
		job.waitForCompletion(true);
	}
}
