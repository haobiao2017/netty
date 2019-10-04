package com.hb.netty.ende.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class SubscribeReqProtoTest {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("HaoBiao");
        builder.setProductName("Netty Book");
        builder.setAddress("Chengdu");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode:" + req.toString());
        SubscribeReqProto.SubscribeReq result = decode(encode(req));
        System.out.println("After decode:" + result.toString());
        System.out.println("Assert equal:--->" + result.equals(req));
    }
}
