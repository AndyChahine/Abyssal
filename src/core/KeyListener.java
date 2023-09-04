package core;
import java.util.Arrays;

import org.lwjgl.glfw.GLFW;

public class KeyListener {

	private static KeyListener instance;
	private boolean[] keyPressed = new boolean[350];
	private boolean[] keyBeginPress = new boolean[350];
	
	private KeyListener() {
		
	}
	
	public static void endFrame() {
		Arrays.fill(get().keyBeginPress, false);
	}
	
	public static KeyListener get() {
		if(KeyListener.instance == null) {
			KeyListener.instance = new KeyListener();
		}
		
		return KeyListener.instance;
	}
	
	public static void keyCallback(long window, int key, int scancode, int action, int mods) {
		if(action == GLFW.GLFW_PRESS) {
			get().keyPressed[key] = true;
			get().keyBeginPress[key] = true;
		}else if(action == GLFW.GLFW_RELEASE) {
			get().keyPressed[key] = false;
			get().keyBeginPress[key] = false;
		}
	}
	
	public static boolean isKeyPressed(int keycode) {
		return get().keyPressed[keycode];
	}
	
	public static boolean keyBeginPress(int keycode) {
		return get().keyBeginPress[keycode];
	}
}
