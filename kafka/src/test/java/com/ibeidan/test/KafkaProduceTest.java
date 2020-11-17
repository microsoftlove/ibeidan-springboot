package com.ibeidan.test;

import com.ibeidan.kafka.KafkaProduce;

/**
 * @author lee
 * DATE 2020/11/9 19:47
 */
public class KafkaProduceTest {

    public static void main(String[] args) {
        KafkaProduce kafkaProduce = KafkaProduce.getInstance();

        String messageStr;
        for (int i = 0; i < 1; i++) {
            long start = System.currentTimeMillis();
            long end = start + 250;
            int s = 1;//random.nextInt(3);
           // System.out.println("s======"+s);
            int ss = 2;//random.nextInt(3);
           // System.out.println("ss======"+ss);
            messageStr ="{\"serviceId\":1001,\"serviceInstanceId\":"+s+",\"endpointId\":"+ss+",\"startTime\":"+start+",\"endTime\":"+end+",\"isError\":1,\"dataBinary\":\"Cg0KCxOJAeDy8qrtgb0cEqgBCAEYmMj4/tMuINfI+P7TLjobRWxhc3RpY3NlYXJjaC9TZWFyY2hSZXF1ZXN0SjcxOTIuMTY4LjIxLjM4OjkyMDAsMTkyLjE2OC4yMS45OjkyMDAsMTkyLjE2OC4yMS4xNDo5MjAwUAFYAWBNehgKB2RiLnR5cGUSDUVsYXN0aWNzZWFyY2h6IAoLZGIuaW5zdGFuY2USEVtvcmRlcnNfMjAyMDAzMzBdEkoIAhjayPj+0y4g4sj4/tMuOglKZWRpcy9zZXRABlABWAVgHnoQCgdkYi50eXBlEgVSZWRpc3oTCgxkYi5zdGF0ZW1lbnQSA3NldBJSCAMY4sj4/tMuIOvI+P7TLjoNSmVkaXMvcGV4cGlyZUAGUAFYBWAeehAKB2RiLnR5cGUSBVJlZGlzehcKDGRiLnN0YXRlbWVudBIHcGV4cGlyZRLEBAgEGPzI+P7TLiCLyfj+0y46JE15c3FsL0pEQkkvUHJlcGFyZWRTdGF0ZW1lbnQvZXhlY3V0ZUAFUAFYAWAheg4KB2RiLnR5cGUSA3NxbHoWCgtkYi5pbnN0YW5jZRIHb3JkZXJkYnrbAwoMZGIuc3RhdGVtZW50EsoDU0VMRUNUCiAgICAgICAgaS5pZCwKICAgICAgICBpLmluZm9faWQgaW5mb0lkLAogICAgICAgIGkub3JkZXJfaWQgb3JkZXJJZCwKICAgICAgICBpLmF0dHJfY29udGVudCBhdHRyQ29udGVudAogICAgICAgIEZST00KICAgICAgICBvcmRlcmRiLmluZm9fYXR0cnMgaQogICAgICAgIFdIRVJFCiAgICAgICAgaS5pbmZvX2lkIElOCiAgICAgICAgICggIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICkSsxAIBRi0yfj+0y4g08n4/tMuOiRNeXNxbC9KREJJL1ByZXBhcmVkU3RhdGVtZW50L2V4ZWN1dGVABVABWAFgIXoOCgdkYi50eXBlEgNzcWx6FgoLZGIuaW5zdGFuY2USB29yZGVyZGJ6yg8KDGRiLnN0YXRlbWVudBK5D1NFTEVDVAogICAgICAgIGMub3JkZXJJZCwKICAgICAgICBkLnBheVR5cGUsCiAgICAgICAgZC5wYXlBZ2VudCwKICAgICAgICBjLnRvdGFsTW9uZXksCiAgICAgICAgYy5kaXNjb3VudCwKICAgICAgICBjLmJhbGFuY2UKICAgICAgICBGUk9NCiAgICAgICAgKAogICAgICAgIFNFTEVDVAogICAgICAgIG1pbihpZCkgaWQsCiAgICAgICAgcG0ub3JkZXJfaWQgb3JkZXJJZCwKICAgICAgICBTVU0ocG0udG90YWwpIHRvdGFsTW9uZXksCiAgICAgICAgc3VtKHBtLmNvdXBvbiArIHBtLmNoYW5uZWxfZGlzY291bnQpIGRpc2NvdW50LAogICAgICAgIHN1bShwbS5iYWxhbmNlKSBiYWxhbmNlCiAgICAgICAgRlJPTQogICAgICAgICgKICAgICAgICBTRUxFQ1QKICAgICAgICBhLioKICAgICAgICBGUk9NCiAgICAgICAgKAogICAgICAgIFNFTEVDVAogICAgICAgIGlkLAogICAgICAgIG9yZGVyX2lkLAogICAgICAgIHRvdGFsLAogICAgICAgIGNvdXBvbiwKICAgICAgICBjaGFubmVsX2Rpc2NvdW50LAogICAgICAgIGJhbGFuY2UsCiAgICAgICAgU1RBVFVTCiAgICAgICAgRlJPTQogICAgICAgIG9yZGVyZGIucGF5bWVudHMgcAogICAgICAgIFdIRVJFCiAgICAgICAgcC5vcmRlcl9pZCBJTgogICAgICAgICAoICAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICApIAogICAgICAgICAKICAgICAgICApIGEKICAgICAgICBKT0lOICgKICAgICAgICBTRUxFQ1QKICAgICAgICBtYXgoU1RBVFVTKSBTVEFUVVMsCiAgICAgICAgb3JkZXJfaWQKICAgICAgICBGUk9NCiAgICAgICAgcGF5bWVudHMgYQogICAgICAgIFdIRVJFCiAgICAgICAgb3JkZXJfaWQgSU4KICAgICAgICAgKCAgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgKSAKICAgICAgICAgCiAgICAgICAgR1JPVVAgQlkKICAgICAgICBvcmRlcl9pZAogICAgICAgICkgYiBPTiBhLmBzdGF0dXNgID0gYi5TVEFUVVMgYW5kIGEub3JkZXJfaWQgPSBiLm9yZGVyX2lkCiAgICAgICAgKSBwbQogICAgICAgIEdST1VQIEJZCiAgICAgICAgb3JkZXJfaWQKICAgICAgICApIGMKICAgICAgICBKT0lOICgKICAgICAgICBTRUxFQ1QKICAgICAgICBpZCwKICAgICAgICBwLnBheV90eXBlIHBheVR5cGUsCiAgICAgICAgcC5wYXlfYWdlbnQgcGF5QWdlbnQKICAgICAgICBGUk9NCiAgICAgICAgb3JkZXJkYi5wYXltZW50cyBwCiAgICAgICAgV0hFUkUKICAgICAgICBwLm9yZGVyX2lkIElOCiAgICAgICAgICggIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICkgCiAgICAgICAgIAogICAgICAgICkgZCBPTiBjLmlkID0gZC5pZBKWBAgGGPrJ+P7TLiCMyvj+0y46JE15c3FsL0pEQkkvUHJlcGFyZWRTdGF0ZW1lbnQvZXhlY3V0ZUAFUAFYAWAheg4KB2RiLnR5cGUSA3NxbHoWCgtkYi5pbnN0YW5jZRIHb3JkZXJkYnqtAwoMZGIuc3RhdGVtZW50EpwDU0VMRUNUCiAgICAgICAgby5vcmRlcl9pZCBvcmRlcklkLAogICAgICAgIG8uYXR0cl9jb250ZW50IGF0dHJDb250ZW50CiAgICAgICAgRlJPTQogICAgICAgIG9yZGVyZGIub3JkZXJfYXR0cnMgbwogICAgICAgIHdoZXJlIG8ub3JkZXJfaWQgaW4KICAgICAgICAgKCAgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgKRLyBQgHGKvK+P7TLiC9yvj+0y46JE15c3FsL0pEQkkvUHJlcGFyZWRTdGF0ZW1lbnQvZXhlY3V0ZUAFUAFYAWAheg4KB2RiLnR5cGUSA3NxbHoWCgtkYi5pbnN0YW5jZRIHb3JkZXJkYnqJBQoMZGIuc3RhdGVtZW50EvgEU0VMRUNUCiAgICAgICAgcC5vcmRlcl9pZCBvcmRlcklkLAogICAgICAgIHAub3JkZXJfbnVtYmVyIG9yZGVyTnVtYmVyLAogICAgICAgIHAubmlnaHRfZmVlIG5pZ2h0RmVlLAogICAgICAgIHAuYWRkaXRpb25fZmVlIGFkZGl0aW9uRmVlLAogICAgICAgIHAucHJlbWl1bV9mZWUgcHJlbWl1bUZlZSwKICAgICAgICBwLnByZW1pdW1fdHlwZSBwcmVtaXVtVHlwZSwKICAgICAgICBwLnByZW1pdW1fcmVhc29uIHByZW1pdW1SZWFzb24sCiAgICAgICAgcC5wcmVtaXVtX2Ftb3VudCBwcmVtaXVtQW1vdW50CiAgICAgICAgRlJPTQogICAgICAgIG9yZGVyZGIucGF5bWVudF9kZXRhaWxzIHAKICAgICAgICB3aGVyZSBwLm9yZGVyX2lkIGluCiAgICAgICAgICggIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICkS2wYICBjhyvj+0y4g8cr4/tMuOiRNeXNxbC9KREJJL1ByZXBhcmVkU3RhdGVtZW50L2V4ZWN1dGVABVABWAFgIXoOCgdkYi50eXBlEgNzcWx6FgoLZGIuaW5zdGFuY2USB29yZGVyZGJ68gUKDGRiLnN0YXRlbWVudBLhBVNFTEVDVAogICAgICAgICAgICBkLmlkLAogICAgICAgICAgICBkLm9yZGVyX2lkIG9yZGVySWQsCiAgICAgICAgICAgIGQudXNlcl9pZCB1c2VySWQsCiAgICAgICAgICAgIGQuY3JlYXRvcl9tb2JpbGUgY3JlYXRvck1vYmlsZSwKICAgICAgICAgICAgZC5nb29kcywKICAgICAgICAgICAgZC5mcm9tX25hbWUgZnJvbU5hbWUsCiAgICAgICAgICAgIGQuZnJvbV9tb2JpbGUgZnJvbU1vYmlsZSwKICAgICAgICAgICAgZC5mcm9tX2FkZHJlc3MgZnJvbUFkZHJlc3MsCiAgICAgICAgICAgIGQudG9fbmFtZSB0b05hbWUsCiAgICAgICAgICAgIGQudG9fbW9iaWxlIHRvTW9iaWxlLAogICAgICAgICAgICBkLnRvX2FkZHJlc3MgdG9BZGRyZXNzLAogICAgICAgICAgICBkLnN0YXR1cwogICAgICAgIEZST00KICAgICAgICAgICAgb3JkZXJkYi5pbmZvcyBkCiAgICAgICAgV0hFUkUKICAgICAgICAgICAgZC5vcmRlcl9pZCBJTgogICAgICAgICAoICAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICApEtwECAkYm8v4/tMuIKrL+P7TLjokTXlzcWwvSkRCSS9QcmVwYXJlZFN0YXRlbWVudC9leGVjdXRlQAVQAVgBYCF6DgoHZGIudHlwZRIDc3FsehYKC2RiLmluc3RhbmNlEgdvcmRlcmRievMDCgxkYi5zdGF0ZW1lbnQS4gNTRUxFQ1QKICAgICAgICBvLmlkLAogICAgICAgIG8uYXBwb2ludF90eXBlIGFwcG9pbnRUeXBlLAogICAgICAgIG8udHJhdmVsX3dheSB0cmF2ZWxXYXksCiAgICAgICAgby5jb3VyaWVyX3RyYXZlbF93YXkgY291cmllclRyYXZlbFdheSwKICAgICAgICBvLmNpdHkKICAgICAgICBGUk9NCiAgICAgICAgb3JkZXJkYi5vcmRlcnMgbwogICAgICAgIHdoZXJlIG8uaWQgaW4KICAgICAgICAgKCAgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgLCAKICAgICAgICAgICAgPwogICAgICAgICAsIAogICAgICAgICAgICA/CiAgICAgICAgICwgCiAgICAgICAgICAgID8KICAgICAgICAgKRKFARD///////////8BGPbH+P7TLiDUy/j+0y46Gi9vcmRlci1zZWFyY2gvY3NvcmRlci9saXN0WANgDno2CgN1cmwSL2h0dHA6Ly9sb2NhbGhvc3Q6ODA4OS9vcmRlci1zZWFyY2gvY3NvcmRlci9saXN0ehIKC2h0dHAubWV0aG9kEgNHRVQYAiAT\"}\n";
            try {
                kafkaProduce.sendMessage("trace_metrices_topic",messageStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
