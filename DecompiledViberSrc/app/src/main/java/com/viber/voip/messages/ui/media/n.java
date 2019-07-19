package com.viber.voip.messages.ui.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.an.a;
import com.viber.voip.an.c;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch.b;
import com.viber.voip.messages.l;

public class n extends k
{
  ImageViewTouch.b a = new ImageViewTouch.b()
  {
    public void a(boolean paramAnonymousBoolean)
    {
      if (n.this.getActivity() != null)
        ((ViewMediaActivity)n.this.getActivity()).c(paramAnonymousBoolean);
    }
  };
  private a b;
  private b c;
  private k.a d;

  // ERROR //
  public void onAttach(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 29	com/viber/voip/messages/ui/media/k:onAttach	(Landroid/app/Activity;)V
    //   5: aload_0
    //   6: aload_1
    //   7: checkcast 31	com/viber/voip/messages/ui/media/n$b
    //   10: putfield 33	com/viber/voip/messages/ui/media/n:c	Lcom/viber/voip/messages/ui/media/n$b;
    //   13: aload_0
    //   14: aload_1
    //   15: checkcast 35	com/viber/voip/messages/ui/media/k$a
    //   18: putfield 37	com/viber/voip/messages/ui/media/n:d	Lcom/viber/voip/messages/ui/media/k$a;
    //   21: return
    //   22: astore_2
    //   23: new 27	java/lang/ClassCastException
    //   26: dup
    //   27: new 39	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   34: aload_1
    //   35: invokevirtual 46	java/lang/Object:toString	()Ljava/lang/String;
    //   38: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 52
    //   43: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 56	java/lang/ClassCastException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: astore_3
    //   54: new 27	java/lang/ClassCastException
    //   57: dup
    //   58: new 39	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   65: aload_1
    //   66: invokevirtual 46	java/lang/Object:toString	()Ljava/lang/String;
    //   69: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 58
    //   74: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 56	java/lang/ClassCastException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	13	22	java/lang/ClassCastException
    //   13	21	53	java/lang/ClassCastException
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.view_image_layout, paramViewGroup, false);
    this.b = new a(localView);
    Bundle localBundle = getArguments();
    int i = localBundle.getInt("fragmentPosition");
    Uri localUri = a((Uri)localBundle.getParcelable("extra_uri"));
    int j = localBundle.getInt("mime_type");
    an.c localc = this.d.a(i, localUri, l.j(j));
    Object localObject;
    int k;
    if ((localc != null) && (!localc.a))
    {
      localObject = localc.e.a;
      k = 1;
      this.b.a.setZoomImageListener(this.c);
      if (localObject == null)
        break label327;
      this.b.b();
      if (k == 0)
      {
        this.b.a.a((Bitmap)localObject, true);
        this.b.a.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (n.this.getActivity() != null)
              ((ViewMediaActivity)n.this.getActivity()).k();
          }
        });
        this.b.b.setVisibility(8);
        this.b.a.setExternalScrollListener(this.a);
        return localView;
      }
    }
    else
    {
      if (localc != null);
      for (Bitmap localBitmap = localc.e.a; ; localBitmap = null)
      {
        localObject = localBitmap;
        k = 0;
        break;
      }
    }
    int m = localc.b;
    int n = localc.c;
    if ((m > 0) && (n > 0))
    {
      this.b.b.getLayoutParams().height = n;
      this.b.b.getLayoutParams().width = m;
    }
    this.b.b.setImageBitmap((Bitmap)localObject);
    this.b.a.setVisibility(8);
    this.b.a.setExternalScrollListener(this.a);
    return localView;
    label327: if (e())
    {
      this.b.a();
      return localView;
    }
    this.b.a(g());
    return localView;
  }

  public void onDetach()
  {
    super.onDetach();
    this.c = null;
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    super.setMenuVisibility(paramBoolean);
    if ((this.b != null) && (!paramBoolean) && (this.b.a.getScale() > 1.0F))
      this.b.a.c(1.0F, 50.0F);
  }

  protected static class a
  {
    final ImageViewTouch a;
    final ImageView b;
    final ImageView c;
    final ProgressBar d;
    final TextView e;

    protected a(View paramView)
    {
      this.a = ((ImageViewTouch)paramView.findViewById(R.id.image));
      this.b = ((ImageView)paramView.findViewById(R.id.image_scrolled));
      this.c = ((ImageView)paramView.findViewById(R.id.loading_icon));
      this.d = ((ProgressBar)paramView.findViewById(R.id.media_loading_progress_bar));
      this.e = ((TextView)paramView.findViewById(R.id.media_loading_text));
    }

    public void a()
    {
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      this.c.setVisibility(0);
    }

    public void a(String paramString)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.c.setVisibility(0);
      this.e.setText(paramString);
    }

    public void b()
    {
      this.a.setVisibility(0);
      this.b.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.c.setVisibility(8);
    }
  }

  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.n
 * JD-Core Version:    0.6.2
 */