package com.hb.netty.ende.marshalling;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public class MarshallingFactory {

    public static MarshallingDecoder buildMarshallingDecoder() {
        MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
        MarshallingConfiguration config = new MarshallingConfiguration();
        config.setVersion(5);
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(factory, config);
        return new MarshallingDecoder(provider, 1024);
    }

    public static MarshallingEncoder buildMarshallingEncoder() {
        MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
        MarshallingConfiguration config = new MarshallingConfiguration();
        config.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(factory, config);
        return new MarshallingEncoder(provider);
    }
}
