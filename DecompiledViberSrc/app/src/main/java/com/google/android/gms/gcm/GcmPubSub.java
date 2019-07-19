package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public class GcmPubSub
{
  private static GcmPubSub zzo;
  private static final Pattern zzq = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
  private InstanceID zzp;

  private GcmPubSub(Context paramContext)
  {
    this.zzp = InstanceID.getInstance(paramContext);
  }

  @Deprecated
  public static GcmPubSub getInstance(Context paramContext)
  {
    try
    {
      if (zzo == null)
      {
        GoogleCloudMessaging.zze(paramContext);
        zzo = new GcmPubSub(paramContext);
      }
      GcmPubSub localGcmPubSub = zzo;
      return localGcmPubSub;
    }
    finally
    {
    }
  }

  @Deprecated
  public void subscribe(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      String str1 = String.valueOf(paramString1);
      if (str1.length() != 0);
      for (String str2 = "Invalid appInstanceToken: ".concat(str1); ; str2 = new String("Invalid appInstanceToken: "))
        throw new IllegalArgumentException(str2);
    }
    if ((paramString2 == null) || (!zzq.matcher(paramString2).matches()))
    {
      String str3 = String.valueOf(paramString2);
      if (str3.length() != 0);
      for (String str4 = "Invalid topic name: ".concat(str3); ; str4 = new String("Invalid topic name: "))
        throw new IllegalArgumentException(str4);
    }
    if (paramBundle == null)
      paramBundle = new Bundle();
    paramBundle.putString("gcm.topic", paramString2);
    this.zzp.getToken(paramString1, paramString2, paramBundle);
  }

  @Deprecated
  public void unsubscribe(String paramString1, String paramString2)
    throws IOException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("gcm.topic", paramString2);
    this.zzp.zzd(paramString1, paramString2, localBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmPubSub
 * JD-Core Version:    0.6.2
 */