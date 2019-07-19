package com.viber.voip.permissions;

import android.support.v4.app.Fragment;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.ActivationController;

public class b extends c
{
  private final Logger d = ViberEnv.getLogger(getClass());

  public b(Fragment paramFragment, com.viber.common.permission.c paramc, c.a parama)
  {
    super(paramFragment, paramc, parama);
  }

  private void b()
  {
    if (this.b.a(n.o))
    {
      a(ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE);
      return;
    }
    this.b.a(this.a, 98, n.o);
  }

  public void a()
  {
    if (!this.b.a(n.j))
    {
      this.b.a(this.a, 97, n.j);
      return;
    }
    b();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
  }

  public void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      return;
    case 97:
      b();
      return;
    case 98:
    }
    a(false);
  }

  public void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      return;
    case 97:
      b();
      return;
    case 98:
    }
    a(ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.b
 * JD-Core Version:    0.6.2
 */