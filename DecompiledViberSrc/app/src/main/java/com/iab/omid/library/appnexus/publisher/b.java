package com.iab.omid.library.appnexus.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.iab.omid.library.appnexus.adsession.VerificationScriptResource;
import com.iab.omid.library.appnexus.b.c;
import com.iab.omid.library.appnexus.b.d;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class b extends AdSessionStatePublisher
{
  private WebView a;
  private List<VerificationScriptResource> b;
  private final String c;

  public b(List<VerificationScriptResource> paramList, String paramString)
  {
    this.b = paramList;
    this.c = paramString;
  }

  public void a()
  {
    super.a();
    i();
  }

  public void b()
  {
    super.b();
    new Handler().postDelayed(new Runnable()
    {
      private WebView b = b.a(b.this);

      public void run()
      {
        this.b.destroy();
      }
    }
    , 2000L);
    this.a = null;
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  void i()
  {
    this.a = new WebView(c.a().b());
    this.a.getSettings().setJavaScriptEnabled(true);
    a(this.a);
    d.a().a(this.a, this.c);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      String str = ((VerificationScriptResource)localIterator.next()).getResourceUrl().toExternalForm();
      d.a().b(this.a, str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.publisher.b
 * JD-Core Version:    0.6.2
 */