package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

final class f
{
  private static Boolean a = null;

  private static String a(Parcel paramParcel)
  {
    if (a())
      return paramParcel.readString();
    Object localObject = paramParcel.readValue(null);
    if (!(localObject instanceof String))
    {
      Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
      return null;
    }
    return (String)localObject;
  }

  private static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  // ERROR //
  private static boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 10	com/firebase/jobdispatcher/f:a	Ljava/lang/Boolean;
    //   8: ifnonnull +87 -> 95
    //   11: new 47	android/os/Bundle
    //   14: dup
    //   15: invokespecial 48	android/os/Bundle:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 50
    //   22: ldc 52
    //   24: invokevirtual 56	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_2
    //   28: invokestatic 60	com/firebase/jobdispatcher/f:c	(Landroid/os/Bundle;)Landroid/os/Parcel;
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual 64	android/os/Parcel:readInt	()I
    //   36: ifle +73 -> 109
    //   39: iload_0
    //   40: istore 7
    //   42: iload 7
    //   44: invokestatic 66	com/firebase/jobdispatcher/f:a	(Z)V
    //   47: aload_3
    //   48: invokevirtual 64	android/os/Parcel:readInt	()I
    //   51: ldc 67
    //   53: if_icmpne +62 -> 115
    //   56: iload_0
    //   57: istore 8
    //   59: iload 8
    //   61: invokestatic 66	com/firebase/jobdispatcher/f:a	(Z)V
    //   64: aload_3
    //   65: invokevirtual 64	android/os/Parcel:readInt	()I
    //   68: iload_0
    //   69: if_icmpne +52 -> 121
    //   72: iload_0
    //   73: invokestatic 66	com/firebase/jobdispatcher/f:a	(Z)V
    //   76: ldc 50
    //   78: aload_3
    //   79: invokevirtual 23	android/os/Parcel:readString	()Ljava/lang/String;
    //   82: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: invokestatic 77	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   88: putstatic 10	com/firebase/jobdispatcher/f:a	Ljava/lang/Boolean;
    //   91: aload_3
    //   92: invokevirtual 80	android/os/Parcel:recycle	()V
    //   95: getstatic 10	com/firebase/jobdispatcher/f:a	Ljava/lang/Boolean;
    //   98: invokevirtual 83	java/lang/Boolean:booleanValue	()Z
    //   101: istore 6
    //   103: ldc 2
    //   105: monitorexit
    //   106: iload 6
    //   108: ireturn
    //   109: iconst_0
    //   110: istore 7
    //   112: goto -70 -> 42
    //   115: iconst_0
    //   116: istore 8
    //   118: goto -59 -> 59
    //   121: iconst_0
    //   122: istore_0
    //   123: goto -51 -> 72
    //   126: astore 5
    //   128: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   131: putstatic 10	com/firebase/jobdispatcher/f:a	Ljava/lang/Boolean;
    //   134: aload_3
    //   135: invokevirtual 80	android/os/Parcel:recycle	()V
    //   138: goto -43 -> 95
    //   141: astore_1
    //   142: ldc 2
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: astore 4
    //   149: aload_3
    //   150: invokevirtual 80	android/os/Parcel:recycle	()V
    //   153: aload 4
    //   155: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   32	39	126	java/lang/RuntimeException
    //   42	56	126	java/lang/RuntimeException
    //   59	72	126	java/lang/RuntimeException
    //   72	91	126	java/lang/RuntimeException
    //   5	32	141	finally
    //   91	95	141	finally
    //   95	103	141	finally
    //   134	138	141	finally
    //   149	156	141	finally
    //   32	39	147	finally
    //   42	56	147	finally
    //   59	72	147	finally
    //   72	91	147	finally
    //   128	134	147	finally
  }

  @SuppressLint({"ParcelClassLoader"})
  private static Pair<m, Bundle> b(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Parcel localParcel = c(paramBundle);
    while (true)
    {
      int j;
      try
      {
        if (localParcel.readInt() <= 0)
        {
          Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
          return null;
        }
        if (localParcel.readInt() != 1279544898)
        {
          Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
          return null;
        }
        int i = localParcel.readInt();
        j = 0;
        localObject2 = null;
        if (j < i)
        {
          String str = a(localParcel);
          if (str == null)
          {
            localObject4 = localObject2;
          }
          else if ((localObject2 != null) || (!"callback".equals(str)))
          {
            Object localObject3 = localParcel.readValue(null);
            if ((localObject3 instanceof String))
            {
              localBundle.putString(str, (String)localObject3);
              localObject4 = localObject2;
              break label387;
            }
            if ((localObject3 instanceof Boolean))
            {
              localBundle.putBoolean(str, ((Boolean)localObject3).booleanValue());
              localObject4 = localObject2;
              break label387;
            }
            if ((localObject3 instanceof Integer))
            {
              localBundle.putInt(str, ((Integer)localObject3).intValue());
              localObject4 = localObject2;
              break label387;
            }
            if ((localObject3 instanceof ArrayList))
            {
              localBundle.putParcelableArrayList(str, (ArrayList)localObject3);
              localObject4 = localObject2;
              break label387;
            }
            if ((localObject3 instanceof Bundle))
            {
              localBundle.putBundle(str, (Bundle)localObject3);
              localObject4 = localObject2;
              break label387;
            }
            if ((localObject3 instanceof Parcelable))
            {
              localBundle.putParcelable(str, (Parcelable)localObject3);
              localObject4 = localObject2;
              break label387;
            }
          }
          else
          {
            if (localParcel.readInt() != 4)
            {
              Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
              return null;
            }
            if (!"com.google.android.gms.gcm.PendingCallback".equals(localParcel.readString()))
            {
              Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
              return null;
            }
            localObject4 = new h(localParcel.readStrongBinder());
          }
        }
      }
      finally
      {
        localParcel.recycle();
      }
      if (localObject2 == null)
      {
        Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
        localParcel.recycle();
        return null;
      }
      Pair localPair = Pair.create(localObject2, localBundle);
      localParcel.recycle();
      return localPair;
      Object localObject4 = localObject2;
      label387: j++;
      Object localObject2 = localObject4;
    }
  }

  private static Parcel c(Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    return localParcel;
  }

  public Pair<m, Bundle> a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
      return null;
    }
    return b(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.f
 * JD-Core Version:    0.6.2
 */