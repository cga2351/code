package com.viber.voip.api.a.a.a;

import com.google.d.a.a;
import com.google.d.a.c;
import java.util.Arrays;

public class g<T extends b>
{

  @a
  @c(a="type")
  private String a;

  @a
  @c(a="subject")
  private String b;

  @a
  @c(a="status")
  private String c;

  @a
  @c(a="labels")
  private String[] d;

  @a
  @c(a="message")
  private f e;

  @a
  @c(a="_links")
  private e f;

  @a
  @c(a="custom_fields")
  private T g;

  public void a(T paramT)
  {
    this.g = paramT;
  }

  public void a(e parame)
  {
    this.f = parame;
  }

  public void a(f paramf)
  {
    this.e = paramf;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(String[] paramArrayOfString)
  {
    this.d = paramArrayOfString;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public void c(String paramString)
  {
    this.c = paramString;
  }

  public String toString()
  {
    return "ReportRequest{mType='" + this.a + '\'' + ", mSubject='" + this.b + '\'' + ", mStatus='" + this.c + '\'' + ", mLabels=" + Arrays.toString(this.d) + ", mMessage=" + this.e + ", mLinks=" + this.f + ", mCustomFields=" + this.g + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a.a.a.g
 * JD-Core Version:    0.6.2
 */