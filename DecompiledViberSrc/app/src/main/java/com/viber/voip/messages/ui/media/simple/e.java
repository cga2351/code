package com.viber.voip.messages.ui.media.simple;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import com.viber.voip.ui.aq;
import com.viber.voip.util.cl;

public class e extends aq
{
  protected a a;
  protected a b = a.h;

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof a))
      throw new IllegalStateException("Activity must implement fragment's callbacks.");
    this.b = ((a)paramActivity);
    this.a = ((AppCompatActivity)getActivity()).getSupportActionBar();
  }

  public void onDetach()
  {
    super.onDetach();
    this.b = a.h;
  }

  public static abstract interface a
  {
    public static final a h = (a)cl.b(a.class);

    public abstract void a(String paramString);

    public abstract void a(String paramString, int paramInt1, int paramInt2);

    public abstract void a(String paramString, Uri paramUri);

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.e
 * JD-Core Version:    0.6.2
 */