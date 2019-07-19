package org.webrtc;

public class GlRectDrawer extends GlGenericDrawer
{
  private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

  public GlRectDrawer()
  {
    super("void main() {\n  gl_FragColor = sample(tc);\n}\n", new ShaderCallbacks(null));
  }

  private static class ShaderCallbacks
    implements GlGenericDrawer.ShaderCallbacks
  {
    public void onNewShader(GlShader paramGlShader)
    {
    }

    public void onPrepareShader(GlShader paramGlShader, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.GlRectDrawer
 * JD-Core Version:    0.6.2
 */