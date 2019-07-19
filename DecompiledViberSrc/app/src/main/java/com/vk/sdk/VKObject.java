package com.vk.sdk;

import java.util.HashMap;
import java.util.Random;

public class VKObject
{
  private static final HashMap<Long, VKObject> sRegisteredObjects = new HashMap();
  private long mRegisteredObjectId = 0L;

  public static VKObject getRegisteredObject(long paramLong)
  {
    return (VKObject)sRegisteredObjects.get(Long.valueOf(paramLong));
  }

  public long registerObject()
  {
    if (sRegisteredObjects.containsKey(Long.valueOf(this.mRegisteredObjectId)))
      return this.mRegisteredObjectId;
    Random localRandom = new Random();
    long l;
    do
      l = localRandom.nextLong();
    while ((sRegisteredObjects.containsKey(Long.valueOf(l))) || (l == 0L));
    sRegisteredObjects.put(Long.valueOf(l), this);
    this.mRegisteredObjectId = l;
    return l;
  }

  public void unregisterObject()
  {
    sRegisteredObjects.remove(Long.valueOf(this.mRegisteredObjectId));
    this.mRegisteredObjectId = 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKObject
 * JD-Core Version:    0.6.2
 */