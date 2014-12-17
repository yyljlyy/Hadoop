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
		//����Job����
		Job job = Job.getInstance(new Configuration());
		//ע��:һ��Ҫ��main�������ڵ���д��ȥ
		job.setJarByClass(WordCount.class);
		//����Mapper�������
		job.setMapperClass(WCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		FileInputFormat.setInputPaths(job, new Path("/words.txt"));
		//����Reduces�������
		job.setReducerClass(WCReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		FileOutputFormat.setOutputPath(job, new Path("/wcount1217"));
		//�ȴ��ύ����
		job.waitForCompletion(true);
	}
}
