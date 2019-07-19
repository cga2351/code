package com.yandex.metrica.impl;

import android.util.Pair;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.Revenue.Receipt;
import com.yandex.metrica.impl.ob.e;
import com.yandex.metrica.impl.ob.kn;
import com.yandex.metrica.impl.ob.kn.a;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.oq;
import com.yandex.metrica.impl.ob.pj;
import com.yandex.metrica.impl.ob.pm;
import com.yandex.metrica.impl.ob.pn;
import com.yandex.metrica.impl.ob.po;
import com.yandex.metrica.impl.ob.pp;
import java.util.Currency;

class bl
{
  private final Revenue a;
  private final pp<String> b;
  private final pp<String> c;
  private final pp<String> d;
  private final of e;

  bl(Revenue paramRevenue, of paramof)
  {
    this.e = paramof;
    this.a = paramRevenue;
    this.b = new pm(30720, "revenue payload", this.e);
    this.c = new po(new pm(184320, "receipt data", this.e), "<truncated data was not sent, see METRIKALIB-4568>");
    this.d = new po(new pn(1000, "receipt signature", this.e), "<truncated data was not sent, see METRIKALIB-4568>");
  }

  Pair<byte[], Integer> a()
  {
    kn localkn = new kn();
    localkn.d = this.a.currency.getCurrencyCode().getBytes();
    localkn.c = this.a.price;
    localkn.e = bu.d(new pn(200, "revenue productID", this.e).a(this.a.productID));
    localkn.b = oq.a(this.a.quantity, 1);
    localkn.f = bu.d((String)this.b.a(this.a.payload));
    int i;
    int j;
    if (this.a.receipt != null)
    {
      i = 1;
      if (i == 0)
        break label268;
      kn.a locala = new kn.a();
      String str1 = (String)this.c.a(this.a.receipt.data);
      if (!pj.a(this.a.receipt.data, str1))
        break label262;
      j = 0 + this.a.receipt.data.length();
      label193: String str2 = (String)this.d.a(this.a.receipt.signature);
      locala.b = bu.d(str1);
      locala.c = bu.d(str2);
      localkn.g = locala;
    }
    while (true)
    {
      return new Pair(e.a(localkn), Integer.valueOf(j));
      i = 0;
      break;
      label262: j = 0;
      break label193;
      label268: j = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bl
 * JD-Core Version:    0.6.2
 */