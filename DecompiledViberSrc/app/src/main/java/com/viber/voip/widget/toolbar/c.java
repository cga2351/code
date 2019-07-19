package com.viber.voip.widget.toolbar;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.view.View;

public class c
  implements e
{
  private a a;

  public c(AppCompatActivity paramAppCompatActivity)
  {
    this.a = paramAppCompatActivity.getSupportActionBar();
    this.a.e(true);
    this.a.b(true);
  }

  public void a(int paramInt)
  {
  }

  public void a(String paramString)
  {
    this.a.a(paramString);
  }

  public void a(boolean paramBoolean)
  {
  }

  public View b()
  {
    return null;
  }

  public void b(int paramInt)
  {
  }

  public void b(String paramString)
  {
    this.a.b(paramString);
  }

  public void c()
  {
  }

  public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.c
 * JD-Core Version:    0.6.2
 */