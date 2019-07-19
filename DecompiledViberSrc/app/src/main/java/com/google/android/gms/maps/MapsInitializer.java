package com.google.android.gms.maps;

import javax.annotation.concurrent.GuardedBy;

public final class MapsInitializer
{

  @GuardedBy("MapsInitializer.class")
  private static boolean zzbm = false;

  // ERROR //
  public static int initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 24
    //   6: invokestatic 30	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: getstatic 13	com/google/android/gms/maps/MapsInitializer:zzbm	Z
    //   13: istore_3
    //   14: iconst_0
    //   15: istore 4
    //   17: iload_3
    //   18: ifeq +9 -> 27
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload 4
    //   26: ireturn
    //   27: aload_0
    //   28: invokestatic 36	com/google/android/gms/maps/internal/zzbz:zza	(Landroid/content/Context;)Lcom/google/android/gms/maps/internal/zze;
    //   31: astore 6
    //   33: aload 6
    //   35: invokeinterface 42 1 0
    //   40: invokestatic 47	com/google/android/gms/maps/CameraUpdateFactory:zza	(Lcom/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate;)V
    //   43: aload 6
    //   45: invokeinterface 51 1 0
    //   50: invokestatic 56	com/google/android/gms/maps/model/BitmapDescriptorFactory:zza	(Lcom/google/android/gms/internal/maps/zze;)V
    //   53: iconst_1
    //   54: putstatic 13	com/google/android/gms/maps/MapsInitializer:zzbm	Z
    //   57: iconst_0
    //   58: istore 4
    //   60: goto -39 -> 21
    //   63: astore_1
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore 5
    //   71: aload 5
    //   73: getfield 60	com/google/android/gms/common/GooglePlayServicesNotAvailableException:errorCode	I
    //   76: istore 4
    //   78: goto -57 -> 21
    //   81: astore 7
    //   83: new 62	com/google/android/gms/maps/model/RuntimeRemoteException
    //   86: dup
    //   87: aload 7
    //   89: invokespecial 65	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   92: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   3	14	63	finally
    //   27	33	63	finally
    //   33	53	63	finally
    //   53	57	63	finally
    //   71	78	63	finally
    //   83	93	63	finally
    //   27	33	69	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   33	53	81	android/os/RemoteException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.MapsInitializer
 * JD-Core Version:    0.6.2
 */