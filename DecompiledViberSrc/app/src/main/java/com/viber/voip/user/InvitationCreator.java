package com.viber.voip.user;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.au;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;
import com.viber.voip.util.dw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvitationCreator
{
  private static final String INVITE_DEFAULT_LINK = "https://www.viber.com/invite/";
  private static final String INVITE_HEAVY_USER_LINK = "https://vb.me/letsUseViber";
  public static final Integer INVITE_LINK_IGNORE_SOURCE;
  private static final ArrayMap<String, Integer> INVITE_LINK_SOURCES;
  public static final Integer INVITE_LINK_SOURCE_FACEBOOK;
  private static final Integer INVITE_LINK_SOURCE_OTHER;
  private static final Integer INVITE_LINK_SOURCE_SMS;
  public static final Integer INVITE_LINK_SOURCE_TWITTER;
  private static final Integer INVITE_LINK_SOURCE_UNKNOWN;
  private static final String INVITE_VARIANT_LINK = "https://vb.me/switchToViber";
  private static final Logger L = ViberEnv.getLogger();
  private final Context mContext;

  static
  {
    INVITE_LINK_IGNORE_SOURCE = Integer.valueOf(-1);
    INVITE_LINK_SOURCE_UNKNOWN = Integer.valueOf(0);
    INVITE_LINK_SOURCE_OTHER = Integer.valueOf(1);
    INVITE_LINK_SOURCE_SMS = Integer.valueOf(2);
    INVITE_LINK_SOURCE_FACEBOOK = Integer.valueOf(5);
    INVITE_LINK_SOURCE_TWITTER = Integer.valueOf(6);
    INVITE_LINK_SOURCES = new ArrayMap();
    INVITE_LINK_SOURCES.put("com.google.android.gm", Integer.valueOf(4));
    INVITE_LINK_SOURCES.put("com.facebook.katana", INVITE_LINK_SOURCE_FACEBOOK);
    INVITE_LINK_SOURCES.put("com.facebook.lite", INVITE_LINK_SOURCE_FACEBOOK);
    INVITE_LINK_SOURCES.put("com.twitter.android", INVITE_LINK_SOURCE_TWITTER);
    INVITE_LINK_SOURCES.put("com.whatsapp", Integer.valueOf(7));
    INVITE_LINK_SOURCES.put("com.facebook.orca", Integer.valueOf(8));
    INVITE_LINK_SOURCES.put("com.facebook.mlite", Integer.valueOf(8));
    INVITE_LINK_SOURCES.put("com.google.android.talk", Integer.valueOf(9));
    INVITE_LINK_SOURCES.put("com.skype.raider", Integer.valueOf(10));
    INVITE_LINK_SOURCES.put("com.skype.insiders", Integer.valueOf(10));
    INVITE_LINK_SOURCES.put("com.microsoft.office.lync15", Integer.valueOf(10));
    INVITE_LINK_SOURCES.put("org.telegram.messenger", Integer.valueOf(11));
  }

  public InvitationCreator(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private List<Intent> createChooserIntents(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = this.mContext.getPackageManager();
    ArraySet localArraySet = getSmsHandlers(localPackageManager);
    Intent localIntent1 = new Intent("android.intent.action.SEND");
    localIntent1.setType("text/plain");
    af localaf = UserManager.from(this.mContext).getRegistrationValues();
    printJapaneseRakutenDebugInfo(localaf, d.au.b);
    boolean bool;
    String str;
    label103: Intent localIntent2;
    if ((localaf.p()) || (d.au.b.d()))
    {
      bool = true;
      str = localaf.n();
      Iterator localIterator = localPackageManager.queryIntentActivities(localIntent1, 0).iterator();
      if (!localIterator.hasNext())
        break label296;
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      localIntent2 = new Intent("android.intent.action.SEND");
      localIntent2.setType("text/plain");
      localIntent2.setPackage(localResolveInfo.activityInfo.packageName);
      localIntent2.setClassName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name);
      localIntent2.addFlags(524288);
      localIntent2.putExtra("android.intent.extra.SUBJECT", this.mContext.getString(R.string.invite_mail_subject));
      if (localArraySet.contains(localResolveInfo.activityInfo.packageName))
        break label258;
      localIntent2.putExtra("android.intent.extra.TEXT", getInviteTextForVariant(this.mContext, str, false));
    }
    while (true)
    {
      localArrayList.add(localIntent2);
      break label103;
      bool = false;
      break;
      label258: if (da.a(paramString))
        localIntent2.putExtra("address", paramString);
      localIntent2.putExtra("android.intent.extra.TEXT", getInviteTextForVariant(this.mContext, str, bool));
    }
    label296: return localArrayList;
  }

  public static Intent createShareSmsIntent(Context paramContext, List<String> paramList, String paramString)
  {
    String str = UserManager.from(paramContext).getRegistrationValues().n();
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", TextUtils.join(",", paramList), null));
    if (da.a(paramString))
      paramString = getInviteTextForVariant(paramContext, str, false);
    return localIntent.putExtra("sms_body", paramString);
  }

  public static int getInviteSource(ArraySet<String> paramArraySet, String paramString)
  {
    Integer localInteger;
    if (paramString != null)
    {
      localInteger = (Integer)INVITE_LINK_SOURCES.get(paramString);
      if (localInteger == null)
      {
        if (!paramArraySet.contains(paramString))
          break label36;
        localInteger = INVITE_LINK_SOURCE_SMS;
      }
    }
    while (true)
    {
      return localInteger.intValue();
      label36: localInteger = INVITE_LINK_SOURCE_OTHER;
      continue;
      localInteger = INVITE_LINK_SOURCE_UNKNOWN;
    }
  }

  public static String getInviteText(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return paramContext.getString(paramInt2, new Object[] { getInviteUrl(paramString, paramInt1, paramBoolean) });
  }

  private static String getInviteTextForVariant(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
      str = getJapaneseSpecificInviteUrl(paramString);
    while (true)
    {
      return paramContext.getString(getInviteTextResId(), new Object[] { str });
      if (bp.a(paramContext))
        str = "https://vb.me/letsUseViber";
      else
        str = "https://vb.me/switchToViber";
    }
  }

  private static int getInviteTextResId()
  {
    return R.string.sms_invite_text;
  }

  public static String getInviteUrl(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      return getJapaneseSpecificInviteUrl(paramString);
    return getRegularInviteURL(paramString, paramInt);
  }

  public static String getJapaneseSpecificInviteUrl(String paramString)
  {
    return ap.c().l + paramString;
  }

  public static String getRegularInviteURL(String paramString, int paramInt)
  {
    if (paramInt != INVITE_LINK_IGNORE_SOURCE.intValue());
    for (int i = 1; i != 0; i = 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder(96).append("https://www.viber.com/invite/");
      if (da.a(paramString))
        paramString = "to";
      return paramString + '/' + paramInt;
    }
    StringBuilder localStringBuilder1 = new StringBuilder(96).append("https://www.viber.com/invite/");
    if (da.a(paramString))
      paramString = "to";
    return paramString;
  }

  public static ArraySet<String> getSmsHandlers(PackageManager paramPackageManager)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    if (a.d())
      localIntent.setData(Uri.parse("sms:"));
    ArraySet localArraySet;
    while (true)
    {
      List localList = paramPackageManager.queryIntentActivities(localIntent, 0);
      localArraySet = new ArraySet(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        localArraySet.add(((ResolveInfo)localIterator.next()).activityInfo.packageName);
      localIntent.setType("vnd.android-dir/mms-sms");
    }
    return localArraySet;
  }

  private void printJapaneseRakutenDebugInfo(af paramaf, b paramb)
  {
  }

  public Intent createShareInviteIntent(String paramString, int paramInt, boolean paramBoolean)
  {
    List localList = createChooserIntents(paramString);
    if (!localList.isEmpty())
    {
      Intent localIntent1 = (Intent)localList.remove(0);
      CharSequence localCharSequence = this.mContext.getText(paramInt);
      Bundle localBundle = new Bundle(1);
      localBundle.putBoolean("invitation_track_by_external_trackers", paramBoolean);
      Intent localIntent2 = dw.a(this.mContext, localIntent1, localCharSequence, "share_type_invite_contact", localBundle);
      localIntent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localList.toArray(new Parcelable[localList.size()]));
      return localIntent2;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.InvitationCreator
 * JD-Core Version:    0.6.2
 */