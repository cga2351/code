package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzdoj extends IOException
{
  private zzdpj zzhid = null;

  public zzdoj(String paramString)
  {
    super(paramString);
  }

  static zzdoj zzayd()
  {
    return new zzdoj("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }

  static zzdoj zzaye()
  {
    return new zzdoj("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }

  static zzdoj zzayf()
  {
    return new zzdoj("CodedInputStream encountered a malformed varint.");
  }

  static zzdoj zzayg()
  {
    return new zzdoj("Protocol message contained an invalid tag (zero).");
  }

  static zzdoj zzayh()
  {
    return new zzdoj("Protocol message end-group tag did not match expected tag.");
  }

  static zzdok zzayi()
  {
    return new zzdok("Protocol message tag had invalid wire type.");
  }

  static zzdoj zzayj()
  {
    return new zzdoj("Failed to parse the message.");
  }

  static zzdoj zzayk()
  {
    return new zzdoj("Protocol message had invalid UTF-8.");
  }

  public final zzdoj zzo(zzdpj paramzzdpj)
  {
    this.zzhid = paramzzdpj;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdoj
 * JD-Core Version:    0.6.2
 */