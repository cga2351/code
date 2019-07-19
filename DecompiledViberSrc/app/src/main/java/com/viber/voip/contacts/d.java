package com.viber.voip.contacts;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.text.TextUtils;
import com.viber.provider.d.a;
import com.viber.voip.contacts.c.d.g;
import dagger.a;

public class d extends b
{
  private String p;

  public d(Context paramContext, LoaderManager paramLoaderManager, a<g> parama, Bundle paramBundle, String paramString, d.a parama1)
  {
    super(7, paramContext, paramLoaderManager, parama, parama1, b.b.d);
    this.n = new com.viber.voip.contacts.d.b();
    if ((paramBundle != null) && (paramBundle.containsKey("one_on_one_contacts_ids")))
      f(paramBundle.getString("one_on_one_contacts_ids"));
    if (!TextUtils.isEmpty(paramString))
      a(paramString, null, false);
  }

  public void a(Bundle paramBundle)
  {
    if (this.p != null)
      paramBundle.putString("one_on_one_contacts_ids", this.p);
  }

  protected void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1))
      return;
    super.a(paramString1, paramString2, false, paramLong);
    StringBuilder localStringBuilder = new StringBuilder().append(n()).append(" AND ");
    Object[] arrayOfObject = new Object[1];
    if (TextUtils.isEmpty(this.p));
    for (String str = "-1"; ; str = this.p)
    {
      arrayOfObject[0] = str;
      a(String.format("phonebookcontact._id NOT IN (%s) ", arrayOfObject));
      if (!paramBoolean)
        break;
      this.l.removeCallbacks(this.o);
      this.l.postDelayed(this.o, 200L);
      return;
    }
  }

  public void f(String paramString)
  {
    this.p = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.d
 * JD-Core Version:    0.6.2
 */