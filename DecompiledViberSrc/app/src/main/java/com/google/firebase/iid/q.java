package com.google.firebase.iid;

import android.os.Bundle;

final class q extends o<Bundle>
{
  q(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 1, paramBundle);
  }

  final void a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle.getBundle("data");
    if (localBundle == null)
      localBundle = Bundle.EMPTY;
    a(localBundle);
  }

  final boolean a()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.q
 * JD-Core Version:    0.6.2
 */