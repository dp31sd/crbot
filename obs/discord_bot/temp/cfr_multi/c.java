/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class c {
    private static String a = c.\u200c\u200d\u200b_0x496c("0veeq1F+CzM62fueoU5oFSLTyb6Lag==");

    c() {
    }

    public static String getData() {
        if (!true) {
        }
        return a;
    }

    private static /* synthetic */ String \u200c\u200d\u200b_0x496c(String string) {
        if (((int)System.nanoTime() << 1 | 1) == 0) {
            throw new IllegalStateException("Security Integrity Violation");
        }
        try {
        }
        catch (Throwable throwable) {}
        byte[] byArray = Base64.getDecoder().decode(string);
        for (int i = 0; i < byArray.length; ++i) {
            int n = (0x3C1F ^ 0x1A) - 6830 ^ 0x2188;
            int n2 = (0x8B5D ^ 0xD) - 22474 ^ 0x3399;
            int n3 = (0x873A ^ 0x73) - 24838 ^ 0x2644;
            int n4 = (0xCED5 ^ 0xF7) - 22614 ^ 0x7533;
            int n5 = ((n << 1) - n ^ i * ((n2 << 1) - n2) + ((n3 << 1) - n3)) & (n4 << 1) - n4;
            int n6 = (0x54E7 ^ 0xF6) - 3541 ^ 0x4672;
            byArray[i] = (byte)(byArray[i] ^ (n6 << 1) - n6 + i ^ n5);
        }
        String string2 = new String(byArray, StandardCharsets.UTF_8);
        if (!true) {
        }
        return string2;
    }
}

