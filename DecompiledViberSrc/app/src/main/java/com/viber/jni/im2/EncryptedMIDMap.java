package com.viber.jni.im2;

public class EncryptedMIDMap
{
  public final String encryptedMID;
  public final String mid;

  public EncryptedMIDMap(String paramString1, String paramString2)
  {
    this.mid = Im2Utils.checkStringValue(paramString1);
    this.encryptedMID = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "EncryptedMIDMap{mid='" + this.mid + '\'' + ", encryptedMID='" + this.encryptedMID + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.EncryptedMIDMap
 * JD-Core Version:    0.6.2
 */