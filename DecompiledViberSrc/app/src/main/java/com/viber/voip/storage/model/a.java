package com.viber.voip.storage.model;

import android.content.Intent;
import android.os.Bundle;

public class a
{
  public int a(Intent paramIntent, String paramString)
  {
    int i = 0;
    if (paramIntent != null)
      i = paramIntent.getIntExtra(paramString, 0);
    return i;
  }

  public int a(Bundle paramBundle, String paramString)
  {
    int i = 0;
    if (paramBundle != null)
      i = paramBundle.getInt(paramString, 0);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.model.a
 * JD-Core Version:    0.6.2
 */