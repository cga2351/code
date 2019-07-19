package com.viber.jni.webrtc;

public final class IceCandidate
{
  public final String sdp;
  public final int sdpMLineIndex;
  public final String sdpMid;

  public IceCandidate(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty()))
      throw new IllegalArgumentException("sdp");
    if ((paramString2 == null) || (paramString2.isEmpty()))
      throw new IllegalArgumentException("sdpMid");
    this.sdp = paramString1;
    this.sdpMid = paramString2;
    this.sdpMLineIndex = paramInt;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    IceCandidate localIceCandidate;
    boolean bool2;
    do
    {
      int i;
      int j;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool1;
            bool1 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool1 = false;
        }
        while (localClass1 != localClass2);
        localIceCandidate = (IceCandidate)paramObject;
        i = this.sdpMLineIndex;
        j = localIceCandidate.sdpMLineIndex;
        bool1 = false;
      }
      while (i != j);
      bool2 = this.sdp.equals(localIceCandidate.sdp);
      bool1 = false;
    }
    while (!bool2);
    return this.sdpMid.equals(localIceCandidate.sdpMid);
  }

  public int hashCode()
  {
    return 31 * (31 * this.sdp.hashCode() + this.sdpMid.hashCode()) + this.sdpMLineIndex;
  }

  public String toString()
  {
    return "IceCandidate{sdp='" + this.sdp + "', sdpMid='" + this.sdpMid + "', sdpMLineIndex=" + this.sdpMLineIndex + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.webrtc.IceCandidate
 * JD-Core Version:    0.6.2
 */