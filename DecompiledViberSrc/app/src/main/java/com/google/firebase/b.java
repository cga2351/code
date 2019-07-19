package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class b
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;

  private b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!Strings.isEmptyOrWhitespace(paramString1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "ApplicationId must be set.");
      this.b = paramString1;
      this.a = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
      this.f = paramString6;
      this.g = paramString7;
      return;
    }
  }

  public static b a(Context paramContext)
  {
    StringResourceValueReader localStringResourceValueReader = new StringResourceValueReader(paramContext);
    String str = localStringResourceValueReader.getString("google_app_id");
    if (TextUtils.isEmpty(str))
      return null;
    return new b(str, localStringResourceValueReader.getString("google_api_key"), localStringResourceValueReader.getString("firebase_database_url"), localStringResourceValueReader.getString("ga_trackingId"), localStringResourceValueReader.getString("gcm_defaultSenderId"), localStringResourceValueReader.getString("google_storage_bucket"), localStringResourceValueReader.getString("project_id"));
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b));
    b localb;
    do
    {
      return false;
      localb = (b)paramObject;
    }
    while ((!Objects.equal(this.b, localb.b)) || (!Objects.equal(this.a, localb.a)) || (!Objects.equal(this.c, localb.c)) || (!Objects.equal(this.d, localb.d)) || (!Objects.equal(this.e, localb.e)) || (!Objects.equal(this.f, localb.f)) || (!Objects.equal(this.g, localb.g)));
    return true;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.a;
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = this.d;
    arrayOfObject[4] = this.e;
    arrayOfObject[5] = this.f;
    arrayOfObject[6] = this.g;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("applicationId", this.b).add("apiKey", this.a).add("databaseUrl", this.c).add("gcmSenderId", this.e).add("storageBucket", this.f).add("projectId", this.g).toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.b
 * JD-Core Version:    0.6.2
 */