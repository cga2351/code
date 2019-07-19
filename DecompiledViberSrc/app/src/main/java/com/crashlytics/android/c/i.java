package com.crashlytics.android.c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import c.a.a.a.a.g.o;
import java.util.concurrent.CountDownLatch;

class i
{
  private final b a;
  private final AlertDialog.Builder b;

  private i(AlertDialog.Builder paramBuilder, b paramb)
  {
    this.a = paramb;
    this.b = paramBuilder;
  }

  private static int a(float paramFloat, int paramInt)
  {
    return (int)(paramFloat * paramInt);
  }

  private static ScrollView a(Activity paramActivity, String paramString)
  {
    float f = paramActivity.getResources().getDisplayMetrics().density;
    int i = a(f, 5);
    TextView localTextView = new TextView(paramActivity);
    localTextView.setAutoLinkMask(15);
    localTextView.setText(paramString);
    localTextView.setTextAppearance(paramActivity, 16973892);
    localTextView.setPadding(i, i, i, i);
    localTextView.setFocusable(false);
    ScrollView localScrollView = new ScrollView(paramActivity);
    localScrollView.setPadding(a(f, 14), a(f, 2), a(f, 10), a(f, 12));
    localScrollView.addView(localTextView);
    return localScrollView;
  }

  public static i a(Activity paramActivity, o paramo, a parama)
  {
    final b localb = new b(null);
    y localy = new y(paramActivity, paramo);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    ScrollView localScrollView = a(paramActivity, localy.b());
    DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.a.a(true);
        paramAnonymousDialogInterface.dismiss();
      }
    };
    localBuilder.setView(localScrollView).setTitle(localy.a()).setCancelable(false).setNeutralButton(localy.c(), local1);
    if (paramo.d)
    {
      DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.a.a(false);
          paramAnonymousDialogInterface.dismiss();
        }
      };
      localBuilder.setNegativeButton(localy.e(), local2);
    }
    if (paramo.f)
    {
      DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.a.a(true);
          localb.a(true);
          paramAnonymousDialogInterface.dismiss();
        }
      };
      localBuilder.setPositiveButton(localy.d(), local3);
    }
    return new i(localBuilder, localb);
  }

  public void a()
  {
    this.b.show();
  }

  public void b()
  {
    this.a.b();
  }

  public boolean c()
  {
    return this.a.a();
  }

  static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }

  private static class b
  {
    private boolean a = false;
    private final CountDownLatch b = new CountDownLatch(1);

    void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      this.b.countDown();
    }

    boolean a()
    {
      return this.a;
    }

    void b()
    {
      try
      {
        this.b.await();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.i
 * JD-Core Version:    0.6.2
 */