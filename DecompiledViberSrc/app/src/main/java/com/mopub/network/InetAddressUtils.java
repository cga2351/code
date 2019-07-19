package com.mopub.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressUtils
{
  public static InetAddress getInetAddressByName(String paramString)
    throws UnknownHostException
  {
    return InetAddress.getByName(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.InetAddressUtils
 * JD-Core Version:    0.6.2
 */