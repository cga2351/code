package com.viber.voip.permissions;

import android.content.Context;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import com.viber.voip.util.n;

public class d extends b
  implements d.b
{
  private final c a;
  private boolean b;

  public d(Context paramContext)
  {
    this.a = c.a(paramContext);
    com.viber.voip.util.d.c(this);
  }

  private void a()
  {
    if (this.b)
      return;
    this.a.b(this);
    com.viber.voip.util.d.d(this);
    this.b = true;
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    i.a(this);
  }

  public void onForeground()
  {
    if (this.a.a(new String[] { "android.permission.CAMERA" }))
      a();
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  public void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject)
  {
    if (!n.a(paramArrayOfString2, "android.permission.CAMERA"))
      return;
    a();
  }

  public void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    if (!n.a(paramArrayOfString, "android.permission.CAMERA"))
      return;
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.d
 * JD-Core Version:    0.6.2
 */