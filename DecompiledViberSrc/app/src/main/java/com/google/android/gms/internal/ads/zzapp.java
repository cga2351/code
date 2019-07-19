package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R.string;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzare
public final class zzapp extends zzaqc
{
  private final Map<String, String> zzcxs;
  private String zzdht;
  private long zzdhu;
  private long zzdhv;
  private String zzdhw;
  private String zzdhx;
  private final Context zzlj;

  public zzapp(zzbha paramzzbha, Map<String, String> paramMap)
  {
    super(paramzzbha, "createCalendarEvent");
    this.zzcxs = paramMap;
    this.zzlj = paramzzbha.zzyd();
    this.zzdht = zzdf("description");
    this.zzdhw = zzdf("summary");
    this.zzdhu = zzdg("start_ticks");
    this.zzdhv = zzdg("end_ticks");
    this.zzdhx = zzdf("location");
  }

  private final String zzdf(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)this.zzcxs.get(paramString)))
      return "";
    return (String)this.zzcxs.get(paramString);
  }

  private final long zzdg(String paramString)
  {
    String str = (String)this.zzcxs.get(paramString);
    if (str == null)
      return -1L;
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1L;
  }

  @TargetApi(14)
  final Intent createIntent()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", this.zzdht);
    localIntent.putExtra("eventLocation", this.zzdhx);
    localIntent.putExtra("description", this.zzdhw);
    if (this.zzdhu > -1L)
      localIntent.putExtra("beginTime", this.zzdhu);
    if (this.zzdhv > -1L)
      localIntent.putExtra("endTime", this.zzdhv);
    localIntent.setFlags(268435456);
    return localIntent;
  }

  public final void execute()
  {
    if (this.zzlj == null)
    {
      zzdh("Activity context is not available.");
      return;
    }
    zzk.zzlg();
    if (!zzaxj.zzao(this.zzlj).zzql())
    {
      zzdh("This feature is not available on the device.");
      return;
    }
    zzk.zzlg();
    AlertDialog.Builder localBuilder = zzaxj.zzan(this.zzlj);
    Resources localResources = zzk.zzlk().getResources();
    String str1;
    String str2;
    label95: String str3;
    if (localResources != null)
    {
      str1 = localResources.getString(R.string.s5);
      localBuilder.setTitle(str1);
      if (localResources == null)
        break label177;
      str2 = localResources.getString(R.string.s6);
      localBuilder.setMessage(str2);
      if (localResources == null)
        break label184;
      str3 = localResources.getString(R.string.s3);
      label117: localBuilder.setPositiveButton(str3, new zzapq(this));
      if (localResources == null)
        break label191;
    }
    label177: label184: label191: for (String str4 = localResources.getString(R.string.s4); ; str4 = "Decline")
    {
      localBuilder.setNegativeButton(str4, new zzapr(this));
      localBuilder.create().show();
      return;
      str1 = "Create calendar event";
      break;
      str2 = "Allow Ad to create a calendar event?";
      break label95;
      str3 = "Accept";
      break label117;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapp
 * JD-Core Version:    0.6.2
 */