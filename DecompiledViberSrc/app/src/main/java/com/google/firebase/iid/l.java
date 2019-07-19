package com.google.firebase.iid;

import android.os.Bundle;

final class l extends o<Void>
{
  l(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 2, paramBundle);
  }

  final void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ack", false))
    {
      a(null);
      return;
    }
    a(new n(4, "Invalid response to one way request"));
  }

  final boolean a()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.l
 * JD-Core Version:    0.6.2
 */