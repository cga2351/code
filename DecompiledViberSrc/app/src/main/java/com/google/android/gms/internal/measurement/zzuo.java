package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzuo<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsx<MessageType, BuilderType>
{
  private static Map<Object, zzuo<?, ?>> zzbyh = new ConcurrentHashMap();
  protected zzxe zzbyf = zzxe.zzyl();
  private int zzbyg = -1;

  static <T extends zzuo<T, ?>> T zza(T paramT, zztq paramzztq, zzub paramzzub)
    throws zzuv
  {
    zzuo localzzuo = (zzuo)paramT.zza(zze.zzbyp, null, null);
    try
    {
      zzwh.zzxt().zzak(localzzuo).zza(localzzuo, zztt.zza(paramzztq), paramzzub);
      zzwh.zzxt().zzak(localzzuo).zzy(localzzuo);
      return localzzuo;
    }
    catch (IOException localIOException)
    {
      if ((localIOException.getCause() instanceof zzuv))
        throw ((zzuv)localIOException.getCause());
      throw new zzuv(localIOException.getMessage()).zzg(localzzuo);
    }
    catch (RuntimeException localRuntimeException)
    {
      if ((localRuntimeException.getCause() instanceof zzuv))
        throw ((zzuv)localRuntimeException.getCause());
      throw localRuntimeException;
    }
  }

  protected static Object zza(zzvv paramzzvv, String paramString, Object[] paramArrayOfObject)
  {
    return new zzwj(paramzzvv, paramString, paramArrayOfObject);
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

  protected static <T extends zzuo<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzbyh.put(paramClass, paramT);
  }

  protected static final <T extends zzuo<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zze.zzbym, null, null)).byteValue();
    if (i == 1)
      return true;
    if (i == 0)
      return false;
    return zzwh.zzxt().zzak(paramT).zzaj(paramT);
  }

  static <T extends zzuo<?, ?>> T zzg(Class<T> paramClass)
  {
    zzuo localzzuo = (zzuo)zzbyh.get(paramClass);
    if (localzzuo == null);
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      localzzuo = (zzuo)zzbyh.get(paramClass);
      if (localzzuo != null)
        break label101;
      localzzuo = (zzuo)((zzuo)zzxj.zzk(paramClass)).zza(zze.zzbyr, null, null);
      if (localzzuo == null)
        throw new IllegalStateException();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalStateException("Class initialization cannot fail.", localClassNotFoundException);
    }
    zzbyh.put(paramClass, localzzuo);
    label101: return localzzuo;
  }

  protected static <E> zzuu<E> zzwg()
  {
    return zzwi.zzxu();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!((zzuo)zza(zze.zzbyr, null, null)).getClass().isInstance(paramObject))
      return false;
    return zzwh.zzxt().zzak(this).equals(this, (zzuo)paramObject);
  }

  public int hashCode()
  {
    if (this.zzbtk != 0)
      return this.zzbtk;
    this.zzbtk = zzwh.zzxt().zzak(this).hashCode(this);
    return this.zzbtk;
  }

  public final boolean isInitialized()
  {
    boolean bool1 = Boolean.TRUE.booleanValue();
    int i = ((Byte)zza(zze.zzbym, null, null)).byteValue();
    if (i == 1)
      return true;
    if (i == 0)
      return false;
    boolean bool2 = zzwh.zzxt().zzak(this).zzaj(this);
    int j;
    if (bool1)
    {
      j = zze.zzbyn;
      if (!bool2)
        break label78;
    }
    label78: for (zzuo localzzuo = this; ; localzzuo = null)
    {
      zza(j, localzzuo, null);
      return bool2;
    }
  }

  public String toString()
  {
    return zzvy.zza(this, super.toString());
  }

  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);

  final void zzai(int paramInt)
  {
    this.zzbyg = paramInt;
  }

  public final void zzb(zztv paramzztv)
    throws IOException
  {
    zzwh.zzxt().zzi(getClass()).zza(this, zztx.zza(paramzztv));
  }

  final int zztx()
  {
    return this.zzbyg;
  }

  public final int zzvx()
  {
    if (this.zzbyg == -1)
      this.zzbyg = zzwh.zzxt().zzak(this).zzai(this);
    return this.zzbyg;
  }

  public final BuilderType zzwf()
  {
    zza localzza = (zza)zza(zze.zzbyq, null, null);
    localzza.zza(this);
    return localzza;
  }

  public static class zza<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsy<MessageType, BuilderType>
  {
    private final MessageType zzbyi;
    protected MessageType zzbyj;
    private boolean zzbyk;

    protected zza(MessageType paramMessageType)
    {
      this.zzbyi = paramMessageType;
      this.zzbyj = ((zzuo)paramMessageType.zza(zzuo.zze.zzbyp, null, null));
      this.zzbyk = false;
    }

    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzwh.zzxt().zzak(paramMessageType1).zzd(paramMessageType1, paramMessageType2);
    }

    public final boolean isInitialized()
    {
      return zzuo.zza(this.zzbyj, false);
    }

    public final BuilderType zza(MessageType paramMessageType)
    {
      zzwk();
      zza(this.zzbyj, paramMessageType);
      return this;
    }

    protected final void zzwk()
    {
      if (this.zzbyk)
      {
        zzuo localzzuo = (zzuo)this.zzbyj.zza(zzuo.zze.zzbyp, null, null);
        zza(localzzuo, this.zzbyj);
        this.zzbyj = localzzuo;
        this.zzbyk = false;
      }
    }

    public MessageType zzwl()
    {
      if (this.zzbyk)
        return this.zzbyj;
      zzuo localzzuo = this.zzbyj;
      zzwh.zzxt().zzak(localzzuo).zzy(localzzuo);
      this.zzbyk = true;
      return this.zzbyj;
    }

    public final MessageType zzwm()
    {
      zzuo localzzuo1 = (zzuo)zzwn();
      boolean bool1 = Boolean.TRUE.booleanValue();
      int i = ((Byte)localzzuo1.zza(zzuo.zze.zzbym, null, null)).byteValue();
      int j;
      if (i == 1)
        j = 1;
      while (j == 0)
      {
        throw new zzxc(localzzuo1);
        if (i == 0)
        {
          j = 0;
        }
        else
        {
          boolean bool2 = zzwh.zzxt().zzak(localzzuo1).zzaj(localzzuo1);
          int k;
          if (bool1)
          {
            k = zzuo.zze.zzbyn;
            if (!bool2)
              break label112;
          }
          label112: for (zzuo localzzuo2 = localzzuo1; ; localzzuo2 = null)
          {
            localzzuo1.zza(k, localzzuo2, null);
            j = bool2;
            break;
          }
        }
      }
      return localzzuo1;
    }
  }

  public static final class zzb<T extends zzuo<T, ?>> extends zzsz<T>
  {
    private final T zzbyi;

    public zzb(T paramT)
    {
      this.zzbyi = paramT;
    }
  }

  public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzuo<MessageType, BuilderType>
    implements zzvx
  {
    protected zzuf<Object> zzbyl = zzuf.zzvw();
  }

  public static final class zzd<ContainingType extends zzvv, Type> extends zztz<ContainingType, Type>
  {
  }

  public static enum zze
  {
    static
    {
      int[] arrayOfInt1 = new int[7];
      arrayOfInt1[0] = zzbym;
      arrayOfInt1[1] = zzbyn;
      arrayOfInt1[2] = zzbyo;
      arrayOfInt1[3] = zzbyp;
      arrayOfInt1[4] = zzbyq;
      arrayOfInt1[5] = zzbyr;
      arrayOfInt1[6] = zzbys;
      zzbyt = arrayOfInt1;
      zzbyu = 1;
      zzbyv = 2;
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = zzbyu;
      arrayOfInt2[1] = zzbyv;
      zzbyw = arrayOfInt2;
      zzbyx = 1;
      zzbyy = 2;
      int[] arrayOfInt3 = new int[2];
      arrayOfInt3[0] = zzbyx;
      arrayOfInt3[1] = zzbyy;
    }

    public static int[] zzwp()
    {
      return (int[])zzbyt.clone();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzuo
 * JD-Core Version:    0.6.2
 */