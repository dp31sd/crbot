package temp;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import java.util.*;

public class TestRemapper {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("chat/ChatManager", "a/a");
        map.put("chat/ChatManager.sendMsg(Ljava/lang/String;)V", "a");
        map.put("gui/ChatScreen", "b/a");

        SimpleRemapper remapper = new SimpleRemapper(map);
        System.out.println("Class 1: " + remapper.map("chat/ChatManager"));
        System.out.println("Class 2: " + remapper.map("gui/ChatScreen"));
        System.out.println("Type desc: " + remapper.mapDesc("Lchat/ChatManager;"));
        System.out.println("Method: " + remapper.mapMethodName("chat/ChatManager", "sendMsg", "(Ljava/lang/String;)V"));
        System.out.println("Method desc: " + remapper.mapMethodDesc("(Lchat/ChatManager;)Lgui/ChatScreen;"));
    }
}
