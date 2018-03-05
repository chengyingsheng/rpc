package com.ziroom.bsrd.rpc.client;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.net.InetSocketAddress;

/**
 * pool factory
 *
 * @author xuxueli 2015-11-5 22:07:35
 */
public class NettyClientFactory extends BasePooledObjectFactory<NettyClient> {

    private InetSocketAddress inetSocketAddress;

    public NettyClientFactory(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
    }

    @Override
    public NettyClient create() throws Exception {
        NettyClient nettyClient = new NettyClient();
        nettyClient.create(inetSocketAddress);
        return nettyClient;
    }

    @Override
    public PooledObject<NettyClient> wrap(NettyClient arg0) {
        return new DefaultPooledObject<>(arg0);
    }

    @Override
    public void destroyObject(PooledObject<NettyClient> p)
            throws Exception {
        NettyClient nettyClient = p.getObject();
        nettyClient.close();
    }

    @Override
    public boolean validateObject(PooledObject<NettyClient> p) {
        NettyClient nettyClient = p.getObject();
        return nettyClient.isValidate();
    }


}