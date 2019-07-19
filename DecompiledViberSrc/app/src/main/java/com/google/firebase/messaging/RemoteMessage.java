package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator="RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new j();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN;

  @SafeParcelable.Field(id=2)
  Bundle zzeh;
  private Map<String, String> zzei;
  private a zzej;

  @SafeParcelable.Constructor
  public RemoteMessage(@SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.zzeh = paramBundle;
  }

  private static int zzp(String paramString)
  {
    if ("high".equals(paramString))
      return 1;
    if ("normal".equals(paramString))
      return 2;
    return 0;
  }

  public final String getCollapseKey()
  {
    return this.zzeh.getString("collapse_key");
  }

  public final Map<String, String> getData()
  {
    if (this.zzei == null)
    {
      Bundle localBundle = this.zzeh;
      ArrayMap localArrayMap = new ArrayMap();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Object localObject = localBundle.get(str1);
        if ((localObject instanceof String))
        {
          String str2 = (String)localObject;
          if ((!str1.startsWith("google.")) && (!str1.startsWith("gcm.")) && (!str1.equals("from")) && (!str1.equals("message_type")) && (!str1.equals("collapse_key")))
            localArrayMap.put(str1, str2);
        }
      }
      this.zzei = localArrayMap;
    }
    return this.zzei;
  }

  public final String getFrom()
  {
    return this.zzeh.getString("from");
  }

  public final String getMessageId()
  {
    String str = this.zzeh.getString("google.message_id");
    if (str == null)
      str = this.zzeh.getString("message_id");
    return str;
  }

  public final String getMessageType()
  {
    return this.zzeh.getString("message_type");
  }

  public final a getNotification()
  {
    if ((this.zzej == null) && (d.b(this.zzeh)))
      this.zzej = new a(this.zzeh, null);
    return this.zzej;
  }

  public final int getOriginalPriority()
  {
    String str = this.zzeh.getString("google.original_priority");
    if (str == null)
      str = this.zzeh.getString("google.priority");
    return zzp(str);
  }

  public final int getPriority()
  {
    String str = this.zzeh.getString("google.delivered_priority");
    if (str == null)
    {
      if ("1".equals(this.zzeh.getString("google.priority_reduced")))
        return 2;
      str = this.zzeh.getString("google.priority");
    }
    return zzp(str);
  }

  public final long getSentTime()
  {
    Object localObject = this.zzeh.get("google.sent_time");
    if ((localObject instanceof Long))
      return ((Long)localObject).longValue();
    if ((localObject instanceof String))
      try
      {
        long l = Long.parseLong((String)localObject);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str = String.valueOf(localObject);
        Log.w("FirebaseMessaging", 19 + String.valueOf(str).length() + "Invalid sent time: " + str);
      }
    return 0L;
  }

  public final String getTo()
  {
    return this.zzeh.getString("google.to");
  }

  public final int getTtl()
  {
    Object localObject = this.zzeh.get("google.ttl");
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof String))
      try
      {
        int i = Integer.parseInt((String)localObject);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str = String.valueOf(localObject);
        Log.w("FirebaseMessaging", 13 + String.valueOf(str).length() + "Invalid TTL: " + str);
      }
    return 0;
  }

  @KeepForSdk
  public final Intent toIntent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.zzeh);
    return localIntent;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.zzeh, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static class a
  {
    private final String a;
    private final String b;
    private final String[] c;
    private final String d;
    private final String e;
    private final String[] f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final Uri n;

    private a(Bundle paramBundle)
    {
      this.a = d.a(paramBundle, "gcm.n.title");
      this.b = d.c(paramBundle, "gcm.n.title");
      this.c = a(paramBundle, "gcm.n.title");
      this.d = d.a(paramBundle, "gcm.n.body");
      this.e = d.c(paramBundle, "gcm.n.body");
      this.f = a(paramBundle, "gcm.n.body");
      this.g = d.a(paramBundle, "gcm.n.icon");
      this.i = d.c(paramBundle);
      this.j = d.a(paramBundle, "gcm.n.tag");
      this.k = d.a(paramBundle, "gcm.n.color");
      this.l = d.a(paramBundle, "gcm.n.click_action");
      this.m = d.a(paramBundle, "gcm.n.android_channel_id");
      this.n = d.d(paramBundle);
      this.h = d.a(paramBundle, "gcm.n.image");
    }

    private static String[] a(Bundle paramBundle, String paramString)
    {
      Object[] arrayOfObject = d.b(paramBundle, paramString);
      if (arrayOfObject == null)
        return null;
      String[] arrayOfString = new String[arrayOfObject.length];
      for (int i1 = 0; i1 < arrayOfObject.length; i1++)
        arrayOfString[i1] = String.valueOf(arrayOfObject[i1]);
      return arrayOfString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.RemoteMessage
 * JD-Core Version:    0.6.2
 */