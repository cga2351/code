package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzsx<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>>
  implements zzvv
{
  private static boolean zzbtl = false;
  protected int zzbtk = 0;

  void zzai(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public final zzte zztw()
  {
    try
    {
      zztm localzztm = zzte.zzao(zzvx());
      zzb(localzztm.zzui());
      zzte localzzte = localzztm.zzuh();
      return localzzte;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      throw new RuntimeException(62 + String.valueOf(str).length() + String.valueOf("ByteString").length() + "Serializing " + str + " to a " + "ByteString" + " threw an IOException (should never happen).", localIOException);
    }
  }

  int zztx()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsx
 * JD-Core Version:    0.6.2
 */