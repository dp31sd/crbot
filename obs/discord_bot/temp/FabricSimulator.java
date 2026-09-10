import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.File;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FabricSimulator {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Simulating Fabric Loader ===");

        File jarFile = new File("discord_bot/temp/fabric_mod_obf.jar");
        URLClassLoader loader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()}, FabricSimulator.class.getClassLoader());

        JarFile jar = new JarFile(jarFile);
        JarEntry entry = jar.getJarEntry("fabric.mod.json");
        String json = new String(jar.getInputStream(entry).readAllBytes(), "UTF-8");
        jar.close();

        System.out.println("[fabric.mod.json icerigi]\n" + json);

        Matcher m = Pattern.compile("\"main\"\\s*:\\s*\\[\\s*\"([^\"]+)\"").matcher(json);
        if (!m.find()) throw new RuntimeException("No main entrypoint found!");
        String mainClass = m.group(1).trim();
        System.out.println("[Fabric Loader] Entrypoint: " + mainClass);

        Class<?> modClass = loader.loadClass(mainClass);
        System.out.println("[Fabric Loader] Class yuklendi: " + modClass.getName());

        Object instance = modClass.getDeclaredConstructor().newInstance();
        Method onInit = modClass.getMethod("onInitialize");
        System.out.println("[Fabric Loader] onInitialize() cagiriliyor...");
        onInit.invoke(instance);

        System.out.println("[BASARILI] Fabric mod yuklendi ve calistu!");
        loader.close();
    }
}
