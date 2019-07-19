package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzxj
{
  private static final Logger logger = Logger.getLogger(zzxj.class.getName());
  private static final Class<?> zzbto;
  private static final boolean zzbuo;
  private static final Unsafe zzcar = zzyq();
  private static final boolean zzcco;
  private static final boolean zzccp;
  private static final zzd zzccq;
  private static final boolean zzccr;
  private static final long zzccs;
  private static final long zzcct;
  private static final long zzccu;
  private static final long zzccv;
  private static final long zzccw;
  private static final long zzccx;
  private static final long zzccy;
  private static final long zzccz;
  private static final long zzcda;
  private static final long zzcdb;
  private static final long zzcdc;
  private static final long zzcdd;
  private static final long zzcde;
  private static final long zzcdf;
  private static final boolean zzcdg;

  static
  {
    zzbto = zztb.zzuc();
    zzcco = zzn(Long.TYPE);
    zzccp = zzn(Integer.TYPE);
    Unsafe localUnsafe = zzcar;
    Object localObject = null;
    Field localField;
    long l;
    if (localUnsafe == null)
    {
      zzccq = (zzd)localObject;
      zzccr = zzys();
      zzbuo = zzyr();
      zzccs = zzl([B.class);
      zzcct = zzl([Z.class);
      zzccu = zzm([Z.class);
      zzccv = zzl([I.class);
      zzccw = zzm([I.class);
      zzccx = zzl([J.class);
      zzccy = zzm([J.class);
      zzccz = zzl([F.class);
      zzcda = zzm([F.class);
      zzcdb = zzl([D.class);
      zzcdc = zzm([D.class);
      zzcdd = zzl([Ljava.lang.Object.class);
      zzcde = zzm([Ljava.lang.Object.class);
      localField = zzyt();
      if ((localField != null) && (zzccq != null))
        break label290;
      l = -1L;
      label202: zzcdf = l;
      if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN)
        break label304;
    }
    label290: label304: for (boolean bool1 = true; ; bool1 = false)
    {
      zzcdg = bool1;
      return;
      if (zztb.zzub())
      {
        if (zzcco)
        {
          localObject = new zzb(zzcar);
          break;
        }
        boolean bool2 = zzccp;
        localObject = null;
        if (!bool2)
          break;
        localObject = new zza(zzcar);
        break;
      }
      localObject = new zzc(zzcar);
      break;
      l = zzccq.zzcdh.objectFieldOffset(localField);
      break label202;
    }
  }

  static byte zza(byte[] paramArrayOfByte, long paramLong)
  {
    return zzccq.zzy(paramArrayOfByte, paramLong + zzccs);
  }

  static void zza(long paramLong, byte paramByte)
  {
    zzccq.zza(paramLong, paramByte);
  }

  private static void zza(Object paramObject, long paramLong, byte paramByte)
  {
    int i = zzk(paramObject, paramLong & 0xFFFFFFFC);
    int j = (0x3 & (0xFFFFFFFF ^ (int)paramLong)) << 3;
    int k = i & (0xFFFFFFFF ^ 255 << j) | (paramByte & 0xFF) << j;
    zzb(paramObject, paramLong & 0xFFFFFFFC, k);
  }

  static void zza(Object paramObject, long paramLong, double paramDouble)
  {
    zzccq.zza(paramObject, paramLong, paramDouble);
  }

  static void zza(Object paramObject, long paramLong, float paramFloat)
  {
    zzccq.zza(paramObject, paramLong, paramFloat);
  }

  static void zza(Object paramObject, long paramLong1, long paramLong2)
  {
    zzccq.zza(paramObject, paramLong1, paramLong2);
  }

  static void zza(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzccq.zzcdh.putObject(paramObject1, paramLong, paramObject2);
  }

  static void zza(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzccq.zza(paramObject, paramLong, paramBoolean);
  }

  static void zza(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzccq.zze(paramArrayOfByte, paramLong + zzccs, paramByte);
  }

  static void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
  {
    zzccq.zza(paramArrayOfByte, paramLong1, paramLong2, paramLong3);
  }

  static long zzb(ByteBuffer paramByteBuffer)
  {
    return zzccq.zzl(paramByteBuffer, zzcdf);
  }

  private static Field zzb(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static void zzb(Object paramObject, long paramLong, byte paramByte)
  {
    int i = zzk(paramObject, paramLong & 0xFFFFFFFC);
    int j = (0x3 & (int)paramLong) << 3;
    int k = i & (0xFFFFFFFF ^ 255 << j) | (paramByte & 0xFF) << j;
    zzb(paramObject, paramLong & 0xFFFFFFFC, k);
  }

  static void zzb(Object paramObject, long paramLong, int paramInt)
  {
    zzccq.zzb(paramObject, paramLong, paramInt);
  }

  private static void zzb(Object paramObject, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      zza(paramObject, paramLong, (byte)i);
      return;
    }
  }

  private static void zzc(Object paramObject, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      zzb(paramObject, paramLong, (byte)i);
      return;
    }
  }

  static int zzk(Object paramObject, long paramLong)
  {
    return zzccq.zzk(paramObject, paramLong);
  }

  static <T> T zzk(Class<T> paramClass)
  {
    try
    {
      Object localObject = zzcar.allocateInstance(paramClass);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException(localInstantiationException);
    }
  }

  private static int zzl(Class<?> paramClass)
  {
    if (zzbuo)
      return zzccq.zzcdh.arrayBaseOffset(paramClass);
    return -1;
  }

  static long zzl(Object paramObject, long paramLong)
  {
    return zzccq.zzl(paramObject, paramLong);
  }

  private static int zzm(Class<?> paramClass)
  {
    if (zzbuo)
      return zzccq.zzcdh.arrayIndexScale(paramClass);
    return -1;
  }

  static boolean zzm(Object paramObject, long paramLong)
  {
    return zzccq.zzm(paramObject, paramLong);
  }

  static float zzn(Object paramObject, long paramLong)
  {
    return zzccq.zzn(paramObject, paramLong);
  }

  private static boolean zzn(Class<?> paramClass)
  {
    if (!zztb.zzub())
      return false;
    try
    {
      Class localClass = zzbto;
      Class[] arrayOfClass1 = new Class[2];
      arrayOfClass1[0] = paramClass;
      arrayOfClass1[1] = Boolean.TYPE;
      localClass.getMethod("peekLong", arrayOfClass1);
      Class[] arrayOfClass2 = new Class[3];
      arrayOfClass2[0] = paramClass;
      arrayOfClass2[1] = Long.TYPE;
      arrayOfClass2[2] = Boolean.TYPE;
      localClass.getMethod("pokeLong", arrayOfClass2);
      Class[] arrayOfClass3 = new Class[3];
      arrayOfClass3[0] = paramClass;
      arrayOfClass3[1] = Integer.TYPE;
      arrayOfClass3[2] = Boolean.TYPE;
      localClass.getMethod("pokeInt", arrayOfClass3);
      Class[] arrayOfClass4 = new Class[2];
      arrayOfClass4[0] = paramClass;
      arrayOfClass4[1] = Boolean.TYPE;
      localClass.getMethod("peekInt", arrayOfClass4);
      Class[] arrayOfClass5 = new Class[2];
      arrayOfClass5[0] = paramClass;
      arrayOfClass5[1] = Byte.TYPE;
      localClass.getMethod("pokeByte", arrayOfClass5);
      localClass.getMethod("peekByte", new Class[] { paramClass });
      Class[] arrayOfClass6 = new Class[4];
      arrayOfClass6[0] = paramClass;
      arrayOfClass6[1] = [B.class;
      arrayOfClass6[2] = Integer.TYPE;
      arrayOfClass6[3] = Integer.TYPE;
      localClass.getMethod("pokeByteArray", arrayOfClass6);
      Class[] arrayOfClass7 = new Class[4];
      arrayOfClass7[0] = paramClass;
      arrayOfClass7[1] = [B.class;
      arrayOfClass7[2] = Integer.TYPE;
      arrayOfClass7[3] = Integer.TYPE;
      localClass.getMethod("peekByteArray", arrayOfClass7);
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  static double zzo(Object paramObject, long paramLong)
  {
    return zzccq.zzo(paramObject, paramLong);
  }

  static Object zzp(Object paramObject, long paramLong)
  {
    return zzccq.zzcdh.getObject(paramObject, paramLong);
  }

  private static byte zzq(Object paramObject, long paramLong)
  {
    return (byte)(zzk(paramObject, 0xFFFFFFFC & paramLong) >>> (int)((0x3 & (0xFFFFFFFF ^ paramLong)) << 3));
  }

  private static byte zzr(Object paramObject, long paramLong)
  {
    return (byte)(zzk(paramObject, 0xFFFFFFFC & paramLong) >>> (int)((0x3 & paramLong) << 3));
  }

  private static boolean zzs(Object paramObject, long paramLong)
  {
    return zzq(paramObject, paramLong) != 0;
  }

  private static boolean zzt(Object paramObject, long paramLong)
  {
    return zzr(paramObject, paramLong) != 0;
  }

  static boolean zzyo()
  {
    return zzbuo;
  }

  static boolean zzyp()
  {
    return zzccr;
  }

  static Unsafe zzyq()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new zzxk());
      return localUnsafe;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static boolean zzyr()
  {
    if (zzcar == null)
      return false;
    try
    {
      Class localClass = zzcar.getClass();
      localClass.getMethod("objectFieldOffset", new Class[] { Field.class });
      localClass.getMethod("arrayBaseOffset", new Class[] { Class.class });
      localClass.getMethod("arrayIndexScale", new Class[] { Class.class });
      Class[] arrayOfClass1 = new Class[2];
      arrayOfClass1[0] = Object.class;
      arrayOfClass1[1] = Long.TYPE;
      localClass.getMethod("getInt", arrayOfClass1);
      Class[] arrayOfClass2 = new Class[3];
      arrayOfClass2[0] = Object.class;
      arrayOfClass2[1] = Long.TYPE;
      arrayOfClass2[2] = Integer.TYPE;
      localClass.getMethod("putInt", arrayOfClass2);
      Class[] arrayOfClass3 = new Class[2];
      arrayOfClass3[0] = Object.class;
      arrayOfClass3[1] = Long.TYPE;
      localClass.getMethod("getLong", arrayOfClass3);
      Class[] arrayOfClass4 = new Class[3];
      arrayOfClass4[0] = Object.class;
      arrayOfClass4[1] = Long.TYPE;
      arrayOfClass4[2] = Long.TYPE;
      localClass.getMethod("putLong", arrayOfClass4);
      Class[] arrayOfClass5 = new Class[2];
      arrayOfClass5[0] = Object.class;
      arrayOfClass5[1] = Long.TYPE;
      localClass.getMethod("getObject", arrayOfClass5);
      Class[] arrayOfClass6 = new Class[3];
      arrayOfClass6[0] = Object.class;
      arrayOfClass6[1] = Long.TYPE;
      arrayOfClass6[2] = Object.class;
      localClass.getMethod("putObject", arrayOfClass6);
      if (zztb.zzub())
        return true;
      Class[] arrayOfClass7 = new Class[2];
      arrayOfClass7[0] = Object.class;
      arrayOfClass7[1] = Long.TYPE;
      localClass.getMethod("getByte", arrayOfClass7);
      Class[] arrayOfClass8 = new Class[3];
      arrayOfClass8[0] = Object.class;
      arrayOfClass8[1] = Long.TYPE;
      arrayOfClass8[2] = Byte.TYPE;
      localClass.getMethod("putByte", arrayOfClass8);
      Class[] arrayOfClass9 = new Class[2];
      arrayOfClass9[0] = Object.class;
      arrayOfClass9[1] = Long.TYPE;
      localClass.getMethod("getBoolean", arrayOfClass9);
      Class[] arrayOfClass10 = new Class[3];
      arrayOfClass10[0] = Object.class;
      arrayOfClass10[1] = Long.TYPE;
      arrayOfClass10[2] = Boolean.TYPE;
      localClass.getMethod("putBoolean", arrayOfClass10);
      Class[] arrayOfClass11 = new Class[2];
      arrayOfClass11[0] = Object.class;
      arrayOfClass11[1] = Long.TYPE;
      localClass.getMethod("getFloat", arrayOfClass11);
      Class[] arrayOfClass12 = new Class[3];
      arrayOfClass12[0] = Object.class;
      arrayOfClass12[1] = Long.TYPE;
      arrayOfClass12[2] = Float.TYPE;
      localClass.getMethod("putFloat", arrayOfClass12);
      Class[] arrayOfClass13 = new Class[2];
      arrayOfClass13[0] = Object.class;
      arrayOfClass13[1] = Long.TYPE;
      localClass.getMethod("getDouble", arrayOfClass13);
      Class[] arrayOfClass14 = new Class[3];
      arrayOfClass14[0] = Object.class;
      arrayOfClass14[1] = Long.TYPE;
      arrayOfClass14[2] = Double.TYPE;
      localClass.getMethod("putDouble", arrayOfClass14);
      return true;
    }
    catch (Throwable localThrowable)
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str = String.valueOf(localThrowable);
      localLogger.logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", 71 + String.valueOf(str).length() + "platform method missing - proto runtime falling back to safer methods: " + str);
    }
    return false;
  }

  private static boolean zzys()
  {
    if (zzcar == null);
    while (true)
    {
      return false;
      try
      {
        Class localClass = zzcar.getClass();
        localClass.getMethod("objectFieldOffset", new Class[] { Field.class });
        Class[] arrayOfClass1 = new Class[2];
        arrayOfClass1[0] = Object.class;
        arrayOfClass1[1] = Long.TYPE;
        localClass.getMethod("getLong", arrayOfClass1);
        if (zzyt() != null)
        {
          if (zztb.zzub())
            return true;
          Class[] arrayOfClass2 = new Class[1];
          arrayOfClass2[0] = Long.TYPE;
          localClass.getMethod("getByte", arrayOfClass2);
          Class[] arrayOfClass3 = new Class[2];
          arrayOfClass3[0] = Long.TYPE;
          arrayOfClass3[1] = Byte.TYPE;
          localClass.getMethod("putByte", arrayOfClass3);
          Class[] arrayOfClass4 = new Class[1];
          arrayOfClass4[0] = Long.TYPE;
          localClass.getMethod("getInt", arrayOfClass4);
          Class[] arrayOfClass5 = new Class[2];
          arrayOfClass5[0] = Long.TYPE;
          arrayOfClass5[1] = Integer.TYPE;
          localClass.getMethod("putInt", arrayOfClass5);
          Class[] arrayOfClass6 = new Class[1];
          arrayOfClass6[0] = Long.TYPE;
          localClass.getMethod("getLong", arrayOfClass6);
          Class[] arrayOfClass7 = new Class[2];
          arrayOfClass7[0] = Long.TYPE;
          arrayOfClass7[1] = Long.TYPE;
          localClass.getMethod("putLong", arrayOfClass7);
          Class[] arrayOfClass8 = new Class[3];
          arrayOfClass8[0] = Long.TYPE;
          arrayOfClass8[1] = Long.TYPE;
          arrayOfClass8[2] = Long.TYPE;
          localClass.getMethod("copyMemory", arrayOfClass8);
          Class[] arrayOfClass9 = new Class[5];
          arrayOfClass9[0] = Object.class;
          arrayOfClass9[1] = Long.TYPE;
          arrayOfClass9[2] = Object.class;
          arrayOfClass9[3] = Long.TYPE;
          arrayOfClass9[4] = Long.TYPE;
          localClass.getMethod("copyMemory", arrayOfClass9);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Logger localLogger = logger;
        Level localLevel = Level.WARNING;
        String str = String.valueOf(localThrowable);
        localLogger.logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", 71 + String.valueOf(str).length() + "platform method missing - proto runtime falling back to safer methods: " + str);
      }
    }
    return false;
  }

  private static Field zzyt()
  {
    Field localField;
    if (zztb.zzub())
    {
      localField = zzb(Buffer.class, "effectiveDirectAddress");
      if (localField == null);
    }
    do
    {
      return localField;
      localField = zzb(Buffer.class, "address");
    }
    while ((localField != null) && (localField.getType() == Long.TYPE));
    return null;
  }

  static final class zza extends zzxj.zzd
  {
    zza(Unsafe paramUnsafe)
    {
      super();
    }

    public final void zza(long paramLong, byte paramByte)
    {
      Memory.pokeByte((int)(0xFFFFFFFF & paramLong), paramByte);
    }

    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }

    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zzb(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }

    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzxj.zzvk())
      {
        zzxj.zzd(paramObject, paramLong, paramBoolean);
        return;
      }
      zzxj.zze(paramObject, paramLong, paramBoolean);
    }

    public final void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
    {
      Memory.pokeByteArray((int)(0xFFFFFFFF & paramLong2), paramArrayOfByte, (int)paramLong1, (int)paramLong3);
    }

    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzxj.zzvk())
      {
        zzxj.zzc(paramObject, paramLong, paramByte);
        return;
      }
      zzxj.zzd(paramObject, paramLong, paramByte);
    }

    public final boolean zzm(Object paramObject, long paramLong)
    {
      if (zzxj.zzvk())
        return zzxj.zzw(paramObject, paramLong);
      return zzxj.zzx(paramObject, paramLong);
    }

    public final float zzn(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zzk(paramObject, paramLong));
    }

    public final double zzo(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzl(paramObject, paramLong));
    }

    public final byte zzy(Object paramObject, long paramLong)
    {
      if (zzxj.zzvk())
        return zzxj.zzu(paramObject, paramLong);
      return zzxj.zzv(paramObject, paramLong);
    }
  }

  static final class zzb extends zzxj.zzd
  {
    zzb(Unsafe paramUnsafe)
    {
      super();
    }

    public final void zza(long paramLong, byte paramByte)
    {
      Memory.pokeByte(paramLong, paramByte);
    }

    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      zza(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }

    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      zzb(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }

    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzxj.zzvk())
      {
        zzxj.zzd(paramObject, paramLong, paramBoolean);
        return;
      }
      zzxj.zze(paramObject, paramLong, paramBoolean);
    }

    public final void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
    {
      Memory.pokeByteArray(paramLong2, paramArrayOfByte, (int)paramLong1, (int)paramLong3);
    }

    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzxj.zzvk())
      {
        zzxj.zzc(paramObject, paramLong, paramByte);
        return;
      }
      zzxj.zzd(paramObject, paramLong, paramByte);
    }

    public final boolean zzm(Object paramObject, long paramLong)
    {
      if (zzxj.zzvk())
        return zzxj.zzw(paramObject, paramLong);
      return zzxj.zzx(paramObject, paramLong);
    }

    public final float zzn(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(zzk(paramObject, paramLong));
    }

    public final double zzo(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(zzl(paramObject, paramLong));
    }

    public final byte zzy(Object paramObject, long paramLong)
    {
      if (zzxj.zzvk())
        return zzxj.zzu(paramObject, paramLong);
      return zzxj.zzv(paramObject, paramLong);
    }
  }

  static final class zzc extends zzxj.zzd
  {
    zzc(Unsafe paramUnsafe)
    {
      super();
    }

    public final void zza(long paramLong, byte paramByte)
    {
      this.zzcdh.putByte(paramLong, paramByte);
    }

    public final void zza(Object paramObject, long paramLong, double paramDouble)
    {
      this.zzcdh.putDouble(paramObject, paramLong, paramDouble);
    }

    public final void zza(Object paramObject, long paramLong, float paramFloat)
    {
      this.zzcdh.putFloat(paramObject, paramLong, paramFloat);
    }

    public final void zza(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.zzcdh.putBoolean(paramObject, paramLong, paramBoolean);
    }

    public final void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
    {
      this.zzcdh.copyMemory(paramArrayOfByte, paramLong1 + zzxj.zzyu(), null, paramLong2, paramLong3);
    }

    public final void zze(Object paramObject, long paramLong, byte paramByte)
    {
      this.zzcdh.putByte(paramObject, paramLong, paramByte);
    }

    public final boolean zzm(Object paramObject, long paramLong)
    {
      return this.zzcdh.getBoolean(paramObject, paramLong);
    }

    public final float zzn(Object paramObject, long paramLong)
    {
      return this.zzcdh.getFloat(paramObject, paramLong);
    }

    public final double zzo(Object paramObject, long paramLong)
    {
      return this.zzcdh.getDouble(paramObject, paramLong);
    }

    public final byte zzy(Object paramObject, long paramLong)
    {
      return this.zzcdh.getByte(paramObject, paramLong);
    }
  }

  static abstract class zzd
  {
    Unsafe zzcdh;

    zzd(Unsafe paramUnsafe)
    {
      this.zzcdh = paramUnsafe;
    }

    public abstract void zza(long paramLong, byte paramByte);

    public abstract void zza(Object paramObject, long paramLong, double paramDouble);

    public abstract void zza(Object paramObject, long paramLong, float paramFloat);

    public final void zza(Object paramObject, long paramLong1, long paramLong2)
    {
      this.zzcdh.putLong(paramObject, paramLong1, paramLong2);
    }

    public abstract void zza(Object paramObject, long paramLong, boolean paramBoolean);

    public abstract void zza(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3);

    public final void zzb(Object paramObject, long paramLong, int paramInt)
    {
      this.zzcdh.putInt(paramObject, paramLong, paramInt);
    }

    public abstract void zze(Object paramObject, long paramLong, byte paramByte);

    public final int zzk(Object paramObject, long paramLong)
    {
      return this.zzcdh.getInt(paramObject, paramLong);
    }

    public final long zzl(Object paramObject, long paramLong)
    {
      return this.zzcdh.getLong(paramObject, paramLong);
    }

    public abstract boolean zzm(Object paramObject, long paramLong);

    public abstract float zzn(Object paramObject, long paramLong);

    public abstract double zzo(Object paramObject, long paramLong);

    public abstract byte zzy(Object paramObject, long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxj
 * JD-Core Version:    0.6.2
 */