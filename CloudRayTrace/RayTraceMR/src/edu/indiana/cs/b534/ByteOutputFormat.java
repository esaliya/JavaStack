package edu.indiana.cs.b534;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.util.Progressable;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Saliya Ekanayake
 */

/**
 * Class <code>ByteOutputFormat</code> is useful when you have a byte output
 * from the reduce. This will write the set of bytes WITHOUT the key
 * as a binary file.
 * @param <K> key
 * @param <V> value
 */
public class ByteOutputFormat<K, V> extends FileOutputFormat<K, V> {
    protected static class ByteRecordWriter<K, V> implements RecordWriter<K, V> {
        private DataOutputStream out;

        public ByteRecordWriter(DataOutputStream out) {
            this.out = out;
        }

        public void write(K key, V value) throws IOException {
            boolean nullValue = value == null || value instanceof NullWritable;
            if (!nullValue) {
                BytesWritable bw = (BytesWritable) value;
                out.write(bw.get(), 0, bw.getSize());
            }
        }

        public synchronized void close(Reporter reporter) throws IOException {
            out.close();
        }
    }

    @Override
    public RecordWriter<K, V> getRecordWriter(FileSystem ignored, JobConf job, String name, Progressable progress)
            throws IOException {
        if (!getCompressOutput(job)) {
            Path file = FileOutputFormat.getTaskOutputPath(job, name);
            FileSystem fs = file.getFileSystem(job);
            FSDataOutputStream fileOut = fs.create(file, progress);
            return new ByteRecordWriter<K, V>(fileOut);
        } else {
            Class <? extends CompressionCodec> codecClass = getOutputCompressorClass(job, DefaultCodec.class);
            CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, job);
            Path file = FileOutputFormat.getTaskOutputPath(job, name + codec.getDefaultExtension());
            FileSystem fs = file.getFileSystem(job);
            FSDataOutputStream fileOut = fs.create(file, progress);
            return new ByteRecordWriter<K, V>(new DataOutputStream(codec.createOutputStream(fileOut)));

        }

    }
}
