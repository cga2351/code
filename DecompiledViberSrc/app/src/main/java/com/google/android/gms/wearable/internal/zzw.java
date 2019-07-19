package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Set;

public final class zzw
  implements CapabilityInfo
{
  private final String name;
  private final Set<Node> zzbt;

  public zzw(CapabilityInfo paramCapabilityInfo)
  {
    this(paramCapabilityInfo.getName(), paramCapabilityInfo.getNodes());
  }

  private zzw(String paramString, Set<Node> paramSet)
  {
    this.name = paramString;
    this.zzbt = paramSet;
  }

  public final String getName()
  {
    return this.name;
  }

  public final Set<Node> getNodes()
  {
    return this.zzbt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzw
 * JD-Core Version:    0.6.2
 */