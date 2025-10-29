import AssemblyGlasses.*;

public class AssemblyGlassesTest {
  public static void main(String[] args) {
    GlassesFrameStep buildFrameStep = new GlassesFrameStep();
    GlassesLensStep buildLensStep = new GlassesLensStep();
    GlassesTemplesStep buildTemplesStep = new GlassesTemplesStep();
    
    AssemblyGlasses assembler = new AssemblyGlasses(buildFrameStep, buildLensStep, buildTemplesStep);

    Glasses glasses = new Glasses();
    assembler.assemblyProduct(glasses);
  }
}