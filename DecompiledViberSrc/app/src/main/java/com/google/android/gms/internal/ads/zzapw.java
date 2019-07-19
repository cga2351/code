package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzk;

final class zzapw
  implements DialogInterface.OnClickListener
{
  zzapw(zzapv paramzzapv, String paramString1, String paramString2)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadManager localDownloadManager = (DownloadManager)zzapv.zza(this.zzdir).getSystemService("download");
    try
    {
      String str1 = this.zzdip;
      String str2 = this.zzdiq;
      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(str1));
      localRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
      zzk.zzli();
      localRequest.allowScanningByMediaScanner();
      localRequest.setNotificationVisibility(1);
      localDownloadManager.enqueue(localRequest);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzdir.zzdh("Could not store picture.");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapw
 * JD-Core Version:    0.6.2
 */