package com.viber.voip.model.entity;

import android.content.ContentValues;
import android.text.TextUtils;
import com.viber.voip.messages.orm.annotation.ViberEntity;
import com.viber.voip.messages.orm.annotation.ViberEntityField;
import com.viber.voip.messages.orm.annotation.ViberEntityType;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.messages.orm.entity.EntityUpdater;
import com.viber.voip.model.i;
import com.viber.voip.util.a.b.a;
import java.util.Collection;

@ViberEntity(authority="com.viber.voip.provider.vibercontacts", table="phonebookcontact", type=ViberEntityType.Standard)
public class e extends b
  implements i
{
  public static final CreatorHelper E = new com.viber.voip.contacts.b.a.b();

  @ViberEntityField(projection="flags")
  protected int A;

  @ViberEntityField(projection="version")
  protected int B;

  @ViberEntityField(projection="phonetic_name")
  protected String C;

  @ViberEntityField(projection="phone_label")
  protected String D;

  @ViberEntityField(projection="native_id")
  protected long n;

  @ViberEntityField(projection="display_name")
  protected String o;

  @ViberEntityField(projection="low_display_name")
  protected String p;

  @ViberEntityField(projection="numbers_name")
  protected String q;

  @ViberEntityField(projection="starred")
  protected boolean r;

  @ViberEntityField(projection="viber")
  protected boolean s;

  @ViberEntityField(projection="contact_lookup_key")
  protected String t;

  @ViberEntityField(projection="contact_hash")
  protected int u;

  @ViberEntityField(projection="has_number")
  protected boolean v;

  @ViberEntityField(projection="has_name")
  protected boolean w;

  @ViberEntityField(projection="native_photo_id")
  protected long x;

  @ViberEntityField(projection="recently_joined_date")
  protected long y;

  @ViberEntityField(projection="joined_date")
  protected long z;

  public e()
  {
  }

  public e(o paramo)
  {
    this.id = paramo.e();
    this.n = paramo.e();
    this.x = paramo.h();
    h(paramo.f());
    m(paramo.l());
    this.r = paramo.j();
    this.t = paramo.k();
    this.C = paramo.m();
    this.D = paramo.n();
  }

  public e(String paramString)
  {
    this(paramString, "");
  }

  public e(String paramString1, String paramString2)
  {
    h(paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (com.viber.voip.util.a.e.m(paramString1)) && (com.viber.voip.util.a.e.b(paramString1)))
    {
      m(com.viber.voip.util.a.e.l(paramString1).toLowerCase());
      b.a locala = com.viber.voip.util.a.b.a(paramString1, paramString2, this.p);
      this.p = locala.c;
      this.C = locala.b;
      this.D = locala.d;
      if (TextUtils.isEmpty(paramString1))
        break label131;
    }
    label131: for (boolean bool = true; ; bool = false)
    {
      this.w = bool;
      return;
      String str;
      if (TextUtils.isEmpty(paramString2))
        if (paramString1 != null)
          str = paramString1.toLowerCase();
      while (true)
      {
        m(str);
        break;
        str = "";
        continue;
        str = paramString2;
      }
    }
  }

  public int A()
  {
    return this.u;
  }

  public boolean B()
  {
    return this.x > 0L;
  }

  public long C()
  {
    return this.z;
  }

  public int D()
  {
    return this.B;
  }

  public void a(long paramLong)
  {
    this.n = paramLong;
  }

  public void b(int paramInt)
  {
    this.u = paramInt;
  }

  public void b(long paramLong)
  {
    this.x = paramLong;
  }

  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void c(int paramInt)
  {
    this.B = paramInt;
  }

  public void c(long paramLong)
  {
    this.y = paramLong;
  }

  public void c(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void d(int paramInt)
  {
    this.A = paramInt;
  }

  public void d(long paramLong)
  {
    this.z = paramLong;
  }

  public void d(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  public long e()
  {
    return this.x;
  }

  public void e(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  public ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues(19);
    if (this.id > 0L)
      localContentValues.put("_id", Long.valueOf(this.id));
    localContentValues.put("native_id", Long.valueOf(this.n));
    localContentValues.put("starred", Boolean.valueOf(this.r));
    localContentValues.put("display_name", this.o);
    localContentValues.put("low_display_name", this.p);
    localContentValues.put("numbers_name", this.q);
    localContentValues.put("joined_date", Long.valueOf(this.z));
    localContentValues.put("has_number", Boolean.valueOf(this.v));
    localContentValues.put("has_name", Boolean.valueOf(this.w));
    localContentValues.put("native_photo_id", Long.valueOf(this.x));
    localContentValues.put("contact_lookup_key", this.t);
    localContentValues.put("viber", Boolean.valueOf(this.s));
    localContentValues.put("contact_hash", Integer.valueOf(this.u));
    localContentValues.put("contact_lookup_key", this.t);
    localContentValues.put("flags", Integer.valueOf(this.A));
    localContentValues.put("version", Integer.valueOf(this.B));
    localContentValues.put("phonetic_name", this.C);
    localContentValues.put("phone_label", this.D);
    return localContentValues;
  }

  public Creator getCreator()
  {
    return E;
  }

  public void h(String paramString)
  {
    i(paramString);
  }

  public void i(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.o = paramString;
  }

  public boolean i()
  {
    return this.w;
  }

  public long j()
  {
    return this.n;
  }

  public void j(String paramString)
  {
    this.C = paramString;
  }

  public String k()
  {
    return this.o;
  }

  public void k(String paramString)
  {
    this.D = paramString;
  }

  public String l()
  {
    return this.C;
  }

  public void l(String paramString)
  {
    this.q = paramString;
  }

  public void m(String paramString)
  {
    this.p = paramString;
  }

  public void n(String paramString)
  {
    this.t = paramString;
  }

  public boolean p()
  {
    return this.s;
  }

  public String q()
  {
    return this.t;
  }

  public boolean r()
  {
    return this.r;
  }

  public String toString()
  {
    return "Contact [id(contact_id)=" + this.id + ", nativeId=" + this.n + ", hash=" + this.u + ", displayName=" + this.o + "(" + this.p + "), phoneticName=" + this.C + ", phoneLabel=" + this.D + ", numbersName=" + this.q + ", starred=" + this.r + ", viber=" + this.s + ", lookupKey=" + this.t + ", hasNumbers=" + this.v + ", hasName=" + this.w + ", nativePhotoId=" + this.x + ", recentlyJoined=" + this.y + ", joinedDate=" + this.z + ", flags=" + this.A + ", version=" + this.B + "]";
  }

  public String v()
  {
    return this.p;
  }

  public String x()
  {
    return this.D;
  }

  public static class a extends EntityUpdater<e>
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    public a(e parame, String[] paramArrayOfString)
    {
      super(null, paramArrayOfString);
    }

    public boolean a(e parame)
    {
      boolean bool1 = notEquals(this.a, parame.o, ((e)this.baseEntity).o);
      boolean bool2 = false;
      if (bool1)
      {
        parame.m(((e)this.baseEntity).p);
        parame.h(((e)this.baseEntity).o);
        bool2 = true;
      }
      if (notEquals(this.h, parame.t, ((e)this.baseEntity).t))
      {
        parame.t = ((e)this.baseEntity).t;
        bool2 = true;
      }
      if (notEquals(this.b, parame.r, ((e)this.baseEntity).r))
      {
        parame.r = ((e)this.baseEntity).r;
        bool2 = true;
      }
      if (notEquals(this.c, parame.s, ((e)this.baseEntity).s))
      {
        parame.s = ((e)this.baseEntity).s;
        bool2 = true;
      }
      if (notEquals(this.d, parame.u, ((e)this.baseEntity).u))
      {
        parame.u = ((e)this.baseEntity).u;
        bool2 = true;
      }
      if (notEquals(this.e, parame.v, ((e)this.baseEntity).v))
        parame.v = ((e)this.baseEntity).v;
      for (boolean bool3 = true; ; bool3 = bool2)
      {
        if (notEquals(this.i, parame.z, ((e)this.baseEntity).z))
        {
          parame.z = ((e)this.baseEntity).z;
          bool3 = true;
        }
        if (notEquals(this.f, parame.w, ((e)this.baseEntity).w))
        {
          parame.w = ((e)this.baseEntity).w;
          bool3 = true;
        }
        if (notEquals(this.g, parame.x, ((e)this.baseEntity).x))
        {
          parame.x = ((e)this.baseEntity).x;
          bool3 = true;
        }
        if (notEquals(this.j, parame.A, ((e)this.baseEntity).A))
        {
          parame.A = ((e)this.baseEntity).A;
          bool3 = true;
        }
        if (notEquals(this.k, parame.B, ((e)this.baseEntity).B))
        {
          parame.B = ((e)this.baseEntity).B;
          bool3 = true;
        }
        if (notEquals(this.l, parame.C, ((e)this.baseEntity).C))
        {
          parame.C = ((e)this.baseEntity).C;
          bool3 = true;
        }
        if (notEquals(this.m, parame.D, ((e)this.baseEntity).D))
        {
          parame.D = ((e)this.baseEntity).D;
          return true;
        }
        return bool3;
      }
    }

    protected void initUpdateTerms(Collection<String> paramCollection)
    {
      this.a = paramCollection.contains("display_name");
      this.h = paramCollection.contains("contact_lookup_key");
      this.b = paramCollection.contains("starred");
      this.c = paramCollection.contains("viber");
      this.d = paramCollection.contains("contact_hash");
      this.e = paramCollection.contains("has_number");
      this.f = paramCollection.contains("has_name");
      this.g = paramCollection.contains("native_photo_id");
      this.i = paramCollection.contains("joined_date");
      this.j = paramCollection.contains("flags");
      this.k = paramCollection.contains("version");
      this.l = paramCollection.contains("phonetic_name");
      this.m = paramCollection.contains("phone_label");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.e
 * JD-Core Version:    0.6.2
 */