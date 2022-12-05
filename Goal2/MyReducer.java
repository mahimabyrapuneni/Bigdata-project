package Goal2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
    
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
        int v = 0;
        for(IntWritable value: values){
            v = value.get();
        }
        context.write(key, new IntWritable(v));
               
    }
}
