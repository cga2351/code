package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

final class zad extends DialogRedirect
{
  zad(Intent paramIntent, Fragment paramFragment, int paramInt)
  {
  }

  public final void redirect()
  {
    if (this.zaog != null)
      this.val$fragment.startActivityForResult(this.zaog, this.val$requestCode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zad
 * JD-Core Version:    0.6.2
 */