package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzdoa<MessageType extends zzdoa<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmh<MessageType, BuilderType>
{
  private static Map<Object, zzdoa<?, ?>> zzhhf = new ConcurrentHashMap();
  protected zzdqt zzhhd = zzdqt.zzazz();
  private int zzhhe = -1;

  protected static <T extends zzdoa<T, ?>> T zza(T paramT, zzdmq paramzzdmq)
    throws zzdoj
  {
    zzdoa localzzdoa1 = zza(paramT, paramzzdmq, zzdnn.zzaxd());
    if (localzzdoa1 != null)
    {
      boolean bool3 = Boolean.TRUE.booleanValue();
      int m = ((Byte)localzzdoa1.zza(zze.zzhhk, null, null)).byteValue();
      int n;
      if (m == 1)
        n = 1;
      while (n == 0)
      {
        throw new zzdqr(localzzdoa1).zzazx().zzo(localzzdoa1);
        if (m == 0)
        {
          n = 0;
        }
        else
        {
          boolean bool4 = zzdpw.zzazg().zzan(localzzdoa1).zzam(localzzdoa1);
          int i1;
          if (bool3)
          {
            i1 = zze.zzhhl;
            if (!bool4)
              break label129;
          }
          label129: for (zzdoa localzzdoa3 = localzzdoa1; ; localzzdoa3 = null)
          {
            localzzdoa1.zza(i1, localzzdoa3, null);
            n = bool4;
            break;
          }
        }
      }
    }
    if (localzzdoa1 != null)
    {
      boolean bool1 = Boolean.TRUE.booleanValue();
      int i = ((Byte)localzzdoa1.zza(zze.zzhhk, null, null)).byteValue();
      int j;
      if (i == 1)
        j = 1;
      while (j == 0)
      {
        throw new zzdqr(localzzdoa1).zzazx().zzo(localzzdoa1);
        if (i == 0)
        {
          j = 0;
        }
        else
        {
          boolean bool2 = zzdpw.zzazg().zzan(localzzdoa1).zzam(localzzdoa1);
          int k;
          if (bool1)
          {
            k = zze.zzhhl;
            if (!bool2)
              break label253;
          }
          label253: for (zzdoa localzzdoa2 = localzzdoa1; ; localzzdoa2 = null)
          {
            localzzdoa1.zza(k, localzzdoa2, null);
            j = bool2;
            break;
          }
        }
      }
    }
    return localzzdoa1;
  }

  private static <T extends zzdoa<T, ?>> T zza(T paramT, zzdmq paramzzdmq, zzdnn paramzzdnn)
    throws zzdoj
  {
    try
    {
      zzdnc localzzdnc = paramzzdmq.zzavp();
      zzdoa localzzdoa = zza(paramT, localzzdnc, paramzzdnn);
      try
      {
        localzzdnc.zzfp(0);
        return localzzdoa;
      }
      catch (zzdoj localzzdoj2)
      {
        throw localzzdoj2.zzo(localzzdoa);
      }
    }
    catch (zzdoj localzzdoj1)
    {
      throw localzzdoj1;
    }
  }

  private static <T extends zzdoa<T, ?>> T zza(T paramT, zzdnc paramzzdnc, zzdnn paramzzdnn)
    throws zzdoj
  {
    zzdoa localzzdoa = (zzdoa)paramT.zza(zze.zzhhn, null, null);
    try
    {
      zzdpw.zzazg().zzan(localzzdoa).zza(localzzdoa, zzdnf.zza(paramzzdnc), paramzzdnn);
      zzdpw.zzazg().zzan(localzzdoa).zzaa(localzzdoa);
      return localzzdoa;
    }
    catch (IOException localIOException)
    {
      if ((localIOException.getCause() instanceof zzdoj))
        throw ((zzdoj)localIOException.getCause());
      throw new zzdoj(localIOException.getMessage()).zzo(localzzdoa);
    }
    catch (RuntimeException localRuntimeException)
    {
      if ((localRuntimeException.getCause() instanceof zzdoj))
        throw ((zzdoj)localRuntimeException.getCause());
      throw localRuntimeException;
    }
  }

  protected static <T extends zzdoa<T, ?>> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzdoj
  {
    zzdoa localzzdoa1 = zza(paramT, paramArrayOfByte, 0, paramArrayOfByte.length, zzdnn.zzaxd());
    if (localzzdoa1 != null)
    {
      boolean bool1 = Boolean.TRUE.booleanValue();
      int i = ((Byte)localzzdoa1.zza(zze.zzhhk, null, null)).byteValue();
      int j;
      if (i == 1)
        j = 1;
      while (j == 0)
      {
        throw new zzdqr(localzzdoa1).zzazx().zzo(localzzdoa1);
        if (i == 0)
        {
          j = 0;
        }
        else
        {
          boolean bool2 = zzdpw.zzazg().zzan(localzzdoa1).zzam(localzzdoa1);
          int k;
          if (bool1)
          {
            k = zze.zzhhl;
            if (!bool2)
              break label130;
          }
          label130: for (zzdoa localzzdoa2 = localzzdoa1; ; localzzdoa2 = null)
          {
            localzzdoa1.zza(k, localzzdoa2, null);
            j = bool2;
            break;
          }
        }
      }
    }
    return localzzdoa1;
  }

  private static <T extends zzdoa<T, ?>> T zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzdnn paramzzdnn)
    throws zzdoj
  {
    zzdoa localzzdoa = (zzdoa)paramT.zza(zze.zzhhn, null, null);
    try
    {
      zzdpw.zzazg().zzan(localzzdoa).zza(localzzdoa, paramArrayOfByte, 0, paramInt2, new zzdmn(paramzzdnn));
      zzdpw.zzazg().zzan(localzzdoa).zzaa(localzzdoa);
      if (localzzdoa.zzhcf != 0)
        throw new RuntimeException();
    }
    catch (IOException localIOException)
    {
      if ((localIOException.getCause() instanceof zzdoj))
        throw ((zzdoj)localIOException.getCause());
      throw new zzdoj(localIOException.getMessage()).zzo(localzzdoa);
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw zzdoj.zzayd().zzo(localzzdoa);
    }
    return localzzdoa;
  }

  protected static <T extends zzdoa<T, ?>> T zza(T paramT, byte[] paramArrayOfByte, zzdnn paramzzdnn)
    throws zzdoj
  {
    zzdoa localzzdoa1 = zza(paramT, paramArrayOfByte, 0, paramArrayOfByte.length, paramzzdnn);
    if (localzzdoa1 != null)
    {
      boolean bool1 = Boolean.TRUE.booleanValue();
      int i = ((Byte)localzzdoa1.zza(zze.zzhhk, null, null)).byteValue();
      int j;
      if (i == 1)
        j = 1;
      while (j == 0)
      {
        throw new zzdqr(localzzdoa1).zzazx().zzo(localzzdoa1);
        if (i == 0)
        {
          j = 0;
        }
        else
        {
          boolean bool2 = zzdpw.zzazg().zzan(localzzdoa1).zzam(localzzdoa1);
          int k;
          if (bool1)
          {
            k = zze.zzhhl;
            if (!bool2)
              break label130;
          }
          label130: for (zzdoa localzzdoa2 = localzzdoa1; ; localzzdoa2 = null)
          {
            localzzdoa1.zza(k, localzzdoa2, null);
            j = bool2;
            break;
          }
        }
      }
    }
    return localzzdoa1;
  }

  protected static Object zza(zzdpj paramzzdpj, String paramString, Object[] paramArrayOfObject)
  {
    return new zzdpy(paramzzdpj, paramString, paramArrayOfObject);
  }

  static Object zza(Method paramMethod, Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      if ((localThrowable instanceof Error))
        throw ((Error)localThrowable);
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", localThrowable);
    }
  }

  protected static <T extends zzdoa<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzhhf.put(paramClass, paramT);
  }

  protected static final <T extends zzdoa<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zze.zzhhk, null, null)).byteValue();
    if (i == 1)
      return true;
    if (i == 0)
      return false;
    return zzdpw.zzazg().zzan(paramT).zzam(paramT);
  }

  protected static zzdog zzaxr()
  {
    return zzdob.zzayc();
  }

  protected static <E> zzdoi<E> zzaxs()
  {
    return zzdpx.zzazh();
  }

  static <T extends zzdoa<?, ?>> T zze(Class<T> paramClass)
  {
    zzdoa localzzdoa = (zzdoa)zzhhf.get(paramClass);
    if (localzzdoa == null);
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      localzzdoa = (zzdoa)zzhhf.get(paramClass);
      if (localzzdoa != null)
        break label101;
      localzzdoa = (zzdoa)((zzdoa)zzdqy.zzi(paramClass)).zza(zze.zzhhp, null, null);
      if (localzzdoa == null)
        throw new IllegalStateException();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalStateException("Class initialization cannot fail.", localClassNotFoundException);
    }
    zzhhf.put(paramClass, localzzdoa);
    label101: return localzzdoa;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!((zzdoa)zza(zze.zzhhp, null, null)).getClass().isInstance(paramObject))
      return false;
    return zzdpw.zzazg().zzan(this).equals(this, (zzdoa)paramObject);
  }

  public int hashCode()
  {
    if (this.zzhcf != 0)
      return this.zzhcf;
    this.zzhcf = zzdpw.zzazg().zzan(this).hashCode(this);
    return this.zzhcf;
  }

  public final boolean isInitialized()
  {
    boolean bool1 = Boolean.TRUE.booleanValue();
    int i = ((Byte)zza(zze.zzhhk, null, null)).byteValue();
    if (i == 1)
      return true;
    if (i == 0)
      return false;
    boolean bool2 = zzdpw.zzazg().zzan(this).zzam(this);
    int j;
    if (bool1)
    {
      j = zze.zzhhl;
      if (!bool2)
        break label78;
    }
    label78: for (zzdoa localzzdoa = this; ; localzzdoa = null)
    {
      zza(j, localzzdoa, null);
      return bool2;
    }
  }

  public String toString()
  {
    return zzdpm.zza(this, super.toString());
  }

  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);

  final int zzavg()
  {
    return this.zzhhe;
  }

  public final int zzaxj()
  {
    if (this.zzhhe == -1)
      this.zzhhe = zzdpw.zzazg().zzan(this).zzak(this);
    return this.zzhhe;
  }

  public final void zzb(zzdnh paramzzdnh)
    throws IOException
  {
    zzdpw.zzazg().zzg(getClass()).zza(this, zzdnj.zza(paramzzdnh));
  }

  final void zzfi(int paramInt)
  {
    this.zzhhe = paramInt;
  }

  public static class zza<MessageType extends zzdoa<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmi<MessageType, BuilderType>
  {
    private final MessageType zzhhg;
    protected MessageType zzhhh;
    private boolean zzhhi;

    protected zza(MessageType paramMessageType)
    {
      this.zzhhg = paramMessageType;
      this.zzhhh = ((zzdoa)paramMessageType.zza(zzdoa.zze.zzhhn, null, null));
      this.zzhhi = false;
    }

    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzdpw.zzazg().zzan(paramMessageType1).zzd(paramMessageType1, paramMessageType2);
    }

    private final BuilderType zzb(zzdnc paramzzdnc, zzdnn paramzzdnn)
      throws IOException
    {
      zzaxw();
      try
      {
        zzdpw.zzazg().zzan(this.zzhhh).zza(this.zzhhh, zzdnf.zza(paramzzdnc), paramzzdnn);
        return this;
      }
      catch (RuntimeException localRuntimeException)
      {
        if ((localRuntimeException.getCause() instanceof IOException))
          throw ((IOException)localRuntimeException.getCause());
        throw localRuntimeException;
      }
    }

    private final BuilderType zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzdnn paramzzdnn)
      throws zzdoj
    {
      zzaxw();
      try
      {
        zzdpw.zzazg().zzan(this.zzhhh).zza(this.zzhhh, paramArrayOfByte, 0, paramInt2 + 0, new zzdmn(paramzzdnn));
        return this;
      }
      catch (zzdoj localzzdoj)
      {
        throw localzzdoj;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw zzdoj.zzayd();
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Reading from byte array should not throw IOException.", localIOException);
      }
    }

    public final boolean isInitialized()
    {
      return zzdoa.zza(this.zzhhh, false);
    }

    public final BuilderType zza(MessageType paramMessageType)
    {
      zzaxw();
      zza(this.zzhhh, paramMessageType);
      return this;
    }

    protected final void zzaxw()
    {
      if (this.zzhhi)
      {
        zzdoa localzzdoa = (zzdoa)this.zzhhh.zza(zzdoa.zze.zzhhn, null, null);
        zza(localzzdoa, this.zzhhh);
        this.zzhhh = localzzdoa;
        this.zzhhi = false;
      }
    }

    public MessageType zzaxx()
    {
      if (this.zzhhi)
        return this.zzhhh;
      zzdoa localzzdoa = this.zzhhh;
      zzdpw.zzazg().zzan(localzzdoa).zzaa(localzzdoa);
      this.zzhhi = true;
      return this.zzhhh;
    }

    public final MessageType zzaxy()
    {
      zzdoa localzzdoa1 = (zzdoa)zzaxz();
      boolean bool1 = Boolean.TRUE.booleanValue();
      int i = ((Byte)localzzdoa1.zza(zzdoa.zze.zzhhk, null, null)).byteValue();
      int j;
      if (i == 1)
        j = 1;
      while (j == 0)
      {
        throw new zzdqr(localzzdoa1);
        if (i == 0)
        {
          j = 0;
        }
        else
        {
          boolean bool2 = zzdpw.zzazg().zzan(localzzdoa1).zzam(localzzdoa1);
          int k;
          if (bool1)
          {
            k = zzdoa.zze.zzhhl;
            if (!bool2)
              break label112;
          }
          label112: for (zzdoa localzzdoa2 = localzzdoa1; ; localzzdoa2 = null)
          {
            localzzdoa1.zza(k, localzzdoa2, null);
            j = bool2;
            break;
          }
        }
      }
      return localzzdoa1;
    }
  }

  public static final class zzb<T extends zzdoa<T, ?>> extends zzdmj<T>
  {
    private final T zzhhg;

    public zzb(T paramT)
    {
      this.zzhhg = paramT;
    }
  }

  public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzdoa<MessageType, BuilderType>
    implements zzdpl
  {
    protected zzdnr<Object> zzhhj = zzdnr.zzaxi();
  }

  public static final class zzd<ContainingType extends zzdpj, Type> extends zzdnl<ContainingType, Type>
  {
  }

  public static enum zze
  {
    static
    {
      int[] arrayOfInt1 = new int[7];
      arrayOfInt1[0] = zzhhk;
      arrayOfInt1[1] = zzhhl;
      arrayOfInt1[2] = zzhhm;
      arrayOfInt1[3] = zzhhn;
      arrayOfInt1[4] = zzhho;
      arrayOfInt1[5] = zzhhp;
      arrayOfInt1[6] = zzhhq;
      zzhhr = arrayOfInt1;
      zzhhs = 1;
      zzhht = 2;
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = zzhhs;
      arrayOfInt2[1] = zzhht;
      zzhhu = arrayOfInt2;
      zzhhv = 1;
      zzhhw = 2;
      int[] arrayOfInt3 = new int[2];
      arrayOfInt3[0] = zzhhv;
      arrayOfInt3[1] = zzhhw;
    }

    public static int[] zzayb()
    {
      return (int[])zzhhr.clone();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdoa
 * JD-Core Version:    0.6.2
 */