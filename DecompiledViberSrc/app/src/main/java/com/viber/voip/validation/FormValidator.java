package com.viber.voip.validation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.HashMap;

public class FormValidator
  implements b
{
  private static final Logger a = ViberEnv.getLogger();
  private d b;
  private c[] c;
  private b[] d;
  private HashMap<c, Integer> e;
  private boolean f;
  private int g;

  private FormValidator(ArrayList<c> paramArrayList, ArrayList<b> paramArrayList1, d paramd, b paramb, e.a parama)
  {
    this.b = paramd;
    this.c = ((c[])paramArrayList.toArray(new c[paramArrayList.size()]));
    this.d = new b[this.c.length];
    this.e = new HashMap(this.c.length);
    for (int i = 0; i < this.d.length; i++)
    {
      this.d[i] = ((b)paramArrayList1.get(i));
      if (this.d[i] == b.b)
        this.g = (1 + this.g);
      this.c[i].a(this);
      this.e.put(this.c[i], Integer.valueOf(i));
      if (paramb != null)
        this.c[i].a(paramb);
      if (parama != null)
        this.c[i].a(parama);
    }
  }

  private int b(c paramc)
  {
    Integer localInteger = (Integer)this.e.get(paramc);
    if (localInteger == null)
      return -1;
    return localInteger.intValue();
  }

  public InstanceState a()
  {
    return new InstanceState(this.d);
  }

  public void a(InstanceState paramInstanceState)
  {
    int i = 0;
    this.d = paramInstanceState.fieldValidatorStates;
    this.g = 0;
    while (i < this.d.length)
    {
      if (this.d[i] == b.b)
        this.g = (1 + this.g);
      i++;
    }
  }

  public void a(c paramc)
  {
    int i = 1;
    int j = b(paramc);
    boolean bool1;
    int k;
    if (j >= 0)
    {
      bool1 = e();
      if (this.d[j] != b.b)
        break label112;
      k = i;
      if (!paramc.f())
        break label118;
      this.d[j] = b.d;
      if (this.d[j] != b.b)
        break label153;
      label61: if ((k != 0) || (i == 0))
        break label158;
    }
    label153: label158: for (this.g = (1 + this.g); ; this.g = (-1 + this.g))
      label112: label118: 
      do
      {
        boolean bool2 = e();
        if ((bool1 != bool2) && (this.b != null))
          this.b.a(bool2);
        return;
        k = 0;
        break;
        b[] arrayOfb = this.d;
        if (paramc.a());
        for (b localb = b.b; ; localb = b.c)
        {
          arrayOfb[j] = localb;
          break;
        }
        i = 0;
        break label61;
      }
      while ((k == 0) || (i != 0));
  }

  public void b()
  {
    for (int i = 0; i < this.c.length; i++)
      this.c[i].b();
  }

  public FormValidator c()
  {
    if (!this.f)
    {
      this.f = true;
      int i = 0;
      if (i < this.d.length)
      {
        this.c[i].a(true);
        switch (1.a[this.d[i].ordinal()])
        {
        default:
        case 1:
        case 2:
        }
        while (true)
        {
          i++;
          break;
          this.c[i].d();
        }
      }
      if (this.b != null)
        this.b.a(e());
    }
    return this;
  }

  public boolean d()
  {
    return this.f;
  }

  public boolean e()
  {
    return this.g == this.c.length;
  }

  public static class InstanceState
    implements Parcelable
  {
    public static final Parcelable.Creator<InstanceState> CREATOR = new Parcelable.Creator()
    {
      public FormValidator.InstanceState a(Parcel paramAnonymousParcel)
      {
        return new FormValidator.InstanceState(paramAnonymousParcel);
      }

      public FormValidator.InstanceState[] a(int paramAnonymousInt)
      {
        return new FormValidator.InstanceState[paramAnonymousInt];
      }
    };
    public final FormValidator.b[] fieldValidatorStates;

    protected InstanceState(Parcel paramParcel)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      this.fieldValidatorStates = new FormValidator.b[arrayOfByte.length];
      FormValidator.b[] arrayOfb = FormValidator.b.values();
      for (int i = 0; i < this.fieldValidatorStates.length; i++)
      {
        FormValidator.b localb = arrayOfb[arrayOfByte[i]];
        this.fieldValidatorStates[i] = localb;
      }
    }

    public InstanceState(FormValidator.b[] paramArrayOfb)
    {
      this.fieldValidatorStates = paramArrayOfb;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte[] arrayOfByte = new byte[this.fieldValidatorStates.length];
      for (int i = 0; i < arrayOfByte.length; i++)
        arrayOfByte[i] = ((byte)this.fieldValidatorStates[i].ordinal());
      paramParcel.writeByteArray(arrayOfByte);
    }
  }

  public static class a
  {
    ArrayList<c> a = new ArrayList();
    ArrayList<FormValidator.b> b = new ArrayList();
    private d c;
    private b d;
    private e.a e;

    public a a(c paramc, FormValidator.b paramb)
    {
      this.a.add(paramc);
      this.b.add(paramb);
      return this;
    }

    public a a(d paramd)
    {
      this.c = paramd;
      return this;
    }

    public FormValidator a()
    {
      return new FormValidator(this.a, this.b, this.c, this.d, this.e, null);
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.FormValidator
 * JD-Core Version:    0.6.2
 */