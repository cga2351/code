package com.viber.voip.util;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.u.e;

public class bw
{
  private static final Logger a = ViberEnv.getLogger();

  public static boolean a(TelephonyManager paramTelephonyManager)
  {
    int i;
    ViberApplication localViberApplication;
    if (paramTelephonyManager.getCallState() != 0)
    {
      i = 1;
      localViberApplication = ViberApplication.getInstance();
      CallInfo localCallInfo = localViberApplication.getEngine(false).getCurrentCall();
      if ((localCallInfo == null) || ((!localCallInfo.isCalling()) && (!localCallInfo.isCallInProgress())))
        break label102;
    }
    label102: for (int j = 1; ; j = 0)
    {
      com.viber.voip.messages.k localk = localViberApplication.getMessagesManager();
      boolean bool1;
      if ((i == 0) && (j == 0) && (!localk.l().a()))
      {
        boolean bool2 = localk.o().f();
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
    }
  }

  public static int[] a(Context paramContext, Uri paramUri)
  {
    int[] arrayOfInt = new int[2];
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    while (true)
    {
      int j;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramContext, paramUri);
        if (a.b())
        {
          i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
          break label121;
          int k = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
          int m = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
          if (j != 0)
          {
            n = m;
            arrayOfInt[0] = n;
            if (j == 0)
              continue;
            arrayOfInt[1] = k;
            return arrayOfInt;
            j = 0;
            continue;
          }
          int n = k;
          continue;
          k = m;
          continue;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        return arrayOfInt;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return arrayOfInt;
      }
      int i = 0;
      label121: if ((i == 90) || (i == 270))
        j = 1;
    }
  }

  public static long b(Context paramContext, Uri paramUri)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramContext, paramUri);
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(9));
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      return 0L;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return 0L;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bw
 * JD-Core Version:    0.6.2
 */