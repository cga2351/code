package com.viber.jni;

public class ClientEnvConfig
{
  public final String LBHost;
  public final int LBPort;
  public final String PGHost;
  public final String PGProtocol;
  public final String PTTHost;
  public final String PTTProtocol;
  public final String StickersApiPrefix;

  public ClientEnvConfig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.LBHost = paramString1;
    this.PTTHost = paramString3;
    this.PGHost = paramString2;
    this.PGProtocol = paramString4;
    this.PTTProtocol = paramString5;
    this.StickersApiPrefix = paramString6;
    this.LBPort = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ClientEnvConfig
 * JD-Core Version:    0.6.2
 */