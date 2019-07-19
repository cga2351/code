package com.viber.voip.user.editinfo;

import android.content.Context;
import com.viber.voip.ViberApplication;

public class MountedDriveCheckerImpl
  implements MountedDriveChecker
{
  private final Context mContext;

  public MountedDriveCheckerImpl(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public boolean checkIsMounted(boolean paramBoolean)
  {
    return ViberApplication.externalStorageMounted(this.mContext, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.MountedDriveCheckerImpl
 * JD-Core Version:    0.6.2
 */