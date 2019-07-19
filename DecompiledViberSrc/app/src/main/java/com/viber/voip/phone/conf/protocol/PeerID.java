package com.viber.voip.phone.conf.protocol;

import com.google.d.a.c;

public final class PeerID
{

  @c(a="cid")
  public final int memberDeviceID;

  @c(a="mid")
  public final String memberID;

  public PeerID(String paramString, int paramInt)
  {
    this.memberID = paramString;
    if (paramString.isEmpty())
      throw new IllegalArgumentException("memberID");
    this.memberDeviceID = paramInt;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.memberID;
    arrayOfObject[1] = Integer.valueOf(this.memberDeviceID);
    return String.format("PeerID(MID=%s, CID=%d)", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.protocol.PeerID
 * JD-Core Version:    0.6.2
 */