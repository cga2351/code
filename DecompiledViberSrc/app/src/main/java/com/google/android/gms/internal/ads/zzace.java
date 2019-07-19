package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

@zzare
public final class zzace
{
  private final Context zzlj;

  public zzace(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "Context can not be null");
    this.zzlj = paramContext;
  }

  private final boolean zza(Intent paramIntent)
  {
    Preconditions.checkNotNull(paramIntent, "Intent can not be null");
    boolean bool1 = this.zzlj.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
    boolean bool2 = false;
    if (!bool1)
      bool2 = true;
    return bool2;
  }

  public final boolean zzqi()
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setData(Uri.parse("tel:"));
    return zza(localIntent);
  }

  public final boolean zzqj()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("sms:"));
    return zza(localIntent);
  }

  public final boolean zzqk()
  {
    return (((Boolean)zzazm.zza(this.zzlj, new zzacf())).booleanValue()) && (Wrappers.packageManager(this.zzlj).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }

  @TargetApi(14)
  public final boolean zzql()
  {
    return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzace
 * JD-Core Version:    0.6.2
 */