package com.ibeidan.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lee
 * DATE 2020/11/9 17:04
 */
public class KafkaProduce {

    public static Producer<String, String> producer;

    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        // props.put("acks", 0);//这意味着producer发送数据后，不会等待broker确认，直接发送下一条数据，性能最快
        props.put("acks", "1");//leader partition收到消息，生产者就会收到一个来自服务器的成功响应
        props.put("retries", 0);//重试次数
        props.put("client.id","sky-produce-sdk");
        props.put("request.timeout.ms",1000);//该配置控制客户端等待请求响应的最长时间。默认30000（30秒）
       // props.put("batch.size", 16384);
       // props.put("linger.ms", 0);
       // props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("max.block.ms",1200);
        producer = new KafkaProducer(props);
        /*String kafkaServer = "localhost:9092";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "DemoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
*/
       // props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, enableIdempotency);

       /* producer = new KafkaProducer(props);*/
    }

    public void sendMessage(String message) throws Exception {
       sendMessage(new ProducerRecord<String, String>("trace_metrices_topic", message));
    }

    public void sendMessage(String topic,String message) throws Exception {
        sendMessage(new ProducerRecord<String, String>(topic, message));
    }


    public void sendMessage(final ProducerRecord message) throws Exception {

        Future future =  producer.send(message);
        future.get(200, TimeUnit.MILLISECONDS);

       /* producer.send(message, new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception e) {
                //e.printStackTrace();
                if(e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println("The offset of the record we just sent is: " + metadata.offset());
                }
               // System.out.println("发送"+metadata.offset());
            }
        });
        producer.flush();*/


    }

    private static class ProduceKafkaHolder{
        private static KafkaProduce instance = new KafkaProduce();
    }

    public static KafkaProduce getInstance(){
        return ProduceKafkaHolder.instance;
    }

}
