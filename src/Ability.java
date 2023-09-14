import java.util.concurrent.TimeUnit;

public class Ability {

    String name;
    long cooldown;
    long lastUsedTime;

    Ability(String name, long cooldown) {
        this.name = name;
        this.cooldown = cooldown;
        this.lastUsedTime = 0;
    }

    boolean isReady() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - lastUsedTime) >= TimeUnit.SECONDS.toMillis(cooldown);
    }

    void use() {
        lastUsedTime = System.currentTimeMillis();
    }
}
