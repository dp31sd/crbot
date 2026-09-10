/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a {
    private String a = a.\u200c\u200d\u200b_0x1ccf("KAZ6XKKB4Ny6Wno=");

    private int a() {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        try {
        }
        catch (Throwable throwable) {}
        int n = (0x5191 ^ 0x75) - 10509 ^ 0x28DD;
        int n2 = (0x7551 ^ 0xC9) - 23061 ^ 0x1B86;
        int n3 = new b().multiply((n << 1) - n, (n2 << 1) - n2);
        if (!true) {
        }
        return n3;
    }

    public static void main(String[] stringArray) {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        try {
        }
        catch (Throwable throwable) {}
        a a2 = new a();
        System.out.println("Result: " + a2.a + " Value: " + a2.a() + " Data: " + c.getData());
        if (!true) {
        }
    }

    private static /* synthetic */ String \u200c\u200d\u200b_0x1ccf(String string) {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        try {
        }
        catch (Throwable throwable) {}
        byte[] byArray = Base64.getDecoder().decode(string);
        for (int i = 0; i < byArray.length; ++i) {
            int n = (0x7127 ^ 0x40) - 28941 ^ 0x96;
            int n2 = (0x7AB4 ^ 0xD3) - 766 ^ 0x7776;
            int n3 = (0x7642 ^ 0xB8) - 873 ^ 0x7396;
            int n4 = (0x8BD5 ^ 0xB1) - 11213 ^ 0x5F68;
            int n5 = ((n << 1) - n ^ i * ((n2 << 1) - n2) + ((n3 << 1) - n3)) & (n4 << 1) - n4;
            int n6 = (0x8BF4 ^ 0x4D) - 17965 ^ 0x4524;
            byArray[i] = (byte)(byArray[i] ^ (n6 << 1) - n6 + i ^ n5);
        }
        String string2 = new String(byArray, StandardCharsets.UTF_8);
        if (!true) {
        }
        return string2;
    }
}

