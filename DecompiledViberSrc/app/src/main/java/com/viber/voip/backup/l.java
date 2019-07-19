package com.viber.voip.backup;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.Pair;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import com.google.a.a.f.k;
import com.google.a.b.a.a.a;
import com.google.a.b.a.a.b;
import com.viber.dexshared.Logger;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.voip.AcceptTermsAndPoliciesDialogActivity;
import com.viber.voip.AcceptTermsAndPoliciesWebActivity;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberSystemActivity;
import com.viber.voip.messages.ui.media.WinkViewMediaActivity;
import com.viber.voip.messages.ui.popup.PopupMessageActivity;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.phone.TabletVideoCallActivity;
import com.viber.voip.registration.ao;
import com.viber.voip.util.at;
import com.viber.voip.util.ax;
import com.viber.voip.util.u;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l
{
  private static final Logger a = ViberEnv.getLogger();

  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return 0;
    case 1:
      return (int)(0.5F * paramInt2);
    case 2:
    }
    return (int)(50.0F + 0.5F * paramInt2);
  }

  public static k a(a parama, String paramString)
  {
    String str = c(parama, paramString);
    if (!TextUtils.isEmpty(str))
      try
      {
        k localk = new k(str);
        return localk;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    return null;
  }

  public static a a(b paramb)
  {
    if ((paramb != null) && (!u.a(paramb.a())))
      return (a)paramb.a().get(0);
    return null;
  }

  public static BackupInfo a(String paramString, a parama)
  {
    if (a(parama))
      return new BackupInfo(paramString, parama.e(), c(parama).a(), parama.h().longValue(), b(parama));
    return new BackupInfo(paramString, null, 0L, 0L, 0);
  }

  public static CharSequence a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    p localp = new p(paramContext);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localp.a(paramLong1);
    arrayOfObject[1] = at.a(paramLong2);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(localLocale, paramString1, com.viber.common.d.c.a(arrayOfObject)));
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 17);
    localSpannableStringBuilder.append("\n\n");
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramInt, false), i - 1, i, 17);
    localSpannableStringBuilder.append(paramString2);
    return localSpannableStringBuilder;
  }

  public static String a(MessageBackupEntity paramMessageBackupEntity)
  {
    if (com.viber.voip.flatbuffers.b.c.a(paramMessageBackupEntity.getMsgInfo()))
      return paramMessageBackupEntity.getBody();
    return paramMessageBackupEntity.getMsgInfo();
  }

  public static boolean a(Activity paramActivity)
  {
    return ((paramActivity instanceof ViberSystemActivity)) || ((paramActivity instanceof AcceptTermsAndPoliciesDialogActivity)) || ((paramActivity instanceof AcceptTermsAndPoliciesWebActivity)) || ((paramActivity instanceof PopupMessageActivity)) || ((paramActivity instanceof PhoneFragmentActivity)) || ((paramActivity instanceof TabletVideoCallActivity)) || ((paramActivity instanceof WinkViewMediaActivity));
  }

  public static boolean a(Context paramContext)
  {
    if ((ax.a(paramContext)) && (!ao.f()));
    for (boolean bool = true; ; bool = false)
    {
      if (!bool);
      return bool;
    }
  }

  public static boolean a(a parama)
  {
    return (parama != null) && (parama.e() != null) && (parama.f() != null) && (parama.h() != null);
  }

  public static int b(a parama)
  {
    String str = c(parama, "backupMetadataVersion");
    int i = 0;
    if (str != null);
    try
    {
      int j = Integer.parseInt(str);
      i = j;
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public static Pair<String, String> b(a parama, String paramString)
  {
    Map localMap = parama.a();
    if (localMap != null)
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramString.equals(localEntry.getKey()))
          return new Pair(localEntry.getKey(), localEntry.getValue());
      }
    }
    return null;
  }

  public static k c(a parama)
  {
    k localk = a(parama, "backupUploadTime");
    if (localk == null)
      localk = parama.f();
    return localk;
  }

  public static String c(a parama, String paramString)
  {
    Pair localPair = b(parama, paramString);
    if (localPair == null)
      return null;
    return (String)localPair.second;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.l
 * JD-Core Version:    0.6.2
 */