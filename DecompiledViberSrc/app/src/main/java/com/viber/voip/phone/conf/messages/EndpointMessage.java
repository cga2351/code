package com.viber.voip.phone.conf.messages;

import com.google.d.a.c;
import com.google.d.l;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class EndpointMessage
{
  public static final String MESSAGE_TYPE = "EndpointMessage";

  @c(a="colibriClass")
  @Nonnull
  private final String collibriClass = "EndpointMessage";

  @c(a="from")
  @Nullable
  public final String fromEndpoint;

  @c(a="msgPayload")
  @Nonnull
  public final l payload;

  @c(a="to")
  @Nonnull
  public final String toEndpoint;

  public EndpointMessage(@Nullable String paramString1, @Nonnull String paramString2, @Nonnull l paraml)
  {
    this.fromEndpoint = paramString1;
    this.toEndpoint = paramString2;
    this.payload = paraml;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.messages.EndpointMessage
 * JD-Core Version:    0.6.2
 */