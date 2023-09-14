import java.util.HashMap;
import java.util.Map;

class Character {
    String nameOfCharacter;
    Map<Integer, Ability> abilities = new HashMap<>();

    // Метод для проверки перезарядки умения
    boolean isAbilityReady(int abilityNumber) {
        Ability ability = abilities.get(abilityNumber);
        if (ability != null) {
            return ability.isReady();
        }
        return false;
    }

    // Метод для использования умения
    void useAbility(int abilityNumber) {
        Ability ability = abilities.get(abilityNumber);
        if (ability != null) {
            ability.use();
        }
    }

}