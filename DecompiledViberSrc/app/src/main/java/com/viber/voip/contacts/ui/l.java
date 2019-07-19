package com.viber.voip.contacts.ui;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.contacts.model.a;
import com.viber.voip.contacts.model.a.a;

public class l
{
  public static a a(Context paramContext)
  {
    a locala = new a();
    locala.a = a.a.b;
    locala.b = paramContext.getString(R.string.menu_free_video_call);
    locala.c = R.drawable.contact_details_video_call_badge;
    return locala;
  }

  public static a a(String paramString)
  {
    a locala = new a();
    locala.a = a.a.a;
    locala.c = R.drawable.contact_details_viber_out_call_badge;
    locala.b = paramString;
    return locala;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.l
 * JD-Core Version:    0.6.2
 */