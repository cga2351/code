package com.viber.voip.model.entity;

import android.telephony.PhoneNumberUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.f.b.a.a.a;
import com.viber.voip.model.f;
import com.viber.voip.util.dr;

public class k extends t
  implements f
{
  private static final Logger k = ViberEnv.getLogger();

  public k()
  {
  }

  public k(a.a.a parama)
  {
    this.a = PhoneNumberUtils.stripSeparators(parama.a);
    this.b = parama.b;
    this.c = parama.a;
    this.g = 0;
  }

  public k(o paramo)
  {
    super(paramo);
    this.a = PhoneNumberUtils.stripSeparators(paramo.b());
    this.b = dr.a(ViberApplication.getInstance(), this.a, this.a);
    this.c = paramo.b();
    this.d = paramo.c();
    this.e = paramo.d();
    this.g = 0;
  }

  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString3;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString4;
    this.e = paramString5;
    this.g = 0;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String toString()
  {
    return "NumberDataEntity [id=" + this.id + ", number=" + this.a + ", canonized=" + this.b + ", original=" + this.c + ", type=" + this.d + ", label=" + this.e + ", mimeType=" + this.g + ", contactId=" + this.h + ", rawId=" + this.i + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.k
 * JD-Core Version:    0.6.2
 */